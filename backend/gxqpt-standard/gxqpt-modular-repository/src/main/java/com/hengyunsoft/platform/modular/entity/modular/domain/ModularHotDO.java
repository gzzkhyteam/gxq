package com.hengyunsoft.platform.modular.entity.modular.domain;


import com.hengyunsoft.platform.modular.entity.modular.po.Modular;

public class ModularHotDO extends Modular {
    /**
     * 名称
     */
    private String name;

    /**
     * 下载次数
     */
    private Integer hotCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
    }
}
