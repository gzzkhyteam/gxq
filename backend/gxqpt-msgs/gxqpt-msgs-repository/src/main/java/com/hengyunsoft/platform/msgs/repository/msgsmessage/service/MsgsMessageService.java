package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessageQueryDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.ChannelByAnalysis;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessageMerge;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsMessageExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsMessageQueryParam;

public interface MsgsMessageService extends BaseAllService<Long, MsgsMessage, MsgsMessageExample> {
    public List<MsgsMessageMerge> queryMsgsMergeChannel(MsgsMessageQueryParam msgsMessageQueryParam);
    //非空字段 更改
    public int updateMessageById(MsgsMessage msgsMessage);
    //渠道平台消息量分析
    public List<ChannelByAnalysis> getCountToChannelType(Date startDate, Date endDate);
    //修改草稿状态
    public void updateStatusById(Long id);
    /**
     * 获取信息列表
     * @param msgsMessageQueryDTO
     * @return
     */
    List<MsgsListDO> getMsgsList(MsgsMessageQueryDO messageQueryDO);
}
