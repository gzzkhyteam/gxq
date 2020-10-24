package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AppWarnTypeResDTO", description = "应用预警类型返回参数")
public class AppWarnTypeResDTO {
	@ApiModelProperty(value = "预警类型")
	private String type;
	@ApiModelProperty(value = "应用预警数量")
	private Integer app;
	@ApiModelProperty(value = "平均预警数量")
	private Integer avg;
}
