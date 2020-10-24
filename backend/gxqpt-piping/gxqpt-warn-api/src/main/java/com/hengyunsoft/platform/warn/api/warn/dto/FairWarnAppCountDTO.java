package com.hengyunsoft.platform.warn.api.warn.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class FairWarnAppCountDTO {
	@ApiModelProperty(value = "内部应用统计列表")
	private List<WarnAppCountDTO> inner;
	@ApiModelProperty(value = "接入应用统计列表")
	private List<WarnAppCountDTO> outer;

	public List<WarnAppCountDTO> getInner() {
		return inner;
	}

	public void setInner(List<WarnAppCountDTO> inner) {
		this.inner = inner;
	}

	public List<WarnAppCountDTO> getOuter() {
		return outer;
	}

	public void setOuter(List<WarnAppCountDTO> outer) {
		this.outer = outer;
	}
}
