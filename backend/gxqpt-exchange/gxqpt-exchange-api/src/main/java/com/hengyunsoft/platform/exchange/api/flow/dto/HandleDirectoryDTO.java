package com.hengyunsoft.platform.exchange.api.flow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "HandleDirectoryDTO", description = "流程处理返回信息")
public class HandleDirectoryDTO {
    @ApiModelProperty(value = "任务Id",required = true)
    private Long taskId;
    @ApiModelProperty(value = "单位id",required = true)
    private String  unitId;
    @ApiModelProperty(value = "处理状态",required = true)
    private Integer status;
    @ApiModelProperty(value = "处理意见")
    private String content;
}
