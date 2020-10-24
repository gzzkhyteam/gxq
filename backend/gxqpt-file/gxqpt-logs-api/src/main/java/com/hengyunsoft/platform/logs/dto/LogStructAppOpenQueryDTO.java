package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 按查询条件显示
 */
@Data
@ApiModel(value = "LogStructAppOpenQuery", description = "(对外开放接口)应用系统结构化日志查询参数对象")
public class LogStructAppOpenQueryDTO {
    /**
     *日志记录开始时间
     */
    @ApiModelProperty(value = "日志记录开始时间 yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTimeStart;
    /**
     *日志记录结束时间
     */
    @ApiModelProperty(value = "日志记录结束时间 yyyy-MM-dd HH:mm:ss")
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
    @ApiModelProperty(value = "日志级别 可选值：INFO|DEBUG|WARN|ERROR|FATAL")
    private String level;
    /**
     *日志内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志内容")
    private String content;
}
