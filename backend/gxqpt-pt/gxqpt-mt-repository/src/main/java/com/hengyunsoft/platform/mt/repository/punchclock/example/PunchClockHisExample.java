package com.hengyunsoft.platform.mt.repository.punchclock.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PunchClockHisExample extends com.hengyunsoft.db.example.BaseExample<PunchClockHisExample.Criteria> implements Serializable {
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

        public Criteria andClockTypeIsNull() {
            addCriterion("clock_type is null");
            return (Criteria) this;
        }

        public Criteria andClockTypeIsNotNull() {
            addCriterion("clock_type is not null");
            return (Criteria) this;
        }

        public Criteria andClockTypeEqualTo(Integer value) {
            addCriterion("clock_type =", value, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeNotEqualTo(Integer value) {
            addCriterion("clock_type <>", value, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeGreaterThan(Integer value) {
            addCriterion("clock_type >", value, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("clock_type >=", value, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeLessThan(Integer value) {
            addCriterion("clock_type <", value, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeLessThanOrEqualTo(Integer value) {
            addCriterion("clock_type <=", value, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("clock_type in", values, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("clock_type not in", values, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeBetween(Integer value1, Integer value2) {
            addCriterion("clock_type between", value1, value2, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("clock_type not between", value1, value2, "clockType");
            return (Criteria) this;
        }

        public Criteria andClockDateIsNull() {
            addCriterion("clock_date is null");
            return (Criteria) this;
        }

        public Criteria andClockDateIsNotNull() {
            addCriterion("clock_date is not null");
            return (Criteria) this;
        }

        public Criteria andClockDateEqualTo(Date value) {
            addCriterionForJDBCDate("clock_date =", value, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("clock_date <>", value, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateGreaterThan(Date value) {
            addCriterionForJDBCDate("clock_date >", value, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clock_date >=", value, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateLessThan(Date value) {
            addCriterionForJDBCDate("clock_date <", value, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clock_date <=", value, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateIn(java.util.List<java.util.Date> values) {
            addCriterionForJDBCDate("clock_date in", values, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateNotIn(java.util.List<java.util.Date> values) {
            addCriterionForJDBCDate("clock_date not in", values, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clock_date between", value1, value2, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clock_date not between", value1, value2, "clockDate");
            return (Criteria) this;
        }

        public Criteria andClockTimeIsNull() {
            addCriterion("clock_time is null");
            return (Criteria) this;
        }

        public Criteria andClockTimeIsNotNull() {
            addCriterion("clock_time is not null");
            return (Criteria) this;
        }

        public Criteria andClockTimeEqualTo(Date value) {
            addCriterion("clock_time =", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotEqualTo(Date value) {
            addCriterion("clock_time <>", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeGreaterThan(Date value) {
            addCriterion("clock_time >", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("clock_time >=", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeLessThan(Date value) {
            addCriterion("clock_time <", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeLessThanOrEqualTo(Date value) {
            addCriterion("clock_time <=", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("clock_time in", values, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("clock_time not in", values, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeBetween(Date value1, Date value2) {
            addCriterion("clock_time between", value1, value2, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotBetween(Date value1, Date value2) {
            addCriterion("clock_time not between", value1, value2, "clockTime");
            return (Criteria) this;
        }

        public Criteria andAdceTypeIsNull() {
            addCriterion("adce_type is null");
            return (Criteria) this;
        }

        public Criteria andAdceTypeIsNotNull() {
            addCriterion("adce_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdceTypeEqualTo(Integer value) {
            addCriterion("adce_type =", value, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeNotEqualTo(Integer value) {
            addCriterion("adce_type <>", value, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeGreaterThan(Integer value) {
            addCriterion("adce_type >", value, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("adce_type >=", value, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeLessThan(Integer value) {
            addCriterion("adce_type <", value, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("adce_type <=", value, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("adce_type in", values, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("adce_type not in", values, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeBetween(Integer value1, Integer value2) {
            addCriterion("adce_type between", value1, value2, "adceType");
            return (Criteria) this;
        }

        public Criteria andAdceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("adce_type not between", value1, value2, "adceType");
            return (Criteria) this;
        }

        public Criteria andLateReasonIsNull() {
            addCriterion("late_reason is null");
            return (Criteria) this;
        }

        public Criteria andLateReasonIsNotNull() {
            addCriterion("late_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLateReasonEqualTo(String value) {
            addCriterion("late_reason =", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotEqualTo(String value) {
            addCriterion("late_reason <>", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonGreaterThan(String value) {
            addCriterion("late_reason >", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonGreaterThanOrEqualTo(String value) {
            addCriterion("late_reason >=", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonLessThan(String value) {
            addCriterion("late_reason <", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonLessThanOrEqualTo(String value) {
            addCriterion("late_reason <=", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonLike(String value) {
            addCriterion("late_reason like", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotLike(String value) {
            addCriterion("late_reason not like", value, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonIn(java.util.List<java.lang.String> values) {
            addCriterion("late_reason in", values, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("late_reason not in", values, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonBetween(String value1, String value2) {
            addCriterion("late_reason between", value1, value2, "lateReason");
            return (Criteria) this;
        }

        public Criteria andLateReasonNotBetween(String value1, String value2) {
            addCriterion("late_reason not between", value1, value2, "lateReason");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOutterReasonIsNull() {
            addCriterion("outter_reason is null");
            return (Criteria) this;
        }

        public Criteria andOutterReasonIsNotNull() {
            addCriterion("outter_reason is not null");
            return (Criteria) this;
        }

        public Criteria andOutterReasonEqualTo(String value) {
            addCriterion("outter_reason =", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonNotEqualTo(String value) {
            addCriterion("outter_reason <>", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonGreaterThan(String value) {
            addCriterion("outter_reason >", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonGreaterThanOrEqualTo(String value) {
            addCriterion("outter_reason >=", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonLessThan(String value) {
            addCriterion("outter_reason <", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonLessThanOrEqualTo(String value) {
            addCriterion("outter_reason <=", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonLike(String value) {
            addCriterion("outter_reason like", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonNotLike(String value) {
            addCriterion("outter_reason not like", value, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonIn(java.util.List<java.lang.String> values) {
            addCriterion("outter_reason in", values, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("outter_reason not in", values, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonBetween(String value1, String value2) {
            addCriterion("outter_reason between", value1, value2, "outterReason");
            return (Criteria) this;
        }

        public Criteria andOutterReasonNotBetween(String value1, String value2) {
            addCriterion("outter_reason not between", value1, value2, "outterReason");
            return (Criteria) this;
        }

        public Criteria andAutoFlagIsNull() {
            addCriterion("auto_flag is null");
            return (Criteria) this;
        }

        public Criteria andAutoFlagIsNotNull() {
            addCriterion("auto_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFlagEqualTo(Integer value) {
            addCriterion("auto_flag =", value, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagNotEqualTo(Integer value) {
            addCriterion("auto_flag <>", value, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagGreaterThan(Integer value) {
            addCriterion("auto_flag >", value, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_flag >=", value, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagLessThan(Integer value) {
            addCriterion("auto_flag <", value, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagLessThanOrEqualTo(Integer value) {
            addCriterion("auto_flag <=", value, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_flag in", values, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_flag not in", values, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagBetween(Integer value1, Integer value2) {
            addCriterion("auto_flag between", value1, value2, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_flag not between", value1, value2, "autoFlag");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(java.util.List<java.lang.String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(java.util.List<java.lang.String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(java.util.List<java.lang.String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(java.util.List<java.lang.String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(java.util.List<java.lang.String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
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
    b_punch_clock_hisaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}