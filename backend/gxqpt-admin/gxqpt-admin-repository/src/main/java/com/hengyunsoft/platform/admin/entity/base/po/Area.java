package com.hengyunsoft.platform.admin.entity.base.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Area extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 地区编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 全名
     *
     * @mbggenerated
     */
    private String fullName;

    /**
     * 排序
     *
     * @mbggenerated
     */
    private Integer orderNum;

    /**
     * 父id
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * 路径
     *
     * @mbggenerated
     */
    private String treePath;

    /**
     * 经度
     *
     * @mbggenerated
     */
    private String longitude;

    /**
     * 维度
     *
     * @mbggenerated
     */
    private String latitude;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 地区编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 地区编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 全名
     *
     * @mbggenerated
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 全名
     *
     * @mbggenerated
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 排序
     *
     * @mbggenerated
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序
     *
     * @mbggenerated
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
     * 路径
     *
     * @mbggenerated
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * 路径
     *
     * @mbggenerated
     */
    public void setTreePath(String treePath) {
        this.treePath = treePath == null ? null : treePath.trim();
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 维度
     *
     * @mbggenerated
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 维度
     *
     * @mbggenerated
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
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