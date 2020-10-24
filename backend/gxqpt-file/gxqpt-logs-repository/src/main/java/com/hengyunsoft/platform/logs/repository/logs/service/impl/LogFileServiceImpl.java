package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogFileDO;
import com.hengyunsoft.platform.logs.entity.logs.po.*;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogFileMapper;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogOpenDeleteMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.*;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LogFileServiceImpl extends BaseAllServiceImpl<Long, LogFile, LogFileExample> implements LogFileService {
    @Autowired
    private LogFileMapper logFileMapper;
    @Autowired
    private LogOpenDeleteMapper logOpenDeleteMapper;
    @Override
    protected BaseNormalDao<Long, LogFile, LogFileExample> getDao()  {
        return logFileMapper;
    }

    @Override
    public List<LogFileDO> pageQueryUpload(LogFileExample example) {
        return logFileMapper.pageQueryUpload(example);
    }

    @Override
    public List<LogStructApp> pageQueryAppList(LogStructAppExample example) {
        return logFileMapper.pageQueryAppList(example);
    }

    @Override
    public List<LogStructApache> pageQueryApacheList(LogStructApacheExample example) {
        return logFileMapper.pageQueryApacheList(example);
    }

    @Override
    public List<LogStructNginx> pageQueryNginxList(LogStructNginxExample example) {
        return logFileMapper.pageQueryNginxList(example);
    }

    @Override
    public List<LogStructTomcat> pageQueryTomcatList(LogStructTomcatExample example) {
        return logFileMapper.pageQueryTomcatList(example);
    }


    /**
     *
     * @param log_file_id
     * @return
     */
    @Override
    public int deleteLogFileInterfaceById(Long log_file_id) {
        return logFileMapper.deleteLogFileInterfaceById(log_file_id);
    }

    @Override
    public int deleteLogFileInterfaceByIds(List<Long> list) {
        return logFileMapper.deleteLogFileInterfaceByIds(list);
    }

    @Override
    public List<LogFile> queryLogFileByIds(List<Long> list) {
        return logFileMapper.queryLogFileByIds(list);
    }

    @Override
    public int deleteAppByDocumentId(List<String> list) {
        return logFileMapper.deleteAppByDocumentId(list);
    }

    @Override
    public int deleteApacheByDocumentId(List<String> list) {
        return logFileMapper.deleteApacheByDocumentId(list);
    }

    @Override
    public int deleteTomcatByDocumentId(List<String> list) {
        return logFileMapper.deleteTomcatByDocumentId(list);
    }

    @Override
    public int deleteNginxByDocumentId(List<String> list) {
        return logFileMapper.deleteNginxByDocumentId(list);
    }
    @Override
    public int deleteByDocumentIds(LogFileExample example,String conditions) {

        int i = logFileMapper.deleteByDocumentIds(example);
        if(i>0){
            LogOpenDelete logOpenDelete = new LogOpenDelete();
            Long simple=System.currentTimeMillis();
            logOpenDelete.setId(simple);
            logOpenDelete.setAppId(BaseContextHandler.getAppId());
            logOpenDelete.setIp("");
            logOpenDelete.setCallServeTime(Calendar.getInstance().getTime());
            logOpenDelete.setDeleteCondition(conditions);
            logOpenDelete.setDeleteCount((long) i);
            logOpenDelete.setCreateTime(Calendar.getInstance().getTime());
            logOpenDelete.setCreateUser(BaseContextHandler.getAdminId());
            logOpenDelete.setCreateUserName(BaseContextHandler.getName());
            logOpenDeleteMapper.insert(logOpenDelete);//保存删除的文件接口数据
        }


        return i;
    }


}
