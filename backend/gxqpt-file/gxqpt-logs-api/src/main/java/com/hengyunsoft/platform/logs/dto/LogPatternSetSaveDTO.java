package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "LogPatternSetSave", description = "日志格式保存")
public class LogPatternSetSaveDTO extends LogPatternSetBaseDTO {
}
