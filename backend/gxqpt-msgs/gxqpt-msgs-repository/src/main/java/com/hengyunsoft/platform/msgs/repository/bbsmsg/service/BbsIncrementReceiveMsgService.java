package com.hengyunsoft.platform.msgs.repository.bbsmsg.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementReceiveMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsIncrementReceiveMsgExample;

public interface BbsIncrementReceiveMsgService extends BaseAllService<Long, BbsIncrementReceiveMsg, BbsIncrementReceiveMsgExample> {


    void saveBrim(BbsIncrementReceiveMsg birm);
}
