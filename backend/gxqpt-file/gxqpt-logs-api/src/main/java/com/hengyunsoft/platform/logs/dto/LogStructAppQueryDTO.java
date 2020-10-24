package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 按查询条件显示
 */
@Data
@ApiModel(value = "LogStructAppQuery", description = "应用系统结构化日志查询参数对象")
public class LogStructAppQueryDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     *日志记录开始时间
     */
    @ApiModelProperty(value = "日志记录开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTimeStart;
    /**
     *日志记录结束时间
     */
    @ApiModelProperty(value = "日志记录结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTimeEnd;
    /**
     *类名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类名")
    private String className;
    /**
     *日志级别(多个以，号分隔)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志级别")
    private String level;
    /**
     *应用系统(多个以，号分隔)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统")
    private String appId;
    /**
     *日志内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志内容")
    private String content;
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
