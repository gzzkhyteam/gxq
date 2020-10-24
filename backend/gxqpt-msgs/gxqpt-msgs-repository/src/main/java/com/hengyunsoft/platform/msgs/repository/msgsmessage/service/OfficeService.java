package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.Office;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.OfficeExample;

public interface OfficeService extends BaseAllService<Long, Office, OfficeExample>{
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(Long reciverId);
}
