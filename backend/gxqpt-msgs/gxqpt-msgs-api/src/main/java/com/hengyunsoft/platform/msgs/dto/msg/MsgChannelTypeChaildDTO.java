package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgChannelTypeChaildDTO", description = "渠道子集参数")
public class MsgChannelTypeChaildDTO {
	/**
	 * 渠道名称
	 */
	@ApiModelProperty(value = "渠道类型名称")
	private String name;
	/**
	 * 发送结果状态
	 */
	@ApiModelProperty(value = "发送结果状态")
	private String status;
}
