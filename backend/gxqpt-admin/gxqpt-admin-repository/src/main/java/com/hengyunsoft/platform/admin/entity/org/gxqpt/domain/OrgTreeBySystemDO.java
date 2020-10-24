package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

/**
 * 根据体系获得所有单位
 */
public class OrgTreeBySystemDO {
    /**
     * 单位id
     */
    private String id;
    /**
     * 单位体系
     */
    private String name;
    /**
     * 上级单位id
     */
    private String parentId;
    /**
     * 单位所属体系编码
     */
    private String systemCode;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
