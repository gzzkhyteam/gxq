package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModelProperty;

public class ServiceAccountMsgDTO {
	@ApiModelProperty(value = "主键ID")
	private Long id;
	@ApiModelProperty(value = "服务账号名称")
	private String name;
	@ApiModelProperty(value = "服务账号")
	private String account;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}	
}
