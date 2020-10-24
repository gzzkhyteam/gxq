package com.hengyunsoft.platform.logs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.LogsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppShowDto;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.logs.dto.LogStructApacheDTO;
import com.hengyunsoft.platform.logs.dto.LogStructAppDTO;
import com.hengyunsoft.platform.logs.dto.LogStructNginxDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTomcatDTO;
import com.hengyunsoft.platform.logs.dto.LogTypeMap;
import com.hengyunsoft.platform.logs.dto.LogWarnRuleDTO;
import com.hengyunsoft.platform.logs.dto.LogWarnRuleQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogWarnRuleSaveDTO;
import com.hengyunsoft.platform.logs.dto.LogWarnRuleUpdateDTO;
import com.hengyunsoft.platform.logs.dto.LogWarnSetDTO;
import com.hengyunsoft.platform.logs.dto.LogWarningDTO;
import com.hengyunsoft.platform.logs.dto.LogWarningQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogWarningUpdateBatchDTO;
import com.hengyunsoft.platform.logs.dto.LogWarningUpdateDTO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogAppNameDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogLevelMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogMonthErrorDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogSortDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogWarnAvgTimeDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogWarningDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnRule;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnSet;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarning;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnRuleExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnSetExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarningExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructApacheService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructAppService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructNginxService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructTomcatService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnRuleService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnSetService;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "日志告警", description = "日志告警管理")
public class LogWarnApiImpl /*implements LogWarnApi*/ {
    @Autowired
    private LogWarnService logWarnService;
    @Autowired
    private LogStructAppService logStructAppService;
    @Autowired
    private LogStructApacheService logStructApacheService;
    @Autowired
    private LogStructTomcatService logStructTomcatService;
    @Autowired
    private LogStructNginxService logStructNginxService;
    @Autowired
    private LogWarnService logWarnSerivce;
    @Autowired
    private LogWarnRuleService logWarnRuleService;
    @Autowired
    private LogWarnSetService logWarnSetService;
    @Autowired
    private ApplicationApi applicationApi;
    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;

    @Value("${logs.keep.file}")
    private Long logsKeepFile;
    @Value("${logs.keep.data}")
    private Long logsKeepData;
    @Value("${logs.keep.warn}")
    private Long logsKeepWarn;

    /**
     * 分页查询日志告警的记录
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询日志告警的记录", notes = "分页查询日志告警的记录")
    @RequestMapping(value = "/warn/pageQueryWarning", method = RequestMethod.POST)
    public Result<PageInfo<LogWarningDTO>> pageQueryWarning(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }
        LogWarningQueryDTO data = openApiReq.getData();
        LogWarningExample example = new LogWarningExample();
        if(null!=data){
                String appIds=data.getAppId();
                List<String> appIdList = new ArrayList();
                if(null!=appIds && !"".equals(appIds)){
                    String[] appIdArray = appIds.split(",");
                    for(int m=0; m<appIdArray.length; m++) {
                        String appId = appIdArray[m];
                        if(null!=appId && !appId.equals("")) {
                            appIdList.add(appId);
                        }
                    }
                }

            String warnTypes=data.getWarnType();
            List<String> warnList = new ArrayList();
            if(null!=warnTypes && !"".equals(warnTypes)){
                String[] warnArray = warnTypes.split(",");
                for(int m=0; m<warnArray.length; m++) {
                    String warnType = warnArray[m];
                    if(null!=warnType && !warnType.equals("")) {
                        warnList.add(warnType);
                    }
                }
            }
            String warnLevels=data.getWarnLevel();
            List<String> levelList = new ArrayList();
            if(null!=warnLevels && !"".equals(warnLevels)){
                String[] levelArray = warnLevels.split(",");
                for(int m=0; m<levelArray.length; m++) {
                    String warnLevel = levelArray[m];
                    if(null!=warnLevel && !warnLevel.equals("")) {
                        levelList.add(warnLevel);
                    }
                }
            }

                example.createCriteria().andFIdEqualTo(data.getId())
                        .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                       .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                       .andFWarnTypeIn(warnList.size()==0? Arrays.asList(""):warnList)
                        .andFWarnLevelIn(levelList.size()==0? Arrays.asList(""):levelList)
                       .andFCreateTimeGt(data.getCreateTimeStart())
                       .andFCreateTimeLt(data.getCreateTimeEnd())
                       .andFIsDealEqualTo(data.getIsDeal())
                       .andFNameLike(LogWarningExample.fullLike(data.getName()));
        }else{
            LogWarningExample.Criteria criteria= example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogWarningDO> lists = logWarnService.pageQueryWarning(example);
        List<LogWarningDTO> pageList = dozerUtils.mapPage(lists, LogWarningDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    /**
     * 分页查询告警的应用系统结构化日志列表（app）
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询告警的应用系统结构化日志", notes = "分页查询告警的应用系统结构化日志")
    @RequestMapping(value = "/warn/pageQueryWarningApp", method = RequestMethod.POST)
    public Result<PageInfo<LogStructAppDTO>> pageQueryWarningApp(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq) {
        LogWarningQueryDTO data = openApiReq.getData();
        Long id = data.getId();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApp> lists = logStructAppService.pageQueryWarningApp(id);
        List<LogStructAppDTO> pageList = dozerUtils.mapPage(lists, LogStructAppDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    /**
     * 分页查询告警apache的结构化日志列表（apache）
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询告警的APACHE结构化日志", notes = "分页查询告警的APACHE结构化日志")
    @RequestMapping(value = "/warn/pageQueryWarningApache", method = RequestMethod.POST)
    public Result<PageInfo<LogStructApacheDTO>> pageQueryWarningApache(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq) {
        LogWarningQueryDTO data = openApiReq.getData();
        Long id = data.getId();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApache> lists = logStructApacheService.pageQueryWarningApache(id);
        List<LogStructApacheDTO> pageList = dozerUtils.mapPage(lists, LogStructApacheDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    /**
     * 分页查询告警tomcat的构化日志列表（tomcat）
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询告警TOMCAT构化日志", notes = "分页查询告警TOMCAT结构化日志")
    @RequestMapping(value = "/warn/pageQueryWarningTomcat", method = RequestMethod.POST)
    public Result<PageInfo<LogStructTomcatDTO>> pageQueryWarningTomcat(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq) {
        LogWarningQueryDTO data = openApiReq.getData();
        Long id = data.getId();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructTomcat> lists = logStructTomcatService.pageQueryWarningTomcat(id);
        List<LogStructTomcatDTO> pageList = dozerUtils.mapPage(lists, LogStructTomcatDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    /**
     * 分页查询告警nginx的构化日志列表（nginx）
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "分页查询告警NGINX构化日志", notes = "分页查询告警NGINX结构化日志")
    @RequestMapping(value = "/warn/pageQueryWarningNginx", method = RequestMethod.POST)
    public Result<PageInfo<LogStructNginxDTO>> pageQueryWarningNginx(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq) {
        LogWarningQueryDTO data = openApiReq.getData();
        Long id = data.getId();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructNginx> lists = logStructNginxService.pageQueryWarningNginx(id);
        List<LogStructNginxDTO> pageList = dozerUtils.mapPage(lists, LogStructNginxDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    /**
     * 单个处理告警日志信息
     *
     * @param logWarningUpdateDTO
     * @return
     */
    @ApiOperation(value = "单个处理告警日志", notes = "单个处理告警日志")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "文件id不能为空"),
            @ApiResponse(code = 65006, message = "实体对象未获取到值"),
            @ApiResponse(code = 65500, message = "处理意见不能为空")
    })
    @RequestMapping(value = "/warn/updateWarningDeal", method = RequestMethod.POST)
    public Result<Boolean> updateWarningDeal(@RequestBody LogWarningUpdateDTO logWarningUpdateDTO) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logWarningUpdateDTO);
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, logWarningUpdateDTO.getId());
        BizAssert.assertNotNull(LogsExceptionCode.WARN_RESULT_NULL, logWarningUpdateDTO.getDealResult());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        LogWarning logWarning = new LogWarning();
        logWarning.setId(logWarningUpdateDTO.getId());
        logWarning.setDealResult(logWarningUpdateDTO.getDealResult());
        logWarning.setDealResultDescription(logWarningUpdateDTO.getDealResultDescription());
        logWarning.setUpdateUser(adminId);
        logWarning.setUpdateTime(Calendar.getInstance().getTime());
        logWarning.setUpdateUserName(userName);
        logWarning.setIsDeal("1");
        int i = logWarnSerivce.updateByIdSelective(logWarning);

        UpdateBacklogReqDTO updateBacklogReqDTO = null;
        updateBacklogReqDTO = builderUpdateBacklogReqDTO(logWarning.getId().toString());
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要更新的数据，id：" + logWarningUpdateDTO.getId());
        }
    }
    /**
     * 批量处理告警日志信息
     *
     * @param logWarningUpdateBatchDTO
     * @return
     */
    @ApiOperation(value = "批量处理告警日志", notes = "批量处理告警日志")
    @ApiResponses({
            @ApiResponse(code = 65501, message = "处理记录ids不能为空"),
            @ApiResponse(code = 65006, message = "实体对象未获取到值"),
            @ApiResponse(code = 65500, message = "处理意见不能为空")
    })
    @RequestMapping(value = "/warn/updateWarningDealBatch", method = RequestMethod.POST)
    public Result<Boolean> updateWarningDealBatch(@RequestBody LogWarningUpdateBatchDTO logWarningUpdateBatchDTO) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logWarningUpdateBatchDTO);
        BizAssert.assertNotNull(LogsExceptionCode.WARN_IDS_NULL, logWarningUpdateBatchDTO.getIds());
        BizAssert.assertNotNull(LogsExceptionCode.WARN_RESULT_NULL, logWarningUpdateBatchDTO.getDealResult());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();


        String ids = logWarningUpdateBatchDTO.getIds();
        String[] idArray = ids.split(",");
        List<Long> list = new ArrayList<Long>();
        for(int m=0; m<idArray.length; m++) {
            String id = idArray[m];
            if(id != null && !id.equals("")) {
                list.add(Long.valueOf(id));
            }
        }
        LogWarningExample example = new LogWarningExample();
        example.createCriteria().andIdIn(list);
        List<LogWarning> listWarning = logWarnSerivce.find(example);
        List<LogWarning> listWarningUpdate = new ArrayList<LogWarning>();
        for(int i=0;i<listWarning.size();i++){
            LogWarning logWarning = new LogWarning();
            logWarning = listWarning.get(i);
            logWarning.setDealResult(logWarningUpdateBatchDTO.getDealResult());
            logWarning.setDealResultDescription(logWarningUpdateBatchDTO.getDealResultDescription());
            logWarning.setUpdateUser(adminId);
            logWarning.setUpdateTime(Calendar.getInstance().getTime());
            logWarning.setUpdateUserName(userName);
            logWarning.setIsDeal("1");
            listWarningUpdate.add(logWarning);
        }
        logWarnSerivce.updateByIdSelective(listWarningUpdate);

        //消费消息
        for(int i=0;i<listWarning.size();i++){
            UpdateBacklogReqDTO updateBacklogReqDTO = null;
            updateBacklogReqDTO = builderUpdateBacklogReqDTO(listWarning.get(i).getId().toString());
            msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        }
        return Result.success(true);
    }
       /**
        * 分页查询告警规则
        *
        * @param openApiReq
        * @return
        */
    @ApiOperation(value = "分页查询告警规则", notes = "分页查询告警规则")
    @RequestMapping(value = "/warn/pageQueryWarnRule", method = RequestMethod.POST)
    public Result<PageInfo<LogWarnRuleDTO>> pageQueryWarnRule(@RequestBody OpenApiReq<LogWarnRuleQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }
        LogWarnRuleQueryDTO data = openApiReq.getData();
        LogWarnRuleExample example = new LogWarnRuleExample();
        if(null!=data){
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }

            String warnTypes=data.getWarnType();
            List<String> warnList = new ArrayList();
            if(null!=warnTypes && !"".equals(warnTypes)){
                String[] warnArray = warnTypes.split(",");
                for(int m=0; m<warnArray.length; m++) {
                    String warnType = warnArray[m];
                    if(null!=warnType && !warnType.equals("")) {
                        warnList.add(warnType);
                    }
                }
            }
            String warnLevels=data.getWarnLevel();
            List<String> levelList = new ArrayList();
            if(null!=warnLevels && !"".equals(warnLevels)){
                String[] levelArray = warnLevels.split(",");
                for(int m=0; m<levelArray.length; m++) {
                    String warnLevel = levelArray[m];
                    if(null!=warnLevel && !warnLevel.equals("")) {
                        levelList.add(warnLevel);
                    }
                }
            }

            example.createCriteria()
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                    .andFWarnTypeIn(warnList.size()==0? Arrays.asList(""):warnList)
                    .andFWarnLevelIn(levelList.size()==0? Arrays.asList(""):levelList)
                    .andFNameLike(LogWarnRuleExample.fullLike(data.getName()))
                    .andFWarnDescriptionLike(LogWarnRuleExample.fullLike(data.getWarnDescription()))
            ;

        }else{
            example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogWarnRule> lists = logWarnRuleService.pageQueryWarnRule(example);
        List<LogWarnRuleDTO> pageList = dozerUtils.mapPage(lists, LogWarnRuleDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiOperation(value = "保存告警规则", notes = "保存告警规则")
    @ApiResponses({
            @ApiResponse(code = 65006, message = "实体对象未获取到值")
    })
    @RequestMapping(value = "/warn/saveWarnRule", method = RequestMethod.POST)
    public Result<LogWarnRuleDTO> saveWarnRule(@RequestBody LogWarnRuleSaveDTO logWarnRuleSaveDTO) {
       //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logWarnRuleSaveDTO);

        //2，获取身份
        //String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //3,转换po，并验证
        String appIds = logWarnRuleSaveDTO.getAppId();
        String[] appIdArray = appIds.split(",");
        List<LogWarnRule> logWarnRuleList = new ArrayList<LogWarnRule>();
        for(int i=0;i<appIdArray.length;i++){
            LogWarnRule logWarnRule = dozerUtils.map2(logWarnRuleSaveDTO, LogWarnRule.class);
            logWarnRule.setAppId(appIdArray[i]);
            logWarnRule.setLogType(logWarnRuleSaveDTO.getLogType());
            logWarnRule.setCode(logWarnRuleSaveDTO.getCode());
            logWarnRule.setName(logWarnRuleSaveDTO.getName());
            logWarnRule.setWarnType(logWarnRuleSaveDTO.getWarnType());
            logWarnRule.setWarnLevel(logWarnRuleSaveDTO.getWarnLevel());
            logWarnRule.setWarnDescription(logWarnRuleSaveDTO.getWarnDescription());
            logWarnRule.setKeyContent(logWarnRuleSaveDTO.getKeyContent());
            logWarnRule.setQuantityTimeInterval(logWarnRuleSaveDTO.getQuantityTimeInterval());
            logWarnRule.setQuantityLogLevel(logWarnRuleSaveDTO.getQuantityLogLevel());
            logWarnRule.setQuantityUpperLimit(logWarnRuleSaveDTO.getQuantityUpperLimit());
            logWarnRule.setResponseDuration(logWarnRuleSaveDTO.getResponseDuration());
            logWarnRule.setIsEnable(logWarnRuleSaveDTO.getIsEnable());
            logWarnRule.setIsDelete("0");
            logWarnRule.setCreateTime(Calendar.getInstance().getTime());
            logWarnRule.setCreateUser(adminId);
            logWarnRule.setCreateUserName(userName);
            logWarnRuleList.add(logWarnRule);
        }
        List<LogWarnRule> logWarnRuleListResult = (List<LogWarnRule>) logWarnRuleService.save(logWarnRuleList);
        return Result.success(dozerUtils.map(logWarnRuleListResult.get(0), LogWarnRuleDTO.class));
    }
    @ApiOperation(value = "根据id删除告警规则", notes = "根据id删除告警规则")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "告警规则id不能为空")
    })
    @RequestMapping(value = "/warn/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        int i = logWarnRuleService.deleteById(id);
        if(i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        }else {
            return Result.success(true);
        }
    }
    @ApiOperation(value = "根据ids批量删除告警规则", notes = "根据ids批量删除告警规则")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "告警规则id不能为空")
    })
    @RequestMapping(value = "/warn/deleteBatch", method = RequestMethod.GET)
    public Result<Boolean> deleteBatch(@RequestParam(value = "ids") String ids) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, ids);

        String[] idArray = ids.split(",");
        List<Long> list = new ArrayList<Long>();
        for(int m=0; m<idArray.length; m++) {
            String id = idArray[m];
            if(id != null && !id.equals("")) {
                list.add(Long.valueOf(id));
            }
        }
        int i=logWarnRuleService.deleteByIds(list);
        if(i == 0) {
            return Result.fail("未找到要删除的数据，ids：" + ids);
        }else {
            return Result.success(true);
        }
    }
    @ApiOperation(value = "根据id查询告警规则详情", notes = "根据id查询告警规则详情")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "告警规则id不能为空")
    })
    @RequestMapping(value = "/warn/get", method = RequestMethod.GET)
    public Result<LogWarnRuleDTO> get(@RequestParam(value = "id") Long id) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        LogWarnRule logWarnRule = logWarnRuleService.getById(id);
        return Result.success(dozerUtils.map(logWarnRule, LogWarnRuleDTO.class));
    }
    @ApiOperation(value = "更新告警规则", notes = "更新告警规则")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "告警规则id不能为空")
    })
    @RequestMapping(value = "/warn/updateWarnRule", method = RequestMethod.POST)
    public Result<Boolean> updateWarnRule(@RequestBody LogWarnRuleUpdateDTO logWarnRuleUpdateDTO) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logWarnRuleUpdateDTO);
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, logWarnRuleUpdateDTO.getId());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //3,转换po，并保存
        LogWarnRule logWarnRule = dozerUtils.map(logWarnRuleUpdateDTO, LogWarnRule.class);
        logWarnRule.setAppId(logWarnRuleUpdateDTO.getAppId());
        logWarnRule.setLogType(logWarnRuleUpdateDTO.getLogType());
        logWarnRule.setCode(logWarnRuleUpdateDTO.getCode());
        logWarnRule.setName(logWarnRuleUpdateDTO.getName());
        logWarnRule.setWarnType(logWarnRuleUpdateDTO.getWarnType());
        logWarnRule.setWarnLevel(logWarnRuleUpdateDTO.getWarnLevel());
        logWarnRule.setWarnDescription(logWarnRuleUpdateDTO.getWarnDescription());
        logWarnRule.setKeyContent(logWarnRuleUpdateDTO.getKeyContent());
        logWarnRule.setQuantityLogLevel(logWarnRuleUpdateDTO.getQuantityLogLevel());
        logWarnRule.setIsEnable(logWarnRuleUpdateDTO.getIsEnable());
        logWarnRule.setIsDelete(logWarnRuleUpdateDTO.getIsDelete());
        logWarnRule.setCreateTime(logWarnRuleUpdateDTO.getCreateTime());
        logWarnRule.setCreateUserName(logWarnRuleUpdateDTO.getCreateUserName());
        logWarnRule.setCreateUser(logWarnRuleUpdateDTO.getCreateUser());
        logWarnRule.setQuantityTimeInterval(logWarnRuleUpdateDTO.getQuantityTimeInterval());
        logWarnRule.setQuantityUpperLimit(logWarnRuleUpdateDTO.getQuantityUpperLimit());
        logWarnRule.setResponseDuration(logWarnRuleUpdateDTO.getResponseDuration());
        logWarnRule.setUpdateUser(adminId);
        logWarnRule.setUpdateTime(Calendar.getInstance().getTime());
        logWarnRule.setUpdateUserName(userName);
        int i = logWarnRuleService.updateById(logWarnRule);
        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要更新的数据，id：" + logWarnRuleUpdateDTO.getId());
        }
    }
    @ApiOperation(value = "告警规则可用设置", notes = "告警规则可用设置")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "告警规则id不能为空")
    })
    @RequestMapping(value = "/warn/warnRuleIsAbled", method = RequestMethod.GET)
    public Result<Boolean> warnRuleIsAbled(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        LogWarnRule logWarnRule = logWarnRuleService.getById(id);

        String isAbled = logWarnRule.getIsEnable();
        if(isAbled.equals("0")){
            logWarnRule.setIsEnable("1");
        }else{
            logWarnRule.setIsEnable("0");
        }
        logWarnRule.setUpdateUser(adminId);
        logWarnRule.setUpdateTime(Calendar.getInstance().getTime());
        logWarnRule.setUpdateUserName(userName);
        int i = logWarnRuleService.updateByIdSelective(logWarnRule);
        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要更新的数据，id：" +id);
        }
    }
    @ApiOperation(value = "查看日志保留天数", notes = "查看日志保留天数")
    @RequestMapping(value = "/warn/getSetDay", method = RequestMethod.GET)
    public Result<LogWarnSetDTO> getSetDay() {
        LogWarnSetExample example = new LogWarnSetExample();
        example.createCriteria();
        List<LogWarnSet> logWarnSetList = new ArrayList<LogWarnSet>();
        logWarnSetList  = logWarnSetService.find(example);
        LogWarnSet logWarnSet = new LogWarnSet();
        if(logWarnSetList.size()>0){
            logWarnSet.setFileSaveDays(logWarnSetList.get(0).getFileSaveDays());
            logWarnSet.setWarnSaveDays(logWarnSetList.get(0).getWarnSaveDays());
            logWarnSet.setStructSaveDays(logWarnSetList.get(0).getStructSaveDays());
        }else{
            logWarnSet.setFileSaveDays(logsKeepFile);
            logWarnSet.setWarnSaveDays(logsKeepWarn);
            logWarnSet.setStructSaveDays(logsKeepData);
        }
        return Result.success(dozerUtils.map(logWarnSet, LogWarnSetDTO.class));
    }
    @ApiOperation(value = "设置日志保留天数", notes = "设置日志保留天数")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "告警规则id不能为空")
    })
    @RequestMapping(value = "/warn/updateSetDay", method = RequestMethod.POST)
    public Result<LogWarnSetDTO> updateSetDay(@RequestBody LogWarnSetDTO logWarnSetDTO) {
        //1，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        LogWarnSetExample example = new LogWarnSetExample();
        example.createCriteria();
        List<LogWarnSet> logWarnSetList = new ArrayList<LogWarnSet>();
        logWarnSetList  = logWarnSetService.find(example);
        if(logWarnSetList.size()>0){
            logWarnSetService.deleteById(logWarnSetList.get(0).getId());
        }
        LogWarnSet logWarnSet = new LogWarnSet();
        logWarnSet.setFileSaveDays(logWarnSetDTO.getFileSaveDays());
        logWarnSet.setWarnSaveDays(logWarnSetDTO.getWarnSaveDays());
        logWarnSet.setStructSaveDays(logWarnSetDTO.getStructSaveDays());
        logWarnSet.setCreateTime(Calendar.getInstance().getTime());
        logWarnSet.setCreateUser(adminId);
        logWarnSet.setCreateUserName(userName);
        logWarnSet.setUpdateTime(Calendar.getInstance().getTime());
        logWarnSet.setUpdateUser(adminId);
        logWarnSet.setUpdateUserName(userName);
        logWarnSetService.save(logWarnSet);
        return Result.success(dozerUtils.map(logWarnSet, LogWarnSetDTO.class));
    }
    @ApiOperation(value = "日志保留天数恢复默认设置", notes = "日志保留天数恢复默认设置")
    @RequestMapping(value = "/warn/recover", method = RequestMethod.GET)
    public Result<LogWarnSetDTO> recover() {
        //1，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        LogWarnSetExample example = new LogWarnSetExample();
        example.createCriteria();
        List<LogWarnSet> logWarnSetList = new ArrayList<LogWarnSet>();
        logWarnSetList  = logWarnSetService.find(example);
        if(logWarnSetList.size()>0){
            logWarnSetService.deleteById(logWarnSetList.get(0).getId());
        }
        LogWarnSet logWarnSet = new LogWarnSet();
        logWarnSet.setFileSaveDays(logsKeepFile);
        logWarnSet.setWarnSaveDays(logsKeepWarn);
        logWarnSet.setStructSaveDays(logsKeepData);
        logWarnSet.setCreateTime(Calendar.getInstance().getTime());
        logWarnSet.setCreateUser(adminId);
        logWarnSet.setCreateUserName(userName);
        logWarnSet.setUpdateTime(Calendar.getInstance().getTime());
        logWarnSet.setUpdateUser(adminId);
        logWarnSet.setUpdateUserName(userName);
        logWarnSetService.save(logWarnSet);
        return Result.success(dozerUtils.map(logWarnSet, LogWarnSetDTO.class));
    }
    private UpdateBacklogReqDTO builderUpdateBacklogReqDTO(String id){
        UpdateBacklogReqDTO updateBacklogReqDTO = new UpdateBacklogReqDTO();
       // updateBacklogReqDTO.setReceiveId(null);
        //写死，定时不能从上下文中获取
        updateBacklogReqDTO.setAppId("35kj6356");
        updateBacklogReqDTO.setBizId(id);
        updateBacklogReqDTO.setClientFlag("gxqpt");
        updateBacklogReqDTO.setBizType("add_warn");
        return updateBacklogReqDTO;
    }
    /**
     * 查询日志warn警告总数及当前warn警告数
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findWarnLogCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志warn警告总数及当前warn警告数", notes = "查询日志warn警告总数及当前warn警告数")
    @ApiResponses({

    })
    public Result<Map<String, Integer>> findWarnLogCount() {

        Map<String,Integer> map=new HashMap<String,Integer>();
        LogWarningExample le =new LogWarningExample();
        map.put("warnCount",logWarnService.count(le));
        map.put("currentCount", logWarnService.currentWarnCount());
        Result<Map<String, Integer>> result = Result.success(map, "true");
        return result;
    }
    /**
     * 查询日志warn警告未处理总数
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findWarnNotDealCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志warn警告未处理总数", notes = "查询日志warn警告未处理总数")
    @ApiResponses({

    })
    public Result<Map<String, Integer>> findWarnNotDealCount() {
        Map<String,Integer> map=new HashMap<String,Integer>();
        LogWarningExample le =new LogWarningExample();
        le.createCriteria().andIsDealEqualTo("0");
        map.put("warnNotDealCount",logWarnService.count(le));
        Result<Map<String, Integer>> result = Result.success(map, "true");
        return result;
    }
    /**
     * 查询日志warn警告已处理总数及本月处理总数
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findWarnDealCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志warn警告已处理总数及本月处理总数", notes = "查询日志warn警告已处理总数及本月处理总数")
    @ApiResponses({

    })
    public Result<Map<String, Integer>> findWarnDealCount() {
        Map<String,Integer> map=new HashMap<String,Integer>();
        LogWarningExample le =new LogWarningExample();
        le.createCriteria().andIsDealEqualTo("1");
        map.put("warnDealCount",logWarnService.count(le));
        map.put("currentWarnDealCount",logWarnService.currentWarnDealCount());
        Result<Map<String, Integer>> result = Result.success(map, "true");
        return result;
    }
    /**
     * 查询日志类型数量
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogTypeCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志类型数量", notes = "查询日志类型数量")
    @ApiResponses({

    })
    public Result<LogTypeMap> findLogTypeCount() {
        LogTypeMap lm=new LogTypeMap();
        Map<String, List<LogTypeDO>> warnLogTypeCount = logWarnService.findLogTypeCount();
        lm.setApache(warnLogTypeCount.get("apache"));
        lm.setTomcat(warnLogTypeCount.get("tomcat"));
        lm.setNginx(warnLogTypeCount.get("nginx"));
        lm.setApp(warnLogTypeCount.get("app"));
        Result<LogTypeMap> aTrue = Result.success(lm, "true");
        return aTrue;
    }
    /**
     * 前12月告警数量分析
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findWarnCount", method = RequestMethod.GET)
    @ApiOperation(value = "前12月告警数量分析", notes = "前12月告警数量分析")
    @ApiResponses({

    })
    public Result<List<LogTypeDO>> findWarnCount() {
        List<LogTypeDO> warnCount = logWarnSerivce.findWarnCount();
        Result<List<LogTypeDO>> aTrue = Result.success(warnCount, "true");
        Result<List<ApplicationAllDTO>> allList = applicationApi.findAllList();
        return aTrue;
    }
    /**
     * 统计前20应用告警数量
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findWarnAppName", method = RequestMethod.GET)
    @ApiOperation(value = "统计前20应用告警数量", notes = "统计前20应用告警数量")
    @ApiResponses({

    })
    public Result<List<LogAppNameDO>> findWarnAppName() {
        List<LogAppNameDO> warnAppName = logWarnSerivce.findWarnAppName();
        Result<List<ApplicationAllDTO>> allList = applicationApi.findAllList();
        List<ApplicationAllDTO> data = allList.getData();
        for (ApplicationAllDTO ad:data){
            for (LogAppNameDO ln:warnAppName){
                if(ad.getAppId().equals(ln.getAppId())){
                    ln.setAppName(ad.getName());
                }
            }
        }
        Result<List<LogAppNameDO>> aTrue = Result.success(warnAppName, "true");
        return aTrue;
    }
    /**
     * 查询告警平均处理时间
     */
    @RequestMapping(value = "findWarnAvgTime", method = RequestMethod.GET)
    @ApiOperation(value = "查询告警平均处理时间", notes = "查询告警平均处理时间")
    @ApiResponses({

    })
    public Result<LogWarnAvgTimeDO> findWarnAvgTime() {
        LogWarnAvgTimeDO ltd= logWarnSerivce.findWarnAvgTime();
        Result<LogWarnAvgTimeDO> aTrue = Result.success(ltd, "true");
        return  aTrue;
    }
    @RequestMapping(value = "findLogAvgMonth", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志前十二月每月总数", notes = "查询日志前十二月每月总数")
    @ApiResponses({

    })
    public Result<List<LogTypeDO>> findLogAvgMonth() {
        List<LogTypeDO> ltd= logWarnSerivce.findLogAvgMonth();
        Result<List<LogTypeDO>> aTrue = Result.success(ltd, "true");
        return  aTrue;
    }
    /**
     * 查询日志类型占比
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogTypeRatio", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志类型占比", notes = "查询日志类型占比")
    @ApiResponses({

    })
    public Result< Map<String,Integer>> findLogTypeRatio() {
        Map<String,Integer>  map = new HashMap<>();
        int apache = logStructApacheService.count(new LogStructApacheExample());
        int tomcate = logStructTomcatService.count(new LogStructTomcatExample());
        int nginx = logStructNginxService.count(new LogStructNginxExample());
        int app = logStructAppService.count(new LogStructAppExample());
        map.put("apache",apache);
        map.put("tomcate",tomcate);
        map.put("nginx",nginx);
        map.put("app",app);
        Result<Map<String, Integer>> aTrue = Result.success(map, "true");
        return aTrue;
    }
    /**
     * 查询前十二月日志级别数量
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogLevelMonthCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询前十二月日志级别数量", notes = "查询前十二月日志级别数量")
    @ApiResponses({

    })
    public Result<List<List<LogLevelMonthDO>>> findLogLevelMonthCount() {
        List<List<LogLevelMonthDO>> list= logStructAppService.findLogLevelMonthCount();
        Result<List<List<LogLevelMonthDO>>> aTrue = Result.success(list, "true");
        return aTrue;
    }
    /**
     * 查询前十二月日志响应时间
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogRespondMonth", method = RequestMethod.GET)
    @ApiOperation(value = "查询前十二月日志响应时间", notes = "查询前十二月日志响应时间")
    @ApiResponses({

    })
    public Result<List<LogRespondMonthDO>> findLogRespondMonth() {
        List<LogRespondMonthDO> list= logWarnSerivce.findLogRespondMonth();
        Result<List<LogRespondMonthDO>> aTrue = Result.success(list, "true");
        return aTrue;
    }
    /**
     * 查询前十二月告警数量等级统计
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogWarnMonth", method = RequestMethod.GET)
    @ApiOperation(value = "查询前十二月告警数量等级统计", notes = "查询前十二月告警数量等级统计")
    @ApiResponses({

    })
    public Result<List<List<LogTypeDO>>> findLogWarnMonth() {
        List<List<LogTypeDO>> logWarnMonth = logWarnSerivce.findLogWarnMonth();
        Result<List<List<LogTypeDO>>> aTrue = Result.success(logWarnMonth, "true");
        return aTrue;
    }
    /**
     * 查询告警数量类型统计
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogWarnTypeMonth", method = RequestMethod.GET)
    @ApiOperation(value = "查询告警数量类型统计", notes = "查询告警数量类型统计")
    @ApiResponses({

    })
    public Result<List<LogTypeDO>> findLogWarnTypeMonth() {
        List<LogTypeDO> logWarnMonth = logWarnSerivce.findLogWarnTypeMonth();
        Result<List<LogTypeDO>> aTrue = Result.success(logWarnMonth, "true");
        return aTrue;
    }
    /**
     * 统计告警级别
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogWarnLevleCount", method = RequestMethod.GET)
    @ApiOperation(value = "统计告警级别", notes = "统计告警级别")
    @ApiResponses({

    })
    public Result<List<LogTypeDO>> findLogWarnLevleCount() {
        List<LogTypeDO> logWarnMonth = logWarnSerivce.findLogWarnLevleCount();
        Result<List<LogTypeDO>> aTrue = Result.success(logWarnMonth, "true");
        return aTrue;
    }
    /**
     * 查询日志error警告总数及当前error警告数
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findErrorLogCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志error警告总数及当前error警告数", notes = "查询日志error警告总数及当前error警告数")
    @ApiResponses({

    })
    public Result<Map<String, Integer>> findErrorLogCount() {
        LogStructAppExample lae =new LogStructAppExample();
        lae.createCriteria().andLevelEqualTo("ERROR");
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("errorCount",logStructAppService.count(lae));
        map.put("currentCount", logStructAppService.currentCount());
        Result<Map<String, Integer>> result = Result.success(map, "true");
        return result;
    }

    /**
     * 查询日志error警告每月总数
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findErrorLogMonthCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志error警告每月总数", notes = "查询日志error警告每月总数")
    @ApiResponses({

    })
    public Result<Map<String,  List<LogMonthErrorDO>>> findErrorLogMonthCount() {
        Map<String,List<LogMonthErrorDO>> map=new HashMap<String,List<LogMonthErrorDO>>();
        List<LogMonthErrorDO> ls=logStructAppService.findErrorLogMonthCount();
        map.put("currentCount", ls);
        Result<Map<String,  List<LogMonthErrorDO>>> result = Result.success(map, "true");
        return result;
    }
    /**
     * 查询日志分类数量
     *
     * @param
     * @return
     */
    @RequestMapping(value = "findLogSortCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志分类数量", notes = "查询日志分类数量")
    @ApiResponses({

    })
    public Result< List<LogSortDO>> findLogSortCount() {
        List<LogSortDO> ls=logStructAppService.findLogSortCount();
        Result<List<LogSortDO>> aTrue = Result.success(ls, "true");
        return aTrue;
    }

}
