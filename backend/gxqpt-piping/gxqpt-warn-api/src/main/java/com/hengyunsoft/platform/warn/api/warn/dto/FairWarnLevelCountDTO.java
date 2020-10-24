package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;

public class FairWarnLevelCountDTO {
	//预警级别
	@ApiModelProperty(value = "预警级别")
	private Integer level;
	//各个状态的数量
	@ApiModelProperty(value = "各个状态的数量")
	private Long count;

	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
}
