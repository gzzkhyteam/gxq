package com.hengyunsoft.platform.developer.entity.fast.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FastBizConfig extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 资源编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 资源类型  1：业务场景 2：菜单
     *
     * @mbggenerated
     */
    private Short type;

    /**
     * 路径
     *
     * @mbggenerated
     */
    private String url;

    /**
     * 打开方式：_self：相同框架 _top：整页  _blank：新建一个窗口  _paren：父窗口   按照a标签走
     *
     * @mbggenerated
     */
    private String target;

    /**
     * 状态    1、启用    2禁用
     *
     * @mbggenerated
     */
    private Short status;

    /**
     * 序号
     *
     * @mbggenerated
     */
    private Integer orderNo;

    /**
     * 菜单图标 
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 菜单分组 参照字典
     *
     * @mbggenerated
     */
    private String group;

    /**
     * 层级
     *
     * @mbggenerated
     */
    private String leve;

    /**
     * 父级菜单id
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
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
     * 资源类型  1：业务场景 2：菜单
     *
     * @mbggenerated
     */
    public Short getType() {
        return type;
    }

    /**
     * 资源类型  1：业务场景 2：菜单
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
}