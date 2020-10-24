package com.hengyunsoft.platform.security.repository.interfaces.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class 
InterfaceAccessStatExample extends com.hengyunsoft.db.example.BaseExample<InterfaceAccessStatExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

        public GeneratedCriteria() {
            super();
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, java.util.List<java.util.Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdIsNull() {
            addCriterion("interface_config_id is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdIsNotNull() {
            addCriterion("interface_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdEqualTo(Long value) {
            addCriterion("interface_config_id =", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotEqualTo(Long value) {
            addCriterion("interface_config_id <>", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdGreaterThan(Long value) {
            addCriterion("interface_config_id >", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("interface_config_id >=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdLessThan(Long value) {
            addCriterion("interface_config_id <", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("interface_config_id <=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("interface_config_id in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("interface_config_id not in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdBetween(Long value1, Long value2) {
            addCriterion("interface_config_id between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("interface_config_id not between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andStatHourIsNull() {
            addCriterion("stat_hour is null");
            return (Criteria) this;
        }

        public Criteria andStatHourIsNotNull() {
            addCriterion("stat_hour is not null");
            return (Criteria) this;
        }

        public Criteria andStatHourEqualTo(Integer value) {
            addCriterion("stat_hour =", value, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourNotEqualTo(Integer value) {
            addCriterion("stat_hour <>", value, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourGreaterThan(Integer value) {
            addCriterion("stat_hour >", value, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("stat_hour >=", value, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourLessThan(Integer value) {
            addCriterion("stat_hour <", value, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourLessThanOrEqualTo(Integer value) {
            addCriterion("stat_hour <=", value, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourIn(java.util.List<java.lang.Integer> values) {
            addCriterion("stat_hour in", values, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("stat_hour not in", values, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourBetween(Integer value1, Integer value2) {
            addCriterion("stat_hour between", value1, value2, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatHourNotBetween(Integer value1, Integer value2) {
            addCriterion("stat_hour not between", value1, value2, "statHour");
            return (Criteria) this;
        }

        public Criteria andStatDateIsNull() {
            addCriterion("stat_date is null");
            return (Criteria) this;
        }

        public Criteria andStatDateIsNotNull() {
            addCriterion("stat_date is not null");
            return (Criteria) this;
        }

        public Criteria andStatDateEqualTo(String value) {
            addCriterion("stat_date =", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotEqualTo(String value) {
            addCriterion("stat_date <>", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThan(String value) {
            addCriterion("stat_date >", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThanOrEqualTo(String value) {
            addCriterion("stat_date >=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThan(String value) {
            addCriterion("stat_date <", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThanOrEqualTo(String value) {
            addCriterion("stat_date <=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateIn(java.util.List<String> values) {
            addCriterion("stat_date in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotIn(java.util.List<String> values) {
            addCriterion("stat_date not in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateBetween(String value1, String value2) {
            addCriterion("stat_date between", value1, value2, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotBetween(String value1, String value2) {
            addCriterion("stat_date not between", value1, value2, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatSumIsNull() {
            addCriterion("stat_sum is null");
            return (Criteria) this;
        }

        public Criteria andStatSumIsNotNull() {
            addCriterion("stat_sum is not null");
            return (Criteria) this;
        }

        public Criteria andStatSumEqualTo(Integer value) {
            addCriterion("stat_sum =", value, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumNotEqualTo(Integer value) {
            addCriterion("stat_sum <>", value, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumGreaterThan(Integer value) {
            addCriterion("stat_sum >", value, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stat_sum >=", value, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumLessThan(Integer value) {
            addCriterion("stat_sum <", value, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumLessThanOrEqualTo(Integer value) {
            addCriterion("stat_sum <=", value, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("stat_sum in", values, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("stat_sum not in", values, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumBetween(Integer value1, Integer value2) {
            addCriterion("stat_sum between", value1, value2, "statSum");
            return (Criteria) this;
        }

        public Criteria andStatSumNotBetween(Integer value1, Integer value2) {
            addCriterion("stat_sum not between", value1, value2, "statSum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
    se_interface_access_stataddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}