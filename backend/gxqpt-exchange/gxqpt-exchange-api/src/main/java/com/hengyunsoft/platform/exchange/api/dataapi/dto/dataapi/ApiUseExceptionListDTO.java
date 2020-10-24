package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api使用情况列表返回字段
 * 修改人：zhaopengfei
 * 修改时间：2018/5/1
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiUseExceptionList", description = "API基础信息")
public class ApiUseExceptionListDTO {
    @ApiModelProperty(value = "调用情况Id")
    private Long id;
    @ApiModelProperty(value = "异常情况")
    private String failLog;

    @ApiModelProperty(value = "异常时间")
    private Date visitTime;

    @ApiModelProperty(value = "异常来源")
    private Integer failType;

    @ApiModelProperty(value = "处理状态")
    private Integer hdleState;

    @ApiModelProperty(value = "处理人")
    private String hdleUser;
}
