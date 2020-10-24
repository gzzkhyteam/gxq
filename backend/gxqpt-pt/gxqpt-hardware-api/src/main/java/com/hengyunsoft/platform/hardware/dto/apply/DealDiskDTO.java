package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DealDiskDTO", description = "优易分配虚拟机磁盘")
public class DealDiskDTO {
    /**
     * 磁盘id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘id")
    private String diskId;

    /**
     * 磁盘名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘名称")
    private String diskName;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘大小")
    private Long diskSize;

    /**
     * 挂载点
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "挂载点")
    private String diskPath;

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘属性（1数据盘，2系统盘）")
    private String diskType;

}
