package com.hengyunsoft.platform.developer.api.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luchanghong
 * @create 2018-04-03 15:24
 * @desc 主机实体
 **/
@Data
@ApiModel(value = "Host",description = "主机数据实体")
public class HostDTO  implements Serializable{
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 域名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "域名")
    private String domainName;

    /**
     * 公网ip地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公网ip地址")
    private String ipAddrPublic;

    /**
     * 内网ip地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内网ip地址")
    private String ipAddr;

    /**
     * 主机名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机名")
    private String hostName;

    /**
     * 操作系统类型(windows-server,linux,mac)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value ="操作系统类型(windows-server,linux,mac" )
    private String osType;

    /**
     * 操作系统版本号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作系统版本号")
    private String osVersion;

    /**
     * cpu信息
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "cpu信息")
    private String cpuInfo;

    /**
     * CPU核数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "CPU核数")
    private Short cpuCount;

    /**
     * 服务商
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务商")
    private String serverProvider;

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
     * 是否虚拟主机（ 1、否    2、是）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否虚拟主机（ 1、否    2、是）")
    private Short virtualHost;

    /**
     * 物理主机id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "物理主机id")
    private Long physicalHostId;


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
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 主机状态（1.启用，2.停用）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机状态（1.启用，2.停用）")
    private Boolean status;

    private static final long serialVersionUID = 1L;
}