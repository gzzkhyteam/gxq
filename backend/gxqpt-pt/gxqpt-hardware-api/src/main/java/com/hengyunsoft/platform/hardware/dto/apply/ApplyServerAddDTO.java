package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ApplyServerAddDTO", description = "服务器资源申请")
public class ApplyServerAddDTO {


    /**
     * 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private Long applyKeyid;

    /**
     * cpu核数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "cpu核数")
    private Integer cpuCount;

    /**
     * 内存
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存")
    private Long memorySize;

    /**
     * 操作系统
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作系统")
    private String system;

    /**
     * 系统盘大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统盘大小")
    private Integer sysDisksize;

    /**
     * 网络局域
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网络局域")
    private String netScope;

    /**
     * 网络宽带
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网络宽带")
    private Integer netWide;

    /**
     * 网关描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网关描述")
    private String gatewayDesc;
    /**
     * 申请数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请数量")
    private Integer applyCount;

    /**
     * 申请磁盘
     */
    @ApiModelProperty(value = "申请磁盘")
    private List<ApplyDiskDTO> disks;

}
