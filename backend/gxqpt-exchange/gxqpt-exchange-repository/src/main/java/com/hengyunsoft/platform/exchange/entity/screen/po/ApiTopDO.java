package com.hengyunsoft.platform.exchange.entity.screen.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiTopDO implements Serializable{
    @ApiModelProperty(value = "API名称")
    private String apiName;
    @ApiModelProperty(value = "api调用次数")
    private int  apiCallCount;
}
