package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "MsgChannelChildDTO", description = "渠道子集参数")
public class MsgChannelChildDTO {
	/**
	 * 渠道名称
	 */
	@ApiModelProperty(value = "渠道名称")
	private String name;
	/**
	 * 渠道类型
	 */
	@ApiModelProperty(value = "渠道类型")
	private String type;
}
