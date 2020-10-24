package com.hengyunsoft.platform.ops.entity.person.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class DealUser extends BaseEntity<Long> implements Serializable {
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
    private Long bussId;

    /**
     * 人员id
     *
     * @mbggenerated
     */
    private Long personId;

    /**
     * 处理人姓名
     *
     * @mbggenerated
     */
    private String personName;

    /**
     * 人员类型(咨询人zxr，协助人xzr，处理人clr)
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 创建人
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
     * 更新人
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
     * 业务id
     *
     * @mbggenerated
     */
    public Long getBussId() {
        return bussId;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public void setBussId(Long bussId) {
        this.bussId = bussId;
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * 处理人姓名
     *
     * @mbggenerated
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * 处理人姓名
     *
     * @mbggenerated
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * 人员类型
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 人员类型
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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