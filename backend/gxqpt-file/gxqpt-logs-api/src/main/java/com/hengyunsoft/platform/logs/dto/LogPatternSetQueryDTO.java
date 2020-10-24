package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 */
@Data
@ApiModel(value = "LogPatternSetQuery", description = "按条件查询日志格式")
public class LogPatternSetQueryDTO {
    /**
     *应用系统(多个以，号分隔)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统")
    private String appId;
}
