package com.hengyunsoft.platform.admin.api.authority.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserManagerReqDTO {
    /**
     * 用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private String id;

    /**
     * 用户名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户名称")
    private String name;

    /**
     * 账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 用户绑定状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户绑定状态")
    private String tag;
}
