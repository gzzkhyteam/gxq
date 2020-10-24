package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OfficeSaveDTO {
	/**
     * 原字号
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "原字号")
    private String task;  

	/**
     * 消息主题
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "消息主题")
    private String topic;
    /**
     * 紧急程度
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "紧急程度")
    private Integer urgent;
    /**
     * 接收人id
     */
	@ApiModelProperty(value = "接收人id")
    private Long receiverId;
    /**
     * 任务发生地址
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务发生地址")
    private String taskUrl;
    /**
     * 任务创建人
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务创建人")
    private String createUser;
    /**
     * 任务创建人id
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务创建人id")
    private Long createUserId;
}
