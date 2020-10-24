package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BulletinCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BulletinCenterExample;

public interface BulletinCenterService extends BaseAllService<Long, BulletinCenter, BulletinCenterExample>{
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(Long reciverId);
}
