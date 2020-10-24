package com.hengyunsoft.platform.msgs.repository.channel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.dto.ChannelMsgDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.repository.channel.dao.MsgsChannelMapper;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;

@Service
public class MsgsChannelServiceImpl extends BaseAllServiceImpl<Long, MsgsChannel, MsgsChannelExample>
        implements MsgsChannelService {
    @Autowired
    private MsgsChannelMapper msgsChannelMapper;

    @Override
    protected BaseNormalDao<Long, MsgsChannel, MsgsChannelExample> getDao() {
        return msgsChannelMapper;
    }

	@Override
	public MsgsChannel getByAccount(String account) {		
		return msgsChannelMapper.getByAccount(account);
	}

	@Override
	public List<ChannelMsgDTO> getByChannelType(Integer channelType) {
		return msgsChannelMapper.getByChannelType(channelType);
	}

}
