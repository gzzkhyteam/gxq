package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkApproveLeave extends BaseEntity<Long> implements Serializable {
    /**
     * 请假审批主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 审批主键（字典item_code）
     *
     * @mbggenerated
     */
    private Long aproveId;

    /**
     * 请假类型
     *
     * @mbggenerated
     */
    private String leaveType;

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    private Long workAgent;

    /**
     * 请假开始时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 请假结束时间
     *
     * @mbggenerated
     */
    private Date endTime;

    private String imgUrl;

    private Float leaveHour;

    /**
     * 请假事由
     *
     * @mbggenerated
     */
    private String leaveReason;

    /**
     * 创建时间
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

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    private static final long serialVersionUID = 1L;

    /**
     * 请假审批主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 请假审批主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 审批主键（字典item_code）
     *
     * @mbggenerated
     */
    public Long getAproveId() {
        return aproveId;
    }

    /**
     * 审批主键（字典item_code）
     *
     * @mbggenerated
     */
    public void setAproveId(Long aproveId) {
        this.aproveId = aproveId;
    }

    /**
     * 请假类型
     *
     * @mbggenerated
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * 请假类型
     *
     * @mbggenerated
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    public Long getWorkAgent() {
        return workAgent;
    }

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    public void setWorkAgent(Long workAgent) {
        this.workAgent = workAgent;
    }

    /**
     * 请假开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 请假开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 请假结束时间
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 请假结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Float getLeaveHour() {
        return leaveHour;
    }

    public void setLeaveHour(Float leaveHour) {
        this.leaveHour = leaveHour;
    }

    /**
     * 请假事由
     *
     * @mbggenerated
     */
    public String getLeaveReason() {
        return leaveReason;
    }

    /**
     * 请假事由
     *
     * @mbggenerated
     */
    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
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

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}