package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 审批列表
 **/
@Data
@ApiModel(value = "ResponseWorkApproveDTO",description = "审批列表")
public class ResponseWorkApproveDTO implements Serializable{

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 审批编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批编号")
    private String aproveCode;

    /**
     * 审批类型("1"为请假审批，"2"为出差审批,"3"为普通审批,"4"为加班审批,"5"为外勤申报)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批类型(\"1\"为请假审批，\"2\"为出差审批,\"3\"为普通审批,\"4\"为加班审批,\"5\"为外勤申报)")
    private String aproveType;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    /**
     * 申请人ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人ID")
    private Long applyUserId;

    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人名称")
    private String applyUserName;

    /**
     * 当前状态说明
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前状态说明")
    private String currentState;

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
     * 是否变更（“1”：变更，“0”：未变更）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否变更（“1”：变更，“0”：未变更）")
    private String isChange;

    /**
     * 变更理由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变更理由")
    private String changeReason;

    /**
     * 变更时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变更时间")
    private Date changeTime;

    private static final long serialVersionUID = 1L;

}