package com.hengyunsoft.platform.msgs.repository.bbsmsg.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.UpdateBacklogDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllReceiveMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllReceiveMsgExample;

public interface BbsAllReceiveMsgService extends BaseAllService<Long, BbsAllReceiveMsg, BbsAllReceiveMsgExample> {


    void updateBacklog(UpdateBacklogDO updateBacklogDO);
}
