package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogWarnCheck extends BaseEntity<Long> implements Serializable {
    private Long id;

    private Long logStructId;

    private String logType;

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

    public Long getLogStructId() {
        return logStructId;
    }

    public void setLogStructId(Long logStructId) {
        this.logStructId = logStructId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }
}