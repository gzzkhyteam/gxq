package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogFile", description = "日志文件")
public class LogFileDTO extends LogFileBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;
}
