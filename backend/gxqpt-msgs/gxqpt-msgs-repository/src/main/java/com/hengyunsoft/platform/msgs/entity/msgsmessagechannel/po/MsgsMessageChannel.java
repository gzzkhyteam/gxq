package com.hengyunsoft.platform.msgs.entity.msgsmessagechannel.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MsgsMessageChannel extends BaseEntity<Long> implements Serializable {
    /**
     * 消息关联渠道
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 消息id
     *
     * @mbggenerated
     */
    private Long messageId;

    /**
     * 类型id
     *
     * @mbggenerated
     */
    private Long typeId;

    /**
     * 渠道
     *
     * @mbggenerated
     */
    private String channel;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    private Long channelId;

    /**
     * 消息状态
     *
     * @mbggenerated
     */
    private Long msgStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;
    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 消息关联渠道
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 消息关联渠道
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
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
     * 类型id
     *
     * @mbggenerated
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 类型id
     *
     * @mbggenerated
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 渠道
     *
     * @mbggenerated
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 渠道
     *
     * @mbggenerated
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}