package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-07-16 14:19
 * @desc 主机筛选条件实体
 **/
@Data
public class MachineConditionDTO {


    /**
     * 主机ip
     *
     * @mbggenerated
     */
    @ApiModelProperty("主机ip")
    private String ip;


    /**
     * 型号
     *
     * @mbggenerated
     */
    @ApiModelProperty("型号")
    private String model;


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


}