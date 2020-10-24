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
@ApiModel(value = "AssignModuleApplyAppr", description = "模块申请DTO")
public class AssignModuleApplyApprDTO implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 审批状态
     */
    @ApiModelProperty(value = "是否通过")
    private Boolean passStatus;

    /**
     * 审核意见
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核描述，意见")
    private String auditDesc;


    private static final long serialVersionUID = 1L;

}