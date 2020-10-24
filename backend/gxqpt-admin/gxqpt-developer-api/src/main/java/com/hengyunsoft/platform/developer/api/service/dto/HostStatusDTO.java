package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author luchanghong
 * @create 2018-04-03 16:56
 * @desc 主机状态实体
 **/
@Data
@ApiModel(value = "Host",description = "主机状态实体")
public class HostStatusDTO implements Serializable {
    /**
     * 主机id
     */
    @ApiModelProperty(value = "主机id")
    private  Long id;
    /**
     * 主机状态
     */
    @ApiModelProperty(value = "主机状态")
 private Boolean status;

}