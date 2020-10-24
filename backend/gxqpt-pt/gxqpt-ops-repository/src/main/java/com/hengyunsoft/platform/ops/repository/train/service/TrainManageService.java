package com.hengyunsoft.platform.ops.repository.train.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.train.dos.OperationFileDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainAdminPageReqDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainAdminPageResDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainPageResDO;
import com.hengyunsoft.platform.ops.entity.train.po.TrainManage;
import com.hengyunsoft.platform.ops.repository.train.example.TrainManageExample;

public interface TrainManageService extends BaseService<Long,TrainManage,TrainManageExample>{
   /**
	* 获取培训分页列表
	* @return
	*/
	 List<TrainPageResDO> getList(@SuppressWarnings("rawtypes") Map map);
	/**
	 * 获取培训审核分页列表
	 * @return
	 */
	 List<TrainAdminPageResDO> getAuditorList(TrainAdminPageReqDO trainAdminPageReqDTO);
	/**
	 * 获取文件列表
	 */
	List<OperationFileDO> getFilesByBussId(Set<Long> ids);
}
