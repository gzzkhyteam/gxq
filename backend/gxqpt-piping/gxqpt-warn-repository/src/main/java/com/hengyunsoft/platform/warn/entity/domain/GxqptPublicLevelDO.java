package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicLevel", description = "公用预警级别统计映射参数")
public class GxqptPublicLevelDO {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "一般预警")
    private Integer commonly;
    @ApiModelProperty(value = "较重预警")
    private Integer heavier;
    @ApiModelProperty(value = "严重预警")
    private Integer serious;
    @ApiModelProperty(value = "非常严重预警")
    private Integer verySerious;
}
