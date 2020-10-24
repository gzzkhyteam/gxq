package com.hengyunsoft.platform.msgs.repository.bbsmsg.dao;

import com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo.UpdateBacklogDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsAllReceiveMsgMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllReceiveMsg, com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsAllReceiveMsgExample> {
    void updateBacklog(@Param("updateBacklogDO") UpdateBacklogDO updateBacklogDO);
}