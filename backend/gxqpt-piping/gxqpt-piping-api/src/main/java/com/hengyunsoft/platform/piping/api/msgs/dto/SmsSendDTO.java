package com.hengyunsoft.platform.piping.api.msgs.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "sms", description = "短信消息对象")
public class SmsSendDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 发送者id
	 */
	@ApiModelProperty(value = "发送者id")
	private String sender;	
	/**
	 * 接收者账号、手机号（手机号支持多个，用逗号隔开，最多1000个手机号）
	 */
	@ApiModelProperty(value = "接收者账号、手机号，必传（手机号支持多个，用逗号隔开，最多1000个手机号）")
	private String receiver;
	/**
	 * 发送渠道（"xxx,xxx"）
	 */
	@ApiModelProperty(value = "发送渠道，必传（多个用英文逗号隔开：\"xxx,xxx\"）；通过发布管道 “查询短信渠道”接口获得")
	private String channelId;
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
	/**
	 * 短信模板id
	 */
	@ApiModelProperty(value = "短信模板id，必传：通过发布管道 “获取某个渠道下的模板列表”接口获得")
	private String templateId;
	/**
	 * 短信模板参数，json格式：例如模板内容为"尊敬的${name},您的验证码为${code}"时,此处的值为"{\"name\":\"xxx\",\"code\":\"xxxxxx\"}"
	 */
	@ApiModelProperty(value = "短信模板参数，必传：通过发布管道 “获取某个渠道下的模板列表”接口获得;json格式：例如模板内容为\"尊敬的${name},您的验证码为${code}\"时,此处的值为\"{\"name\":\"xxx\",\"code\":\"xxxxxx\"}")
    private String templateParams;
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
	@ApiModelProperty(value = "定时发送时间，非必传 yyyy-MM-dd HH:mm:ss")
	private String startTime;

}
