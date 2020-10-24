package com.hengyunsoft.platform.standard.entity.standard.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardMonthDO", description = "标准下载")
public class StandardMonthDO {
    @ApiModelProperty(value = "年份")
    private String year;
    @ApiModelProperty(value = "月份")
    private String month;
    @ApiModelProperty(value = "标准数量")
    private Integer count;
}
