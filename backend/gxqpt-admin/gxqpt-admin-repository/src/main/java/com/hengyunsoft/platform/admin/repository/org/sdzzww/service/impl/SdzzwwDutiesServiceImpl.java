package com.hengyunsoft.platform.admin.repository.org.sdzzww.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDuties;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.dao.SdzzwwDutiesMapper;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwDutiesExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwDutiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SdzzwwDutiesServiceImpl  extends BaseServiceImpl<String, SdzzwwDuties, SdzzwwDutiesExample> implements SdzzwwDutiesService {
    @Autowired
    private SdzzwwDutiesMapper sdzzwwDutiesMapper;

    @Override
    protected BaseNormalDao<String, SdzzwwDuties, SdzzwwDutiesExample> getDao() {
        return sdzzwwDutiesMapper;
    }
}
