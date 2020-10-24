package com.hengyunsoft.platform.developer.entity.service.po.domain;

public class ModuleRelationDO {

    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 类别 0应用，1功能，2消费功能
     */
    private int category;

    /**
     * 大屏造数据增加2018-5-12
     */
    private int symbolSize;

    /**
     * 是否可拖动
     */
    private boolean draggable;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public int getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(int symbolSize) {
        this.symbolSize = symbolSize;
    }
}
