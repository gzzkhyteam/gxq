package com.hengyunsoft.platform.developer.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Application extends BaseEntity<Long> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    @FieldDesc("ID")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    @FieldDesc("开发者ID，提供给各个应用的设别码")
    @Length(max=64)
    private String appId;

    /**
     * 开发者密码是校验开发者身份的密码，具有极高的安全性
     *
     * @mbggenerated
     */
    @FieldDesc("开发者密码是校验开发者身份的密码，具有极高的安全性")
    @Length(max=64)
    private String appSecret;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    @FieldDesc("首页访问地址")
    @Length(max=255)
    private String indexUrl;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @FieldDesc("应用名称")
    @Length(max=20)
    private String name;

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    @FieldDesc("应用logo")
    @Length(max=200)
    private String logoUrl;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @FieldDesc("功能描述")
    @Length(max=200)
    private String desc;

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    @FieldDesc("应用编码")
    @Length(max=100)
    private String code;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @FieldDesc("序号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer orderNo;

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    @FieldDesc("应用/服务类型： 1 应用   2服务   3既是应用也是服务")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short appType;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
     *
     * @mbggenerated
     */
    @FieldDesc("应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）")
    @Length(max=100)
    private String type;

    /**
     * 提供方   pt 平台   zk 中科 等等
     *
     * @mbggenerated
     */
    @FieldDesc("提供方   pt 平台   zk 中科 等等")
    @Length(max=30)
    private String provider;
    
    @FieldDesc("提供方id")
    private Long providerId;

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    @FieldDesc("是否启用")
    private Boolean status;

    /**
     * 随机序列
     *
     * @mbggenerated
     */
    @FieldDesc("随机序列")
    @Length(max=36)
    private String randomStr;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @FieldDesc("更新人id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 应用所属单位Id
     *
     * @mbggenerated
     */
    @FieldDesc("应用所属单位Id")
    @Length(max=64)
    private String orgId;

    /**
     * 单位所属体系编码
     *
     * @mbggenerated
     */
    @FieldDesc("单位所属体系编码")
    @Length(max=64)
    private String orgSystemCode;

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    @FieldDesc("单位名称")
    @Length(max=164)
    private String orgName;

    /**
     * 使用此应用，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此应用，可以节省多少工期（人/天）")
    @Range(max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Double reduceTime;

    /**
     * 使用此应用，可以节省多少前（元）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此应用，可以节省多少前（元）")
    @Range(max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer reduceCost;

    /**
     * 此应用程序的初始预计工期（人/天）
     *
     * @mbggenerated
     */
    @FieldDesc("此应用程序的初始预计工期（人/天）")
    @Range(max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Double originalTime;

    /**
     * 此应用程序的初始预计成本（人（元）
     *
     * @mbggenerated
     */
    @FieldDesc("此应用程序的初始预计成本（人（元）")
    @Range(max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer originalCost;

    /**
     * 是否快速应用开发
     *
     * @mbggenerated
     */
    @FieldDesc("是否快速应用开发")
    @Length(max=1)
    private String isFastApp;

    /**
     * 配置表关联ID
     *
     * @mbggenerated
     */
    @FieldDesc("配置表关联ID")
    @Range(max=Long.MAX_VALUE)
    private Long bizConfigId;

    /**
     * 热门程度
     *
     * @mbggenerated
     */
    @FieldDesc("热门程度")
    @Range(max=Integer.MAX_VALUE)
    private Integer hotsCount;

    /**
     * 使用此应用，可以节省多少建设成本（元）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此应用，可以节省多少建设成本（元）")
    @Range(max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer reduceBuildCost;

    /**
     * 使用此应用，可以节省多少使用成本（元）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此应用，可以节省多少使用成本（元）")
    @Range(max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer reduceUseCost;

    /**
     * 使用此应用，可以节省多少维护成本（元）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此应用，可以节省多少维护成本（元）")
    @Range(max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer reduceProtectCost;

    /**
     * 应用是否公有的   true表示公有，谁都可以访问，至于应用内部的资源，应用程序自己决定，要想有公有的菜单，完全可以在前端写死
     *
     * @mbggenerated
     */
    @FieldDesc("应用是否公有的   true表示公有，谁都可以访问，至于应用内部的资源，应用程序自己决定，要想有公有的菜单，完全可以在前端写死")
    @NotNull(groups=MustNoneNull.class)
    private Boolean publicIs;

    /**
     * 服务注册中心的唯一标示： 比如eurake中的serviceId
     *
     * @mbggenerated
     */
    @FieldDesc("服务注册中心的唯一标示： 比如eurake中的serviceId")
    @Length(max=100)
    private String serviceId;

    /**
     * 应用程序的完整根路径
     *
     * @mbggenerated
     */
    @FieldDesc("应用程序的完整根路径")
    @Length(max=200)
    private String fullRootPath;

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
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
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
     * 应用所属单位Id
     *
     * @mbggenerated
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 应用所属单位Id
     *
     * @mbggenerated
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 单位所属体系编码
     *
     * @mbggenerated
     */
    public String getOrgSystemCode() {
        return orgSystemCode;
    }

    /**
     * 单位所属体系编码
     *
     * @mbggenerated
     */
    public void setOrgSystemCode(String orgSystemCode) {
        this.orgSystemCode = orgSystemCode == null ? null : orgSystemCode.trim();
    }

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 使用此应用，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    public Double getReduceTime() {
        return reduceTime;
    }

    /**
     * 使用此应用，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    public void setReduceTime(Double reduceTime) {
        this.reduceTime = reduceTime;
    }

    /**
     * 使用此应用，可以节省多少前（元）
     *
     * @mbggenerated
     */
    public Integer getReduceCost() {
        return reduceCost;
    }

    /**
     * 使用此应用，可以节省多少前（元）
     *
     * @mbggenerated
     */
    public void setReduceCost(Integer reduceCost) {
        this.reduceCost = reduceCost;
    }

    /**
     * 此应用程序的初始预计工期（人/天）
     *
     * @mbggenerated
     */
    public Double getOriginalTime() {
        return originalTime;
    }

    /**
     * 此应用程序的初始预计工期（人/天）
     *
     * @mbggenerated
     */
    public void setOriginalTime(Double originalTime) {
        this.originalTime = originalTime;
    }

    /**
     * 此应用程序的初始预计成本（人（元）
     *
     * @mbggenerated
     */
    public Integer getOriginalCost() {
        return originalCost;
    }

    /**
     * 此应用程序的初始预计成本（人（元）
     *
     * @mbggenerated
     */
    public void setOriginalCost(Integer originalCost) {
        this.originalCost = originalCost;
    }

    /**
     * 是否快速应用开发
     *
     * @mbggenerated
     */
    public String getIsFastApp() {
        return isFastApp;
    }

    /**
     * 是否快速应用开发
     *
     * @mbggenerated
     */
    public void setIsFastApp(String isFastApp) {
        this.isFastApp = isFastApp == null ? null : isFastApp.trim();
    }

    /**
     * 配置表关联ID
     *
     * @mbggenerated
     */
    public Long getBizConfigId() {
        return bizConfigId;
    }

    /**
     * 配置表关联ID
     *
     * @mbggenerated
     */
    public void setBizConfigId(Long bizConfigId) {
        this.bizConfigId = bizConfigId;
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

    /**
     * 使用此应用，可以节省多少建设成本（元）
     *
     * @mbggenerated
     */
    public Integer getReduceBuildCost() {
        return reduceBuildCost;
    }

    /**
     * 使用此应用，可以节省多少建设成本（元）
     *
     * @mbggenerated
     */
    public void setReduceBuildCost(Integer reduceBuildCost) {
        this.reduceBuildCost = reduceBuildCost;
    }

    /**
     * 使用此应用，可以节省多少使用成本（元）
     *
     * @mbggenerated
     */
    public Integer getReduceUseCost() {
        return reduceUseCost;
    }

    /**
     * 使用此应用，可以节省多少使用成本（元）
     *
     * @mbggenerated
     */
    public void setReduceUseCost(Integer reduceUseCost) {
        this.reduceUseCost = reduceUseCost;
    }

    /**
     * 使用此应用，可以节省多少维护成本（元）
     *
     * @mbggenerated
     */
    public Integer getReduceProtectCost() {
        return reduceProtectCost;
    }

    /**
     * 使用此应用，可以节省多少维护成本（元）
     *
     * @mbggenerated
     */
    public void setReduceProtectCost(Integer reduceProtectCost) {
        this.reduceProtectCost = reduceProtectCost;
    }

    /**
     * 应用是否公有的   true表示公有，谁都可以访问，至于应用内部的资源，应用程序自己决定，要想有公有的菜单，完全可以在前端写死
     *
     * @mbggenerated
     */
    public Boolean getPublicIs() {
        return publicIs;
    }

    /**
     * 应用是否公有的   true表示公有，谁都可以访问，至于应用内部的资源，应用程序自己决定，要想有公有的菜单，完全可以在前端写死
     *
     * @mbggenerated
     */
    public void setPublicIs(Boolean publicIs) {
        this.publicIs = publicIs;
    }

    /**
     * 服务注册中心的唯一标示： 比如eurake中的serviceId
     *
     * @mbggenerated
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 服务注册中心的唯一标示： 比如eurake中的serviceId
     *
     * @mbggenerated
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    /**
     * 应用程序的完整根路径
     *
     * @mbggenerated
     */
    public String getFullRootPath() {
        return fullRootPath;
    }

    /**
     * 应用程序的完整根路径
     *
     * @mbggenerated
     */
    public void setFullRootPath(String fullRootPath) {
        this.fullRootPath = fullRootPath == null ? null : fullRootPath.trim();
    }

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
}