package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardTypeDTO", description = "标准分类统计")
public class StandardTypeDTO {

    @ApiModelProperty(value = "标准类别名称")
    private String type;
    @ApiModelProperty(value = "标准数量")
    private Integer count;
    @ApiModelProperty(value = "占比")
    private String proportion;
}
