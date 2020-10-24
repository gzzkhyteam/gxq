package com.hengyunsoft.platform.security.dto.interfaces;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author luchanghong
 * @create 2018-09-04 15:45
 * @desc 接口调用查询参数
 **/
@Data
@ApiModel
public class PageInterCallListDTO {
    @ApiModelProperty(value = "操作时间")
    private Date createTime;
    @ApiModelProperty(value = "操作描述")
    private String name;
    @ApiModelProperty(value ="用户名称" )
    private String userName;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "模块id")
    private String appId;

}