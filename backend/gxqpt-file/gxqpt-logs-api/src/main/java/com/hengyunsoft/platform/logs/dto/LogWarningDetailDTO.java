package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 回溯分析功能返回内容
 */
@Data
@ApiModel(value = "LogWarningDetail", description = "告警日志详细列表")
public class LogWarningDetailDTO extends  LogWarningBaseDTO{
    @ApiModelProperty(value = "主键id")
    private Long id;

}
