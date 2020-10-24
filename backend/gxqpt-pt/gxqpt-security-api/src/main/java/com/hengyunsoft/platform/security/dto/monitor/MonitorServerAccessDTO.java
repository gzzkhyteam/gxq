package com.hengyunsoft.platform.security.dto.monitor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class MonitorServerAccessDTO implements Serializable {

    @ApiModelProperty(value = "来访服务器ip")
    private String fromServerIp;

    @ApiModelProperty(value = "目标服务器ip")
    private String toServerIp;

    @ApiModelProperty(value = "账户")
    private String account;

    @ApiModelProperty(value = "登入时间（pattern:yyyy-mm-dd HH:mm:ss）")
    private String loginTime;

    @ApiModelProperty(value = "注销时间（pattern:yyyy-mm-dd HH:mm:ss）")
    private String logoutTime;

    @ApiModelProperty(value = "登录时长")
    private String loginDuration;

}
