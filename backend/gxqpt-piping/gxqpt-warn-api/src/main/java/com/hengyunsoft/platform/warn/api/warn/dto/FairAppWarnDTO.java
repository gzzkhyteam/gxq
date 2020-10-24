package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;

public class FairAppWarnDTO {
	//应用id
	@ApiModelProperty(value = "应用id")
	private String appId;
	//应用名称
	@ApiModelProperty(value = "应用名称")
	private String appName;
	//预警名称
	@ApiModelProperty(value = "预警名称")
	private String title;
	//预警级别
	@ApiModelProperty(value = "预警级别")
	private Integer level;
	//预警到现在的时间
	@ApiModelProperty(value = "预警到现在的时间")
	private Double timeSlot;
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
