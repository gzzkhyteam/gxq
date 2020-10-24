package com.hengyunsoft.platform.admin.api.authority.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.role.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色修改Dto
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
public class RoleUpdatDto extends RoleSaveDto {
    @ApiModelProperty(value = "角色Id" ,required = true)
    private Long id;
}
