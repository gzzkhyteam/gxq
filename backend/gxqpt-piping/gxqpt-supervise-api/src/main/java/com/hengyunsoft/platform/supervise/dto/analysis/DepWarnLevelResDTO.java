package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DepWarnLevelRes", description = "部门预警级别返回参数")
public class DepWarnLevelResDTO {
	@ApiModelProperty(value = "预警类型")
	private Integer level;
	@ApiModelProperty(value = "预警数量")
	private Integer count;
}
