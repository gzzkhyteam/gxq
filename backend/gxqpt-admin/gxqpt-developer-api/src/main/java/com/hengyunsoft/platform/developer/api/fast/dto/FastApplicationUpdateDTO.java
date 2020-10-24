package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用更新
 **/
@Data
@ApiModel(value = "FastApplicationUpdate",description = "快速应用更新")
public class FastApplicationUpdateDTO implements Serializable{
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开发者ID，提供给各个应用的设别码")
    private String appId;

    /**
     * 配置表ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "配置表ID")
    private Long bizConfigId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用logo")
    private String logoUrl;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能描述")
    private String desc;

    /**
     * 热门程度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "热门程度")
    private Integer hotsCount;

    /**
     * 平台、应用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台、应用")
    private List<String> selectMenuAppId;

    /**
     * 服务、模块
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务、模块")
    private List<String> selectAppId;


    private static final long serialVersionUID = 1L;

}