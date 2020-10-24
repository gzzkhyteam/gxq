package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularSave", description = "模块（新增）参数对象")
public class ModularSaveDTO {

    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String repName;

    /**
     * 模块名称
     */
    @ApiModelProperty(value = "模块名称")
    private String modularName;

    /**
     * 模块分类
     */
    @ApiModelProperty(value = "模块分类")
    private String modularType;

    /**
     * 模块标签
     */
    @ApiModelProperty(value = "模块标签")
    private String modularTag;

    /**
     * groupId
     */
    @ApiModelProperty(value = "groupId")
    private String groupId;

    /**
     * artifactId
     */
    @ApiModelProperty(value = "artifactId")
    private String artifactId;

    /**
     * 模块版本
     */
    @ApiModelProperty(value = "模块版本")
    private String version;

    /**
     * 模块描述
     */
    @ApiModelProperty(value = "模块描述")
    private String description;

    /**
     * jar包类型
     */
    @ApiModelProperty(value = "jar包类型")
    private String classifier;

}
