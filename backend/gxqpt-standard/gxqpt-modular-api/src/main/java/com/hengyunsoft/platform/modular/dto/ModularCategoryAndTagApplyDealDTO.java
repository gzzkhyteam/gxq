package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularApplyDeal", description = "申请处理操作对象")
public class ModularCategoryAndTagApplyDealDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 处理意见
     */
    @ApiModelProperty(value = "处理意见")
    private String dealSuggestion;

}
