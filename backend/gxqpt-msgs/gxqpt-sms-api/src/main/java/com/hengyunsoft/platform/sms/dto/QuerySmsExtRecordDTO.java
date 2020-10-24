package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "QuerySmsExtRecordDTO", description = "获取短信记录分页列表")
public class QuerySmsExtRecordDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 来源类型APP=应用，SERVICE=服务，MODULAR=模块
	 */
	@ApiModelProperty(value = "来源类型APP=应用，SERVICE=服务，MODULAR=模块")
	private String sourceType;

	/**
	 * 应用程序名称
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "应用程序名称")
	private String appName;

	/**
	 * 短信主题
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "短信主题")
	private String topic;

	/**
	 * 发送者名称
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发送者名称")
	private String senderName;

	/**
	 * 接收者手机号
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "接收者手机号")
	private String phone;

	/**
	 * 发送开始时间
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发送开始时间")
	private Date startTime;

	/**
	 * 发送结束时间
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发送结束时间")
	private Date endTime;
}
