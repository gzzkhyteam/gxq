package com.hengyunsoft.platform.mt.api.appr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：一条审批记录
 * 修改人：gbl
 * 修改时间：2018/7/11
 * 修改内容：
 */
@Data
@ApiModel(value = "ApprApplyRecodeDTO", description = "一条审批记录")
public class ApprApplyRecodeDTO {
    /**
     * 审批人Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人Id")
    private Long apprUserId;
    /**
     * 审批人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人姓名")
    private String apprUserName;
    /**
     * 是否同意(0:是，1:否)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否同意(0:是，1:否)")
    private Integer agree;
    /**
     * 审批意见
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批意见")
    private String apprOpinion;

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批时间")
    private Date apprTime;
}
