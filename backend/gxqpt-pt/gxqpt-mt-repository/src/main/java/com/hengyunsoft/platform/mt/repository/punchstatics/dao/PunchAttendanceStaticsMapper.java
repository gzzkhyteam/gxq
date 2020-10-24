package com.hengyunsoft.platform.mt.repository.punchstatics.dao;

import com.hengyunsoft.platform.mt.entity.punchstatics.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PunchAttendanceStaticsMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, PunchAttendanceStatics, com.hengyunsoft.platform.mt.repository.punchstatics.example.PunchAttendanceStaticsExample> {
    /***
     * web查询我的考勤
     * @param param
     */
    List<PunchAttendanceStaticsExt> webQueryMyStatics(Map<String, Object> param);

    /**
     * web查询我的考勤总计
     *
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
    @SelectProvider(type = QueryByAndSqlProvider.class, method = "listByAndSql")
    List<PunchAttendanceStaticsExt> queryByAndSqlProvider(@Param("whereAndSql") String whereAndSql, @Param("havingAndSql") String havingAndSql);

    /***
     * 查询使用了移动终端用户的简单信息
     * @return
     */
    @SelectProvider(type = QueryByAndSqlProvider.class, method = "querySimpEmp")
    List<SimpEmp> querySimpEmpByProvider();

    /***
     * 查询所有用户的简单信息
     * @return
     */
    @SelectProvider(type = QueryByAndSqlProvider.class, method = "queryAllSimpEmp")
    List<SimpEmp> queryAllSimpEmpByProvider();

    @SelectProvider(type = QueryByAndSqlProvider.class, method = "querySimpEmpByOrgId")
    List<SimpEmp> querySimpEmpByOrgId(@Param("oriId") String oriId);

    /***
     * 根据用户Id及时间查询当前时间段的正常出勤天数
     * @return
     */
    int getNormalDay(Map<String, Object> param);

    List<PunchAttendanceStaticsExt> queryHalfYearAttence(Map<String, Object> param);

    List<PunchAttendanceStaticsExt> appPeronManaList(Map<String, Object> param);


    //企业管理相关
    @SelectProvider(type = QueryByAndSqlProvider.class, method = "companyStatics")
    CompanyStatics company();

    @SelectProvider(type = QueryByAndSqlProvider.class, method = "declareTypeSql")
    List<TypeAndNum> getDeclareTypeNum();

    @SelectProvider(type = QueryByAndSqlProvider.class, method = "projectMoney")
    List<TypeAndNum> projectMoney();

    @SelectProvider(type = QueryByAndSqlProvider.class, method = "projectDecSort")
    List<TypeAndNum> projectDecSort();

    @SelectProvider(type = QueryByAndSqlProvider.class, method = "declareNum")
    List<TypeAndNum> declareNum();

    @SelectProvider(type = QueryByAndSqlProvider.class, method = "coyYersProject")
    List<TypeAndNum> coyYersProject(@Param("name") String name);
}