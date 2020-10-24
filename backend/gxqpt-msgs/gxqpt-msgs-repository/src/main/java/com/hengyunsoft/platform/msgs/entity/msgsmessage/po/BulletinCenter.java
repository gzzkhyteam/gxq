package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class BulletinCenter extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 消息主题
     *
     * @mbggenerated
     */
    private String topic;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * 发布人
     *
     * @mbggenerated
     */
    private String sender;

    /**
     * 接收者id
     *
     * @mbggenerated
     */
    private Long receiverId;

    /**
     * 消息发生地址
     *
     * @mbggenerated
     */
    private String url;

    /**
     * 任务创建人id
     *
     * @mbggenerated
     */
    private Long createUserId;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 是否已读0未读 1已读
     *
     * @mbggenerated
     */
    private Integer readed;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消息主题
     *
     * @mbggenerated
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 消息主题
     *
     * @mbggenerated
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 发布人
     *
     * @mbggenerated
     */
    public String getSender() {
        return sender;
    }

    /**
     * 发布人
     *
     * @mbggenerated
     */
    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    /**
     * 接收者id
     *
     * @mbggenerated
     */
    public Long getReceiverId() {
        return receiverId;
    }

    /**
     * 接收者id
     *
     * @mbggenerated
     */
    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * 消息发生地址
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * 消息发生地址
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 任务创建人id
     *
     * @mbggenerated
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 任务创建人id
     *
     * @mbggenerated
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
     * 是否已读0未读 1已读
     *
     * @mbggenerated
     */
    public Integer getReaded() {
        return readed;
    }

    /**
     * 是否已读0未读 1已读
     *
     * @mbggenerated
     */
    public void setReaded(Integer readed) {
        this.readed = readed;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}