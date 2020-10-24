package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;

public class FairDepartmentDTO {
	//部门id	
	@ApiModelProperty(value = "部门id")
	private String departmentId;
	//部门名称
	@ApiModelProperty(value = "部门名称")
	private String department;
	//预警名称
	@ApiModelProperty(value = "预警名称")
	private String title;
	//预警级别
	@ApiModelProperty(value = "预警级别")
	private Integer level;
	//预警到现在的时间
	@ApiModelProperty(value = "预警到现在的时间")
	private Double timeSlot;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Double getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(Double timeSlot) {
		this.timeSlot = timeSlot;
	}	
}
