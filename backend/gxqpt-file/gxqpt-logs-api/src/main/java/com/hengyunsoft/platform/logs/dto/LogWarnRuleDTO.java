package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogWarnRule", description = "告警规则")
public class LogWarnRuleDTO extends LogWarnRuleBaseDTO{
    @ApiModelProperty(value = "主键id")
    private Long id;
}
