package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "EmpWarnLevelRes", description = "人员预警级别返回参数")
public class EmpWarnLevelResDTO {
	@ApiModelProperty(value = "预警类型")
	private Integer level;
	@ApiModelProperty(value = "预警数量")
	private Integer count;
}
