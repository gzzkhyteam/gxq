package com.hengyunsoft.platform.exchange.api.flow.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.flow.dto
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api处理DTO
 * 修改人：zhaopengfei
 * 修改时间：2018/4/25
 * 修改内容：
 */
@Data
public class ShareDataHandleApiDTO extends HandleDTO {
    @ApiModelProperty(value = "申请类型(1:API延续申请，2：目录新增API，3：已封装API申请)", required = true)
    private Integer applyType;
}

