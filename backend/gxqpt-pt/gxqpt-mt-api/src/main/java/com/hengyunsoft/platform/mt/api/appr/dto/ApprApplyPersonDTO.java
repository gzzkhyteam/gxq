package com.hengyunsoft.platform.mt.api.appr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：提交审批申请时选择的审批人
 * 修改人：gbl
 * 修改时间：2018/7/9
 * 修改内容：
 */
@Data
@ApiModel(value = "ApprApplyPersonDTO", description = "提交审批申请时选择的审批人")
public class ApprApplyPersonDTO {
    /**
     * 审批（抄送）人Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批（抄送）人Id")
    private Long apprUserId;

    /**
     * 审批（抄送）人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批（抄送）人姓名")
    private String apprUserName;

    /**
     * 审批人顺序
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人顺序")
    private Integer apprUserIndex;

    /**
     * 人员类型(1:审批人，2:抄送人)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "人员类型(1:审批人，2:抄送人)")
    private Integer userType;

    /**
     * 照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片")
    private String photo;
}
