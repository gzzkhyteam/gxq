package com.hengyunsoft.platform.developer.entity.fast.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApplicationRelation extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 平台或应用的主键id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 根据type区分是服务id或者模块id
     *
     * @mbggenerated
     */
    private String bizId;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、模块等等）
     *
     * @mbggenerated
     */
    private String type;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 平台或应用的主键id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 平台或应用的主键id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 根据type区分是服务id或者模块id
     *
     * @mbggenerated
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 根据type区分是服务id或者模块id
     *
     * @mbggenerated
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、模块等等）
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、模块等等）
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}