package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogPatternSetUpdate", description = "日志格式修改")
public class LogPatternSetUpdateDTO extends LogPatternSetBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;
}
