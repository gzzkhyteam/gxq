package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TemplateDTO", description = "模板对象")
public class TemplateDTO {
	@ApiModelProperty(value = "模板id")
	private Long id;
	@ApiModelProperty(value = "模板名称")
	private String name;
	@ApiModelProperty(value = "模板参数")
	private String param;
}
