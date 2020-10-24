package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PublisherPullblackDTO {
	//应用程序id
	@ApiModelProperty(value = "取消标识0=拉黑，1=取消拉黑")
	private Integer cancel;
	//应用程序id
	@ApiModelProperty(value = "应用程序id")
	private String appId;
	//用户名称
	@ApiModelProperty(value = "用户名称")
	private String userName;
	//用户账号
	@ApiModelProperty(value = "用户账号")
	private String userAccount;
	//所在部门名称
	@ApiModelProperty(value = "所在部门名称")
	private String depatment;
	//用户id
	@ApiModelProperty(value = "用户id")
	private Long userId;
}
