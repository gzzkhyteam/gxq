package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MessageSendDTO", description = "消息发送参数")
public class MessageSendDTO {
	/**
	 * 消息id
	 */
	@ApiModelProperty(value = "消息id")
    private Long id;
	/**
	 * 应用程序id
	 */
	@ApiModelProperty(value = "应用程序id")
    private String appId;
	/**
	 * 发送渠道集合
	 */
	@ApiModelProperty(value = "发送渠道集合")
	private List<MsgsChannelThreeDTO> channelIds;
	/**
	 * 信息的主题
	 */
	@ApiModelProperty(value = "信息的主题")
	private String topic;
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
	 * 文件id
	 */
	@ApiModelProperty(value = "信息文件id")
	private String fileId;
	/**
	 * 文件url
	 */
	@ApiModelProperty(value = "信息文件url")
	private String fileUrl;
	/**
	 * 文件名称
	 */
	@ApiModelProperty(value = "信息文件名称")
	private String fileName;
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
}
