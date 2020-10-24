package com.hengyunsoft.platform.ops.repository.train.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.ops.entity.train.dos.OperationFileDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainAdminPageReqDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainAdminPageResDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainPageResDO;

@Repository
public interface TrainManageMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.ops.entity.train.po.TrainManage, com.hengyunsoft.platform.ops.repository.train.example.TrainManageExample> {
   /**
	* 获取培训分页列表
	* @return
	*/
   List<TrainPageResDO> getList(@SuppressWarnings("rawtypes") Map map);
	/**
	 * 获取培训审核分页列表
	 * @return
	 */
	public List<TrainAdminPageResDO> getAuditorList(@Param(value = "trainAdminPageReqDTO") TrainAdminPageReqDO trainAdminPageReqDTO);
	/**
	 * 获取文件列表
	 */
	List<OperationFileDO> getFilesByBussId(@Param(value = "ids") Set<Long> ids);
}