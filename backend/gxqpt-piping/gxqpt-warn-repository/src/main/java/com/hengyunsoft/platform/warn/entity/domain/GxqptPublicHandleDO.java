package com.hengyunsoft.platform.warn.entity.domain;

import com.hengyunsoft.platform.supervise.dto.analysis.GxqptPublicOrgNodeDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicHandle", description = "公用预警状态统计映射参数")
public class GxqptPublicHandleDO extends GxqptPublicOrgNodeDTO {
    @ApiModelProperty(value = "平均确认时长")
    private Float confirmedHours;
    @ApiModelProperty(value = "平均处理时长")
    private Float processedHours;
}
