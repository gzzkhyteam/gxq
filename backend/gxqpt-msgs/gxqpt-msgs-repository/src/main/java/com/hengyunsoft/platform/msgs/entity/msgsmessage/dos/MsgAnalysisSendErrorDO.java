package com.hengyunsoft.platform.msgs.entity.msgsmessage.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgAnalysisSendErrorDO", description = "发送统计")
public class MsgAnalysisSendErrorDO {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "数量")
	private Integer count;
}
