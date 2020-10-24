package com.hengyunsoft.platform.admin.api.core.dto.dpm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptDpmDetails", description = "部门字典详情实体")
public class GxqptDpmDetailsDTO {

    /**
     * 部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门名称")
    private String name;

    /**
     * 部门简称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门简称")
    private String shortName;

    /**
     * 部门其它名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门其它名")
    private String elseName;

    /**
     * 邮编
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮编")
    private String zipcode;

    /**
     * 电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "电话")
    private String telcode;

    /**
     * 传真
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "传真")
    private String faxcode;

    /**
     * 部门介绍
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门介绍")
    private String descrption;

    /**
     * 部门节点类型 1为实体单位 0为分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门节点类型 1为实体单位 0为分类")
    private String fornodetype;

    /**
     * 部门职责
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门职责")
    private String orgduty;

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用标记")
    private String isenable;


    /**
     * 状态 1正常 2待撤销 3 已撤销
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态 1正常 2待撤销 3 已撤销")
    private String status;

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序（值小排前）")
    private Integer sortvalue;
}
