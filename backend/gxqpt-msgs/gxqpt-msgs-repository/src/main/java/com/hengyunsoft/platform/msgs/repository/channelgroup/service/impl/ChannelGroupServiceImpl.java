package com.hengyunsoft.platform.msgs.repository.channelgroup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.ChannelGroup;
import com.hengyunsoft.platform.msgs.repository.channelgroup.dao.ChannelGroupMapper;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.ChannelGroupExample;
import com.hengyunsoft.platform.msgs.repository.channelgroup.service.ChannelGroupService;
@Service
public class ChannelGroupServiceImpl extends BaseAllServiceImpl<Long, ChannelGroup, ChannelGroupExample> implements ChannelGroupService{
    @Autowired
    private ChannelGroupMapper channelGroupTypeMapper;
	@Override
	protected BaseNormalDao<Long, ChannelGroup, ChannelGroupExample> getDao() {
		return channelGroupTypeMapper;
	}

}
