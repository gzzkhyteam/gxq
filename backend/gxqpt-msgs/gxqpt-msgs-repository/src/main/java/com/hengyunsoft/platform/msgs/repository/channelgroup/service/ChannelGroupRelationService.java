package com.hengyunsoft.platform.msgs.repository.channelgroup.service;

import java.util.List;
import java.util.Set;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.ChannelGroupRelation;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.ChannelNamesDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.ChannelGroupRelationExample;

public interface ChannelGroupRelationService extends BaseAllService<Long , ChannelGroupRelation, ChannelGroupRelationExample>{

	/**
	 * 获取渠道群组包含渠道名称
	 * @param set
	 * @return
	 */
	List<ChannelNamesDO> getChannelNames(Set<Long> set);
    /**
     * 删除渠道群组
     * @param id
     * @return
     */
	void deleteByGroupId(Long id);
	/**
	 * 获取群组包含子渠道
	 * @return
	 */
	List<MsgsChannel> getByGroupId(Long id);
    /**
     * 根据渠道id删除渠道群组关系
     * @param id
     * @return
     */
	void deleteByChannelId(Long id);
}
