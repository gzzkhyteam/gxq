package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "TreeDTO", description = "树子类对象")
public class TreeChaildDTO {
	@ApiModelProperty(value = "名称")
	private String name;
}
