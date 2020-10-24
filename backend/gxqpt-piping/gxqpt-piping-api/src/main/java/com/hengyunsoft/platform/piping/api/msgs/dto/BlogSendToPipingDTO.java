package com.hengyunsoft.platform.piping.api.msgs.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class BlogSendToPipingDTO {
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
	 * 发送渠道（"xxx,xxx,xxx"）
	 */
	@ApiModelProperty(value = "发送渠道（多个用英文逗号隔开：\"xxx,xxx,xxx\"）")
	private String channelId;	
    /**
     * 发送状态：0=发送；1=存草稿；2=草稿编辑发送
     */
    @ApiModelProperty(value = "发送状态：0=发送；")
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
	 * 信息文本内容
	 */
	@ApiModelProperty(value = "信息文本内容")
	private String imgText;
	/**
	 * 信息文件url
	 */
	@ApiModelProperty(value = "信息文件url")
	private String fileUrl;
}
