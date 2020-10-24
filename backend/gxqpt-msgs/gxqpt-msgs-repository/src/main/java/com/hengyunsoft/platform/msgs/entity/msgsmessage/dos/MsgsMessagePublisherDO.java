package com.hengyunsoft.platform.msgs.entity.msgsmessage.dos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "MsgsMessagePublisherDO", description = "消息分页查询参数对象")
public class MsgsMessagePublisherDO {
	/**
     * 发布商id
     */
    @ApiModelProperty(value = "发布商id")
    private String appId;
	/**
     * 用户id
     */
    @ApiModelProperty(value = "用户id，不用传")
    private Long userId;
    /**
     * 渠道类型
     */
    @ApiModelProperty(value = "渠道类型")
    private Integer channelType;

    /**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String name;
    /**
     * 消息状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息状态，不用传")
    private Long msgStatus = 0L;

    /**
     *创建开始时间
     */
    @ApiModelProperty(value = "创建开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeStart;

    /**
     *创建截止时间
     */
    @ApiModelProperty(value = "创建截止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeEnd;   
    @ApiModelProperty(value = "渠道id，不用传")
    private List<String> channelIds;
}
