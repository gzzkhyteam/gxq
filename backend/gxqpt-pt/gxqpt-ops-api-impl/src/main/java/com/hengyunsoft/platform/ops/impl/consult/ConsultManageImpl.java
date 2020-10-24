package com.hengyunsoft.platform.ops.impl.consult;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.OperationExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.ops.consultdto.*;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmInformation;
import com.hengyunsoft.platform.ops.entity.consult.domain.ConsultManageDO;
import com.hengyunsoft.platform.ops.entity.consult.po.ConsultManage;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.entity.person.po.PersonManage;
import com.hengyunsoft.platform.ops.impl.utils.OpsCode;
import com.hengyunsoft.platform.ops.impl.utils.OpsCodeUtil;
import com.hengyunsoft.platform.ops.impl.utils.PushSuperviseTemp;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmInformationService;
import com.hengyunsoft.platform.ops.repository.consult.example.ConsultManageExample;
import com.hengyunsoft.platform.ops.repository.consult.service.ConsultManageService;
import com.hengyunsoft.platform.ops.repository.person.example.DealUserExample;
import com.hengyunsoft.platform.ops.repository.person.service.DealUserService;
import com.hengyunsoft.platform.ops.repository.person.service.PersonService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * com.hengyunsoft.platform.mt.impl.application
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：咨询管理API
 * 修改人：wt
 * 修改时间：2018/7/25
 * 修改内容：
 */
@RestController
@Slf4j
@RequestMapping("consult")
@Api(value = "API - ConsultManageImpl", description = "咨询管理")
public class ConsultManageImpl {

    @Value("${gxqpt.ops-webapp.app-id}")
    private String appId;
    @Value("${gxqpt.ops-webapp.app-secret}")
    private String appSecret;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ConsultManageService consultManageService;
    @Autowired
    private GxqptOrgApi gxqptOrgApi;
    @Autowired
    private DealUserService dealUserService;
    @Autowired
    private PersonService personManageService;
    @Autowired
    private GxqptEmpApi gxqptEmpApi;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    private AlarmInformationService alarmInformationService;
    @Autowired
    private PersonService personService;
    @Autowired
    PushSuperviseTemp pushSuperviseTemp;
    private String dealResult = "false";


    @ApiOperation(value = "保存新增咨询内容", notes = "保存新增咨询内容")
    @ApiResponses({
            @ApiResponse(code = 105020, message = "咨询名称不能为空"),
            @ApiResponse(code = 105021, message = "咨询时间不能为空"),
            @ApiResponse(code = 105022, message = "咨询内容不能为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<ConsultApplySaveReqDTO> saveConsult(@RequestBody ConsultApplySaveReqDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_NAME, saveDTO.getConsultName());
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_TIME, saveDTO.getConsultTime());
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_INFO, saveDTO.getConsultInfo());

        //获取登陆人id,姓名
        Long userId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //保存咨询信息
        ConsultManage consultManage = dozerUtils.map(saveDTO, ConsultManage.class);
        String applyCode = OpsCodeUtil.automaticCode("ZX");
        consultManage.setStatus(1);//默认状态未处理
        consultManage.setCreateUser(userId);
        consultManage.setSubPerson(userName);
        consultManage.setApplyCode(applyCode);
        ConsultManage result = consultManageService.saveSelective(consultManage);
        //推送到统一监管
        pushSuperviseTemp.pushSupervise(consultManage.getId(), new Date(), null, OpsCode.CONSUIT_CODE.getCode(),
                OpsCode.CONSUIT_CODE.getName(), OpsCode.CONSUIT_CODE.getDescribe());

        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(appId);
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(result.getId() + "");
        bbsAllMainMsgDTO.setBizType("ADD_CONSULT");
        bbsAllMainMsgDTO.setBriefTpye("add_consult");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        bbsAllMainMsgDTO.setContent("您有一个" + result.getConsultName() + "咨询申请待审核。");
        bbsAllMainMsgDTO.setTitle("您有一个" + result.getConsultName() + "咨询申请待审核。");
        bbsAllMainMsgDTO.setDetailedType("ADD_CONSULT");
        bbsAllMainMsgDTO.setDetailedTypeDesc("咨询审核");
        bbsAllMainMsgDTO.setHandlerNeedIs(true);
        bbsAllMainMsgDTO.setHandlerUrl("/index.html#/referCheck");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");

        msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, "app_approval", appId);

        return Result.success(dozerUtils.map(result, ConsultApplySaveReqDTO.class));
    }

    @ApiOperation(value = "修改咨询内容", notes = "修改咨询内容")
    @ApiResponses({
            @ApiResponse(code = 105020, message = "咨询ID称不能为空"),
            @ApiResponse(code = 105020, message = "咨询名称不能为空"),
            @ApiResponse(code = 105021, message = "咨询时间不能为空"),
            @ApiResponse(code = 105022, message = "咨询内容不能为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Integer> updateConsult(@RequestBody ConsultApplyUpdateReqDTO dto) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_NAME, dto.getId());
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_NAME, dto.getConsultName());
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_TIME, dto.getConsultTime());
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_INFO, dto.getConsultInfo());

        //获取登陆人id,姓名
        Long userId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //保存咨询信息
        ConsultManage consultManage = dozerUtils.map(dto, ConsultManage.class);
        consultManage.setStatus(1);//恢复状态未处理
        consultManage.setUpdateUser(userId);
        Integer result = consultManageService.updateByIdSelective(consultManage);
        //推送到统一监管
        pushSuperviseTemp.pushSupervise(consultManage.getId(), new Date(), null, OpsCode.CONSUIT_CODE.getCode(),
                OpsCode.CONSUIT_CODE.getName(), OpsCode.CONSUIT_CODE.getDescribe());
        return Result.success(result);
    }


    @ApiOperation(value = "查询当前登陆人咨询分页列表", notes = "查询当前登陆人咨询分页列表")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 105027, message = "分页参数不能为空")
    })
    public Result<PageInfo<ConsultApplyPageDTO>> page(@RequestBody OpenApiReq<ConsultApplyPageReqDTO> openApiReq) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.PAGE_PARAMS, openApiReq);
        Date start = null;
        Date end = null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = openApiReq.getData().getStartTime();
        String endTime = openApiReq.getData().getEndTime();
        String consultName = openApiReq.getData().getConsultName();
        Integer status = openApiReq.getData().getStatus();
        String applyCode = openApiReq.getData().getApplyCode();
        ParsePosition pos = new ParsePosition(0);
        ParsePosition poss = new ParsePosition(0);
        if (startTime != null && startTime != "") {
            start = formatter.parse(startTime, pos);
        }
        if (endTime != null && endTime != "") {
            end = formatter.parse(endTime, poss);
        }
        status = status < 1 ? null : status;

        Long userId = BaseContextHandler.getAdminId();

        Map map = new HashMap<>();
        map.put("startTime", start);
        map.put("endTime", end);
        map.put("status", status);
        map.put("createUser", userId);
        map.put("consultName", consultName);
        map.put("applyCode", applyCode);

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ConsultManageDO> result = consultManageService.getApplyPageList(map);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(result, ConsultApplyPageDTO.class)));
    }


    @ApiOperation(value = "更新咨询评价", notes = "更新咨询评价")
    @ApiResponses({
            @ApiResponse(code = 105023, message = "服务态度不能为空"),
            @ApiResponse(code = 105024, message = "服务效率不能为空"),
            @ApiResponse(code = 105025, message = "服务质量不能为空"),
            @ApiResponse(code = 105026, message = "咨询建议不能为空")
    })
    @RequestMapping(value = "/updateEval", method = RequestMethod.POST)
    public Result<ConsultEvaluateUpdateReqDTO> updateEval(@RequestBody ConsultEvaluateUpdateReqDTO updateDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_ATTITUDE, updateDTO.getServiceAttitude());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_EFFICIENCY, updateDTO.getServiceEfficiency());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_QUALITY, updateDTO.getServiceQuality());
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_ADVICE, updateDTO.getConsultAdvice());

        //更新咨询信息
        Long userId = BaseContextHandler.getAdminId();
        ConsultManage consultManage = dozerUtils.map(updateDTO, ConsultManage.class);
        consultManage.setUpdateUser(userId);
        Long score = (consultManage.getServiceAttitude() +
                consultManage.getServiceEfficiency() +
                consultManage.getServiceQuality()) / 3;
        consultManage.setScore(score);
        consultManage.setScoreTime(new Date());
        consultManageService.updateByIdSelective(consultManage);


        ConsultManageExample example = new ConsultManageExample();
        example.createCriteria().andIdEqualTo(updateDTO.getId());
        ConsultManage cm = consultManageService.getUnique(example);

        DealUserExample dealUserExample = new DealUserExample();
        dealUserExample.createCriteria().andBussIdEqualTo(updateDTO.getId()).andTypeEqualTo("zxr");
        DealUser dealUser = dealUserService.getUnique(dealUserExample);
        //对接消息
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(appId);
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(updateDTO.getId() + "");
        bbsAllMainMsgDTO.setBizType("EVAL_CONSULT");
        bbsAllMainMsgDTO.setBriefTpye("eval_consult");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        bbsAllMainMsgDTO.setContent("您的" + cm.getConsultName() + "咨询已评价。");
        bbsAllMainMsgDTO.setTitle("您的" + cm.getConsultName() + "咨询已评价。");
        bbsAllMainMsgDTO.setDetailedType("EVAL_CONSULT");
        bbsAllMainMsgDTO.setDetailedTypeDesc("咨询评价");
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setHandlerUrl("/index.html#/referHandle");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        List<Long> lookUserIds = new ArrayList<Long>();
        lookUserIds.add(dealUser.getPersonId());

        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
        //修改处理状态
        UpdateBacklogReqDTO updateBacklogReqDTO = new UpdateBacklogReqDTO();
        updateBacklogReqDTO.setReceiveId(null);
        updateBacklogReqDTO.setBizType("EVAL_CONSULT");
        updateBacklogReqDTO.setClientFlag("gxqpt");
        updateBacklogReqDTO.setAppId(appId);
        updateBacklogReqDTO.setBizId(updateDTO.getId() + "");
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);

        return Result.success(dozerUtils.map(consultManage, ConsultEvaluateUpdateReqDTO.class));
    }


    @ApiOperation(value = "查询咨询审批分页列表", notes = "查询咨询审批分页列表")
    @ApiResponses({
            @ApiResponse(code = 105027, message = "分页参数不能为空")
    })
    @RequestMapping(value = "/dealPage", method = RequestMethod.POST)
    public Result<PageInfo<ConsultDealPageDTO>> queryDealPage(@RequestBody OpenApiReq<ConsultDealPageReqDTO> openApiReq) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.PAGE_PARAMS, openApiReq);
        Date start = null;
        Date end = null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = openApiReq.getData().getStartTime();
        String endTime = openApiReq.getData().getEndTime();
        String consultName = openApiReq.getData().getConsultName();
        Integer status = openApiReq.getData().getStatus();
        String subDept = openApiReq.getData().getSubDept();
        String subPerson = openApiReq.getData().getSubPerson();
        String applyCode = openApiReq.getData().getApplyCode();

        ParsePosition pos = new ParsePosition(0);
        ParsePosition poss = new ParsePosition(0);
        if (startTime != null && startTime != "") {
            start = formatter.parse(startTime, pos);
        }
        if (endTime != null && endTime != "") {
            end = formatter.parse(endTime, poss);
        }
        status = status < 1 ? null : status;
        subDept = ("-1".equals(subDept)) ? null : subDept;

        Map map = new HashMap<>();
        map.put("startTime", start);
        map.put("endTime", end);
        map.put("status", status);
        map.put("consultName", BaseExample.fullLike(consultName));
        map.put("subDept", BaseExample.fullLike(subDept));
        map.put("subPerson", BaseExample.fullLike(subPerson));
        map.put("applyCode", BaseExample.fullLike(applyCode));
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ConsultManageDO> result = consultManageService.getDealPageList(map);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(result, ConsultDealPageDTO.class)));
    }

    @ApiOperation(value = "查询咨询处理分页列表", notes = "查询咨询处理分页列表")
    @ApiResponses({
            @ApiResponse(code = 105027, message = "分页参数不能为空")
    })
    @RequestMapping(value = "/handlePage", method = RequestMethod.POST)
    public Result<PageInfo<ConsultDealPageDTO>> queryHandlePage(@RequestBody OpenApiReq<ConsultDealPageReqDTO> openApiReq) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.PAGE_PARAMS, openApiReq);
        Date start = null;
        Date end = null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = openApiReq.getData().getStartTime();
        String endTime = openApiReq.getData().getEndTime();
        String consultName = openApiReq.getData().getConsultName();
        Integer status = openApiReq.getData().getStatus();
        String subDept = openApiReq.getData().getSubDept();
        String subPerson = openApiReq.getData().getSubPerson();
        String applyCode = openApiReq.getData().getApplyCode();

        ParsePosition pos = new ParsePosition(0);
        ParsePosition poss = new ParsePosition(0);
        if (startTime != null && startTime != "") {
            start = formatter.parse(startTime, pos);
        }
        if (endTime != null && endTime != "") {
            end = formatter.parse(endTime, poss);
        }
        status = status < 1 ? null : status;
        subDept = ("-1".equals(subDept)) ? null : subDept;
        Long userId = BaseContextHandler.getAdminId();
        UserTokenExtInfo userTokenExtInfo = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
        String currAppId = BaseContextHandler.getAppId();
        boolean isAdmin = userTokenExtInfo.isAppAdmin(currAppId);

        Map map = new HashMap<>();
        map.put("startTime", start);
        map.put("endTime", end);
        map.put("status", status);
        map.put("subDept", BaseExample.fullLike(subDept));
        map.put("consultName", BaseExample.fullLike(consultName));
        map.put("subPerson", BaseExample.fullLike(subPerson));
        map.put("applyCode", BaseExample.fullLike(applyCode));
        map.put("personId", userId);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ConsultManageDO> list = consultManageService.getHandlePageList(map);
        for (ConsultManageDO dto : list) {
            if (isAdmin) {
                dto.setIsAdminRole(true);
            } else {
                dto.setIsAdminRole(false);
            }
        }
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ConsultDealPageDTO.class)));
    }


    @ApiOperation(value = "根据id查询咨询详情", notes = "根据id查询咨询详情")
    @ApiResponses({
            @ApiResponse(code = 105028, message = "咨询ID不能为空")
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<ConsultDetailDTO> get(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_ID, id);
        ConsultManage consultManage = consultManageService.getById(id);
        ConsultDetailDTO dto = new ConsultDetailDTO();
        dto.setConsultName(consultManage.getConsultName());
        dto.setConsultTime(consultManage.getConsultTime());
        dto.setConsultInfo(consultManage.getConsultInfo());
        dto.setDealResult(consultManage.getDealResult());
        dto.setDealOpinion(consultManage.getDealOpinion());
        dto.setServiceAttitude(consultManage.getServiceAttitude());
        dto.setServiceEfficiency(consultManage.getServiceEfficiency());
        dto.setServiceQuality(consultManage.getServiceQuality());
        dto.setConsultAdvice(consultManage.getConsultAdvice());

        //获取咨询人
        List<DealUser> users = dealUserService.getByBussId(id);
        if (users != null && users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                if ("zxr".equals(users.get(i).getType())) {
                    DealUser dealUser = users.get(i);
                    dto.setConsultPerson(dealUser.getPersonName());
                    //添加获取咨询人相关信息
                    Long[] ids = {Long.valueOf(dealUser.getPersonId())};
                    log.info("咨询管理 ids=", ids);
                    Result<List<GxqptEmpRetDTO>> renyuan = gxqptEmpApi.findByIdsGxqptYw(ids);
                    List<GxqptEmpRetDTO> emps = renyuan.getData();
                    log.info("咨询管理 emps=", JSON.toJSON(emps));
                    if (emps != null && emps.size() != 0) {
                        PersonManage personManage = personService.getById(dealUser.getPersonId());
                        if (personManage != null) {
                            dto.setTel(personManage.getMainmobile());
                        }
                        dto.setJob(emps.get(0).getMaindutyname());
                    }
                    //工作类容
                    PersonManage pm = personManageService.getById(dealUser.getPersonId());
                    if (pm != null) {
                        dto.setWorkInfo(pm.getContent());
                    }
                    users.remove(users.get(i));
                }
            }
        }

        //获取协助人姓名
        List<String> helps = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            helps.add(users.get(i).getPersonName());
        }
        dto.setHelpPerson(helps);

        return Result.success(dto);
    }


    @ApiOperation(value = "处理咨询", notes = "处理咨询")
    @ApiResponses({@ApiResponse(code = 105026, message = "处理结果不能为空")})
    @RequestMapping(value = "/deal", method = RequestMethod.POST)
    public Result<ConsultManage> saveDeal(@RequestBody ConsultDealReqDTO dealDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.DEAL_RESULT, dealDTO.getDealResult());

        //更新咨询结果
        Long userId = BaseContextHandler.getAdminId();
        ConsultManage consultManage = consultManageService.getById(dealDTO.getId());
        consultManage.setUpdateUser(userId);
        consultManage.setId(dealDTO.getId());
        consultManage.setDealResult(dealDTO.getDealResult());
        consultManage.setDealOpinion(dealDTO.getDealOpinion());
        if ("false".equals(dealDTO.getDealResult())) {
            //状态改为已驳回
            consultManage.setStatus(3);
            consultManageService.updateByIdSelective(consultManage);
        } else {
            //状态改为已处理
            consultManage.setStatus(2);
            consultManageService.updateByIdSelective(consultManage);

            //保存处理人员信息
            List<DealUserDTO> list = dealDTO.getDealUser();
            List<DealUser> dealList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (DealUserDTO dto : list) {
                    DealUser user = dozerUtils.map(dto, DealUser.class);
                    user.setCreateUser(userId);
                    user.setUpdateUser(userId);
                    dealList.add(user);
                }
            }
            dealUserService.save(dealList);
        }
        List<Long> zxrList = null;
        List<Long> xzrList = null;
        ConsultManageExample example = new ConsultManageExample();
        example.createCriteria().andIdEqualTo(dealDTO.getId());
        ConsultManage cm = consultManageService.getUnique(example);
        List<Long> createUser = new ArrayList<Long>();
        createUser.add(cm.getCreateUser());
        if ("false".equals(dealDTO.getDealResult())) {
            zxrList = new ArrayList<Long>();
            zxrList.add(cm.getCreateUser());

            //对接消息
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setAppId(appId);
            bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
            bbsAllMainMsgDTO.setBizId(dealDTO.getId() + "");
            bbsAllMainMsgDTO.setBizType("HANDLE_CONSULT");
            bbsAllMainMsgDTO.setBriefTpye("handle_consult");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setSingleHandleIs(true);
            bbsAllMainMsgDTO.setContent("您的" + cm.getConsultName() + "已被驳回。");
            bbsAllMainMsgDTO.setTitle("您的" + cm.getConsultName() + "已被驳回。");
            bbsAllMainMsgDTO.setDetailedType("HANDLE_CONSULT");
            bbsAllMainMsgDTO.setDetailedTypeDesc("咨询申请");
            bbsAllMainMsgDTO.setHandlerNeedIs(true);
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/referHandle");
            bbsAllMainMsgDTO.setSenderName("系统自动通知");
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, createUser, null);
        } else {
            zxrList = new ArrayList<Long>();
            xzrList = new ArrayList<Long>();
            for (DealUserDTO dto : dealDTO.getDealUser()) {
                if ("zxr".equals(dto.getType())) {
                    zxrList.add(dto.getPersonId());
                } else {
                    xzrList.add(dto.getPersonId());
                }
            }
            //对接消息
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setAppId(appId);
            bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
            bbsAllMainMsgDTO.setBizId(dealDTO.getId() + "");
            bbsAllMainMsgDTO.setBizType("HANDLE_CONSULT");
            bbsAllMainMsgDTO.setBriefTpye("handle_consult");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setSingleHandleIs(true);
            bbsAllMainMsgDTO.setContent("您有一个" + cm.getConsultName() + "咨询申请待处理。");
            bbsAllMainMsgDTO.setTitle("您有一个" + cm.getConsultName() + "咨询申请待处理。");
            bbsAllMainMsgDTO.setDetailedType("HANDLE_CONSULT");
            bbsAllMainMsgDTO.setDetailedTypeDesc("咨询处理");
            bbsAllMainMsgDTO.setHandlerNeedIs(true);
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/referHandle");
            bbsAllMainMsgDTO.setSenderName("系统自动通知");
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, xzrList, zxrList);
            String msg = "您的" + cm.getConsultName() + "咨询申请已审批通过。";
            bbsAllMainMsgDTO.setContent(msg);
            bbsAllMainMsgDTO.setTitle(msg);
            bbsAllMainMsgDTO.setDetailedTypeDesc("咨询申请");
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, createUser, null);
            //修改处理状态
            UpdateBacklogReqDTO updateBacklogReqDTO = new UpdateBacklogReqDTO();
            updateBacklogReqDTO.setReceiveId(null);
            updateBacklogReqDTO.setBizType("HANDLE_CONSULT");
            updateBacklogReqDTO.setClientFlag("gxqpt");
            updateBacklogReqDTO.setAppId(appId);
            updateBacklogReqDTO.setBizId(dealDTO.getId() + "");
            msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        }
        if (consultManage.getApplyCode() != null) {
            AlarmInformationExample informationExample = new AlarmInformationExample();
            informationExample.createCriteria().andApplyCodeEqualTo(consultManage.getApplyCode()).andApplyTypeEqualTo("consult_audit");
            List<AlarmInformation> informationList = alarmInformationService.find(informationExample);
            if (informationList != null && informationList.size() > 0) {
                for (AlarmInformation information : informationList) {
                    information.setStatus(2);
                    information.setUpdateUser(userId);
                    alarmInformationService.updateByIdSelective(information);
                }
            }
        }
        //推送到统一监管-结束审批
        pushSuperviseTemp.pushSupervise(consultManage.getId(), new Date(), new Date(), OpsCode.CONSUIT_CODE.getCode(),
                OpsCode.CONSUIT_CODE.getName(), OpsCode.CONSUIT_CODE.getDescribe());

        //推送到统一监管-处理申请
        if (!dealResult.equals(dealDTO.getDealResult())) {
            pushSuperviseTemp.pushSupervise(consultManage.getId(), new Date(), null, OpsCode.CONSUIT_DEAL_APPLY_CODE.getCode(),
                    OpsCode.CONSUIT_DEAL_APPLY_CODE.getName(), OpsCode.CONSUIT_DEAL_APPLY_CODE.getDescribe());
        }
        return Result.success(consultManage);
    }

    @ApiOperation(value = "完结咨询", notes = "完结咨询")
    @ApiResponses({@ApiResponse(code = 105028, message = "咨询ID不能为空")})
    @RequestMapping(value = "/over", method = RequestMethod.GET)
    public Result<Integer> saveOver(Long id) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.CONSULT_ID, id);

        //更新咨询结果
        Long userId = BaseContextHandler.getAdminId();
        ConsultManage consultManage = new ConsultManage();
        consultManage.setId(id);
        consultManage.setUpdateUser(userId);
        //状态改为已完结
        consultManage.setStatus(4);
        Integer result = consultManageService.updateByIdSelective(consultManage);

        ConsultManageExample example = new ConsultManageExample();
        example.createCriteria().andIdEqualTo(id);
        ConsultManage cm = consultManageService.getUnique(example);
        //对接消息
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(appId);
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(id + "");
        bbsAllMainMsgDTO.setBizType("OVER_CONSULT");
        bbsAllMainMsgDTO.setBriefTpye("over_consult");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
        bbsAllMainMsgDTO.setContent("您有一条" + cm.getConsultName() + "咨询已处理，请尽快评价。");
        bbsAllMainMsgDTO.setTitle("您有一条" + cm.getConsultName() + "咨询已处理，请尽快评价。");
        bbsAllMainMsgDTO.setDetailedType("OVER_CONSULT");
        bbsAllMainMsgDTO.setDetailedTypeDesc("咨询评价");
        bbsAllMainMsgDTO.setHandlerNeedIs(true);
        bbsAllMainMsgDTO.setHandlerUrl("/index.html#/referApply");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        List<Long> handlerUserIds = new ArrayList<Long>();
        handlerUserIds.add(cm.getCreateUser());

        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, null, handlerUserIds);

        //修改处理状态
        UpdateBacklogReqDTO updateBacklogReqDTO = new UpdateBacklogReqDTO();
        updateBacklogReqDTO.setReceiveId(null);
        updateBacklogReqDTO.setBizType("OVER_CONSULT");
        updateBacklogReqDTO.setClientFlag("gxqpt");
        updateBacklogReqDTO.setAppId(appId);
        updateBacklogReqDTO.setBizId(id + "");
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        if (consultManage.getApplyCode() != null) {
            AlarmInformationExample informationExample = new AlarmInformationExample();
            informationExample.createCriteria().andApplyCodeEqualTo(consultManage.getApplyCode()).andApplyTypeEqualTo("consult_deal");
            List<AlarmInformation> informationList = alarmInformationService.find(informationExample);
            if (informationList != null && informationList.size() > 0) {
                for (AlarmInformation information : informationList) {
                    information.setUpdateUser(userId);
                    information.setStatus(2);
                    alarmInformationService.updateByIdSelective(information);
                }
            }
        }
        //推送到统一监管
        pushSuperviseTemp.pushSupervise(consultManage.getId(), new Date(), new Date(), OpsCode.CONSUIT_DEAL_APPLY_CODE.getCode(),
                OpsCode.CONSUIT_DEAL_APPLY_CODE.getName(), OpsCode.CONSUIT_DEAL_APPLY_CODE.getDescribe());
        return Result.success(result);
    }

}
