package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModelProperty;

public class FairWarnLevelCountDO {
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
