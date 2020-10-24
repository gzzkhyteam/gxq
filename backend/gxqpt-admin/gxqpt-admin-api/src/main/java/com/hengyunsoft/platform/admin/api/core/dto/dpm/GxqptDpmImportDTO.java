package com.hengyunsoft.platform.admin.api.core.dto.dpm;

import com.hengyunsoft.platform.admin.api.core.dto.org.ExcelParentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptDpmImport", description = "部门导入所用")
public class GxqptDpmImportDTO extends ExcelParentDTO{
    /**
     * 上级部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级部门名称")
    private String parentName;

    /**
     * 上级部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级部门id")
    private String parentId;

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门所属单位")
    private String orgId;

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
