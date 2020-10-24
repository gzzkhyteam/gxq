package com.hengyunsoft.platform.sms.entity.template.dos;

import java.io.Serializable;

import lombok.Data;
@Data
public class QuerySmsTemplateDO implements Serializable{
	private static final long serialVersionUID = 1L;
	//渠道id
	private String channelId;
	//渠道id
	private String userId;
	//模板名称
	private String name;	
	//模板编码 ：第三方申请的模板id
	private String templateCode;
	//查询起始时间
	private String startTime;
	//查询终止时间
	private String endTime;
}
