package com.hengyunsoft.platform.security.dto.monitor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class MonitorServerReqDTO implements Serializable {

    @ApiModelProperty(value = "服务器IP")
    private String serverIp;

    @ApiModelProperty(value = "服务名称")
    private String Name;

    @ApiModelProperty(value = "处理状态")
    private Integer status;

}
