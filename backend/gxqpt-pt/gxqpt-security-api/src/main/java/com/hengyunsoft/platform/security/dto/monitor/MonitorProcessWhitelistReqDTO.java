package com.hengyunsoft.platform.security.dto.monitor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class MonitorProcessWhitelistReqDTO {
    @ApiModelProperty(value = "服务器ip")
    private String serverIp;
}
