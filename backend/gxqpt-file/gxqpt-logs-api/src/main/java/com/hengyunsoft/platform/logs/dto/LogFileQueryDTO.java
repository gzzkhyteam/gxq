package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "LogFileQuery", description = "日志文件查询参数对象")
public class LogFileQueryDTO{
    /**
     * 应用系统(多个以，号分隔)
     */
    @ApiModelProperty(value = "应用系统")
    private String appId;
    /**
     * 日志类型(多个以，号分隔)
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;
    /**
     * 解析状态(多个以，号分隔)
     */
    @ApiModelProperty(value = "解析状态")
    private String isParsed;
    /**
     *上传开始时间
     */
    @ApiModelProperty(value = "上传开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeStart;
    /**
     *上传截止时间
     */
    @ApiModelProperty(value = "上传截止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeEnd;
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
