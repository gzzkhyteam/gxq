package com.hengyunsoft.platform.msgs.repository.msgsmessagetype.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessagetype.po.MsgsMessageType;
import com.hengyunsoft.platform.msgs.repository.msgsmessagetype.example.MsgsMessageTypeExample;

public interface MsgsMessageTypeService extends BaseAllService<Long, MsgsMessageType, MsgsMessageTypeExample> {
    public  int  deleteByMessageId(Long messagId);
}
