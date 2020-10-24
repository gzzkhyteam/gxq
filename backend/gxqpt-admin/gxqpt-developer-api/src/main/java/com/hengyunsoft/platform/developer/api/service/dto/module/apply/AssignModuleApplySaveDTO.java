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
@ApiModel(value = "AssignModuleApplySave", description = "新增模块申请")
public class AssignModuleApplySaveDTO implements Serializable {

    /**
     * 功能id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能id")
    private Long moduleId;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;


    /** 审批人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人")
    private Long auditUser;


    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人名称")
    private String auditUserName;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请描述")
    private String applyDesc;

    private static final long serialVersionUID = 1L;

}