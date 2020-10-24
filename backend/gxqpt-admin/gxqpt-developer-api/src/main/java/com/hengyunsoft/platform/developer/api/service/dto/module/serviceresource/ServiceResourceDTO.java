package com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：服务资源管理dto
 * 修改人：sunxiaoya
 * 修改时间：2018/4/4
 * 修改内容：
 */
@Data
@ApiModel(value = "ServiceResourceDTO", description = "服务资源管理")
public class ServiceResourceDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "功能模块id")
    private Long moduleId;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "功能描述")
    private String desc;

    @ApiModelProperty(value = "资源编码")
    private String code;

    @ApiModelProperty(value = "路径")
    private String url;

    @ApiModelProperty(value = "get/post/all")
    private String httpMethod;

    @ApiModelProperty(value = "状态： 1启用   2禁用")
    private Short status;

    @ApiModelProperty(value = "序号")
    private Integer orderNo;

    @ApiModelProperty(value = "所属应用appid")
    private String appId;

}
