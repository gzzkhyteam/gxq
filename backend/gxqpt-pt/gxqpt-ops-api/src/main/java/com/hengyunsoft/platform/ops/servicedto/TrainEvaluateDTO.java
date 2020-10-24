package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainEvaluateDTO", description = "培训评价请求参数")
public class TrainEvaluateDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "评分")
    private Long score;
    @ApiModelProperty(value = "培训意见")
    private String advice;
}
