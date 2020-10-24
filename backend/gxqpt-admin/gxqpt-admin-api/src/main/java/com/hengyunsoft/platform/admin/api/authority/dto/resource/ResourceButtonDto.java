package com.hengyunsoft.platform.admin.api.authority.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/4/17
 * 修改内容：
 */
@Data
@ApiModel(value = "ResourceButton", description = "按钮查询参数")
public class ResourceButtonDto {
    @ApiModelProperty(value = "登录用户id")
    private Long userId;

    @ApiModelProperty(value = "资源id")
    private Long resourceId;

    @ApiModelProperty(value = "菜单分组")
    private String group;
}
