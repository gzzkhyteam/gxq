package com.hengyunsoft.platform.msgs.repository.channelgroup.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.ChannelNamesDO;

@Repository
public interface ChannelGroupRelationMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.channelgroup.po.ChannelGroupRelation, com.hengyunsoft.platform.msgs.repository.channelgroup.example.ChannelGroupRelationExample> {
	/**
	 * 获取渠道群组包含渠道名称
	 * @param set
	 * @return
	 */
	List<ChannelNamesDO> getChannelNames(@Param(value="set")Set<Long> set);
    /**
     * 删除渠道群组
     * @param id
     * @return
     */
	void deleteByGroupId(@Param(value="id")Long id);
	/**
	 * 获取群组包含子渠道
	 * @return
	 */
	List<MsgsChannel> getByGroupId(@Param(value="id")Long id);
    /**
     * 根据渠道id删除渠道群组关系
     * @param id
     * @return
     */
	void deleteByChannelId(@Param(value="id")Long id);
}