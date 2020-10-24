package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
@ApiModel(value = "Message", description = "消息对象")
public class MessageDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 发送信息的id,草稿发送的时候需要传
	 */
	@ApiModelProperty(value = "发送信息的id")
	private String msgId;
	/**
	 * 信息的主题
	 */
	@ApiModelProperty(value = "信息的主题")
	private String topic;
	/**
	 * 发送渠道集合
	 */
	@ApiModelProperty(value = "发送渠道集合")
	private List<MsgsChannelThreeDTO> channelIds;
    /**
    * 发送状态：0=发送；1=存草稿；2=草稿编辑发送
    */
    @ApiModelProperty(value = "发送状态")
    private int draft = 0;
    /**
	* 定时发送时间 "yyyy-MM-dd HH:mm:ss"
	*/
	@ApiModelProperty(value = "定时发送时间 yyyy-MM-dd HH:mm:ss")
	private String startTime;
	/**
	 * 文件url
	 */
	@ApiModelProperty(value = "信息文件url")
	private String fileUrl;
    /**
    * 微信摘要，非必传；默认抓取文章前60个字
    */
    @ApiModelProperty(value = "微信摘要，非必传；默认抓取文章前60个字")
    private String digest;
	/**
	 * 微信封面图片地址（可以不传，不传会默认一张）
	 */
	@ApiModelProperty(value = "微信封面图片地址（可以不传，不传会默认一张）")
	private String filePath;
	/**
	 * 消息内容，可以带html标签
	 */
	@ApiModelProperty(value = "消息内容，可以带html标签")
	private String imgText;
	
	
	
	//========================以下参数不需要传==================================
	
	/**
	 * 应用程序的id,不需要传
	 */
	@ApiModelProperty(value = "应用程序的id,不需要传")
	private String appId;
	/**
	 * 应用程序的名称,不需要传
	 */
	@ApiModelProperty(value = "应用程序的名称,不需要传")
	private String appName;
	/**
	 * 发送者id,不需要传
	 */
	@ApiModelProperty(value = "发送者id,不需要传")
	private String sender;
	/**
	 * 发送者名称,不需要传
	 */
	@ApiModelProperty(value = "发送者名称,不需要传")
	private String senderName;
	/**
	 * 接收者账号、手机号（手机号支持多个，用逗号隔开，最多1000个手机号），不需要传
	 */
	@ApiModelProperty(value = "接收者账号、手机号，不需要传")
	private String receiver;
	/**
     * 短信模板id，不需要传
     */
	@ApiModelProperty(value = "短信模板id，不需要传")
    private String templateId;
    /**
     * 短信模板参数，不需要传
     */
	@ApiModelProperty(value = "短信模板参数，不需要传")
    private String templateParams;
	/**
	 * 短信文本内容，不需要传
	 */
	@ApiModelProperty(value = "信息文本内容，不需要传")
	private String context;
    /**
     * 渠道id，不需要传
     */
	@ApiModelProperty(value = "渠道id，不需要传")
    private String channelId;
	/**
	 * 信息来源类型
	 */
	@ApiModelProperty(value = "信息来源类型")
	private String sourceType;
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
}
