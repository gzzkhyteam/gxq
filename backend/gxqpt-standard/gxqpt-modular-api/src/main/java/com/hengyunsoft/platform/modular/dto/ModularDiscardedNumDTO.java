package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularDiscardedNumDTO", description = "模块废弃数量")
public class ModularDiscardedNumDTO {
    @ApiModelProperty(value = "年份")
    private String year;
    @ApiModelProperty(value = "月份")
    private String month;
    @ApiModelProperty(value = "废弃数量")
    private Integer modularNum;
}
