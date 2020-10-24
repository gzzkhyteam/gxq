package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrgDeptDutyInfoDTO", description = "单位，部门，职务，岗位信息")
public class OrgDeptDutyInfoDTO {

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String orgId;

    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String orgName;

    /**
     *部门id
     */
    @ApiModelProperty(value = "部门id")
    private String deptId;

    /**
     *部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     *职务id
     */
    @ApiModelProperty(value = "职务id")
    private String dutyId;

    /**
     *职务名称
     */
    @ApiModelProperty(value = "职务名称")
    private String dutyName;

    /**
     *岗位id
     */
    @ApiModelProperty(value = "岗位id")
    private String postId;

    /**
     *岗位名称
     */
    @ApiModelProperty(value = "岗位名称")
    private String postName;

    /**
     *用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "照片")
    private String  photo;
    /**
     * 体系编码
     */
    @ApiModelProperty(value = "体系编码")
    private String systemCode;

}
