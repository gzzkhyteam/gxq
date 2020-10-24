package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class BlogMessageCursor extends BaseEntity<Long> implements Serializable {
	/**
     * 微博记录id
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
     * 发送开始时间
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * 文件信息地址
     *
     * @mbggenerated
     */
    private String fileUrl;

    /**
     * 文件信息id
     *
     * @mbggenerated
     */
    private String fileId;

    /**
     * 图文信息
     *
     * @mbggenerated
     */
    private String imgText;

    private static final long serialVersionUID = 1L;

    /**
     * 微博记录id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 微博记录id
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
     * 文件信息地址
     *
     * @mbggenerated
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 文件信息地址
     *
     * @mbggenerated
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    /**
     * 文件信息id
     *
     * @mbggenerated
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 文件信息id
     *
     * @mbggenerated
     */
    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
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

	@Override
	public void setCreateTime(Date arg0) {
		
	}

	@Override
	public void setUpdateTime(Date arg0) {
		
	}
}