package com.hengyunsoft.platform.hardware.entity.database.domain;


public class DatabaseTypeRationDO {
    /**
     * 数据库数量
     *
     * @mbggenerated
     */
    private int num;

    /**
     * 数据库类型
     *
     * @mbggenerated
     */
    private String type;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
