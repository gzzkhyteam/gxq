package com.hengyunsoft.platform.developer.entity.fast.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FastAppRelation extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    private String fastAppId;

    private String appId;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、模块等等）
     *
     * @mbggenerated
     */
    private String type;

    private Long createUser;

    private Date createTime;

    private Long updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFastAppId() {
        return fastAppId;
    }

    public void setFastAppId(String fastAppId) {
        this.fastAppId = fastAppId == null ? null : fastAppId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
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
}