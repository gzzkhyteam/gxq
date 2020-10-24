package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api调用异常展示信息
 * 修改人：zhaopengfei
 * 修改时间：2018/5/2
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiUseExceptionDetail", description = "api调用异常展示信息")
public class ApiUseExceptionDetailDTO {
    @ApiModelProperty(value = "调用情况Id")
    private Long id;
    @ApiModelProperty(value = "异常情况")
    private String failLog;

    @ApiModelProperty(value = "异常时间")
    private Date visitTime;

    @ApiModelProperty(value = "异常来源")
    private Integer failType;
}
