package com.hengyunsoft.platform.warn.api.warn.dto;

public class FairWarnNumberCountDTO {
	private String appId;
	private String appName;	
	private Integer count;
	private String tag;
	private String confirmCostTime;
	private String handleCostTime;
	
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getConfirmCostTime() {
		return confirmCostTime;
	}
	public void setConfirmCostTime(String confirmCostTime) {
		this.confirmCostTime = confirmCostTime;
	}
	public String getHandleCostTime() {
		return handleCostTime;
	}
	public void setHandleCostTime(String handleCostTime) {
		this.handleCostTime = handleCostTime;
	}	
}
