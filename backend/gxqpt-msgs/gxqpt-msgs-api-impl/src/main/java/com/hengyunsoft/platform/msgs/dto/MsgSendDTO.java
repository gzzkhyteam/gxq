package com.hengyunsoft.platform.msgs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgSend", description = "消息发送结果对象")
public class MsgSendDTO {

	/**
	 * 返回结果数据
	 */
	@ApiModelProperty(value = "返回结果数据")	
	private String date;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
}
