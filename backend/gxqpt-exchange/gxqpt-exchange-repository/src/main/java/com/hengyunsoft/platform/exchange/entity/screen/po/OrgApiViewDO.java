package com.hengyunsoft.platform.exchange.entity.screen.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrgApiViewDO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;
    /**
     * 单位名称
     *
     * @mbggenerated
     */
    private String unitName;
    /**
     * api数量
     *
     * @mbggenerated
     */
    private int  apiCount;


    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getApiCount() {
        return apiCount;
    }

    public void setApiCount(int apiCount) {
        this.apiCount = apiCount;
    }
}
