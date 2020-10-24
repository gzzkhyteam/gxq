package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RequestAppName", description = "所有应用查询接口")
public class RequestAppNameDTO {

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

    /**
     * 应用类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用类型")
    private Integer type;
}
