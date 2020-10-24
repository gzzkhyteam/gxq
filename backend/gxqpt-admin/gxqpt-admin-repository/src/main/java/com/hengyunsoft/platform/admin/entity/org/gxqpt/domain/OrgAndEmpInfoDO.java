package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgAndEmpInfoDO {

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * 体系编码
     */
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
    private String name;

    /**
     * 电话
     *
     * @mbggenerated
     */
    private String telcode;

    /**
     * 所属类型
     *
     * @mbggenerated
     */
    private String forType;


    /**
     * 所属级别
     *
     * @mbggenerated
     */
    private String forClass;

    /**
     * 所属系统如公安、税务等
     *
     * @mbggenerated
     */
    private String forindustry;

    /**
     * 邮编
     *
     * @mbggenerated
     */
    private String zipcode;

    /**
     * 传真
     *
     * @mbggenerated
     */
    private String faxcode;

    /**
     * 状态 1正常 2待撤销 3 已撤销
     *
     * @mbggenerated
     */
    private String status;


    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    private Integer sortvalue;


    /**
     * 所属省份
     *
     * @mbggenerated
     */
    private String forarea;

    /**
     * 所属市州
     *
     * @mbggenerated
     */
    private String forcity;

    /**
     * 所属区县
     *
     * @mbggenerated
     */
    private String forcounty;

    /**
     * 所属乡镇
     *
     * @mbggenerated
     */
    private String fortown;

    /**
     * 单位归口是政府、人大、政协等
     *
     * @mbggenerated
     */
    private String forgk;

    /**
     * 单位节点类型 1为实体单位 0为分类
     *
     * @mbggenerated
     */
    private String fornodetype;

}
