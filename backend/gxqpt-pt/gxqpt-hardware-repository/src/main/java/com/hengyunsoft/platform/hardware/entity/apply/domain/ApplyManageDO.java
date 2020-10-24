package com.hengyunsoft.platform.hardware.entity.apply.domain;

import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyManage;

import java.util.Date;
import java.util.Set;

public class ApplyManageDO extends ApplyManage {

    /**
     * 处理状态
     */
    private String handleType;

    private Date applyStartTime;

    private Date applyEneTime;

    /**
     * 大环节code（SQ，GL，UY，YY）
     *
     * @mbggenerated
     */
    private Set<String> scodes;

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Date getApplyEneTime() {
        return applyEneTime;
    }

    public void setApplyEneTime(Date applyEneTime) {
        this.applyEneTime = applyEneTime;
    }

    public Set<String> getScodes() {
        return scodes;
    }

    public void setScodes(Set<String> scodes) {
        this.scodes = scodes;
    }
}