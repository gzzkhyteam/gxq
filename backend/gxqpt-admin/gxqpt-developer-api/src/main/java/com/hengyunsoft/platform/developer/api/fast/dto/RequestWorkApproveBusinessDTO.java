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
 * @desc 出差审批入参
 **/
@Data
@ApiModel(value = "RequestWorkApproveBusinessDTO",description = "出差审批入参")
public class RequestWorkApproveBusinessDTO implements Serializable{

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;
    /**
     * 出差类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差类型")
    private String businessType;

    /**
     * 图片地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    /**
     * 工作代理人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "工作代理人")
    private Long workAgent;

    /**
     * 出差地址类型（1：省内，2：省外）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差地址类型（1：省内，2：省外）")
    private Integer addrType;

    /**
     * 出差地点
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差地点")
    private String businessAddr;

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "交通工具")
    private String businessVehicle;

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "随行人员")
    private String accompanyUser;

    /**
     * 随行人员电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "随行人员电话")
    private String accompanyUserPhone;

    /**
     * 培训名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "培训名称")
    private String trainName;

    /**
     * 出差开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    /**
     * 出差结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    /**
     * 出差时长
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差时长")
    private Float busHour;

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差事由")
    private String businessRenson;

    /**
     * 是否申请差旅费（1：是，2：否）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否申请差旅费（1：是，2：否）")
    private Integer travelApply;

    /**
     * 当前环节审批人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前环节审批人")
    private Long currentAproveUserId;
    @ApiModelProperty(value = "当前环节审批人名字")
    private String currentAproveUserName;

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

}