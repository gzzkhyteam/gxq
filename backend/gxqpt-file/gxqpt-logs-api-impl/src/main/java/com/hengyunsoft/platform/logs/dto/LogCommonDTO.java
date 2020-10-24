package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LogCommonDTO {
    /**
     * 日志ID
     */
    private Long id;
    /**
     * 应用系统ID
     */
    private String appId;
    /**
     * 日志类型
     */
    private String logType;
    /**
     * 日志时间
     */
    @ApiModelProperty(value = "日志时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTime;
    /**
     * 响应时长
     */
    private Long timeConsum;
    /**
     * 日志内容
     */
    private String content;
    /**
     * 日志级别
     */
    private String level;
    /**
     * ip(ip数量统计)
     */
    private String ip;

}
