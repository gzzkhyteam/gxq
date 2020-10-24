package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ApiModel(value = "LogWarning", description = "日志告警")
public class LogWarningDTO extends LogWarningBaseDTO{
    @ApiModelProperty(value = "主键id")
    private Long id;
}
