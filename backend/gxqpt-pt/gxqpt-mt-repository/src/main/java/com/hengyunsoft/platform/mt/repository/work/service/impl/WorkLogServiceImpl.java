package com.hengyunsoft.platform.mt.repository.work.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLog;
import com.hengyunsoft.platform.mt.entity.work.po.domain.WorkLogCountDO;
import com.hengyunsoft.platform.mt.repository.work.dao.WorkLogMapper;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogExample;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WorkLogServiceImpl extends BaseServiceImpl<Long, WorkLog, WorkLogExample> implements WorkLogService {

    @Autowired
    private WorkLogMapper workLogMapper;

    @Override
    protected BaseNormalDao<Long, WorkLog, WorkLogExample> getDao() {
        return workLogMapper;
    }

    /**
     * 查询日志列表信息
     *
     * @param
     */
    @Override
    public List<WorkLog> getPageList(Map map) {
        return workLogMapper.getPageList(map);
    }

    /**
     * 查询本周日志统计记录
     *
     * @param
     */
    @Override
    public WorkLogCountDO getCountList(Map map) {
        return workLogMapper.getCountList(map);
    }

    @Override
    public WorkLog getByUserId(Long userId, String unitId) {
        return workLogMapper.getByUserId(userId, unitId);
    }

    /***
     * 查询用户当前月日志数量
     * @param userId
     * @return
     */
    public int getMonthCount(Long userId, String unitId) {
        return workLogMapper.getMonthCount(userId, unitId);
    }

}
