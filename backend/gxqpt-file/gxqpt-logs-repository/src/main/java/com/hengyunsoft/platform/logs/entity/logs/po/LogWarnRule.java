package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogWarnRule extends BaseEntity<Long> implements Serializable {
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
     * 文件类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    private String logType;

    /**
     * 规则编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 告警名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 告警规则类型，KEY:关键字告警；QUANTITY：数量告警;RESPONSE:响应时长
     *
     * @mbggenerated
     */
    private String warnType;

    /**
     * 告警级别，1：一级；2：二级；3：三级
     *
     * @mbggenerated
     */
    private String warnLevel;

    /**
     * 告警描述
     *
     * @mbggenerated
     */
    private String warnDescription;

    /**
     * 告警关键词，多个用“,”隔开
     *
     * @mbggenerated
     */
    private String keyContent;

    /**
     * 数量告警：时间间隔，单位：分钟
     *
     * @mbggenerated
     */
    private Long quantityTimeInterval;

    /**
     * 数量告警：日志级别
     *
     * @mbggenerated
     */
    private String quantityLogLevel;

    /**
     * 数量告警：日志条数上限
     *
     * @mbggenerated
     */
    private Long quantityUpperLimit;

    /**
     * 响应时长
     *
     * @mbggenerated
     */
    private Long responseDuration;

    /**
     * 是否启用 1：是；0：否
     *
     * @mbggenerated
     */
    private String isEnable;

    /**
     * 是否删除 1：是；0：否
     *
     * @mbggenerated
     */
    private String isDelete;

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
     * 文件类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 文件类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * 规则编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 规则编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 告警名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 告警名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 告警规则类型，KEY:关键字告警；QUANTITY：数量告警;RESPONSE:响应时长
     *
     * @mbggenerated
     */
    public String getWarnType() {
        return warnType;
    }

    /**
     * 告警规则类型，KEY:关键字告警；QUANTITY：数量告警;RESPONSE:响应时长
     *
     * @mbggenerated
     */
    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    /**
     * 告警级别，1：一级；2：二级；3：三级
     *
     * @mbggenerated
     */
    public String getWarnLevel() {
        return warnLevel;
    }

    /**
     * 告警级别，1：一级；2：二级；3：三级
     *
     * @mbggenerated
     */
    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel == null ? null : warnLevel.trim();
    }

    /**
     * 告警描述
     *
     * @mbggenerated
     */
    public String getWarnDescription() {
        return warnDescription;
    }

    /**
     * 告警描述
     *
     * @mbggenerated
     */
    public void setWarnDescription(String warnDescription) {
        this.warnDescription = warnDescription == null ? null : warnDescription.trim();
    }

    /**
     * 告警关键词，多个用“,”隔开
     *
     * @mbggenerated
     */
    public String getKeyContent() {
        return keyContent;
    }

    /**
     * 告警关键词，多个用“,”隔开
     *
     * @mbggenerated
     */
    public void setKeyContent(String keyContent) {
        this.keyContent = keyContent == null ? null : keyContent.trim();
    }

    /**
     * 数量告警：时间间隔，单位：分钟
     *
     * @mbggenerated
     */
    public Long getQuantityTimeInterval() {
        return quantityTimeInterval;
    }

    /**
     * 数量告警：时间间隔，单位：分钟
     *
     * @mbggenerated
     */
    public void setQuantityTimeInterval(Long quantityTimeInterval) {
        this.quantityTimeInterval = quantityTimeInterval;
    }

    /**
     * 数量告警：日志级别
     *
     * @mbggenerated
     */
    public String getQuantityLogLevel() {
        return quantityLogLevel;
    }

    /**
     * 数量告警：日志级别
     *
     * @mbggenerated
     */
    public void setQuantityLogLevel(String quantityLogLevel) {
        this.quantityLogLevel = quantityLogLevel == null ? null : quantityLogLevel.trim();
    }

    /**
     * 数量告警：日志条数上限
     *
     * @mbggenerated
     */
    public Long getQuantityUpperLimit() {
        return quantityUpperLimit;
    }

    /**
     * 数量告警：日志条数上限
     *
     * @mbggenerated
     */
    public void setQuantityUpperLimit(Long quantityUpperLimit) {
        this.quantityUpperLimit = quantityUpperLimit;
    }

    /**
     * 响应时长
     *
     * @mbggenerated
     */
    public Long getResponseDuration() {
        return responseDuration;
    }

    /**
     * 响应时长
     *
     * @mbggenerated
     */
    public void setResponseDuration(Long responseDuration) {
        this.responseDuration = responseDuration;
    }

    /**
     * 是否启用 1：是；0：否
     *
     * @mbggenerated
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 是否启用 1：是；0：否
     *
     * @mbggenerated
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    /**
     * 是否删除 1：是；0：否
     *
     * @mbggenerated
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除 1：是；0：否
     *
     * @mbggenerated
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
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