package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-04-12 10:14
 * @desc 主机创建人
 **/
@Data
public class HostCreateUserDTO {
    /**
     * 创建人id
     */
    @ApiModelProperty("创建人id")
    private Long id;
    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    private  String  name;
}