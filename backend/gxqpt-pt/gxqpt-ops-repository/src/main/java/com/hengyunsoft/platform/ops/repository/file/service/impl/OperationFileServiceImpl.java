package com.hengyunsoft.platform.ops.repository.file.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.file.po.OperationFile;
import com.hengyunsoft.platform.ops.repository.file.dao.OperationFileMapper;
import com.hengyunsoft.platform.ops.repository.file.example.OperationFileExample;
import com.hengyunsoft.platform.ops.repository.file.service.OperationFileService;

@Service
public class OperationFileServiceImpl extends BaseServiceImpl<Long,OperationFile,OperationFileExample>  implements OperationFileService{

    @Autowired
    private OperationFileMapper operationFileMapper;
    @Override
    protected BaseNormalDao<Long, OperationFile, OperationFileExample> getDao() {
        return operationFileMapper;
    }
    
	@Override
	public void deleteByFileIds(List<Long> fileIds) {
		operationFileMapper.deleteByFileIds(fileIds);
	}
}
