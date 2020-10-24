package com.hengyunsoft.platform.admin.api.authority.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.admin.api.role.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
public class RoleUserDto {
    @ApiModelProperty(value = "角色Id",required = true)
    private Long roleId;

    @ApiModelProperty(value = "新增用户Id list")
    private List<Long> addUserIdList;

    @ApiModelProperty(value = "移除用户Id list")
    private List<Long> removeUserIdList;
}
