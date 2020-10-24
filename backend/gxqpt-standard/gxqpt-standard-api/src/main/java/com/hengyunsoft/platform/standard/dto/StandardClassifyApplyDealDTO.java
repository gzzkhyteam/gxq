package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardClassifyUpdate", description = "更新分类信息参数对象")
public class StandardClassifyApplyDealDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "处理结果描述")
    private String dealResultDescription;

}
