package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-07-16 14:12
 * @desc 查询主机列表返回数据实体
 **/
@Data
public class FindMachineListDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机id")
    private Long id;


    /**
     * 主机ip
     *
     * @mbggenerated
     */
    @ApiModelProperty("主机ip")
    private String ip;

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
    @ApiModelProperty("处理器类型")
    private String cpuType;

    /**
     * 处理器数量
     *
     * @mbggenerated
     */
    @ApiModelProperty("处理器数量")
    private Integer cpuCount;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    @ApiModelProperty("内存大小")
    private Integer memory;

    /**
     * 网卡数量
     *
     * @mbggenerated
     */
    @ApiModelProperty("网卡数量")
    private Integer netcardCount;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘大小")
    private Long diskSize;




}