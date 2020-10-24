package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-04-08 10:36
 * @desc 主机管理员列表实体
 **/
@Data
public class HostAdminListDTO {
    /**
     * 用户管理员id
     */
    @ApiModelProperty(value = "用户管理员id")
    private Long id;
    /**
     * 管理员名称
     */
    @ApiModelProperty(value ="管理员名称" )
    private String name;
    /**
     * 办公电话
     */
    @ApiModelProperty(value = "办公电话")
    private String officetel;
    /**
     * 手机电话
     */
    @ApiModelProperty(value = "手机电话")
    private String phone;
    /**
     * 是否与当前主机关联（1.关联，2.未关联）
     */
    @ApiModelProperty(value ="是否与当前主机关联（1.关联，2.未关联）" )
    private String relate;
    /**
     * 当前主机id
     */
    @ApiModelProperty(value = "当前主机id")
    private String hostId;
    /**
     * 用户角色id
     */
    @ApiModelProperty(value = "用户角色id")
    private Long assignId;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private  Long roleId;
    @ApiModelProperty(value ="账号")
    private String account;

}