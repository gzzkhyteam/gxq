package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendErrorDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgAnalysisSendExceptionDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WechatSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.WechatSendStatusMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WechatSendStatusExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WechatSendStatusService;
@Service
public class WechatSendStatusServiceImpl extends BaseAllServiceImpl<Long, WechatSendStatus, WechatSendStatusExample> implements WechatSendStatusService{
	@Autowired
	private WechatSendStatusMapper wechatSendStatusMapper;

	@Override
	protected BaseNormalDao<Long, WechatSendStatus, WechatSendStatusExample> getDao() {
		return wechatSendStatusMapper;
	}
	@Override
	public List<WechatSendStatus> getByMsgId(String msgId){
		return wechatSendStatusMapper.getByMsgId(msgId);
	}
    /**
     * 各类型渠道发送问题TOP10
     * @return
     */
	@Override
	public List<MsgAnalysisSendErrorDO> getMsgSendErrorTop10(List<String> list) {
		return wechatSendStatusMapper.getMsgSendErrorTop10(list);
	}
    /**
     * 各渠道类型异常情况分析(近六个月数据)
     * @return
     */
	@Override
	public List<MsgAnalysisSendExceptionDO> getMsgSendExceptionCount(Long userId) {
		return wechatSendStatusMapper.getMsgSendExceptionCount(userId);
	}
}
