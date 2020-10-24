package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
@ApiModel(value = "ServiceEvaluateUpdateReq", description = "更新服务评价")
public class ServiceEvaluateUpdateReqDTO implements Serializable{


    @ApiModelProperty(value = "id" ,required = true)
    private Long id;

    @ApiModelProperty(value = "服务态度" ,required = true)
    private Long serviceAttitude;

    @ApiModelProperty(value = "服务效率",required = true)
    private Long serviceEfficiency;

    @ApiModelProperty(value = "服务质量",required = true)
    private Long serviceEvaluation;

    @ApiModelProperty(value = "咨询建议" ,required = false)
    private String serviceAdvice;
}
