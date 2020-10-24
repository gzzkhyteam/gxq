package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2018-07-17
 */
@Data
public class ServiceDirectoryDTO implements Serializable{

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "服务类别")
    private String type;

    @ApiModelProperty(value = "服务名称")
    private String serviceName;

    @ApiModelProperty(value = "服务简介")
    private String serviceInfo;

    @ApiModelProperty(value = "服务成果")
    private String serviceResult;



}
