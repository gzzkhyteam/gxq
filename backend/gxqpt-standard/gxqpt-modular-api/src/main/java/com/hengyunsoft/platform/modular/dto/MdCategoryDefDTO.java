package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MdCategoryDef", description = "模块分类对象")
public class MdCategoryDefDTO {

    /**
     * id主键
     */
    @ApiModelProperty(value = "id主键")
    private Long id;

    /**
     * 模块分类名称
     */
    @ApiModelProperty(value = "模块分类名称")
    private String name;

}
