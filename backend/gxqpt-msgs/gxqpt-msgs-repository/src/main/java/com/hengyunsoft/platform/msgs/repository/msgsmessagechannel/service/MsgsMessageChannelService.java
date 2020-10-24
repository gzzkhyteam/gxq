package com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.service;

import java.util.List;
import java.util.Set;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessagechannel.po.MsgsMessageChannel;
import com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.example.MsgsMessageChannelExample;


public interface MsgsMessageChannelService  extends BaseAllService<Long, MsgsMessageChannel, MsgsMessageChannelExample>{

    public void deleteByMsgId (Long messagId);
    
    public List<MsgsMessageChannel> getByMsgId(Long msgId);
    /**
     * 根据id集合查询渠道
     * @param ids
     * @return
     */
    public List<MsgsMessageChannel> getChannelsByIds(Set<Long> ids);
}

