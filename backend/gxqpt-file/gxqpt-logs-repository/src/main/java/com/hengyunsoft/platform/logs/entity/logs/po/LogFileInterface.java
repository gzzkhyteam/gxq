package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogFileInterface extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * log_file表ID
     *
     * @mbggenerated
     */
    private Long logFileId;

    /**
     * 文件类型,APACHE、TOMCAT、APP、NGINX
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
     * 日志文件格式
     *
     * @mbggenerated
     */
    private String logPattern;

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    private String documentId;

    /**
     * 是否解析,1：是；0：否；2：解析失败
     *
     * @mbggenerated
     */
    private String isParsed;

    /**
     * 解析时间
     *
     * @mbggenerated
     */
    private Date parseTime;

    /**
     * 数据是否已提取到日志管理系统,1：是；0：否
     *
     * @mbggenerated
     */
    private String isPull;

    /**
     * 提取时间
     *
     * @mbggenerated
     */
    private Date pullTime;

    /**
     * 该日志文件已解析过的结构化的数据是否已经被删除。1：代表已删除 0：代表未删除。
     *
     * @mbggenerated
     */
    private String isDeleteStruct;

    /**
     * 日志条数
     *
     * @mbggenerated
     */
    private Long logCount;

    /**
     * 日志时间区-开始时间
     *
     * @mbggenerated
     */
    private Date logStartTime;

    /**
     * 日志时间区-结束时间
     *
     * @mbggenerated
     */
    private Date logEndTime;

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
     * 应用系统id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * log_file表ID
     *
     * @mbggenerated
     */
    public Long getLogFileId() {
        return logFileId;
    }

    /**
     * log_file表ID
     *
     * @mbggenerated
     */
    public void setLogFileId(Long logFileId) {
        this.logFileId = logFileId;
    }

    /**
     * 文件类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 文件类型,APACHE、TOMCAT、APP、NGINX
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
     * 日志文件格式
     *
     * @mbggenerated
     */
    public String getLogPattern() {
        return logPattern;
    }

    /**
     * 日志文件格式
     *
     * @mbggenerated
     */
    public void setLogPattern(String logPattern) {
        this.logPattern = logPattern == null ? null : logPattern.trim();
    }

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    /**
     * 是否解析,1：是；0：否；2：解析失败
     *
     * @mbggenerated
     */
    public String getIsParsed() {
        return isParsed;
    }

    /**
     * 是否解析,1：是；0：否；2：解析失败
     *
     * @mbggenerated
     */
    public void setIsParsed(String isParsed) {
        this.isParsed = isParsed == null ? null : isParsed.trim();
    }

    /**
     * 解析时间
     *
     * @mbggenerated
     */
    public Date getParseTime() {
        return parseTime;
    }

    /**
     * 解析时间
     *
     * @mbggenerated
     */
    public void setParseTime(Date parseTime) {
        this.parseTime = parseTime;
    }

    /**
     * 数据是否已提取到日志管理系统,1：是；0：否
     *
     * @mbggenerated
     */
    public String getIsPull() {
        return isPull;
    }

    /**
     * 数据是否已提取到日志管理系统,1：是；0：否
     *
     * @mbggenerated
     */
    public void setIsPull(String isPull) {
        this.isPull = isPull == null ? null : isPull.trim();
    }

    /**
     * 提取时间
     *
     * @mbggenerated
     */
    public Date getPullTime() {
        return pullTime;
    }

    /**
     * 提取时间
     *
     * @mbggenerated
     */
    public void setPullTime(Date pullTime) {
        this.pullTime = pullTime;
    }

    /**
     * 该日志文件已解析过的结构化的数据是否已经被删除。1：代表已删除 0：代表未删除。
     *
     * @mbggenerated
     */
    public String getIsDeleteStruct() {
        return isDeleteStruct;
    }

    /**
     * 该日志文件已解析过的结构化的数据是否已经被删除。1：代表已删除 0：代表未删除。
     *
     * @mbggenerated
     */
    public void setIsDeleteStruct(String isDeleteStruct) {
        this.isDeleteStruct = isDeleteStruct == null ? null : isDeleteStruct.trim();
    }

    /**
     * 日志条数
     *
     * @mbggenerated
     */
    public Long getLogCount() {
        return logCount;
    }

    /**
     * 日志条数
     *
     * @mbggenerated
     */
    public void setLogCount(Long logCount) {
        this.logCount = logCount;
    }

    /**
     * 日志时间区-开始时间
     *
     * @mbggenerated
     */
    public Date getLogStartTime() {
        return logStartTime;
    }

    /**
     * 日志时间区-开始时间
     *
     * @mbggenerated
     */
    public void setLogStartTime(Date logStartTime) {
        this.logStartTime = logStartTime;
    }

    /**
     * 日志时间区-结束时间
     *
     * @mbggenerated
     */
    public Date getLogEndTime() {
        return logEndTime;
    }

    /**
     * 日志时间区-结束时间
     *
     * @mbggenerated
     */
    public void setLogEndTime(Date logEndTime) {
        this.logEndTime = logEndTime;
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
}