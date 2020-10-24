package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageIsread;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MobileReadCheckDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageIsreadExample;

public interface MobileMessageIsreadService extends BaseAllService<Long, MobileMessageIsread, MobileMessageIsreadExample>{

	/**
	 * 根据用户id获取未读数量
	 * @param userId
	 * @return
	 */
	Integer getReadNumByUserId(Long userId);
	/**
	 * 根据用户id和消息id获取信息
	 * @return
	 */
	List<MobileMessageIsread> getByUserIdAndMsgId(MobileReadCheckDO mobileReadCheckDO);
}
