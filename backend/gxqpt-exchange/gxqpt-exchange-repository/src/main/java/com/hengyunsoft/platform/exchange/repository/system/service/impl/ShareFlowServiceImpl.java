package com.hengyunsoft.platform.exchange.repository.system.service.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlow;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowAudit;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowHiTask;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowTask;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowAuditMapper;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowHiTaskMapper;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowMapper;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowTaskMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowService;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.PowerSuperviseTempApi;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wgj
 * @todo 流程引擎service
 * @createtime 2018-4-22
 */
@Service
@Slf4j
public class ShareFlowServiceImpl extends BaseAllServiceImpl<Long, ShareFlow, ShareFlowExample> implements ShareFlowService {
    @Autowired
    IdGenerate<Long> idGenerate;
    @Autowired
    ShareFlowMapper shareFlowMapper;
    @Autowired
    ShareFlowTaskMapper shareFlowTaskMapper;
    @Autowired
    ShareFlowHiTaskMapper shareFlowHiTaskMapper;
    @Autowired
    ShareFlowAuditMapper shareFlowAuditMapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    private PowerSuperviseTempApi powerSuperviseTempApi;
    /**
     * 平台管理员编码
     */
    public static final String PT_ADMIN_ROLE_CODE = "gxq_pt_admin";
    /**
     * 单位管理员
     */
    public static final String ORG_ADMIN_DATA_ROLE_CODE = "org_admin";


    @Override
    protected BaseNormalDao<Long, ShareFlow, ShareFlowExample> getDao() {
        return shareFlowMapper;
    }

    /**
     * 根据流程编号查询流程信息
     *
     * @param procCode
     * @return
     * @createtime 2018-4-22
     */
    @Override
    public ShareFlow getByFlowKey(String procCode) {
        return shareFlowMapper.getByFlowKey(procCode);
    }

    /**
     * @param applyCode 申请编号
     * @param procCode  流程编号
     * @param userId    申请用户id
     * @param unitId    单位id
     * @return boolean
     * @todo 启动流程
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    @ApiOperation(value = "启动流程", notes = "启动流程")
    public Result<Boolean> saveStartFlow(Integer type, String applyCode, String procCode, Long userId, String unitId) {
        //查询流程信息
        ShareFlow flow = shareFlowMapper.getByFlowKey(procCode);
        if (StringUtils.isEmpty(procCode) || StringUtils.isEmpty(applyCode) || flow == null) {
            return Result.fail("false");
        }
        //添加待办任务数据
        ShareFlowTask task = new ShareFlowTask();
        task.setId(idGenerate.generate());
        task.setApplyCode(applyCode);
        task.setProcCode(procCode);
        task.setProcName(flow.getProcName());
        task.setNodeCode(flow.getNodeCode());
        task.setNodeCode(flow.getNodeCode());
        task.setHandleRole(flow.getHandleRole());
        task.setStartTime(new Date());
        task.setCreateTime(new Date());
        task.setCreateUser(userId);
        task.setUpdateTime(new Date());
        task.setUpdateUser(userId);
        task.setUnitId(unitId);
        shareFlowTaskMapper.insertSelective(task);

        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
        String appId = BaseContextHandler.getAppId();
        String unitName = commonService.getOrgNameByUnitId(unitId);
        if (type.equals(1)) {
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, task.getId(), "目录发布申请", unitName);
            msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, PT_ADMIN_ROLE_CODE, appId);
        } else if (type.equals(2)) {
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, task.getId(), "数据集申请", unitName);
            msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, ORG_ADMIN_DATA_ROLE_CODE, appId);
        } else if (type.equals(3)) {
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, task.getId(), "共享申请", unitName);
            msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, ORG_ADMIN_DATA_ROLE_CODE, appId);
        } else if (type.equals(4)) {
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, task.getId(), "需求申请", unitName);
            msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, ORG_ADMIN_DATA_ROLE_CODE, appId);
        }
        //推送到统一监管
        PowerSupervise superviseType = PowerSupervise.getPowerSupervise(type);
        PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
        sts.setBizId(task.getId());
        sts.setStartTime(task.getStartTime());
        sts.setCode(superviseType.code);
        sts.setDesc(superviseType.desc);
        sts.setName(superviseType.name);
        sts.setAppId(BaseContextHandler.getAppId());
        sts.setAppName(BaseContextHandler.getAppName());
        Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
        log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());

        return Result.success(true);
    }

    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(Integer type, Long id, String moduleName, String unitName) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(id.toString());
        bbsAllMainMsgDTO.setBizType("add_module");
        bbsAllMainMsgDTO.setBriefTpye("work_auth");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        bbsAllMainMsgDTO.setContent("您有一条来自于" + unitName + "的" + moduleName + "待审核.");
        bbsAllMainMsgDTO.setTitle(moduleName + "功能待审核");

        bbsAllMainMsgDTO.setDetailedType("module_add_apply");
        bbsAllMainMsgDTO.setHandlerNeedIs(true);
        if (type.equals(1)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("目录审核");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/catalogAuditList");
        } else if (type.equals(2)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("数据集审核");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/dataSetApplyList");
        } else if (type.equals(3)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("共享审核");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/shareExamineList");
        } else if (type.equals(4)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("需求审核");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/demandExamineList");
        }
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }

    /**
     * @param taskId 任务id
     * @param status 流程状态 1,通过；2，驳回
     * @param userId 申请用户id
     * @return boolean
     * @todo 流程审批
     * @Param content 审批意见
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    @ApiOperation(value = "流程审批", notes = "流程审批")
    public Result<Boolean> updateWorkFlow(Integer type, Long taskId, Long userId, Integer status, String content) {
        ShareFlowTask task = shareFlowTaskMapper.selectByPrimaryKey(taskId);
        String loginUserName = BaseContextHandler.getName();

        //添加历史任务
        ShareFlowHiTask histask = new ShareFlowHiTask();
        histask.setId(idGenerate.generate());
        histask.setApplyCode(task.getApplyCode());
        histask.setProcCode(task.getProcCode());
        histask.setProcName(task.getProcName());
        histask.setNodeCode(task.getNodeCode());
        histask.setNodeCode(task.getNodeCode());
        histask.setUserId(userId);
        histask.setUserName(loginUserName);
        histask.setStartTime(task.getStartTime());
        histask.setEndTime(new Date());
        histask.setTimeLimit(gethours(task.getStartTime(), new Date()));
        histask.setCreateTime(new Date());
        histask.setCreateUser(userId);
        histask.setUpdateTime(new Date());
        histask.setUpdateUser(userId);
        shareFlowHiTaskMapper.insertSelective(histask);
        //添加审批信息
        ShareFlowAudit audit = new ShareFlowAudit();
        audit.setApplyCode(task.getApplyCode());
        audit.setProcCode(task.getProcCode());
        audit.setNodeCode(task.getNodeCode());
        audit.setNodeCode(task.getNodeCode());
        audit.setUserId(userId);
        audit.setUserName(loginUserName);
        audit.setAuditTime(new Date());
        audit.setStatus(status);
        audit.setContent(content);
        audit.setCreateTime(new Date());
        audit.setCreateUser(userId);
        audit.setUpdateTime(new Date());
        audit.setUpdateUser(userId);
        audit.setId(idGenerate.generate());

        //删除待办任务数据
        shareFlowAuditMapper.insertSelective(audit);
        //shareFlowTaskMapper.deleteByPrimaryKey(taskId);
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;

        List<Long> lookUserIds = new ArrayList<>(1);
        lookUserIds.add(task.getCreateUser());
        if (type.equals(1)) {
            if (status == 1) {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "目录发布申请", true);
            } else {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "目录发布申请", false);
            }
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
            //更新自己受到的审批消息未已经出了
            UpdateBacklogReqDTO updateBacklogReqDTO = createUpdateBacklogReqDTO(type, task.getId(), userId);
            msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        } else if (type.equals(2)) {
            if (status == 1) {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "数据集申请", true);
            } else {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "数据集申请", false);
            }
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
            //更新自己受到的审批消息未已经出了
            UpdateBacklogReqDTO updateBacklogReqDTO = createUpdateBacklogReqDTO(type, task.getId(), userId);
            msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        } else if (type.equals(3)) {
            if (status == 1) {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "共享申请", true);
            } else {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "共享申请", false);
            }
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
            //更新自己受到的审批消息未已经出了
            UpdateBacklogReqDTO updateBacklogReqDTO = createUpdateBacklogReqDTO(type, task.getId(), userId);
            msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        } else if (type.equals(4)) {
            if (status == 1) {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "需求申请", true);
            } else {
                bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(type, audit.getId(), "需求申请", false);
            }
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
            //更新自己受到的审批消息未已经出了
            UpdateBacklogReqDTO updateBacklogReqDTO = createUpdateBacklogReqDTO(type, task.getId(), userId);
            msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
        }

        //推送到统一监管
        PowerSupervise superviseType = PowerSupervise.getPowerSupervise(type);
        PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
        sts.setBizId(task.getId());
        sts.setStartTime(task.getStartTime());
        sts.setEndTime(histask.getEndTime());
        sts.setCode(superviseType.code);
        sts.setDesc(superviseType.desc);
        sts.setName(superviseType.name);
        sts.setAppId(BaseContextHandler.getAppId());
        sts.setAppName(BaseContextHandler.getAppName());
        Result<PowerSuperviseTempSaveDTO> save = powerSuperviseTempApi.save(sts);
        log.info("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        return Result.success(true);
    }

    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(Integer type, Long id, String moduleName, boolean pass) {
        Long loginUserId = BaseContextHandler.getAdminId();
        String longinUnitId = commonService.getOrgIdByUserId(loginUserId);
        String unitName = commonService.getOrgNameByUnitId(longinUnitId);
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(id.toString());
        bbsAllMainMsgDTO.setBizType("add_module");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setBriefTpye("work_auth");
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        if (pass) {
            if (type.equals(1) || type.equals(2)) {
                bbsAllMainMsgDTO.setContent("您的" + moduleName + "已审批通过");
                bbsAllMainMsgDTO.setTitle("您的" + moduleName + "审批已通过");
            } else {
                bbsAllMainMsgDTO.setContent("您向" + unitName + "提出的" + moduleName + "已审批通过");
                bbsAllMainMsgDTO.setTitle("您向" + unitName + "提出的" + moduleName + "已审批通过");
            }
        } else {
            if (type.equals(1) || type.equals(2)) {
                bbsAllMainMsgDTO.setContent("您的" + moduleName + "已被驳回");
                bbsAllMainMsgDTO.setTitle("您的" + moduleName + "已被驳回");
            } else {
                bbsAllMainMsgDTO.setContent("您向" + unitName + "提出的" + moduleName + "已被驳回");
                bbsAllMainMsgDTO.setTitle("您向" + unitName + "提出的" + moduleName + "已被驳回");
            }
        }

        bbsAllMainMsgDTO.setDetailedType("module_add_apply");
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        if (type.equals(1)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("目录申请");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/applyList");
        } else if (type.equals(2)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("数据集申请");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/dataSetManageList");
        } else if (type.equals(3)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("共享申请");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/shareMagApplyList");
        } else if (type.equals(4)) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("需求申请");
            bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/shareMagDemandList");
        }
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }

    /***
     * 创建更新消息实体
     * @param apprId
     * @return
     */
    public static UpdateBacklogReqDTO createUpdateBacklogReqDTO(Integer type, Long apprId, Long receiveId) {
        String appId = BaseContextHandler.getAppId();
        //String appName = BaseContextHandler.getAppName();
        UpdateBacklogReqDTO update = new UpdateBacklogReqDTO();
        update.setAppId(appId);
        update.setBizId(String.valueOf(apprId));
        update.setClientFlag("gxqpt");
        if (type == 1) {
            update.setBizType("数据目录申请");
        } else if (type == 2) {
            update.setBizType("数据集申请");
        } else if (type == 3) {
            update.setBizType("共享申请");
        } else if (type == 4) {
            update.setBizType("需求申请");
        }

        update.setReceiveId(receiveId);
        return update;
    }

    public static Float gethours(Date startDate, Date endTime) {
        try {
            long result = endTime.getTime() - startDate.getTime();
            double t = result / 3600000;
            BigDecimal b = new BigDecimal(t);
            Float hours = b.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .floatValue();
            return hours;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Float.valueOf(0);
    }

    enum PowerSupervise {
        DIR_RELEASE_ONE(1, "DIR_RELEASE_ONE", "审批", "共享交换目录发布"),
        SET_PUT_ONE(2, "SET_PUT_ONE", "审批", "共享交换数据集上架"),
        REQT_RELEASE_ONE(3, "REQT_RELEASE_ONE", "审批", "共享交换发布需求"),
        API_APPLY_ONE(4, "API_APPLY_ONE", "审批", "共享交换API申请"),
        API_RENEWAL_ONE(5, "API_RENEWAL_ONE", "审批", "共享交换API续期申请"),;
        int flowType;
        String code;
        String name;
        String desc;

        PowerSupervise(int flowType, String code, String name, String desc) {
            this.flowType = flowType;
            this.code = code;
            this.desc = desc;
            this.name = name;
        }

        public static PowerSupervise getPowerSupervise(int flowType) {
            for (PowerSupervise ps : values()) {
                if (ps.flowType == flowType) {
                    return ps;
                }
            }
            return null;
        }
    }
}

