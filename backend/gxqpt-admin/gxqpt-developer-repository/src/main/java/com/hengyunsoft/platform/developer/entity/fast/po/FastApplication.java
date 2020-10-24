package com.hengyunsoft.platform.developer.entity.fast.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FastApplication extends CommonBaseEntity<Long> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    private String appId;

    private Long bizConfigId;

    /**
     * 开发者密码是校验开发者身份的密码，具有极高的安全性
     *
     * @mbggenerated
     */
    private String appSecret;

    private String appFlag;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    private String indexUrl;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    private String logoUrl;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 序号
     *
     * @mbggenerated
     */
    private Integer orderNo;

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    private Short appType;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务等等）
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 提供方   pt 平台   zk 中科 等等
     *
     * @mbggenerated
     */
    private String provider;

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    private Boolean status;

    /**
     * 随机序列
     *
     * @mbggenerated
     */
    private String randomStr;

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
     * 热门程度 
     *
     * @mbggenerated
     */
    private Integer hotsCount;

    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
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

    public Long getBizConfigId() {
        return bizConfigId;
    }

    public void setBizConfigId(Long bizConfigId) {
        this.bizConfigId = bizConfigId;
    }

    /**
     * 开发者密码是校验开发者身份的密码，具有极高的安全性
     *
     * @mbggenerated
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 开发者密码是校验开发者身份的密码，具有极高的安全性
     *
     * @mbggenerated
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public String getAppFlag() {
        return appFlag;
    }

    public void setAppFlag(String appFlag) {
        this.appFlag = appFlag == null ? null : appFlag.trim();
    }

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    public String getIndexUrl() {
        return indexUrl;
    }

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl == null ? null : indexUrl.trim();
    }

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
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
     * 应用编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    public Short getAppType() {
        return appType;
    }

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    public void setAppType(Short appType) {
        this.appType = appType;
    }

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务等等）
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务等等）
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 提供方   pt 平台   zk 中科 等等
     *
     * @mbggenerated
     */
    public String getProvider() {
        return provider;
    }

    /**
     * 提供方   pt 平台   zk 中科 等等
     *
     * @mbggenerated
     */
    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 随机序列
     *
     * @mbggenerated
     */
    public String getRandomStr() {
        return randomStr;
    }

    /**
     * 随机序列
     *
     * @mbggenerated
     */
    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr == null ? null : randomStr.trim();
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
     * 热门程度 
     *
     * @mbggenerated
     */
    public Integer getHotsCount() {
        return hotsCount;
    }

    /**
     * 热门程度 
     *
     * @mbggenerated
     */
    public void setHotsCount(Integer hotsCount) {
        this.hotsCount = hotsCount;
    }
}