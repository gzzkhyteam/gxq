package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicContrast", description = "公用对比分析统计映射参数")
public class GxqptPublicContrastDO {
    @ApiModelProperty(value = "使用个数")
    private Float num;
    @ApiModelProperty(value = "平均数")
    private Float avg;
    @ApiModelProperty(value = "类型id")
    private String typeId;
    @ApiModelProperty(value = "类型名称")
    private String typeName;
}
