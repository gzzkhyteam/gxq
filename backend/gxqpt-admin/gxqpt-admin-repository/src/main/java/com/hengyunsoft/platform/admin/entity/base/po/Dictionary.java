package com.hengyunsoft.platform.admin.entity.base.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Dictionary extends BaseEntity<Long> implements Serializable {
    @FieldDesc("")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
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
     * 类型id
     *
     * @mbggenerated
     */
    @FieldDesc("类型id")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
    private Long dictionaryTypeId;

    /**
     * 类型编码
     *
     * @mbggenerated
     */
    @FieldDesc("类型编码")
    @Length(max=100)
    private String dictionaryTypeCode;

    /**
     * 字典类型名称
     *
     * @mbggenerated
     */
    @FieldDesc("字典类型名称")
    @Length(max=255)
    private String dictionaryTypeName;

    /**
     * 字典编码
     *
     * @mbggenerated
     */
    @FieldDesc("字典编码")
    @Length(max=100)
    private String code;

    /**
     * 字典条目名称
     *
     * @mbggenerated
     */
    @FieldDesc("字典条目名称")
    @Length(max=255)
    private String name;

    /**
     * 是否删除
     1：已删除
     0：未删除
     *
     * @mbggenerated
     */
    @FieldDesc("是否删除 1：已删除 0：未删除")
    private Boolean isDelete;

    /**
     * 启用状态
    1：启用
    0：禁用
     *
     * @mbggenerated
    */
    @FieldDesc("启用状态 1：启用 0：禁用")
    private Boolean isEnable;

            /**
             * 排序号
             *
             * @mbggenerated
            */
    @FieldDesc("排序号")
    @Range(min=-2147483648,max=2147483647)
    private Integer orderNum;

    /**
     * 描述
     *
     * @mbggenerated
    */
    @FieldDesc("描述")
    @Length(max=255)
    private String description;

    /**
     * 创建时间
     *
     * @mbggenerated
    */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
    */
    @FieldDesc("创建人")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

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
     * 类型id
     *
     * @mbggenerated
     */
    public Long getDictionaryTypeId() {
        return dictionaryTypeId;
    }

    /**
     * 类型id
     *
     * @mbggenerated
     */
    public void setDictionaryTypeId(Long dictionaryTypeId) {
        this.dictionaryTypeId = dictionaryTypeId;
    }

    /**
     * 类型编码
     *
     * @mbggenerated
     */
    public String getDictionaryTypeCode() {
        return dictionaryTypeCode;
    }

    /**
     * 类型编码
     *
     * @mbggenerated
     */
    public void setDictionaryTypeCode(String dictionaryTypeCode) {
        this.dictionaryTypeCode = dictionaryTypeCode == null ? null : dictionaryTypeCode.trim();
    }

    /**
     * 字典类型名称
     *
     * @mbggenerated
     */
    public String getDictionaryTypeName() {
        return dictionaryTypeName;
    }

    /**
     * 字典类型名称
     *
     * @mbggenerated
     */
    public void setDictionaryTypeName(String dictionaryTypeName) {
        this.dictionaryTypeName = dictionaryTypeName == null ? null : dictionaryTypeName.trim();
    }

    /**
     * 字典编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 字典编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 字典条目名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 字典条目名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 是否删除 
     1：已删除
     0：未删除
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除 
     1：已删除
     0：未删除
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 启用状态
     1：启用
     0：禁用
     *
     * @mbggenerated
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 启用状态
     1：启用
     0：禁用
     *
     * @mbggenerated
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 排序号
     *
     * @mbggenerated
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序号
     *
     * @mbggenerated
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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
     * 更新人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}