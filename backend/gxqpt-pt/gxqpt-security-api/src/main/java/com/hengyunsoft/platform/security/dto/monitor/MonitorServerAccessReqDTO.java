package com.hengyunsoft.platform.security.dto.monitor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class MonitorServerAccessReqDTO implements Serializable {

    @ApiModelProperty(value = "服务器IP/登录账户")
    private String serverIpOrAccount;

    @ApiModelProperty(value = "开始时间(格式：YYYY-MM-DD)")
    private String begDate;

    @ApiModelProperty(value = "结束时间(格式：YYYY-MM-DD)")
    private String endDate;
}
