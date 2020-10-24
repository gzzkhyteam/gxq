package com.hengyunsoft.platform.mt.api.help.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-05-27
 */
@Data
@ApiModel(value = "UseTheHelpPageReq", description = "使用帮助分页查询")
public class UseTheHelpPageReqDTO implements Serializable{
    @ApiModelProperty(value = "标题" ,required = false)
    private String title;
    @ApiModelProperty(value = "开始时间" ,required = false)
    private String startTime;
    @ApiModelProperty(value = "截止时间",required = false)
    private String endTime;
    @ApiModelProperty(value = "模块id",required = false)
    private Long modularId;
}
