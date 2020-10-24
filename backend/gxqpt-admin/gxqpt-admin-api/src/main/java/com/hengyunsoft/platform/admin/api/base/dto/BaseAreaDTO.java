package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianai
 * @createTime 2018-1-30
 */
@Data
public abstract class BaseAreaDTO {

    /**
     * 名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域名称")
    private String name;

    /**
     * 全名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域全名")
    private String fullName;

    /**
     * 排序
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序")
    private Integer orderNum;

}
