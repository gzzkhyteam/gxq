package com.hengyunsoft.platform.admin.api.core.dto.empidentity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述:人员身份；修改DTO
 * @author chb
 * @date 2018/4/10 10:44 
 */
@Data
public class GxqptEmpIdentityRetDTO implements Serializable {

    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 单位ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位ID")
    private String orgId;

    /**
     * 部门ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门ID")
    private String deptId;

    /**
     * 岗位ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "岗位ID")
    private String postId;

    /**
     * 职务ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "职务ID")
    private String dutyId;

    /**
     * 说明
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "说明")
    private String description;

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位一把手,1是-1否")
    private String isheader;

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位领导,1是-1否")
    private String isleader;

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "人员职责")
    private String userduty;

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用标记,1是-1否")
    private String isenable;

    /**
     * 人员名称
     */
    @ApiModelProperty(value = "人员名称")
    private String userName;

    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String orgName;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称")
    private String postName;

    /**
     * 职务名称
     */
    @ApiModelProperty(value = "职务名称")
    private String dutyName;

    private static final long serialVersionUID = 1L;
}
