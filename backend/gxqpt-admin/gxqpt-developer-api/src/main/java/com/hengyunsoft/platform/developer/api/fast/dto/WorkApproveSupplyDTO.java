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
 * @desc 普通审批
 **/
@Data
@ApiModel(value = "WorkApproveSupplyDTO",description = "普通审批")
public class WorkApproveSupplyDTO implements Serializable{

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
    private Long apprId;

    /**
     * 图片地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    /**
     * 补签时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "补签时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date supplyDate;

    /**
     * 0：签到，1：签退
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "0：签到，1：签退")
    private Integer type;

    /**
     * 说明
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "说明")
    private String descript;

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