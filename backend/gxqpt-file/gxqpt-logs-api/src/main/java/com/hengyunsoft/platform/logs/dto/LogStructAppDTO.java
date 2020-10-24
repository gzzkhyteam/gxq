package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogStructApp", description = "结构化应用系统日志")
public class LogStructAppDTO extends LogStructAppBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;
}
