package com.hengyunsoft.platform.mt.api.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：审核应用请求参数
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：
 */
@Data
@ApiModel(value = "AuditAppReq", description = "审核应用请求参数")
public class AuditAppReqDTO {
    @ApiModelProperty(value = "应用id")
    private Long id;

    @ApiModelProperty(value = "审核状态(3通过,4驳回)")
    private Integer state;

    @ApiModelProperty(value = "审批内容")
    private String auditContent;
}
