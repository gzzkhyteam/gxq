package com.hengyunsoft.platform.sms.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SmsRecordDetailDTO {
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
     * 发送者账号
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
    //发送成功个数
    private int success;
    //发送失败个数
    private int fail;
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
     * 发送渠道名称
     *
     * @mbggenerated
     */
    private String channelName;
    
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
     * 短信模板名称
     *
     * @mbggenerated
     */
    private String templateName;

    /**
     * 短信发送时间
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    private String context;
    /**
     * 模板内容
     *
     * @mbggenerated
     */
    private String content;
    /**
     * 发送渠道的服务商英文名称
     *
     * @mbggenerated
     */
    private String channelServer;
    
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

    public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
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

    public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateParams() {
		return templateParams;
	}

	public void setTemplateParams(String templateParams) {
		this.templateParams = templateParams;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
     * 短信发送时间
     *
     * @mbggenerated
     */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 短信发送时间
     *
     * @mbggenerated
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChannelServer() {
		return channelServer;
	}

	public void setChannelServer(String channelServer) {
		this.channelServer = channelServer;
	}   
}
