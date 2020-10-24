package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class SmsMessageCursor extends BaseEntity<Long> implements Serializable {
    /**
     * 短信记录id
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
     * 发送者账号
     *
     * @mbggenerated
     */
    private String sender;
    
    /**
     * 发送者名称
     *
     * @mbggenerated
     */
    private String senderName;

    /**
     * 接收者手机号
     *
     * @mbggenerated
     */
    private String receiver;

    /**
     * 短信主题
     *
     * @mbggenerated
     */
    private String topic;

    /**
     * 发送渠道id
     *
     * @mbggenerated
     */
    private String channelId;

    /**
     * 短信模板id
     *
     * @mbggenerated
     */
    private Long templateId;

    /**
     * 短信模板参数
     *
     * @mbggenerated
     */
    private String templateParams;

    /**
     * 发送开始时间
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * 发送结束时间
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    private String context;

    private static final long serialVersionUID = 1L;

    /**
     * 短信记录id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 短信记录id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreateTime() {
        return null;
    }

    @Override
    public Date getUpdateTime() {
        return null;
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

    public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
     * 发送者账号
     *
     * @mbggenerated
     */
    public String getSender() {
        return sender;
    }

    /**
     * 发送者账号
     *
     * @mbggenerated
     */
    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
     * 接收者手机号
     *
     * @mbggenerated
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 接收者手机号
     *
     * @mbggenerated
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * 短信主题
     *
     * @mbggenerated
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 短信主题
     *
     * @mbggenerated
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * 发送渠道id
     *
     * @mbggenerated
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 发送渠道id
     *
     * @mbggenerated
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 短信模板id
     *
     * @mbggenerated
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 短信模板id
     *
     * @mbggenerated
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * 短信模板参数
     *
     * @mbggenerated
     */
    public String getTemplateParams() {
        return templateParams;
    }

    /**
     * 短信模板参数
     *
     * @mbggenerated
     */
    public void setTemplateParams(String templateParams) {
        this.templateParams = templateParams == null ? null : templateParams.trim();
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
     * 发送结束时间
     *
     * @mbggenerated
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 发送结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    public String getContext() {
        return context;
    }

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

	@Override
	public void setCreateTime(Date arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateTime(Date arg0) {
		// TODO Auto-generated method stub
		
	}
}