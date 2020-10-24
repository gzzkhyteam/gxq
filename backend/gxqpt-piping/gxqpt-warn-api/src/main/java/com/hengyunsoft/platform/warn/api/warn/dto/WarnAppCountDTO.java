package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;

public class WarnAppCountDTO {
	@ApiModelProperty(value = "应用名称")
	private String appName;
	@ApiModelProperty(value = "预警数量")
	private Integer count;

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

}
