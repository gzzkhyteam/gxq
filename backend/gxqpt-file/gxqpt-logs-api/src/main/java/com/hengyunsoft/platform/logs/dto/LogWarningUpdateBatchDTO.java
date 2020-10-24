package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogWarningUpdateBatch", description = "告警处理")
public class LogWarningUpdateBatchDTO extends LogWarningBaseDTO {
    /**
     * id 集合，多个ID用“，”号分隔
     */
    @ApiModelProperty(value = "主键ids")
    private String ids;
}
