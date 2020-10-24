package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "LogStructNginx", description = "结构化Nginx")
public class LogStructNginxDTO extends LogStructNginxBaseDTO{
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     *日志时间
     */
    @ApiModelProperty(value = "日志时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTime;

    /**
     *  应用系统ID
     */
    @ApiModelProperty(value = "应用系统ID")
    private String appId;
    /**
     *  日志类型
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;
    /**
     *  日志级别
     */
    @ApiModelProperty(value = "日志级别")
    private String logLevel;
}
