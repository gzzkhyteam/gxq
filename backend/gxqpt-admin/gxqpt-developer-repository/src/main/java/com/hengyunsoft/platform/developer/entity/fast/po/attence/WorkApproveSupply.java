package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkApproveSupply extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    private Long apprId;

    private String imgUrl;

    /**
     * 补签时间
     *
     * @mbggenerated
     */
    private Date supplyDate;

    /**
     * 0：签到，1：签退
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * 说明
     *
     * @mbggenerated
     */
    private String descript;

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
     * 审批主键
     *
     * @mbggenerated
     */
    public Long getApprId() {
        return apprId;
    }

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    public void setApprId(Long apprId) {
        this.apprId = apprId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 补签时间
     *
     * @mbggenerated
     */
    public Date getSupplyDate() {
        return supplyDate;
    }

    /**
     * 补签时间
     *
     * @mbggenerated
     */
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    /**
     * 0：签到，1：签退
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * 0：签到，1：签退
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 说明
     *
     * @mbggenerated
     */
    public String getDescript() {
        return descript;
    }

    /**
     * 说明
     *
     * @mbggenerated
     */
    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
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