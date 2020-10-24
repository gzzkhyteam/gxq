package com.hengyunsoft.platform.mt.entity.work.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class WorkLogAuthority extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 查看人
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;

    /**
     * 被查看人
     *
     * @mbggenerated
     */
    private Long beViewedUser;

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
     * 查看人
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 查看人
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    /**
     * 被查看人
     *
     * @mbggenerated
     */
    public Long getBeViewedUser() {
        return beViewedUser;
    }

    /**
     * 被查看人
     *
     * @mbggenerated
     */
    public void setBeViewedUser(Long beViewedUser) {
        this.beViewedUser = beViewedUser;
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