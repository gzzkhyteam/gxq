package com.hengyunsoft.platform.developer.entity.service.po.domain;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QueryConsummerAssignModule extends CommonBaseEntity<Long> implements Serializable {
    private Long id;
    private Long assignModuleId;

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
     * 状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用
     *
     * @mbggenerated
     */
    private Short status;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    private Boolean assignStatus;

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 模块类型
     *
     * @mbggenerated
     */
    private String moduleType;

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
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    private Boolean publicIs;

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    private Boolean publicLook;

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    private String apiSyncUrl;

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    private Integer resourceNum;

    /**
     * 停用日期（停止使用/维护日期）
     *
     * @mbggenerated
     */
    private Date stopTime;

    /**
     * 建议使用模块
     *
     * @mbggenerated
     */
    private Long adviceModule;

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
     * 状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用
     *
     * @mbggenerated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用
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
     * 所属应用appid
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 模块类型
     *
     * @mbggenerated
     */
    public String getModuleType() {
        return moduleType;
    }

    /**
     * 模块类型
     *
     * @mbggenerated
     */
    public void setModuleType(String moduleType) {
        this.moduleType = moduleType == null ? null : moduleType.trim();
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
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    public Boolean getPublicIs() {
        return publicIs;
    }

    /**
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    public void setPublicIs(Boolean publicIs) {
        this.publicIs = publicIs;
    }

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    public Boolean getPublicLook() {
        return publicLook;
    }

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    public void setPublicLook(Boolean publicLook) {
        this.publicLook = publicLook;
    }

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    public String getApiSyncUrl() {
        return apiSyncUrl;
    }

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    public void setApiSyncUrl(String apiSyncUrl) {
        this.apiSyncUrl = apiSyncUrl == null ? null : apiSyncUrl.trim();
    }

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    public Integer getResourceNum() {
        return resourceNum;
    }

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    public void setResourceNum(Integer resourceNum) {
        this.resourceNum = resourceNum;
    }

    /**
     * 停用日期（停止使用/维护日期）
     *
     * @mbggenerated
     */
    public Date getStopTime() {
        return stopTime;
    }

    /**
     * 停用日期（停止使用/维护日期）
     *
     * @mbggenerated
     */
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * 建议使用模块
     *
     * @mbggenerated
     */
    public Long getAdviceModule() {
        return adviceModule;
    }

    /**
     * 建议使用模块
     *
     * @mbggenerated
     */
    public void setAdviceModule(Long adviceModule) {
        this.adviceModule = adviceModule;
    }
}