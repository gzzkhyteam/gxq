package com.hengyunsoft.platform.admin.repository.org.sdzzww.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDepartment;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.dao.SdzzwwDepartmentMapper;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwDepartmentExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwDpmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangzhen
 * @createTime 2018-03-14
 */
@Service
@Slf4j
public class SdzzwwDpmServiceImpl extends BaseServiceImpl<String, SdzzwwDepartment, SdzzwwDepartmentExample> implements SdzzwwDpmService {
    @Autowired
    private SdzzwwDepartmentMapper mapper;
    @Override
    protected BaseNormalDao<String, SdzzwwDepartment, SdzzwwDepartmentExample> getDao() {
        return mapper;
    }
}
