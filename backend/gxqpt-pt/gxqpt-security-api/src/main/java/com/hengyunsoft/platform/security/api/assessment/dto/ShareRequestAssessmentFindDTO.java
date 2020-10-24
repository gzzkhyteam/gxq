package com.hengyunsoft.platform.security.api.assessment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareRequestAssessmentFind", description = "系统安全评估列表接收信息")
public class ShareRequestAssessmentFindDTO implements Serializable {

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String applicationName;

    /**
     * 安全等级 0低 1中 2高
     *
     * @mbggenerated
     */
//    @ApiModelProperty(value = "安全等级 0低 1中 2高")
//    private String level;
}
