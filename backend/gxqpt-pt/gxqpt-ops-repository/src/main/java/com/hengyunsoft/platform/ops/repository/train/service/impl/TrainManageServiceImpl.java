package com.hengyunsoft.platform.ops.repository.train.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.train.dos.OperationFileDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainAdminPageReqDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainAdminPageResDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainPageResDO;
import com.hengyunsoft.platform.ops.entity.train.po.TrainManage;
import com.hengyunsoft.platform.ops.repository.train.dao.TrainManageMapper;
import com.hengyunsoft.platform.ops.repository.train.example.TrainManageExample;
import com.hengyunsoft.platform.ops.repository.train.service.TrainManageService;

@Service
public class TrainManageServiceImpl extends BaseServiceImpl<Long,TrainManage,TrainManageExample> implements TrainManageService{
    @Autowired
    private TrainManageMapper trainManageMapper;
    
	@Override
	protected BaseNormalDao<Long, TrainManage, TrainManageExample> getDao() {
		return trainManageMapper;
	}
   /**
	* 获取培训分页列表
	* @return
	*/
	@Override
	public List<TrainPageResDO> getList(@SuppressWarnings("rawtypes") Map map) {
		return trainManageMapper.getList(map);
	}
	/**
	 * 获取培训审核分页列表
	 * @return
	 */
	@Override
	public List<TrainAdminPageResDO> getAuditorList(TrainAdminPageReqDO trainAdminPageReqDTO) {
		return trainManageMapper.getAuditorList(trainAdminPageReqDTO);
	}
	/**
	 * 获取文件列表
	 */
	@Override
	public List<OperationFileDO> getFilesByBussId(Set<Long> ids) {
		return trainManageMapper.getFilesByBussId(ids);
	}

}
