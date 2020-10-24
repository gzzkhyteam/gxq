package com.hengyunsoft.platform.security.repository.assess.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.assess.po.ProgramRelease;
import com.hengyunsoft.platform.security.repository.assess.dao.ProgramReleaseMapper;
import com.hengyunsoft.platform.security.repository.assess.example.ProgramReleaseExample;
import com.hengyunsoft.platform.security.repository.assess.service.ProgramReleaseApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：程序发布管理实现
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Service
@Slf4j
public class ProgramReleaseApiServiceImpl extends BaseServiceImpl<Long, ProgramRelease, ProgramReleaseExample> implements ProgramReleaseApiService {

    @Autowired
    ProgramReleaseMapper programReleaseMapper;


    @Override
    protected BaseNormalDao<Long, ProgramRelease, ProgramReleaseExample> getDao() {
        return programReleaseMapper;
    }

}
