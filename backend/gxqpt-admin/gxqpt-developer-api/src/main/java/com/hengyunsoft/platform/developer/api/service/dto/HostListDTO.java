package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luchanghong
 * @create 2018-04-03 10:31
 * @desc 主机列表数据实体
 **/
@Data
@ApiModel(value = "Host",description = "主机列表数据实体")
public class HostListDTO implements Serializable{
    /**
     * 主机创建人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机创建人id")
    private Long createUser;



    /**
     * 主机名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机名")
    private String hostName;

}