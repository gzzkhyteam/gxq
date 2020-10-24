package com.hengyunsoft.platform.msgs.repository.attachment.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.attachment.po.MsgsAttachment;

@Repository
public interface MsgsAttachmentMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.attachment.po.MsgsAttachment, com.hengyunsoft.platform.msgs.repository.attachment.example.MsgsAttachmentExample> {

	public void deleteByMsgId(@Param(value="msgId")Long msgId);
	
	public MsgsAttachment getByMsgId(@Param(value="msgId")Long msgId);
}