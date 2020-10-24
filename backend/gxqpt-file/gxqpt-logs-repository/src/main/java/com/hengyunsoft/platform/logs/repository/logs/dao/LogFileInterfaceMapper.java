package com.hengyunsoft.platform.logs.repository.logs.dao;

import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFileInterface;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileInterfaceExample;
public interface LogFileInterfaceMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogFileInterface, com.hengyunsoft.platform.logs.repository.logs.example.LogFileInterfaceExample> {
    LogFileInterface queryLogFileInterfaceByLogFileId(Long id);

    int updateLogFileInterfaceStatus(List<String> documentIdList);

    Result<Boolean> deleteByDocumentIds(LogFileInterfaceExample example);

    void updateParsedSattus();
}