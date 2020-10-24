package com.hengyunsoft.platform.admin.repository.core.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.core.po.DataShareToApp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptShareAndAppInServiceDO;
import com.hengyunsoft.platform.admin.repository.core.example.DataShareToAppExample;

import java.util.List;

public interface DataShareToAppService extends BaseService<Long,DataShareToApp,DataShareToAppExample>{
    List<GxqptShareAndAppInServiceDO> selectAppByShare(String bizId);

    int deleteShare(List<String> deleteIds, String id);
}
