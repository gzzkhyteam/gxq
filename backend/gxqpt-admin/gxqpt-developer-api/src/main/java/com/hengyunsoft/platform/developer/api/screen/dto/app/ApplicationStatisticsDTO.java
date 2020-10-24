package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplicationStatistics",description = "大屏应用分类")
public class ApplicationStatisticsDTO {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "应用分类")
    private String type;
}
