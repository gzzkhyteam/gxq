package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据集元数据规则
 * 修改人：zhaopengfei
 * 修改时间：2018/8/29
 * 修改内容：
 */
@Data
@ApiModel(value = " DataSetElementRule", description = "数据集元数据规则")
public class DataSetCheakRuleDTO {
    @ApiModelProperty(value = "数据集id")
    private Long setId;
    @ApiModelProperty(value = "每个字段的规则")
    private List<DateSetElementRuleDTO> eles;
}
