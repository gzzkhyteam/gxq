package com.hengyunsoft.platform.developer.api.core.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApplicationApplyAudit", description = "应用审核实体")
public class ApplicationApplyAuditDTO {
    /**
     * id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 申请状态： 1、待审核     2、已通过      3、被拒绝
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请状态： 1、待审核     2、已通过      3、被拒绝")
    private Short applyStatus;
    /**
     * 审批备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批备注")
    private String auditDesc;
}
