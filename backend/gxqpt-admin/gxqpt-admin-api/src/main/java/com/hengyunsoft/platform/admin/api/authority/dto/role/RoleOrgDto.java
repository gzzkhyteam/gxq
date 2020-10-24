package com.hengyunsoft.platform.admin.api.authority.dto.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.admin.api.role.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/3/14
 * 修改内容：
 */
@Data
public class RoleOrgDto{

    @ApiModelProperty(value = "组织Id")
    private Long id;

    @ApiModelProperty(value = "组织名称")
    private String name;

    @ApiModelProperty(value = "体系code")
    private String sysCode;

    @ApiModelProperty(value = "+号展示，默认为true")
    private Boolean isParent=true;


}
