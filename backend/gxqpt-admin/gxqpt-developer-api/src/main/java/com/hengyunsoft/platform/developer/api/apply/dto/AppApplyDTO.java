package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-05 15:47
 * @desc
 * @Version 1.0
 **/
@Data
public class AppApplyDTO extends ApplyQueryDetailDTO{

    @ApiModelProperty(value = "应用logo")
    private String logoUrl;

    @ApiModelProperty(value = "应用序号")
    private int orderNo;

    @ApiModelProperty(value = "首页访问地址")
    private String indexUrl;

    @ApiModelProperty(value = "提供方")
    private String provider;

    @ApiModelProperty(value = "所属单位")
    private String orgId;

    @ApiModelProperty(value = "应用/服务类型")
    private Short appType;

    @ApiModelProperty(value = "应用/服务分类（共性应用、统一平台、共性服务等等）")
    private String type;

    @ApiModelProperty(value = "单位所属体系编码）")
    private String orgSystemCode;

    @ApiModelProperty(value = "单位名称）")
    private String orgName;

    @ApiModelProperty(value = "使用此应用，可以节省多少建设成本（元））")
    private Integer reduceBuildCost;

    @ApiModelProperty(value = "使用此应用，可以节省多少使用成本（元））")
    private Integer reduceUseCost;

    @ApiModelProperty(value = "使用此应用，可以节省多少维护成本（元）")
    private Integer reduceProtectCost;

    @ApiModelProperty(value = "使用此应用，可以节省多少工期（人/天）")
    private Double reduceTime;

    @ApiModelProperty(value = "使用此应用，可以节省多少钱（元）")
    private Integer reduceCost;

    @ApiModelProperty(value = "此应用程序的初始预计工期（人/天）")
    private Double originalTime;

    @ApiModelProperty(value = "此应用程序的初始预计成本（人（元）")
    private Integer originalCost;

    @ApiModelProperty(value = "是否公有模块 所有人可调用(无需申请)")
    private Boolean publicIs;

    @ApiModelProperty(value = "服务注册中心的唯一标示： 比如eurake中的serviceId")
    private String serviceId ;

    @ApiModelProperty(value = "应用程序的完整根路径")
    private String fullRootPath;
}
