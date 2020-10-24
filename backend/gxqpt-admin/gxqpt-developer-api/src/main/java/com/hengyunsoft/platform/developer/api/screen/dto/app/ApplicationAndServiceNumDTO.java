package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplicationAndServiceNum",description = "大屏应用与服务统计")
public class ApplicationAndServiceNumDTO {
    /**
     * 应用个数
     */
    @ApiModelProperty(value = "应用个数")
    private Integer appNum;

    /**
     * 服务个数
     */
    @ApiModelProperty(value = "服务个数")
    private Integer serviceNum;
}
