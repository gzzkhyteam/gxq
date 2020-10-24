package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "ChannelGroupDetailBackDTO", description = "渠道群组详情返回对象")
public class ChannelGroupDetailBackDTO {
	@ApiModelProperty(value = "渠道群组名称")
	private String name;
	@ApiModelProperty(value = "渠道群组包含渠道名称")
	private List<MsgChannelChildDTO> channels;
	@ApiModelProperty(value = "渠道群组说明")
	private String explain;
}
