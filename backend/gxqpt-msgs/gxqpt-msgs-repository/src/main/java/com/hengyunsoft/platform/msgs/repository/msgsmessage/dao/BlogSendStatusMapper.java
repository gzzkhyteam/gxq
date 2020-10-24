package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendExceptionDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BlogSendStatusExample;

@Repository
public interface BlogSendStatusMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, BlogSendStatus, BlogSendStatusExample> {
	List<BlogSendStatus> getByMsgId(String msgId);
    /**
     * 各类型渠道发送问题TOP10
     * @return
     */
	List<MsgAnalysisSendErrorDO> getMsgSendErrorTop10(@Param(value="list")List<String> list);
    /**
     * 各渠道类型异常情况分析(近六个月数据)
     * @return
     */
	List<MsgAnalysisSendExceptionDO> getMsgSendExceptionCount(@Param(value="userId")Long userId);
}