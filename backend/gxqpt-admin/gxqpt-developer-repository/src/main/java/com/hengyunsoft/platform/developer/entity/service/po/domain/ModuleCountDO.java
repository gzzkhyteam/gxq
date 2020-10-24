package com.hengyunsoft.platform.developer.entity.service.po.domain;

/**
 * 组件各类别占比情况
 */
public class ModuleCountDO {

    /**
     * 数量
     */
    private Integer num;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型名称
     */
    private String typeName;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
