package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgAnalysisChannelTypeDTO", description = "渠道类型使用情况")
public class MsgAnalysisChannelTypeDTO {
	@ApiModelProperty(value = "微信数量")
	private Integer wechat;
	@ApiModelProperty(value = "微博数量")
	private Integer blog;
	@ApiModelProperty(value = "公示平台数量")
	private Integer publicSys;
	@ApiModelProperty(value = "移动终端数量")
	private Integer mobile;
}
