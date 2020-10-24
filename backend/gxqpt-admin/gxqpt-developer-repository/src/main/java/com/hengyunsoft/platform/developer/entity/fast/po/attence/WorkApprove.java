package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkApprove extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 审批主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 审批编号
     *
     * @mbggenerated
     */
    private String aproveCode;

    /**
     * 审批类型("1"为请假审批，"2"为出差审批,"3"为普通审批,"4"为加班审批,"5"为外勤申报)
     *
     * @mbggenerated
     */
    private String aproveType;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    private Date applyTime;

    /**
     * 申请人ID
     *
     * @mbggenerated
     */
    private Long applyUserId;

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    private String applyUserName;

    /**
     * 当前状态说明
     *
     * @mbggenerated
     */
    private String currentState;

    /**
     * 当前环节审批人
     *
     * @mbggenerated
     */
    private Long currentAproveUserId;

    /**
     * 当前环节审批人操作("1"为等待审批,"2"为同意审批，"3"拒绝审批)
     *
     * @mbggenerated
     */
    private String currentAproveUserOperation;

    /**
     * 审批状态("0"为未提交，”1“为已提交)
     *
     * @mbggenerated
     */
    private String aproveState;

    /**
     * 是否已经审批过("0":还未审批过，"1"已经审批过)
     *
     * @mbggenerated
     */
    private String inAprove;

    /**
     * 是否变更（“1”：变更，“0”：未变更）
     *
     * @mbggenerated
     */
    private String isChange;

    /**
     * 变更理由
     *
     * @mbggenerated
     */
    private String changeReason;

    /**
     * 变更时间
     *
     * @mbggenerated
     */
    private Date changeTime;

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

    private Long backlogId;

    private static final long serialVersionUID = 1L;

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 审批编号
     *
     * @mbggenerated
     */
    public String getAproveCode() {
        return aproveCode;
    }

    /**
     * 审批编号
     *
     * @mbggenerated
     */
    public void setAproveCode(String aproveCode) {
        this.aproveCode = aproveCode == null ? null : aproveCode.trim();
    }

    /**
     * 审批类型("1"为请假审批，"2"为出差审批,"3"为普通审批,"4"为加班审批,"5"为外勤申报)
     *
     * @mbggenerated
     */
    public String getAproveType() {
        return aproveType;
    }

    /**
     * 审批类型("1"为请假审批，"2"为出差审批,"3"为普通审批,"4"为加班审批,"5"为外勤申报)
     *
     * @mbggenerated
     */
    public void setAproveType(String aproveType) {
        this.aproveType = aproveType == null ? null : aproveType.trim();
    }

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 申请人ID
     *
     * @mbggenerated
     */
    public Long getApplyUserId() {
        return applyUserId;
    }

    /**
     * 申请人ID
     *
     * @mbggenerated
     */
    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    public String getApplyUserName() {
        return applyUserName;
    }

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName == null ? null : applyUserName.trim();
    }

    /**
     * 当前状态说明
     *
     * @mbggenerated
     */
    public String getCurrentState() {
        return currentState;
    }

    /**
     * 当前状态说明
     *
     * @mbggenerated
     */
    public void setCurrentState(String currentState) {
        this.currentState = currentState == null ? null : currentState.trim();
    }

    /**
     * 当前环节审批人
     *
     * @mbggenerated
     */
    public Long getCurrentAproveUserId() {
        return currentAproveUserId;
    }

    /**
     * 当前环节审批人
     *
     * @mbggenerated
     */
    public void setCurrentAproveUserId(Long currentAproveUserId) {
        this.currentAproveUserId = currentAproveUserId;
    }

    /**
     * 当前环节审批人操作("1"为等待审批,"2"为同意审批，"3"拒绝审批)
     *
     * @mbggenerated
     */
    public String getCurrentAproveUserOperation() {
        return currentAproveUserOperation;
    }

    /**
     * 当前环节审批人操作("1"为等待审批,"2"为同意审批，"3"拒绝审批)
     *
     * @mbggenerated
     */
    public void setCurrentAproveUserOperation(String currentAproveUserOperation) {
        this.currentAproveUserOperation = currentAproveUserOperation == null ? null : currentAproveUserOperation.trim();
    }

    /**
     * 审批状态("0"为未提交，”1“为已提交)
     *
     * @mbggenerated
     */
    public String getAproveState() {
        return aproveState;
    }

    /**
     * 审批状态("0"为未提交，”1“为已提交)
     *
     * @mbggenerated
     */
    public void setAproveState(String aproveState) {
        this.aproveState = aproveState == null ? null : aproveState.trim();
    }

    /**
     * 是否已经审批过("0":还未审批过，"1"已经审批过)
     *
     * @mbggenerated
     */
    public String getInAprove() {
        return inAprove;
    }

    /**
     * 是否已经审批过("0":还未审批过，"1"已经审批过)
     *
     * @mbggenerated
     */
    public void setInAprove(String inAprove) {
        this.inAprove = inAprove == null ? null : inAprove.trim();
    }

    /**
     * 是否变更（“1”：变更，“0”：未变更）
     *
     * @mbggenerated
     */
    public String getIsChange() {
        return isChange;
    }

    /**
     * 是否变更（“1”：变更，“0”：未变更）
     *
     * @mbggenerated
     */
    public void setIsChange(String isChange) {
        this.isChange = isChange == null ? null : isChange.trim();
    }

    /**
     * 变更理由
     *
     * @mbggenerated
     */
    public String getChangeReason() {
        return changeReason;
    }

    /**
     * 变更理由
     *
     * @mbggenerated
     */
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason == null ? null : changeReason.trim();
    }

    /**
     * 变更时间
     *
     * @mbggenerated
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * 变更时间
     *
     * @mbggenerated
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
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

    public Long getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(Long backlogId) {
        this.backlogId = backlogId;
    }
}