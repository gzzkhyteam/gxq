package com.hengyunsoft.platform.hardware.repository.database.dao;

import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseResPanelDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseStatisticsDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseTypeRationDO;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.hardware.entity.database.po.DatabaseManagement;
import com.hengyunsoft.platform.hardware.repository.database.example.DatabaseManagementExample;

import java.util.List;

@Repository
public interface DatabaseManagementMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, DatabaseManagement, DatabaseManagementExample> {


    List<DatabaseManagement> selectByConditions(DatabaseManagement databaseManagement);

    /**
     * 数据库数量统计
     * @return
     */
    List<DatabaseStatisticsDO> findDatabaseStatistics();

    /**
     * 数据库类型占比统计
     * @return
     */
    List<DatabaseTypeRationDO> findDBTypeRatioStatistics();

}