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
@ApiModel(value = "WorkLogPageReq", description = "使用帮助分页查询")
public class WorkLogPageReqDTO implements Serializable{
    @ApiModelProperty(value = "所属单位" ,required = true)
    private String unitId;//所属单位
    @ApiModelProperty(value = "处室" ,required = false)
    private String mainDeptId;//所属部门名称
    @ApiModelProperty(value = "开始时间" ,required = false)
    private String startTime;
    @ApiModelProperty(value = "截止时间",required = false)
    private String endTime;
}
