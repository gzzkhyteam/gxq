package com.hengyunsoft.platform.logs.warns;


import com.hengyunsoft.commons.constant.RoleCode;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.logs.dto.LogCommonDTO;
import com.hengyunsoft.platform.logs.dto.LogIdDTO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnRule;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarning;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarningStruct;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarningStructSerivce;
import com.hengyunsoft.platform.logs.utils.RedisUtils;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
@Slf4j
public abstract class LogRuleBaseMonitor implements Serializable {

    private LogWarnService logWarnSerivce;
    private LogWarningStructSerivce logWarningStructSerivce;
    private BbbMsgQueueProducer msgQueueProducer;

    public abstract void put(LogCommonDTO logCommonDTO,RedisUtils redisUtil);

    /**
     * 该条日志是否适用于这条规则。比如KEY 只适用于APP。如果适用，判断是否在预警规则范围内。
     * @param logCommonDTO
     * @return
     */
    public abstract boolean filter(LogCommonDTO logCommonDTO);


    public abstract boolean checkInvalidate(LogCommonDTO logCommonDTO);

    public abstract boolean trigWarn(LogCommonDTO logCommonDTO) ;

    public void sendWarn(LogCommonDTO logCommonDTO, LogWarnRule rule){
        if(logWarnSerivce == null) {
            logWarnSerivce = SpringUtil.getBean(LogWarnService.class);
        }
        if(logWarningStructSerivce == null) {
            logWarningStructSerivce = SpringUtil.getBean(LogWarningStructSerivce.class);
        }
        if(msgQueueProducer == null) {
            msgQueueProducer = SpringUtil.getBean(BbbMsgQueueProducer.class);
        }
        //1，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        LogWarning logWarning =new LogWarning();
        logWarning.setAppId(rule.getAppId());
        logWarning.setLogType(logCommonDTO.getLogType());
        logWarning.setRuleId(rule.getId());
        logWarning.setLogDescription(rule.getWarnDescription());
        logWarning.setIsDeal("0");
        logWarning.setCreateTime(Calendar.getInstance().getTime());
        logWarning.setCreateUser(adminId);
        logWarning.setCreateUserName(userName);
        logWarnSerivce.save(logWarning);



        LogWarningStruct logWarningStruct =new LogWarningStruct();
        logWarningStruct.setLogStructId(logCommonDTO.getId());
        logWarningStruct.setLogType(logCommonDTO.getLogType());
        logWarningStruct.setLogWarningId(logWarning.getId());
        logWarningStructSerivce.save(logWarningStruct);

        //发送消息
        BbsAllMainMsgDTO bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(logWarning,logCommonDTO.getLogType());
        msgQueueProducer.saveHandlerMsgToRole(bbsAllMainMsgDTO, RoleCode.APPLICATION_ADMIN_CODE, rule.getAppId());
    }

    public void sendWarnQuantity(LogCommonDTO logCommonDTO, LogWarnRule rule,List<LogIdDTO> list){
        if(logWarnSerivce == null) {
            logWarnSerivce = SpringUtil.getBean(LogWarnService.class);
        }
        if(logWarningStructSerivce == null) {
            logWarningStructSerivce = SpringUtil.getBean(LogWarningStructSerivce.class);
        }
        if(msgQueueProducer == null) {
            msgQueueProducer = SpringUtil.getBean(BbbMsgQueueProducer.class);
        }
        //1，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        LogWarning logWarning =new LogWarning();
        logWarning.setAppId(rule.getAppId());
        logWarning.setLogType(logCommonDTO.getLogType());
        logWarning.setRuleId(rule.getId());
        logWarning.setLogDescription(rule.getWarnDescription());
        logWarning.setIsDeal("0");
        logWarning.setCreateTime(Calendar.getInstance().getTime());
        logWarning.setCreateUser(adminId);
        logWarning.setCreateUserName(userName);
        logWarnSerivce.save(logWarning);

        List<LogWarningStruct> logWarningStructList =new ArrayList<LogWarningStruct>();
        for(int i=0;i<list.size();i++){
            LogWarningStruct logWarningStruct =new LogWarningStruct();
            logWarningStruct.setLogStructId(list.get(i).getId());
            logWarningStruct.setLogType(logCommonDTO.getLogType());
            logWarningStruct.setLogWarningId(logWarning.getId());
            logWarningStructList.add(logWarningStruct);
        }
        logWarningStructSerivce.save(logWarningStructList);
        //发送消息
        BbsAllMainMsgDTO bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(logWarning,logCommonDTO.getLogType());
        msgQueueProducer.saveHandlerMsgToRole(bbsAllMainMsgDTO, RoleCode.APPLICATION_ADMIN_CODE, rule.getAppId());
    }

    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(LogWarning logWarning,String logType) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();

        bbsAllMainMsgDTO.setAppId("35kj6356");
        bbsAllMainMsgDTO.setAppName("日志管理系统");
        bbsAllMainMsgDTO.setBizId(logWarning.getId().toString());
        bbsAllMainMsgDTO.setBizType("add_warn");
        bbsAllMainMsgDTO.setBriefTpye("work_audit");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
        bbsAllMainMsgDTO.setContent("您有一条"+logType+"日志预警待处理。");
        bbsAllMainMsgDTO.setTitle("日志告警");
        bbsAllMainMsgDTO.setDetailedType("logs_add_warning");
        bbsAllMainMsgDTO.setDetailedTypeDesc("日志告警");
        bbsAllMainMsgDTO.setHandlerNeedIs(true);
        bbsAllMainMsgDTO.setHandlerUrl("/module/index?promUrl=/gxqpt-logs/logs/waringList");
      //  bbsAllMainMsgDTO.setHandlerParams("moduleName=");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }

}
