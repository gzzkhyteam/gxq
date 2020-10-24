package com.hengyunsoft.platform.msgs.repository.msgsmessagetype.dao;

import com.hengyunsoft.platform.msgs.repository.msgsmessagetype.example.MsgsMessageTypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgsMessageTypeMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.msgsmessagetype.po.MsgsMessageType, com.hengyunsoft.platform.msgs.repository.msgsmessagetype.example.MsgsMessageTypeExample> {

    public  int  deleteByMessageId(@Param(value = "messageId") Long messagId);
}