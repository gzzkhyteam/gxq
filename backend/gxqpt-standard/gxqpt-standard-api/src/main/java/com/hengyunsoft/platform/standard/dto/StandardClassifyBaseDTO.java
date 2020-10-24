package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StandardClassifyBaseDTO {

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

}
