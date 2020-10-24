package com.hengyunsoft.platform.exchange.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareResponseDictDTO", description = "数据字典request信息")
public class ShareRequestSaveSystemDTO implements Serializable {

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String sysName;

    /**
     * 系统承建商
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统承建商")
    private String contractor;

    /**
     * 承建商联系人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "承建商联系人")
    private String contName;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系电话")
    private String contTel;

    /**
     * 系统使用状态:1,在用；2，停用；3，整改中；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统使用状态:1,在用；2，停用；3，整改中；")
    private Integer status;

    /**
     * 访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "访问地址")
    private String url;

    /**
     * 用户体系:1,电子政务网；2，自建
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户体系:1,电子政务网；2，自建")
    private Integer userReft;

    /**
     * 网络环境:1,互联网；2，电子政务外网；3，电子政务内网；4，电子政务专网
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网络环境:1,互联网；2，电子政务外网；3，电子政务内网；4，电子政务专网")
    private Integer network;

    /**
     * 是否需要key:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否需要key:1,是；2，否")
    private Integer hasKey;

    /**
     * 是否需要VPN:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否需要VPN:1,是；2，否")
    private Integer hasVpn;

    /**
     * 系统架构:1，BS; 2,CS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统架构:1，BS; 2,CS")
    private Integer sysArch;

    /**
     * 账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 密码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 开发语言及框架
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开发语言及框架")
    private String langeFrwork;

    /**
     * 是否有系统说明书:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否有系统说明书:1,是；2，否")
    private Integer hasInstruction;

    /**
     * 系统运行环境
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统运行环境")
    private String sysRunEnvent;

    /**
     * 数据存储地
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据存储地")
    private String dataAddress;

    /**
     * 数据库类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库类型")
    private String dbType;

    /**
     * 数据量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据量")
    private Integer dataCount;

    /**
     * 是否有数据字典:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否有数据字典:1,是；2，否")
    private Integer hasDict;

    /**
     * 是否对外提供数据共享接:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否对外提供数据共享接:1,是；2，否")
    private Integer shareChain;

    /**
     * 对其他单位的数据需求
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "对其他单位的数据需求")
    private String dataDemand;

    /**
     * 系统包含主要数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统包含主要数据")
    private String majorData;

    /**
     * 系统主要用途
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统主要用途")
    private String sysPurpose;


}
