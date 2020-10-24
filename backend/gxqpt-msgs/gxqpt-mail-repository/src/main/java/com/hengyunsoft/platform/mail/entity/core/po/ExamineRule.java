package com.hengyunsoft.platform.mail.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ExamineRule extends BaseEntity<Long> implements Serializable {
    /**
     * 主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 来源IP
     *
     * @mbggenerated
     */
    private String sourceIp;

    /**
     * 收件人IP
     *
     * @mbggenerated
     */
    private String ccIp;

    /**
     * 发件人所属部门
     *
     * @mbggenerated
     */
    private String formDept;

    /**
     * 收件人所属部门
     *
     * @mbggenerated
     */
    private String ccDept;

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
    private String mailCc;

    /**
     * 主题
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
     * 附件名
     *
     * @mbggenerated
     */
    private String attachmentName;

    /**
     * 邮件长度
     *
     * @mbggenerated
     */
    private String mailLength;

    /**
     * 邮件头字段
     *
     * @mbggenerated
     */
    private String mailHead;

    /**
     * 邮件发送时间
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * 邮件接收时间
     *
     * @mbggenerated
     */
    private Date receiveTime;

    /**
     * 是否包含附件
     *
     * @mbggenerated
     */
    private String isAttachment;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 来源IP
     *
     * @mbggenerated
     */
    public String getSourceIp() {
        return sourceIp;
    }

    /**
     * 来源IP
     *
     * @mbggenerated
     */
    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp == null ? null : sourceIp.trim();
    }

    /**
     * 收件人IP
     *
     * @mbggenerated
     */
    public String getCcIp() {
        return ccIp;
    }

    /**
     * 收件人IP
     *
     * @mbggenerated
     */
    public void setCcIp(String ccIp) {
        this.ccIp = ccIp == null ? null : ccIp.trim();
    }

    /**
     * 发件人所属部门
     *
     * @mbggenerated
     */
    public String getFormDept() {
        return formDept;
    }

    /**
     * 发件人所属部门
     *
     * @mbggenerated
     */
    public void setFormDept(String formDept) {
        this.formDept = formDept == null ? null : formDept.trim();
    }

    /**
     * 收件人所属部门
     *
     * @mbggenerated
     */
    public String getCcDept() {
        return ccDept;
    }

    /**
     * 收件人所属部门
     *
     * @mbggenerated
     */
    public void setCcDept(String ccDept) {
        this.ccDept = ccDept == null ? null : ccDept.trim();
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
    public String getMailCc() {
        return mailCc;
    }

    /**
     * 收件人
     *
     * @mbggenerated
     */
    public void setMailCc(String mailCc) {
        this.mailCc = mailCc == null ? null : mailCc.trim();
    }

    /**
     * 主题
     *
     * @mbggenerated
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 主题
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
     * 附件名
     *
     * @mbggenerated
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * 附件名
     *
     * @mbggenerated
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    /**
     * 邮件长度
     *
     * @mbggenerated
     */
    public String getMailLength() {
        return mailLength;
    }

    /**
     * 邮件长度
     *
     * @mbggenerated
     */
    public void setMailLength(String mailLength) {
        this.mailLength = mailLength == null ? null : mailLength.trim();
    }

    /**
     * 邮件头字段
     *
     * @mbggenerated
     */
    public String getMailHead() {
        return mailHead;
    }

    /**
     * 邮件头字段
     *
     * @mbggenerated
     */
    public void setMailHead(String mailHead) {
        this.mailHead = mailHead == null ? null : mailHead.trim();
    }

    /**
     * 邮件发送时间
     *
     * @mbggenerated
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 邮件发送时间
     *
     * @mbggenerated
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 邮件接收时间
     *
     * @mbggenerated
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 邮件接收时间
     *
     * @mbggenerated
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 是否包含附件
     *
     * @mbggenerated
     */
    public String getIsAttachment() {
        return isAttachment;
    }

    /**
     * 是否包含附件
     *
     * @mbggenerated
     */
    public void setIsAttachment(String isAttachment) {
        this.isAttachment = isAttachment == null ? null : isAttachment.trim();
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}