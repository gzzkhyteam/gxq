package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ResourceCountDTO", description = "软硬件面板各资源数量总计查询")
public class ResourceCountDTO {

    /**
     * 主机数量
     */
    @ApiModelProperty(value = "主机数量")
    private int machineCount;

    /**
     * 服务器数量
     */
    @ApiModelProperty(value = "服务器数量")
    private int serverCount;

    /**
     * cpu数量
     */
    @ApiModelProperty(value = "cpu数量")
    private int cpuCount;

    /**
     * 内存数量
     */
    @ApiModelProperty(value = "内存数量")
    private int memorySize;

    /**
     * 磁盘数量
     */
    @ApiModelProperty(value = "磁盘数量")
    private long diskSize;

}
