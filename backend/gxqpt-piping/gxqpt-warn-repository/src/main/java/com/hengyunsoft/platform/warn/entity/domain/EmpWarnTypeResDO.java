package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EmpWarnTypeReq", description = "人员预警类型返回参数")
public class EmpWarnTypeResDO {
	@ApiModelProperty(value = "预警类型")
	private String type;
	@ApiModelProperty(value = "预警数量")
	private Integer count;
}
