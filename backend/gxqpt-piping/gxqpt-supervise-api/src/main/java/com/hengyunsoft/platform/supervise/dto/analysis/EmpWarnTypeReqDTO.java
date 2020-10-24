package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "EmpWarnTypeReq", description = "人员预警类型接收参数")
public class EmpWarnTypeReqDTO {
	@ApiModelProperty(value = "查询年份")
	private String year;
	
	@ApiModelProperty(value = "人员id")
	private String empId;
	
	@ApiModelProperty(value = "部门id")
	private String depId;
}
