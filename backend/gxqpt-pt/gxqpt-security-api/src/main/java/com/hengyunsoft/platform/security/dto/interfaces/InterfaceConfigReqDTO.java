package com.hengyunsoft.platform.security.dto.interfaces;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class InterfaceConfigReqDTO {

    @ApiModelProperty(value = "模块ID")
    private String appId;

    @ApiModelProperty(value = "接口名称")
    private String apiName;

    @ApiModelProperty(value = "设置状态 0：未设置，1：已设置")
    private Integer status;
}
