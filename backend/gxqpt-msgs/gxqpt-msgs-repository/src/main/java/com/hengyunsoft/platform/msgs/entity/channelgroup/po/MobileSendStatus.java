package com.hengyunsoft.platform.msgs.entity.channelgroup.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MobileSendStatus extends BaseEntity<Long> implements Serializable {
    /**
     * 移动终端发送状态id
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
     * 渠道名称
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
     * 移动终端发送状态id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 移动终端发送状态id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 发送信息的id
     *
     * @mbggenerated
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 发送信息的id
     *
     * @mbggenerated
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
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
     * 渠道名称
     *
     * @mbggenerated
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 渠道名称
     *
     * @mbggenerated
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
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
     * 发送结果描述
     *
     * @mbggenerated
     */
    public String getResult() {
        return result;
    }

    /**
     * 发送结果描述
     *
     * @mbggenerated
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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
}