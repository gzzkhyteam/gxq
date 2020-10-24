package com.hengyunsoft.platform.admin.api.authority.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.role.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
public class RoleSaveDto {
    @ApiModelProperty(value = "角色名称", required = true)
    private String name;

    @ApiModelProperty(value = "角色编码")
    private String code;

    @ApiModelProperty(value = "功能描述")
    private String desc;

    @ApiModelProperty(value = "是否平台角色")
    private Boolean ptRole;

    @ApiModelProperty(value = "是否只读 不允许修改")
    private Boolean readonly;

    @ApiModelProperty(value = "应用Id")
    private String appId;


}
