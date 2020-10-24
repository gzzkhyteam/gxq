package com.hengyunsoft.platform.developer.repository.fast.document.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocExtraAdvice;
import com.hengyunsoft.platform.developer.repository.fast.document.dao.FastAppDocExtraAdviceMapper;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocExtraAdviceExample;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocExtraAdviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FastAppDocExtraAdviceServiceImpl extends BaseAllServiceImpl<Long, FastAppDocExtraAdvice, FastAppDocExtraAdviceExample>
        implements FastAppDocExtraAdviceService {
    @Autowired
    private FastAppDocExtraAdviceMapper fastAppDocExtraAdviceMapper;

    @Override
    protected BaseNormalDao<Long, FastAppDocExtraAdvice, FastAppDocExtraAdviceExample> getDao() {
        return fastAppDocExtraAdviceMapper;
    }

}
