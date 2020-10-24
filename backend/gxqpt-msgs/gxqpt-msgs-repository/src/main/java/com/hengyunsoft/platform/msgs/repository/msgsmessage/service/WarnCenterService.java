package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WarnCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WarnCenterExample;

public interface WarnCenterService extends BaseAllService<Long, WarnCenter, WarnCenterExample>{

	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(Long reciverId);
}
