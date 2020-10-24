package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：字段参数
 * 修改人：gbl
 * 修改时间：2018/4/23
 * 修改内容：
 */
@Data
@ApiModel(value = "FieldParam", description = "字段参数")
public class FieldParamDTO {
    @ApiModelProperty(value = "字段标识")
    private  String fieldCode;
    @ApiModelProperty(value = "参数规则,1:=,2:>,3:<,4:>=,5:<=,")
    private  int rule;
    @ApiModelProperty(value = "默认值")
    private String value;
    @ApiModelProperty(value = "字段名称")
    private String fieldName;
    @ApiModelProperty(value = "字段类型")
    private String fieldType;
}
