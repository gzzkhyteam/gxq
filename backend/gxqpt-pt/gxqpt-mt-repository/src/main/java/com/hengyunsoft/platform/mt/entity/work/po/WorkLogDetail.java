package com.hengyunsoft.platform.mt.entity.work.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class WorkLogDetail extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 工作类型;1：本职工作，2：非本职工作
     *
     * @mbggenerated
     */
    private Integer workType;

    /**
     * 非本职工作类型
     *
     * @mbggenerated
     */
    private String nonJobType;

    /**
     * 日志id
     *
     * @mbggenerated
     */
    private Long logId;

    /**
     * 工作描述
     *
     * @mbggenerated
     */
    private String description;

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
     * 工作类型;1：本职工作，2：非本职工作
     *
     * @mbggenerated
     */
    public Integer getWorkType() {
        return workType;
    }

    /**
     * 工作类型;1：本职工作，2：非本职工作
     *
     * @mbggenerated
     */
    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    /**
     * 非本职工作类型
     *
     * @mbggenerated
     */
    public String getNonJobType() {
        return nonJobType;
    }

    /**
     * 非本职工作类型
     *
     * @mbggenerated
     */
    public void setNonJobType(String nonJobType) {
        this.nonJobType = nonJobType == null ? null : nonJobType.trim();
    }

    /**
     * 日志id
     *
     * @mbggenerated
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * 日志id
     *
     * @mbggenerated
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 工作描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 工作描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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