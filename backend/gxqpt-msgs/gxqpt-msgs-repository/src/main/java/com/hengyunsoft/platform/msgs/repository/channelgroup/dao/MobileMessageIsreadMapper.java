package com.hengyunsoft.platform.msgs.repository.channelgroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageIsread;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MobileReadCheckDO;

@Repository
public interface MobileMessageIsreadMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageIsread, com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageIsreadExample> {
	Integer getReadNumByUserId(@Param(value="userId")Long userId);
	/**
	 * 根据用户id和消息id获取信息
	 * @return
	 */
	List<MobileMessageIsread> getByUserIdAndMsgId(@Param(value="mobileReadCheckDTO")MobileReadCheckDO mobileReadCheckDTO);
}