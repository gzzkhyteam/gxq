package com.hengyunsoft.platform.logs.entity.logs.domain;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class LogStructTogetherDO extends BaseEntity<Long> implements Serializable {
    /**
     * 结构化数据id
     */
    private Long id;
    /**
     * 记录日志时间
     */
    private Date logTime;

    /**
     * 应用系统ID
      */
    private String appId;
    /**
     * 文档ID
     */
    private String documentId;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 详情
     */
    private String detailContent;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public Date getUpdateTime() {
        return null;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setUpdateTime(Date nowDate) {

    }
}
