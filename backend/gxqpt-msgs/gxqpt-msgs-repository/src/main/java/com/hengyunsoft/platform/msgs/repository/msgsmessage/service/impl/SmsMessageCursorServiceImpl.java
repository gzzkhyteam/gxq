package com.hengyunsoft.platform.msgs.repository.msgsmessage.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsMessageCursor;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.SmsMessageCursorMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.SmsMessageCursorExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsMessageCursorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsMessageCursorServiceImpl extends BaseAllServiceImpl<Long, SmsMessageCursor, SmsMessageCursorExample> implements SmsMessageCursorService{
	@Autowired
	private SmsMessageCursorMapper smsMessageCursorMapper;
	@Override
	protected BaseNormalDao<Long, SmsMessageCursor, SmsMessageCursorExample> getDao() {
		return smsMessageCursorMapper;
	}
	/**
	 * 获取所有临时信息
	 * @return
	 */
	@Override
	public List<SmsMessageCursor> getAll() {
		return smsMessageCursorMapper.getAll();
	}

    @Override
    public int saveHavedId(SmsMessageCursor smsMessageCursor) {
	    if(smsMessageCursor.getId()==null){
            smsMessageCursor.setId(genId());
        }
        return smsMessageCursorMapper.insertSelective(smsMessageCursor);
    }
}
