package com.hengyunsoft.platform.hardware.entity.database.domain;


public class DatabaseResPanelDO {
    /**
     * 数据库数量
     *
     * @mbggenerated
     */
    private int databaseNum;
    /**
     * 本月新增
     *
     * @mbggenerated
     */
    private int addNum;

    /**
     * 上月新增
     *
     * @mbggenerated
     */
    private int addedLastMonth;
    /**
     * 本月释放
     *
     * @mbggenerated
     */
    private int release;

    /**
     * 上月释放
     *
     * @mbggenerated
     */
    private int releaseLastMonth;

    /**
     * 净增
     *
     * @mbggenerated
     */
    private int netIncrease;

    public int getDatabaseNum() {
        return databaseNum;
    }

    public void setDatabaseNum(int databaseNum) {
        this.databaseNum = databaseNum;
    }

    public int getAddNum() {
        return addNum;
    }

    public void setAddNum(int addNum) {
        this.addNum = addNum;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public int getNetIncrease() {
        return netIncrease;
    }

    public void setNetIncrease(int netIncrease) {
        this.netIncrease = netIncrease;
    }

    public int getAddedLastMonth() {
        return addedLastMonth;
    }

    public void setAddedLastMonth(int addedLastMonth) {
        this.addedLastMonth = addedLastMonth;
    }

    public int getReleaseLastMonth() {
        return releaseLastMonth;
    }

    public void setReleaseLastMonth(int releaseLastMonth) {
        this.releaseLastMonth = releaseLastMonth;
    }
}
