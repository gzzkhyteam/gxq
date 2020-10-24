package com.hengyunsoft.platform.developer.repository.fast.document.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocTaskJnl;
import com.hengyunsoft.platform.developer.repository.fast.document.dao.FastAppDocTaskJnlMapper;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocTaskJnlExample;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocTaskJnlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FastAppDocTaskJnlServiceImpl extends BaseAllServiceImpl<Long, FastAppDocTaskJnl, FastAppDocTaskJnlExample>
        implements FastAppDocTaskJnlService {
    @Autowired
    private FastAppDocTaskJnlMapper fastAppDocTaskJnlMapper;

    @Override
    protected BaseNormalDao<Long, FastAppDocTaskJnl, FastAppDocTaskJnlExample> getDao() {
        return fastAppDocTaskJnlMapper;
    }

}
