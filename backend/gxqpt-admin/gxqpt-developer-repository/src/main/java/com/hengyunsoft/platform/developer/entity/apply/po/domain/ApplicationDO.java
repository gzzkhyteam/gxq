package com.hengyunsoft.platform.developer.entity.apply.po.domain;

import com.hengyunsoft.platform.developer.entity.apply.po.Application;

public class ApplicationDO extends Application{

    /**
     * 类型名称
     *
     * @mbggenerated
     */
    private String typeName;

    /**
     * 创建人名称
     *
     * @mbggenerated
     */
    private String createName;

    /**
     * 当前应用管理员
     *
     * @mbggenerated
     */
    private String appManager;

    /**
     * 当前应用管理员ID
     *
     * @mbggenerated
     */
    private Long appManagerId;

    public Long getAppManagerId() {
        return appManagerId;
    }

    public void setAppManagerId(Long appManagerId) {
        this.appManagerId = appManagerId;
    }

    public String getAppManager() {
        return appManager;
    }

    public void setAppManager(String appManager) {
        this.appManager = appManager;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}