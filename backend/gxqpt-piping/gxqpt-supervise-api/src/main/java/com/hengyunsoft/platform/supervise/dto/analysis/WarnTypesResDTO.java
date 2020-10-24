package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WarnTypesResDTO {
	@ApiModelProperty(value = "单位/部门/人员/应用id")
	private String id;
	@ApiModelProperty(value = "单位/部门/人员/应用名称")
	private String name;
	@ApiModelProperty(value = "预警类型id")
	private Long typeId;
	@ApiModelProperty(value = "预警类型")
	private String type;
	@ApiModelProperty(value = "预警数量")
	private Integer count;
}
