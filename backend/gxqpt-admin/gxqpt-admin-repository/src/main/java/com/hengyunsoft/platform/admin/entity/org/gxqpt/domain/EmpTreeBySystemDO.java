package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

/**
 * 根据体系获得所有部门
 */
public class EmpTreeBySystemDO {
    /**
     * 人员id
     */
    private String id;
    /**
     * 人员名称
     */
    private String name;
    /**
     * 所属单位id
     */
    private String mainorgid;
    /**
     * 所属部门id
     */
    private String maindeptid;
    /**
     * 人员所属体系编码
     */
    private String systemCode;
    /**
     * 登录账号
     */
    private String nickname;

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

    public String getMainorgid() {
        return mainorgid;
    }

    public void setMainorgid(String mainorgid) {
        this.mainorgid = mainorgid;
    }

    public String getMaindeptid() {
        return maindeptid;
    }

    public void setMaindeptid(String maindeptid) {
        this.maindeptid = maindeptid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
