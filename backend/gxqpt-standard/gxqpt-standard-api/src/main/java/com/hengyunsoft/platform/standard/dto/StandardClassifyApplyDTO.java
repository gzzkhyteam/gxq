package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "StandardClassifyApply", description = "标准分类申请信息")
public class StandardClassifyApplyDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     * 父ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父ID")
    private String parentId;

    /**
     * 父ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父分类名称")
    private String parentName;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 排序号，数值越大排序越靠后
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序号，数值越大排序越靠后")
    private Integer sortNo;

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
     */
    @ApiModelProperty(value = "处理结果")
    private String dealResult;

    /**
     * 处理结果描述
     */
    @ApiModelProperty(value = "处理结果描述")
    private String dealResultDescription;
}
