package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AnalysisRespondsDTO", description = "各应用、服务使用情况分析")
public class AnalysisRespondsDTO {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "数量")
	private Integer count;
}
