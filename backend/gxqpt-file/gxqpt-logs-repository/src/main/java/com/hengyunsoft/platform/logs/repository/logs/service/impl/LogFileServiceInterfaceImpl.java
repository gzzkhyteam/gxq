package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFileInterface;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogFileInterfaceMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileInterfaceExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogFileServiceInterfaceImpl extends BaseAllServiceImpl<Long, LogFileInterface, LogFileInterfaceExample> implements LogFileInterfaceService {
    @Autowired
    private LogFileInterfaceMapper logFileInterfaceMapper;
    @Override
    protected BaseNormalDao<Long, LogFileInterface, LogFileInterfaceExample> getDao() {
        return logFileInterfaceMapper;
    }
    /**
     * 保存interface
     *
     * @param entity
     * @param entity
     * @return
     */
    public LogFileInterface saveInterface(LogFileInterface entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        Long id = genId();
        entity.setId(id);
        getDao().insert(entity);
        return entity;
    }
    /**
     * 根据 log_file_id查询一条记录
     */
    @Override
    public LogFileInterface queryLogFileInterfaceByLogFileId(Long id){
        return logFileInterfaceMapper.queryLogFileInterfaceByLogFileId(id);
    }

    @Override
    public int updateLogFileInterfaceStatus(List<String> documentIdList) {
        return logFileInterfaceMapper.updateLogFileInterfaceStatus(documentIdList);
    }
    @Override
   public List<LogFileInterface> queryLogFileInterfaceByTime(LogFileInterfaceExample logFileInterfaceExample){
        return logFileInterfaceMapper.selectByExample(logFileInterfaceExample);
    }




}
