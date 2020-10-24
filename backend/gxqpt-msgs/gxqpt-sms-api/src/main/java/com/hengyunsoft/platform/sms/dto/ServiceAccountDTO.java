package com.hengyunsoft.platform.sms.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceAccountDTO {
	//主键id
	private Long id;
	//服务账号
	private String account;
	//渠道名称
	private String name;
    //渠道类型
    private Integer channelType;
	//服务商英文名称
	private String channelServer;
	//服务商中文名称
	private String channelServerName;
	//第三方申请编码
	private String appId;
	//第三方申请密钥
	private String appSecret;
	//现有短信量
	private Long existing;
	//账号描述
	private String description;
	//创建人名称
	private String createUserName;
	//创建人id
	private Long createUser;	
	//指定的应用名称
	private List<String> apps;
	//指定的应用ID
	private List<String> appIds;
	//创建时间
	private Date createTime;
	/**
	 * 已用短信量
	 */
    private Long used;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getChannelType() {
		return channelType;
	}
	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}
	public String getChannelServer() {
		return channelServer;
	}
	public void setChannelServer(String channelServer) {
		this.channelServer = channelServer;
	}
	public String getChannelServerName() {
		return channelServerName;
	}
	public void setChannelServerName(String channelServerName) {
		this.channelServerName = channelServerName;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public Long getExisting() {
		return existing;
	}
	public void setExisting(Long existing) {
		this.existing = existing;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	public List<String> getApps() {
		return apps;
	}
	public void setApps(List<String> apps) {
		this.apps = apps;
	}
	
	public List<String> getAppIds() {
		return appIds;
	}
	public void setAppIds(List<String> appIds) {
		this.appIds = appIds;
	}
	public Long getUsed() {
		return used;
	}
	public void setUsed(Long used) {
		this.used = used;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
