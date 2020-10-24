package com.hengyunsoft.platform.mt.repository.punchstatics.dao;

import java.util.Map;

/***
 * 自定义sql条件查询
 */
public class QueryByAndSqlProvider {

    public String listByAndSql(Map<String, Object> params) {
        String whereAndSql = (String) params.get("whereAndSql");
        String havingAndSql = (String) params.get("havingAndSql");
        StringBuffer selectSql = new StringBuffer(" SELECT   s.user_id userId," +
                "        e.name_  userName," +
                "        e.maindeptname deptName, " +
                "        e.maindutyname maindutyName," +
                "        SUM( IF (s.late_hour + s.early_hour +s.miner_count +s.leave_hous <= 0,1,0)) normalDays,\t" +
                "        SUM( IF (s.late_hour + s.early_hour +s.miner_count +s.leave_hous > 0,1,0)) extDays,\t" +
                "        SUM(s.out_hous) outHous, " +
                "        SUM(s.work_hous) workHous, " +
                "        SUM(s.leave_hous) leaveHous, " +
                "        SUM(s.travel_hous) travelHous, " +
                "        SUM(s.late_hour) lateHour, " +
                "        SUM(s.early_hour) earlyHour, " +
                "        SUM(s.miner_count) minerCount, " +
                "        SUM(IF(s.late_hour > 0,1,0)) lateHourTime," +
                "        SUM(IF(s.early_hour > 0,1,0)) earlyHourTime, " +
                "        SUM( IF(s.isholiday > 0,0,1)) needDays" +
                "        FROM " +
                "        b_punch_attendance_statics AS s LEFT JOIN copy_core_c_gxqpt_emp e ON s.user_id = e.gxqpt_emp_id ");
        selectSql.append(" WHERE  1=1 ");
        selectSql.append(whereAndSql);
        selectSql.append(" GROUP BY s.user_id ");
        selectSql.append(" HAVING 1=1 ");
        selectSql.append(havingAndSql);
        return selectSql.toString();
    }

    public String querySimpEmp() {
        String sql = "SELECT emp.gxqpt_emp_id gxqptEmpId,emp.isenable,emp.name_ name,emp.mainorgid,emp.mainorgname,emp.maindeptname,emp.maindutyname " +
                " FROM copy_core_c_gxqpt_emp emp" +
                " WHERE " +
                " emp.isenable = 1 " +
                " AND " +
                "(((SELECT COUNT(*) FROM b_appr_apply aa WHERE aa.apply_user_id = emp.gxqpt_emp_id) > 0 OR (SELECT COUNT(*) FROM b_punch_clock pc WHERE pc.user_id = emp.gxqpt_emp_id ) > 0))";
        return sql;
    }

    public String queryAllSimpEmp() {
        String sql = "SELECT emp.gxqpt_emp_id gxqptEmpId,emp.isenable,emp.name_ name,emp.mainorgid,emp.mainorgname,emp.maindeptname,emp.maindutyname " +
                " FROM copy_core_c_gxqpt_emp emp" +
                " WHERE " +
                " emp.isenable = 1 ";
        return sql;
    }

    public String querySimpEmpByOrgId(Map<String, Object> params) {
        String oriId = (String) params.get("oriId");
        String sql = "SELECT emp.gxqpt_emp_id gxqptEmpId,emp.isenable,emp.name_ name,emp.mainorgid,emp.mainorgname,emp.maindeptname,emp.maindutyname " +
                " FROM copy_core_c_gxqpt_emp emp" +
                " WHERE " +
                " emp.isenable = 1 " +
                " AND emp.mainorgid = " + oriId;
        return sql;
    }

    public String companyStatics() {
        String sql = "SELECT COUNT(*) companyNum,SUM(c.INVESTMENT) property,SUM(c.SIZE_OF_PERSON) personNum,\n" +
                "   (SELECT COUNT(*)  from bs_company_info bc  WHERE   DATE_FORMAT( bc.CREATE_TIME, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )) monthNum,\n" +
                "\t\t(SELECT COUNT(*) FROM bs_project_declare_third pd ) projectDeclare, \n" +
                "\t(SELECT COUNT(*) FROM bs_project_declare_third  WHERE DECLARE_TYPE = 5) technical,  \n" +
                "(SELECT COUNT(*) FROM bs_project_declare_third  WHERE DECLARE_TYPE = 6) investment,  \n" +
                "(SELECT COUNT(*) FROM bs_project_declare_third  WHERE DECLARE_TYPE = 7) cultivate\n" +
                "  from bs_company_info c; ";
        return sql;
    }

    public String declareTypeSql() {
        String sql = "SELECT COUNT(1) V1,DECLARE_TYPE K from bs_project_declare_third bc  " +
                "  GROUP BY bc.DECLARE_TYPE DESC";
        return sql;
    }

    public String projectMoney() {
        String sql = "SELECT SUM(bc.PROJECT_SQDK) V1,SUM(bc.PROJECT_SQCZ) V2,DATE_FORMAT( bc.CREATE_TIME, '%Y' ) K  " +
                "from bs_project bc   GROUP BY K  ORDER BY K ASC LIMIT 5 ;";
        return sql;
    }

    public String projectDecSort() {
        String sql = "SELECT COUNT(1) V1, (SELECT bc.CPY_NAME FROM bs_company_info bc WHERE bc.CPY_ID = bd.CPY_ID) K\n" +
                "FROM `bs_project` bd GROUP BY bd.CPY_ID ORDER BY V1 DESC  LIMIT 5;";
        return sql;
    }

    public String declareNum() {
        String sql = "select COUNT(1) V1,YEAR(CREATE_DATE) K\n" +
                " from `bs_project_declare_third` bd  GROUP BY K ORDER BY K ASC LIMIT 5";
        return sql;
    }

    public String coyYersProject(Map<String, Object> params) {
        String name = (String) params.get("name");
        String sql = "SELECT p.PROJECT_NAME K,p.PROJECT_SQCZ V1 from bs_project p LEFT JOIN bs_company_info c ON p.CPY_ID = c.CPY_ID \n" +
                "   WHERE  c.CPY_NAME = '" + name + "' ";
        return sql;

    }
}
