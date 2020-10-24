package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogStructApache", description = "结构化apache日志")
public class LogStructApacheDTO extends LogStructApacheBaseDTO{
    @ApiModelProperty(value = "主键id")
    private Long id;
}
