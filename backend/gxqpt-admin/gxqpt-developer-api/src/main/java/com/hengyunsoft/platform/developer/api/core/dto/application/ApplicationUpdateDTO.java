package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ApplicationUpdate", description = "修改应用实体")
public class ApplicationUpdateDTO implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

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
     * 序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer orderNo;

    /**
     * '提供方   pt 平台   zk 中科 等等'(8个字符)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "'提供方   pt 平台   zk 中科 等等'(8个字符)")
    private String provider;
    
    /**
     * '提供方   pt 平台   zk 中科 等等'(8个字符)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "'提供方   pt 平台   zk 中科 等等'(8个字符)")
    private String providerId;

    /**
     * 应用所属单位Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用所属单位Id")
    private String orgId;

    /**
     * 应用所属单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用所属单位名称")
    private String orgName;

    /**
     * 单位所属体系编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位所属体系编码")
    private String orgSystemCode;

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用logo")
    private String logoUrl;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "首页访问地址")
    private String indexUrl;

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用编码")
    private String code;
    
    /**
     * 使用此应用，可以节省多少工期（人/天）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "使用此应用，可以节省多少工期（人/天）")
    private Double reduceTime;

    /**
     * 使用此应用，可以节省多少建设成本（元）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "使用此应用，可以节省多少建设成本（元）")
    private Integer reduceBuildCost;

    /**
     * 使用此应用，可以节省多少使用成本（元）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "使用此应用，可以节省多少使用成本（元）")
    private Integer reduceUseCost;

    /**
     * 使用此应用，可以节省多少维护成本（元）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "使用此应用，可以节省多少维护成本（元）")
    private Integer reduceProtectCost;

    /**
     * 此应用程序的初始预计工期（人/天）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "此应用程序的初始预计工期（人/天）")
    private Double originalTime;

    /**
     * 此应用程序的初始预计成本（人（元）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "此应用程序的初始预计成本（人（元）")
    private Integer originalCost;
    
    /**
     * 应用是否公有的   true表示公有，谁都可以访问，至于应用内部的资源，应用程序自己决定，要想有公有的菜单，完全可以在前端写死
     *
     * @mbggenerated
     */
    @ApiModelProperty("应用是否公有的   true表示公有，谁都可以访问，至于应用内部的资源，应用程序自己决定，要想有公有的菜单，完全可以在前端写死")
    private Boolean publicIs;
    
    /**
     * 服务注册中心的唯一标示： 比如eurake中的serviceId
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务注册中心的唯一标示： 比如eurake中的serviceId")
    private String serviceId;
    
    /**
     * 应用程序的完整根路径
     */
    @ApiModelProperty(value = "应用程序的完整根路径： http://127.0.0.1:8080/gxpqt-center")
    private String fullRootPath;
    private static final long serialVersionUID = 1L;
}
