package com.hengyunsoft.platform.msgs.dto.msg;

import java.util.Set;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@Data
@ApiModel(value = "MobileReadCheckDTO", description = "移动终端未读消息")
public class MobileReadCheckDTO {

	private Long userId;
	
	private Set<Long> ids;
}
