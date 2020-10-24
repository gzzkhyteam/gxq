package com.hengyunsoft.platform.msgs.repository.channelgroup.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.ChannelGroupRelation;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.ChannelNamesDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.dao.ChannelGroupRelationMapper;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.ChannelGroupRelationExample;
import com.hengyunsoft.platform.msgs.repository.channelgroup.service.ChannelGroupRelationService;

@Service
public class ChannelGroupRelationServiceImpl extends BaseAllServiceImpl<Long, ChannelGroupRelation, ChannelGroupRelationExample> implements ChannelGroupRelationService{
    @Autowired
    private ChannelGroupRelationMapper channelGroupRelationMapper;
	@Override
	protected BaseNormalDao<Long, ChannelGroupRelation, ChannelGroupRelationExample> getDao() {
		return channelGroupRelationMapper;
	}
	/**
	 * 获取渠道群组包含渠道名称
	 * @param set
	 * @return
	 */
	@Override
	public List<ChannelNamesDO> getChannelNames(Set<Long> set) {
		return channelGroupRelationMapper.getChannelNames(set);
	}
    /**
     * 删除渠道群组
     * @param id
     * @return
     */
	@Override
	public void deleteByGroupId(Long id) {
		channelGroupRelationMapper.deleteByGroupId(id);
	}
	/**
	 * 获取群组包含子渠道
	 * @return
	 */
	@Override
	public List<MsgsChannel> getByGroupId(Long id) {
		return channelGroupRelationMapper.getByGroupId(id);
	}
    /**
     * 根据渠道id删除渠道群组关系
     * @param id
     * @return
     */
	@Override
	public void deleteByChannelId(Long id) {
		channelGroupRelationMapper.deleteByChannelId(id);
	}

}
