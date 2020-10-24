package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ApiCallDO {
    @ApiModelProperty(value = "部门名称",required = true)
    private String unitName;
    @ApiModelProperty(value = "API名称",required = true)
    private String apiName;
    @ApiModelProperty(value = "访问时间",required = true)
    private Date visitTime;
    @ApiModelProperty(value = "目录名",required = true)
    private String dirName;
    @ApiModelProperty(value = "调用Ip",required = true)
    private String ipAddr;
    @ApiModelProperty(value = "交换数据量",required = true)
    private Integer dataCount;


}
