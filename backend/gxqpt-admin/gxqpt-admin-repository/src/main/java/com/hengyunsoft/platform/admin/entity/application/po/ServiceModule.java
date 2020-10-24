package com.hengyunsoft.platform.admin.entity.application.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ServiceModule extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 图标
     *
     * @mbggenerated
     */
    private String logo;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    private Short status;

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * demo路径
     *
     * @mbggenerated
     */
    private String demoUrl;

    /**
     * api文档地址
     *
     * @mbggenerated
     */
    private String apiUrl;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    private String appId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 图标
     *
     * @mbggenerated
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 图标
     *
     * @mbggenerated
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * demo路径
     *
     * @mbggenerated
     */
    public String getDemoUrl() {
        return demoUrl;
    }

    /**
     * demo路径
     *
     * @mbggenerated
     */
    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl == null ? null : demoUrl.trim();
    }

    /**
     * api文档地址
     *
     * @mbggenerated
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * api文档地址
     *
     * @mbggenerated
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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
     * 更新人id
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
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

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }
}