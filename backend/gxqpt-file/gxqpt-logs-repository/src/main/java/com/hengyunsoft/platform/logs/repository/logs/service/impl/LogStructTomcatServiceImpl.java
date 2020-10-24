package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogOpenDelete;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogOpenDeleteMapper;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogStructTomcatMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructTomcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Service
public class LogStructTomcatServiceImpl extends BaseAllServiceImpl<Long, LogStructTomcat, LogStructTomcatExample> implements LogStructTomcatService {
    @Autowired
    private LogStructTomcatMapper logStructTomcatMapper;
    @Autowired
    private LogOpenDeleteMapper logOpenDeleteMapper;
    @Override
    protected BaseNormalDao<Long, LogStructTomcat, LogStructTomcatExample> getDao() {
        return logStructTomcatMapper;
    }

    @Override
    public List<LogStructTomcat> pageQueryTomcat(LogStructTomcatExample example) {
        return logStructTomcatMapper.selectByExample(example);
    }

    @Override
    public List<LogStructTomcat> pageQueryWarningTomcat(Long id) {
        return logStructTomcatMapper.pageQueryWarningTomcat(id);
    }

    @Override
    public int deleteByDocumentIds(LogStructTomcatExample example,String conditions) {
        int i=logStructTomcatMapper.deleteByDocumentIds(example);
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
            logOpenDeleteMapper.insertSelective(logOpenDelete);//保存删除的文件接口数据
        }
        return i;
    }

    /**
     * 统计前十二月数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<LogTypeDO> findMonthCount(String startTime, String endTime) {
        return logStructTomcatMapper.findMonthCount(startTime,endTime);
    }

    /**
     *查询前十二月响应时间
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<LogRespondMonthDO> findLogRespondMonth(String startTime, String endTime) {
       return logStructTomcatMapper.findLogRespondMonth(startTime,endTime);
    }


}
