package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ApplicationRes", description = "查询应用返回实体")
public class ApplicationResDTO implements Serializable {
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
     * 首页访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "首页访问地址")
    private String indexUrl;

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
     * 应用编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用编码")
    private String code;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能描述")
    private String desc;

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用")
    private Boolean status;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务等等）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用/服务分类（共性应用、统一平台、共性服务等等）")
    private String type;

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用/服务类型： 1 应用   2服务   3既是应用也是服务")
    private Short appType;

    /**
     * 应用/服务分类名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用/服务分类名称")
    private String typeName;

    /**
     * 提供方   pt 平台   zk 中科 等等(安全保障所需字段)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提供方")
    private String provider;

    /**
     * 单位名称(安全保障所需字段)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位名称")
    private String orgName;

    /**
     * 应用程序的完整根路径
     */
    @ApiModelProperty(value = "应用程序的完整根路径： http://127.0.0.1:8080/gxpqt-center")
    private String fullRootPath;

    private static final long serialVersionUID = 1L;
}
