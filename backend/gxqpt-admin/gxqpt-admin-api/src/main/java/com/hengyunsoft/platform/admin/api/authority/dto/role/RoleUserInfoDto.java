package com.hengyunsoft.platform.admin.api.authority.dto.role;

import io.swagger.annotations.ApiModelProperty;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.role
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
public class RoleUserInfoDto {
    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "所属体系")
    private String ownSystem;

    @ApiModelProperty(value = "所属单位")
    private String orgName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    private String telephone;


}
