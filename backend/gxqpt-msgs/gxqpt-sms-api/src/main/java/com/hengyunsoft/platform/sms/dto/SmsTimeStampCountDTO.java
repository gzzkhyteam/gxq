package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SmsTimeStampCountDTO", description = "短信时间分析对象")
public class SmsTimeStampCountDTO {
	@ApiModelProperty(value = "年份")
	private String year;
	@ApiModelProperty(value = "月份")
	private String month;
	@ApiModelProperty(value = "周")
	private String week;
	@ApiModelProperty(value = "日期")
	private String day;	
	@ApiModelProperty(value = "短信数量")
	private Integer count;
}
