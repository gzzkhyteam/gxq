package com.hengyunsoft.platform.hardware.entity.database.domain;

public class DatabaseStatisticsDO {

    /**
     * 数据库数量
     *
     * @mbggenerated
     */
    private int databaseNum;

    /**
     * 时间
     *
     * @mbggenerated
     */
    private String time;

    public int getDatabaseNum() {
        return databaseNum;
    }

    public void setDatabaseNum(int databaseNum) {
        this.databaseNum = databaseNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
