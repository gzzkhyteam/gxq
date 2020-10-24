package com.hengyunsoft.platform.exchange.api.flow.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ShareFlowAuditDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "流程编码")
    private String procCode;


    @ApiModelProperty(value = "环节名称")
    private String nodeName;

    @ApiModelProperty(value = "环节编号")
    private String nodeCode;

    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    @ApiModelProperty(value = "审批人id")
    private Long userId;

    @ApiModelProperty(value = "审批人姓名")
    private String userName;

    @ApiModelProperty(value = "审批时间")
    private Date auditTime;

    @ApiModelProperty(value = "状态:1,通过；2，驳回")
    private Integer status;


    @ApiModelProperty(value = " 审批意见")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private Long createUser;

    @ApiModelProperty(value = " 更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "更新人")
    private Long updateUser;
}
