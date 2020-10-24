package com.hengyunsoft.platform.admin.repository.org.sdzzww.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwPost;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.dao.SdzzwwPostMapper;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwPostExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SdzzwwPostServiceImpl extends BaseServiceImpl<String, SdzzwwPost, SdzzwwPostExample> implements SdzzwwPostService {
    @Autowired
    private SdzzwwPostMapper sdzzwwPostMapper;

    @Override
    protected BaseNormalDao<String, SdzzwwPost, SdzzwwPostExample> getDao() {
        return sdzzwwPostMapper;
    }
}
