package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DirDataCount {
    @ApiModelProperty(value = "数据目录",required = true)
    private Integer dirCount;
    @ApiModelProperty(value = "数据条数",required = true)
    private Integer dataCount;
    @ApiModelProperty(value = "接入单位",required = true)
    private Integer orgCount;
}
