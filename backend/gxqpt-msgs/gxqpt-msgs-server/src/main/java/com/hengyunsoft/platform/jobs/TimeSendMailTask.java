package com.hengyunsoft.platform.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.dto.AttachmentDTO;
import com.hengyunsoft.platform.mail.dto.MqMessageDTO;
import com.hengyunsoft.platform.mail.dto.SendMailInfoDTO;
import com.hengyunsoft.platform.mail.entity.core.po.TimeAttachment;
import com.hengyunsoft.platform.mail.entity.core.po.TimeSend;
import com.hengyunsoft.platform.mail.entity.domain.Attachment;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.queue.MailQueueProducer;
import com.hengyunsoft.platform.mail.repository.core.example.TimeAttachmentExample;
import com.hengyunsoft.platform.mail.repository.core.example.TimeSendExample;
import com.hengyunsoft.platform.mail.repository.core.service.TimeAttachmentApiService;
import com.hengyunsoft.platform.mail.repository.core.service.TimeSendApiService;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.ReceiveMail;
import com.hengyunsoft.platform.mail.repository.service.mail.send.SendMail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时同步用户表数据到邮件用户表中
 * @author wt
 * @createTime 2018-8-17
 *
 */
@RestController
@Slf4j
public class TimeSendMailTask {
    @Autowired
    DozerUtils dozerUtils;
    @Autowired
    MailQueueProducer mailQueueProducer;
    @Autowired
    private TimeSendApiService timeSendApiService;
    @Autowired
    private TimeAttachmentApiService timeAttachmentApiService;

    /**
     * 定时获取缓存中功能调用信息上报到数据库中,5分钟上报一次
     * @throws Exception
     */

    @Scheduled(cron = "0 0/10 * * * ?")//每隔10分钟触发一次
    public void saveSend() {
        log.info("定时获取缓存中功能调用信息上报到数据库开始");
        try {
            log.info("开始执行定时任务");

            TimeSendExample example = new TimeSendExample();
            example.createCriteria().andMailTypeEqualTo("ds");
            List<TimeSend> timeSend = timeSendApiService.find(example);
            for (TimeSend obj : timeSend){
                execute(obj);
            }
            log.info("结束执行定时任务");
        } catch (Exception e) {
            log.error("定时获取缓存中功能调用信息上报到数据库失败!!",e);
        }
    }

    private void execute(TimeSend timeSend)throws Exception{
        String password = MailConstant.DEFAULT_PASSWORD;
        Date currDate = new Date();
        Integer val = timeSend.getSendTime().compareTo(currDate);
        if (val <= 0){
            SendMailInfoDTO mailInfoFB = new SendMailInfoDTO();
            mailInfoFB.setSubject(timeSend.getSubject());
            mailInfoFB.setContent(timeSend.getContent());
            mailInfoFB.setFrom(timeSend.getMailFrom());
            mailInfoFB.setTo(timeSend.getMailTo());
            mailInfoFB.setCc(timeSend.getMailCc());
            mailInfoFB.setSended(true);
            mailInfoFB.setDate(timeSend.getSendTime());
            TimeAttachmentExample example = new TimeAttachmentExample();
            example.createCriteria().andMailIdEqualTo(timeSend.getId());
            List<TimeAttachment> list = timeAttachmentApiService.find(example);
            if (list != null && list.size() > 0) {
                List<AttachmentDTO> attachment = new ArrayList<AttachmentDTO>();
                for (TimeAttachment obj : list) {
                    AttachmentDTO dto = new AttachmentDTO();
                    dto.setFileName(obj.getFileName());
                    dto.setUrl(obj.getFileUrl());
                    attachment.add(dto);
                }
                mailInfoFB.setAttachment(attachment);
            }
            String username = timeSend.getMailName();
            String email = username + "@gygxq.com";
            MailBean mailBean = setMailBean(mailInfoFB, username, password);
            log.info("setMailBean=true");
            // 发送邮件
            SendMail mail = new SendMail(mailBean);
            MimeMessage message = mail.createMimeMessage();
            log.info("createMimeMessage=true");
            //设置回执
            if(mailInfoFB.getIsReplySign() != null) {
                if (mailInfoFB.getIsReplySign() == 1) {
                    message.setHeader("Disposition-Notification-To", "配置回执");
                    message.reply(true);
                }
            }
            // 发送邮件
            mail.sendMail(message);
            log.info("发送邮件={}", message == null);
            isSended(mailInfoFB.getSended(),username,password,message);
            log.info("保存到已发送={}", mailInfoFB.getSended());
            mailQueueProducer.saveSendBbsMsg(new MqMessageDTO(mailInfoFB,email,username));
            log.info("消息队列={}");
            timeSendApiService.deleteById(timeSend.getId());
            List<Long> deleteList = new ArrayList<Long>();
            if (list != null && list.size() > 0) {
                for (TimeAttachment obj : list) {
                    deleteList.add(obj.getId());
                }
            }
            if(deleteList != null && deleteList.size() > 0){
                timeAttachmentApiService.deleteByIds(deleteList);
            }

        }
    }

    // 设置邮件基本信息
    private MailBean setMailBean(SendMailInfoDTO mailInfoFB, String username, String password) {
        MailBean mailBean = new MailBean(username, password,
                mailInfoFB.getFrom(), mailInfoFB.getTo(),
                mailInfoFB.getSubject(), mailInfoFB.getContent(),
                mailInfoFB.getCc(), mailInfoFB.getBcc());
        mailBean.setExigence(mailInfoFB.getExigence());// 是否紧急
        if(mailInfoFB.getTime()) {
            mailBean.setDate(mailInfoFB.getDate());
        }
        log.info("设置参数");
        mailBean.setFile(dozerUtils.mapList(mailInfoFB.getAttachment(), Attachment.class));//附件
        log.info("设置附件={}",  mailBean.getFile() ==null);
        return mailBean;
    }

    /**
     * 是否保存到已发送
     * @param sended
     * @param username
     * @param password
     * @param message
     * @throws Exception
     */
    private void isSended(Boolean sended,String username,String password,MimeMessage message)throws Exception{
        if (sended) {// 是否保存到已发送
            ReceiveMail receiveMail = new ReceiveMail(username, password);
            Message m[] = {message};
            receiveMail.copyMessage(m, MailConstant.FOLDER_SENDED);// 将邮件保存到已发送邮件夹中
            receiveMail.close();
        }
    }
}
