package com.hengyunsoft.platform.security.api.assessment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareRequestProgramFind", description = "程序发布列表接收信息")
public class ShareRequestProgramFindDTO implements Serializable {

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String name;

    /**
     * 审批状态 0 未审批 1审批 3全部
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态 0 未审批 1审批 3全部")
    private Integer auditStatus;

    /**
     * 开始时间yyyy-mm-dd
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间yyyy-mm-dd")
    private String startDate;

    /**
     * 结束时间yyyy-mm-dd
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间yyyy-mm-dd")
    private String endDate;
}
