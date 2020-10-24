package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MdTagDef", description = "模块标签对象")
public class MdTagDefDTO {

    /**
     * id主键
     */
    @ApiModelProperty(value = "id主键")
    private Long id;

    /**
     * 模块分类名称
     */
    @ApiModelProperty(value = "模块标签名称")
    private String name;

}
