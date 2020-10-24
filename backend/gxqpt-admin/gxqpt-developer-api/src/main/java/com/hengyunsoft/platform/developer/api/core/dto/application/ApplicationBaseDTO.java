package com.hengyunsoft.platform.developer.api.core.dto.application;

import com.hengyunsoft.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ApplicationBaseDTO extends BaseEntity<Long> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开发者ID，提供给各个应用的设别码")
    private String appId;

    /**
     * 开发者密码是校验开发者身份的密码，具有极高的安全性
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开发者密码是校验开发者身份的密码，具有极高的安全性")
    private String appSecret;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "首页访问地址")
    private String indexUrl;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

    /**
     * 应用logo
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用logo")
    private String logoUrl;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能描述")
    private String desc;

    /**
     * 应用编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用编码")
    private String code;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer orderNo;

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用/服务类型： 1 应用   2服务   3既是应用也是服务")
    private Short appType;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务等等）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用/服务分类（共性应用、统一平台、共性服务等等）")
    private String type;

    /**
     * 提供方   pt 平台   zk 中科 等等
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提供方   pt 平台   zk 中科 等等")
    private String provider;

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用")
    private Boolean status;

    /**
     * 随机序列
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "随机序列")
    private String randomStr;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人id")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 应用所属单位Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用所属单位Id")
    private String orgId;

    /**
     * 单位所属体系编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位所属体系编码")
    private String orgSystemCode;

    private static final long serialVersionUID = 1L;
}
