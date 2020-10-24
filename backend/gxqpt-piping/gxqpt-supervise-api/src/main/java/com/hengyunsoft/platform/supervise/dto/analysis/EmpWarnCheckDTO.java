package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class EmpWarnCheckDTO {
	@ApiModelProperty(value = "查询年份开始")
	private Date startTime;
	@ApiModelProperty(value = "查询年份结束")
	private Date endTime;
	@ApiModelProperty(value = "人员id")
	private String empId;
    @ApiModelProperty(value = "部门id")
    private String depId;
}
