package com.hengyunsoft.platform.msgs.repository.bbsmsg.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsNotReadMsgResDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementMainMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsIncrementMainMsgExample;

import java.util.List;

public interface BbsIncrementMainMsgService extends BaseAllService<Long, BbsIncrementMainMsg, BbsIncrementMainMsgExample> {

    List<BbsNotReadMsgResDO> getAllNotReadMsg(Long userId);

    List<BbsNotReadMsgResDO> getNeedHandleNotReadMsg(Long userId);

    List<BbsNotReadMsgResDO> getCommonNotReadMsg(Long userId);

    void saveBimm(BbsIncrementMainMsg bimm);
}
