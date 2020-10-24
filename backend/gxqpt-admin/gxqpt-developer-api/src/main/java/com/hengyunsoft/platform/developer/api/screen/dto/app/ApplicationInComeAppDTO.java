package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 2018-5-11
 * 因大屏需求修改应用集成所有接口重写
 * 接入应用查询DTO
 * @return
 */
@Data
@ApiModel(value = "ApplicationInComeAppDTO",description = "接入应用查询DTO")
public class ApplicationInComeAppDTO {
    /**
     * 应用ID
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 应用名称
     */
    @ApiModelProperty(value = "应用ID")
    private String appName;
}
