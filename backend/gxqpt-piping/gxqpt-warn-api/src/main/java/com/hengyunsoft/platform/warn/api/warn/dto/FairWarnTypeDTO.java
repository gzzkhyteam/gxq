package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class FairWarnTypeDTO {
	//预警类型
	@ApiModelProperty(value = "预警类型")
	private String type;
	//各个状态的数量
	@ApiModelProperty(value = "各个状态的数量")
	private Long count;
}
