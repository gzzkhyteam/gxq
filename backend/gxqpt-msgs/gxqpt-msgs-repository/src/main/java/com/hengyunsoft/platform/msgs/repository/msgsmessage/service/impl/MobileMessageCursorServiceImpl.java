package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageCursor;
import com.hengyunsoft.platform.msgs.repository.channelgroup.dao.MobileMessageCursorMapper;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageCursorExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageCursorService;
@Service
public class MobileMessageCursorServiceImpl extends BaseAllServiceImpl<Long, MobileMessageCursor, MobileMessageCursorExample> implements MobileMessageCursorService{
	@Autowired
	private MobileMessageCursorMapper mobileMessageCursorMapper;
	
	@Override
	protected BaseNormalDao<Long, MobileMessageCursor, MobileMessageCursorExample> getDao() {
		return mobileMessageCursorMapper;
	}

	@Override
	public List<MobileMessageCursor> getAll() {
		return mobileMessageCursorMapper.getAll();
	}

}
