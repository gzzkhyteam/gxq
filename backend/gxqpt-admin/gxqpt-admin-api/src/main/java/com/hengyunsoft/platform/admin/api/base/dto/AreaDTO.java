package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2018-01-30
 */
@Data
public class AreaDTO extends BaseAreaDTO implements Serializable {

    /**
     * 主键id
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 区域名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域名称")
    private String name;
    /**
     * 地区编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "地区编码")
    private String code;
    /**
     * 父id
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;
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
