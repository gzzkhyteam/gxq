package com.hengyunsoft.platform.sms.entity.template.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AnalysisRespondsDO", description = "各应用、服务使用情况分析")
public class AnalysisRespondsDO {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "数量")
	private Integer count;
}
