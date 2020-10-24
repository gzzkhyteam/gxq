package com.hengyunsoft.platform.hardware.repository.database.service.impl;

import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseResPanelDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseStatisticsDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseTypeRationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.database.po.DatabaseManagement;
import com.hengyunsoft.platform.hardware.repository.database.dao.DatabaseManagementMapper;
import com.hengyunsoft.platform.hardware.repository.database.example.DatabaseManagementExample;
import com.hengyunsoft.platform.hardware.repository.database.service.DatabaseManagementService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseManagementServiceImpl extends BaseServiceImpl<Long, DatabaseManagement, DatabaseManagementExample> implements DatabaseManagementService {
	@Autowired
	DatabaseManagementMapper databaseManagementMapper;

	@Override
	protected BaseNormalDao<Long, DatabaseManagement, DatabaseManagementExample> getDao() {

		return databaseManagementMapper;
	}

	@Override
	public List<DatabaseManagement> findByCondition(DatabaseManagement databaseManagement){

        return databaseManagementMapper.selectByConditions(databaseManagement);
    }

    @Override
    public DatabaseResPanelDO findDatabaseResPanel() {

        DatabaseResPanelDO databaseResPanelDO = new DatabaseResPanelDO();
        int databaseNum;
        int addNum;
        int addedLastMonth;
        int release;
        int releaseLastMonth;
        int netIncrease;

        //当前月
        Calendar cal_c_s=Calendar.getInstance();
        cal_c_s.add(Calendar.MONTH, 0);
        cal_c_s.set(Calendar.DAY_OF_MONTH,1);
        Date start = cal_c_s.getTime();

        Calendar cal_c_e = Calendar.getInstance();
        cal_c_e.set(Calendar.DAY_OF_MONTH, cal_c_e.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date end = cal_c_e.getTime();

        //上一月
        Calendar call_s = Calendar.getInstance();
        call_s.add(Calendar.MONTH, -1);
        call_s.set(Calendar.DAY_OF_MONTH,1);
        Date start_l_s = call_s.getTime();

        Calendar call_e = Calendar.getInstance();
        call_e.set(Calendar.DAY_OF_MONTH,0);
        Date start_l_e = call_e.getTime();

        DatabaseManagementExample example = new DatabaseManagementExample();

        //总数据库数量
        databaseNum = databaseManagementMapper.countByExample(null);

        //当前月新增
        example.createCriteria().andCreateTimeBetween(start,end);
        addNum = databaseManagementMapper.countByExample(example);

        //上月新增
        example.clear();
        example.createCriteria().andCreateTimeBetween(start_l_s,start_l_e);
        addedLastMonth = databaseManagementMapper.countByExample(example);

        //当前月释放
        example.clear();
            example.createCriteria().andIsReleaseEqualTo(1).andUpdateTimeBetween(start,end);
        release = databaseManagementMapper.countByExample(example);

        //上月释放
        example.clear();
        example.createCriteria().andIsReleaseEqualTo(1).andUpdateTimeBetween(start_l_s,start_l_e);
        releaseLastMonth = databaseManagementMapper.countByExample(example);

        //净增
        netIncrease = addNum - release;

        databaseResPanelDO.setDatabaseNum(databaseNum);
        databaseResPanelDO.setAddNum(addNum);
        databaseResPanelDO.setAddedLastMonth(addedLastMonth);
        databaseResPanelDO.setRelease(release);
        databaseResPanelDO.setReleaseLastMonth(releaseLastMonth);
        databaseResPanelDO.setNetIncrease(netIncrease);

        return  databaseResPanelDO;
    }

    @Override
    public List<DatabaseStatisticsDO> findDatabaseStatistics() {
        return databaseManagementMapper.findDatabaseStatistics();
    }

    @Override
    public List<DatabaseTypeRationDO> findDBTypeRatioStatistics() {
        return databaseManagementMapper.findDBTypeRatioStatistics();
    }
}