package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-04-04 15:31
 * @desc 应用名称实体
 **/
@Data
public class ApplicationNameDTO {
    /**
     * 应用名称
     */
    @ApiModelProperty(value = "应用名称")
    private  String applicationName;
    /**
     * 应用id
     */
    @ApiModelProperty(value = "应用id")
    private  String appId;
}