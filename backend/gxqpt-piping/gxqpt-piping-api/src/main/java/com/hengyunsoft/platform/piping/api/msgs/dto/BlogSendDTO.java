package com.hengyunsoft.platform.piping.api.msgs.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "blog", description = "微博消息对象")
public class BlogSendDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 发送渠道（"xxx,xxx,xxx"）
	 */
	@ApiModelProperty(value = "发送渠道，必传（多个用英文逗号隔开：\"xxx,xxx,xxx\"）；通过发布管道 “获取渠道接口”接口获得")
	private String channelId;	
	/**
	 * 应用程序id
	 */
	@ApiModelProperty(value = "应用程序id，必传")
	private String appId;
	/**
	 * 应用程序名称
	 */
	@ApiModelProperty(value = "应用程序名称，必传")
	private String appName;
	/**
	 * 发送起始时间 "yyyy-MM-dd HH:mm:ss"
	 */
	@ApiModelProperty(value = "定时发送时间，非必传 yyyy-MM-dd HH:mm:ss")
	private String startTime;
	/**
	 * 信息文本内容
	 */
	@ApiModelProperty(value = "信息文本内容，必传")
	private String imgText;
	/**
	 * 信息文件url
	 */
	@ApiModelProperty(value = "信息文件url，非必传")
	private String fileUrl;
}
