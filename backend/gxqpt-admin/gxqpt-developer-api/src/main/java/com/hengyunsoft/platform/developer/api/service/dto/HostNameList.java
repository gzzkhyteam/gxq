package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-04-24 11:31
 * @desc 主机名列表
 **/
@Data
@ApiModel(value = "Host",description = "主机名实体")
public class HostNameList {
    /**
     * 主机id
     */
    @ApiModelProperty(value = "主机id")
    private Long id;
    /**
     * 主机名
     */
    @ApiModelProperty(value = "主机名")
    private  String hostName;
}