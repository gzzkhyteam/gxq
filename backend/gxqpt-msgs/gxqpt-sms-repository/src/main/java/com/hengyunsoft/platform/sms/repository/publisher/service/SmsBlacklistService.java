package com.hengyunsoft.platform.sms.repository.publisher.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.sms.entity.publisher.po.SmsBlacklist;
import com.hengyunsoft.platform.sms.entity.template.dos.PublisherPullblackDO;
import com.hengyunsoft.platform.sms.repository.publisher.example.SmsBlacklistExample;

public interface SmsBlacklistService extends BaseService<Long, SmsBlacklist, SmsBlacklistExample>{

	/**
	 * 取消拉黑
	 * @param publisherPullblackDTO
	 */
	void deleteByAppidAndUserId(PublisherPullblackDO publisherPullblackDTO);
}
