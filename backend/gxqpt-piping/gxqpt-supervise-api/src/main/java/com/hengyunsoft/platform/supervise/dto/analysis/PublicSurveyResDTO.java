package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "PublicSurveyRes", description = "单位预警概况返回参数")
public class PublicSurveyResDTO extends GxqptPublicOrgNodeDTO{
    @ApiModelProperty(value = "警报数量(未处理)")
    private Integer num;
}
