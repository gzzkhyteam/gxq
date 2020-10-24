package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendExceptionDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.BlogSendStatusMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BlogSendStatusExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogSendStatusService;

@Service
public class BlogSendStatusServiceImpl extends BaseAllServiceImpl<Long, BlogSendStatus, BlogSendStatusExample> implements BlogSendStatusService{
	@Autowired
	private BlogSendStatusMapper blogSendStatusMapper;

	@Override
	protected BaseNormalDao<Long, BlogSendStatus, BlogSendStatusExample> getDao() {
		return blogSendStatusMapper;
	}
	@Override
	public List<BlogSendStatus> getByMsgId(String msgId){
		return blogSendStatusMapper.getByMsgId(msgId);
	}
    /**
     * 各类型渠道发送问题TOP10
     * @return
     */
	@Override
	public List<MsgAnalysisSendErrorDO> getMsgSendErrorTop10(List<String> list) {
		return blogSendStatusMapper.getMsgSendErrorTop10(list);
	}
    /**
     * 各渠道类型异常情况分析(近六个月数据)
     * @return
     */
	@Override
	public List<MsgAnalysisSendExceptionDO> getMsgSendExceptionCount(Long userId) {
		return blogSendStatusMapper.getMsgSendExceptionCount(userId);
	}
}
