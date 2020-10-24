package com.hengyunsoft.platform.mt.repository.punchstatics.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PunchAttendanceStaticsExample extends com.hengyunsoft.db.example.BaseExample<PunchAttendanceStaticsExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

        public GeneratedCriteria() {
            super();
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNull() {
            addCriterion("unit_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(String value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(String value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(String value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(String value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(String value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLike(String value) {
            addCriterion("unit_id like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotLike(String value) {
            addCriterion("unit_id not like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(String value1, String value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(String value1, String value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andAttYearIsNull() {
            addCriterion("att_year is null");
            return (Criteria) this;
        }

        public Criteria andAttYearIsNotNull() {
            addCriterion("att_year is not null");
            return (Criteria) this;
        }

        public Criteria andAttYearEqualTo(String value) {
            addCriterion("att_year =", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearNotEqualTo(String value) {
            addCriterion("att_year <>", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearGreaterThan(String value) {
            addCriterion("att_year >", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearGreaterThanOrEqualTo(String value) {
            addCriterion("att_year >=", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearLessThan(String value) {
            addCriterion("att_year <", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearLessThanOrEqualTo(String value) {
            addCriterion("att_year <=", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearLike(String value) {
            addCriterion("att_year like", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearNotLike(String value) {
            addCriterion("att_year not like", value, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearIn(java.util.List<java.lang.String> values) {
            addCriterion("att_year in", values, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearNotIn(java.util.List<java.lang.String> values) {
            addCriterion("att_year not in", values, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearBetween(String value1, String value2) {
            addCriterion("att_year between", value1, value2, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttYearNotBetween(String value1, String value2) {
            addCriterion("att_year not between", value1, value2, "attYear");
            return (Criteria) this;
        }

        public Criteria andAttMonthIsNull() {
            addCriterion("att_month is null");
            return (Criteria) this;
        }

        public Criteria andAttMonthIsNotNull() {
            addCriterion("att_month is not null");
            return (Criteria) this;
        }

        public Criteria andAttMonthEqualTo(String value) {
            addCriterion("att_month =", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthNotEqualTo(String value) {
            addCriterion("att_month <>", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthGreaterThan(String value) {
            addCriterion("att_month >", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthGreaterThanOrEqualTo(String value) {
            addCriterion("att_month >=", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthLessThan(String value) {
            addCriterion("att_month <", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthLessThanOrEqualTo(String value) {
            addCriterion("att_month <=", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthLike(String value) {
            addCriterion("att_month like", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthNotLike(String value) {
            addCriterion("att_month not like", value, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthIn(java.util.List<java.lang.String> values) {
            addCriterion("att_month in", values, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthNotIn(java.util.List<java.lang.String> values) {
            addCriterion("att_month not in", values, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthBetween(String value1, String value2) {
            addCriterion("att_month between", value1, value2, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttMonthNotBetween(String value1, String value2) {
            addCriterion("att_month not between", value1, value2, "attMonth");
            return (Criteria) this;
        }

        public Criteria andAttDayIsNull() {
            addCriterion("att_day is null");
            return (Criteria) this;
        }

        public Criteria andAttDayIsNotNull() {
            addCriterion("att_day is not null");
            return (Criteria) this;
        }

        public Criteria andAttDayEqualTo(String value) {
            addCriterion("att_day =", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayNotEqualTo(String value) {
            addCriterion("att_day <>", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayGreaterThan(String value) {
            addCriterion("att_day >", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayGreaterThanOrEqualTo(String value) {
            addCriterion("att_day >=", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayLessThan(String value) {
            addCriterion("att_day <", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayLessThanOrEqualTo(String value) {
            addCriterion("att_day <=", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayLike(String value) {
            addCriterion("att_day like", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayNotLike(String value) {
            addCriterion("att_day not like", value, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayIn(java.util.List<java.lang.String> values) {
            addCriterion("att_day in", values, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayNotIn(java.util.List<java.lang.String> values) {
            addCriterion("att_day not in", values, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayBetween(String value1, String value2) {
            addCriterion("att_day between", value1, value2, "attDay");
            return (Criteria) this;
        }

        public Criteria andAttDayNotBetween(String value1, String value2) {
            addCriterion("att_day not between", value1, value2, "attDay");
            return (Criteria) this;
        }

        public Criteria andIsholidayIsNull() {
            addCriterion("isholiday is null");
            return (Criteria) this;
        }

        public Criteria andIsholidayIsNotNull() {
            addCriterion("isholiday is not null");
            return (Criteria) this;
        }

        public Criteria andIsholidayEqualTo(Integer value) {
            addCriterion("isholiday =", value, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayNotEqualTo(Integer value) {
            addCriterion("isholiday <>", value, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayGreaterThan(Integer value) {
            addCriterion("isholiday >", value, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayGreaterThanOrEqualTo(Integer value) {
            addCriterion("isholiday >=", value, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayLessThan(Integer value) {
            addCriterion("isholiday <", value, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayLessThanOrEqualTo(Integer value) {
            addCriterion("isholiday <=", value, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayIn(java.util.List<java.lang.Integer> values) {
            addCriterion("isholiday in", values, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("isholiday not in", values, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayBetween(Integer value1, Integer value2) {
            addCriterion("isholiday between", value1, value2, "isholiday");
            return (Criteria) this;
        }

        public Criteria andIsholidayNotBetween(Integer value1, Integer value2) {
            addCriterion("isholiday not between", value1, value2, "isholiday");
            return (Criteria) this;
        }

        public Criteria andOutHousIsNull() {
            addCriterion("out_hous is null");
            return (Criteria) this;
        }

        public Criteria andOutHousIsNotNull() {
            addCriterion("out_hous is not null");
            return (Criteria) this;
        }

        public Criteria andOutHousEqualTo(Double value) {
            addCriterion("out_hous =", value, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousNotEqualTo(Double value) {
            addCriterion("out_hous <>", value, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousGreaterThan(Double value) {
            addCriterion("out_hous >", value, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousGreaterThanOrEqualTo(Double value) {
            addCriterion("out_hous >=", value, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousLessThan(Double value) {
            addCriterion("out_hous <", value, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousLessThanOrEqualTo(Double value) {
            addCriterion("out_hous <=", value, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousIn(java.util.List<java.lang.Double> values) {
            addCriterion("out_hous in", values, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("out_hous not in", values, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousBetween(Double value1, Double value2) {
            addCriterion("out_hous between", value1, value2, "outHous");
            return (Criteria) this;
        }

        public Criteria andOutHousNotBetween(Double value1, Double value2) {
            addCriterion("out_hous not between", value1, value2, "outHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousIsNull() {
            addCriterion("work_hous is null");
            return (Criteria) this;
        }

        public Criteria andWorkHousIsNotNull() {
            addCriterion("work_hous is not null");
            return (Criteria) this;
        }

        public Criteria andWorkHousEqualTo(Double value) {
            addCriterion("work_hous =", value, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousNotEqualTo(Double value) {
            addCriterion("work_hous <>", value, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousGreaterThan(Double value) {
            addCriterion("work_hous >", value, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousGreaterThanOrEqualTo(Double value) {
            addCriterion("work_hous >=", value, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousLessThan(Double value) {
            addCriterion("work_hous <", value, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousLessThanOrEqualTo(Double value) {
            addCriterion("work_hous <=", value, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousIn(java.util.List<java.lang.Double> values) {
            addCriterion("work_hous in", values, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("work_hous not in", values, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousBetween(Double value1, Double value2) {
            addCriterion("work_hous between", value1, value2, "workHous");
            return (Criteria) this;
        }

        public Criteria andWorkHousNotBetween(Double value1, Double value2) {
            addCriterion("work_hous not between", value1, value2, "workHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousIsNull() {
            addCriterion("leave_hous is null");
            return (Criteria) this;
        }

        public Criteria andLeaveHousIsNotNull() {
            addCriterion("leave_hous is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveHousEqualTo(Double value) {
            addCriterion("leave_hous =", value, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousNotEqualTo(Double value) {
            addCriterion("leave_hous <>", value, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousGreaterThan(Double value) {
            addCriterion("leave_hous >", value, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousGreaterThanOrEqualTo(Double value) {
            addCriterion("leave_hous >=", value, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousLessThan(Double value) {
            addCriterion("leave_hous <", value, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousLessThanOrEqualTo(Double value) {
            addCriterion("leave_hous <=", value, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousIn(java.util.List<java.lang.Double> values) {
            addCriterion("leave_hous in", values, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("leave_hous not in", values, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousBetween(Double value1, Double value2) {
            addCriterion("leave_hous between", value1, value2, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andLeaveHousNotBetween(Double value1, Double value2) {
            addCriterion("leave_hous not between", value1, value2, "leaveHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousIsNull() {
            addCriterion("travel_hous is null");
            return (Criteria) this;
        }

        public Criteria andTravelHousIsNotNull() {
            addCriterion("travel_hous is not null");
            return (Criteria) this;
        }

        public Criteria andTravelHousEqualTo(Double value) {
            addCriterion("travel_hous =", value, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousNotEqualTo(Double value) {
            addCriterion("travel_hous <>", value, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousGreaterThan(Double value) {
            addCriterion("travel_hous >", value, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousGreaterThanOrEqualTo(Double value) {
            addCriterion("travel_hous >=", value, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousLessThan(Double value) {
            addCriterion("travel_hous <", value, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousLessThanOrEqualTo(Double value) {
            addCriterion("travel_hous <=", value, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousIn(java.util.List<java.lang.Double> values) {
            addCriterion("travel_hous in", values, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("travel_hous not in", values, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousBetween(Double value1, Double value2) {
            addCriterion("travel_hous between", value1, value2, "travelHous");
            return (Criteria) this;
        }

        public Criteria andTravelHousNotBetween(Double value1, Double value2) {
            addCriterion("travel_hous not between", value1, value2, "travelHous");
            return (Criteria) this;
        }

        public Criteria andLateHourIsNull() {
            addCriterion("late_hour is null");
            return (Criteria) this;
        }

        public Criteria andLateHourIsNotNull() {
            addCriterion("late_hour is not null");
            return (Criteria) this;
        }

        public Criteria andLateHourEqualTo(Double value) {
            addCriterion("late_hour =", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourNotEqualTo(Double value) {
            addCriterion("late_hour <>", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourGreaterThan(Double value) {
            addCriterion("late_hour >", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourGreaterThanOrEqualTo(Double value) {
            addCriterion("late_hour >=", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourLessThan(Double value) {
            addCriterion("late_hour <", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourLessThanOrEqualTo(Double value) {
            addCriterion("late_hour <=", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourIn(java.util.List<java.lang.Double> values) {
            addCriterion("late_hour in", values, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("late_hour not in", values, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourBetween(Double value1, Double value2) {
            addCriterion("late_hour between", value1, value2, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourNotBetween(Double value1, Double value2) {
            addCriterion("late_hour not between", value1, value2, "lateHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourIsNull() {
            addCriterion("early_hour is null");
            return (Criteria) this;
        }

        public Criteria andEarlyHourIsNotNull() {
            addCriterion("early_hour is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyHourEqualTo(Double value) {
            addCriterion("early_hour =", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourNotEqualTo(Double value) {
            addCriterion("early_hour <>", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourGreaterThan(Double value) {
            addCriterion("early_hour >", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourGreaterThanOrEqualTo(Double value) {
            addCriterion("early_hour >=", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourLessThan(Double value) {
            addCriterion("early_hour <", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourLessThanOrEqualTo(Double value) {
            addCriterion("early_hour <=", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourIn(java.util.List<java.lang.Double> values) {
            addCriterion("early_hour in", values, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("early_hour not in", values, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourBetween(Double value1, Double value2) {
            addCriterion("early_hour between", value1, value2, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourNotBetween(Double value1, Double value2) {
            addCriterion("early_hour not between", value1, value2, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andMinerCountIsNull() {
            addCriterion("miner_count is null");
            return (Criteria) this;
        }

        public Criteria andMinerCountIsNotNull() {
            addCriterion("miner_count is not null");
            return (Criteria) this;
        }

        public Criteria andMinerCountEqualTo(Integer value) {
            addCriterion("miner_count =", value, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountNotEqualTo(Integer value) {
            addCriterion("miner_count <>", value, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountGreaterThan(Integer value) {
            addCriterion("miner_count >", value, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("miner_count >=", value, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountLessThan(Integer value) {
            addCriterion("miner_count <", value, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountLessThanOrEqualTo(Integer value) {
            addCriterion("miner_count <=", value, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("miner_count in", values, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("miner_count not in", values, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountBetween(Integer value1, Integer value2) {
            addCriterion("miner_count between", value1, value2, "minerCount");
            return (Criteria) this;
        }

        public Criteria andMinerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("miner_count not between", value1, value2, "minerCount");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
    b_punch_attendance_staticsaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}