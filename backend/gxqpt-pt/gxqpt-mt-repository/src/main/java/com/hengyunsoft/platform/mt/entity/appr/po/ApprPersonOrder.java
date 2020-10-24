package com.hengyunsoft.platform.mt.entity.appr.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApprPersonOrder extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    private String aprType;

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    private Long apprPersonId;

    /**
     * 审批人姓名
     *
     * @mbggenerated
     */
    private String apprPersonName;

    /**
     * 审批顺序
     *
     * @mbggenerated
     */
    private Integer apprOrder;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

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
     * 用户id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    public String getAprType() {
        return aprType;
    }

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    public void setAprType(String aprType) {
        this.aprType = aprType == null ? null : aprType.trim();
    }

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    public Long getApprPersonId() {
        return apprPersonId;
    }

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    public void setApprPersonId(Long apprPersonId) {
        this.apprPersonId = apprPersonId;
    }

    /**
     * 审批人姓名
     *
     * @mbggenerated
     */
    public String getApprPersonName() {
        return apprPersonName;
    }

    /**
     * 审批人姓名
     *
     * @mbggenerated
     */
    public void setApprPersonName(String apprPersonName) {
        this.apprPersonName = apprPersonName == null ? null : apprPersonName.trim();
    }

    /**
     * 审批顺序
     *
     * @mbggenerated
     */
    public Integer getApprOrder() {
        return apprOrder;
    }

    /**
     * 审批顺序
     *
     * @mbggenerated
     */
    public void setApprOrder(Integer apprOrder) {
        this.apprOrder = apprOrder;
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