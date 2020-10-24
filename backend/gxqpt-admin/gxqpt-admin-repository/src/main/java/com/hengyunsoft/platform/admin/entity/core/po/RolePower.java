package com.hengyunsoft.platform.admin.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class RolePower extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    private Long bizId;

    /**
     * 业务类型 1资源    2应用
     *
     * @mbggenerated
     */
    private Short bizType;

    /**
     * 角色id
     *
     * @mbggenerated
     */
    private Long roleId;

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
     * 业务id
     *
     * @mbggenerated
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * 业务类型 1资源    2应用
     *
     * @mbggenerated
     */
    public Short getBizType() {
        return bizType;
    }

    /**
     * 业务类型 1资源    2应用
     *
     * @mbggenerated
     */
    public void setBizType(Short bizType) {
        this.bizType = bizType;
    }

    /**
     * 角色id
     *
     * @mbggenerated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     *
     * @mbggenerated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public Date getUpdateTime() {
        return null;
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

	@Override
	public void setUpdateTime(Date nowDate) {
		
	}
}