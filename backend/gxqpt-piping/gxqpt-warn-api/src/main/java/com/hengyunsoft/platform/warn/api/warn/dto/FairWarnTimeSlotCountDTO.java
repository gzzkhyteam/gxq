package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;

public class FairWarnTimeSlotCountDTO {

	//待处理数量
	@ApiModelProperty(value = "待处理数量")
	private Integer pending;
	//新增数量
	@ApiModelProperty(value = "新增数量")
	private Integer newCome;	
	//已处理数量
	@ApiModelProperty(value = "已处理数量")
	private Integer handled;
	//年份、月份
	@ApiModelProperty(value = "年份、月份")
	private String month;
	//平均确认时长
	@ApiModelProperty(value = "平均确认时长")
	private String avgConfirmTime;
	//平均处理时长
	@ApiModelProperty(value = "平均处理时长")
	private String avgHandleTime;
	public Integer getPending() {
		return pending;
	}
	public void setPending(Integer pending) {
		this.pending = pending;
	}
	public Integer getNewCome() {
		return newCome;
	}
	public void setNewCome(Integer newCome) {
		this.newCome = newCome;
	}
	public Integer getHandled() {
		return handled;
	}
	public void setHandled(Integer handled) {
		this.handled = handled;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getAvgConfirmTime() {
		return avgConfirmTime;
	}
	public void setAvgConfirmTime(String avgConfirmTime) {
		this.avgConfirmTime = avgConfirmTime;
	}
	public String getAvgHandleTime() {
		return avgHandleTime;
	}
	public void setAvgHandleTime(String avgHandleTime) {
		this.avgHandleTime = avgHandleTime;
	}	
}
