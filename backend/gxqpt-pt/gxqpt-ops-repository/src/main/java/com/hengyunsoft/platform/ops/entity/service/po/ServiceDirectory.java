package com.hengyunsoft.platform.ops.entity.service.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ServiceDirectory extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 父id
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * 排序
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * 层级
     *
     * @mbggenerated
     */
    private Integer level;

    /**
     * 类型
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    private String serviceName;

    /**
     * 服务简介
     *
     * @mbggenerated
     */
    private String serviceInfo;

    /**
     * 服务成果
     *
     * @mbggenerated
     */
    private String serviceResult;

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
     * 排序
     *
     * @mbggenerated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     *
     * @mbggenerated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 层级
     *
     * @mbggenerated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 层级
     *
     * @mbggenerated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 类型
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 服务名称
     *
     * @mbggenerated
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    /**
     * 服务简介
     *
     * @mbggenerated
     */
    public String getServiceInfo() {
        return serviceInfo;
    }

    /**
     * 服务简介
     *
     * @mbggenerated
     */
    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo == null ? null : serviceInfo.trim();
    }

    /**
     * 服务成果
     *
     * @mbggenerated
     */
    public String getServiceResult() {
        return serviceResult;
    }

    /**
     * 服务成果
     *
     * @mbggenerated
     */
    public void setServiceResult(String serviceResult) {
        this.serviceResult = serviceResult == null ? null : serviceResult.trim();
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