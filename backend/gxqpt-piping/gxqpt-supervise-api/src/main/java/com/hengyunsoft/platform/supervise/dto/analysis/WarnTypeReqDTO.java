package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "WarnTypeReqDTO", description = "预警类型接收参数")
public class WarnTypeReqDTO {
	@ApiModelProperty(value = "查询年份")
	private String year;
	
	@ApiModelProperty(value = "单位/部门/人员/应用id")
	private String id;
	
}
