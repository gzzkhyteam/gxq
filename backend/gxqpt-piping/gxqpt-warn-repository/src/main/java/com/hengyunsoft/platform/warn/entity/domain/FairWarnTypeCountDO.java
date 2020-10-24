package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModelProperty;

public class FairWarnTypeCountDO {
	//应用名称
	@ApiModelProperty(value = "应用ID")
	private String appId;
	//应用名称
	@ApiModelProperty(value = "应用名称")
	private String appName;
	//预警类型
	@ApiModelProperty(value = "预警类型")
	private String type;
	//各个状态的数量
	@ApiModelProperty(value = "各个状态的数量")
	private Long count;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}	
}
