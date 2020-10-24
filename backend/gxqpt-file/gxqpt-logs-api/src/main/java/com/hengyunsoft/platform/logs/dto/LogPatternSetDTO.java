package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogPatternSet", description = "日志格式")
public class LogPatternSetDTO extends LogPatternSetBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;
}
