package com.hengyunsoft.platform.jobs;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.constant.BooleanStatus;
import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.commons.constant.SystemUsers;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiOpenDto;
import com.hengyunsoft.platform.exchange.api.dataapi.open.ShareDataApiOpen;
import com.hengyunsoft.platform.ops.alarmdto.AlarmRuleSettingsDTO;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmInformation;
import com.hengyunsoft.platform.ops.entity.alarm.po.domain.ServiceManageAlarmDO;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmInformationService;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmRuleSettingsService;
import com.hengyunsoft.platform.ops.repository.person.example.DealUserExample;
import com.hengyunsoft.platform.ops.repository.person.service.DealUserService;
import com.hengyunsoft.platform.ops.repository.person.service.PersonService;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceManageService;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendDTO;
import com.hengyunsoft.platform.piping.open.SmsSendApi;
import com.hengyunsoft.platform.security.api.interfaces.InterfacesSettingsBeanCache;
import com.hengyunsoft.platform.security.api.interfaces.InterfacesSettingsIdListCache;
import com.hengyunsoft.platform.security.entity.interfaces.domain.ServiceResource;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceConfig;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/12
 */
@Component
@Slf4j
public class InterfacesConfigActuator {
    @Autowired
    private ShareDataApiOpen shareDataApiOpen;
    @Autowired
    private InterfaceConfigService interfaceConfigService;
    @Autowired
    private ServiceManageService serviceManageService;
    @Autowired
    private AlarmRuleSettingsService alarmRuleSettingsService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private AlarmInformationService alarmInformationService;
    @Autowired
    private DealUserService dealUserService;
    @Autowired
    private PersonService personService;

    private final static int DEF_PAGE_NO = 1;
    private final static int DEF_PAGE_SIZE = 10;

    @Autowired
    IdGenerate<Long> idGenerate;
    @Autowired
    ApplicationApi applicationApi;
    @Autowired
    UserApi userAdminApi;
    @Autowired
    UserApi userApi;
    @Autowired
    private SmsSendApi smsSendApi;
    @Value("${gxqpt.ops-webapp.app-id}")
    private String appId;
    @Value("${gxqpt.ops-webapp.app-name}")
    private String appName;

    @Value("${gxqpt.warnconstat.channel_id}")
    private String CHANNEL_ID;
    @Value("${gxqpt.warnconstat.template_id}")
    private String TEMPLATE_ID;



    /**
     * 定时同步 服务监控系统的接口
     * <p>
     * 服务监控系统中的c_service_resource，通过复制的形式，弄到pt库。定时读pt库的数据
     */
    @Scheduled(cron = "0 0 3 * * ?")//每天晚上凌晨执行
//    @Scheduled(cron = "0/30 * * * * ?")//每30秒执行一次
    public void saveServiceApiSynchronization() {
        try {
            log.info("服务监控接口同步执行了{}", LocalDateTime.now());
            PageHelper.startPage(DEF_PAGE_NO, DEF_PAGE_SIZE);
            List<ServiceResource> allList = interfaceConfigService.findAllServiceResource();


            log.info("allList={}" ,allList.size());
            PageInfo<ServiceResource> pageInfo = new PageInfo<>(allList);

            List<ServiceResource> list = pageInfo.getList();
            int pages = pageInfo.getPages();


            List<InterfaceConfig> configList = new ArrayList<>();
            for (int i = 1; i <= pages; i++) {
                if (i != 1) {
                    PageHelper.startPage(i, DEF_PAGE_SIZE);
                    allList = interfaceConfigService.findAllServiceResource();
                    pageInfo = new PageInfo<>(allList);
                    list = pageInfo.getList();
                }

                List<InterfaceConfig> pageList = coverList2(list);
                if (!pageList.isEmpty()) {
                    configList.addAll(pageList);
                }
            }


            log.info("configList.size={}", configList.size());

            if (!configList.isEmpty()) {
                interfaceConfigService.batchSaveOrUpdate(configList);

                InterfacesSettingsIdListCache.of().clear();
                configList.forEach((config) -> {
                    InterfacesSettingsBeanCache.of(config.getId()).clear();
                });

            }
        } catch (Exception e) {
            log.error("同步共享交换服务出错", e);
        }
    }

    private static List<InterfaceConfig> coverList2(List<ServiceResource> list) {
        List<InterfaceConfig> pageList = list.stream()
                .filter((api) -> StringUtils.isNotEmpty(api.getAppId()) && StringUtils.isNotEmpty(api.getHttpMethod()) && StringUtils.isNotEmpty(api.getUrl()))
                .map((api) -> {
                    InterfaceConfig ic = new InterfaceConfig();
                    ic.setApiId(api.getId());
                    ic.setApiName(api.getName());
                    ic.setApiUrl(api.getUrl());
                    ic.setModularName(api.getDesc());
                    ic.setAppId(api.getAppId());
                    ic.setCreateTime(new Date());
                    ic.setUpdateTime(new Date());
                    ic.setIsNotify(BooleanStatus.FALSE.getVal());
                    ic.setIsSmsNotify(BooleanStatus.FALSE.getVal());
                    ic.setStatus(EnableStatus.DISABLE.getStatus());
                    ic.setMethod(api.getHttpMethod());
                    return ic;
                }).collect(Collectors.toList());
        return pageList;
    }


    /**
     * 定时同步共享交换的api
     */
    @Scheduled(cron = "0 0 2 * * ?")//每天晚上凌晨执行
//    @Scheduled(cron = "0/30 * * * * ?")//每30秒执行一次
    public void saveExchangeApiSynchronization() {
        log.info("共享交换接口同步执行了{}", LocalDateTime.now());
        try {
            OpenApiReq openApiReq = new OpenApiReq();
            openApiReq.setPageNo(DEF_PAGE_NO);
            openApiReq.setPageSize(DEF_PAGE_SIZE);
            Result<PageInfo<ApiOpenDto>> result = shareDataApiOpen.getAllUserApi(openApiReq);

            List<InterfaceConfig> configList = new ArrayList<>();

            if (result.isSuccess() && result.getData() != null) {
                PageInfo<ApiOpenDto> dtoPageInfo = result.getData();
                List<ApiOpenDto> list = dtoPageInfo.getList();
                int pages = dtoPageInfo.getPages();//总页数3

                for (int i = 1; i <= pages; i++) {
                    if (i != 1) {
                        openApiReq.setPageNo(i);
                        result = shareDataApiOpen.getAllUserApi(openApiReq);
                        dtoPageInfo = result.getData();
                        list = dtoPageInfo.getList();
                    }

                    if (result.isSuccess() && result.getData() != null) {
                        List<InterfaceConfig> pageList = coverList(list);
                        if (!pageList.isEmpty()) {
                            configList.addAll(pageList);
                        }
                    }
                }
            }

            log.info("configList.size={}", configList.size());

            if (!configList.isEmpty()) {
                interfaceConfigService.batchSaveOrUpdate(configList);

                InterfacesSettingsIdListCache.of().clear();
                configList.forEach((config) -> {
                    InterfacesSettingsBeanCache.of(config.getId()).clear();
                });

            }
        } catch (Exception e) {
            log.error("同步共享交换接口出错", e);
        }
    }
    /**
     * 定时生成告警信息
     */
    @Scheduled(cron = "0 0 13 * * ?")//每天13点执行
    //@Scheduled(cron = "0/60 * * * * ?")//每30秒执行一次
    public void saveAlarmInformation() {
        log.info("定时生成告警信息{}", LocalDateTime.now());
        try {
            //alarmType告警类型,task_type任务类型，apply_type申请类别（服务、培训、咨询），details_url详情跳转地址
            findSet(1,1,"service_audit","serviceAudit");//服务审核
            findSet(2,1,"service_deal","serviceDeal");//服务处理

            findSet(1,2,"train_audit","trainAudit");//培训审核
            findSet(2,2,"train_deal","trainDeal");//培训处理

            findSet(1,3,"consult_audit","referCheck");//咨询审核
            findSet(2,3,"consult_deal","referHandle");//咨询处理
        } catch (Exception e) {
            log.error("运维告警出错", e);
            throw e;
        }
    }

    private void findSet(Integer alarmType,Integer  taskType,String appType,String detailsUrl){
        Map map = new HashMap<>();
        map.put("alarmType", alarmType);
        map.put("taskType", taskType);
        List<ServiceManageAlarmDO> serviceList=new ArrayList<>();
        if(taskType==1) {
                if(alarmType==1){
                    serviceList =serviceManageService.findServiceAudit();//查询运维待审核；
                }else{
                    serviceList = serviceManageService.findServiceDeal();//查询运维待处理；
                }
        }else if(taskType==2){
                if(alarmType==1){
                    serviceList =serviceManageService.findTrainAudit();//查询运维培训待审核；
                }else{
                    serviceList =serviceManageService.findTrainDeal();//查询运维培训待处理；
                }
        }else if(taskType==3){
                if(alarmType==1){
                    serviceList =serviceManageService.findConsultAudit();//查询运维咨询待审核；
                }else{
                    serviceList =serviceManageService.findConsultDeal();//查询运维咨询待审核；
                }
        }
        List<AlarmRuleSettingsDTO> setList=dozerUtils.
                mapList(alarmRuleSettingsService.getAlarmPageList(map),AlarmRuleSettingsDTO.class);//查询运维服务类别的告警规则；
        batchSave(serviceList, setList,appType,detailsUrl);
        if(alarmType==1){
            Result<List<UserResDTO>> list=userApi.findUserByCodeAndAppId(appId,"app_approval");
            StringBuilder userId = new StringBuilder();
            StringBuilder userName= new StringBuilder();
            if(list.getData()!=null && !list.getData().isEmpty()){
                for(int i=0;i<list.getData().size();i++){
                    if (userId.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                        userId.append(",");
                    }
                    if (userName.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                        userName.append(",");
                    }
                    userId.append(list.getData().get(i).getId());
                    userName.append(list.getData().get(i).getName());
                }
            }
           if(userId!=null && userName!=null){
               sendMsg(userId.toString(), userName.toString());
           }
        }else{
            if(serviceList!=null && !serviceList.isEmpty()){
                for(ServiceManageAlarmDO manageAlarmDO:serviceList){
                    Long id=manageAlarmDO.getId();
                    DealUserExample dealUserExample=new DealUserExample();
                    dealUserExample.createCriteria().andBussIdEqualTo(id).andTypeEqualTo("clr");
                    DealUser dealUser=dealUserService.getUnique(dealUserExample);
                    if(dealUser!=null){
                        sendMsg(dealUser.getPersonId().toString(), dealUser.getPersonName());
                    }
                }
            }
        }
    }

    private void batchSave(List<ServiceManageAlarmDO> serviceList, List<AlarmRuleSettingsDTO> setList,String appType,String detailsUrl) {
        if(setList!=null && setList.size()>0 ){
            for(AlarmRuleSettingsDTO dto:setList){
                Integer alarmDay=dto.getDay();
                if(serviceList!=null && serviceList.size()>0){
                    List<AlarmInformation> alarmInformationList=new ArrayList<>();
                    for(ServiceManageAlarmDO alarmDO:serviceList){
                        Long id=alarmDO.getId();
                        DealUserExample dealUserExample=new DealUserExample();
                        dealUserExample.createCriteria().andBussIdEqualTo(id).andTypeEqualTo("clr");
                        //查询处理人
                        DealUser dealUser=dealUserService.getUnique(dealUserExample);
                        if(alarmDO!=null && alarmDO.getDay()>=alarmDay){
                            AlarmInformationExample informationExample=new AlarmInformationExample();
                            informationExample.createCriteria().andApplyCodeEqualTo(alarmDO.getApplyCode()).andRuleIdEqualTo(dto.getId())
                                    .andApplyTypeEqualTo(appType).andStatusEqualTo(1);
                            List<AlarmInformation> information=alarmInformationService.find(informationExample);
                            if(information==null || information.size()==0){
                                AlarmInformation alarmInformation=new AlarmInformation();
                                alarmInformation.setId(idGenerate.generate());
                                alarmInformation.setRuleId(dto.getId());
                                alarmInformation.setDetailsUrl(detailsUrl);
                                alarmInformation.setApplyCode(alarmDO.getApplyCode());
                                alarmInformation.setApplyType(appType);
                                alarmInformation.setStatus(1);
                                if(alarmDO.getStatus()==3){
                                    alarmInformation.setCreateUser(dealUser.getPersonId());
                                }
                                alarmInformation.setCreateTime(new Date());
                                alarmInformation.setSystemId(appId);
                                alarmInformation.setSystemName(appName);
                                alarmInformationList.add(alarmInformation);
                            }
                        }
                    }
                    if(alarmInformationList!=null && alarmInformationList.size()>0){
                        alarmInformationService.batchSave(alarmInformationList);
                    }
                }
            }
        }
    }

    private void sendMsg(String dutyUser,String dutyUserName){
        //发短信-组装短信模板
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("{1}", "运维管理平台");
        hashMap.put("{2}", appName);
        hashMap.put("{3}", dutyUserName);
        addSendBbsUserList(dutyUser,hashMap);
    }
    /**
     *
     * @param dutyUser
     * @param map
     */
    public void addSendBbsUserList( String dutyUser, Map<String, String> map) {

        //给责任人或处理人发消息
        if (StringUtils.isNotEmpty(dutyUser)) {
            String[] dutyUsers = dutyUser.split(",");
            addSendPhoneMsg(dutyUsers,map);
        }
    }
    /**
     * 统一监管平台监管配置中心手机短信发送
     *
     * @param userIds
     * @param map
     */
    public void addSendPhoneMsg(String[] userIds, Map<String, String> map) {

        for (String userId : userIds) {
            UserDto user = userAdminApi.getById(Long.parseLong(userId)).getData();
            if (user == null) {
                log.info("根据userID,[{}]查询用户信息为空！！");
            }
            if (user != null) {
                String userPhone = user.getPhone();
                String userName = user.getName();
                SmsSendDTO dto = new SmsSendDTO();
                dto.setAppId(appId);
                dto.setAppName(appName);
                dto.setSender(SystemUsers.gxqptSystem.getId().toString());
                dto.setReceiver(userPhone);
                // TODO: 2018/9/21  以下模板需要根据申请的新模板进行更改
                dto.setChannelId(CHANNEL_ID);
                dto.setTemplateId(TEMPLATE_ID);
                dto.setTemplateParams(JSON.toJSONString(map));

                //存在手机号，发送短信
                if (StringUtils.isNotEmpty(userPhone)) {
                    Result<String> res = smsSendApi.send(dto);
                    log.info("发送短信结果,res,[{}] ", res.toString());
                    if (res.isSuccess() && res.getData() != null) {
                        log.info("用户名：[{}]，手机号码：[{}]，发送短信成功!!", userName, userPhone, res.getErrmsg());
                    } else {
                        log.info("用户名：[{}]，手机号码：[{}]，发送短信失败!!", userName, userPhone, res.getErrmsg());
                    }
                }
            }
        }
    }
    private List<InterfaceConfig> coverList(List<ApiOpenDto> list) {
        List<InterfaceConfig> pageList = list.stream()
                .filter((api) -> StringUtils.isNotEmpty(api.getApiUrl()))
                .map((api) -> {
                    InterfaceConfig ic = new InterfaceConfig();
                    ic.setApiId(api.getId());
                    ic.setApiName(api.getApiName());
                    ic.setApiUrl(api.getApiUrl());
                    ic.setModularName(api.getModuleName());
//                    ic.setModularName("共享交换系统");
                    ic.setAppId("35kj6100");
                    ic.setCreateTime(new Date());
                    ic.setUpdateTime(new Date());
                    ic.setIsNotify(BooleanStatus.FALSE.getVal());
                    ic.setIsSmsNotify(BooleanStatus.FALSE.getVal());
                    ic.setStatus(EnableStatus.DISABLE.getStatus());
                    ic.setMethod("GET");
                    return ic;
                }).collect(Collectors.toList());
        return pageList;
    }


}
