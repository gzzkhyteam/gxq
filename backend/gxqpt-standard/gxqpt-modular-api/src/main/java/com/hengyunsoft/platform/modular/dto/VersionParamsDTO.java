package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VersionParamsDTO {
	@ApiModelProperty(value = "文件id")
	private String fileId;
	@ApiModelProperty(value = "文件下载地址")
	private String filePath;
	@ApiModelProperty(value = "文件类型，sources：源码、doc：API文档、help：帮助文档")
	private String classifier;
}
