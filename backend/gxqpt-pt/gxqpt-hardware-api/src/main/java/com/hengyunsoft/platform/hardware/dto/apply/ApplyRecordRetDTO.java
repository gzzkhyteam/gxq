package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ApplyRecordRetDTO", description = "审批记录")
public class ApplyRecordRetDTO {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请表主键")
    private Long applyKeyid;

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人id")
    private String applyUid;

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人名称")
    private String applyUname;

    /**
     * 是否通过（1通过2不通过）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 是否通过（1通过2不通过）")
    private String passFlag;

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批意见")
    private String apprOpinion;

    /**
     * 环节代码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节代码")
    private String stepCode;

    /**
     * 处理环节名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理环节名称")
    private String stepName;
    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
