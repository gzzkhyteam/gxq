package com.hengyunsoft.platform.msgs.repository.channel.service;

import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.dto.ChannelMsgDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;

public interface MsgsChannelService extends BaseAllService<Long, MsgsChannel, MsgsChannelExample> {
	MsgsChannel getByAccount(String account);

	List<ChannelMsgDTO> getByChannelType(Integer channelType);	
}
