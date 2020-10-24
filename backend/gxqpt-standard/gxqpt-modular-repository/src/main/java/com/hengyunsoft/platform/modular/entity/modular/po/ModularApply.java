package com.hengyunsoft.platform.modular.entity.modular.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ModularApply extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    @FieldDesc("id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private Long id;

    /**
     * 申请类型    CATEGORYAPPLY:分类申请   TAGAPPLY:标签申请
     *
     * @mbggenerated
     */
    @FieldDesc("申请类型    CATEGORYAPPLY:分类申请   TAGAPPLY:标签申请")
    @Length(max=64)
    private String applyType;

    /**
     * 申请名称
     *
     * @mbggenerated
     */
    @FieldDesc("申请名称")
    @Length(max=64)
    private String name;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    @FieldDesc("申请描述")
    @Length(max=255)
    private String description;

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    @FieldDesc("申请原因")
    @Length(max=255)
    private String reason;

    /**
     * 是否处理     1:已处理    0:待处理
     *
     * @mbggenerated
     */
    @FieldDesc("是否处理     1:已处理    0:待处理")
    private Boolean isDeal;

    /**
     * 处理结果     PASS：通过  REJECT：驳回
     *
     * @mbggenerated
     */
    @FieldDesc("处理结果     PASS：通过  REJECT：驳回")
    @Length(max=64)
    private String dealResult;

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    @FieldDesc("处理意见")
    @Length(max=64)
    private String dealSuggestion;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    @FieldDesc("申请人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @FieldDesc("申请时间")
    private Date createTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    @FieldDesc("修改人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    @FieldDesc("修改时间")
    private Date updateTime;

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    @FieldDesc("申请人姓名")
    @Length(max=64)
    private String createUserName;

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    @FieldDesc("修改人姓名")
    @Length(max=64)
    private String updateUserName;

    /**
     * 申请单位
     *
     * @mbggenerated
     */
    @FieldDesc("申请单位")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createCompany;

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    @FieldDesc("申请单位名称")
    @Length(max=64)
    private String createCompanyName;

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 申请类型    CATEGORYAPPLY:分类申请   TAGAPPLY:标签申请
     *
     * @mbggenerated
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * 申请类型    CATEGORYAPPLY:分类申请   TAGAPPLY:标签申请
     *
     * @mbggenerated
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * 申请名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 申请名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 是否处理     1:已处理    0:待处理
     *
     * @mbggenerated
     */
    public Boolean getIsDeal() {
        return isDeal;
    }

    /**
     * 是否处理     1:已处理    0:待处理
     *
     * @mbggenerated
     */
    public void setIsDeal(Boolean isDeal) {
        this.isDeal = isDeal;
    }

    /**
     * 处理结果     PASS：通过  REJECT：驳回
     *
     * @mbggenerated
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * 处理结果     PASS：通过  REJECT：驳回
     *
     * @mbggenerated
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult == null ? null : dealResult.trim();
    }

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    public String getDealSuggestion() {
        return dealSuggestion;
    }

    /**
     * 处理意见
     *
     * @mbggenerated
     */
    public void setDealSuggestion(String dealSuggestion) {
        this.dealSuggestion = dealSuggestion == null ? null : dealSuggestion.trim();
    }

    /**
     * 申请人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 申请人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    /**
     * 申请单位
     *
     * @mbggenerated
     */
    public Long getCreateCompany() {
        return createCompany;
    }

    /**
     * 申请单位
     *
     * @mbggenerated
     */
    public void setCreateCompany(Long createCompany) {
        this.createCompany = createCompany;
    }

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    public String getCreateCompanyName() {
        return createCompanyName;
    }

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    public void setCreateCompanyName(String createCompanyName) {
        this.createCompanyName = createCompanyName == null ? null : createCompanyName.trim();
    }
}