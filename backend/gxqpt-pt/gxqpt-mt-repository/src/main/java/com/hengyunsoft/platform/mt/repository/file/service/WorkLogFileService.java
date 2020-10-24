package com.hengyunsoft.platform.mt.repository.file.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.file.po.WorkLogFile;
import com.hengyunsoft.platform.mt.repository.file.example.WorkLogFileExample;
import org.springframework.stereotype.Service;

@Service
public interface WorkLogFileService extends BaseService<Long,WorkLogFile,WorkLogFileExample>{
}
