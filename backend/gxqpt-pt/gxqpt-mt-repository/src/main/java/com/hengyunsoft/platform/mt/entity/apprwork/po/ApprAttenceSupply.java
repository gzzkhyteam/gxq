package com.hengyunsoft.platform.mt.entity.apprwork.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApprAttenceSupply extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请Id
     *
     * @mbggenerated
     */
    private Long applyId;

    /**
     * 补签类型(1:签到、2:签退)
     *
     * @mbggenerated
     */
    private Integer supplyType;

    /**
     * 补签日期
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 补签理由
     *
     * @mbggenerated
     */
    private String reason;

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
     * 申请Id
     *
     * @mbggenerated
     */
    public Long getApplyId() {
        return applyId;
    }

    /**
     * 申请Id
     *
     * @mbggenerated
     */
    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    /**
     * 补签类型(1:签到、2:签退)
     *
     * @mbggenerated
     */
    public Integer getSupplyType() {
        return supplyType;
    }

    /**
     * 补签类型(1:签到、2:签退)
     *
     * @mbggenerated
     */
    public void setSupplyType(Integer supplyType) {
        this.supplyType = supplyType;
    }

    /**
     * 补签日期
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 补签日期
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 补签理由
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * 补签理由
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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