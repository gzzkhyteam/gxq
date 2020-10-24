package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogWarnSet extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 结构化日志保留天数
     *
     * @mbggenerated
     */
    private Long structSaveDays;

    /**
     * 文件保留天数
     *
     * @mbggenerated
     */
    private Long fileSaveDays;

    /**
     * 告警信息保留
     *
     * @mbggenerated
     */
    private Long warnSaveDays;

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
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private Long updateUser;

    private String createUserName;

    private String updateUserName;

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
     * 结构化日志保留天数
     *
     * @mbggenerated
     */
    public Long getStructSaveDays() {
        return structSaveDays;
    }

    /**
     * 结构化日志保留天数
     *
     * @mbggenerated
     */
    public void setStructSaveDays(Long structSaveDays) {
        this.structSaveDays = structSaveDays;
    }

    /**
     * 文件保留天数
     *
     * @mbggenerated
     */
    public Long getFileSaveDays() {
        return fileSaveDays;
    }

    /**
     * 文件保留天数
     *
     * @mbggenerated
     */
    public void setFileSaveDays(Long fileSaveDays) {
        this.fileSaveDays = fileSaveDays;
    }

    /**
     * 告警信息保留
     *
     * @mbggenerated
     */
    public Long getWarnSaveDays() {
        return warnSaveDays;
    }

    /**
     * 告警信息保留
     *
     * @mbggenerated
     */
    public void setWarnSaveDays(Long warnSaveDays) {
        this.warnSaveDays = warnSaveDays;
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
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }
}