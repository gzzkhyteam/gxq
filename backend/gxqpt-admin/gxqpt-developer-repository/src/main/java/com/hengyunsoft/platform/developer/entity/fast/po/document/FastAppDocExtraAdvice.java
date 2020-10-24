package com.hengyunsoft.platform.developer.entity.fast.po.document;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FastAppDocExtraAdvice extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 任务id
     *
     * @mbggenerated
     */
    private Long taskId;

    /**
     * 收发文类型
     *
     * @mbggenerated
     */
    private String taskType;

    /**
     * 任务名称
     *
     * @mbggenerated
     */
    private String taskName;

    /**
     * 牵头领导
     *
     * @mbggenerated
     */
    private String leadName;

    /**
     * 收文处理状态
     *
     * @mbggenerated
     */
    private Long leadId;

    /**
     * 配合领导
     *
     * @mbggenerated
     */
    private String coordinationName;

    /**
     * 配合领导id
     *
     * @mbggenerated
     */
    private Long coordinationId;

    /**
     * 承办处室 
     *
     * @mbggenerated
     */
    private String undertakeRoom;

    /**
     * 配合处室
     *
     * @mbggenerated
     */
    private String coordinationRoom;

    /**
     * 代理
     *
     * @mbggenerated
     */
    private String agent;

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    private String urgencyDegree;

    /**
     * 完成时限
     *
     * @mbggenerated
     */
    private Date finishTimeLimit;

    /**
     * 内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    private String attachmentUrl;

    /**
     * 描述
     *
     * @mbggenerated
     */
    private String desc;

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

    /**
     * 任务id
     *
     * @mbggenerated
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 任务id
     *
     * @mbggenerated
     */
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
     * 任务名称
     *
     * @mbggenerated
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 任务名称
     *
     * @mbggenerated
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 牵头领导
     *
     * @mbggenerated
     */
    public String getLeadName() {
        return leadName;
    }

    /**
     * 牵头领导
     *
     * @mbggenerated
     */
    public void setLeadName(String leadName) {
        this.leadName = leadName == null ? null : leadName.trim();
    }

    /**
     * 收文处理状态
     *
     * @mbggenerated
     */
    public Long getLeadId() {
        return leadId;
    }

    /**
     * 收文处理状态
     *
     * @mbggenerated
     */
    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    /**
     * 配合领导
     *
     * @mbggenerated
     */
    public String getCoordinationName() {
        return coordinationName;
    }

    /**
     * 配合领导
     *
     * @mbggenerated
     */
    public void setCoordinationName(String coordinationName) {
        this.coordinationName = coordinationName == null ? null : coordinationName.trim();
    }

    /**
     * 配合领导id
     *
     * @mbggenerated
     */
    public Long getCoordinationId() {
        return coordinationId;
    }

    /**
     * 配合领导id
     *
     * @mbggenerated
     */
    public void setCoordinationId(Long coordinationId) {
        this.coordinationId = coordinationId;
    }

    /**
     * 承办处室 
     *
     * @mbggenerated
     */
    public String getUndertakeRoom() {
        return undertakeRoom;
    }

    /**
     * 承办处室 
     *
     * @mbggenerated
     */
    public void setUndertakeRoom(String undertakeRoom) {
        this.undertakeRoom = undertakeRoom == null ? null : undertakeRoom.trim();
    }

    /**
     * 配合处室
     *
     * @mbggenerated
     */
    public String getCoordinationRoom() {
        return coordinationRoom;
    }

    /**
     * 配合处室
     *
     * @mbggenerated
     */
    public void setCoordinationRoom(String coordinationRoom) {
        this.coordinationRoom = coordinationRoom == null ? null : coordinationRoom.trim();
    }

    /**
     * 代理
     *
     * @mbggenerated
     */
    public String getAgent() {
        return agent;
    }

    /**
     * 代理
     *
     * @mbggenerated
     */
    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    public String getUrgencyDegree() {
        return urgencyDegree;
    }

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    public void setUrgencyDegree(String urgencyDegree) {
        this.urgencyDegree = urgencyDegree == null ? null : urgencyDegree.trim();
    }

    /**
     * 完成时限
     *
     * @mbggenerated
     */
    public Date getFinishTimeLimit() {
        return finishTimeLimit;
    }

    /**
     * 完成时限
     *
     * @mbggenerated
     */
    public void setFinishTimeLimit(Date finishTimeLimit) {
        this.finishTimeLimit = finishTimeLimit;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl == null ? null : attachmentUrl.trim();
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
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