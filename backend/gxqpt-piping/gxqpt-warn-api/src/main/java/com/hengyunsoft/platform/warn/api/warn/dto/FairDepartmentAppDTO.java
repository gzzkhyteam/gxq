package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;

public class FairDepartmentAppDTO {
	//部门id	
	@ApiModelProperty(value = "部门id")
	private String departmentId;
	//部门名称
	@ApiModelProperty(value = "部门名称")
	private String department;
	//应用id
	@ApiModelProperty(value = "应用id")
	private String appId;
	//应用名称
	@ApiModelProperty(value = "应用名称")
	private String appName;
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
}
