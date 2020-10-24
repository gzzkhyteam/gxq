package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author luchanghong
 * @create 2018-04-04 11:02
 * @desc 主机应用部署列表实体
 **/
@Data
public class ApplicationHostInstallListDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 主机id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机id")
    private Long hostId;

    /**
     * 内存（单位M）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存（单位M）")
    private Integer mem;

    /**
     * 硬盘容量(单位M)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "硬盘容量(单位M)")
    private Integer harddisk;

    /**
     * 安装部署路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "安装部署路径")
    private String installPath;

    /**
     * 应用版本
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用版本")
    private String version;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "首页访问地址")
    private String indexUrl;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 状态     1、故障中；20、升级中；30、  运行中
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态     1、故障中；20、升级中；30、  运行中")
    private Integer status;

//表外字段
    @ApiModelProperty(value = "主机名称")
    private  String hostName;//主机名称
    @ApiModelProperty(value = "应用名称")
    private  String applicationName;//应用名称


    private static final long serialVersionUID = 1L;
}