package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrgAndEmpInfo", description = "人员单位信息返回")
public class OrgAndEmpInfoDTO {

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String id;

    /**
     * 体系编码
     */
    @ApiModelProperty(value = "体系编码")
    private String systemCode;


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
     * 电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "电话")
    private String telcode;

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
     * 传真
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "传真")
    private String faxcode;

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

}
