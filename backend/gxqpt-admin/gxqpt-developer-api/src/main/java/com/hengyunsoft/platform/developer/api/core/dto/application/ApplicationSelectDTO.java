package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplicationSelect", description = "查询下拉返回实体")
public class ApplicationSelectDTO {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 应用appId
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用appId")
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

    @ApiModelProperty(value = "服务注册中心的唯一标示")
    private String serviceId;
}
