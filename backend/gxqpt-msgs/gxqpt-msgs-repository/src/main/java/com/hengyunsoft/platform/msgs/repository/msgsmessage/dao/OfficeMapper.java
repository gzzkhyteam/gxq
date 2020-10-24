package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.Office;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.OfficeExample;

@Repository
public interface OfficeMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, Office, OfficeExample> {
	/**
	 * 获取待公文项数据列表
	 * @return
	 */
	List<Office> getOfficeList();
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
	List<Office> getListByDate(@Param("date") Date date);
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(@Param("reciverId")Long reciverId);
}