package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "LogStructTogether", description = "结构化app、apache、tomcat、Nginx")
public class LogStructTogetherDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "日志记录时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTime;

    @ApiModelProperty(value = "应用系统ID")
    private String appId;

    @ApiModelProperty(value = "文档Id")
    private String documentId;

    @ApiModelProperty(value = "日志类型")
    private String logType;

    @ApiModelProperty(value = "日志详情")
    private String detailContent;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

}
