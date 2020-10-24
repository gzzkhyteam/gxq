package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BulletinCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.BulletinCenterMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BulletinCenterExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BulletinCenterService;
@Service
public class BulletinCenterServiceImpl extends BaseAllServiceImpl<Long, BulletinCenter, BulletinCenterExample> implements BulletinCenterService{

	@Autowired
	private BulletinCenterMapper bulletinCenterMapper;
	@Override
	protected BaseNormalDao<Long, BulletinCenter, BulletinCenterExample> getDao() {		
		return bulletinCenterMapper;
	}
	@Override
	public Integer getAllCount(Long reciverId) {		
		return bulletinCenterMapper.getAllCount(reciverId);
	}
}
