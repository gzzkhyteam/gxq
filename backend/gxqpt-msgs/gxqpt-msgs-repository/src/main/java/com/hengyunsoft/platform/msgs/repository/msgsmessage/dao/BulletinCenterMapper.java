package com.hengyunsoft.platform.msgs.repository.msgsmessage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BulletinCenter;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BulletinCenterExample;

@Repository
public interface BulletinCenterMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, BulletinCenter,BulletinCenterExample> {
	/**
	 * 获取公告中心数据列表
	 * @return
	 */
	List<BulletinCenter> getBulletinCenterList();
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
	List<BulletinCenter> getListByDate(@Param("date") Date date);
	/**
	 * 获取全部数量消息
	 * @return
	 */
	Integer getAllCount(@Param("reciverId")Long reciverId);
}