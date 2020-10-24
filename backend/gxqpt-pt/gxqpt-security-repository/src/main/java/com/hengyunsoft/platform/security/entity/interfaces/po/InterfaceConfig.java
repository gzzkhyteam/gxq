package com.hengyunsoft.platform.security.entity.interfaces.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class InterfaceConfig extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    private String apiName;

    /**
     * 接口id
     *
     * @mbggenerated
     */
    private Long apiId;

    /**
     * 接口地址
     *
     * @mbggenerated
     */
    private String apiUrl;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    private String modularName;

    /**
     * 请求方式 post/get/put/delete..
     *
     * @mbggenerated
     */
    private String method;

    /**
     * 每5分钟错误次数
     *
     * @mbggenerated
     */
    private Integer errorCountMinute;

    /**
     * 每日上限次数 0表示无上限
     *
     * @mbggenerated
     */
    private Integer upperLimitCountByDay;

    /**
     * 是否短信通知 0否, 1是
     *
     * @mbggenerated
     */
    private Boolean isSmsNotify;

    /**
     * 接收通知电话号码
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 是否已通知 0未通知 1已通知
     *
     * @mbggenerated
     */
    private Boolean isNotify;

    /**
     * 状态 1 已设置 0 未设置
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 创建日期
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
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 最后修改人
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
     * 接口名称
     *
     * @mbggenerated
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    /**
     * 接口id
     *
     * @mbggenerated
     */
    public Long getApiId() {
        return apiId;
    }

    /**
     * 接口id
     *
     * @mbggenerated
     */
    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    /**
     * 接口地址
     *
     * @mbggenerated
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * 接口地址
     *
     * @mbggenerated
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    public String getModularName() {
        return modularName;
    }

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    public void setModularName(String modularName) {
        this.modularName = modularName == null ? null : modularName.trim();
    }

    /**
     * 请求方式 post/get/put/delete..
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * 请求方式 post/get/put/delete..
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 每5分钟错误次数
     *
     * @mbggenerated
     */
    public Integer getErrorCountMinute() {
        return errorCountMinute;
    }

    /**
     * 每5分钟错误次数
     *
     * @mbggenerated
     */
    public void setErrorCountMinute(Integer errorCountMinute) {
        this.errorCountMinute = errorCountMinute;
    }

    /**
     * 每日上限次数 0表示无上限
     *
     * @mbggenerated
     */
    public Integer getUpperLimitCountByDay() {
        return upperLimitCountByDay;
    }

    /**
     * 每日上限次数 0表示无上限
     *
     * @mbggenerated
     */
    public void setUpperLimitCountByDay(Integer upperLimitCountByDay) {
        this.upperLimitCountByDay = upperLimitCountByDay;
    }

    /**
     * 是否短信通知 0否, 1是
     *
     * @mbggenerated
     */
    public Boolean getIsSmsNotify() {
        return isSmsNotify;
    }

    /**
     * 是否短信通知 0否, 1是
     *
     * @mbggenerated
     */
    public void setIsSmsNotify(Boolean isSmsNotify) {
        this.isSmsNotify = isSmsNotify;
    }

    /**
     * 接收通知电话号码
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 接收通知电话号码
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 是否已通知 0未通知 1已通知
     *
     * @mbggenerated
     */
    public Boolean getIsNotify() {
        return isNotify;
    }

    /**
     * 是否已通知 0未通知 1已通知
     *
     * @mbggenerated
     */
    public void setIsNotify(Boolean isNotify) {
        this.isNotify = isNotify;
    }

    /**
     * 状态 1 已设置 0 未设置
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 1 已设置 0 未设置
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建日期
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建日期
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
     * 最后修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 最后修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}