package com.hengyunsoft.platform.sms.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TreeDTO", description = "树对象")
public class TreeDTO {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "结束时间")
	private List<TreeChaildDTO> children;
}
