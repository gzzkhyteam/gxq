package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgImport", description = "单位导入所用")
public class GxqptOrgImportDTO extends ExcelParentDTO{

    /**
     * 上级单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级单位id")
    private String parentId;

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位名称")
    private String name;

    /**
     * 单位简称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位简称")
    private String shortName;

    /**
     * 单位其它名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位其他名")
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
     * 单位介绍
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位介绍")
    private String descrption;

    /**
     * 所属省份
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属省份")
    private String forarea;

    /**
     * 所属市州
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属市州")
    private String forcity;

    /**
     * 所属区县
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属区县")
    private String forcounty;

    /**
     * 所属乡镇
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属乡镇")
    private String fortown;

    /**
     * 单位职责
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位职责")
    private String orgduty;

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

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用标记")
    private String isenable;
}
