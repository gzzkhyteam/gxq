package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogOpenDelete;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogOpenDeleteMapper;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogStructApacheMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructApacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LogStructApacheServiceImpl extends BaseAllServiceImpl<Long, LogStructApache, LogStructApacheExample> implements LogStructApacheService {
    @Autowired
    private LogStructApacheMapper logStructApacheMapper;
    @Autowired
    private LogOpenDeleteMapper logOpenDeleteMapper;
    @Override
    protected BaseNormalDao<Long, LogStructApache, LogStructApacheExample> getDao() {
        return logStructApacheMapper;
    }

    @Override
    public List<LogStructApache> pageQueryApache(LogStructApacheExample example) {
        return logStructApacheMapper.pageQueryApache(example);
    }
    @Override
    public List<LogStructApache> pageQueryWarningApache(Long id) {
        return logStructApacheMapper.pageQueryWarningApache(id);
    }

    @Override
    public int deleteByDocumentIds(LogStructApacheExample example,String conditions) {
        int i=logStructApacheMapper.deleteByDocumentIds(example);
        LogOpenDelete logOpenDelete = new LogOpenDelete();
        if(i>0){
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

    @Override
    public List<LogTypeDO> findMonthCount(String startTime,String endTime) {
        return logStructApacheMapper.findMonthCount(startTime,endTime);
    }

    /**
     * 日志前12月响应时间
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<LogRespondMonthDO> findLogRespondMonth(String startTime, String endTime) {
      return   logStructApacheMapper.findLogRespondMonth(startTime,endTime);
    }
}
