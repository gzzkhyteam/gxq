package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageIsread;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MobileReadCheckDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.dao.MobileMessageIsreadMapper;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageIsreadExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageIsreadService;

@Service
public class MobileMessageIsreadServiceImpl extends BaseAllServiceImpl<Long, MobileMessageIsread, MobileMessageIsreadExample> implements MobileMessageIsreadService{

	@Autowired
	private MobileMessageIsreadMapper mobileMessageIsreadMapper;
	
	@Override
	protected BaseNormalDao<Long, MobileMessageIsread, MobileMessageIsreadExample> getDao() {
		return mobileMessageIsreadMapper;
	}

	@Override
	public Integer getReadNumByUserId(Long userId) {
		return mobileMessageIsreadMapper.getReadNumByUserId(userId);
	}

	@Override
	public List<MobileMessageIsread> getByUserIdAndMsgId(MobileReadCheckDO mobileReadCheckDTO) {
		return mobileMessageIsreadMapper.getByUserIdAndMsgId(mobileReadCheckDTO);
	}

}
