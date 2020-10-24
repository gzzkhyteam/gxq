package com.hengyunsoft.platform.supervise.impl.manager;

import com.alibaba.fastjson.JSON;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.SystemUsers;
import com.hengyunsoft.commons.msg.BriefTpye;
import com.hengyunsoft.commons.msg.SuperviseBizTypeEnum;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSelectResDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.piping.api.msgs.dto.*;
import com.hengyunsoft.platform.piping.open.SmsSendApi;
import com.hengyunsoft.platform.piping.open.WarnMessageSendOpenApi;
import com.hengyunsoft.platform.supervise.constant.ApplicationNode;
import com.hengyunsoft.platform.supervise.impl.constant.WarnConstat;
import com.hengyunsoft.utils.BizAssert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 接收人名称处理
 *
 * @author sxy
 * @date 2018-09-14
 */
@Component
@Slf4j
public class BizCommon {

    @Autowired
    UserApi userAdminApi;

    @Autowired
    private SmsSendApi smsSendApi;

    @Autowired
    BbbMsgQueueProducer msgQueueProducer;

    @Autowired
    WarnMessageSendOpenApi warnMessageSendOpenApi;

    @Value("${gxqpt.piping.app-id}")
    private String appId;

    @Value("${gxqpt.piping.app-name}")
    private String appName;


    /**
     * 获取用户信息并处理
     *
     * @param confirmUser
     * @param dutyUser
     * @param copyUser
     * @return
     */
    public Map<String, String> getUserInfo(String confirmUser, String dutyUser, String copyUser) {
        //查询用户信息
        List<UserSelectResDTO> userList = userAdminApi.findAllList().getData();
        List<String> confirmUsers = Arrays.asList(confirmUser.split(","));
        List<String> copyUsers = Arrays.asList(copyUser.split(","));
        String confirmUserNames = "";
        String dutyUserName = "";
        String copyUserNames = "";
        if (userList == null) {
            return null;
        }
        for (UserSelectResDTO li : userList) {
            //责任人
            if (String.valueOf(li.getId()).equals(dutyUser)) {
                dutyUserName = li.getName();
            }
            //确认人
            for (String confirmU : confirmUsers) {
                if (String.valueOf(li.getId()).equals(confirmU)) {
                    confirmUserNames = confirmUserNames + li.getName() + ",";
                }
            }
            //抄送人
            for (String copyU : copyUsers) {
                if (copyU.equals(String.valueOf(li.getId()))) {
                    copyUserNames = copyUserNames + li.getName() + ",";
                }
            }
        }
        Map<String, String> map = new HashMap<>();
        if (confirmUserNames.length() > 0) {
            map.put("confirmUserNames", confirmUserNames.substring(0, confirmUserNames.length() - 1));
        }
        if (dutyUserName.length() > 0) {
            map.put("dutyUserName", dutyUserName);
        }
        if (copyUserNames.length() > 0) {
            map.put("copyUserNames", copyUserNames.substring(0, copyUserNames.length() - 1));
        }
        return map;
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
                dto.setChannelId(WarnConstat.CHANNEL_ID);
                dto.setTemplateId(WarnConstat.TEMPLATE_ID);
                dto.setTopic(WarnConstat.WARN_TOPIC);
                dto.setContext(WarnConstat.WARN_TOPIC);
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

    /**
     * 统一监管平台监管配置中心站内信息发送
     *
     * @param bbsAllMainMsgDTO
     * @param lookUserIds
     * @param handlerUserIds
     */
    public void addSendBbsMsg(BbsAllMainMsgDTO bbsAllMainMsgDTO, String[] lookUserIds, List<Long> handlerUserIds) {
        bbsAllMainMsgDTO.setAppId(appId);
        bbsAllMainMsgDTO.setAppName(appName);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(true);
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        for (String id : lookUserIds) {
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, Arrays.asList(Long.parseLong(id)), handlerUserIds);
        }
    }

    /**
     * 在进行消息实体组装的时候会发一条预警信息，如果失败，将不会进行接下去的操作
     *
     * @param node    联合查询的泛型实体
     * @param bizType Biz枚举，用于配合预警那边的变更
     * @param Content 内容
     * @param <T>
     * @return
     * @wz
     */
    public <T extends ApplicationNode> BbsAllMainMsgDTO builderBbsAllMainMsgDTO(T node, SuperviseBizTypeEnum bizType, String Content) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();

        bbsAllMainMsgDTO.setBizId(node.getId().toString());
        bbsAllMainMsgDTO.setBizType(bizType.getBizTypeCode());
        bbsAllMainMsgDTO.setBriefTpye(BriefTpye.WARNING_REMIND_MSG);
        bbsAllMainMsgDTO.setContent(bizType.getMsg() + "通知," + Content);
        bbsAllMainMsgDTO.setTitle(bizType.getMsg());
        bbsAllMainMsgDTO.setDetailedType(bizType.getDetailedType());
        bbsAllMainMsgDTO.setDetailedTypeDesc(bizType.getTypeName());
        bbsAllMainMsgDTO.setHandlerUrl(bizType.getUrl());
        bbsAllMainMsgDTO.setSenderName("系统自动通知");

        //设置warn预警保存实体
        WarnMessageDTO warnMessageDTO = new WarnMessageDTO();

        //最高级别预警
        warnMessageDTO.setLevel(node.getLevel() == null ? 1 : node.getLevel());
        warnMessageDTO.setTitle(bbsAllMainMsgDTO.getTitle());
        warnMessageDTO.setContent(bbsAllMainMsgDTO.getContent());

        //预警类型
        warnMessageDTO.setTypeId(bizType.getTypeId());
        warnMessageDTO.setType(bizType.getTypeName());

        //设置预警跳转地址
        warnMessageDTO.setCallbackUrl(bizType.getUrl());

        //设置责任人
        List<DutyDTO> dutyDTOS = new ArrayList<>();
        List<String> dutyIds = Arrays.asList(node.getDutyUser().split(","));
        List<String> dutyNames = Arrays.asList(node.getDutyUserName().split(","));
        DutyNameDTO dutyNameDTO = new DutyNameDTO();
        dutyIds.forEach(obj -> {
            DutyDTO dutyDTO = new DutyDTO();
            dutyDTO.setAppId(node.getAppId());
            dutyDTO.setAppName(node.getAppName());
            dutyDTO.setAppType(node.getType());
            dutyDTO.setBizId(node.getAppId());
            dutyDTO.setBizType(WarnConstat.BIZ_TYPE);
            dutyDTO.setUserId(Long.valueOf(obj));
            dutyDTO.setEmpName(dutyNames.get(dutyIds.indexOf(obj)));
            dutyDTO.setName(node.getAppName());
            dutyDTOS.add(dutyDTO);
            dutyNameDTO.setUserId(Long.valueOf(obj));
            dutyNameDTO.setRecName(dutyNames.get(dutyIds.indexOf(obj)));
        });
        warnMessageDTO.setDutyName(dutyNameDTO);
        warnMessageDTO.setDuty(dutyDTOS);

        //设置确认人
        List<HandlerDTO> handlerDTOS = new ArrayList<>();
        List<String> confirmIds = Arrays.asList(node.getConfirmUser().split(","));
        List<String> confirmNames = Arrays.asList(node.getConfirmUserName().split(","));
        confirmIds.forEach(obj -> {
            HandlerDTO handlerDTO = new HandlerDTO();
            handlerDTO.setHandlerLeve(confirmIds.indexOf(obj) + 1);
            handlerDTO.setUserId(Long.valueOf(obj));
            handlerDTO.setRecName(confirmNames.get(confirmIds.indexOf(obj)));
            handlerDTOS.add(handlerDTO);
        });
        warnMessageDTO.setHandler(handlerDTOS);

        //设置抄送人
        List<CsrDTO> csrDTOS = new ArrayList<>();
        List<String> copyIds = StringUtils.isEmpty(node.getCopyUser()) ? new ArrayList<>()
                : Arrays.asList(node.getCopyUser().split(","));
        List<String> copyNames = StringUtils.isEmpty(node.getCopyUserName()) ? new ArrayList<>()
                : Arrays.asList(node.getCopyUserName().split(","));
        copyIds.forEach(obj -> {
            CsrDTO csrDTO = new CsrDTO();
            csrDTO.setUserId(Long.valueOf(obj));
            csrDTO.setRecName(copyNames.get(copyIds.indexOf(obj)));
            csrDTOS.add(csrDTO);
        });
        warnMessageDTO.setCsr(csrDTOS);
        Result<String> ret = saveInsideSend(warnMessageDTO);
        if (ret.getData() == null) {
            BizAssert.fail(ret.getErrcode(), ret.getErrmsg());
        }
        return bbsAllMainMsgDTO;
    }

    /**
     * 发送短信给多个人
     *
     * @param confirmUser
     * @param copyUser
     * @param dutyUser
     * @param
     * @param map
     */
    public void addSendPhoneUserList(String confirmUser, String copyUser, String dutyUser, Map<String, String> map) {

        //给确认人信发短信
        if (StringUtils.isNotEmpty(confirmUser)) {
            String[] confirmUsers = confirmUser.split(",");
            addSendPhoneMsg(confirmUsers, map);
        }

        //给抄送人发短信
        if (StringUtils.isNotEmpty(copyUser)) {
            String[] copyUsers = copyUser.split(",");
            addSendPhoneMsg(copyUsers, map);
        }

        //给责任人发短信
        if (StringUtils.isNotEmpty(dutyUser)) {
            String[] dutyUsers = dutyUser.split(",");
            addSendPhoneMsg(dutyUsers, map);
        }
    }

    /**
     * 发送站内消息给多个人
     *
     * @param confirmUser
     * @param copyUser
     * @param dutyUser
     * @param bbsAllMainMsgDTO
     */
    public void addSendBbsUserList(String confirmUser, String copyUser, String dutyUser, BbsAllMainMsgDTO bbsAllMainMsgDTO) {

        //给确认人信发消息
        if (StringUtils.isNotEmpty(confirmUser)) {
            String[] confirmUsers = confirmUser.split(",");
            addSendBbsMsg(bbsAllMainMsgDTO, confirmUsers, null);
        }

        //给抄送人发消息
        if (StringUtils.isNotEmpty(copyUser)) {
            String[] copyUsers = copyUser.split(",");
            addSendBbsMsg(bbsAllMainMsgDTO, copyUsers, null);
        }

        //给责任人发消息
        if (StringUtils.isNotEmpty(dutyUser)) {
            String[] dutyUsers = dutyUser.split(",");
            addSendBbsMsg(bbsAllMainMsgDTO, dutyUsers, null);
        }
    }

    /**
     * 判断是否超过时限
     *
     * @param startTime
     * @param timeLimit
     * @return
     */
    public boolean validLimit(Date startTime,Double timeLimit) {
        long resultTime = new Date().getTime() - startTime.getTime();
        double resHours = (double) (resultTime) / (1000 * 60 * 60);
        if (resHours > timeLimit) {
            return true;
        }
        return false;
    }


    /**
     * 构建预警dto
     *
     * @param dutyUser
     * @param copyUser
     * @param confirmUser
     * @param copyUserNames
     * @param dutyUserName
     * @param confirmUserNames
     * @return
     */
    public WarnMessageDTO buildWarnDto(String dutyUser, String copyUser, String confirmUser, String copyUserNames, String dutyUserName, String confirmUserNames, String systemName, String appId) {

        WarnMessageDTO warnDto = new WarnMessageDTO();
        List<CsrDTO> csrList = new ArrayList<CsrDTO>();
        List<DutyDTO> dutyList = new ArrayList<DutyDTO>();
        List<HandlerDTO> handlerList = new ArrayList<HandlerDTO>();
        DutyNameDTO dutyDTO = new DutyNameDTO();

        if (StringUtils.isNotEmpty(copyUser) && StringUtils.isNotEmpty(copyUserNames)) {
            List<String> copyUserList = Arrays.asList(copyUser.split(","));
            List<String> copyUserNameList = Arrays.asList(copyUserNames.split(","));
            for (int i = 0; i < copyUserList.size(); i++) {
                CsrDTO dto = new CsrDTO();
                dto.setUserId(Long.parseLong(copyUserList.get(i)));
                dto.setRecName(copyUserNameList.get(i));
                csrList.add(dto);
            }
        }

        if (StringUtils.isNotEmpty(dutyUser) && StringUtils.isNotEmpty(dutyUserName)) {
            List<String> dutyUserList = Arrays.asList(dutyUser.split(","));
            List<String> dutyUserNameList = Arrays.asList(dutyUserName.split(","));
            for (int i = 0; i < dutyUserNameList.size(); i++) {
                DutyDTO dto = new DutyDTO();
                dto.setUserId(Long.parseLong(dutyUserList.get(i)));
                dto.setEmpName(dutyUserNameList.get(i));
                dto.setBizId(appId);
                dto.setName(appName);
                dto.setBizType(WarnConstat.BIZ_TYPE);
                dto.setAppId(appId);
                if(null != systemName){
                    dto.setAppName(systemName);
                } else {
                    dto.setAppName(appName);
                }
                dto.setAppType("zcpt");
                dto.setEmpName(dutyUserNameList.get(i));
                dutyList.add(dto);
                dutyDTO.setUserId(Long.parseLong(dutyUserList.get(i)));
                dutyDTO.setRecName(dutyUserNameList.get(i));
                warnDto.setDutyName(dutyDTO);
            }
        }

        if (StringUtils.isNotEmpty(confirmUser) && StringUtils.isNotEmpty(confirmUserNames)) {
            List<String> confirmUserList = Arrays.asList(confirmUser.split(","));
            List<String> confirmUserNameList = Arrays.asList(confirmUserNames.split(","));
            for (int i = 0; i < confirmUserList.size(); i++) {
                HandlerDTO dto = new HandlerDTO();
                dto.setUserId(Long.parseLong(confirmUserList.get(i)));
                dto.setRecName(confirmUserNameList.get(i));
                dto.setHandlerLeve(i + 1);
                handlerList.add(dto);
            }
        }
        warnDto.setCsr(csrList);
        warnDto.setDuty(dutyList);
        warnDto.setIsHandle(true);
        warnDto.setHandler(handlerList);
        return warnDto;
    }

    /**
     * 发送预警信息
     *
     * @param warnMessageDTO
     * @return
     */
    public Result<String> saveInsideSend(WarnMessageDTO warnMessageDTO) {
        return warnMessageSendOpenApi.saveInsideSend(warnMessageDTO);
    }
}
