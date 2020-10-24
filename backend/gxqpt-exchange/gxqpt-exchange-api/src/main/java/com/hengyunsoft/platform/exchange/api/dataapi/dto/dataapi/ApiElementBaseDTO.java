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
@ApiModel(value = "ApiElementBase", description = "API元数据基础信息")
public class ApiElementBaseDTO {
    @ApiModelProperty
    private Long id;
    @ApiModelProperty(value = "字段名称")
    private String fieldName;
    @ApiModelProperty(value = "字段类型")
    private String fieldType;
    @ApiModelProperty(value = "字段标识")
    private String fieldCode;
    @ApiModelProperty(value = "字段描述")
    private String desc;
}
