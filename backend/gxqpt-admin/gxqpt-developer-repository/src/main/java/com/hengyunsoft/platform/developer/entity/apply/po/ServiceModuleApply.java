package com.hengyunsoft.platform.developer.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class ServiceModuleApply extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 图标
     *
     * @mbggenerated
     */
    @FieldDesc("图标")
    @Length(max=100)
    private String logo;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    @FieldDesc("功能名称")
    @Length(max=30)
    private String name;

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    @FieldDesc("功能编码")
    @Length(max=80)
    private String code;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @FieldDesc("功能描述")
    @Length(max=300)
    private String desc;

    /**
     * 状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用
     *
     * @mbggenerated
     */
    @FieldDesc("状态： 1、正常使用中   10、已过时（有新版本取代）     20、停止使用")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short status;

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    @FieldDesc("联系人邮箱")
    @Length(max=50)
    private String email;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @FieldDesc("所属应用appid")
    @Length(max=64)
    private String appId;

    /**
     * 模块类型
     *
     * @mbggenerated
     */
    @FieldDesc("模块类型")
    @Length(max=255)
    private String moduleType;

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
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    @FieldDesc("是否公有模块 所有人可调用(无需申请)")
    private Boolean publicIs;

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    @FieldDesc("是否公开模块   需要登陆才可以看到。")
    private Boolean publicLook;

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    @FieldDesc("API接口文档地址")
    @Length(max=300)
    private String apiSyncUrl;

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    @FieldDesc("资源数量（接口数量）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer resourceNum;

    /**
     * 停用日期（停止使用/维护日期）
     *
     * @mbggenerated
     */
    @FieldDesc("停用日期（停止使用/维护日期）")
    private Date stopTime;

    /**
     * 建议使用模块
     *
     * @mbggenerated
     */
    @FieldDesc("建议使用模块")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long adviceModule;

    /**
     * 申请状态： 1、待审核     11、已通过      21、被拒绝
     *
     * @mbggenerated
     */
    @FieldDesc("申请状态： 1、待审核     11、已通过      21、被拒绝")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short applyStatus;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    @FieldDesc("申请人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long applyUser;

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    @FieldDesc("申请人名称")
    @Length(max=255)
    private String applyUserName;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    @FieldDesc("审批人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long auditUser;

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    @FieldDesc("审批人名称")
    @Length(max=255)
    private String auditUserName;

    /**
     * 申请备注
     *
     * @mbggenerated
     */
    @FieldDesc("申请备注")
    @Length(max=500)
    private String applyDesc;

    /**
     * 审批备注
     *
     * @mbggenerated
     */
    @FieldDesc("审批备注")
    @Length(max=500,message="长度最大不超过500")
    private String auditDesc;

    /**
     * 申请成功的模块id
     *
     * @mbggenerated
     */
    @FieldDesc("申请成功的模块id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long successPassModuleId;

    /**
     * 使用此服务，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此服务，可以节省多少工期（人/天）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Double reduceTime;

    /**
     * 使用此服务，可以节省多少前（元）
     *
     * @mbggenerated
     */
    @FieldDesc("使用此服务，可以节省多少前（元）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer reduceCost;

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

    /**
     * 申请状态： 1、待审核     11、已通过      21、被拒绝
     *
     * @mbggenerated
     */
    public Short getApplyStatus() {
        return applyStatus;
    }

    /**
     * 申请状态： 1、待审核     11、已通过      21、被拒绝
     *
     * @mbggenerated
     */
    public void setApplyStatus(Short applyStatus) {
        this.applyStatus = applyStatus;
    }

    /**
     * 申请人
     *
     * @mbggenerated
     */
    public Long getApplyUser() {
        return applyUser;
    }

    /**
     * 申请人
     *
     * @mbggenerated
     */
    public void setApplyUser(Long applyUser) {
        this.applyUser = applyUser;
    }

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    public String getApplyUserName() {
        return applyUserName;
    }

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName == null ? null : applyUserName.trim();
    }

    /**
     * 审批人
     *
     * @mbggenerated
     */
    public Long getAuditUser() {
        return auditUser;
    }

    /**
     * 审批人
     *
     * @mbggenerated
     */
    public void setAuditUser(Long auditUser) {
        this.auditUser = auditUser;
    }

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    public String getAuditUserName() {
        return auditUserName;
    }

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName == null ? null : auditUserName.trim();
    }

    /**
     * 申请备注
     *
     * @mbggenerated
     */
    public String getApplyDesc() {
        return applyDesc;
    }

    /**
     * 申请备注
     *
     * @mbggenerated
     */
    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
    }

    /**
     * 审批备注
     *
     * @mbggenerated
     */
    public String getAuditDesc() {
        return auditDesc;
    }

    /**
     * 审批备注
     *
     * @mbggenerated
     */
    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }

    /**
     * 申请成功的模块id
     *
     * @mbggenerated
     */
    public Long getSuccessPassModuleId() {
        return successPassModuleId;
    }

    /**
     * 申请成功的模块id
     *
     * @mbggenerated
     */
    public void setSuccessPassModuleId(Long successPassModuleId) {
        this.successPassModuleId = successPassModuleId;
    }

    /**
     * 使用此服务，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    public Double getReduceTime() {
        return reduceTime;
    }

    /**
     * 使用此服务，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    public void setReduceTime(Double reduceTime) {
        this.reduceTime = reduceTime;
    }

    /**
     * 使用此服务，可以节省多少前（元）
     *
     * @mbggenerated
     */
    public Integer getReduceCost() {
        return reduceCost;
    }

    /**
     * 使用此服务，可以节省多少前（元）
     *
     * @mbggenerated
     */
    public void setReduceCost(Integer reduceCost) {
        this.reduceCost = reduceCost;
    }
}