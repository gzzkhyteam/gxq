package com.hengyunsoft.platform.developer.api.core.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "UserRes", description = "用户返回实体")
public class UserResDTO implements Serializable {
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
     * 用户电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户电话")
    private String phone;

    /**
     * 用户绑定状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户绑定状态")
    private String tag;

    private static final long serialVersionUID = 1L;
}
