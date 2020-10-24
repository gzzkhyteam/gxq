package com.hengyunsoft.platform.sms.entity.template.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SmsMonthAcountDO", description = "近一年短信统计")
public class SmsYearAcountDO {
	@ApiModelProperty(value = "年份")
	private String year;
	@ApiModelProperty(value = "月份")
	private String month;
	@ApiModelProperty(value = "使用量")
	private Integer count;
}
