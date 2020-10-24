package com.hengyunsoft.platform.mt.api.work.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
@ApiModel(value = "WorkLogAppPageReq", description = "工作日志分页查询")
public class WorkLogAppPageReqDTO implements Serializable{
    @ApiModelProperty(value = "用户id" ,required = true)
    private Long userId;//用户id
    @ApiModelProperty(value = "单位id" ,required = true)
    private String unitId;//用户id
}
