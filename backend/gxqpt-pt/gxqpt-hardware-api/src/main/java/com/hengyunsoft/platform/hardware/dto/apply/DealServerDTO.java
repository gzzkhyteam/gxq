package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "DealServerDTO", description = "优易分配虚拟机")
public class DealServerDTO {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请表主键")
    private Long applyKeyid;

    /**
     * 服务器id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器id")
    private String serverId;

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器ip")
    private String ip;


    /**
     * cpu核数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "cpu核数")
    private Integer cpuCount;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存大小")
    private Integer memorySize;

    /**
     * 操作系统
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作系统")
    private String system;

    /**
     * 所属网络
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属网络")
    private String netScope;

    /**
     * 网络带宽
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网络带宽")
    private Integer netWide;


    /**
     * 申请磁盘
     */
    @ApiModelProperty(value = "申请磁盘")
    private List<DealDiskDTO> disks;
}
