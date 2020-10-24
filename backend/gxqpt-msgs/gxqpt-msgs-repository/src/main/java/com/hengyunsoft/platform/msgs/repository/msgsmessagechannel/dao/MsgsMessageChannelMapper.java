package com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessagechannel.po.MsgsMessageChannel;

@Repository
public interface MsgsMessageChannelMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.msgsmessagechannel.po.MsgsMessageChannel, com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.example.MsgsMessageChannelExample> {
  
	public void deleteByMsgId (@Param(value = "msgId") Long msgId);
	
	public List<MsgsMessageChannel> getByMsgId(@Param(value = "msgId")Long msgId);
    /**
     * 根据id集合查询渠道
     * @param ids
     * @return
     */
    public List<MsgsMessageChannel> getChannelsByIds(@Param(value = "ids")Set<Long> ids);
}