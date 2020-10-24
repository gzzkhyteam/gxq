package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PublisherBlackListDTO {
	//应用程序id
	@ApiModelProperty(value = "取消标识0=拉黑，1=取消拉黑")
	private Integer cancel;
	//应用程序id
	@ApiModelProperty(value = "应用程序id")
	private String appId;
	//渠道id
	@ApiModelProperty(value = "渠道id")
	private Long channelId;
}
