package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogWarningStruct extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 告警日志
     *
     * @mbggenerated
     */
    private Long logWarningId;

    private String logType;

    /**
     * 四类结构化以后的日志ID
     *
     * @mbggenerated
     */
    private Long logStructId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreateTime() {
        return null;
    }

    @Override
    public Date getUpdateTime() {
        return null;
    }

    @Override
    public void setCreateTime(Date nowDate) {

    }

    @Override
    public void setUpdateTime(Date nowDate) {

    }

    /**
     * 告警日志
     *
     * @mbggenerated
     */
    public Long getLogWarningId() {
        return logWarningId;
    }

    /**
     * 告警日志
     *
     * @mbggenerated
     */
    public void setLogWarningId(Long logWarningId) {
        this.logWarningId = logWarningId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * 四类结构化以后的日志ID
     *
     * @mbggenerated
     */
    public Long getLogStructId() {
        return logStructId;
    }

    /**
     * 四类结构化以后的日志ID
     *
     * @mbggenerated
     */
    public void setLogStructId(Long logStructId) {
        this.logStructId = logStructId;
    }
}