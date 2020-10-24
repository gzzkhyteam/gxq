package com.hengyunsoft.platform.admin.entity.core.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Resource extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
    @NotNull
    private Long id;

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    @FieldDesc("资源名称")
    @Length(max=20)
    @NotNull
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
    @Length(max=255)
    private String code;

    /**
     * 资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口
     *
     * @mbggenerated
     */
    @FieldDesc("资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口")
    @Range(min=-32768,max=32767)
    private Short type;

    /**
     * 路径
     *
     * @mbggenerated
     */
    @FieldDesc("路径")
    @Length(max=100)
    private String url;

    /**
     * 打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走
     *
     * @mbggenerated
     */
    @FieldDesc("打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走")
    @Length(max=9)
    private String target;

    /**
     * 状态    1、启用    2禁用
     *
     * @mbggenerated
     */
    @FieldDesc("状态    1、启用    2禁用")
    @Range(min=-32768,max=32767)
    private Short status;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @FieldDesc("序号")
    @Range(min=-2147483648,max=2147483647)
    private Integer orderNo;

    /**
     * 菜单图标
     *
     * @mbggenerated
     */
    @FieldDesc("菜单图标")
    @Length(max=255)
    private String icon;

    /**
     * 菜单分组 参照字典
     *
     * @mbggenerated
     */
    @FieldDesc("菜单分组 参照字典")
    @Length(max=20)
    private String group;

    /**
     * 层级
     *
     * @mbggenerated
     */
    @FieldDesc("层级")
    @Length(max=200)
    private String leve;

    /**
     * 父级菜单id
     *
     * @mbggenerated
     */
    @FieldDesc("父级菜单id")
    @Range(min=-9223372036854775808L,max=9223372036854775807L)
    private Long parentId;

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
     * 是否公有资源，就是无需分配就可以访问的。所有人可见
     *
     * @mbggenerated
     */
    @FieldDesc("是否公有资源，就是无需分配就可以访问的。所有人可见")
    @NotNull
    private Boolean publicIs;

    /**
     * 需要后端做认证的资源集合；比如审批界面中有 通过，驳回，跳过等等操作，那么都对应有需要后端认证的地址。地址间有分号;分割， 公有资源不需要填写此项，填写了也不做过滤
     *
     * @mbggenerated
     */
    @FieldDesc("需要后端做认证的资源集合；比如审批界面中有 通过，驳回，跳过等等操作，那么都对应有需要后端认证的地址。地址间有分号;分割， 公有资源不需要填写此项，填写了也不做过滤")
    @Length(max=500)
    private String authUrls;

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
     * 资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口
     *
     * @mbggenerated
     */
    public Short getType() {
        return type;
    }

    /**
     * 资源类型  1：菜单  2：菜单页面中的链接（按钮）   3：api 服务接口
     *
     * @mbggenerated
     */
    public void setType(Short type) {
        this.type = type;
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
     * 打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走
     *
     * @mbggenerated
     */
    public String getTarget() {
        return target;
    }

    /**
     * 打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走
     *
     * @mbggenerated
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * 状态    1、启用    2禁用
     *
     * @mbggenerated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 状态    1、启用    2禁用
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
     * 菜单图标
     *
     * @mbggenerated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     *
     * @mbggenerated
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 菜单分组 参照字典
     *
     * @mbggenerated
     */
    public String getGroup() {
        return group;
    }

    /**
     * 菜单分组 参照字典
     *
     * @mbggenerated
     */
    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
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
     * 父级菜单id
     *
     * @mbggenerated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级菜单id
     *
     * @mbggenerated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 是否公有资源，就是无需分配就可以访问的。所有人可见
     *
     * @mbggenerated
     */
    public Boolean getPublicIs() {
        return publicIs;
    }

    /**
     * 是否公有资源，就是无需分配就可以访问的。所有人可见
     *
     * @mbggenerated
     */
    public void setPublicIs(Boolean publicIs) {
        this.publicIs = publicIs;
    }

    /**
     * 需要后端做认证的资源集合；比如审批界面中有 通过，驳回，跳过等等操作，那么都对应有需要后端认证的地址。地址间有分号;分割， 公有资源不需要填写此项，填写了也不做过滤
     *
     * @mbggenerated
     */
    public String getAuthUrls() {
        return authUrls;
    }

    /**
     * 需要后端做认证的资源集合；比如审批界面中有 通过，驳回，跳过等等操作，那么都对应有需要后端认证的地址。地址间有分号;分割， 公有资源不需要填写此项，填写了也不做过滤
     *
     * @mbggenerated
     */
    public void setAuthUrls(String authUrls) {
        this.authUrls = authUrls == null ? null : authUrls.trim();
    }
}