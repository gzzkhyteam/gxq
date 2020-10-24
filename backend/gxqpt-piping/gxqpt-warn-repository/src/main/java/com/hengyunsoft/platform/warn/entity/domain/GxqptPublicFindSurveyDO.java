package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicFindSurvey", description = "公用预警状态统计映射参数")
public class GxqptPublicFindSurveyDO {
    @ApiModelProperty(value = "单位id")
    private String id;
    @ApiModelProperty(value = "单位名称")
    private String name;
    @ApiModelProperty(value = "警报数量(未处理)")
    private Integer num;
}
