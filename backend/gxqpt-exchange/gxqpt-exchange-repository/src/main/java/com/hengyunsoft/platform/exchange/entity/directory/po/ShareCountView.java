package com.hengyunsoft.platform.exchange.entity.directory.po;

import java.io.Serializable;

public class ShareCountView  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 业务名称
     *
     * @mbggenerated
     */
    private String dirName;
    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;
    /**
     * 数据集量
     *
     * @mbggenerated
     */
    private String dataCount;
    /**
     * 业务key
     *
     * @mbggenerated
     */
    private String busKey;
    /**
     * 业务编码
     *
     * @mbggenerated
     */
    private String busCode;

    public String getBusKey() {
        return busKey;
    }

    public void setBusKey(String busKey) {
        this.busKey = busKey;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getDataCount() {
        return dataCount;
    }

    public void setDataCount(String dataCount) {
        this.dataCount = dataCount;
    }
}
