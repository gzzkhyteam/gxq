package com.hengyunsoft.platform.sms.entity.template.dos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PublisherPullblackDO {
	//应用程序id
	@ApiModelProperty(value = "取消标识0=拉黑，1=取消拉黑")
	private Integer cancel;
	//应用程序id
	@ApiModelProperty(value = "应用程序id")
	private String appId;
	//用户id
	@ApiModelProperty(value = "用户id")
	private Long userId;
	//创建人id
	@ApiModelProperty(value = "创建人id")
	private Long createUser;
}
