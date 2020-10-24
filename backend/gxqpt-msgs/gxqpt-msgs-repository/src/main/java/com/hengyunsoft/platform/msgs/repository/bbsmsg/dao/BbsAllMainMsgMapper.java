package com.hengyunsoft.platform.msgs.repository.bbsmsg.dao;

import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsAllMsgResDO;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsMsgDetailResDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbsAllMainMsgMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllMainMsg, com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllMainMsgExample> {
    List<BbsAllMsgResDO> getAllMsg(Long userId);

    List<BbsAllMsgResDO> getReadMsg(Long userId);

    List<BbsAllMsgResDO> getAllNotHandleMsg(Long userId);

    BbsMsgDetailResDO getDetailById(Long msgId);

    BbsMsgDetailResDO getRecentMsgAndNotReadNum(Long userId);
}