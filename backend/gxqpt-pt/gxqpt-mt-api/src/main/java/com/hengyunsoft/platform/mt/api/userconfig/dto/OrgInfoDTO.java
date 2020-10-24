package com.hengyunsoft.platform.mt.api.userconfig.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.userconfig.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/6/25
 * 修改内容：
 */
@Data
@ApiModel(value = "UserOrgDTO", description = "用户带我信息")
public class OrgInfoDTO {
    @ApiModelProperty(value = "单位id")
    private String id;

    @ApiModelProperty(value = "单位名称")
    private String name;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "职务")
    private String dutyName;

    @ApiModelProperty(value = "岗位")
    private String postName;
}
