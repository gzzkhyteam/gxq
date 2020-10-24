package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardHandleAnalysisDTO", description = "各操作数量统计")
public class StandardHandleAnalysisDTO {

    @ApiModelProperty(value = "标准总数量")
    private Integer standardNum;
    @ApiModelProperty(value = "本月新增标准数量")
    private Integer monthAddNum;
    @ApiModelProperty(value = "使用标准数量")
    private Integer standardUsedNum;
    @ApiModelProperty(value = "本月使用标准数量")
    private Integer monthUsedNum;
    @ApiModelProperty(value = "过期标准数量")
    private Integer overdueNum;
    @ApiModelProperty(value = "本月标准过期数量")
    private Integer monthOverdueNum;
    @ApiModelProperty(value = "运维标准数量")
    private Integer operationNum;
    @ApiModelProperty(value = "本月新增运维标准数量")
    private Integer monthOperationNum;
}
