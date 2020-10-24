package com.hengyunsoft.platform.security.api.assessment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "ShareResponseAssessmentGetById", description = "安全风险评估根据ID查询返回信息")
public class ShareResponseAssessmentGetByIdDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String applicationName;

    /**
     * 建设单位
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "建设单位")
    private String company;

    /**
     * 承建商
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "承建商")
    private String contractor;

    /**
     * 测评报告列表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "承建商")
    private List<ShareResponseAssessmentReportSaveDTO> assessmentReportList;
}
