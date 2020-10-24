package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 移动端需要新增
 */
@Data
@ApiModel(value = "OrgInfosDTO", description = "人员单位信息返回")
public class OrgInfosDTO {

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String id;

    /**
     * 体系编码
     */
    @ApiModelProperty(value = "单位名称")
    private String orgName;


    /**
     * 部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门id")
    private String deptId;

    /**
     * 部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 职务
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "职务")
    private String dutyName;

    /**
     *岗位
     */
    @ApiModelProperty(value = "岗位")
    private String postName;
}
