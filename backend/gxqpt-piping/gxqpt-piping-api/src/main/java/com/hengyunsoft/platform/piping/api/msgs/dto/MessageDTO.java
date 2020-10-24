package com.hengyunsoft.platform.piping.api.msgs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "Message", description = "消息对象")
public class MessageDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 发送信息的id,草稿发送的时候需要传
	 */
	@ApiModelProperty(value = "发送信息的id")
	private String msgId;
	/**
	 * 应用程序的id
	 */
	@ApiModelProperty(value = "应用程序的id")
	private String appId;
	/**
	 * 应用程序的名称
	 */
	@ApiModelProperty(value = "应用程序的名称")
	private String appName;
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
//	/**
//	 * 信息类型（微信、微博、短信、移动终端、公示平台：多个用英文逗号隔开）
//	 * WeChat\Blog\Sms\Mobile\Public
//	 */
//	@ApiModelProperty(value = "信息类型")
//	private String msgType;
	/**
	 * 信息的主题
	 */
	@ApiModelProperty(value = "信息的主题")
	private String topic;
	/**
	 * 发送渠道（json格式{"WeChat":"xxx,xxx,xxx","Sms":"xxx,xxx"}）
	 */
	@ApiModelProperty(value = "发送渠道（json格式{\"WeChat\":\"xxx,xxx,xxx\",\"Sms\":\"xxx,xxx\"}）")
	private String channelId;
	/**
	 * 短信模板id
	 */
	@ApiModelProperty(value = "短信模板id")
	private String templateId;
	/**
	 * 短信模板参数，json格式：例如模板内容为"尊敬的${name},您的验证码为${code}"时,此处的值为"{\"name\":\"xxx\",\"code\":\"xxxxxx\"}"
	 */
	@ApiModelProperty(value = "短信模板参数，json格式：例如模板内容为\"尊敬的${name},您的验证码为${code}\"时,此处的值为\"{\"name\":\"xxx\",\"code\":\"xxxxxx\"}")
    private String templateParams;
    /**
     * 发送状态：0=发送；1=存草稿；2=草稿编辑发送
     */
    @ApiModelProperty(value = "发送状态：0=发送；1=存草稿；2=草稿编辑发送")
    private int draft = 0;
	/**
	 * 发送起始时间 "yyyy-MM-dd HH:mm:ss"
	 */
	@ApiModelProperty(value = "发送起始时间 yyyy-MM-dd HH:mm:ss")
	private String startTime;
	/**
	 * 发送终止时间 "yyyy-MM-dd HH:mm:ss"
	 */
	@ApiModelProperty(value = "发送终止时间 yyyy-MM-dd HH:mm:ss")
	private String endTime;
	/**
	 * 信息文本内容
	 */
	@ApiModelProperty(value = "信息文本内容")
	private String context;
	/**
	 * 信息文件id
	 */
	@ApiModelProperty(value = "信息文件id")
	private String fileId;
	/**
	 * 信息文件url
	 */
	@ApiModelProperty(value = "信息文件url")
	private String fileUrl;
	/**
	 * 信息摘要
	 */
	@ApiModelProperty(value = "信息摘要")
	private String digest;
	/**
	 * 图文消息,json格式{"filepath":"xxx","topic":"xxx","content":"xxx"}
	 * 多个图文用"#&!"分开 例{"filepath":"xxx","topic":"xxx","content":"xxx"}#&!{"filepath":"xxx","topic":"xxx","content":"xxx"}
	 */
	@ApiModelProperty(value = "图文消息,json格式{\"filepath\":\"xxx\",\"topic\":\"xxx\",\"content\":\"xxx\"}"
			+ "多个图文用\"#&!\"分开 例{\"filepath\":\"xxx\",\"topic\":\"xxx\",\"content\":\"xxx\"}#&!{\"filepath\":\"xxx\",\"topic\":\"xxx\",\"content\":\"xxx\"}")
	private String imgText;
}
