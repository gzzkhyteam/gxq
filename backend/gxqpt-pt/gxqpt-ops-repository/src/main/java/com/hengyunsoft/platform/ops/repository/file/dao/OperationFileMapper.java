package com.hengyunsoft.platform.ops.repository.file.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationFileMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.ops.entity.file.po.OperationFile, com.hengyunsoft.platform.ops.repository.file.example.OperationFileExample> {
	void deleteByFileIds(@Param(value="fileIds")List<Long> fileIds);
}