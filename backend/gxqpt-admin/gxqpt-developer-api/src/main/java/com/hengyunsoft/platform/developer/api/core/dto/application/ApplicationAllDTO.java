package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplicationAll", description = "所有应用查询接口")
public class ApplicationAllDTO {
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
    @ApiModelProperty(value = "开发者ID，提供给各个应用的设别码")
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

    /**
     * 应用类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用类型")
    private String appType;

    /**
     * 应用分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用分类")
    private String type;

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

    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位id")
    private String orgId;


    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位名称")
    private String orgName;
}
