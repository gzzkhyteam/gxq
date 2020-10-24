package com.hengyunsoft.platform.developer.repository.fast.document.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocTask;
import com.hengyunsoft.platform.developer.repository.fast.document.dao.FastAppDocTaskMapper;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocTaskExample;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FastAppDocTaskServiceImpl extends BaseAllServiceImpl<Long, FastAppDocTask, FastAppDocTaskExample>
        implements FastAppDocTaskService {
    @Autowired
    private FastAppDocTaskMapper fastAppDocTaskMapper;

    @Override
    protected BaseNormalDao<Long, FastAppDocTask, FastAppDocTaskExample> getDao() {
        return fastAppDocTaskMapper;
    }

}
