package com.hengyunsoft.platform.admin.api.authority.dto.user;

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
    private Long id;
    /**
     * 用户账户
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户账户")
    private String account;
    /**
     * 用户名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户名称")
    private String name;
    /**
     * 用户电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户电话")
    private String phone;
    /**
     * 工作描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "工作描述")
    private String workDesc;
    /**
     * 是否可登录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否可登录")
    private Boolean loginable;
    /**
     * 存在体系
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "存在体系")
    private String ownSystem;
    /**
     * 照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片")
    private String photo;
}
