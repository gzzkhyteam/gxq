package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api选择目录dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiFilter", description = "API过滤条件")
public class ApiFilterDTO {
    @ApiModelProperty(value = "API Id", required = true)
    private Long apiId;
    @ApiModelProperty(value = "字段id")
    private List<ApiFilterPropertyDTO> fieldPropertys;
}
