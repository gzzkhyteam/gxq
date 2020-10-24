package com.hengyunsoft.platform.sms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BlackListResponseDTO", description = "黑名单列表返回参数")
public class BlackListResponseDTO {

	@ApiModelProperty(value = "姓名")
	private String name;
	@ApiModelProperty(value = "登录账号")
	private String nickname;
	@ApiModelProperty(value = "部门")
	private String maindeptname;
	@ApiModelProperty(value = "状态")
	private String status;
	@ApiModelProperty(value = "用户id")
	private Long gxqptEmpId;
}
