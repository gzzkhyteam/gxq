package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogDeleteApp extends BaseEntity<Long> implements Serializable {
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
     * 文件名
     *
     * @mbggenerated
     */
    private String fileName;

    /**
     * 文件服务器返回的文件id
     *
     * @mbggenerated
     */
    private String documentId;

    /**
     * 日志路径
     *
     * @mbggenerated
     */
    private String documentPath;

    /**
     * 记录日志开始时间
     *
     * @mbggenerated
     */
    private Date logStartTime;

    /**
     * 记录日志结束时间
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
     * 文件名
     *
     * @mbggenerated
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 文件名
     *
     * @mbggenerated
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 文件服务器返回的文件id
     *
     * @mbggenerated
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * 文件服务器返回的文件id
     *
     * @mbggenerated
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    /**
     * 日志路径
     *
     * @mbggenerated
     */
    public String getDocumentPath() {
        return documentPath;
    }

    /**
     * 日志路径
     *
     * @mbggenerated
     */
    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath == null ? null : documentPath.trim();
    }

    /**
     * 记录日志开始时间
     *
     * @mbggenerated
     */
    public Date getLogStartTime() {
        return logStartTime;
    }

    /**
     * 记录日志开始时间
     *
     * @mbggenerated
     */
    public void setLogStartTime(Date logStartTime) {
        this.logStartTime = logStartTime;
    }

    /**
     * 记录日志结束时间
     *
     * @mbggenerated
     */
    public Date getLogEndTime() {
        return logEndTime;
    }

    /**
     * 记录日志结束时间
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
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}