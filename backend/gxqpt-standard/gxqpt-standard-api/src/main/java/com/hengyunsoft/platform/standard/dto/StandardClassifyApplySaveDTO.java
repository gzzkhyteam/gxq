package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardClassifyApplySave", description = "标准分类申请信息参数对象")
public class StandardClassifyApplySaveDTO {

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
     * 父级名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父级名称")
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
