package com.hengyunsoft.platform.warn.entity.domain;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class FairWarnAppCountDO {
	@ApiModelProperty(value = "内部应用统计列表")
	private List<WarnAppCountDO> inner;
	@ApiModelProperty(value = "接入应用统计列表")
	private List<WarnAppCountDO> outer;
}
