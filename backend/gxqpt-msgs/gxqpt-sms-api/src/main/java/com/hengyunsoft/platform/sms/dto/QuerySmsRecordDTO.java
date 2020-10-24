package com.hengyunsoft.platform.sms.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class QuerySmsRecordDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	//渠道id
	@ApiModelProperty(value = "发送渠道id")
	private String channelId;
	//短信主题
	@ApiModelProperty(value = "短信主题")
	private String topic;
	//是否为草稿 0=发送；1=草稿； 
	@ApiModelProperty(value = "是否为草稿 0=已发送；1=草稿；")
	private int draft = 0;
	//查询起始时间
	@ApiModelProperty(value = "查询起始时间")
	private Date startTime;
	//查询终止时间
	@ApiModelProperty(value = "查询终止时间")
	private Date endTime;
	//查询终止时间
	@ApiModelProperty(value = "来源类型APP=应用，SERVICE=服务，MODULAR=模块")
	private String sourceType;	
}
