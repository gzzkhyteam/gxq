package com.hengyunsoft.platform.mail.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class TimeSend extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户
     *
     * @mbggenerated
     */
    private String mailName;

    /**
     * 发件人
     *
     * @mbggenerated
     */
    private String mailFrom;

    /**
     * 收件人
     *
     * @mbggenerated
     */
    private String mailTo;

    /**
     * 抄送人
     *
     * @mbggenerated
     */
    private String mailCc;

    /**
     * 标题
     *
     * @mbggenerated
     */
    private String subject;

    /**
     * 内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 是否回执
     *
     * @mbggenerated
     */
    private Integer isReplySign;

    /**
     * 发送日期
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * 邮件类型
     *
     * @mbggenerated
     */
    private String mailType;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户
     *
     * @mbggenerated
     */
    public String getMailName() {
        return mailName;
    }

    /**
     * 用户
     *
     * @mbggenerated
     */
    public void setMailName(String mailName) {
        this.mailName = mailName == null ? null : mailName.trim();
    }

    /**
     * 发件人
     *
     * @mbggenerated
     */
    public String getMailFrom() {
        return mailFrom;
    }

    /**
     * 发件人
     *
     * @mbggenerated
     */
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom == null ? null : mailFrom.trim();
    }

    /**
     * 收件人
     *
     * @mbggenerated
     */
    public String getMailTo() {
        return mailTo;
    }

    /**
     * 收件人
     *
     * @mbggenerated
     */
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo == null ? null : mailTo.trim();
    }

    /**
     * 抄送人
     *
     * @mbggenerated
     */
    public String getMailCc() {
        return mailCc;
    }

    /**
     * 抄送人
     *
     * @mbggenerated
     */
    public void setMailCc(String mailCc) {
        this.mailCc = mailCc == null ? null : mailCc.trim();
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 是否回执
     *
     * @mbggenerated
     */
    public Integer getIsReplySign() {
        return isReplySign;
    }

    /**
     * 是否回执
     *
     * @mbggenerated
     */
    public void setIsReplySign(Integer isReplySign) {
        this.isReplySign = isReplySign;
    }

    /**
     * 发送日期
     *
     * @mbggenerated
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发送日期
     *
     * @mbggenerated
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 邮件类型
     *
     * @mbggenerated
     */
    public String getMailType() {
        return mailType;
    }

    /**
     * 邮件类型
     *
     * @mbggenerated
     */
    public void setMailType(String mailType) {
        this.mailType = mailType == null ? null : mailType.trim();
    }
}