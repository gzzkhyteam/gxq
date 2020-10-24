package com.hengyunsoft.platform.mt.repository.punchstatics.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.*;
import com.hengyunsoft.platform.mt.repository.punchstatics.dao.PunchAttendanceStaticsMapper;
import com.hengyunsoft.platform.mt.repository.punchstatics.example.PunchAttendanceStaticsExample;
import com.hengyunsoft.platform.mt.repository.punchstatics.service.PunchAttendanceStaticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PunchAttendanceStaticsServiceImpl extends BaseServiceImpl<Long, PunchAttendanceStatics, PunchAttendanceStaticsExample> implements PunchAttendanceStaticsService {
    @Autowired
    private PunchAttendanceStaticsMapper punchAttendanceStaticsMapper;

    @Override
    protected BaseNormalDao<Long, PunchAttendanceStatics, PunchAttendanceStaticsExample> getDao() {
        return punchAttendanceStaticsMapper;
    }

    @Override
    public PunchAttendanceStatics getPunchAttendanceStaticsByDate(Long userId, String dateStr) {
        PunchAttendanceStaticsExample example = new PunchAttendanceStaticsExample();
        PunchAttendanceStaticsExample.Criteria criteria = example.createCriteria();
        criteria.andAttDayEqualTo(dateStr).andUserIdEqualTo(userId);
        PunchAttendanceStatics unique = getUnique(example);
        return unique;
    }

    @Override
    public List<PunchAttendanceStaticsExt> webQueryMyStatics(Map<String, Object> param) {
        return punchAttendanceStaticsMapper.webQueryMyStatics(param);
    }

    @Override
    public PunchAttendanceStaticsExt queryMyStaticsSum(Map<String, Object> param) {
        return punchAttendanceStaticsMapper.queryMyStaticsSum(param);
    }

    @Override
    public List<PunchAttendanceStaticsExt> queryByAndSqlProvider(String whereAndSql, String havingAndSql) {
        List<PunchAttendanceStaticsExt> punchAttendanceStaticExts = punchAttendanceStaticsMapper.queryByAndSqlProvider(whereAndSql, havingAndSql);
        return punchAttendanceStaticExts;
    }

    @Override
    public List<PunchAttendanceStatics> htGetMyStaticsByType(String attMonth, long userId,String unitId, String type) {
        PunchAttendanceStaticsExample example = new PunchAttendanceStaticsExample();
        PunchAttendanceStaticsExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andAttMonthEqualTo(attMonth).andUnitIdEqualTo(unitId);
        //类型(overtime:加班，leave:请假，business:出差，outside:外勤，
        //     *              : lateHour: 迟到 : earlyHour :早退 : minerCount:矿工)
        if (type.equals("overtime")) {
            criteria.andWorkHousGreaterThan(0d);
        } else if (type.equals("leave")) {
            criteria.andLeaveHousGreaterThan(0d);
        } else if (type.equals("business")) {
            criteria.andTravelHousGreaterThan(0d);
        } else if (type.equals("outside")) {
            criteria.andOutHousGreaterThan(0d);
        } else if (type.equals("lateHour")) {
            criteria.andLateHourGreaterThan(0d);
        } else if (type.equals("earlyHour")) {
            criteria.andEarlyHourGreaterThan(0d);
        } else if (type.equals("minerCount")) {
            criteria.andMinerCountGreaterThan(0);
        }
        return find(example);
    }

    @Override
    public List<SimpEmp> querySimpEmpByProvider() {
        return punchAttendanceStaticsMapper.querySimpEmpByProvider();
    }

    @Override
    public List<SimpEmp> querySimpEmpByOrgId(String oriId) {
        return punchAttendanceStaticsMapper.querySimpEmpByOrgId(oriId);
    }

    @Override
    public List<SimpEmp> queryAllSimpEmpByProvider() {
        return punchAttendanceStaticsMapper.queryAllSimpEmpByProvider();
    }

    @Override
    public List<PunchAttendanceStaticsExt> appPeronManaList(Map<String, Object> param) {
        return punchAttendanceStaticsMapper.appPeronManaList(param);
    }

    @Override
    public CompanyStatics company() {
        return punchAttendanceStaticsMapper.company();
    }

    @Override
    public List<TypeAndNum> getDeclareTypeNum() {
        return punchAttendanceStaticsMapper.getDeclareTypeNum();
    }

    @Override
    public List<TypeAndNum> projectMoney() {
        return punchAttendanceStaticsMapper.projectMoney();
    }

    @Override
    public List<TypeAndNum> projectDecSort() {
        return punchAttendanceStaticsMapper.projectDecSort();
    }

    @Override
    public List<TypeAndNum> declareNum() {
        return punchAttendanceStaticsMapper.declareNum();
    }

    @Override
    public List<TypeAndNum> coyYersProject(String name) {
        return punchAttendanceStaticsMapper.coyYersProject(name);
    }
}
