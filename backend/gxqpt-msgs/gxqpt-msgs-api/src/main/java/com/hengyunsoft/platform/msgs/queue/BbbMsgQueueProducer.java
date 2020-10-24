package com.hengyunsoft.platform.msgs.queue;


import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgSaveReqDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.utils.JSONUtils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 站内消息生产者
 *
 * @auth sxy
 * @date 2018/08/09
 */
@Slf4j
@Component
public class BbbMsgQueueProducer {

    /**
     * 站内消息发送
     */
    private final static String MSGS_INTERFACE_BBS_SEND = "msgs.interface.bbs.send";

    /**
     * 站内消息更新
     */
    private final static String MSGS_INTERFACE_BBS_UPDATE = "msgs.interface.bbs.update";

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    /**
     * 发送消息
     *
     * @param dto
     */
    private void saveSendBbsMsg(BbsAllMainMsgSaveReqDTO dto) {

        String bean = JSONUtils.toJsonString(dto);
        log.info("调用消息队列发送，dto[{}]", bean);
        this.rabbitTemplate.convertAndSend(keyPrefix + MSGS_INTERFACE_BBS_SEND, bean);
    }

    /**
     * 更新消息为已处理
     *
     * @param dto
     */
    public String updateBbsToHandleed(UpdateBacklogReqDTO dto) {
        String msg = null;
        try {
            msg = validateUpdate(dto);
            if (msg != null) {
                log.info("调用消息队列更新,必输项校验失败,msg:[{}]", msg);
                return msg;
            }
            String bean = JSONUtils.toJsonString(dto);
            log.info("调用消息队列更新，dto[{}]", bean);

            this.rabbitTemplate.convertAndSend(keyPrefix + MSGS_INTERFACE_BBS_UPDATE, bean);
        } catch (AmqpException e) {
            log.error("更新消息异常！！", e);
        }
        return msg;
    }


    /**
     * 保存消息到指定的用户集合
     *
     * @param bbsAllMainMsgDTO
     * @param lookUserIds
     * @param handlerUserIds
     */
    public String saveMsgToUser(BbsAllMainMsgDTO bbsAllMainMsgDTO, List<Long> lookUserIds, List<Long> handlerUserIds) {
        String msg = null;
        try {
            msg = validateSend(bbsAllMainMsgDTO);
            if (msg != null) {
                log.info("保存消息到指定的用户集合,必输项校验失败,msg:[{}]", msg);
                return msg;
            }
            BbsAllMainMsgSaveReqDTO dto = new BbsAllMainMsgSaveReqDTO();
            dto.setBbsAllMainMsgDTO(bbsAllMainMsgDTO);
            dto.setHandlerUsers(handlerUserIds);
            dto.setLookUsers(lookUserIds);
            dto.setRecvType(BbsAllMainMsgSaveReqDTO.PERSON_RECV_TYPE);
            saveSendBbsMsg(dto);
        } catch (Exception e) {
            log.error("保存消息到指定的用户集合异常！！", e);
        }
        return msg;
    }

    /**
     * 保存只需要查看类的信息到指定的角色
     *
     * @param bbsAllMainMsgDTO
     * @param roleCode
     * @param roleAppId
     */
    public String saveLookMsgToRole(BbsAllMainMsgDTO bbsAllMainMsgDTO, String roleCode, String roleAppId) {
        String msg = null;
        try {
            msg = validateSend(bbsAllMainMsgDTO);
            if (msg != null) {
                log.info("保存只需要查看类的信息到指定的角色,必输项校验失败,msg:[{}]", msg);
                return msg;
            }
            BbsAllMainMsgSaveReqDTO dto = new BbsAllMainMsgSaveReqDTO();
            dto.setBbsAllMainMsgDTO(bbsAllMainMsgDTO);
            dto.setRoleAppId(roleAppId);
            dto.setRoleCode(roleCode);
            dto.setRecvType(BbsAllMainMsgSaveReqDTO.ROLE_RECV_TYPE);
            dto.setRoleHandIs(false);
            saveSendBbsMsg(dto);
        } catch (Exception e) {
            log.error("保存只需要查看类的信息到指定的角色异常！！", e);
        }
        return msg;
    }

    /**
     * 保存只需要处理类的消息到指定的角色
     *
     * @param bbsAllMainMsgDTO
     * @param roleCode
     * @param roleAppId
     */
    public String saveHandlerMsgToRole(BbsAllMainMsgDTO bbsAllMainMsgDTO, String roleCode, String roleAppId) {
        String msg = null;
        try {
            msg = validateSend(bbsAllMainMsgDTO);
            if (msg != null) {
                log.info("保存只需要处理类的消息到指定的角色,必输项校验失败,msg:[{}]", msg);
                return msg;
            }
            BbsAllMainMsgSaveReqDTO dto = new BbsAllMainMsgSaveReqDTO();
            dto.setBbsAllMainMsgDTO(bbsAllMainMsgDTO);
            dto.setRoleAppId(roleAppId);
            dto.setRoleCode(roleCode);
            dto.setRecvType(BbsAllMainMsgSaveReqDTO.ROLE_RECV_TYPE);
            dto.setRoleHandIs(true);
            saveSendBbsMsg(dto);
        } catch (Exception e) {
            log.error("保存只需要处理类的消息到指定的角色异常！！", e);
        }
        return msg;
    }

    /**
     * 校验入参
     *
     * @param dto
     * @return
     */
    public String validateSend(BbsAllMainMsgDTO dto) {
        String msg = null;
        if (dto == null) {
            msg = "入参实体DTO不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getBizId())) {
            msg = "业务id不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getBizType())) {
            msg = "业务类型不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getClientFlag())) {
            msg = "客户端标识不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getBriefTpye())) {
            msg = "简要类型，粗粒度的类型不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getDetailedType())) {
            msg = "详细类型不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getTitle())) {
            msg = "标题不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getContent())) {
            msg = "内容不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getSenderName())) {
            msg = "作者名称不能为空！！";
        }
		/*if(StringUtil.isEmpty(dto.getHandlerUrl())){
			msg =  "处理地址不为空！！";
		}*/
        if (StringUtil.isEmpty(dto.getAppName())) {
            msg = "应用名称不为空！！";
        }
        if (StringUtil.isEmpty(dto.getAppId())) {
            msg = "应用ID不能为空！！";
        }
        if (dto.getSingleHandleIs() == null) {
            msg = "是否单人处理不能为空！！";
        }
        if (dto.getHandlerNeedIs() == null) {
            msg = "是否需要处理不能为空！！";
        }
        return msg;
    }

    /**
     * 校验入参
     *
     * @param dto
     * @return
     */
    public String validateUpdate(UpdateBacklogReqDTO dto) {
        String msg = null;
        if (dto == null) {
            msg = "入参实体DTO不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getAppId())) {
            msg = "应用id不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getBizId())) {
            msg = "业务id不能为空！！";
        }
        if (StringUtil.isEmpty(dto.getBizType())) {
            msg = "业务类型不能为空！！";
        }
        return msg;
    }
}
