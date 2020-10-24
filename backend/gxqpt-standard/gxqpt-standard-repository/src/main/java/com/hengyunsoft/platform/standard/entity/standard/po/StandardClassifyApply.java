package com.hengyunsoft.platform.standard.entity.standard.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class StandardClassifyApply extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    @FieldDesc("分类名称")
    @Length(max=255)
    private String name;

    /**
     * 父id
     *
     * @mbggenerated
     */
    @FieldDesc("父id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long parentId;

    /**
     * 父级名称
     *
     * @mbggenerated
     */
    @FieldDesc("父级名称")
    @Length(max=64)
    private String parentName;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @FieldDesc("描述")
    @Length(max=255)
    private String description;

    /**
     * 排序号，数字越大越靠后
     *
     * @mbggenerated
     */
    @FieldDesc("排序号，数字越大越靠后")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer sortNo;

    /**
     * 是否处理
            1：启用
            0：禁用
     *
     * @mbggenerated
     */
    @FieldDesc("是否处理 1：启用 0：禁用")
    private Boolean isDeal;

    /**
     * 处理结果
            DEAL：处理完成
            REJECT：禁用
     *
     * @mbggenerated
     */
    @FieldDesc("处理结果 DEAL：处理完成 REJECT：禁用")
    @Length(max=64)
    private String dealResult;

    /**
     * 处理结果描述
     *
     * @mbggenerated
     */
    @FieldDesc("处理结果描述")
    @Length(max=64)
    private String dealResultDescription;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    private Date createTime;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    private Date updateTime;

    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    @FieldDesc("创建人姓名")
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

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createCompany;

    @Length(max=64)
    private String createCompanyName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父id
     *
     * @mbggenerated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父id
     *
     * @mbggenerated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 父级名称
     *
     * @mbggenerated
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 父级名称
     *
     * @mbggenerated
     */
    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 排序号，数字越大越靠后
     *
     * @mbggenerated
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 排序号，数字越大越靠后
     *
     * @mbggenerated
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 是否处理
            1：启用
            0：禁用
     *
     * @mbggenerated
     */
    public Boolean getIsDeal() {
        return isDeal;
    }

    /**
     * 是否处理
            1：启用
            0：禁用
     *
     * @mbggenerated
     */
    public void setIsDeal(Boolean isDeal) {
        this.isDeal = isDeal;
    }

    /**
     * 处理结果
            DEAL：处理完成
            REJECT：禁用
     *
     * @mbggenerated
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * 处理结果
            DEAL：处理完成
            REJECT：禁用
     *
     * @mbggenerated
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult == null ? null : dealResult.trim();
    }

    /**
     * 处理结果描述
     *
     * @mbggenerated
     */
    public String getDealResultDescription() {
        return dealResultDescription;
    }

    /**
     * 处理结果描述
     *
     * @mbggenerated
     */
    public void setDealResultDescription(String dealResultDescription) {
        this.dealResultDescription = dealResultDescription == null ? null : dealResultDescription.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人姓名
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

    public Long getCreateCompany() {
        return createCompany;
    }

    public void setCreateCompany(Long createCompany) {
        this.createCompany = createCompany;
    }

    public String getCreateCompanyName() {
        return createCompanyName;
    }

    public void setCreateCompanyName(String createCompanyName) {
        this.createCompanyName = createCompanyName == null ? null : createCompanyName.trim();
    }
}