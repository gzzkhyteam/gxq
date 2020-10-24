package com.hengyunsoft.platform.msgs.repository.channelgroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageCursor;

@Repository
public interface MobileMessageCursorMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageCursor, com.hengyunsoft.platform.msgs.repository.channelgroup.example.MobileMessageCursorExample> {

	List<MobileMessageCursor> getAll();
}