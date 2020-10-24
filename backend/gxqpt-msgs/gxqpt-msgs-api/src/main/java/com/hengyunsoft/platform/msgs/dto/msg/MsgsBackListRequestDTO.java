package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsBackListRequestDTO", description = "黑名单请求对象")
public class MsgsBackListRequestDTO {
	@ApiModelProperty(value = "发布商名称")
	private String name;
	@ApiModelProperty(value = "所属单位")
	private String company;
	@ApiModelProperty(value = "状态")
	private String status;
	@ApiModelProperty(value = "渠道id")
	private Long channelId;
}
