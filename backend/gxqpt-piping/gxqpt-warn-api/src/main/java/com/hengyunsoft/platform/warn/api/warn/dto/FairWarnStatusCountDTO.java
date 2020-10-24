package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 数博会预警统计
 * @author dxz
 */
public class FairWarnStatusCountDTO {
	//处理状态
	@ApiModelProperty(value = "处理状态")
	private String status;
	//各个状态的数量
	@ApiModelProperty(value = "各个状态的数量")
	private Long count;
	//平均处理时长
	@ApiModelProperty(value = "平均处理时长")
	private Double time;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
}
