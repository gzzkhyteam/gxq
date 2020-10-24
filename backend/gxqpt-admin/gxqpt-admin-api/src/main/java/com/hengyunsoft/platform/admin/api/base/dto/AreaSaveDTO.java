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
@ApiModel(value = "AreaSave", description = "地区名称")
public class AreaSaveDTO extends BaseAreaDTO implements Serializable {
    /**
     * 地区名称
     *
     * @mbggenerated
     */@ApiModelProperty(value = "地区名称")
    private String name;

    /**
     * 父id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;
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
