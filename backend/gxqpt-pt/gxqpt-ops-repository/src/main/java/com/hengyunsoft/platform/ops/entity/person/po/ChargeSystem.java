package com.hengyunsoft.platform.ops.entity.person.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ChargeSystem extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 业务表id
     *
     * @mbggenerated
     */
    private Long pId;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String systemName;

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
     * id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 运维人员管理表id
     *
     * @mbggenerated
     */
    public Long getpId() {
        return pId;
    }

    /**
     * 运维人员管理表id
     *
     * @mbggenerated
     */
    public void setpId(Long pId) {
        this.pId = pId;
    }

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 系统id
     *
     * @mbggenerated
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
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