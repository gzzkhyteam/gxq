package com.hengyunsoft.platform.security.api.assessment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareResponseAssessmentFind", description = "安全风险评估列表返回信息")
public class ShareResponseAssessmentFindDTO implements Serializable {

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
     * 安全等级 0低 1中 2高
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "安全等级 0低 1中 2高")
    private String level;

    /**
     * 评估时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "评估时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date assessmentTime;

    /**
     * 评估文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "评估文件名")
    private String assessmentFileName;

    /**
     * 整改文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "整改文件名")
    private String rectificationFileName;
}
