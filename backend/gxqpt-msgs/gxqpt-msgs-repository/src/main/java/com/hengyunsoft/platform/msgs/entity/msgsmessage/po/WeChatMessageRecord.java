package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WeChatMessageRecord extends BaseEntity<Long> implements Serializable {
    /**
     * 微信记录id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 发布信息的id
     *
     * @mbggenerated
     */
    private String msgId;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 发布者账号
     *
     * @mbggenerated
     */
    private String sender;

    /**
     * 信息主题
     *
     * @mbggenerated
     */
    private String topic;

    /**
     * 发送渠道的id
     *
     * @mbggenerated
     */
    private String channelId;

    /**
     * 是否为草稿,1表示是草稿，0表示不是
     *
     * @mbggenerated
     */
    private Integer draft;

    /**
     * 发送开始时间
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * 消息摘要
     *
     * @mbggenerated
     */
    private String digest;

    /**
     * 图文信息
     *
     * @mbggenerated
     */
    private String imgText;

    /**
     * 信息记录创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 信息记录更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 微信记录id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 微信记录id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 发布信息的id
     *
     * @mbggenerated
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 发布信息的id
     *
     * @mbggenerated
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
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
     * 应用程序名称
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 发布者账号
     *
     * @mbggenerated
     */
    public String getSender() {
        return sender;
    }

    /**
     * 发布者账号
     *
     * @mbggenerated
     */
    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    /**
     * 信息主题
     *
     * @mbggenerated
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 信息主题
     *
     * @mbggenerated
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * 发送渠道的id
     *
     * @mbggenerated
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 发送渠道的id
     *
     * @mbggenerated
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 是否为草稿,1表示是草稿，0表示不是
     *
     * @mbggenerated
     */
    public Integer getDraft() {
        return draft;
    }

    /**
     * 是否为草稿,1表示是草稿，0表示不是
     *
     * @mbggenerated
     */
    public void setDraft(Integer draft) {
        this.draft = draft;
    }

    /**
     * 发送开始时间
     *
     * @mbggenerated
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 发送开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 消息摘要
     *
     * @mbggenerated
     */
    public String getDigest() {
        return digest;
    }

    /**
     * 消息摘要
     *
     * @mbggenerated
     */
    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    /**
     * 图文信息
     *
     * @mbggenerated
     */
    public String getImgText() {
        return imgText;
    }

    /**
     * 图文信息
     *
     * @mbggenerated
     */
    public void setImgText(String imgText) {
        this.imgText = imgText == null ? null : imgText.trim();
    }

    /**
     * 信息记录创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 信息记录创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 信息记录更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 信息记录更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}