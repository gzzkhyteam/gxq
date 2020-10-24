package com.hengyunsoft.platform.hardware.repository.manage.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage;
import com.hengyunsoft.platform.hardware.repository.manage.example.DiskManageExample;

public interface DiskManageService extends BaseService<Long, DiskManage, DiskManageExample> {
	/**
	 * 获取所有磁盘信息
	 * @return
	 */
	List<DiskManage> findDiskByDpm();
}
