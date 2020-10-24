package com.hengyunsoft.platform.mt.api.appr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：考勤审批
 * 修改人：gbl
 * 修改时间：2018/7/9
 * 修改内容：
 */
@Data
@ApiModel(value = "ApprApplyDTO", description = "")
public class ApprApplyDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 撤销业务Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "撤销业务Id")
    private Long applyId;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    private String aprCode;

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)")
    private String aprType;
    /**
     * 申请人Id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人Id")
    private Long applyUserId;
    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人姓名")
    private String applyUserName;
    /**
     * 照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片")
    private String photo;

    /**
     * 当前状态(1:审批中，2:已驳回，3:已结束，4:已撤销)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "1:审批中，2:已驳回，3:已结束，4:撤销中，5：已经撤销)")
    private Integer curState;

    /***
     * 是否已读
     */
    @ApiModelProperty(value = "是否已读")
    private Integer isRead;
    /**
     * 当前审批人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前审批人id")
    private Long curAprUserId;
    /**
     * 当前审批人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前审批人姓名")
    private String curAprUserName;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
