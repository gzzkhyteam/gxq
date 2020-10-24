package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogWarnRuleUpdate", description = "修改告警规则")
public class LogWarnRuleUpdateDTO extends LogWarnRuleBaseDTO{
    @ApiModelProperty(value = "id")
    private Long id;
}
