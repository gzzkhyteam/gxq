package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ResponseApplication", description = "运维系统应用查询返回信息")
public class ResponseApplicationDTO {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开发者ID")
    private String appId;

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
     * 应用编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用编码")
    private String code;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer orderNo;

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用/服务类型 1 应用   2服务   3既是应用也是服务")
    private Short appType;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）")
    private String typeName;

    /**
     * 提供方   pt 平台   zk 中科 等等
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提供方   pt 平台   zk 中科 等等")
    private String provider;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 当前应用管理员ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前应用管理员ID")
    private Long appManagerId;

    /**
     * 创建人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人名称")
    private String createName;

    /**
     * 当前应用管理员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前应用管理员")
    private String appManager;


}
