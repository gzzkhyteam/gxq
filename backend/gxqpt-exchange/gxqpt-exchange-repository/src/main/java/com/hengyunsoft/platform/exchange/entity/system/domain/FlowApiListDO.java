package com.hengyunsoft.platform.exchange.entity.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.system.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/4/25
 * 修改内容：
 */
@Data
public class FlowApiListDO {
    @ApiModelProperty(value = "流程taskId")
    private Long id;

    @ApiModelProperty(value = "API Id")
    private Long apiId;

    @ApiModelProperty(value = "业务申请")
    private Long applyId;

    @ApiModelProperty(value = "申请编码")
    private String applyCode;

    @ApiModelProperty(value = "API编码")
    private String apiCode;

    @ApiModelProperty(value = "API名称")
    private String apiName;

    @ApiModelProperty(value = "目录名称")
    private String dirName;

    @ApiModelProperty(value = "申请单位")
    private String unitName;

    @ApiModelProperty(value = "申请人")
    private String createUserName;

    @ApiModelProperty(value = "申请原因")
    private String applyReason;

    @ApiModelProperty(value = "申请时间")
    private Date createTime;

    @ApiModelProperty(value = "授权期限")
    private Integer dateTerm;

    @ApiModelProperty(value = "申请类型(1:API延续申请，2：目录新增API，3：已封装API申请)")
    private Integer applyType;

    @ApiModelProperty(value = "申请类型名")
    private String applyTypeName;

    @ApiModelProperty(value = "审批状态（0、待处理，1：已通过，2：已驳回）")
    private Integer auditStatus;
    @ApiModelProperty(value = "API所属目录类型（1：结构化文件，2：非结构化文件")
    private Integer dataType;
}
