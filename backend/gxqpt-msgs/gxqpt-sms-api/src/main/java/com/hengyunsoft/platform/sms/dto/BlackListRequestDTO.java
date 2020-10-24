package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BlackListRequestDTO", description = "黑名单列表请求参数")
public class BlackListRequestDTO {
	@ApiModelProperty(value = "应用程序")
	private String appId;
	@ApiModelProperty(value = "姓名")
	private String name;
	@ApiModelProperty(value = "部门")
	private String demp;
	@ApiModelProperty(value = "状态，0：全部，1：已拉黑")
	private String status;
}
