package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-1-30
 */
@Data
@ApiModel(value = "AreaUpdate", description = "地区名称")
public class AreaUpdateDTO extends BaseAreaDTO implements Serializable {
    /**
     * 地区id
     * @mbggenerated
     */
    @ApiModelProperty(value = "地区id" ,required = true)
    private Long id;
    /**
     * 地区编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "地区编码")
    private String code;
    /**
     * 经度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "经度")
    private String longitude;

    /**
     * 维度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "维度")
    private String latitude;
}
