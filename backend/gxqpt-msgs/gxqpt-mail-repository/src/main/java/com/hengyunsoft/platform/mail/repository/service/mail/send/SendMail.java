package com.hengyunsoft.platform.mail.repository.service.mail.send;

import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.entity.domain.Attachment;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.MailSession;
import lombok.extern.slf4j.Slf4j;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 类说明：发送邮件
 *
 * @author 作者: LiuJunGuang
 * @version 创建时间：2011-7-22 下午05:58:25
 */
@Slf4j
public class SendMail {
    private MailBean mail = null;
    private Session session = null;

    public SendMail(MailBean mail) {
        this.mail = mail;
    }

    /**
     * 创建邮件
     */
    public MimeMessage createMimeMessage() throws AddressException,
            MessagingException, UnsupportedEncodingException {
        session = MailSession.createSession(MailConstant.EMAIL_CONFIG_PATH, mail.getAuth());// 创建session
        MimeMessage message = new MimeMessage(session);// 创建整体邮件
        // 设置邮件基本信息
        setMimeMessageInfo(message);
        MimeMultipart multipart = null;

        // 创建什么都不含的邮件体（alternative）
//        if (mail.getContent() != null && mail.getContent().length() > 0)
//            multipart = createAlternative(multipart);
        // 创建含有内嵌资源的邮件体(related)
        if (mail.getResource() != null && mail.getResource().length() > 0)
            multipart = createRelated(multipart);
        // 创建含有附件的邮件体（mixed）
//        if (mail.getFile() != null && !mail.getFile().isEmpty())
//            multipart = createMixed(multipart);
        if (mail.getFile() != null && !mail.getFile().isEmpty()) {
            multipart = createAlternative2(multipart);
        } else {
            multipart = createAlternative(multipart);
        }


        // 添加multipart到邮件内容上
        if (multipart == null)
            multipart = createAlternative(multipart);
        message.setContent(multipart);
        message.saveChanges();
        return message;
    }

    // 创建什么都不含的邮件体（alternative）
    private MimeMultipart createAlternative(MimeMultipart multipart)
            throws MessagingException {
        multipart = new MimeMultipart("alternative");
        MimeBodyPart html = new MimeBodyPart();
        html.setContent(mail.getContent(), "text/html;charset=UTF-8");
        multipart.addBodyPart(html);
        return multipart;
    }

    private MimeMultipart createAlternative2(MimeMultipart multipart)
            throws MessagingException {
        multipart = new MimeMultipart("alternative");
        MimeBodyPart html = new MimeBodyPart();
        html.setContent(mail.getContent(), "text/html;charset=UTF-8");
        multipart.addBodyPart(html);

        try {
            html.setHeader("HEADER_FILE_SIZE",String.valueOf(mail.getFile().size()));
            int i = 0;
            for (Attachment file : mail.getFile()) {
//                html.setFileName(MimeUtility.encodeText(file.getFileName(), "UTF-8", "Q"));
                html.setHeader(MailConstant.HEADER_FILE_NAME+"_"+i, MimeUtility.encodeText(file.getFileName(), "UTF-8", "Q"));
                html.setHeader(MailConstant.HEADER_FILE_URL+"_"+i, file.getUrl());
                ++i;
            }
        } catch (Exception e) {
            log.error("加载附件异常：", e);
        }

        return multipart;
    }

    // 创建含有内嵌资源的邮件体(related)
    private MimeMultipart createRelated(MimeMultipart multipart)
            throws MessagingException {
        MimeBodyPart alternative = new MimeBodyPart();
        alternative.setContent(multipart);
        MimeMultipart related = new MimeMultipart("related");
        related.addBodyPart(alternative);
        // 添加内嵌资源
        related = addResource(related);
        return related;
    }

    // 添加内嵌资源
    private MimeMultipart addResource(MimeMultipart related)
            throws MessagingException {
        String resources[] = mail.getResource().split(",");
        for (String res : resources) {
            MimeBodyPart img = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(res);
            img.setDataHandler(new DataHandler(fds));
            img.setContentID(System.currentTimeMillis() + fds.getName());
            related.addBodyPart(img);
        }
        return related;
    }

    // 创建含有附件的邮件体（mixed）
    private MimeMultipart createMixed(MimeMultipart multipart)
            throws MessagingException, UnsupportedEncodingException {
        MimeBodyPart related = new MimeBodyPart();
        // 添加multipart到邮件内容上
        if (multipart == null)
            multipart = createAlternative(multipart);
        related.setContent(multipart);
        MimeMultipart mixed = new MimeMultipart("mixed");
        mixed.addBodyPart(related);
        // 添加附件
        mixed = addAttachment(mixed);

        return mixed;
    }

    // 添加附件
    private MimeMultipart addAttachment(MimeMultipart mixed)
            throws MessagingException, UnsupportedEncodingException {

        if (mail.getFile() == null || mail.getFile().isEmpty()) {
            return mixed;
        }
        for (Attachment file : mail.getFile()) {
            MimeBodyPart attachment = new MimeBodyPart();
//			FileDataSource fds = new FileDataSource(file);
//            try {
            String url = file.getUrl();
//                url = url.replaceAll("http://127.0.0.1", "http://192.168.30.151");
//                url = url.replaceAll("http://127.0.0.1", "http://192.168.0.199");
//                URL fileUrl = new URL(url);
//                attachment.setDataHandler(new DataHandler(fileUrl));
            attachment.setFileName(MimeUtility.encodeText(file.getFileName(), "UTF-8", "Q"));
            attachment.setHeader(MailConstant.HEADER_FILE_URL, file.getUrl());
            mixed.addBodyPart(attachment);
//            } catch (MalformedURLException e) {
//                log.error("附件读取错误", e);
//                throw new BizException(FILE_LOAD_ERROR.getCode(), FILE_LOAD_ERROR.getMsg());
//            }

        }
//		for (String file : files) {
//			MimeBodyPart attachment = new MimeBodyPart();
//			FileDataSource fds = new FileDataSource(file);
//			attachment.setDataHandler(new DataHandler(fds));
//			attachment.setFileName(MimeUtility.encodeText(fds.getName(),
//					"UTF-8", "Q"));
//			mixed.addBodyPart(attachment);
//		}
        return mixed;
    }

    // 设置邮件具体信息
    private void setMimeMessageInfo(MimeMessage message)
            throws AddressException, MessagingException,
            UnsupportedEncodingException {
        if (mail.getFrom() != null && !"".equals(mail.getFrom())) {
            message.setFrom(new InternetAddress(encode(mail.getFrom())));// 设置发件人
            message.setSender(new InternetAddress(encode(mail.getFrom())));
        }
        if (mail.getTo() != null && !"".equals(mail.getTo()))
            message.setRecipients(RecipientType.TO,
                    InternetAddress.parse(encode(mail.getTo())));// 设置收件人
        if (mail.getCc() != null && !"".equals(mail.getCc()))
            message.setRecipients(RecipientType.CC,
                    InternetAddress.parse(encode(mail.getCc())));// 设置抄送人
        if (mail.getBcc() != null && !"".equals(mail.getBcc()))
            message.setRecipients(RecipientType.BCC,
                    InternetAddress.parse(encode(mail.getBcc())));// 设置密送人
        if (mail.getSubject() != null && !"".equals(mail.getSubject()))
            message.setSubject(mail.getSubject(), "UTF-8");
        // 是否紧急
        if (mail.isExigence()) {// 指定邮件的优先级，1：紧急，3：普通，5：缓慢
            message.setHeader("X-Priority", "1");
        } else {
            message.setHeader("X-Priority", "3");
        }
        message.setSentDate(mail.getDate());
    }

    // 对中文进行编码
    private String encode(String mailadd) throws UnsupportedEncodingException {
        Pattern p = Pattern.compile("(\"(.*?)\" ?<)");// 查找所有("中文"<)的格式
        StringBuffer sb = new StringBuffer();
        Matcher matcher = p.matcher(mailadd);
        while (matcher.find()) {
            matcher.appendReplacement(sb,
                    MimeUtility.encodeText(matcher.group(2), "UTF-8", "B")
                            + " <");
        }
        matcher.appendTail(sb);
        log.info(sb.toString());
        return sb.toString();
    }

    /**
     * 发送邮件
     */
    public void sendMail() throws AddressException, MessagingException,
            UnsupportedEncodingException {
        MimeMessage message = createMimeMessage();
        // 发送消息
        Transport.send(message);
    }

    /**
     * 发送指定邮件体的邮件
     */
    public void sendMail(MimeMessage message) throws AddressException,
            MessagingException, UnsupportedEncodingException {
        // 发送消息
        Transport.send(message);

    }
}
