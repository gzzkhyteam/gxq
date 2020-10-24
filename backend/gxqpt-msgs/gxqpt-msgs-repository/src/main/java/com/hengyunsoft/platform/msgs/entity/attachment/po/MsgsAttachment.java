package com.hengyunsoft.platform.msgs.entity.attachment.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MsgsAttachment extends CommonBaseEntity<Long> implements Serializable {

    /**
     * 消息附件id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 附件名称
     *
     * @mbggenerated
     */
    private String attachmentName;

    /**
     * 附件id
     *
     * @mbggenerated
     */
    private String attachmentId;

    /**
     * 附件路径
     *
     * @mbggenerated
     */
    private String mediaUrl;

    /**
     * 消息id
     *
     * @mbggenerated
     */
    private Long messageId;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 消息附件id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 消息附件id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
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
     * 附件路径
     *
     * @mbggenerated
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 附件路径
     *
     * @mbggenerated
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    /**
     * 消息id
     *
     * @mbggenerated
     */
    public Long getMessageId() {
        return messageId;
    }

    /**
     * 消息id
     *
     * @mbggenerated
     */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public Date getUpdateTime() {
        return null;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setUpdateTime(Date nowDate) {

    }

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }
}