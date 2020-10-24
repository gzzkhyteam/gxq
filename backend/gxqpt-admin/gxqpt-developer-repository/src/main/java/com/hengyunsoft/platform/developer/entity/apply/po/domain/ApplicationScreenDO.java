package com.hengyunsoft.platform.developer.entity.apply.po.domain;


public class ApplicationScreenDO {

    /**
     * 类型名称
     * @mbggenerated
     */
    private String type;

    /**
     * 应用总数
     * @mbggenerated
     */
    private Integer num;


    /**
     * 年月
     * @mbggenerated
     */
    private String xDate;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getXDate() {
        return xDate;
    }

    public void setXDate(String xDate) {
        this.xDate = xDate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}