package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OpenChannelDTO", description = "渠道对象")
public class OpenChannelDTO {
	@ApiModelProperty(value = "渠道ID")
	private Long id;
	@ApiModelProperty(value = "渠道名称")
	private String name;
	@ApiModelProperty(value = "渠道类型1=微信、2=微博、4=公示平台、5=移动终端")
	private Integer channelType;
}
