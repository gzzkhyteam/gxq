package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api调用异常处理信息
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiCallExceptionHdle", description = "api调用异常处理信息")
public class ApiCallExceptionHdleDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "处理方式")
    private String hdleContent;
}
