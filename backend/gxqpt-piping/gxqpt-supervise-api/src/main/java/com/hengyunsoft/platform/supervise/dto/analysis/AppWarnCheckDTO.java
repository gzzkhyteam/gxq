package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class AppWarnCheckDTO {
	@ApiModelProperty(value = "查询年份开始")
	private Date startTime;
	@ApiModelProperty(value = "查询年份结束")
	private Date endTime;
	@ApiModelProperty(value = "应用id")
	private String appId;
}
