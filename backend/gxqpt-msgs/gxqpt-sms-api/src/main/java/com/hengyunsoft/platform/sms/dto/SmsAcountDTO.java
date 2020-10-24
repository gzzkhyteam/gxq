package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SmsAcountDTO", description = "各短信量对象")
public class SmsAcountDTO {
	@ApiModelProperty(value = "已发送条数")
	private Integer sendNum;
	@ApiModelProperty(value = "草稿箱数量")
	private Integer draftNum;
	@ApiModelProperty(value = "模板数量")
	private Integer modleNum;
	@ApiModelProperty(value = "账号数量")
	private Integer accountNum;
}
