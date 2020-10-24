package com.hengyunsoft.platform.mt.repository.work.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogDetail;
import com.hengyunsoft.platform.mt.repository.work.dao.WorkLogDetailMapper;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogDetailExample;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkLogDetailServiceImpl extends BaseServiceImpl<Long,WorkLogDetail,WorkLogDetailExample> implements WorkLogDetailService{
    @Autowired
    private WorkLogDetailMapper workLogDetailMapper;
    @Override
    protected BaseNormalDao<Long, WorkLogDetail, WorkLogDetailExample> getDao() {
        return workLogDetailMapper;
    }
}
