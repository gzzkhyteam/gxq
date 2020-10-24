package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgChannelTypeDTO", description = "渠道类型参数")
public class MsgChannelTypeDTO {
	/**
	 * 渠道类型名称
	 */
	@ApiModelProperty(value = "渠道类型名称")
	private String name;
	/**
	 * 渠道子集
	 */
	@ApiModelProperty(value = "渠道子集")
	private List<MsgChannelTypeChaildDTO> chaild;
}
