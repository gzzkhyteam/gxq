package com.hengyunsoft.platform.piping.repository.service;


import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.piping.entity.message.GxqptPingpingWarnType;
import com.hengyunsoft.platform.piping.repository.example.GxqptPingpingWarnTypeExample;

import java.util.List;

public interface GxqptPingpingWarnTypeService extends BaseService<Long, GxqptPingpingWarnType, GxqptPingpingWarnTypeExample> {

    /**
     * 查询预警类型
     * @return
     */
    List<Long> getTypeId();
}
