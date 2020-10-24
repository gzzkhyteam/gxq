package com.hengyunsoft.platform.admin.api.authority.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RoleFindLike", description = "平台角色模糊查询")
public class PtRoleFindLikeDTO {
    /**
     * 角色名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色名称", required = true)
    private String name;
    /**
     * 角色编码
     *
     * @mbggenerated
     */
    private String code;
}
