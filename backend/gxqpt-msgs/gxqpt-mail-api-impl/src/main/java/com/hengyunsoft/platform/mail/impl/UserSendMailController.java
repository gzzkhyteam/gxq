package com.hengyunsoft.platform.mail.impl;

import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.api.UserSendMailApi;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.dto.AttachmentDTO;
import com.hengyunsoft.platform.mail.dto.MqMessageDTO;
import com.hengyunsoft.platform.mail.dto.SendMailInfoDTO;
import com.hengyunsoft.platform.mail.dto.core.FilterKeywordDTO;
import com.hengyunsoft.platform.mail.dto.open.MailBeanDTO;
import com.hengyunsoft.platform.mail.entity.core.po.FilterKeyword;
import com.hengyunsoft.platform.mail.entity.core.po.TimeAttachment;
import com.hengyunsoft.platform.mail.entity.core.po.TimeSend;
import com.hengyunsoft.platform.mail.entity.domain.Attachment;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.queue.MailQueueProducer;
import com.hengyunsoft.platform.mail.repository.core.service.SetParamApiService;
import com.hengyunsoft.platform.mail.repository.core.service.TimeAttachmentApiService;
import com.hengyunsoft.platform.mail.repository.core.service.TimeSendApiService;
import com.hengyunsoft.platform.mail.repository.service.BWListService;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.ReceiveMail;
import com.hengyunsoft.platform.mail.repository.service.mail.send.SendMail;
import com.hengyunsoft.platform.mail.utils.AccountUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a Description
 *
 * @author 作者: tangyh
 * @version 创建时间：2018-07-25
 */
@RestController
@Slf4j
@RequestMapping("/send")
@Api(value = "写信管理", description = "写信管理")
public class UserSendMailController implements UserSendMailApi {

    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    MailQueueProducer mailQueueProducer;

    @Autowired
    SetParamApiService setParamApiService;

    @Autowired
    private BWListService bwListService;

    @Autowired
    private TimeSendApiService timeSendApiService;
    @Autowired
    private TimeAttachmentApiService timeAttachmentApiService;

    @Autowired
    IdGenerate<Long> idGenerate;

    // 发送电子邮件
    @ApiOperation(value = "发送邮件", notes = "发送邮件")
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    @Override
    public Result<MailBeanDTO> saveSendEmail(@RequestBody SendMailInfoDTO mailInfoFB){
        String email = AccountUtils.getAccountSuffix();
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        log.info("username={}, email={}", username, email);
        try{
            String checkValue = bwListService.checkKeyword(mailInfoFB.getSubject(),mailInfoFB.getContent());
            if(!"".equals(checkValue)){
                return Result.fail("邮件中包含'"+checkValue+"'关键字，请修改后发送！");
            }
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
            return Result.success(dozerUtils.map(mailBean,MailBeanDTO.class));
        }catch (Exception ex){
            log.error("======Send异常信息======",ex);
            TimeSend timeSend = new TimeSend();
            timeSend.setMailName(username);
            timeSend.setMailFrom(mailInfoFB.getFrom());
            timeSend.setMailCc(mailInfoFB.getCc());
            timeSend.setContent(mailInfoFB.getContent());
            timeSend.setIsReplySign(mailInfoFB.getIsReplySign());
            timeSend.setSendTime(mailInfoFB.getDate());
            timeSend.setSubject(mailInfoFB.getSubject());
            timeSend.setMailTo(mailInfoFB.getTo());
            timeSend.setMailType("yc");
            TimeSend resultTimeSend = timeSendApiService.saveSelective(timeSend);
            if(mailInfoFB.getAttachment() != null) {
                List<AttachmentDTO> attachement = mailInfoFB.getAttachment();
                for (AttachmentDTO curObj : attachement) {
                    TimeAttachment timeAttachment = new TimeAttachment();
                    timeAttachment.setFileName(curObj.getFileName());
                    timeAttachment.setFileUrl(curObj.getUrl());
                    timeAttachment.setMailId(resultTimeSend.getId());
                    timeAttachmentApiService.saveSelective(timeAttachment);
                }
            }
            return Result.fail("产生异常，已保存至异常邮件。");
        }

    }

    @ApiOperation(value = "插入过滤关键字", notes = "插入过滤关键字")
    @RequestMapping(value = "/insertfilter", method = RequestMethod.GET)
    public Result<Integer> insertfilter(@RequestParam String keyWord){
        String email = AccountUtils.getAccountSuffix();
        FilterKeyword paramDto = new FilterKeyword();
        paramDto.setId(idGenerate.generate());
        paramDto.setFilterWord(keyWord);
        paramDto.setCreateTime(new Date());
        paramDto.setCreateUser(email);
        int result = bwListService.insertFilterKeyWord(paramDto);
        return Result.success(result);
    }

    @ApiOperation(value = "删除过滤关键字", notes = "删除过滤关键字")
    @RequestMapping(value = "/deletefilter", method = RequestMethod.GET)
    public Result<Integer> deletefilter(@RequestParam Long id){
        int result = bwListService.deleteFilterKeyWord(id);
        return Result.success(result);
    }

    @ApiOperation(value = "查询过滤关键字", notes = "查询过滤关键字")
    @RequestMapping(value = "/getfilter", method = RequestMethod.GET)
    public Result<List<FilterKeywordDTO>> getfilter(@RequestParam String filterWord){
        List<FilterKeyword> result = bwListService.getFilterKeywordAll(filterWord);
        return Result.success(dozerUtils.mapList(result,FilterKeywordDTO.class));
    }

    @ApiOperation(value = "查询过滤关键字(分页)", notes = "查询过滤关键字(分页)")
    @RequestMapping(value = "/getfilterpage", method = RequestMethod.POST)
    public Result<PageInfo<FilterKeywordDTO>> getFilterPage(@RequestBody OpenApiReq<String> openApiReq){
        //设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<FilterKeyword> result = bwListService.getFilterKeywordAll(openApiReq.getData());
        return Result.success(new PageInfo<>(dozerUtils.mapList(result,FilterKeywordDTO.class)));
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

    // 保存到草稿箱
    @ApiOperation(value = "保存到草稿箱", notes = "保存到草稿箱")
    @RequestMapping(value = "/saveDraft", method = RequestMethod.POST)
    public Result<MailBean> saveDraft(@RequestBody SendMailInfoDTO mailInfoFB) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        log.info("username={}", username);
        MailBean mailBean = setMailBean(mailInfoFB, username, password);
        // 发送邮件
        SendMail mail = new SendMail(mailBean);
        log.info("mail={}", mail == null);
        MimeMessage message = mail.createMimeMessage();
        log.info("message={}", message == null);
        ReceiveMail receiveMail = new ReceiveMail(username, password);
        Message m[] = { message };
        receiveMail.copyMessage(m, MailConstant.FOLDER_DRAFT);
        // 将邮件保存到草稿箱邮件夹中
        receiveMail.close();
        return Result.success(mailBean);
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
        // 附件
//        String path = session.getServletContext().getRealPath("/")
//                + "fileUpload/" + username + "/";
//        File attachment = new File(path);
//        if (attachment.exists() && attachment.isDirectory()) {// 有附件
//            String files[] = attachment.list();
//            StringBuffer attas = new StringBuffer();
//            for (int i = 0; i < files.length; i++) {
//                attas.append(path).append(files[i]).append(",");
//            }
//            System.out.println(attas);
//            if (attas.length() > 0) {
//                attas.deleteCharAt(attas.length() - 1);
//                mailBean.setFile(attas.toString());// 将附件添加到附件列表中
//            }
//        }
        return mailBean;
    }

    // 删除硬盘中的附件信息
    private void deleteAttachment() {
//        String path = session.getServletContext().getRealPath("/")
//                + "fileUpload/" + user.getName() + "/";
//        File attachment = new File(path);
//        if (attachment.exists() && attachment.isDirectory()) {
//            File files[] = attachment.listFiles();
//            for (File file : files) {
//                file.delete();// 删除上传的附件
//            }
//            attachment.delete();// 删除目录
//        }
    }


    // 发送快速回复邮件
    @ApiOperation(value = "发送快速回复邮件", notes = "发送快速回复邮件")
    @RequestMapping(value = "/quickReply", method = RequestMethod.POST)
    public Result saveSendQuickReply(@RequestBody SendMailInfoDTO mailInfoFB) {
        //当前登录用户
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        try {
            MailBean mailBean = new MailBean(username, password,
                    setMailFrom(username), mailInfoFB.getTo(), "回复给："
                    + mailInfoFB.getTo(), new String(mailInfoFB
                    .getContent().getBytes("ISO-8859-1"), "UTF-8"));
            // 发送邮件
            SendMail mail = new SendMail(mailBean);
            MimeMessage message = mail.createMimeMessage();
            mail.sendMail(message);// 发送邮件
        } catch (Exception e) {
            log.error("快速回复邮件失败", e);
            return Result.fail(-1, "邮件发送失败！请稍后再发...");
        }
        return Result.success("邮件发送成功！");
    }

    // 设置发件人
    private String setMailFrom(String username) {
//        user = userDAO.find(User.class, username);// 查找用户
//        String alias = user.getUserInfo().getAlias();
        String alias = BaseContextHandler.getName();
        if (alias != null && !"".equals(alias)) {
            return ("\"" + alias + "\"<" + username + "@gygxq.com>");
        } else {
            return ("\"" + username + "\"<" + username + "@gygxq.com>");
        }
    }
}
