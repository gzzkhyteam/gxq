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
 * @desc 加班审批
 **/
@Data
@ApiModel(value = "WorkApproveExtraDTO",description = "加班审批")
public class WorkApproveExtraDTO implements Serializable{

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 审批主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批主键")
    private Long approveId;

    /**
     * 加班开始日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;

    /**
     * 加班结束日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;

    /**
     * 加班时间长（小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班时间长（小时）")
    private Float extraHour;

    /**
     * 加班内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班内容")
    private String content;

    /**
     * 图片地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    /**
     * '是否自动扫描到考勤统计的加班小时（1：是，2：否）'
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否自动扫描到考勤统计的加班小时（1：是，2：否）'")
    private Short autoUpdate;

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