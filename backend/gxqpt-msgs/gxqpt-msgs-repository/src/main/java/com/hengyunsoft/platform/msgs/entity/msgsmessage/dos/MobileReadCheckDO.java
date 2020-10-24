package com.hengyunsoft.platform.msgs.entity.msgsmessage.dos;

import java.util.Set;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@Data
@ApiModel(value = "MobileReadCheckDO", description = "移动终端未读消息")
public class MobileReadCheckDO {

	private Long userId;
	
	private Set<Long> ids;
}
