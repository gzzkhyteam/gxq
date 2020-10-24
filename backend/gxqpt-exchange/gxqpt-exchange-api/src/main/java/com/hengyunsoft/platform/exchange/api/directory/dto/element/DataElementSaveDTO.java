package com.hengyunsoft.platform.exchange.api.directory.dto.element;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-04-22
 */
@Data
public class DataElementSaveDTO extends BaseDataElementDTO implements Serializable {

    /**
     * 字段名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段名称")
    private String fieldName;
    /**
     * 目录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录id")
    private String dirId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String unitId;
    /**
     * 字段标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段标识")
    private String fieldCode;

    /**
     * 字段类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段类型")
    private String fieldType;
    /**
     * 字段长度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段长度")
    private String fieldLength;
    /**
     * 字段描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段描述")
    private String desc;

    /**
     * 数据集字段
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集字段")
    private String setField;

    /**
     * 字段是否主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段是否主键")
    private Integer isPrimary;
}
