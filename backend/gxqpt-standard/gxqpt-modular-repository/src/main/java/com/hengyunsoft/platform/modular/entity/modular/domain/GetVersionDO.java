package com.hengyunsoft.platform.modular.entity.modular.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetVersionDO {
	@ApiModelProperty(value = "用户id")
	private Long userId;
	@ApiModelProperty(value = "分组id")
	private String groupId;
	@ApiModelProperty(value = "工具id")
	private String artifactId;
	@ApiModelProperty(value = "版本号")
	private String version;
}
