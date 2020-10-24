package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AppPublicTopContent", description = "公用TOP10统计返回参数")
public class AppPublicTopContentDTO {
    @ApiModelProperty(value = "关键词名称")
    private String name;
    @ApiModelProperty(value = "数量")
    private Integer num;
}
