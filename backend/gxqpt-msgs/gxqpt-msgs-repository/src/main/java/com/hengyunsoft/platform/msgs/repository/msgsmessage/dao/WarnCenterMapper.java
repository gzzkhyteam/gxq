package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WarnCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WarnCenterExample;

@Repository
public interface WarnCenterMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, WarnCenter, WarnCenterExample> {
	/**
	 * 获取预警中心数据列表
	 * @return
	 */
	List<WarnCenter> getWarnCenterList();
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
	List<WarnCenter> getListByDate(@Param("date") Date date);
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(@Param("reciverId")Long reciverId);
}