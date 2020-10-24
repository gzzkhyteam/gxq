package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgDetailDTO", description = "消息详情对象")
public class MsgDetailDTO {
	@ApiModelProperty(value = "信息ID")
	private Long msgId;
	@ApiModelProperty(value = "信息主题")
	private String title;	
	@ApiModelProperty(value = "发送情况")
	private List<MsgChannelTypeDTO> status;
	@ApiModelProperty(value = "发送成功数量")	
	private String successNum;
	@ApiModelProperty(value = "发送失败数量")	
	private String failNum;
	@ApiModelProperty(value = "信息发送时间")	
	private String sendTime;
	@ApiModelProperty(value = "附件id")	
	private String fileId;
	@ApiModelProperty(value = "附件地址")	
	private String fileUrl;
	@ApiModelProperty(value = "附件名称")	
	private String fileName;
	@ApiModelProperty(value = "信息内容")	
	private String content;	
	@ApiModelProperty(value = "渠道，草稿的时候返回")	
	private List<MsgChannelChildTreeDTO> channels;	
}
