package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "WarnCount", description = "预警统计信息")
@SuppressWarnings("unused")
public class WarnCountDTO {
	//预警发生人名称
	private String empName;
	//预警部门名称
	private String departmentName;
	//预警应用名称
	private String appName;	
	//预警发送数量
	private Integer count;
}
