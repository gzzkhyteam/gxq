package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularHandleAnalysisDTO", description = "各操作数量统计")
public class ModularHandleAnalysisDTO {
    @ApiModelProperty(value = "模块总数量")
    private Integer modularNum;
    @ApiModelProperty(value = "本月新增模块数量")
    private Integer monthAddNum;
    @ApiModelProperty(value = "废弃模块数量")
    private Integer overdueNum;
    @ApiModelProperty(value = "本月废弃模块数量")
    private Integer monthOverdueNum;        
    @ApiModelProperty(value = "使用模块数量")
    private Integer modularUsedNum;
    @ApiModelProperty(value = "本月使用模块数量")
    private Integer monthUsedNum;
    @ApiModelProperty(value = "模块使用率")
    private Double modularUsageRate;
    @ApiModelProperty(value = "本月模块使用率")
    private Double monthUsageRate;
}
