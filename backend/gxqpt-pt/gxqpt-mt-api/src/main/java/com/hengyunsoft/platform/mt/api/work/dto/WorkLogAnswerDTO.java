package com.hengyunsoft.platform.mt.api.work.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author tianai
 * @createTime 2018-06-7
 */
@Data
public class WorkLogAnswerDTO implements Serializable{

    @ApiModelProperty(value = " 主键")
    private Long id;

    /**
     * 工作日志id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 工作日志id")
    private Long workLogId;

    /**
     * 回复人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 回复人id")
    private Long userId;

    /**
     * 回复内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "回复内容")
    private String content;

    /**
     * 回复人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "回复人姓名")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 头像
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "头像")
    private String  photo;
 /*   *//**
     * 创建时间
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    *//**
     * 更新人
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "更新人")
    private Long updateUser;

    *//**
     * 更新时间
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;*/
}
