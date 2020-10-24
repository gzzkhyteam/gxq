package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wt
 * @create 2018-05-03
 * @desc 新增应用
 **/
@Data
@ApiModel(value = "ResponseApplicationDetailDTO",description = "查询应用详情")
public class ResponseApplicationDetailDTO implements Serializable{

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 关联是模块还是服务ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "关联是模块还是服务ID")
    private String bizId;

    /**
     * 关联是模块还是服务ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "关联是模块还是服务ID")
    private String fastAppId;

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
     * 配置表ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "配置表ID")
    private Long bizConfigId;

    /**
     * 应用创建人
     */
    @ApiModelProperty(value = "应用创建人")
    private String userName;

    /**
     * 应用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用")
    private List<ResponseDictionaryDTO> application;
}