package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "LogWarnRuleSave", description = "保存告警规则")
public class LogWarnRuleSaveDTO extends LogWarnRuleBaseDTO{

}
