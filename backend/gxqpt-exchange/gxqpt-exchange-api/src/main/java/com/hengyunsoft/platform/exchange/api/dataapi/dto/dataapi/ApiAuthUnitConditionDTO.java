package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api授权单位查询参数
 * 修改人：zhaopengfei
 * 修改时间：2018/4/30
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiAuthUnitCondition", description = "api授权单位查询参数")
public class ApiAuthUnitConditionDTO {
    @ApiModelProperty(value = "apiId",required = true)
    private Long apiId;
    @ApiModelProperty(value = "单位id")
    private String unitName;
}
