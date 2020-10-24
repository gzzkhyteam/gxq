package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "DepWarnLevelReq", description = "部门预警级别接收参数")
public class DepWarnLevelReqDTO {
	@ApiModelProperty(value = "查询年份")
	private String year;
	
	@ApiModelProperty(value = "部门id")
	private String departmentId;
}
