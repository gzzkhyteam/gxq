package com.hengyunsoft.platform.sms.entity.template.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SmsMonthAcountDO", description = "近一个月短信统计")
public class SmsMonthAcountDO {
	@ApiModelProperty(value = "年份")
	private String year;
	@ApiModelProperty(value = "月份")
	private String month;
	@ApiModelProperty(value = "日期")
	private String day;
	@ApiModelProperty(value = "发送成功数量")
	private Integer success;
	@ApiModelProperty(value = "发送失败数量")
	private Integer fail;
}
