package com.hengyunsoft.platform.developer.api.fast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 审批记录
 **/
@Data
@ApiModel(value = "WorkApproveRecordDTO",description = "审批记录")
public class WorkApproveRecordDTO implements Serializable{

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 审批人员审批顺序
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人员审批顺序")
    private Integer approveSortId;

    /**
     * 审批人ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人ID")
    private Long personId;

    /**
     * 审批人员名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人员名称")
    private String personName;

    /**
     * 审批主键（b_work_approve.ID）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批主键（b_work_approve.ID）")
    private Long apprId;

    /**
     * 审批人员对该审批的操作("1"为同意审批，"2"为驳回)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人员对该审批的操作(\"1\"为同意审批，\"2\"为驳回)")
    private String approveState;

    /**
     * 审批人员对该审批的意见
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人员对该审批的意见")
    private String approveOponion;

    /**
     * 当前环节审批人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前环节审批人")
    private Long currentAproveUserId;

    /**
     * 当前环节审批人操作("1"为等待审批,"2"为同意审批，"3"拒绝审批)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前环节审批人操作(\"1\"为等待审批,\"2\"为同意审批，\"3\"拒绝审批)")
    private String currentAproveUserOperation;

    /**
     * 审批状态("0"为未提交，”1“为已提交)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态(\"0\"为未提交，”1“为已提交)")
    private String aproveState;

    /**
     * 是否已经审批过("0":还未审批过，"1"已经审批过)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否已经审批过(\"0\":还未审批过，\"1\"已经审批过)")
    private String inAprove;

    /**
     * 操作时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operationDate;


}