package com.hengyunsoft.platform.warn.entity.domain;

import com.hengyunsoft.platform.supervise.dto.analysis.GxqptPublicOrgNodeDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicSuperviseStatus", description = "公用预警状态统计映射参数")
public class GxqptPublicSuperviseStatusDO extends GxqptPublicOrgNodeDTO {
    @ApiModelProperty(value = "已处理预警")
    private Integer processed;
    @ApiModelProperty(value = "未处理预警")
    private Integer untreated;
    @ApiModelProperty(value = "新增预警")
    private Integer newThisYear;
}
