package com.hengyunsoft.platform.admin.api.authority.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：新增快捷入口dto
 * 修改人：sunxiaoya
 * 修改时间：2018/3/28
 * 修改内容：
 */
@Data
@ApiModel(value = "FastEntry", description = "快捷入口")
public class FastEntryDTO {

    @ApiModelProperty(value = "应用资源名")
    private String appResourceName;

    @ApiModelProperty(value = "应用ID")
    private String appId;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "资源ID")
    private Long resourceId;

    @ApiModelProperty(value = "描述")
    private String desc;

    @ApiModelProperty(value = "资源路径")
    private String url;

    @ApiModelProperty(value = "资源图标")
    private String icon;


}
