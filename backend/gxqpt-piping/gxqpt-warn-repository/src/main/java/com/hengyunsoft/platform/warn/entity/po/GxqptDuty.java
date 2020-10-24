package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class GxqptDuty extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 业务id （人员id\部门id\应用id）
     *
     * @mbggenerated
     */
    private String bizId;

    /**
     * 业务类型  personnel：人员  department：部门  company：单位  application：应用
     *
     * @mbggenerated
     */
    private String bizType;

    /**
     * 名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 责任类型
     *
     * @mbggenerated
     */
    private String dutyType;

    /**
     * 预警id
     *
     * @mbggenerated
     */
    private Long warnId;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
     *
     * @mbggenerated
     */
    private String appType;

    /**
     * 人员id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 人员姓名
     *
     * @mbggenerated
     */
    private String empName;

    /**
     * 人员所属部门
     *
     * @mbggenerated
     */
    private String departmentId;

    /**
     * 人员所在部门名称
     *
     * @mbggenerated
     */
    private String departmentName;

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    private String orgId;

    /**
     * 部门所在单位名称
     *
     * @mbggenerated
     */
    private String orgName;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 业务id （人员id\部门id\应用id）
     *
     * @mbggenerated
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 业务id （人员id\部门id\应用id）
     *
     * @mbggenerated
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * 业务类型  personnel：人员  department：部门  company：单位  application：应用
     *
     * @mbggenerated
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 业务类型  personnel：人员  department：部门  company：单位  application：应用
     *
     * @mbggenerated
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 责任类型
     *
     * @mbggenerated
     */
    public String getDutyType() {
        return dutyType;
    }

    /**
     * 责任类型
     *
     * @mbggenerated
     */
    public void setDutyType(String dutyType) {
        this.dutyType = dutyType == null ? null : dutyType.trim();
    }

    /**
     * 预警id
     *
     * @mbggenerated
     */
    public Long getWarnId() {
        return warnId;
    }

    /**
     * 预警id
     *
     * @mbggenerated
     */
    public void setWarnId(Long warnId) {
        this.warnId = warnId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
     *
     * @mbggenerated
     */
    public String getAppType() {
        return appType;
    }

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
     *
     * @mbggenerated
     */
    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 人员姓名
     *
     * @mbggenerated
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 人员姓名
     *
     * @mbggenerated
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     * 人员所属部门
     *
     * @mbggenerated
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 人员所属部门
     *
     * @mbggenerated
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * 人员所在部门名称
     *
     * @mbggenerated
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 人员所在部门名称
     *
     * @mbggenerated
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 部门所在单位名称
     *
     * @mbggenerated
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 部门所在单位名称
     *
     * @mbggenerated
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}