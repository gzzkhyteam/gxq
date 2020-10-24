package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhoukx
 * @createTime 2018-4-16
 */
@Data
@ApiModel(value = "Modular", description = "模块展示对象")
public class ModularVersionPageDTO {

    /**
     * 仓库名
     */
    @ApiModelProperty(value = "repName")
    private String repName;

    /**
     * 模块名
     */
    @ApiModelProperty(value = "modularName")
    private String modularName;

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
     * 版本号
     */
    @ApiModelProperty(value = "version")
    private String version;

    /**
     * 模块描述
     */
    @ApiModelProperty(value = "description")
    private String description;

}
