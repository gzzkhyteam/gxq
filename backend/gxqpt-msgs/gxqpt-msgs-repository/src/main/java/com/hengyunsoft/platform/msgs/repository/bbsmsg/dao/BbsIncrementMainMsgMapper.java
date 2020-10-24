package com.hengyunsoft.platform.msgs.repository.bbsmsg.dao;

import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.BbsNotReadMsgResDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbsIncrementMainMsgMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementMainMsg, com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsIncrementMainMsgExample> {
    List<BbsNotReadMsgResDO> getAllNotReadMsg(Long userId);

    List<BbsNotReadMsgResDO> getNeedHandleNotReadMsg(Long userId);

    List<BbsNotReadMsgResDO> getCommonNotReadMsg(Long userId);
}