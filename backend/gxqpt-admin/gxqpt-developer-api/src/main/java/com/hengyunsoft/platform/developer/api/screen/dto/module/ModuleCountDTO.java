package com.hengyunsoft.platform.developer.api.screen.dto.module;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 组件各类别占比情况
 */
@Data
public class ModuleCountDTO {

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer num;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 类型名称
     */
    @ApiModelProperty(value = "类型名称")
    private String typeName;

}
