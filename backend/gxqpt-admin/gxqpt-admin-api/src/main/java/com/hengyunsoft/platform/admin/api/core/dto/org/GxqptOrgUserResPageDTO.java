package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GxqptOrgUserResPageDTO implements Serializable {
    @ApiModelProperty(value = "登录用户id")
    private Long userId;

    @ApiModelProperty(value = "菜单分组")
    private String group;
}
