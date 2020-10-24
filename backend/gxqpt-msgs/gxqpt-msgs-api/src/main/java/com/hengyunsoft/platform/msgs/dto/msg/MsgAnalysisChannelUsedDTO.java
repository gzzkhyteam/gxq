package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgAnalysisChannelUsedDTO", description = "个人渠道使用情况")
public class MsgAnalysisChannelUsedDTO {
	@ApiModelProperty(value = "渠道名称")
	private String channelName;
	@ApiModelProperty(value = "自己使用数量")
	private Integer personalUsed;
	@ApiModelProperty(value = "授权使用数量")
	private Integer authorizeUsed;
}
