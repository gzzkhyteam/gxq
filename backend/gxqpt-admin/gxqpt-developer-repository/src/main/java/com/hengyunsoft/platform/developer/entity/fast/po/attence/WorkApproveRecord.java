package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkApproveRecord extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
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
     * 审批人ID
     *
     * @mbggenerated
     */
    private Long personId;

    /**
     * 审批人员名称
     *
     * @mbggenerated
     */
    private String personName;

    /**
     * 审批主键（b_work_approve.ID）
     *
     * @mbggenerated
     */
    private Long apprId;

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
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
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
     * 审批人ID
     *
     * @mbggenerated
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * 审批人ID
     *
     * @mbggenerated
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * 审批人员名称
     *
     * @mbggenerated
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * 审批人员名称
     *
     * @mbggenerated
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * 审批主键（b_work_approve.ID）
     *
     * @mbggenerated
     */
    public Long getApprId() {
        return apprId;
    }

    /**
     * 审批主键（b_work_approve.ID）
     *
     * @mbggenerated
     */
    public void setApprId(Long apprId) {
        this.apprId = apprId;
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