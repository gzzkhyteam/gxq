package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DepSurveyRes", description = "部门预警概况返回参数")
public class DepSurveyResDTO {
    @ApiModelProperty(value = "部门id")
    private String id;
    @ApiModelProperty(value = "部门名称")
    private String name;
    @ApiModelProperty(value = "预警数量")
    private Integer count;
}
