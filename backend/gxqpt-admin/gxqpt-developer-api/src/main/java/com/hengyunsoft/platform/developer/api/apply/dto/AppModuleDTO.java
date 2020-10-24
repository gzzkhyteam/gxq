package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-05 15:48
 * @desc
 * @Version 1.0
 **/
@Data
public class AppModuleDTO extends ApplyQueryDetailDTO {


    @ApiModelProperty(value = "功能图标")
    private String logo;

    @ApiModelProperty(value = "联系人邮箱")
    private String email;

    @ApiModelProperty(value = "功能申请状态")
    private String applyStatus;

    @ApiModelProperty(value = "模块类型")
    private ModuleType moduleTypeMap;

    @ApiModelProperty(value = "功能名称")
    private String moduleName;

    @ApiModelProperty(value = "是否公有模块 所有人可调用(无需申请)")
    private Boolean publicIs;

    @ApiModelProperty(value = "是否公开模块   需要登陆才可以看到")
    private Boolean publicLook;

    @ApiModelProperty(value = "API接口文档地址")
    private String apiSyncUrl;

    @ApiModelProperty(value = "资源数量（接口数量）")
    private Integer resourceNum;

    @ApiModelProperty(value = "停用日期（停止使用/维护日期）")
    private String stopTime;

    @ApiModelProperty(value = "建议使用模块")
    private String adviceModule;

    @ApiModelProperty(value = "使用此应用，可以节省多少工期（人/天）")
    private Double reduceTime;

    @ApiModelProperty(value = "使用此应用，可以节省多少钱（元）")
    private Integer reduceCost;

}
