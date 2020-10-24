package com.hengyunsoft.platform.msgs.repository.attachment.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.attachment.po.MsgsAttachment;
import com.hengyunsoft.platform.msgs.repository.attachment.example.MsgsAttachmentExample;

//消息附件
public interface MsgsAttachmentService extends BaseAllService<Long, MsgsAttachment, MsgsAttachmentExample> {

	public void deleteByMsgId(Long msgId);
	
	public MsgsAttachment getByMsgId(Long msgId);
}
