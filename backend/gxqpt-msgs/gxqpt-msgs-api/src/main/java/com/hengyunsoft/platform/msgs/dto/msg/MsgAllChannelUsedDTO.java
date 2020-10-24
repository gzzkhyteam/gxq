package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "MsgAllChannelUsedDTO", description = "高新区渠道使用情况")
public class MsgAllChannelUsedDTO {
	@ApiModelProperty(value = "年份")
	private String year;
	@ApiModelProperty(value = "月份")
	private String month;
	@ApiModelProperty(value = "使用数量")
	private Integer count;
}
