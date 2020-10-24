package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 日志聚合查询
 */
@Data
@ApiModel(value = "LogStructTogetherQuery", description = "app、apache、tomcat、Nginx结构化日志查询参数对象")
public class LogStructTogetherQueryDTO {
    /**
     *日志记录（响应）条件：开始时间
     */
    @ApiModelProperty(value = "日志记录时间（条件开始）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date localTimeStart;
    /**
     *日志记录（响应）条件：结束时间
     */
    @ApiModelProperty(value = "日志记录时间（条件结束）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date localTimeEnd;
    /**
     *应用系统(多个以，号分隔)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统")
    private String appId;
    /**
     *日志类型(多个以，号分隔)APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;
    /**
     *排序字段
     */
    @ApiModelProperty(value = "排序字段")
    private String sidx;

    /**
     *排序方式，可选值：asc、desc
     */
    @ApiModelProperty(value = "排序方式，可选值：asc、desc")
    private String sord;
}
