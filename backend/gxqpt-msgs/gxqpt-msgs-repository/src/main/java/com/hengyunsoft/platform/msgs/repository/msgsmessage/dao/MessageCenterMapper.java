package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MessageCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MessageCenterExample;

@Repository
public interface MessageCenterMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, MessageCenter, MessageCenterExample> {
	/**
	 * 获取消息中心数据列表
	 * @return
	 */
	List<MessageCenter> getMessageCenterList();
	/**
	 * 获取未读信息总条数
	 * @param date
	 * @return
	 */
	int getCount(@Param("date") Date date);
	/**
	 * 获取半年以内未读信息
	 * @param date
	 * @return
	 */
	List<MessageCenter> getListByDate(@Param("date") Date date);
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(@Param("reciverId")Long reciverId);
}