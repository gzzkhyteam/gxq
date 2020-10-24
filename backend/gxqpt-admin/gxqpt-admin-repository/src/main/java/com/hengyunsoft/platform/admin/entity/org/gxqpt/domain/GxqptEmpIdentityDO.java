package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmpIdentity;

/**
 * 描述:人员身份DO
 * @author chb
 * @date 2018/4/10 14:28
 */
public class GxqptEmpIdentityDO extends SdzzwwEmpIdentity {
    /**
     * 人员名称
     */
    private String userName;

    /**
     * 单位名称
     */
    private String orgName;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 职务名称
     */
    private String dutyName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }
}