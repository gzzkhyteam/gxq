package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-04-04 15:13
 * @desc 主机名称实体
 **/
@Data
public class ApplicationHostNameDTO {
    /**
     * 主机名称
     */
@ApiModelProperty(value = "主机名称")
    private  String hostName;
    /**
     * 主机id
     */
    @ApiModelProperty(value = "主机id")
    private  Long hostId;
}