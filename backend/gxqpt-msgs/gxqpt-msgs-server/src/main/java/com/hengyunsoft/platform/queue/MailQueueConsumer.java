package com.hengyunsoft.platform.queue;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.mail.dto.MqMessageDTO;
import com.hengyunsoft.platform.mail.dto.SendMailInfoDTO;
import com.hengyunsoft.platform.mail.entity.core.po.SetParam;
import com.hengyunsoft.platform.mail.entity.domain.Attachment;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.repository.core.example.SetParamExample;
import com.hengyunsoft.platform.mail.repository.core.service.SetParamApiService;
import com.hengyunsoft.platform.mail.repository.service.mail.send.SendMail;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 邮件消息-消费者
 *
 * @auth wt
 * @date 2018/08/22
 */
@Component
@Slf4j
public class MailQueueConsumer {
    /**
     * 发送邮件
     */
    private final static String MAIL_INTERFACE_SEND = "mail.interface.send";

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;
    /**
     * 创建bean 的作用和 init 方法中的一样。
     * 没有这个，启动会报错
     *
     * @return
     */

    @Bean
    public Queue mailQueue() {
        return new Queue(keyPrefix + MAIL_INTERFACE_SEND);
    }

    @Value("${gxqpt.mail-webapp.app-id}")
    private String appId;
    @Value("${gxqpt.mail-webapp.app-secret}")
    private String appSecret;
    @Autowired
    SetParamApiService setParamApiService;
    @Autowired
    private UserApi userApi;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    DozerUtils dozerUtils;

    @RabbitListener(queues = "${spring.redis.key-prefix}" + MAIL_INTERFACE_SEND)
    @RabbitHandler
    public void mailQueue(String dto) {
        try {

            log.info("从管道[{}]处理数据开始dto[{}] ", MAIL_INTERFACE_SEND,dto);
            MqMessageDTO record = JSONObject.parseObject(dto, MqMessageDTO.class);
            if (record == null) {
                return;
            }
            SendMailInfoDTO mailInfoFB = record.getMailInfoFB();
            String email = record.getEmail();
            String password = "123456";
            String username = record.getUserName();
            //获取收件人信息
            String [] toArray = mailInfoFB.getTo().trim().split(",");

            //对接消息管理系统
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setAppId(appId);
            bbsAllMainMsgDTO.setAppName("邮件管理系统");
            bbsAllMainMsgDTO.setBizId("1");
            bbsAllMainMsgDTO.setBizType("MAIL_SEND");
            bbsAllMainMsgDTO.setBriefTpye("mail_send");
            bbsAllMainMsgDTO.setClientFlag("gxqpt");
            bbsAllMainMsgDTO.setSingleHandleIs(false);
            bbsAllMainMsgDTO.setContent("您有一封新邮件《"+mailInfoFB.getSubject()+"》。");
            bbsAllMainMsgDTO.setTitle("您有一封新邮件《"+mailInfoFB.getSubject()+"》。");
            bbsAllMainMsgDTO.setDetailedType("MAIL_SEND");
            bbsAllMainMsgDTO.setDetailedTypeDesc("新邮件");
            bbsAllMainMsgDTO.setHandlerNeedIs(false);
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/received");
            bbsAllMainMsgDTO.setSenderName("系统自动通知");

            List<String> userIdList = new ArrayList<String>();
            for (String str:toArray){
                userIdList.add(getMailName(str));
            }
            Result<List<Long>> resultList = userApi.findIdByAccount(userIdList);
            log.info("resultList={}", resultList);
            if(resultList != null){
                List<Long> userIds = resultList.getData();
                if(userIds != null) {
                    for (Long sendMsg : userIds) {
                        List<Long> curList = new ArrayList<Long>();
                        curList.add(sendMsg);
                        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, curList, null);
                    }
                }
            }
            if(mailInfoFB.getIsReplyAll()) {
                //查询是否需要自动转发邮件
                SetParamExample example = new SetParamExample();
                example.createCriteria().andCreateUserEqualTo(email);
                SetParam setParam = setParamApiService.getUnique(example);
                //自动转发
                if (setParam != null) {
                    if (setParam.getAutoForward() == 1) {
                        String forwardAddress = setParam.getForwardAddress();
                        MailBean forwardMailBean = setMailBean(mailInfoFB, username, password);
                        forwardMailBean.setTo(forwardAddress);
                        forwardMailBean.setSubject("自动转发:" + mailInfoFB.getSubject());
                        forwardMailBean.setCc(null);
                        forwardMailBean.setBcc(null);
                        SendMail forwardMail = new SendMail(forwardMailBean);
                        MimeMessage forwardMessage = forwardMail.createMimeMessage();
                        forwardMail.sendMail();
                    }
                }
                //自动回复
                for (String mailAddress : toArray) {
                    SetParamExample toExample = new SetParamExample();
                    String mailName = getMailName(mailAddress) + "@gygxq.com";
                    toExample.createCriteria().andCreateUserEqualTo(mailName);
                    SetParam toSetParam = setParamApiService.getUnique(toExample);
                    if (toSetParam != null) {
                        if (toSetParam.getAutoReply() == 1) {
                            SendMailInfoDTO sendMailInfoDTO = new SendMailInfoDTO();
                            sendMailInfoDTO.setFrom(mailAddress);
                            sendMailInfoDTO.setTo(mailInfoFB.getFrom());
                            sendMailInfoDTO.setSubject("来自" + mailAddress + "自动回复邮件");
                            sendMailInfoDTO.setContent(toSetParam.getReplyContent());
                            MailBean replyMailBean = setMailBean(sendMailInfoDTO, username, password);
                            SendMail replyMail = new SendMail(replyMailBean);
                            replyMail.createMimeMessage();
                            replyMail.sendMail();
                        }
                    }
                }
            }
            log.info("从管道处理数据结束");
        } catch (Exception e) {
            log.error("从管道处理数据失败", e);
            e.printStackTrace();
        }
    }

    //获取邮件地址名称
    private static String getMailName(String val){
        String result = "";
        if(!"".equals(val)){
            if(val.indexOf("<") != -1){
                result =  val.substring(val.indexOf("<")+1,val.indexOf("@"));
            }else{
                result =  val.substring(0,val.indexOf("@"));
            }
        }
        return result;
    }

    // 设置邮件基本信息
    private MailBean setMailBean(SendMailInfoDTO mailInfoFB, String username, String password) {
        MailBean mailBean = new MailBean(username, password,
                mailInfoFB.getFrom(), mailInfoFB.getTo(),
                mailInfoFB.getSubject(), mailInfoFB.getContent(),
                mailInfoFB.getCc(), mailInfoFB.getBcc());
        mailBean.setExigence(mailInfoFB.getExigence());// 是否紧急
        mailBean.setDate(mailInfoFB.getDate());
        mailBean.setFile(dozerUtils.mapList(mailInfoFB.getAttachment(), Attachment.class));//附件
        return mailBean;
    }

}
