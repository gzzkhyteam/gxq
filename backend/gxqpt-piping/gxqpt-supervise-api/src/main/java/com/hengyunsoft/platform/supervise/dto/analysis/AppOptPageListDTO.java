package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author luchanghong
 * @create 2019-04-19 17:35
 * @desc 应用选择列表参数实体
 **/
@Data
@ApiModel(value = "AppOptPageListDTO", description = "应用选择列表参数实体")
public class AppOptPageListDTO implements Serializable {
    @ApiModelProperty(value = "采集方式")
    private String storeDay;
    @ApiModelProperty(value = "存储率")
    private Integer storeRates;
    @ApiModelProperty(value = "采集占用率")
    private float storeIs;
    @ApiModelProperty(value = "应用id")
    private String appId;
    @ApiModelProperty(value = "类型")
    private String type;

}