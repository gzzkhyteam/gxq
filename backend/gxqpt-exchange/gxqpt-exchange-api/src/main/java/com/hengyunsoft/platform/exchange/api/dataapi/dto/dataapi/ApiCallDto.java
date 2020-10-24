package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：提供可调用API查询参数
 * 修改人：zhaopengfei
 * 修改时间：2018/7/4
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiCall", description = "提供可调用API查询参数")
public class ApiCallDto {
    @ApiModelProperty(value = "用户Id")
    private Long userId;

    @ApiModelProperty(value = "接口名称")
    private String apiName;


}
