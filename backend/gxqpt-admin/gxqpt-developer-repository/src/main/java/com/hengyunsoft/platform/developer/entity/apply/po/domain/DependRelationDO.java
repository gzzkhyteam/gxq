package com.hengyunsoft.platform.developer.entity.apply.po.domain;

/**
 * Created by kevin on 2018/5/1.
 */
public class DependRelationDO {

    /**
     * 类型名称
     * @mbggenerated
     */
    private String type;

    /**
     * 应用使用数量
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getxDate() {
        return xDate;
    }

    public void setxDate(String xDate) {
        this.xDate = xDate;
    }
}
