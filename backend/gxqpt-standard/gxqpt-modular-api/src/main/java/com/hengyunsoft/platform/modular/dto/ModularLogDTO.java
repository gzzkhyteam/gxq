package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularLogDTO", description = "模块下载记录")
public class ModularLogDTO {
	/**
     * 模块id
     */
    @ApiModelProperty(value = "模块id")
    private Long modularId;

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
     * jar包类型
     */
    @ApiModelProperty(value = "jar包类型")
    private String classifier;
    /**
     * 下载IP
     */
    @ApiModelProperty(value = "下载IP")
    private String ip;
    
    @ApiModelProperty(value = "模块版本")
    private String version;
}
