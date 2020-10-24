package com.hengyunsoft.platform.hardware.repository.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage;

@Repository
public interface DiskManageMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage, com.hengyunsoft.platform.hardware.repository.manage.example.DiskManageExample> {
	 /**
	 * 获取所有磁盘信息
	 * @return
	 */
	List<DiskManage> findDiskByDpm();
}