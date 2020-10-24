package com.hengyunsoft.platform.msgs.entity.msgsmessage.dos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BlackListDeleteDO {
	@ApiModelProperty(value = "应用程序Id")
    private String appId;
	@ApiModelProperty(value = "用户Id")
    private Long userId;
	@ApiModelProperty(value = "渠道Id")
    private Long channelId;
}
