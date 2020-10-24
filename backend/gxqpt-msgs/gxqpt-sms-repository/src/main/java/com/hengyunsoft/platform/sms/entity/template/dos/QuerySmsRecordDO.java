package com.hengyunsoft.platform.sms.entity.template.dos;

import lombok.Data;

import java.util.Date;

@Data
public class QuerySmsRecordDO{

	//渠道id
	private String channelId;

	//短信主题
	private String topic;

	//是否为草稿 0=发送；1=草稿；
	private int draft = 0;

	//查询起始时间
	private Date startTime;

	//查询终止时间
	private Date endTime;

	//查询终止时间
	private String sourceType;

	//发送人
	private String sender;

	//发送相关应用
	private String appId;

}
