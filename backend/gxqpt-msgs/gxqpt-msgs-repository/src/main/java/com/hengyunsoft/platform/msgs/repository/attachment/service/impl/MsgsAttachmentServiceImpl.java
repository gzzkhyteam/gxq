package com.hengyunsoft.platform.msgs.repository.attachment.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.attachment.po.MsgsAttachment;
import com.hengyunsoft.platform.msgs.repository.attachment.dao.MsgsAttachmentMapper;
import com.hengyunsoft.platform.msgs.repository.attachment.example.MsgsAttachmentExample;
import com.hengyunsoft.platform.msgs.repository.attachment.service.MsgsAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//消息附件
@Service
public class MsgsAttachmentServiceImpl extends BaseAllServiceImpl<Long, MsgsAttachment, MsgsAttachmentExample>
        implements MsgsAttachmentService {
    @Autowired
    private MsgsAttachmentMapper msgsAttachmentMapper;
    @Override
    protected BaseNormalDao<Long, MsgsAttachment, MsgsAttachmentExample> getDao() {
        return msgsAttachmentMapper;
    }
	@Override
	public void deleteByMsgId(Long msgId) {
		msgsAttachmentMapper.deleteByMsgId(msgId);
	}
	@Override
	public MsgsAttachment getByMsgId(Long msgId) {
		return msgsAttachmentMapper.getByMsgId(msgId);
	}
}
