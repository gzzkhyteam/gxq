package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BlackListDeleteDTO {
	@ApiModelProperty(value = "应用程序Id")
    private String appId;
	@ApiModelProperty(value = "用户Id")
    private Long userId;
	@ApiModelProperty(value = "渠道Id")
    private Long channelId;
}
