package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "ServerManageChange", description = "服务分配管理改变查询")
public class ServerManageChangeDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "服务器id")
    private String serverId;
    @ApiModelProperty(value = "服务器ip")
    private String ip;
    @ApiModelProperty(value = "cpu核数")
    private Integer cpuCount;
    @ApiModelProperty(value = "内存大小")
    private Integer memorySize;
    @ApiModelProperty(value = "操作系统")
    private String system;
    @ApiModelProperty(value = "所属网络")
    private String netScope;
    @ApiModelProperty(value = "网络带宽")
    private String netWide;
    @ApiModelProperty(value = "变更次数")
    private Integer changeCount;
    /**
     * 变更源（由哪条服务器记录变更而来）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变更源（由哪条服务器记录变更而来）")
    private Long pid;

    /**
     * 初始变更源（记录最开始被变更的服务器主键）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "初始变更源（记录最开始被变更的服务器主键）")
    private Long originId;

    /**
     * 申请单号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请单号")
    private String applyNo;

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人姓名")
    private String applyUname;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请时间")
    private Date applyTime;
    @ApiModelProperty(value = "磁盘详情实体")
    private List<ServerAddDiskDetailDTO> dtos;
}
