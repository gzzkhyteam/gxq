package com.hengyunsoft.platform.security.dto.monitor;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class MonitorProcessSelectDTO implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "服务器ip")
    private String serverIp;

    @ApiModelProperty(value = "进程id")
    private String processId;

    @ApiModelProperty(value = "进程名称")
    private String processName;

    @ApiModelProperty(value = "账号")
    private String account;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "预警时间")
    private Date warnTime;

    @ApiModelProperty(value = "处理人")
    private String handleUser;

    @ApiModelProperty(value = "处理人姓名")
    private String handleUserName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "处理时间")
    private Date handleTime;

    @ApiModelProperty(value = "处理状态 0未处理 1已处理")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
