package com.hengyunsoft.platform.sms.entity.template.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class SmsChannelOwner extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 第三方申请的账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    private String appId;

    private String appName;

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    private Long channelId;

    /**
     * 渠道名称
     *
     * @mbggenerated
     */
    private String channelName;

    /**
     * 渠道服务商英文名称
     *
     * @mbggenerated
     */
    private String channelServer;

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
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 第三方申请的账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 第三方申请的账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 渠道id
     *
     * @mbggenerated
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    /**
     * 渠道名称
     *
     * @mbggenerated
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 渠道名称
     *
     * @mbggenerated
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 渠道服务商英文名称
     *
     * @mbggenerated
     */
    public String getChannelServer() {
        return channelServer;
    }

    /**
     * 渠道服务商英文名称
     *
     * @mbggenerated
     */
    public void setChannelServer(String channelServer) {
        this.channelServer = channelServer == null ? null : channelServer.trim();
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

    public Long getCreateUser() {
		return createUser;
	}

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
}