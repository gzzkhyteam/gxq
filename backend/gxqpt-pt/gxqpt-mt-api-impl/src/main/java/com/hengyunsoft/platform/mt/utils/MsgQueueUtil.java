package com.hengyunsoft.platform.mt.utils;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;

/***
 * 消息发送工具类
 */
public class MsgQueueUtil {
    /***
     * 创建发送消息dto
     * @param apprId
     * @param sendUserName
     * @param title
     * @param context
     * @return
     */
    public static BbsAllMainMsgDTO createBbsAllMainMsgDTO(Long apprId, String sendUserName, String title, String context) {
        String appId = BaseContextHandler.getAppId();
        String appName = BaseContextHandler.getAppName();
        BbsAllMainMsgDTO dto = new BbsAllMainMsgDTO();

        dto.setBizId(String.valueOf(apprId));
        dto.setBizType("考勤审批");
        dto.setBriefTpye("attendance_audit");
        dto.setAppId(appId);
        dto.setAppName(appName);
        dto.setClientFlag("gxqpt");
        dto.setContent(context);//内容
        dto.setTitle(title);//
        dto.setDetailedType("attendance_audit");
        dto.setDetailedTypeDesc("考勤审批");
        dto.setHandlerNeedIs(false);
        dto.setHandlerParams(null);
        //http://127.0.0.1:10086/gxqpt-mt?promUrl=http://127.0.0.1:10086/gxqpt-mt/fast/workapprove/list
        //dto.setHandlerUrl("/fast/workapprove/list");
        dto.setHandlerUrl("/module/index?promUrl=/gxqpt-mt/fast/workapprove/list");
        dto.setSenderName(sendUserName);
        dto.setSingleHandleIs(false);
        return dto;
    }
    /***
     * 创建发送消息dto
     * @param apprId
     * @param sendUserName
     * @param title
     * @param context
     * @return
     */
    public static BbsAllMainMsgDTO createBbsAllMainMsgWorkDTO(Long apprId, String sendUserName, String title, String context) {
        String appId = BaseContextHandler.getAppId();
        String appName = BaseContextHandler.getAppName();
        BbsAllMainMsgDTO dto = new BbsAllMainMsgDTO();

        dto.setBizId(String.valueOf(apprId));
        dto.setBizType("日志查看");
        dto.setBriefTpye("work_add");
        dto.setAppId(appId);
        dto.setAppName(appName);
        dto.setClientFlag("gxqpt");
        dto.setContent(context);//内容
        dto.setTitle(title);//
        dto.setDetailedType("work_add");
        dto.setDetailedTypeDesc("日志查看");
        dto.setHandlerNeedIs(false);
        dto.setHandlerParams(null);
        dto.setHandlerUrl("/module/index?promUrl=/gxqpt-mt/module/leaderview");
        dto.setSenderName(sendUserName);
        dto.setSingleHandleIs(false);
        return dto;
    }
    /***
     * 日志评论发送消息dto
     * @param apprId
     * @param sendUserName
     * @param title
     * @param context
     * @return
     */
    public static BbsAllMainMsgDTO createMsgWorkDTO(Long apprId, String sendUserName, String title, String context) {
        String appId = BaseContextHandler.getAppId();
        String appName = BaseContextHandler.getAppName();
        BbsAllMainMsgDTO dto = new BbsAllMainMsgDTO();

        dto.setBizId(String.valueOf(apprId));
        dto.setBizType("日志评论");
        dto.setBriefTpye("work_answer");
        dto.setAppId(appId);
        dto.setAppName(appName);
        dto.setClientFlag("gxqpt");
        dto.setContent(context);//内容
        dto.setTitle(title);//
        dto.setDetailedType("work_answer");
        dto.setDetailedTypeDesc("日志评论");
        dto.setHandlerNeedIs(false);
        dto.setHandlerParams(null);
        dto.setHandlerUrl("");
        dto.setSenderName(sendUserName);
        dto.setSingleHandleIs(false);
        return dto;
    }
    /***
     * 创建更新消息实体
     * @param apprId
     * @return
     */
    public static UpdateBacklogReqDTO createUpdateBacklogReqDTO(Long apprId, Long receiveId) {
        String appId = BaseContextHandler.getAppId();
        //String appName = BaseContextHandler.getAppName();
        UpdateBacklogReqDTO update = new UpdateBacklogReqDTO();
        update.setAppId(appId);
        update.setBizId(String.valueOf(apprId));
        update.setClientFlag("gxqpt");
        update.setBizType("考勤审批");
        update.setReceiveId(receiveId);
        return update;
    }
}
