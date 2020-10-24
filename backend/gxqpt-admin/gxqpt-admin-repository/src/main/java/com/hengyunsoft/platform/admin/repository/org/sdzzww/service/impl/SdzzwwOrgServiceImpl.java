package com.hengyunsoft.platform.admin.repository.org.sdzzww.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwOrg;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.dao.SdzzwwOrgMapper;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwOrgExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangzhen
 * @createTime 2018-03-14
 */
@Service
@Slf4j
public class SdzzwwOrgServiceImpl extends BaseServiceImpl<String, SdzzwwOrg, SdzzwwOrgExample> implements SdzzwwOrgService {
    @Autowired
    private SdzzwwOrgMapper mapper;

    @Override
    protected BaseNormalDao<String, SdzzwwOrg, SdzzwwOrgExample> getDao() {
        return mapper;
    }
}
