package com.hengyunsoft.platform.sms.dto;

public class AppointAppDTO {
	//主键id
	private Long id;
	//第三方申请账号
	private String account;
	//应用程序id 多个用英文逗号隔开
	private String appId;
	//应用程序名称 多个用英文逗号隔开
	private String appName;
	//创建人
	private String createUser;
	// 绑定/取消绑定 0=绑定 1=取消绑定
	private Integer tag;
	
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
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
}
