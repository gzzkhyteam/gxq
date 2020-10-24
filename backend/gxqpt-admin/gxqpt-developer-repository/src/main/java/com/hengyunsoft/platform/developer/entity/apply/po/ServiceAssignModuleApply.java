package com.hengyunsoft.platform.developer.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class ServiceAssignModuleApply extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 功能id
     *
     * @mbggenerated
     */
    @FieldDesc("功能id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long moduleId;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @FieldDesc("所属应用appid")
    @Length(max=64)
    private String appId;

    /**
     * 审核状态： 1  待审核     2 审核通过    3 审核不通过    
     *
     * @mbggenerated
     */
    @FieldDesc("审核状态： 1  待审核     2 审核通过    3 审核不通过")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short status;

    /**
     * 审核描述
     *
     * @mbggenerated
     */
    @FieldDesc("审核描述")
    @Length(max=500,message="长度最大不超过500")
    private String auditDesc;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    @FieldDesc("申请描述")
    @Length(max=500)
    private String applyDesc;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    @FieldDesc("审批人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long auditUser;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    @FieldDesc("申请人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long applyUser;

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
     * 服务分配模块id（表示这条审批通过后，关联的分配id）
     *
     * @mbggenerated
     */
    @FieldDesc("服务分配模块id（表示这条审批通过后，关联的分配id）")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long serviceAssignModuleId;

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    @FieldDesc("申请人名称")
    @Length(max=20)
    private String applyUserName;

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    @FieldDesc("审批人名称")
    @Length(max=20)
    private String auditUserName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 功能id
     *
     * @mbggenerated
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * 功能id
     *
     * @mbggenerated
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
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
     * 审核状态： 1  待审核     2 审核通过    3 审核不通过    
     *
     * @mbggenerated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 审核状态： 1  待审核     2 审核通过    3 审核不通过    
     *
     * @mbggenerated
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 审核描述
     *
     * @mbggenerated
     */
    public String getAuditDesc() {
        return auditDesc;
    }

    /**
     * 审核描述
     *
     * @mbggenerated
     */
    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    public String getApplyDesc() {
        return applyDesc;
    }

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
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
     * 服务分配模块id（表示这条审批通过后，关联的分配id）
     *
     * @mbggenerated
     */
    public Long getServiceAssignModuleId() {
        return serviceAssignModuleId;
    }

    /**
     * 服务分配模块id（表示这条审批通过后，关联的分配id）
     *
     * @mbggenerated
     */
    public void setServiceAssignModuleId(Long serviceAssignModuleId) {
        this.serviceAssignModuleId = serviceAssignModuleId;
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
}