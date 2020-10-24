package com.hengyunsoft.platform.piping.api.msgs.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class WeChatSendToPipingDTO {
	/**
	 * 发送信息的id,草稿发送的时候需要传
	 */
	@ApiModelProperty(value = "发送信息的id")
	private String msgId;
	/**
	 * 发送者id
	 */
	@ApiModelProperty(value = "发送者id")
	private String sender;
	/**
	 * 发送者名称
	 */
	@ApiModelProperty(value = "发送者名称")
	private String senderName;
	/**
	 * 信息的主题
	 */
	@ApiModelProperty(value = "信息的主题")
	private String topic;
	/**
	 * 发送渠道（"xxx,xxx,xxx"）
	 */
	@ApiModelProperty(value = "发送渠道（多个用英文逗号隔开：\"xxx,xxx,xxx\"）")
	private String channelId;
    /**
     * 发送状态：0=发送；1=存草稿；2=草稿编辑发送
     */
    @ApiModelProperty(value = "发送状态：0=发送；1=存草稿；2=草稿编辑发送")
    private int draft = 0;
	/**
	 * 应用程序id
	 */
	@ApiModelProperty(value = "应用程序id，不需要传")
	private String appId;
	/**
	 * 应用程序名称
	 */
	@ApiModelProperty(value = "应用程序名称，不需要传")
	private String appName;
	/**
	 * 发送起始时间 "yyyy-MM-dd HH:mm:ss"
	 */
	@ApiModelProperty(value = "定时发送时间 yyyy-MM-dd HH:mm:ss")
	private String startTime;
	/**
	 * 信息摘要
	 */
	@ApiModelProperty(value = "信息摘要")
	private String digest;
	/**
	 * 微信封面图片地址（可以不传，不传会默认一张）
	 */
	@ApiModelProperty(value = "微信封面图片地址（可以不传，不传会默认一张）")
	private String filepath;
	/**
	 * 消息内容，可以带html标签
	 */
	@ApiModelProperty(value = "消息内容，可以带html标签")
	private String imgText;
}
