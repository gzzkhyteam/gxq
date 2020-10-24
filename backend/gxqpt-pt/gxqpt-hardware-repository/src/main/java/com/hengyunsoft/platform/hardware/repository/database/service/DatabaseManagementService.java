package com.hengyunsoft.platform.hardware.repository.database.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseResPanelDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseStatisticsDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseTypeRationDO;
import com.hengyunsoft.platform.hardware.entity.database.po.DatabaseManagement;
import com.hengyunsoft.platform.hardware.repository.database.example.DatabaseManagementExample;

import java.util.List;
import java.util.Map;

public interface DatabaseManagementService extends BaseService<Long, DatabaseManagement, DatabaseManagementExample> {
    /**
     * 获取数据库分页数据
     * @param databaseManagement
     * @return
     */
    List<DatabaseManagement> findByCondition(DatabaseManagement databaseManagement);

    /**
     * 获取数据库资源面板数据
     * @return
     */
    DatabaseResPanelDO findDatabaseResPanel();

    /**
     * 获取往前推12个月的数据库数量统计
     * @return
     */
    List<DatabaseStatisticsDO> findDatabaseStatistics();

    /**
     * 数据库类型占比统计
     * @return
     */
    List<DatabaseTypeRationDO> findDBTypeRatioStatistics();
}
