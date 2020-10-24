package com.hengyunsoft.platform.logs.entity.logs.domain;

import com.hengyunsoft.platform.logs.entity.logs.po.LogFile;

import java.util.Date;

public class LogFileDO extends LogFile {
    /**
     * 日志时间区间 开始时间
     */
    private Date logStartTime;
    /**
     * 日志时间区间 结束时间
     */
    private Date logEndTime;

    /**
     * 文件解析状态
     */
    private String isParsed;
    /**
     * 文件解析状态 已解析 未解析 已失效  解析失败
     */
    private String parsedStatus;


    public Date getLogStartTime() {
        return logStartTime;
    }

    public void setLogStartTime(Date logStartTime) {
        this.logStartTime = logStartTime;
    }

    public Date getLogEndTime() {
        return logEndTime;
    }

    public void setLogEndTime(Date logEndTime) {
        this.logEndTime = logEndTime;
    }

    public String getIsParsed() {
        return isParsed;
    }

    public void setIsParsed(String isParsed) {
        this.isParsed = isParsed;
    }

    public String getParsedStatus() {
        return parsedStatus;
    }

    public void setParsedStatus(String parsedStatus) {
        this.parsedStatus = parsedStatus;
    }
}
