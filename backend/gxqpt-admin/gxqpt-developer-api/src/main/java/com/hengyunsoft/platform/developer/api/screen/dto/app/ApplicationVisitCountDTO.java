package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ApplicationAndServiceNum",description = "大屏应用与服务统计")
public class ApplicationVisitCountDTO implements Serializable {
    /**
     * 访问次数
     */
    @ApiModelProperty(value = "访问次数")
    private Integer count;

    /**
     * 应用名称
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;

    /**
     * 应用id
     */
    @ApiModelProperty(value = "应用id")
    private String appId;
}
