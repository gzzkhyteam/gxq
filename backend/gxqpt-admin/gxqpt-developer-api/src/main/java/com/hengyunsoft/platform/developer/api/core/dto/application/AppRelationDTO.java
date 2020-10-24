package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述:给应用添加依赖关系
 * @author chb
 */
@Data
@ApiModel(value = "AppRelationDTO", description = "给应用添加依赖关系")
public class AppRelationDTO {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     *所依赖应用的ID
     */
    @ApiModelProperty(value = "所依赖应用的ID")
    private Long producerId;

    /**
     * 所依赖应用的名称
     */
    @ApiModelProperty(value = "所依赖应用的名称")
    private String producerName;
}
