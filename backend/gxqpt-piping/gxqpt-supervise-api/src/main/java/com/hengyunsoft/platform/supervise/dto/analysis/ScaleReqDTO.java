package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ScaleReqDTO {
	@ApiModelProperty(value = "单位/部门/人员/应用id")
	private String id;
	@ApiModelProperty(value = "查询开始月份")
	private String startMonth;
	@ApiModelProperty(value = "查询结束月份")
	private String endMonth;
	@ApiModelProperty(value = "查询年份")
	private String year;
}
