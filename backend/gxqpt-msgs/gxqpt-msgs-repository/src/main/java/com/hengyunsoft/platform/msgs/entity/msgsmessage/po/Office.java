package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Office extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 是否已读0未读 1已读
     *
     * @mbggenerated
     */
    private Integer readed;

    /**
     * 原字号
     *
     * @mbggenerated
     */
    private String task;

    /**
     * 接收者id
     *
     * @mbggenerated
     */
    private Long receiverId;

    /**
     * 主题
     *
     * @mbggenerated
     */
    private String topic;

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    private Integer urgent;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * 任务发生地址
     *
     * @mbggenerated
     */
    private String taskUrl;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUserId;

    /**
     * 任务创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 任务创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

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
     * 原字号
     *
     * @mbggenerated
     */
    public String getTask() {
        return task;
    }

    /**
     * 原字号
     *
     * @mbggenerated
     */
    public void setTask(String task) {
        this.task = task == null ? null : task.trim();
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
     * 主题
     *
     * @mbggenerated
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 主题
     *
     * @mbggenerated
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    public Integer getUrgent() {
        return urgent;
    }

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    public void setUrgent(Integer urgent) {
        this.urgent = urgent;
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
     * 任务发生地址
     *
     * @mbggenerated
     */
    public String getTaskUrl() {
        return taskUrl;
    }

    /**
     * 任务发生地址
     *
     * @mbggenerated
     */
    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl == null ? null : taskUrl.trim();
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 任务创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 任务创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 任务创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 任务创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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