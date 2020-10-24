package com.hengyunsoft.platform.mt.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.file.po.WorkLogFile;
import com.hengyunsoft.platform.mt.repository.file.service.WorkLogFileService;
import com.hengyunsoft.platform.mt.repository.file.dao.WorkLogFileMapper;
import com.hengyunsoft.platform.mt.repository.file.example.WorkLogFileExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkLogFileServiceImpl extends BaseServiceImpl<Long,WorkLogFile,WorkLogFileExample> implements WorkLogFileService {

    @Autowired
    private WorkLogFileMapper workLogFileMapper;
    @Override
    protected BaseNormalDao<Long, WorkLogFile, WorkLogFileExample> getDao() {
        return workLogFileMapper;
    }
}
