package com.hengyunsoft.platform.sms.entity.template.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SmsRequestDO", description = "短信请求参数")
public class SmsRequestDO {
	@ApiModelProperty(value = "已发送条数")
	private Long userId;
	@ApiModelProperty(value = "来源类型APP=应用，MODULAR=模块，SERVICE=服务")
	private String sourceType;
}
