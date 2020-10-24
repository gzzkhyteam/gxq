package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgAnalysisSendErrorDTO", description = "发送统计")
public class MsgAnalysisSendErrorDTO {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "数量")
	private Integer count;
}
