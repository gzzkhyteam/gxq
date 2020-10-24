package com.hengyunsoft.platform.sms.repository.template.service;

import java.util.List;
import java.util.Set;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.sms.entity.template.dos.AppointDeleteAppDO;
import com.hengyunsoft.platform.sms.entity.template.dos.AppsDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsChannelOwner;
import com.hengyunsoft.platform.sms.repository.template.example.SmsChannelOwnerExample;

public interface SmsChannelOwnerService extends BaseService<Long, SmsChannelOwner, SmsChannelOwnerExample>{
	List<AppsDO> getAppList(Set<Long> channelNames);
	
	void deleteByAccountAndAppids(AppointDeleteAppDO appointDeleteAppDTO);

    /**
     * 账号管理名称修改后名称联查
     * @param owner
     * @return
     */
    List<SmsChannelOwner> getOwnerChannerl(SmsChannelOwner owner);
}
