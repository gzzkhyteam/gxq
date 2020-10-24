package com.hengyunsoft.platform.developer.entity.fast.po.document;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FastAppDocTaskJnl extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    private Long taskId;

    /**
     * 收发文类型
     *
     * @mbggenerated
     */
    private String taskType;

    /**
     * 任务状态：公文登记（register）处室领导审批（directorLeader） 分管领导审批（divisionLeader） 主要领导审批（mainLeader） 办结（finished）
     *
     * @mbggenerated
     */
    private String taskStatus;

    private Long createUser;

    private Date createTime;

    private Long updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 收发文类型
     *
     * @mbggenerated
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 收发文类型
     *
     * @mbggenerated
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    /**
     * 任务状态：公文登记（register）处室领导审批（directorLeader） 分管领导审批（divisionLeader） 主要领导审批（mainLeader） 办结（finished）
     *
     * @mbggenerated
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * 任务状态：公文登记（register）处室领导审批（directorLeader） 分管领导审批（divisionLeader） 主要领导审批（mainLeader） 办结（finished）
     *
     * @mbggenerated
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }
}