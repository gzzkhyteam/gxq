package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ChannelGroupSaveDTO", description = "渠道群组对象")
public class ChannelGroupSaveDTO {
	@ApiModelProperty(value = "渠道群组Id,更新时候传")
	private Long id;
	@ApiModelProperty(value = "渠道群组名称")
	private String name;
	@ApiModelProperty(value = "渠道id")
	private List<Long> channelIds;
	@ApiModelProperty(value = "渠道群组说明")
	private String explain;
}
