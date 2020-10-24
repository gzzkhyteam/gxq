package com.hengyunsoft.platform.mt.repository.punchstatics.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.*;
import com.hengyunsoft.platform.mt.repository.punchstatics.example.PunchAttendanceStaticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

public interface PunchAttendanceStaticsService extends BaseService<Long, PunchAttendanceStatics, PunchAttendanceStaticsExample> {
    /***
     *
     * @param userId  用户id
     * @param dateStr  统计日期,格式为yyyy-MM-dd hh:mm:ss
     * @return
     */
    PunchAttendanceStatics getPunchAttendanceStaticsByDate(Long userId, String dateStr);

    /***
     * web查询我的考勤
     * @param param
     * @return
     */
    List<PunchAttendanceStaticsExt> webQueryMyStatics(Map<String, Object> param);

    /***
     * web查询我的考勤总计值
     * @param param
     * @return
     */
    PunchAttendanceStaticsExt queryMyStaticsSum(Map<String, Object> param);

    /***
     *根据拼接的 and 已经查询
     * @param whereAndSql  where条件的and已经
     * @param havingAndSql having条件的and语句
     * @return
     */
    List<PunchAttendanceStaticsExt> queryByAndSqlProvider(String whereAndSql, String havingAndSql);

    /***
     * 更新类型和月份查询用户的统计列表
     * type   类型(overtime:加班，leave:请假，business:出差，outside:外勤，
     *               :supply:补签 : lateHour: 迟到 : earlyHour :早退 : minerCount:矿工)
     * @param type
     * @param userId
     * @param unitId 单位id
     * @param type
     * @return
     */

    List<PunchAttendanceStatics> htGetMyStaticsByType(String attMonth, long userId, String unitId, String type);

    /***
     * 查询用户的简单信息
     * @return
     */
    List<SimpEmp> querySimpEmpByProvider();

    List<SimpEmp>  querySimpEmpByOrgId(String oriId);
    /***
     * 查询所有用户的简单信息
     * @return
     */
    List<SimpEmp> queryAllSimpEmpByProvider();

    List<PunchAttendanceStaticsExt> appPeronManaList(Map<String, Object> param);

    CompanyStatics company();

    List<TypeAndNum> getDeclareTypeNum();

    List<TypeAndNum> projectMoney();

    List<TypeAndNum> projectDecSort();

    List<TypeAndNum> declareNum();

    List<TypeAndNum> coyYersProject(String name);
}
