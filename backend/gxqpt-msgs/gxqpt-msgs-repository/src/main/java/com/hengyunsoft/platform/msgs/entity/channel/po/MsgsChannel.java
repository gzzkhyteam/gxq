package com.hengyunsoft.platform.msgs.entity.channel.po;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;

public class MsgsChannel extends CommonBaseEntity<Long> implements Serializable {
	/**
     * 渠道
     *
     * @mbggenerated
     */
    @FieldDesc("渠道")
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 渠道类型
     *
     * @mbggenerated
     */
    @FieldDesc("渠道类型")
    private Integer channelType;

    /**
     * 微博用户access_token
     *
     * @mbggenerated
     */
    @FieldDesc("微博用户access_token")
    private String accessToken;

    /**
     * 渠道所属账号
     *
     * @mbggenerated
     */
    @FieldDesc("渠道所属账号")
    private String account;

    /**
     * 名称
     *
     * @mbggenerated
     */
    @FieldDesc("名称")
    private String name;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @FieldDesc("描述")
    private String description;

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    @FieldDesc("应用编码")
    private String appId;

    /**
     * 应用密钥
     *
     * @mbggenerated
     */
    @FieldDesc("应用密钥")
    private String appSecret;

    /**
     * 短信编码0禁用1启用
     *
     * @mbggenerated
     */
    @FieldDesc("短信编码0禁用1启用")
    private String msgCode;

    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    @FieldDesc("创建人姓名")
    private String createUserName;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    @FieldDesc("修改人")
    private Long updateUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    @FieldDesc("修改时间")
    private Date updateTime;

    /**
     * 现有短信量
     *
     * @mbggenerated
     */
    @FieldDesc("现有短信量")
    private Long existing;

    /**
     * 已用短信量
     *
     * @mbggenerated
     */
    @FieldDesc("已用短信量")
    private Long used;

    /**
     * 渠道服务商英文名称
     *
     * @mbggenerated
     */
    @FieldDesc("渠道服务商英文名称")
    @Length(max=50)
    private String channelServer;

    /**
     * 渠道服务商名称
     *
     * @mbggenerated
     */
    @FieldDesc("渠道服务商名称")
    @Length(max=100)
    private String channelServerName;

    private static final long serialVersionUID = 1L;

    /**
     * 渠道
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 渠道
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 渠道类型
     *
     * @mbggenerated
     */
    public Integer getChannelType() {
        return channelType;
    }

    /**
     * 渠道类型
     *
     * @mbggenerated
     */
    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    /**
     * 微博用户access_token
     *
     * @mbggenerated
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 微博用户access_token
     *
     * @mbggenerated
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    /**
     * 渠道所属账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 渠道所属账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 应用密钥
     *
     * @mbggenerated
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 应用密钥
     *
     * @mbggenerated
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    /**
     * 短信编码0禁用1启用
     *
     * @mbggenerated
     */
    public String getMsgCode() {
        return msgCode;
    }

    /**
     * 短信编码0禁用1启用
     *
     * @mbggenerated
     */
    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode == null ? null : msgCode.trim();
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
     * 现有短信量
     *
     * @mbggenerated
     */
    public Long getExisting() {
        return existing;
    }

    /**
     * 现有短信量
     *
     * @mbggenerated
     */
    public void setExisting(Long existing) {
        this.existing = existing;
    }

    /**
     * 已用短信量
     *
     * @mbggenerated
     */
    public Long getUsed() {
        return used;
    }

    /**
     * 已用短信量
     *
     * @mbggenerated
     */
    public void setUsed(Long used) {
        this.used = used;
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
     * 渠道服务商名称
     *
     * @mbggenerated
     */
    public String getChannelServerName() {
        return channelServerName;
    }

    /**
     * 渠道服务商名称
     *
     * @mbggenerated
     */
    public void setChannelServerName(String channelServerName) {
        this.channelServerName = channelServerName == null ? null : channelServerName.trim();
    }
}