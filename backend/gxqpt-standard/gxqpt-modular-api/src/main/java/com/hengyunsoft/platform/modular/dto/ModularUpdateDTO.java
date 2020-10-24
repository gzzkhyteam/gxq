package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularUpdate", description = "模块（更新）参数对象")
public class ModularUpdateDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 模块名称
     */
    @ApiModelProperty(value = "模块名称")
    private String modularName;

    /**
     * 模块描述
     */
    @ApiModelProperty(value = "模块描述")
    private String description;

    /**
     * 模块标签
     */
    @ApiModelProperty(value = "模块标签")
    private String modularTags;

    /**
     * 模块分类
     */
    @ApiModelProperty(value = "模块分类")
    private String modularCategorys;

}
