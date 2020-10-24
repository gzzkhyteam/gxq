package com.hengyunsoft.platform.admin.api.core.dto.dpm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptDpmSave", description = "新增部门实体")
public class GxqptDpmSaveDTO {
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
     * 所属类型（继承单位）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属类型（继承单位）")
    private String forType;

    /**
     * 所属级别（继承单位）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属级别（继承单位）")
    private String forClass;

    /**
     * 所属系统如公安、税务等（继承单位）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属系统如公安、税务等（继承单位）")
    private String forindustry;

    /**
     * 部门管理员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门管理员")
    private String orgadmin;

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

    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用")
    private String logid;

    /**
     * 对应的其它id， 如果未有其它对应则它与本身 id一样
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "对应的其它id， 如果未有其它对应则它与本身 id一样")
    private String otherid;
}
