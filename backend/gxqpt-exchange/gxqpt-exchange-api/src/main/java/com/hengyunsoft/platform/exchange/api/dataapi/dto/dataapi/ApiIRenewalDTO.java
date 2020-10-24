package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：API延续申请信息
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiIRenewal", description = "API延续申请信息")
public class ApiIRenewalDTO {
    @ApiModelProperty(value = "共享申请Id")
    private Long id;

    @ApiModelProperty(value = "API id")
    private Long apiId;

    @ApiModelProperty(value = "申请期限:-1表示不受限制；单位（天）")
    private Integer dateTerm;

    @ApiModelProperty(value = "续期理由")
    private String rewalReason;

}
