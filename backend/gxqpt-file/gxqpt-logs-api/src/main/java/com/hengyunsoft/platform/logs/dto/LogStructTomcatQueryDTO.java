package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "LogStructTomcatQuery", description = "Tomcat结构化日志查询参数对象")
public class LogStructTomcatQueryDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     *日志记录（响应）条件：开始时间
     */
    @ApiModelProperty(value = "日志响应时间（条件开始）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTimeStart;
    /**
     *日志记录（响应）条件：结束时间
     */
    @ApiModelProperty(value = "日志响应时间（条件结束）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTimeEnd;
    /**
     * 请求的URL路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求的URL路径")
    private String requestUrl;
    /**
     *为响应请求而耗费的开始时间，以秒计
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "为响应请求而耗费的开始时间，以秒计")
    private Long timeConsumStart;
    /**
     *为响应请求而耗费的结束时间，以秒计
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "为响应请求而耗费的结束时间，以秒计")
    private Long timeConsumEnd;
    /**
     *远程IP地址(客户端ip)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端ip")
    private String remoteIp;
    /**
     *应用系统(多个以，号分隔)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统")
    private String appId;
    /**
     *状态(多个以，号分隔)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private String status;
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
