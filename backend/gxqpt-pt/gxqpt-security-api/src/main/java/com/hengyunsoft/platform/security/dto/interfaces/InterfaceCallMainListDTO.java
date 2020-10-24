package com.hengyunsoft.platform.security.dto.interfaces;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luchanghong
 * @create 2019-04-22 10:48
 * @desc
 **/
@Data
@ApiModel
public class InterfaceCallMainListDTO implements Serializable {
    /**
     * 接口名称
     *
     * @mbggenerated
     */
    @ApiModelProperty("接口名称")
    private String name;
    @ApiModelProperty("操作人名称")
    private String userName;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty
    private String appId;
    @ApiModelProperty("类型")
    private String type;
}