package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogWarning extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 日志类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    private String logType;

    /**
     * 规则id
     *
     * @mbggenerated
     */
    private Long ruleId;

    /**
     * 告警信息描述
     *
     * @mbggenerated
     */
    private String logDescription;

    /**
     * 状态，0：未处理；1：已处理
     *
     * @mbggenerated
     */
    private String isDeal;

    /**
     * 处理结果，DEAL：处理；WRONG：误告；IGNORE：忽略
     *
     * @mbggenerated
     */
    private String dealResult;

    /**
     * 处理结果描述
     *
     * @mbggenerated
     */
    private String dealResultDescription;

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
     * 创建人姓名
     *
     * @mbggenerated
     */
    private String createUserName;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    private String updateUserName;

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
     * 应用系统id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 日志类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 日志类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * 规则id
     *
     * @mbggenerated
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 规则id
     *
     * @mbggenerated
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 告警信息描述
     *
     * @mbggenerated
     */
    public String getLogDescription() {
        return logDescription;
    }

    /**
     * 告警信息描述
     *
     * @mbggenerated
     */
    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription == null ? null : logDescription.trim();
    }

    /**
     * 状态，0：未处理；1：已处理
     *
     * @mbggenerated
     */
    public String getIsDeal() {
        return isDeal;
    }

    /**
     * 状态，0：未处理；1：已处理
     *
     * @mbggenerated
     */
    public void setIsDeal(String isDeal) {
        this.isDeal = isDeal == null ? null : isDeal.trim();
    }

    /**
     * 处理结果，DEAL：处理；WRONG：误告；IGNORE：忽略
     *
     * @mbggenerated
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * 处理结果，DEAL：处理；WRONG：误告；IGNORE：忽略
     *
     * @mbggenerated
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult == null ? null : dealResult.trim();
    }

    /**
     * 处理结果描述
     *
     * @mbggenerated
     */
    public String getDealResultDescription() {
        return dealResultDescription;
    }

    /**
     * 处理结果描述
     *
     * @mbggenerated
     */
    public void setDealResultDescription(String dealResultDescription) {
        this.dealResultDescription = dealResultDescription == null ? null : dealResultDescription.trim();
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
     * 创建人姓名
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }
}