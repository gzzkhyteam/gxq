package com.hengyunsoft.platform.security.dto.monitor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class MonitorProcessReqDTO implements Serializable {
    @ApiModelProperty(value = "服务器IP")
    private String serverIp;

    @ApiModelProperty(value = "进程名")
    private String processName;

    @ApiModelProperty(value = "处理状态 0未处理 1已处理")
    private Integer status;

}
