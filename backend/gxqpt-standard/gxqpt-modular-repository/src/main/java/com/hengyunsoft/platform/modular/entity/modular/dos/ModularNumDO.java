package com.hengyunsoft.platform.modular.entity.modular.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularNumDO", description = "模块数量")
public class ModularNumDO {
    @ApiModelProperty(value = "年份")
    private String year;
    @ApiModelProperty(value = "月份")
    private String month;
    @ApiModelProperty(value = "历史数量")
    private Integer modularNum;
    @ApiModelProperty(value = "本月新增模块数量")
    private Integer monthAddNum;
}
