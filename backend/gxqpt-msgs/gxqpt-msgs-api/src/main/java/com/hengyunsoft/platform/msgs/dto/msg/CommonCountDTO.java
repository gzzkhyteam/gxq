package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class CommonCountDTO {
	@ApiModelProperty(value = "服务模块名称")
	private String name;
	@ApiModelProperty(value = "消息数量")
	private Integer count;
}
