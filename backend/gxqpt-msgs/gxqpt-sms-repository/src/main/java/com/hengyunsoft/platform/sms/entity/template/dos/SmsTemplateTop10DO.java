package com.hengyunsoft.platform.sms.entity.template.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SmsTemplateTop10DTO", description = "模板使用对象")
public class SmsTemplateTop10DO {
	@ApiModelProperty(value = "模板名称")
	private String name;
	@ApiModelProperty(value = "模板数量")
	private Integer count;
}
