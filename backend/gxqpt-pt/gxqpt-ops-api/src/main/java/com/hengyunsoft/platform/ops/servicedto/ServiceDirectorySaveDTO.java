package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2018-07-17
 */
@Data
public class ServiceDirectorySaveDTO implements Serializable{

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "类型")
    private String type;


    @ApiModelProperty(value = "服务名称")
    private String serviceName;

    @ApiModelProperty(value = "服务简介")
    private String serviceInfo;

    @ApiModelProperty(value = "服务成果")
    private String serviceResult;


}
