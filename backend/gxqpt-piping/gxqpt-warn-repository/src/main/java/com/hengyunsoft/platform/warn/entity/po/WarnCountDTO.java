package com.hengyunsoft.platform.warn.entity.po;

public class WarnCountDTO {
	//预警发生人名称
	private String empName;
	//预警部门名称
	private String departmentName;
	//预警应用名称
	private String appName;	
	//预警发送数量
	private Integer count;
	//预警处理状态
	private String status;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
