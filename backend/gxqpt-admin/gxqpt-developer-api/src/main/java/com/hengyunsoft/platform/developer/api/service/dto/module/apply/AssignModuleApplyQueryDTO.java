package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述:模块申请DTO
 * @author chb
 * @date 2018/4/3 11:16 
 */
@Data
@ApiModel(value = "AssignModuleApplyQuery", description = "查询模块申请")
public class AssignModuleApplyQueryDTO implements Serializable {

    /**
     * 功能id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能id")
    private Long moduleId;

    /**
     * 审核状态：1 起草  2 待审核     3 审核通过    4 审核不通过
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核状态：1 起草  2 待审核     3 审核通过    4 审核不通过")
    private Short status;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人名称")
    private String auditUserName;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人")
    private String applyUserName;

    private static final long serialVersionUID = 1L;
}