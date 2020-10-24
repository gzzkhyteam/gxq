package com.hengyunsoft.platform.security.api.assessment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareRequestAssessmentReportSave", description = "新增测评报告接收信息")
public class ShareRequestAssessmentReportSaveDTO implements Serializable {

    /**
     * 评估id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "评估id")
    private Long assessmentId;

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
     * 评估报告id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "评估报告id")
    private Long assessmentFileId;

    /**
     * 评估文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "评估文件名")
    private String assessmentFileName;

    /**
     * 评估文件路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "评估文件路径")
    private String assessmentFileUrl;

    /**
     * 整改文件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "整改文件id")
    private Long rectificationFileId;

    /**
     * 整改文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "整改文件名")
    private String rectificationFileName;

    /**
     * 整改文件路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "整改文件路径")
    private String rectificationFileUrl;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remarks;
}
