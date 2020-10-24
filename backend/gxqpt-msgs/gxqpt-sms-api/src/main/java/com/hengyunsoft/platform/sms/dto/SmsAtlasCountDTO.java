package com.hengyunsoft.platform.sms.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SmsAtlasCountDTO", description = "发送、接收图谱对象")
public class SmsAtlasCountDTO {
	@ApiModelProperty(value = "发送人集合")
	private List<TreeDTO> senderList;
	@ApiModelProperty(value = "接收主题集合")
	private List<TreeDTO> reciveTopicList;	
}
