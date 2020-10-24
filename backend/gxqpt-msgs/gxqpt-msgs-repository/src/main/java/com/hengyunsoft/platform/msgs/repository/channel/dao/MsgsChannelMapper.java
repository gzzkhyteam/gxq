package com.hengyunsoft.platform.msgs.repository.channel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.dto.ChannelMsgDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;

@Repository
public interface MsgsChannelMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long,MsgsChannel,
        com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample> {
	MsgsChannel getByAccount(@Param(value="account") String account);
	List<ChannelMsgDTO> getByChannelType(@Param(value="channelType") Integer channelType);
}