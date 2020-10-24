package com.hengyunsoft.platform.sms.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SmsTemplateListDTO {
	//主键id
	private Long id;
	//模板名称
	private String name;
	//匹配服务账号
	private String channelName;	
	//模板编码 ：第三方申请的模板id
	private String templateCode;
	//模板描述
	private String templateDescribe;
	//模板创建人
	private String createUserName;
    //模板创建时间
    private Date createTime;
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
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public String getTemplateDescribe() {
		return templateDescribe;
	}
	public void setTemplateDescribe(String templateDescribe) {
		this.templateDescribe = templateDescribe;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}    
}
