package com.hengyunsoft.platform.developer.entity.core.domain;

import com.hengyunsoft.platform.developer.entity.core.po.DependRelation;

public class DependRelationStatisticsDO extends DependRelation {
    private String appName;
    private Double originalTime;
    private Integer originalCost;
    private Double actualReduceTime;
    private Integer actualReduceCost;
    private Integer reduceProtectCost;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Double getOriginalTime() {
        return originalTime;
    }

    public void setOriginalTime(Double originalTime) {
        this.originalTime = originalTime;
    }

    public Double getActualReduceTime() {
        return actualReduceTime;
    }

    public void setActualReduceTime(Double actualReduceTime) {
        this.actualReduceTime = actualReduceTime;
    }

    public Integer getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(Integer originalCost) {
        this.originalCost = originalCost;
    }

    public Integer getActualReduceCost() {
        return actualReduceCost;
    }

    public void setActualReduceCost(Integer actualReduceCost) {
        this.actualReduceCost = actualReduceCost;
    }

    public Integer getReduceProtectCost() {
        return reduceProtectCost;
    }

    public void setReduceProtectCost(Integer reduceProtectCost) {
        this.reduceProtectCost = reduceProtectCost;
    }
}