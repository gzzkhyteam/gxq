package com.hengyunsoft.platform.developer.api.core.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "UserManagerReq", description = "管理员模糊查询所需实体")
public class UserManagerReqDTO implements Serializable {

    /**
     * 账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 用户名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户名称")
    private String name;
    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    private static final long serialVersionUID = 1L;
}
