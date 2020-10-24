package com.hengyunsoft.platform.ops.repository.file.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.file.po.OperationFile;
import com.hengyunsoft.platform.ops.repository.file.example.OperationFileExample;

public interface OperationFileService extends BaseService<Long,OperationFile,OperationFileExample> {

	void deleteByFileIds(List<Long> fileIds);
}
