package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogOpenDelete;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogOpenDeleteMapper;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogStructNginxMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructNginxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LogStructNginxServiceImpl extends BaseAllServiceImpl<Long, LogStructNginx, LogStructNginxExample> implements LogStructNginxService {
    @Autowired
    private LogStructNginxMapper logStructNginxMapper;
    @Autowired
    private LogOpenDeleteMapper logOpenDeleteMapper;
    @Override
    protected BaseNormalDao<Long, LogStructNginx, LogStructNginxExample> getDao() {
        return logStructNginxMapper;
    }

    @Override
    public List<LogStructNginx> pageQueryNginx(LogStructNginxExample example) {
        return logStructNginxMapper.selectByExample(example);
    }

    @Override
    public List<LogStructNginx> pageQueryWarningNginx(Long id) {
         return logStructNginxMapper.pageQueryWarningNginx(id);
    }

    @Override
    public int deleteByDocumentIds(LogStructNginxExample example,String conditions) {
        int i=logStructNginxMapper.deleteByDocumentIds(example);
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

    /**
     * 统计前十二月数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<LogTypeDO> findMonthCount(String startTime, String endTime) {
       return logStructNginxMapper.findMonthCount(startTime,endTime);
    }

    /**
     * 查询前十二月日志响应时间
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<LogRespondMonthDO> findLogRespondMonth(String startTime, String endTime) {
       return logStructNginxMapper.findLogRespondMonth(startTime,endTime);
    }
}
