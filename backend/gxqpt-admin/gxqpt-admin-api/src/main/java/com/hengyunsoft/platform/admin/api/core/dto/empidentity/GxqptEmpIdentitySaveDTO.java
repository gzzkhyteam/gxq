package com.hengyunsoft.platform.admin.api.core.dto.empidentity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述:人员身份；保存DTO
 * @author chb
 * @date 2018/4/10 10:44 
 */
@Data
public class GxqptEmpIdentitySaveDTO implements Serializable {

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


    private static final long serialVersionUID = 1L;
}
