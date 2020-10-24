package com.hengyunsoft.platform.hardware.repository.manage.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage;
import com.hengyunsoft.platform.hardware.repository.manage.dao.DiskManageMapper;
import com.hengyunsoft.platform.hardware.repository.manage.example.DiskManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.service.DiskManageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiskManageServiceImpl extends BaseServiceImpl<Long, DiskManage, DiskManageExample> implements DiskManageService {

    @Autowired
    DiskManageMapper diskManageMapper;

    @Override
    protected BaseNormalDao<Long, DiskManage, DiskManageExample> getDao() {
        return diskManageMapper;
    }
    /**
	 * 获取所有磁盘信息
	 * @return
	 */
	@Override
	public List<DiskManage> findDiskByDpm() {
		
		return diskManageMapper.findDiskByDpm();
	}

}