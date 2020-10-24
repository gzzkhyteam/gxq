package com.hengyunsoft.platform.developer.entity.service.po.domain;

public class ModuleRelationLinksDO {

    /**
     * 力引导图links 源
     */
    private String source;
    /**
     * 目标
     */
    private String target;

    /**
     * 方式
     */
    private String value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
