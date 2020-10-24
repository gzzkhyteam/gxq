package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

/**
 * 根据体系获得所有部门
 */
public class DpmTreeBySystemDO {
    /**
     * 部门id
     */
    private String id;
    /**
     * 部门体系
     */
    private String name;
    /**
     * 所属单位id
     */
    private String orgId;
    /**
     * 部门所属体系编码
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
