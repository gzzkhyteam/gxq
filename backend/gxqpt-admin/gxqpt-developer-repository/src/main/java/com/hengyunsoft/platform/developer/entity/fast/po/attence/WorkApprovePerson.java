package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkApprovePerson extends BaseEntity<Long> implements Serializable {
    /**
     * 普通审批主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 审批人员审批顺序
     *
     * @mbggenerated
     */
    private Integer approveSortId;

    /**
     * 审批人祸抄送人ID
     *
     * @mbggenerated
     */
    private Long personId;

    /**
     * 审批或抄送人员名称
     *
     * @mbggenerated
     */
    private String personName;

    /**
     * 审批主键（b_bg_work_approve.ID）
     *
     * @mbggenerated
     */
    private Long aproveId;

    /**
     * 人员类型("1"为审批人，"2"为抄送人)
     *
     * @mbggenerated
     */
    private String personType;

    /**
     * 审批人员对该审批的操作("1"为同意审批，"2"为驳回)
     *
     * @mbggenerated
     */
    private String approveState;

    /**
     * 审批人员对该审批的意见
     *
     * @mbggenerated
     */
    private String approveOponion;

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    private Date operationDate;

    /**
     * 定时任务是否已经发送消息通知（0：否，1：是）
     *
     * @mbggenerated
     */
    private Short remind;

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
     * 普通审批主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 普通审批主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 审批人员审批顺序
     *
     * @mbggenerated
     */
    public Integer getApproveSortId() {
        return approveSortId;
    }

    /**
     * 审批人员审批顺序
     *
     * @mbggenerated
     */
    public void setApproveSortId(Integer approveSortId) {
        this.approveSortId = approveSortId;
    }

    /**
     * 审批人祸抄送人ID
     *
     * @mbggenerated
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * 审批人祸抄送人ID
     *
     * @mbggenerated
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * 审批或抄送人员名称
     *
     * @mbggenerated
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * 审批或抄送人员名称
     *
     * @mbggenerated
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * 审批主键（b_bg_work_approve.ID）
     *
     * @mbggenerated
     */
    public Long getAproveId() {
        return aproveId;
    }

    /**
     * 审批主键（b_bg_work_approve.ID）
     *
     * @mbggenerated
     */
    public void setAproveId(Long aproveId) {
        this.aproveId = aproveId;
    }

    /**
     * 人员类型("1"为审批人，"2"为抄送人)
     *
     * @mbggenerated
     */
    public String getPersonType() {
        return personType;
    }

    /**
     * 人员类型("1"为审批人，"2"为抄送人)
     *
     * @mbggenerated
     */
    public void setPersonType(String personType) {
        this.personType = personType == null ? null : personType.trim();
    }

    /**
     * 审批人员对该审批的操作("1"为同意审批，"2"为驳回)
     *
     * @mbggenerated
     */
    public String getApproveState() {
        return approveState;
    }

    /**
     * 审批人员对该审批的操作("1"为同意审批，"2"为驳回)
     *
     * @mbggenerated
     */
    public void setApproveState(String approveState) {
        this.approveState = approveState == null ? null : approveState.trim();
    }

    /**
     * 审批人员对该审批的意见
     *
     * @mbggenerated
     */
    public String getApproveOponion() {
        return approveOponion;
    }

    /**
     * 审批人员对该审批的意见
     *
     * @mbggenerated
     */
    public void setApproveOponion(String approveOponion) {
        this.approveOponion = approveOponion == null ? null : approveOponion.trim();
    }

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    public Date getOperationDate() {
        return operationDate;
    }

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    /**
     * 定时任务是否已经发送消息通知（0：否，1：是）
     *
     * @mbggenerated
     */
    public Short getRemind() {
        return remind;
    }

    /**
     * 定时任务是否已经发送消息通知（0：否，1：是）
     *
     * @mbggenerated
     */
    public void setRemind(Short remind) {
        this.remind = remind;
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