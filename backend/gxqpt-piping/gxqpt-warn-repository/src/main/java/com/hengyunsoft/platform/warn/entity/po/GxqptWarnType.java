package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class GxqptWarnType extends BaseEntity<Long> implements Serializable {
    /**
     * 启用
     */
    public static  final Boolean ENABLE = true;
    /**
     * 禁用
     */
    public static  final Boolean UNENABLE = false;
    /**
     * 主键id
     *
     * @mbggenerated
     */
    @FieldDesc("主键id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 预警编码  说明:不允许修改
     *
     * @mbggenerated
     */
    @FieldDesc("预警编码  说明:不允许修改")
    @Length(max=100)
    private String code;

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    @FieldDesc("分类名称")
    @Length(max=20)
    private String typeName;

    /**
     * 父id，最高层父id默认为-1
     *
     * @mbggenerated
     */
    @FieldDesc("父id，最高层父id默认为-1")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long parentId;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @FieldDesc("序号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer orderNo;

    /**
     * 类型描述
     *
     * @mbggenerated
     */
    @FieldDesc("类型描述")
    @Length(max=255)
    private String context;

    /**
     * 是否启用 1：启用 0：禁用
     *
     * @mbggenerated
     */
    @FieldDesc("是否启用 1：启用 0：禁用")
    private Boolean isEnable;

    /**
     * 层级
     *
     * @mbggenerated
     */
    @FieldDesc("层级")
    private String leve;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @Length(max=20)
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @Length(max=20)
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 预警编码  说明:不允许修改
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 预警编码  说明:不允许修改
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 父id，最高层父id默认为-1
     *
     * @mbggenerated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父id，最高层父id默认为-1
     *
     * @mbggenerated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 类型描述
     *
     * @mbggenerated
     */
    public String getContext() {
        return context;
    }

    /**
     * 类型描述
     *
     * @mbggenerated
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * 是否启用 1：启用 0：禁用
     *
     * @mbggenerated
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 是否启用 1：启用 0：禁用
     *
     * @mbggenerated
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 层级
     *
     * @mbggenerated
     */
    public String getLeve() {
        return leve;
    }

    /**
     * 层级
     *
     * @mbggenerated
     */
    public void setLeve(String leve) {
        this.leve = leve == null ? null : leve.trim();
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
     * 更新人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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
}