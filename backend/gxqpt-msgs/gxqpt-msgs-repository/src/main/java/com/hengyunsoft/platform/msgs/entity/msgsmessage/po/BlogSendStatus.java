package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class BlogSendStatus extends BaseEntity<Long> implements Serializable {
    /**
     * 微博发送状态id
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
     * 发送状态
     *
     * @mbggenerated
     */
    private Integer sendStatus;

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
     * 微博发送状态id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 微博发送状态id
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

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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