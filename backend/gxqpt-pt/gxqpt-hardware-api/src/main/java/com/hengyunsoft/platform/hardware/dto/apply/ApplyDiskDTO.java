package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplyDiskDTO", description = "磁盘申请")
public class ApplyDiskDTO {

    /**
     * 磁盘属性（1数据盘，2系统盘）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘属性（1数据盘，2系统盘）")
    private Integer diskType;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "磁盘大小")
    private Long diskSize;

}
