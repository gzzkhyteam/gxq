package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api选择目录dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiFilterProperty", description = "API过滤字段属性")
public class ApiFilterPropertyDTO {
    @ApiModelProperty(value = "字段id")
    private Long fieldId;
    @ApiModelProperty(value = "筛选规则:1,大于；2，小于；3，等于；4，模糊")
    private Integer scrRule;
    @ApiModelProperty(value = "筛选值")
    private String scrValue;
}
