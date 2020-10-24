package com.hengyunsoft.platform.hardware.dto.panel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StorageDiskData", description = "存储资源面板磁盘数据概况返回实体")
public class StorageDiskDataDTO {
    @ApiModelProperty(value = "总内存")
    private Integer memSize;
    @ApiModelProperty(value = "本月新增内存")
    private Integer monthSave;
    @ApiModelProperty(value = "本月回收内存")
    private Integer monthRemove;
    @ApiModelProperty(value = "本月净增内存")
    private Integer netGrowth;
    @ApiModelProperty(value = "本月新增占比")
    private float saveOccupationRatio;
    @ApiModelProperty(value = "本月回收占比")
    private float removeOccupationRatio;
    @ApiModelProperty(value = "本月净增内存占比")
    private float netGrowthOccupationRatio;
    @ApiModelProperty(value = "本月新增环比")
    private float saveRingRatio;
    @ApiModelProperty(value = "本月回收环比")
    private float removeRingRatio;
}
