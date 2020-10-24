package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AppRulesRes", description = "关联规则返回参数")
public class AppRulesResDTO {
    @ApiModelProperty(value = "关联规则源")
    private String source;
    @ApiModelProperty(value = "关联规则目标")
    private String target;
    @ApiModelProperty(value = "支持度")
    private Float supportDegree;
    @ApiModelProperty(value = "置信度")
    private Float confidenceDegree;
}
