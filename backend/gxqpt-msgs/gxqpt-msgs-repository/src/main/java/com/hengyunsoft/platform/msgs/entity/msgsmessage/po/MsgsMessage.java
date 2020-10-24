package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MsgsMessage extends BaseEntity<Long> implements Serializable {
    /**
     * 消息
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 常用联系人
     *
     * @mbggenerated
     */
    private String contactPerson;

    /**
     * 消息状态
     *
     * @mbggenerated
     */
    private Long msgStatus;

    /**
     * 消息文本内容
     *
     * @mbggenerated
     */
    private String msgTxt;

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    private Long msgType;

    /**
     * 多媒体id
     *
     * @mbggenerated
     */
    private String mediaId;

    /**
     * 多媒体url
     *
     * @mbggenerated
     */
    private String mediaUrl;

    /**
     * 附件id
     *
     * @mbggenerated
     */
    private String attachmentId;

    /**
     * 附件url
     *
     * @mbggenerated
     */
    private String attachmentUrl;

    /**
     * 标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 附件名称
     *
     * @mbggenerated
     */
    private String attachmentName;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 定时发送时间
     *
     * @mbggenerated
     */
    private Date sendJobTime;

    private static final long serialVersionUID = 1L;

    /**
     * 消息
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 消息
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 常用联系人
     *
     * @mbggenerated
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * 常用联系人
     *
     * @mbggenerated
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    /**
     * 消息状态
     *
     * @mbggenerated
     */
    public Long getMsgStatus() {
        return msgStatus;
    }

    /**
     * 消息状态
     *
     * @mbggenerated
     */
    public void setMsgStatus(Long msgStatus) {
        this.msgStatus = msgStatus;
    }

    /**
     * 消息文本内容
     *
     * @mbggenerated
     */
    public String getMsgTxt() {
        return msgTxt;
    }

    /**
     * 消息文本内容
     *
     * @mbggenerated
     */
    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt == null ? null : msgTxt.trim();
    }

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    public Long getMsgType() {
        return msgType;
    }

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    public void setMsgType(Long msgType) {
        this.msgType = msgType;
    }

    /**
     * 多媒体id
     *
     * @mbggenerated
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * 多媒体id
     *
     * @mbggenerated
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    /**
     * 多媒体url
     *
     * @mbggenerated
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 多媒体url
     *
     * @mbggenerated
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    /**
     * 附件id
     *
     * @mbggenerated
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * 附件id
     *
     * @mbggenerated
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    /**
     * 附件url
     *
     * @mbggenerated
     */
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    /**
     * 附件url
     *
     * @mbggenerated
     */
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl == null ? null : attachmentUrl.trim();
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 附件名称
     *
     * @mbggenerated
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * 附件名称
     *
     * @mbggenerated
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
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

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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
     * 定时发送时间
     *
     * @mbggenerated
     */
    public Date getSendJobTime() {
        return sendJobTime;
    }

    /**
     * 定时发送时间
     *
     * @mbggenerated
     */
    public void setSendJobTime(Date sendJobTime) {
        this.sendJobTime = sendJobTime;
    }
}