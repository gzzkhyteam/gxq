package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicContrastLevel", description = "公用预警级别对比分析统计映射参数")
public class GxqptPublicContrastLevelDO {
    @ApiModelProperty(value = "使用个数")
    private Integer num;
    @ApiModelProperty(value = "平均数")
    private Float avg;
    @ApiModelProperty(value = "预警等级")
    private String level;
}
