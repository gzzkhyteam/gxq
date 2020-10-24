package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class SmsSendStatus extends BaseEntity<Long> implements Serializable {
    /**
     * 短信发送状态id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 发送信息的id
     *
     * @mbggenerated
     */
    private String msgId;
    
    /**
     * 应用程序的id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 发送者账号
     *
     * @mbggenerated
     */
    private String sender;

    /**
     * 发送状态
     *
     * @mbggenerated
     */
    private Integer sendStatus;

    /**
     * 接收者手机号
     *
     * @mbggenerated
     */
    private String receiver;
    
    /**
     * 发送结果描述
     *
     * @mbggenerated
     */
    private String result;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 短信发送状态id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 短信发送状态id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
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

    /**
     * 发送状态
     *
     * @mbggenerated
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 发送状态
     *
     * @mbggenerated
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
	public void setUpdateTime(Date arg0) {
		
	}
}