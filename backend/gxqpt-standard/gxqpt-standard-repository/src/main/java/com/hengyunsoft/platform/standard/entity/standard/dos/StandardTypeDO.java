package com.hengyunsoft.platform.standard.entity.standard.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardTypeDO", description = "标准分类统计")
public class StandardTypeDO {

    @ApiModelProperty(value = "标准类别名称")
    private String type;
    @ApiModelProperty(value = "标准数量")
    private Integer count;
    @ApiModelProperty(value = "占比")
    private String proportion;
}
