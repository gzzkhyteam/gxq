package com.hengyunsoft.platform.modular.dto;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Modular", description = "模块展示对象")
public class ModularDTO {

    /**
     * 模块主键id
     */
    @ApiModelProperty(value = "模块主键id")
    private Long id;

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
     * 模块描述
     */
    @ApiModelProperty(value = "模块描述")
    private String description;

    /**
     * jar包类型
     */
    @ApiModelProperty(value = "jar包类型")
    private String classifier;

    /**
     *上传时间
     */
    @ApiModelProperty(value = "上传时间")
    private Date createTime;

    /**
     *下载次数
     */
    @ApiModelProperty(value = "下载次数")
    private Integer downloadCount;

    /**
     * 模块的分类列表
     */
    @SuppressWarnings("rawtypes")
	@ApiModelProperty(value = "模块的分类列表")
    private List mclist;

    /**
     * 模块的标签列表
     */
    @SuppressWarnings("rawtypes")
	@ApiModelProperty(value = "模块的标签列表")
    private List mtlist;
    
    @ApiModelProperty(value = "模块版本")
    private String version;
    
    /**
     * 上传单位Id
     */
    @ApiModelProperty(value = "上传单位Id")
    private Long createCompanyId;

    /**
     * 上传单位名称
     */
    @ApiModelProperty(value = "上传单位名称")
    private String createCompanyName;
    
	/**
	 * 各文档的属性
	 */
	private List<VersionParamsDTO> files;
}
