package com.hengyunsoft.platform.sms.repository.publisher.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.sms.entity.template.dos.PublisherPullblackDO;

@Repository
public interface SmsBlacklistMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.sms.entity.publisher.po.SmsBlacklist, com.hengyunsoft.platform.sms.repository.publisher.example.SmsBlacklistExample> {
	/**
	 * 取消拉黑
	 * @param publisherPullblackDTO
	 */
	void deleteByAppidAndUserId(@Param(value="publisherPullblackDTO") PublisherPullblackDO publisherPullblackDTO);
}