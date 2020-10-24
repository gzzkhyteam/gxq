package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OpenMsgsPageDTO", description = "信息分页列表对象")
public class OpenMsgsPageDTO {
	@ApiModelProperty(value = "消息id")
	private Long id;
	@ApiModelProperty(value = "渠道名称")
	private String channelSum;
	@ApiModelProperty(value = "信息标题")
	private String title;
	@ApiModelProperty(value = "信息发送时间")
	private Date sendJobTime;
}
