package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogStructApp extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 日志文件id
     *
     * @mbggenerated
     */
    private String documentId;

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 日志名称
     *
     * @mbggenerated
     */
    private String logName;

    /**
     * 日志记录时间
     *
     * @mbggenerated
     */
    private Date logTime;

    /**
     * 类名
     *
     * @mbggenerated
     */
    private String className;

    /**
     * 源文件名
     *
     * @mbggenerated
     */
    private String sourceFileName;

    /**
     * 日志级别
     *
     * @mbggenerated
     */
    private String level;

    /**
     * 日志内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 线程名
     *
     * @mbggenerated
     */
    private String thread;

    /**
     * 方法名
     *
     * @mbggenerated
     */
    private String method;

    /**
     * 代码行
     *
     * @mbggenerated
     */
    private String line;

    /**
     * 应用存活时间（毫秒数）
     *
     * @mbggenerated
     */
    private String systemLiveTime;

    /**
     * 日志业务类型
     *
     * @mbggenerated
     */
    private String logBusinessType;

    /**
     * 采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    private String dataChannel;

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
     * 日志文件id
     *
     * @mbggenerated
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * 日志文件id
     *
     * @mbggenerated
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
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
     * 日志名称
     *
     * @mbggenerated
     */
    public String getLogName() {
        return logName;
    }

    /**
     * 日志名称
     *
     * @mbggenerated
     */
    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    /**
     * 日志记录时间
     *
     * @mbggenerated
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * 日志记录时间
     *
     * @mbggenerated
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * 类名
     *
     * @mbggenerated
     */
    public String getClassName() {
        return className;
    }

    /**
     * 类名
     *
     * @mbggenerated
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * 源文件名
     *
     * @mbggenerated
     */
    public String getSourceFileName() {
        return sourceFileName;
    }

    /**
     * 源文件名
     *
     * @mbggenerated
     */
    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName == null ? null : sourceFileName.trim();
    }

    /**
     * 日志级别
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * 日志级别
     *
     * @mbggenerated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 日志内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 日志内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 线程名
     *
     * @mbggenerated
     */
    public String getThread() {
        return thread;
    }

    /**
     * 线程名
     *
     * @mbggenerated
     */
    public void setThread(String thread) {
        this.thread = thread == null ? null : thread.trim();
    }

    /**
     * 方法名
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * 方法名
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 代码行
     *
     * @mbggenerated
     */
    public String getLine() {
        return line;
    }

    /**
     * 代码行
     *
     * @mbggenerated
     */
    public void setLine(String line) {
        this.line = line == null ? null : line.trim();
    }

    /**
     * 应用存活时间（毫秒数）
     *
     * @mbggenerated
     */
    public String getSystemLiveTime() {
        return systemLiveTime;
    }

    /**
     * 应用存活时间（毫秒数）
     *
     * @mbggenerated
     */
    public void setSystemLiveTime(String systemLiveTime) {
        this.systemLiveTime = systemLiveTime == null ? null : systemLiveTime.trim();
    }

    /**
     * 日志业务类型
     *
     * @mbggenerated
     */
    public String getLogBusinessType() {
        return logBusinessType;
    }

    /**
     * 日志业务类型
     *
     * @mbggenerated
     */
    public void setLogBusinessType(String logBusinessType) {
        this.logBusinessType = logBusinessType == null ? null : logBusinessType.trim();
    }

    /**
     * 采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    public String getDataChannel() {
        return dataChannel;
    }

    /**
     * 采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    public void setDataChannel(String dataChannel) {
        this.dataChannel = dataChannel == null ? null : dataChannel.trim();
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