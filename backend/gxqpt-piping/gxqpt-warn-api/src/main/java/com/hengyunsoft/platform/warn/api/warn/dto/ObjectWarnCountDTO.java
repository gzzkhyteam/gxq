package com.hengyunsoft.platform.warn.api.warn.dto;

import lombok.Data;

@Data
public class ObjectWarnCountDTO {
	private String objectId;
	private String objectName;	
	private Integer count;
	private String tag;
	private String confirmCostTime;
	private String handleCostTime;
}
