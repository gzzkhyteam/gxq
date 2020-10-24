package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogWarningUpdate", description = "告警处理")
public class LogWarningUpdateDTO extends LogWarningBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;
}
