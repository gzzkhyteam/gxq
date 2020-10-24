package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "WarnTypeReq", description = "预警类型返回参数")
public class WarnTypeResDTO {
	@ApiModelProperty(value = "预警类型")
	private String type;
	@ApiModelProperty(value = "预警数量")
	private Integer count;
}
