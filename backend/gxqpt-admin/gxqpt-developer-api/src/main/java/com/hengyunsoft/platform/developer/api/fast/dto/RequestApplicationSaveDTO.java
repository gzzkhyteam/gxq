package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wt
 * @create 2018-05-03
 * @desc 新增应用
 **/
@Data
@ApiModel(value = "RequestApplicationSaveDTO",description = "新增应用")
public class RequestApplicationSaveDTO implements Serializable{

    /**
     * 配置表ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "配置表ID")
    private Long bizConfigId;

    /**
     * 应用标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用标识")
    private String appFlag;

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

    /**
     * 热门程度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "热门程度")
    private Integer hotsCount;

}