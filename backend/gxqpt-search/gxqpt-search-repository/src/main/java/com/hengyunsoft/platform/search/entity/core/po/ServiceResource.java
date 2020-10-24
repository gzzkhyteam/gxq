package com.hengyunsoft.platform.search.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ServiceResource extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 功能模块id
     *
     * @mbggenerated
     */
    @FieldDesc("功能模块id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long moduleId;

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    @FieldDesc("资源名称")
    @Length(max=100)
    private String name;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @FieldDesc("功能描述")
    @Length(max=200)
    private String desc;

    /**
     * 资源编码
     *
     * @mbggenerated
     */
    @FieldDesc("资源编码")
    @Length(max=20)
    private String code;

    /**
     * 路径
     *
     * @mbggenerated
     */
    @FieldDesc("路径")
    @Length(max=100)
    private String url;

    /**
     * get/post/all
     *
     * @mbggenerated
     */
    @FieldDesc("get/post/all")
    @Length(max=10)
    private String httpMethod;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    @FieldDesc("状态： 1启用   2禁用")
    @Range(min=Short.MIN_VALUE,max=Short.MAX_VALUE)
    private Short status;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @FieldDesc("序号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer orderNo;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @FieldDesc("所属应用appid")
    @Length(max=64)
    private String appId;

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

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 功能模块id
     *
     * @mbggenerated
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * 功能模块id
     *
     * @mbggenerated
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 资源编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 资源编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 路径
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * 路径
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * get/post/all
     *
     * @mbggenerated
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * get/post/all
     *
     * @mbggenerated
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod == null ? null : httpMethod.trim();
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
}