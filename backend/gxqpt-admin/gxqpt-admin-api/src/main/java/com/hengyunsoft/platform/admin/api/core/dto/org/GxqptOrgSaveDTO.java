package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgSave", description = "新增单位实体")
public class GxqptOrgSaveDTO {

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
     * 所属类型
     *
     * @mbggenerated
     */

    @ApiModelProperty(value = "所属类型")
    private String forType;

    /**
     * 所属级别
     *
     * @mbggenerated
     */

    @ApiModelProperty(value = "所属级别")
    private String forClass;

    /**
     * 所属系统如公安、税务等
     *
     * @mbggenerated
     */

    @ApiModelProperty(value = "所属系统如公安、税务等")
    private String forindustry;

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
     * 单位归口是政府、人大、政协等
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位归口是政府、人大、政协等")
    private String forgk;

    /**
     * 单位节点类型 1为实体单位 0为分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位节点类型 1为实体单位 0为分类")
    private String fornodetype;

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
