package com.hengyunsoft.platform.msgs.repository.msgsmessage.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.BlackListDeleteDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample;

public interface MsgsBlacklistService extends BaseAllService<Long, MsgsBlacklist, MsgsBlacklistExample>{

	void deleteByAppId(BlackListDeleteDO blackListDeleteDO);
}
