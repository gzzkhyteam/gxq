package com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessagechannel.po.MsgsMessageChannel;
import com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.dao.MsgsMessageChannelMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.example.MsgsMessageChannelExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.service.MsgsMessageChannelService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//消息关联渠道表
@Service
public class MsgsMessageChannelServiceImpl extends BaseAllServiceImpl<Long, MsgsMessageChannel, MsgsMessageChannelExample>
        implements MsgsMessageChannelService {

    @Autowired
    private MsgsMessageChannelMapper msgsMessageChannelMapper;

    @Override
    protected BaseNormalDao<Long,  MsgsMessageChannel, MsgsMessageChannelExample> getDao(){
        return msgsMessageChannelMapper;
    }

    @Override
    public void deleteByMsgId(Long messagId) {
        msgsMessageChannelMapper.deleteByMsgId(messagId);
    }

	@Override
	public List<MsgsMessageChannel> getByMsgId(Long msgId) {
		return msgsMessageChannelMapper.getByMsgId(msgId);
	}

	@Override
	public List<MsgsMessageChannel> getChannelsByIds(Set<Long> ids) {
		return msgsMessageChannelMapper.getChannelsByIds(ids);
	}
}


