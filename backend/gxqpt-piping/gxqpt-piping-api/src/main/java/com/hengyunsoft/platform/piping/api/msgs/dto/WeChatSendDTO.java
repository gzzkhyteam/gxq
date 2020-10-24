package com.hengyunsoft.platform.piping.api.msgs.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "wechat", description = "微信消息对象")
public class WeChatSendDTO implements Serializable{

	private static final long serialVersionUID = 1L;		
	/**
	 * 信息的主题
	 */
	@ApiModelProperty(value = "信息的主题,必传")
	private String topic;
	/**
	 * 发送渠道（"xxx,xxx,xxx"）
	 */
	@ApiModelProperty(value = "发送渠道,必传（多个用英文逗号隔开：\"xxx,xxx,xxx\"）；通过发布管道 “获取渠道接口”接口获得")
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
	 * 信息摘要
	 */
	@ApiModelProperty(value = "信息摘要，非必传，不传默认抓取文章前32个字")
	private String digest;
	/**
	 * 微信封面图片地址（可以不传，不传会默认一张）
	 */
	@ApiModelProperty(value = "微信封面图片地址（非必传，不传会默认一张）")
	private String filepath;
	/**
	 * 消息内容，带html标签
	 */
	@ApiModelProperty(value = "消息内容，必传，带html标签，否则发布不成功")
	private String imgText;

}
