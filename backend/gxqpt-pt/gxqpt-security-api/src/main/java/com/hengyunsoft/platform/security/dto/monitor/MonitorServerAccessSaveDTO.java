package com.hengyunsoft.platform.security.dto.monitor;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class MonitorServerAccessSaveDTO implements Serializable {
    @ApiModelProperty(value = "来访者IP")
    private  String fromServerIp;

    @ApiModelProperty(value = "目的IP")
    private String toServerIp;

    @ApiModelProperty(value = "账户")
    private String account;

    @ApiModelProperty(value = "登入时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginTime;

    @ApiModelProperty(value = "登出时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logoutTime;

    @ApiModelProperty(value = "持续时间")
    private String loginDuration;
}
