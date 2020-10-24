package com.hengyunsoft.platform.admin.entity.core.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Role extends CommonBaseEntity<Long> implements Serializable {
    @FieldDesc("")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
    private Long id;

    /**
     * 角色名称
     *
     * @mbggenerated
     */
    @FieldDesc("角色名称")
    @Length(max=30)
    private String name;

    /**
     * 角色编码
     *
     * @mbggenerated
     */
    @FieldDesc("角色编码")
    @Length(max=20)
    private String code;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @FieldDesc("功能描述")
    @Length(max=100)
    private String desc;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    @FieldDesc("状态： 1启用   2禁用")
    @Range(min=-32768,max=32767)
    private Short status;

    /**
     * 是否平台角色  
     *
     * @mbggenerated
     */
    @FieldDesc("是否平台角色  ")
    private Boolean ptRole;

    /**
     * 是否只读 不允许修改
     *
     * @mbggenerated
     */
    @FieldDesc("是否只读 不允许修改")
    private Boolean readonly;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
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
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    @FieldDesc("开发者ID，提供给各个应用的设别码")
    @Length(max=64)
    private String appId;

    /**
     * 业务标记    意义根据具体业务去定义
     *
     * @mbggenerated
     */
    @FieldDesc("业务标记    意义根据具体业务去定义")
    @Length(max=100)
    private String bizFlag;

    /**
     * 是否需要由权限管理系统进行统一的角色管理，在很多情况之下，角色是在各个业务系统内部自行维护的，不需要权限管理系统进行维护
     *
     * @mbggenerated
     */
    @FieldDesc("是否需要由权限管理系统进行统一的角色管理，在很多情况之下，角色是在各个业务系统内部自行维护的，不需要权限管理系统进行维护")
    private Boolean authManageIs;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 角色名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 角色编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 角色编码
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
     * 是否平台角色  
     *
     * @mbggenerated
     */
    public Boolean getPtRole() {
        return ptRole;
    }

    /**
     * 是否平台角色  
     *
     * @mbggenerated
     */
    public void setPtRole(Boolean ptRole) {
        this.ptRole = ptRole;
    }

    /**
     * 是否只读 不允许修改
     *
     * @mbggenerated
     */
    public Boolean getReadonly() {
        return readonly;
    }

    /**
     * 是否只读 不允许修改
     *
     * @mbggenerated
     */
    public void setReadonly(Boolean readonly) {
        this.readonly = readonly;
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

    /**
     * 业务标记    意义根据具体业务去定义
     *
     * @mbggenerated
     */
    public String getBizFlag() {
        return bizFlag;
    }

    /**
     * 业务标记    意义根据具体业务去定义
     *
     * @mbggenerated
     */
    public void setBizFlag(String bizFlag) {
        this.bizFlag = bizFlag == null ? null : bizFlag.trim();
    }

    /**
     * 是否需要由权限管理系统进行统一的角色管理，在很多情况之下，角色是在各个业务系统内部自行维护的，不需要权限管理系统进行维护
     *
     * @mbggenerated
     */
    public Boolean getAuthManageIs() {
        return authManageIs;
    }

    /**
     * 是否需要由权限管理系统进行统一的角色管理，在很多情况之下，角色是在各个业务系统内部自行维护的，不需要权限管理系统进行维护
     *
     * @mbggenerated
     */
    public void setAuthManageIs(Boolean authManageIs) {
        this.authManageIs = authManageIs;
    }
}