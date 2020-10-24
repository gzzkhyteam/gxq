package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Modular", description = "模块展示对象")
public class ModularQueryDTO {

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
     * 模糊查询参数
     */
    @ApiModelProperty(value = "模糊查询参数")
    private String mateParam;

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
     * 模块描述
     */
    @ApiModelProperty(value = "description")
    private String description;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "version")
    private String version;
}
