package com.hengyunsoft.platform.ops.consultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by kevin on 2018/7/16.
 */
@Data
@ApiModel(value = "ConsultEvaluateUpdateReq", description = "更新咨询评价")
public class ConsultEvaluateUpdateReqDTO implements Serializable{


    @ApiModelProperty(value = "id" ,required = true)
    private Long id;

    @ApiModelProperty(value = "服务态度" ,required = true)
    private Long serviceAttitude;

    @ApiModelProperty(value = "服务效率",required = true)
    private Long serviceEfficiency;

    @ApiModelProperty(value = "服务质量" ,required = true)
    private Long serviceQuality;

    @ApiModelProperty(value = "咨询建议" ,required = false)
    private String consultAdvice;
}
