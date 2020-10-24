package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularNumDTO", description = "模块数量")
public class ModularNumDTO {
    @ApiModelProperty(value = "年份")
    private String year;
    @ApiModelProperty(value = "月份")
    private String month;
    @ApiModelProperty(value = "历史数量")
    private Integer modularNum;
    @ApiModelProperty(value = "本月新增模块数量")
    private Integer monthAddNum;
}
