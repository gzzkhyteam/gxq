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
 * @desc 请假审批
 **/
@Data
@ApiModel(value = "WorkApproveLeaveDTO",description = "请假审批")
public class WorkApproveLeaveDTO implements Serializable{

    /**
     * 请假审批主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假审批主键")
    private Long id;

    /**
     * 审批主键（字典item_code）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批主键（字典item_code）")
    private Long aproveId;

    /**
     * 请假类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假类型")
    private String leaveType;

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "工作代理人")
    private Long workAgent;

    /**
     * 请假开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    /**
     * 请假结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    @ApiModelProperty(value = "")
    private Float leaveHour;

    /**
     * 请假事由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假事由")
    private String leaveReason;

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
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    private Long updateUser;


    /**
     * 审批记录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批记录")
    private WorkApproveRecordDTO approveRecord;

}