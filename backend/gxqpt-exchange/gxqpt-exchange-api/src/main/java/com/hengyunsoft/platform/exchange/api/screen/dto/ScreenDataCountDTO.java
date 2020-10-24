package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 大屏数据量统计
 */
@Data
@ApiModel(value = "ScreenDataCountDTO", description = "数据量统计信息")
public class ScreenDataCountDTO {
    @ApiModelProperty(value = "已接入部分",required = true)
    private Integer joinOrgCount;
    @ApiModelProperty(value = "数据目录",required = true)
    private Integer directoryCount;
    @ApiModelProperty(value = "数据集",required = true)
    private Integer setCount;
    @ApiModelProperty(value = "API数量",required = true)
    private Integer apiCount;
    @ApiModelProperty(value = "平台访问量",required = true)
    private Integer amtCount;
    @ApiModelProperty(value = "调用次数",required = true)
    private Integer callCount;


}
