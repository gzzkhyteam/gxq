package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AddHostResourceDTO", description = "新增硬件资源")
public class AddHostResourceDTO {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 申请表主键（资源不足时为哪个申请进行资源补充便于展示）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请表主键")
    private Long applyKeyid;

    /**
     * 主机ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机ip")
    private String ip;

    /**
     * 所属集群（手动输入）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属集群（手动输入）")
    private String cluster;

    /**
     * 型号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "型号")
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
