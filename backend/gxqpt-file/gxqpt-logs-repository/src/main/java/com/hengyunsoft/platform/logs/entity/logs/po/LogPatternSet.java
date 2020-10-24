package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogPatternSet extends BaseEntity<Long> implements Serializable {
    private Long id;

    private String appId;

    /**
     * 日志类型
     *
     * @mbggenerated
     */
    private String logType;

    /**
     * 输出日志的类型LOG4J、LOGBACK、LOGHY
     *
     * @mbggenerated
     */
    private String logExportType;

    /**
     * 日志格式
     *
     * @mbggenerated
     */
    private String logPattern;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 日志类型
     *
     * @mbggenerated
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 日志类型
     *
     * @mbggenerated
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * 输出日志的类型LOG4J、LOGBACK、LOGHY
     *
     * @mbggenerated
     */
    public String getLogExportType() {
        return logExportType;
    }

    /**
     * 输出日志的类型LOG4J、LOGBACK、LOGHY
     *
     * @mbggenerated
     */
    public void setLogExportType(String logExportType) {
        this.logExportType = logExportType == null ? null : logExportType.trim();
    }

    /**
     * 日志格式
     *
     * @mbggenerated
     */
    public String getLogPattern() {
        return logPattern;
    }

    /**
     * 日志格式
     *
     * @mbggenerated
     */
    public void setLogPattern(String logPattern) {
        this.logPattern = logPattern == null ? null : logPattern.trim();
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