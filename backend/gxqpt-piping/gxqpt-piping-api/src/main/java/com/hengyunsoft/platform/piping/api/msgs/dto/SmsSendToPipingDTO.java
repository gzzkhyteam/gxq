package com.hengyunsoft.platform.piping.api.msgs.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class SmsSendToPipingDTO {
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
	 * 接收者账号、手机号（手机号支持多个，用逗号隔开，最多1000个手机号）
	 */
	@ApiModelProperty(value = "接收者账号、手机号（手机号支持多个，用逗号隔开，最多1000个手机号）")
	private String receiver;
	/**
	 * 发送渠道（"xxx,xxx"）
	 */
	@ApiModelProperty(value = "发送渠道（多个用英文逗号隔开：\"xxx,xxx\"）；通过发布管道 “查询短信渠道”接口获得")
	private String channelId;
	/**
	 * 短信模板id
	 */
	@ApiModelProperty(value = "短信模板id：通过发布管道 “获取某个渠道下的模板列表”接口获得")
	private String templateId;
	/**
	 * 短信模板参数，json格式：例如模板内容为"尊敬的${name},您的验证码为${code}"时,此处的值为"{\"name\":\"xxx\",\"code\":\"xxxxxx\"}"
	 */
	@ApiModelProperty(value = "短信模板参数：通过发布管道 “获取某个渠道下的模板列表”接口获得;json格式：例如模板内容为\"尊敬的${name},您的验证码为${code}\"时,此处的值为\"{\"name\":\"xxx\",\"code\":\"xxxxxx\"}")
    private String templateParams;
    /**
    * 发送状态：0=发送；1=存草稿；2=草稿编辑发送
    */
    @ApiModelProperty(value = "发送状态:不需要传")
    private int draft;
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
	 * 模块id
	 */
	@ApiModelProperty(value = "模块id，模块必传,其他类型不用")
	private Long moduleId;

	/**
	 * 模块名称
	 */
	@ApiModelProperty(value = "模块名称，模块必传,其他类型不用")
	private String moduleName;
	/**
	 * 发送起始时间 "yyyy-MM-dd HH:mm:ss"
	 */
	@ApiModelProperty(value = "定时发送时间 yyyy-MM-dd HH:mm:ss")
	private String startTime;
	/**
	 * 信息来源类型
	 */
	@ApiModelProperty(value = "信息来源类型")
	private String sourceType;

	/**
	 * 短信文本内容
	 */
	@ApiModelProperty(value = "信息文本内容")
	private String context;
	/**
	 * 信息的主题
	 */
	@ApiModelProperty(value = "信息的主题")
	private String topic;
}
