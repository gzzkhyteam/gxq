package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ChannelGroupDetailDTO", description = "渠道群组详情对象")
public class ChannelGroupDetailDTO {
	@ApiModelProperty(value = "渠道群组名称")
	private String name;
	@ApiModelProperty(value = "渠道群组包含渠道名称")
	private List<MsgChannelChildTreeDTO> channels;
	@ApiModelProperty(value = "渠道群组说明")
	private String explain;
}
