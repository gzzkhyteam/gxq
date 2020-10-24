package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogCount;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFile;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogCountMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogCountExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileInterfaceExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class logCountServiceImpl extends BaseAllServiceImpl<Long, LogCount, LogCountExample> implements LogCountService{
    @Autowired
    private LogCountMapper logCountMapper;

    @Override
    public List<LogCount> getLoginQuantity(Date startDate, Date endDate, String applyId) {
        return logCountMapper.getLoginQuantity(startDate,endDate,applyId);
    }

    @Override
    public List<LogCount> getBusinessClassAccount(Date startDate, Date endDate, String applyId) {
        return logCountMapper.getBusinessClassAccount(startDate,endDate,applyId);
    }

    @Override
    public List<LogCount> getLogLevelAccount(Date startDate, Date endDate, String applyId) {
        return logCountMapper.getLogLevelAccount(startDate,endDate,applyId);
    }

    @Override
    public List<LogCount> getLogLevelNum(Date startDate, Date endDate, String applyId) {
        return logCountMapper.getLevelNum(startDate,endDate,applyId);
    }

    @Override
    public List<LogCount> getLogTypeNum(Date startDate, Date endDate, String applyId) {
        return logCountMapper.getTypeNum(startDate,endDate,applyId);
    }

    @Override
    public List<LogCount> getResponseTime(Date startDate, Date endDate, String applyId, String logType) {
        return logCountMapper.getResponseTime(startDate,endDate,applyId,logType);
    }

    @Override
    public List<LogCount> getWarnLevelNumber(Date startDate, Date endDate, String applyId) {
        return logCountMapper.getWarnLevelNumber(startDate,endDate,applyId);
    }

    @Override
    public List<LogCount> getWarnTypeNumber(Date startDate, Date endDate, String applyId, String logType) {
        return logCountMapper.getWarnTypeNumber(startDate,endDate,applyId,logType);
    }

    @Override
    public List<LogCount> getWarnTypeAccount(Date startDate, Date endDate, String applyId) {
        return logCountMapper.getWarnTypeAccount(startDate,endDate,applyId);
    }

    @Override
    public List<LogCount> getPageAccess(Date startDate, Date endDate, String applyId,String logType) {
        return logCountMapper.getPageAccess(startDate,endDate,applyId,logType);
    }

    @Override
    public List<LogCount> getHttpStatus(Date startDate, Date endDate, String applyId,String logType) {
        return logCountMapper.getHttpStatus(startDate,endDate,applyId,logType);
    }

    @Override
    public List<LogCount> getBrowserType(Date startDate, Date endDate, String applyId,String logType) {
        return logCountMapper.getBrowserType(startDate,endDate,applyId,logType);
    }

    @Override
    public List<LogCount> getPvToUvCount(Date startDate, Date endDate, String applyId,String logType) {
        return logCountMapper.getPvToUvCount(startDate,endDate,applyId,logType);
    }

    @Override
    protected BaseNormalDao<Long, LogCount, LogCountExample> getDao() {
        return logCountMapper;
    }
}
