package com.hengyunsoft.platform.security.repository.backups.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.backups.po.Backups;
import com.hengyunsoft.platform.security.repository.backups.dao.BackupsMapper;
import com.hengyunsoft.platform.security.repository.backups.example.BackupsExample;
import com.hengyunsoft.platform.security.repository.backups.service.BackupsApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：备份管理实现
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Service
@Slf4j
public class BackupsApiServiceImpl extends BaseServiceImpl<Long, Backups, BackupsExample> implements BackupsApiService {

    @Autowired
    BackupsMapper backupsMapper;


    @Override
    protected BaseNormalDao<Long, Backups, BackupsExample> getDao() {
        return backupsMapper;
    }
}
