package com.hengyunsoft.platform.logs.entity.logs.domain;

import com.hengyunsoft.platform.logs.entity.logs.po.LogWarning;

public class LogWarningDO extends LogWarning {
    /**
     * 告警名称
     */
    private String name;
    /**
     * 告警类型
     */
    private String warnType;
    /**
     * 告警级别
     */
    private String warnLevel;
    /**
     * 告警描述
     */
    private String warnDescription;
    /**
     * 告警结果显示（未处理、处理、误告、忽略）
     */
    private String dealResultShow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    public String getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel;
    }

    public String getWarnDescription() {
        return warnDescription;
    }

    public void setWarnDescription(String warnDescription) {
        this.warnDescription = warnDescription;
    }

    public String getDealResultShow() {
        return dealResultShow;
    }

    public void setDealResultShow(String dealResultShow) {
        this.dealResultShow = dealResultShow;
    }


}
