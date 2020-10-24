package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptPublicTopContent", description = "公用TOP10统计映射参数")
public class GxqptPublicTopContentDO {
    @ApiModelProperty(value = "关键词名称")
    private String name;
    @ApiModelProperty(value = "数量")
    private Integer num;
}
