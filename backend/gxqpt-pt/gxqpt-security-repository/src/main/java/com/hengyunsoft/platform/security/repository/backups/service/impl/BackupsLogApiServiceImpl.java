package com.hengyunsoft.platform.security.repository.backups.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.backups.po.BackupsLog;
import com.hengyunsoft.platform.security.repository.backups.dao.BackupsLogMapper;
import com.hengyunsoft.platform.security.repository.backups.example.BackupsLogExample;
import com.hengyunsoft.platform.security.repository.backups.service.BackupsLogApiService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：备份日志管理实现
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Service
@Slf4j
public class BackupsLogApiServiceImpl extends BaseServiceImpl<Long, BackupsLog, BackupsLogExample> implements BackupsLogApiService {

    @Autowired
    BackupsLogMapper backupsLogMapper;


    @Override
    protected BaseNormalDao<Long, BackupsLog, BackupsLogExample> getDao() {
        return backupsLogMapper;
    }

}
