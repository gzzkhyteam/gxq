package com.hengyunsoft.platform.mt.entity.userconfig.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class UserConfig extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    private Long jobId;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 值
     *
     * @mbggenerated
     */
    private String jobValue;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
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
     * 值
     *
     * @mbggenerated
     */
    public String getJobValue() {
        return jobValue;
    }

    /**
     * 值
     *
     * @mbggenerated
     */
    public void setJobValue(String jobValue) {
        this.jobValue = jobValue == null ? null : jobValue.trim();
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

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }
}