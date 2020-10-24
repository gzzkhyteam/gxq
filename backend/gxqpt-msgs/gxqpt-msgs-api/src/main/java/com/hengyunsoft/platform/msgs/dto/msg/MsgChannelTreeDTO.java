package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgChannelTreeDTO", description = "渠道树参数")
public class MsgChannelTreeDTO {
	/**
	 * 渠道id
	 */
	@ApiModelProperty(value = "渠道id")
	private int id;
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
	/**
	 * 渠道子集
	 */
	@ApiModelProperty(value = "渠道子集")
	private List<MsgChannelChildTreeDTO> children;

}
