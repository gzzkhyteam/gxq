package com.hengyunsoft.platform.admin.api.core.dto.emp;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述:人员信息
 * @author chb
 * @date 2018/4/10 16:02
 */
@Data
@ApiModel(value = "GxqptEmpSettingIdentity", description = "人员信息")
public class GxqptEmpSettingIdentityDTO implements Serializable {


    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 身份表主键
     */
    @ApiModelProperty(value = "identityId")
    private String identityId;

    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位id")
    private String mainorgid;

    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位名称")
    private String mainorgname;

    /**
     * 所属部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属部门id")
    private String maindeptid;

    /**
     * 所属部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属部门名称")
    private String maindeptname;

    /**
     * 所属职务id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务id")
    private String mainduty;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务名称")
    private String maindutyname;

    /**
     * 所属岗位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属岗位id")
    private String mainpost;

    /**
     * 所属岗位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属岗位名称")
    private String mainpostname;

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位一把手")
    private String isheader;

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位领导")
    private String isleader;


    private static final long serialVersionUID = 1L;

}