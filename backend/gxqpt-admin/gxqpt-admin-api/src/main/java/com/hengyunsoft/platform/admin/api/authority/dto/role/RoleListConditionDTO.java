package com.hengyunsoft.platform.admin.api.authority.dto.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.role
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/4/27
 * 修改内容：
 */
@Data
public class RoleListConditionDTO {
    @ApiModelProperty(value = "应用Id",required = true)
    private String appId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;


}
