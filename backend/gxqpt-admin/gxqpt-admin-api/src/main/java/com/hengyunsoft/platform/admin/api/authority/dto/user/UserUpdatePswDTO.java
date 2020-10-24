package com.hengyunsoft.platform.admin.api.authority.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserUpdatePswDTO {
    private Long id;
    @ApiModelProperty(value = "原始密码")
    private String oldPassword;
    @ApiModelProperty(value = "新密码")
    private String newPassword;
    @ApiModelProperty(value = "确认密码")
    private String truePassword;
}
