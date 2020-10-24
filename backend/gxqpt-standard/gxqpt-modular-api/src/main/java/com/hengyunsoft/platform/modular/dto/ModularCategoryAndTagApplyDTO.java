package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ModularApply", description = "模块申请信息")
public class ModularCategoryAndTagApplyDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 申请类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请类型，CATEGORYAPPLY：分类申请；TAGAPPLY：标签申请")
    private String applyType;

    /**
     * 申请名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请名称")
    private String name;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请描述")
    private String description;

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请原因")
    private String reason;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请时间")
    private Date createTime;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private String createUserName;

    /**
     * 申请单位
     */
    @ApiModelProperty(value = "申请单位")
    private String createCompanyName;

    /**
     * 是否处理
     1：已处理
     0：未处理
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否处理，1：已处理；0：未处理")
    private Boolean isDeal;

    /**
     * 处理时间
     */
    @ApiModelProperty(value = "处理时间")
    private Date updateTime;

    /**
     * 处理结果
     *
     */
    @ApiModelProperty(value = "处理结果，PASS：通过；REJECT：驳回")
    private String dealResult;

    /**
     * 处理意见
     */
    @ApiModelProperty(value = "处理意见")
    private String dealSuggestion;

    /**
     * 处理人
     */
    @ApiModelProperty(value = "处理人")
    private String updateUserName;
}
