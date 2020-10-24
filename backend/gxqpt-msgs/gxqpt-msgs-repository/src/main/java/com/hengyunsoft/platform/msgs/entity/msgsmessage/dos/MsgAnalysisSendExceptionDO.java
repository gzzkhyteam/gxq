package com.hengyunsoft.platform.msgs.entity.msgsmessage.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgAnalysisSendExceptionDO", description = "发送异常统计")
public class MsgAnalysisSendExceptionDO {
	@ApiModelProperty(value = "年份")
	private String year;
	@ApiModelProperty(value = "月份")
	private String month;
	@ApiModelProperty(value = "数量")
	private Integer count;
}
