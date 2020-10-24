package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CommonApproveDTO", description = "通用审批DTO")
public class CommonApproveDTO {

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请表主键")
    private Long applyKeyid;

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

}
