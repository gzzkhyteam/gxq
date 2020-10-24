package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-07-16 17:19
 * @desc 更改主机数据
 **/
@Data
public class UpdateMachineDTO {
    /**
     * 主机id
     */
    @ApiModelProperty(value = "主机id")
    private Long id;

    /**
     * 主机ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机ip")
    private String ip;

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    private Long applyKeyid;

    /**
     * 所属集群（手动输入）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属集群")
    private String cluster;

    /**
     * 型号
     *
     * @mbggenerated
     */
    @ApiModelProperty("型号")
    private String model;

    /**
     * 处理器类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理器类型")
    private String cpuType;

    /**
     * 处理器数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理器数量")
    private Integer cpuCount;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存大小")
    private Integer memory;

    /**
     * 网卡数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网卡数量")
    private Integer netcardCount;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘大小")
    private Long diskSize;

}