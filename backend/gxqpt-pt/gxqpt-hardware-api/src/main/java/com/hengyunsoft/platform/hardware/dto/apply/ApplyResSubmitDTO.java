package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplyResSubmitDTO", description = "所需新增资源表单数据")
public class ApplyResSubmitDTO {

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
     * cpu核数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "cpu核数")
    private Integer cpuCount;

    /**
     * cpu型号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "cpu型号")
    private String cpuModel;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存大小")
    private Integer memorySize;

    /**
     * 内存规格
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存规格")
    private String memoryModel;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘大小")
    private Long diskSize;

    /**
     * 磁盘规格
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘规格")
    private String diskModel;

    /**
     * 网卡数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网卡数量")
    private Integer netcardCount;

    /**
     * 网卡型号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网卡型号")
    private String netcardModel;

    /**
     * 交换机数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "交换机数量")
    private Integer changeMachine;

    /**
     * 交换机型号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "交换机型号")
    private String changeModel;

    /**
     * 光模块数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "光模块数量")
    private Integer lightCount;

    /**
     * 光模块型号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "光模块型号")
    private String lightModel;

    /**
     * 独显数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "独显数量")
    private Integer videocardCount;

    /**
     * 独显型号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "独显型号")
    private String videocardModel;

    /**
     * 需求说明
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "需求说明")
    private String remark;

    /**
     * 每一个环节的特定标识（避免多个字段确认一个环节）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节的特定标识")
    private String stepCode;
}
