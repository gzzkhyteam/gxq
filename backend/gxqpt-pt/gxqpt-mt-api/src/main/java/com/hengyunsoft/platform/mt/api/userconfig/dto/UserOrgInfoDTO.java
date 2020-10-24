package com.hengyunsoft.platform.mt.api.userconfig.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.userconfig.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：用户单位信息
 * 修改人：gbl
 * 修改时间：2018/6/25
 * 修改内容：
 */
@Data
@ApiModel(value = "UserOrgInfoDTO", description = "用户单位信息")
public class UserOrgInfoDTO {
    @ApiModelProperty(value = "当前单位id")
    private String id;
    @ApiModelProperty(value = "当前单位名称")
    private String name;

    @ApiModelProperty(value = "当前部门名称")
    private String deptName;

    @ApiModelProperty(value = "当前职务")
    private String dutyName;

    @ApiModelProperty(value = "当前岗位")
    private String postName;

    @ApiModelProperty(value = "用户的所有单位列表")
    private List<OrgInfoDTO> orgList;
}
