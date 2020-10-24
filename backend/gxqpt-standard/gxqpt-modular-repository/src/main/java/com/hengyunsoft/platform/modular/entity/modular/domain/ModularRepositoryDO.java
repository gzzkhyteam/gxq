package com.hengyunsoft.platform.modular.entity.modular.domain;


public class ModularRepositoryDO {

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 仓库类型
     */
    private String type;

    /**
     * 仓库格式
     */
    private String format;

    /**
     * 仓库地址
     */
    private String url;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
