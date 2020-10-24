package com.hengyunsoft.platform.ops.impl.fault;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.SystemUsers;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.OperationExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.OrgDeptDutyInfoDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.mail.api.UserSendMailApi;
import com.hengyunsoft.platform.mail.dto.SendMailInfoDTO;
import com.hengyunsoft.platform.mail.dto.open.MailBeanDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.ops.entity.fault.domain.OperationReportDO;
import com.hengyunsoft.platform.ops.entity.fault.po.FaultManage;
import com.hengyunsoft.platform.ops.entity.file.po.OperationFile;
import com.hengyunsoft.platform.ops.entity.person.po.ChargeSystem;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.entity.person.po.PersonManage;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceManage;
import com.hengyunsoft.platform.ops.entity.train.po.TrainManage;
import com.hengyunsoft.platform.ops.faultdto.*;
import com.hengyunsoft.platform.ops.operationfiledto.HomePageAnalysisDTO;
import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import com.hengyunsoft.platform.ops.persondto.ApplicationHourDTO;
import com.hengyunsoft.platform.ops.persondto.ChargeSystemDTO;
import com.hengyunsoft.platform.ops.repository.fault.example.FaultManageExample;
import com.hengyunsoft.platform.ops.repository.fault.service.FaultManageService;
import com.hengyunsoft.platform.ops.repository.file.example.OperationFileExample;
import com.hengyunsoft.platform.ops.repository.file.service.OperationFileService;
import com.hengyunsoft.platform.ops.repository.person.example.ChargeSystemExample;
import com.hengyunsoft.platform.ops.repository.person.service.ChargeSystemService;
import com.hengyunsoft.platform.ops.repository.person.service.DealUserService;
import com.hengyunsoft.platform.ops.repository.person.service.PersonService;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceManageExample;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceManageService;
import com.hengyunsoft.platform.ops.repository.train.example.TrainManageExample;
import com.hengyunsoft.platform.ops.repository.train.service.TrainManageService;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendDTO;
import com.hengyunsoft.platform.piping.open.SmsSendApi;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.hengyunsoft.platform.ops.impl.utils.OpsDateUtils.*;
import static java.math.BigDecimal.ROUND_HALF_DOWN;

@RestController
@Slf4j
@RequestMapping("fault")
@Api(value = "API - FaultManageImpl", description = "故障管理")
public class FaultManageImpl implements Serializable {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FaultManageService faultManageService;
    @Autowired
    private OperationFileService operationFileService;
    @Autowired
    private ChargeSystemService chargeSystemService;
    @Autowired
    private DealUserService dealUserService;
    @Autowired
    private GxqptEmpApi gxqptEmpApi;
    @Autowired
    GxqptOrgOpenApi gxqptOrgOpenApi;
    @Autowired
    private PersonService personService;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    private ServiceManageService serviceManageService;
    @Autowired
    private TrainManageService trainManageService;
    @Autowired
    UserSendMailApi userSendMailApi;
    @Autowired
    UserApi userAdminApi;

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

    public List<String> monthList = new ArrayList<String>(Arrays.asList("01月", "02月", "03月", "04月", "05月", "06月", "07月", "08月", "09月", "10月", "11月", "12月"));


    @RequestMapping(value = "/saveFaultManage", method = RequestMethod.GET)
    @IgnoreToken
    @ApiOperation(value = "新增异常故障管理信息", notes = "新增异常故障管理信息")
    @ApiResponses({
            @ApiResponse(code = 105049, message = "故障名称不能为空"),
            @ApiResponse(code = 105050, message = "故障主机不能为空"),

    })
    public Result<Boolean> saveFaultManage(FaultManageDTO dto) {
        BizAssert.assertNotEmpty(OperationExceptionCode.FAULT_NAME_NULL, dto.getFaultName());
        BizAssert.assertNotEmpty(OperationExceptionCode.FAULT_PC_NULL, dto.getFaultHost());
        Long userId = BaseContextHandler.getAdminId();
        FaultManage faultManage = dozerUtils.map(dto, FaultManage.class);
        //查询当前系统最新产生的故障
        FaultManage faultManage1Max = faultManageService.findMaxHappenTimeEntity(dto.getSystemId());
        log.info("查询当前系统最新产生的故障" + faultManage1Max);
        double time = -1;
        if (faultManage1Max != null) {
            Long mTime = dateDiff(faultManage1Max.getUpdateTime(), dto.getHappenTime());
            BigDecimal b1 = new BigDecimal(Double.toString(mTime));
            BigDecimal b2 = new BigDecimal(Double.toString(1000 * 60));
            time = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (time > 2 || time == -1) {
            //默认未处理
            faultManage.setStatus(1);
            faultManage.setCreateUser(userId);
            faultManageService.saveSelective(faultManage);
            log.info("保存故障信息" + faultManage);
            BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
            String bizType = "yw_fault_deal";
            List<Long> lookUserIds = new ArrayList<>();
            ChargeSystemExample systemExample = new ChargeSystemExample();
            systemExample.createCriteria().andSystemIdEqualTo(dto.getSystemId());
            List<ChargeSystem> list = chargeSystemService.find(systemExample);
            if (list != null && list.size() > 0) {
                for (ChargeSystem system : list) {
                    //负责系统人员
                    lookUserIds.add(system.getpId());
                }
                log.info("用户人员id" + lookUserIds);
                //查询用户结合信息
                Result<List<GxqptEmpRetDTO>> empUser = gxqptEmpApi.findByIdsGxqptUserName(lookUserIds);
                log.info("查询用户结合信息" + empUser);
                if (empUser != null && empUser.getData() != null) {
                    for (GxqptEmpRetDTO empRetDTO : empUser.getData()) {
                        SendMailInfoDTO sendMailInfoDTO = new SendMailInfoDTO();
                        sendMailInfoDTO.setFrom("admin@ljg.com");
                        sendMailInfoDTO.setTo(empRetDTO.getNickname() + "@ljg.com");
                        sendMailInfoDTO.setSubject("您有一封来自运维管理平台的告警信息");
                        sendMailInfoDTO.setContent("您有一封来自运维管理平台的告警信息:" + dto.getFaultName());
                        //发送邮件
                        Result<MailBeanDTO> sendEmail = userSendMailApi.saveSendEmail(sendMailInfoDTO);
                        if (sendEmail != null) {
                            log.info("调用发送邮件" + sendEmail);
                        }
                    }
                    //发送短信
                    Result<String> res = addSendPhoneMsg(lookUserIds);
                    if (res != null) {
                        log.info("调用发送短信" + res);
                    }
                }
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(faultManage.getId(), bizType, "" + faultManage.getSystemName() + "有一条故障待处理");
                String msg = msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
                if (msg != null) {
                    log.info("保存消息到" + msg);
                }
            }
        } else {
            faultManage1Max.setUpdateTime(dto.getHappenTime());
            faultManage1Max.setCreateUser(userId);
            faultManage1Max.setUpdateUser(userId);
            faultManageService.updateByIdSelective(faultManage1Max);
        }
        return Result.success(true);
    }

    /**
     * 运维管理平台告警信息手机短信发送
     *
     * @param userIds
     * @param
     */
    public Result<String> addSendPhoneMsg(List<Long> userIds) {
        Result<String> res = null;
        for (Long userId : userIds) {
            UserDto user = userAdminApi.getById(userId).getData();
            if (user == null) {
                log.info("根据userID,[{}]查询用户信息为空！！");
            }
            if (user != null) {
                String userPhone = user.getPhone();
                String userName = user.getName();
                SmsSendDTO dto = new SmsSendDTO();
                dto.setAppName(appName);
                dto.setAppId(appId);
                dto.setReceiver(userPhone);
                dto.setSender(SystemUsers.gxqptSystem.getId().toString());
                // TODO: 2018/9/21  以下模板需要根据申请的新模板进行更改
                dto.setChannelId(CHANNEL_ID);
                dto.setTemplateId(TEMPLATE_ID);
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("{1}", "运维管理-告警信息");
                hashMap.put("{2}", appName);
                hashMap.put("{3}", "");
                dto.setTemplateParams(JSON.toJSONString(hashMap));

                //存在手机号，发送短信
                if (StringUtils.isNotEmpty(userPhone)) {
                    res = smsSendApi.send(dto);
                    if (res.isSuccess() && res.getData() != null) {
                        return Result.fail("发送短信成功" + res.getErrmsg());
                    } else {
                        return Result.fail("发送短信失败" + res.getErrcode());
                    }
                }
            }
        }
        return Result.success("发送短信成功" + res.getErrmsg());
    }

    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(Long id, String bizType, String moduleName) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(id.toString());
        bbsAllMainMsgDTO.setBizType(bizType);
        bbsAllMainMsgDTO.setBriefTpye("fault_manage");
        bbsAllMainMsgDTO.setContent(moduleName);
        bbsAllMainMsgDTO.setTitle(moduleName);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(false);

        bbsAllMainMsgDTO.setDetailedType(bizType);
        bbsAllMainMsgDTO.setDetailedTypeDesc("待办-我的任务");
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setHandlerUrl("/index.html#/myTask");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }

    @ApiOperation(value = "查询服务申请分页信息", notes = "查询服务申请分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<FaultManageDTO>> page(@RequestBody OpenApiReq<FaultManagePageReqDTO> openApiReq) {

        Map<String, Object> map = new HashMap();
        map.put("faultName", openApiReq.getData().getFaultName());
        map.put("faultType", openApiReq.getData().getFaultType());
        map.put("faultLevel", openApiReq.getData().getFaultLevel());
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        map.put("status", openApiReq.getData().getStatus());
        map.put("isTrue", openApiReq.getData().getIsTrue());
        map.put("faultHost", openApiReq.getData().getFaultHost());
        map.put("systemId", openApiReq.getData().getSystemId());

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(faultManageService.getPageList(map), FaultManageDTO.class)));
    }

    @ApiOperation(value = "查询我的任务故障信息", notes = "查询我的任务故障信息")
    @RequestMapping(value = "/pageMyFaultList", method = RequestMethod.POST)
    public Result<PageInfo<FaultManageDTO>> pageMyFaultList(@RequestBody OpenApiReq<FaultManagePageReqDTO> openApiReq) {

        Long userId = BaseContextHandler.getAdminId();

        Map<String, Object> map = new HashMap();
        map.put("faultName", openApiReq.getData().getFaultName());
        map.put("faultType", openApiReq.getData().getFaultType());
        map.put("faultLevel", openApiReq.getData().getFaultLevel());
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        map.put("status", openApiReq.getData().getStatus());
        map.put("faultHost", openApiReq.getData().getFaultHost());
        map.put("systemId", openApiReq.getData().getSystemId());
        map.put("userId", userId);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(faultManageService.pageMyFaultList(map), FaultManageDTO.class)));
    }


    @ApiOperation(value = "保存处理故障信息是否属实", notes = "保存处理故障信息是否属实")
    @RequestMapping(value = "/updateIsTrue", method = RequestMethod.POST)
    public Result<FaultManageUpdateDTO> updateIsTrue(@RequestBody FaultManageUpdateDTO updateDTO) {
        //转换，保存处理故障信息
        Long userId = BaseContextHandler.getAdminId();
        String isTrue = updateDTO.getIsTrue();
        FaultManage faultManage = dozerUtils.map(updateDTO, FaultManage.class);
        if (isTrue.equals("1")) {
            faultManage.setStatus(2);
        }
        if (isTrue.equals("2")) {
            faultManage.setStatus(3);
        }
        faultManage.setDealTime(new Date());
        faultManage.setUpdateUser(userId);
        faultManageService.updateByIdSelective(faultManage);

        DealUser user = new DealUser();
        user.setBussId(faultManage.getId());
        user.setType("clr");
        user.setPersonId(userId);
        user.setCreateUser(userId);
        user.setUpdateUser(userId);
        dealUserService.saveSelective(user);
        return Result.success(dozerUtils.map(faultManage, FaultManageUpdateDTO.class));
    }

    @ApiOperation(value = "保存处理故障信息", notes = "保存处理故障信息")
    @ApiResponses({
            @ApiResponse(code = 105045, message = "处理过程不能为空"),
            @ApiResponse(code = 105045, message = "处理结果不能为空"),
            @ApiResponse(code = 105046, message = "处理建议不能为空"),
    })
    @RequestMapping(value = "/updateFaultManage", method = RequestMethod.POST)
    public Result<FaultManageUpdateDTO> updateFaultManage(@RequestBody FaultManageUpdateDTO updateDTO) {
        //1.校验

        BizAssert.assertNotNull(OperationExceptionCode.FAULT_PROCESS_NULL, updateDTO.getDealProcess());
        BizAssert.assertNotNull(OperationExceptionCode.FAULT_RESULT_NULL, updateDTO.getResult());
        BizAssert.assertNotNull(OperationExceptionCode.DEAL_OPINION_NULL, updateDTO.getAdvice());


        //转换，保存处理故障信息
        Long userId = BaseContextHandler.getAdminId();
        FaultManage faultManage = dozerUtils.map(updateDTO, FaultManage.class);
        String isTrue = updateDTO.getIsTrue();
        //faultManage.setDealTime(new Date());
        faultManage.setStatus(3);
        faultManage.setUpdateUser(userId);
        faultManageService.updateByIdSelective(faultManage);
        List<OperationFileDTO> fileList = updateDTO.getFileList();
        List<OperationFile> files = new ArrayList<>();
        if (fileList != null && fileList.size() > 0) {
            for (OperationFileDTO dto : fileList) {
                OperationFile file = dozerUtils.map(dto, OperationFile.class);
                //file.setBussId(faultManage.getId());
                file.setUserId(userId);
                files.add(file);
            }
        }
        operationFileService.save(files);
        return Result.success(dozerUtils.map(faultManage, FaultManageUpdateDTO.class));
    }

    @ApiOperation(value = "故障信息-加入知识库", notes = "故障信息-加入知识库")
    @RequestMapping(value = "/updateKnowledge", method = RequestMethod.POST)
    public Result<FaultManageUpdateDTO> updateKnowledge(@RequestBody FaultManageUpdateDTO updateDTO) {
        //转换，保存处理故障信息
        Long userId = BaseContextHandler.getAdminId();
        FaultManage faultManage = dozerUtils.map(updateDTO, FaultManage.class);
        faultManage.setUpdateUser(userId);
        faultManageService.updateByIdSelective(faultManage);
        return Result.success(dozerUtils.map(faultManage, FaultManageUpdateDTO.class));
    }

    @ApiOperation(value = "根据故障id查询故障详情信息", notes = "根据故障id查询故障详情信息")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Result<FaultMangeDetailDTO> getById(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("故障详情id不能为空");
        }
        FaultManageExample manageExample = new FaultManageExample();
        manageExample.createCriteria().andIdEqualTo(id);
        FaultMangeDetailDTO faultDto = dozerUtils.map(faultManageService.getById(id), FaultMangeDetailDTO.class);
        OperationFileExample fileExample = new OperationFileExample();
        fileExample.createCriteria().andBussIdEqualTo(id).andBussTypeEqualTo("fault_report");
        List<OperationFileDTO> fileList = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
        if (fileList != null && fileList.size() > 0) {
            faultDto.setFileList(fileList);
        }
        //获取处理人、协助人信息
        List<DealUser> dealList = dealUserService.getByBussId(id);
        if (dealList != null && dealList.size() > 0) {
            String assistant = "";
            for (DealUser dealUser : dealList) {
                String type = dealUser.getType();
                //处理人只有一个
                if ("clr".equals(type)) {
                    Long personId = dealUser.getPersonId();
                    ChargeSystemExample systemExample = new ChargeSystemExample();
                    systemExample.createCriteria().andPIdEqualTo(personId);
                    List<ChargeSystemDTO> systemDTO = dozerUtils.mapList(chargeSystemService.find(systemExample), ChargeSystemDTO.class);
                    //负责系统
                    faultDto.setChargeSystemDTOS(systemDTO);
                    PersonManage personManage = personService.getById(personId);
                    if (personManage != null) {
                        faultDto.setContent(personManage.getContent());
                        faultDto.setMainmobile(personManage.getMainmobile());
                    }
                    Long[] ids = {Long.valueOf(personId)};
                    Result<List<GxqptEmpRetDTO>> empUser = gxqptEmpApi.findByIdsGxqptYw(ids);
                    List<GxqptEmpRetDTO> emps = empUser.getData();
                    if (emps != null && emps.size() > 0) {
                        GxqptEmpRetDTO empRetDTO = emps.get(0);
                        //职务
                        faultDto.setMaindutyname(empRetDTO.getMaindutyname());
                        //处理人姓名
                        faultDto.setDealUser(empRetDTO.getName());
                    }
                }
                //协助人
                if ("xzr".equals(type)) {
                    assistant += dealUser.getPersonName() + ",";
                }
            }
            faultDto.setAssistant(assistant);
        }
        return Result.success(faultDto);
    }

    @ApiOperation(value = "查询故障知识库分页信息", notes = "查询故障知识库分页信息")
    @RequestMapping(value = "/pageKnowledgeBase", method = RequestMethod.POST)
    public Result<PageInfo<FaultManageDTO>> pageKnowledgeBase(@RequestBody OpenApiReq<FaultKnowledgePageReqDTO> openApiReq) {

        Map<String, Object> map = new HashMap();
        map.put("faultName", openApiReq.getData().getFaultName());
        map.put("faultType", openApiReq.getData().getFaultType());
        map.put("faultLevel", openApiReq.getData().getFaultLevel());
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        map.put("isJoinKnowledge", 1);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<FaultManageDTO> dtoList = dozerUtils.mapPage(faultManageService.pageKnowledgeBase(map), FaultManageDTO.class);
        if (dtoList != null && dtoList.size() > 0) {
            for (FaultManageDTO dto : dtoList) {
                Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(Long.valueOf(dto.getUpdateUser()));
                if (orgDeptDutyInfo.getData() != null && orgDeptDutyInfo.getData().getUserName() != null) {
                    dto.setCreateUser(orgDeptDutyInfo.getData().getUserName());
                } else {
                    dto.setCreateUser("用户名为空");
                }
            }
        }
        return Result.success(new PageInfo<>(dtoList));
    }

    @ApiOperation(value = "删除知识库信息", notes = "删除知识库信息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("故障信息id为空!");
        }
        Long userId = BaseContextHandler.getAdminId();
        FaultManage manage = faultManageService.getById(id);
        if (manage == null) {
            return Result.fail("根据参数id没有查询到相关信息");
        }
        manage.setUpdateUser(userId);
        manage.setIsJoinKnowledge(2);
        faultManageService.updateByIdSelective(manage);
        return Result.success(true);
    }

    @ApiOperation(value = "应用分析查询", notes = "应用分析查询")
    @RequestMapping(value = "/findAnalyse", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 105054, message = "时间参数类型不能为空"),
            @ApiResponse(code = 105055, message = "应用appId不能为空"),
            @ApiResponse(code = 105056, message = "参数对象不能为空")
    })
    public Result<ResponseFMFindAnalyseDTO> findAnalyse(@RequestBody RequestFMFindAnalyseDTO dto) {
        log.info("=================应用分析查询Start=====================");
        //校验
        BizAssert.assertNotNull(OperationExceptionCode.FAULT_PARAM_OBJECT_NULL, dto);
        BizAssert.assertNotNull(OperationExceptionCode.FAULT_APPID_NOT_NULL, dto.getAppId());
        BizAssert.assertNotNull(OperationExceptionCode.FAULT_TIME_TYPE_NULL, dto.getTimeType());

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer timeType = dto.getTimeType();
        //故障数量分析X轴
        List<Integer> faultSumX = Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24);
        Date startTime = getDayBegin();
        Date endTime = getDayEnd();
        if (timeType == 2) {
            faultSumX = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            startTime = getBeginDayOfWeek();
            endTime = getEndDayOfWeek();
        } else if (timeType == 3) {
            faultSumX = Arrays.asList(5, 10, 15, 20, 25, 30);
            startTime = getBeginDayOfMonth();
            endTime = getEndDayOfMonth();
        } else if (timeType == 4) {
            faultSumX = Arrays.asList(2, 4, 6, 8, 10, 12);
            startTime = getBeginDayOfYear();
            endTime = getEndDayOfYear();
        }
        ResponseFMFindAnalyseDTO resultDto = new ResponseFMFindAnalyseDTO();
        //获取时间段所有数据
        FaultManageExample example = new FaultManageExample();
        example.createCriteria().andSystemIdEqualTo(dto.getAppId()).andCreateTimeBetween(startTime, endTime);
        List<FaultManage> list = faultManageService.find(example);
        //已处理故障
        List<FaultManage> alreadyList = new ArrayList<FaultManage>();
        ;
        //未处理故障
        List<FaultManage> untreatedList = new ArrayList<FaultManage>();
        ;
        //故障级别一
        List<FaultManage> oneFaultLevel = new ArrayList<FaultManage>();
        ;
        //故障级别二
        List<FaultManage> twoFaultLevel = new ArrayList<FaultManage>();
        ;
        //故障级别三
        List<FaultManage> threeFaultLevel = new ArrayList<FaultManage>();
        ;

        for (FaultManage curObj : list) {
            if (curObj.getDealTime() == null) {
                untreatedList.add(curObj);
            } else {
                alreadyList.add(curObj);
            }
            if ("1".equals(curObj.getFaultLevel())) {
                oneFaultLevel.add(curObj);
            } else if ("2".equals(curObj.getFaultLevel())) {
                twoFaultLevel.add(curObj);
            } else {
                threeFaultLevel.add(curObj);
            }
        }
        //未处理故障数
        Integer untreatedFaultSum = 0;
        if (untreatedList.size() > 0) {
            untreatedFaultSum = untreatedList.size();
        }
        resultDto.setUntreatedFaultSum(untreatedFaultSum);
        //已处理故障数平均值
        Double faultTimeAvg = 0.0;
        if (alreadyList.size() > 0) {
            Double countDay = 0.0;
            for (FaultManage alreadyObj : alreadyList) {
                Date startDate = alreadyObj.getHappenTime();
                Date endDate = alreadyObj.getDealTime();
                countDay += getDistHour(startDate, endDate);
            }
            log.info("countDay={0},faultTimeAvg={1},untreatedFaultSum={2}", countDay, alreadyList.size(), untreatedFaultSum);
            //故障处理时间平均值（天）
            BigDecimal value1 = new BigDecimal(countDay + "");
            BigDecimal value2 = new BigDecimal(alreadyList.size() + "");
            Double result = value1.divide(value2, 2, RoundingMode.HALF_UP).doubleValue();
            faultTimeAvg = doubleFormartTwo(result);
        }
        resultDto.setFaultTimeAvg(faultTimeAvg);
        //应用评分(（1-故障数量/故障数量阀值）+（1-故障处理时间/故障处理时间阀值）+（1-未处理故障数/未处理故障阀值）)/3*100
        Double appScore = 100.0;
//        if(untreatedList.size() > 0 && alreadyList.size() > 0) {
        Integer faultCountSum = list.size();
        //故障阈值
        Integer faultThreshold = getFaultThreshold(timeType);
        BigDecimal value1 = precisionCalculation("1", faultCountSum + "", faultThreshold + "");
        BigDecimal value2 = precisionCalculation("1", faultTimeAvg + "", "12");
        BigDecimal value3 = precisionCalculation("1", untreatedFaultSum + "", "1");
        BigDecimal sum = value1.add(value2).add(value3);
        appScore = sum.divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).doubleValue();
        log.info("countDay=", appScore);
//        }
        resultDto.setAppScore(doubleFormartTwo(appScore));

        //故障产生数量分析
        //故障数量分析Y轴
        List<Integer> faultSumY = new ArrayList<Integer>();
        Integer currTime = 0;
        Integer curDay = 0;
        Integer curMonth = 0;
        Integer smonth = 1;
        Integer emonth = 2;
        for (Integer val : faultSumX) {
            if (timeType == 1) {
                Date startDate = getNeedTime(currTime, 0, 0, 0);
                Date endDate = getNeedTime(val, 0, 0, 0);
                currTime = val;
                log.info("startDate={},endDate={}", sf.format(startDate), sf.format(endDate));
                Integer count = getCountSum(startDate, endDate, list);
                faultSumY.add(count);
            } else if (timeType == 2) {
                Date startDate = getDayStartTime(getBeginDayOfWeek());
                Date endDate = getDayEndTime(getBeginDayOfWeek());
                startDate = addDate(startDate, curDay);
                endDate = addDate(endDate, curDay);
                curDay++;
                log.info("startDate={},endDate={}", sf.format(startDate), sf.format(endDate));
                Integer count = getCountSum(startDate, endDate, list);
                faultSumY.add(count);
            } else if (timeType == 3) {
                Date startDate = getDayStartTime(getBeginDayOfMonth());
                Date endDate = getDayEndTime(getBeginDayOfMonth());
                endDate = addDate(endDate, 4);
                startDate = addDate(startDate, curMonth);
                endDate = addDate(endDate, curMonth);
                curMonth += 5;
                log.info("startDate={},endDate={}", sf.format(startDate), sf.format(endDate));
                Integer count = getCountSum(startDate, endDate, list);
                faultSumY.add(count);
            } else {
                String startStr = getNowYear() + "-" + smonth + "-1 00:00:00";
                String endStr = getNowYear() + "-" + emonth + "-" + getDaysByYearMonth(getNowYear(), emonth) + " 23:59:59";
                Date startDate = convertDate(startStr);
                Date endDate = convertDate(endStr);
                smonth += 2;
                emonth += 2;
                log.info("startDate={},endDate={}", sf.format(startDate), sf.format(endDate));
                Integer count = getCountSum(startDate, endDate, list);
                faultSumY.add(count);
            }
        }
        resultDto.setFaultSumY(faultSumY);
        resultDto.setFaultSumX(faultSumX);

        //故障级别分析
        List<Double> faultLevel = new ArrayList<Double>();
        Integer oneLevel = oneFaultLevel == null ? 0 : oneFaultLevel.size();
        Integer twoLevel = twoFaultLevel == null ? 0 : twoFaultLevel.size();
        Integer threeLevel = threeFaultLevel == null ? 0 : threeFaultLevel.size();
        Integer countSum = oneLevel + twoLevel + threeLevel;
        faultLevel.add(faultLevelPCalculation(oneFaultLevel, countSum + ""));
        faultLevel.add(faultLevelPCalculation(twoFaultLevel, countSum + ""));
        faultLevel.add(faultLevelPCalculation(threeFaultLevel, countSum + ""));
        resultDto.setFaultLevel(faultLevel);

        log.info("=================应用分析查询End=====================");
        return Result.success(resultDto);
    }

    public Double faultLevelPCalculation(List<FaultManage> list, String sum) {
        if (list.size() > 0) {
            BigDecimal value1 = new BigDecimal(list.size() + "");
            BigDecimal value2 = new BigDecimal(sum);
            BigDecimal value3 = new BigDecimal("100");
            Double val = value1.divide(value2, 10, ROUND_HALF_DOWN).multiply(value3).doubleValue();
            return doubleFormartTwo(val);
        } else {
            return 0.0;
        }
    }


    /**
     * 精度计算,小于0就返回0
     *
     * @param v1
     * @param v2
     * @param v3
     * @return
     */
    private BigDecimal precisionCalculation(String v1, String v2, String v3) {
        BigDecimal a = new BigDecimal(v1);
        BigDecimal b = new BigDecimal(v2);
        BigDecimal c = new BigDecimal(v3);
        BigDecimal d = b.divide(c, 2, RoundingMode.HALF_UP);
        BigDecimal result = a.subtract(d);
        if (result.doubleValue() < 0) {
            return new BigDecimal(0.0);
        } else {
            return result;
        }
    }

    /**
     * 保留两位小数
     *
     * @param val
     * @return
     */
    private Double doubleFormartTwo(Double val) {
        return new BigDecimal(val).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //根据日期统计故障数量
    private Integer getCountSum(Date startDate, Date endDate, List<FaultManage> list) {
        Integer count = 0;
        for (FaultManage curObj : list) {
            Date nowDate = curObj.getCreateTime();
            if (isEffectiveDate(nowDate, startDate, endDate)) {
                count++;
            }
        }
        return count;
    }

    //获取故障阈值
    private Integer getFaultThreshold(Integer type) {
        Integer threshold = 0;
        switch (type) {
            case 1:
                threshold = 1;
                break;
            case 2:
                threshold = 3;
                break;
            case 3:
                threshold = 10;
                break;
            default:
                threshold = 120;
                break;
        }
        return threshold;
    }

    @ApiOperation(value = "查询故障监控", notes = "查询故障监控")
    @RequestMapping(value = "/getFaultMonitoring", method = RequestMethod.GET)
    public Result<FaultMonitoringDTO> getFaultMonitoring() {
        FaultMonitoringDTO monitoringDTO = new FaultMonitoringDTO();
        FaultManageExample wclExample = new FaultManageExample();
        wclExample.createCriteria().andStatusEqualTo(1);
        //查询未处理故障数
        List<FaultManage> wclList = faultManageService.find(wclExample);
        if (wclList != null && wclList.size() > 0) {
            monitoringDTO.setUnhandledFault(wclList.size());
        }

        //无故障持续时间
        //查询最新故障产生时间记录
        Date happenTime = faultManageService.findMaxHappenTime();
        if (happenTime != null) {
            Long hTime = dateDiff(happenTime, new Date());
            Long time = hTime / (1000 * 60 * 60 * 24);
            monitoringDTO.setTime(time);
        }

        //查询故障数和处理时长
        ApplicationHourDTO hourDTOList = dozerUtils.map(faultManageService.findCountAndHour(), ApplicationHourDTO.class);
        if (hourDTOList.getCount() != 0 && hourDTOList.getHour() != null && hourDTOList.getHour() != 0) {
            Integer hour = hourDTOList.getHour();
            Integer averageTime = hour / hourDTOList.getCount();
            monitoringDTO.setAverageTime(averageTime);
        }
        //查询最早故障产生时间记录
        Date minTime = faultManageService.findMinHappenTime();
        if (minTime != null) {
            Long mTime = dateDiff(minTime, new Date());
            Long day = mTime / (1000 * 60 * 60 * 24);
            FaultManageExample allExample = new FaultManageExample();
            allExample.createCriteria();
            //查询所有故障数
            List<FaultManage> allList = faultManageService.find(allExample);
            //构造方法的字符格式这里如果小数不足2位,会以0补足.
            DecimalFormat decimalFormat = new DecimalFormat(".00");
            //求每天故障数
            Double dayFaults = (double) allList.size() / day.intValue();
            String p = decimalFormat.format(dayFaults);
            monitoringDTO.setDayFaults(p);
        }
        //目的数据
        List<Integer> ycldata = new ArrayList<Integer>();
        //查询已处理故障数
        List<OperationReportDO> ycllist = faultManageService.getReport();
        for (String month : monthList) {
            boolean f = true;
            for (OperationReportDO obj : ycllist) {
                if (month.equals((obj.getYearMonth() + "月"))) {
                    ycldata.add(obj.getNumber());
                    f = false;
                    continue;
                }
            }
            if (f) {
                ycldata.add(0);
            }
        }
        //查询未处理故障数
        List<OperationReportDO> wcllist = faultManageService.getWclReport();
        //目的数据
        List<Integer> wcldata = new ArrayList<Integer>();
        for (String month : monthList) {
            boolean f = true;
            for (OperationReportDO obj : wcllist) {
                if (month.equals((obj.getYearMonth() + "月"))) {
                    wcldata.add(obj.getNumber());
                    f = false;
                    continue;
                }
            }
            if (f) {
                wcldata.add(0);
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", ycldata);
        map.put("wcldata", wcldata);
        map.put("monthList", monthList);
        monitoringDTO.setMap(map);

        List<ReportTopDTO> reportTopList = dozerUtils.mapList(faultManageService.getReportTop(), ReportTopDTO.class);
        monitoringDTO.setReportTopDTOList(reportTopList);
        return Result.success(monitoringDTO);
    }

    @ApiOperation(value = "查询运维服务首页统计信息", notes = "查询运维服务首页统计信息")
    @RequestMapping(value = "/getHomePageCount", method = RequestMethod.GET)
    public Result<HomePageAnalysisDTO> getHomePageCount() {

        HomePageAnalysisDTO homePageAnalysisDTO = new HomePageAnalysisDTO();
        String orgId = null;
        Result<Map> mapNum = gxqptEmpApi.getOperationEmpNum(orgId);
        if (mapNum.getData() != null) {
            for (Object key : mapNum.getData().keySet()) {
                Object value = mapNum.getData().get(key);
                System.out.println(key + "  " + value);
                //运维人员总数
                homePageAnalysisDTO.setOperationPerson(value.toString());
            }
        }
        FaultManageExample wclExample = new FaultManageExample();
        //查询所有故障数
        List<FaultManage> wclList = faultManageService.find(wclExample);
        homePageAnalysisDTO.setFaultCount(wclList.size());

        Date startTime = getBeginDayOfMonth();
        Date endTime = getEndDayOfMonth();
        FaultManageExample monthExample = new FaultManageExample();
        monthExample.createCriteria().andHappenTimeGreaterThanOrEqualTo(startTime).andHappenTimeLessThanOrEqualTo(endTime);
        //查询本月所有故障数
        List<FaultManage> monthFaultList = faultManageService.find(monthExample);
        homePageAnalysisDTO.setMonthFaultCount(monthFaultList.size());

        ServiceManageExample serviceExample = new ServiceManageExample();
        //status服务已完结
        serviceExample.createCriteria().andStatusEqualTo(4);
        List<ServiceManage> manageList = serviceManageService.find(serviceExample);
        //总的运维服务次数
        homePageAnalysisDTO.setOperationServiceCount(manageList.size());

        ServiceManageExample monthServiceExample = new ServiceManageExample();
        //status已完结
        monthServiceExample.createCriteria().andStatusEqualTo(4)
                .andReportTimeGreaterThanOrEqualTo(startTime).andReportTimeLessThanOrEqualTo(endTime);
        List<ServiceManage> monthServiceList = serviceManageService.find(monthServiceExample);
        //本月总的运维服务次数
        homePageAnalysisDTO.setMonthOperationServiceCount(monthServiceList.size());

        TrainManageExample trainExample = new TrainManageExample();
        //status培训已完结
        trainExample.createCriteria().andStatusEqualTo(5);
        List<TrainManage> tranList = trainManageService.find(trainExample);
        //总培训次数
        homePageAnalysisDTO.setTrainCount(tranList.size());

        TrainManageExample monthTrainExample = new TrainManageExample();
        //status培训已完结
        monthTrainExample.createCriteria().andStatusEqualTo(5)
                .andTrainTimeGreaterThanOrEqualTo(startTime).andTrainTimeLessThanOrEqualTo(endTime);
        List<TrainManage> monthTranList = trainManageService.find(monthTrainExample);
        //本月总培训次数
        homePageAnalysisDTO.setMonthTrainCount(monthTranList.size());


        //目的数据
        List<Integer> serviceData = new ArrayList<Integer>();
        //查询本年运维服务数
        List<OperationReportDO> yearServiceList = faultManageService.getYearServiceReport();
        List<String> monthList = new ArrayList<String>(Arrays.asList(DateUtils.getLatest12Month()));
        for (String month : monthList) {
            boolean f = true;
            for (OperationReportDO obj : yearServiceList) {
                if (month.equals((obj.getYearMonth()))) {
                    serviceData.add(obj.getNumber());
                    f = false;
                    continue;
                }
            }
            if (f) {
                serviceData.add(0);
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", serviceData);
        map.put("monthList", monthList);
        homePageAnalysisDTO.setYearServiceMap(map);

        //目的数据
        List<Integer> faultdata = new ArrayList<Integer>();
        //查询本年故障数
        List<OperationReportDO> yearFaultList = faultManageService.getYearFaultReport();
        for (String month : monthList) {
            boolean f = true;
            for (OperationReportDO obj : yearFaultList) {
                if (month.equals((obj.getYearMonth()))) {
                    faultdata.add(obj.getNumber());
                    f = false;
                    continue;
                }
            }
            if (f) {
                faultdata.add(0);
            }
        }
        //目的数据
        List<Integer> ycldata = new ArrayList<Integer>();
        //查询已处理故障数
        List<OperationReportDO> ycllist = faultManageService.getMonthFaultReport();
        for (String month : monthList) {
            boolean f = true;
            for (OperationReportDO obj : ycllist) {
                if (month.equals((obj.getYearMonth()))) {
                    ycldata.add(obj.getNumber());
                    f = false;
                    continue;
                }
            }
            if (f) {
                ycldata.add(0);
            }
        }
        Map<String, Object> FaultMap = new HashMap<String, Object>();
        FaultMap.put("data", faultdata);
        FaultMap.put("ycldata", ycldata);
        FaultMap.put("monthList", monthList);
        homePageAnalysisDTO.setYearFaultMap(FaultMap);

        List<HomePageReportTopDTO> reportTopList = dozerUtils.mapList(faultManageService.getFaultReportTop(), HomePageReportTopDTO.class);
        homePageAnalysisDTO.setDtoList(reportTopList);
        return Result.success(homePageAnalysisDTO);
    }
}
