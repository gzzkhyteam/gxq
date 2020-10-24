package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Backlog extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 任务事项
     *
     * @mbggenerated
     */
    private String task;

    /**
     * 是否已读0未读 1已读
     *
     * @mbggenerated
     */
    private Integer readed;

    /**
     * 接收者id
     *
     * @mbggenerated
     */
    private Long receiverId;

    /**
     * 任务来源
     *
     * @mbggenerated
     */
    private String taskSource;

    /**
     * 任务数量
     *
     * @mbggenerated
     */
    private Integer taskNum;

    /**
     * 任务环节
     *
     * @mbggenerated
     */
    private String taskLink;

    /**
     * 任务发生地址
     *
     * @mbggenerated
     */
    private String taskUrl;

    /**
     * 任务创建人id
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
     * 任务事项
     *
     * @mbggenerated
     */
    public String getTask() {
        return task;
    }

    /**
     * 任务事项
     *
     * @mbggenerated
     */
    public void setTask(String task) {
        this.task = task == null ? null : task.trim();
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
     * 任务来源
     *
     * @mbggenerated
     */
    public String getTaskSource() {
        return taskSource;
    }

    /**
     * 任务来源
     *
     * @mbggenerated
     */
    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource == null ? null : taskSource.trim();
    }

    /**
     * 任务数量
     *
     * @mbggenerated
     */
    public Integer getTaskNum() {
        return taskNum;
    }

    /**
     * 任务数量
     *
     * @mbggenerated
     */
    public void setTaskNum(Integer taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * 任务环节
     *
     * @mbggenerated
     */
    public String getTaskLink() {
        return taskLink;
    }

    /**
     * 任务环节
     *
     * @mbggenerated
     */
    public void setTaskLink(String taskLink) {
        this.taskLink = taskLink == null ? null : taskLink.trim();
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