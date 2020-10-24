package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularApplySave", description = "申请信息参数对象")
public class ModularCategoryAndTagApplySaveDTO {

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
     * 上传单位ID
     *
     * @mbggenerated
     */
    private Long createCompany;

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
    private String createCompanyName;
}
