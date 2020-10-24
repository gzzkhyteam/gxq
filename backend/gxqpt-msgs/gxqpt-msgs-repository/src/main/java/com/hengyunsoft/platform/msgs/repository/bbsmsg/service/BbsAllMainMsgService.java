package com.hengyunsoft.platform.msgs.repository.bbsmsg.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsAllMsgResDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsMsgDetailResDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllMainMsg;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllMainMsgExample;

import java.util.List;

public interface BbsAllMainMsgService extends BaseAllService<Long, BbsAllMainMsg, BbsAllMainMsgExample> {

    List<BbsAllMsgResDO> getAllMsg(Long userId);

    List<BbsAllMsgResDO> getReadMsg(Long userId);

    List<BbsAllMsgResDO> getAllNotHandleMsg(Long userId);

    BbsMsgDetailResDO getDetailById(Long msgId);

    BbsMsgDetailResDO getRecentMsgAndNotReadNum(Long userId);
}
