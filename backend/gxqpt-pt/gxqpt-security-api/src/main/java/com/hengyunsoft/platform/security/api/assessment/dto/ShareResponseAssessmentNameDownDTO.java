package com.hengyunsoft.platform.security.api.assessment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareResponseAssessmentNameDown", description = "系统名称下拉框查询返回信息")
public class ShareResponseAssessmentNameDownDTO implements Serializable {

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String applicationName;
}
