package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogOpenDelete extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用系统ID
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * ip
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * 服务调用时间
     *
     * @mbggenerated
     */
    private Date callServeTime;

    /**
     * 删除条件
     *
     * @mbggenerated
     */
    private String deleteCondition;

    /**
     * 删除数量
     *
     * @mbggenerated
     */
    private Long deleteCount;

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

    private String createUserName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用系统ID
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用系统ID
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * ip
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 服务调用时间
     *
     * @mbggenerated
     */
    public Date getCallServeTime() {
        return callServeTime;
    }

    /**
     * 服务调用时间
     *
     * @mbggenerated
     */
    public void setCallServeTime(Date callServeTime) {
        this.callServeTime = callServeTime;
    }

    /**
     * 删除条件
     *
     * @mbggenerated
     */
    public String getDeleteCondition() {
        return deleteCondition;
    }

    /**
     * 删除条件
     *
     * @mbggenerated
     */
    public void setDeleteCondition(String deleteCondition) {
        this.deleteCondition = deleteCondition == null ? null : deleteCondition.trim();
    }

    /**
     * 删除数量
     *
     * @mbggenerated
     */
    public Long getDeleteCount() {
        return deleteCount;
    }

    /**
     * 删除数量
     *
     * @mbggenerated
     */
    public void setDeleteCount(Long deleteCount) {
        this.deleteCount = deleteCount;
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

    @Override
    public void setUpdateTime(Date nowDate) {

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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }
}