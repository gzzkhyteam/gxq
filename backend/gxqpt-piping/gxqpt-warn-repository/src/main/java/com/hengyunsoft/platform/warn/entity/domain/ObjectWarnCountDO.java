package com.hengyunsoft.platform.warn.entity.domain;

import lombok.Data;

@Data
public class ObjectWarnCountDO {
	private String objectId;
	private String objectName;	
	private Integer count;
	private String tag;
	private String confirmCostTime;
	private String handleCostTime;
}
