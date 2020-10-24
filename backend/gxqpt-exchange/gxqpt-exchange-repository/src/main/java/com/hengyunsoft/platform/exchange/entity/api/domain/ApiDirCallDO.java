package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ApiDirCallDO {
    @ApiModelProperty(value = "调用年月",required = true)
    private String callMonth;
    @ApiModelProperty(value = "开放目录调用数",required = true)
    private Integer openNum;
    @ApiModelProperty(value = "共享目录调用数",required = true)
    private Integer shareNum;


}
