package com.hengyunsoft.platform.mt.repository.punchclock.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PunchClockExample extends com.hengyunsoft.db.example.BaseExample<PunchClockExample.Criteria> implements Serializable {
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

        public Criteria andSignInTimeIsNull() {
            addCriterion("sign_in_time is null");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIsNotNull() {
            addCriterion("sign_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignInTimeEqualTo(Date value) {
            addCriterion("sign_in_time =", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotEqualTo(Date value) {
            addCriterion("sign_in_time <>", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeGreaterThan(Date value) {
            addCriterion("sign_in_time >", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_in_time >=", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeLessThan(Date value) {
            addCriterion("sign_in_time <", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_in_time <=", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("sign_in_time in", values, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("sign_in_time not in", values, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeBetween(Date value1, Date value2) {
            addCriterion("sign_in_time between", value1, value2, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_in_time not between", value1, value2, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeIsNull() {
            addCriterion("sign_off_time is null");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeIsNotNull() {
            addCriterion("sign_off_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeEqualTo(Date value) {
            addCriterion("sign_off_time =", value, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeNotEqualTo(Date value) {
            addCriterion("sign_off_time <>", value, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeGreaterThan(Date value) {
            addCriterion("sign_off_time >", value, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_off_time >=", value, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeLessThan(Date value) {
            addCriterion("sign_off_time <", value, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_off_time <=", value, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("sign_off_time in", values, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("sign_off_time not in", values, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeBetween(Date value1, Date value2) {
            addCriterion("sign_off_time between", value1, value2, "signOffTime");
            return (Criteria) this;
        }

        public Criteria andSignOffTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_off_time not between", value1, value2, "signOffTime");
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

        public Criteria andAutoSignInFlagIsNull() {
            addCriterion("auto_sign_in_flag is null");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagIsNotNull() {
            addCriterion("auto_sign_in_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagEqualTo(Integer value) {
            addCriterion("auto_sign_in_flag =", value, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagNotEqualTo(Integer value) {
            addCriterion("auto_sign_in_flag <>", value, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagGreaterThan(Integer value) {
            addCriterion("auto_sign_in_flag >", value, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_sign_in_flag >=", value, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagLessThan(Integer value) {
            addCriterion("auto_sign_in_flag <", value, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagLessThanOrEqualTo(Integer value) {
            addCriterion("auto_sign_in_flag <=", value, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_sign_in_flag in", values, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_sign_in_flag not in", values, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagBetween(Integer value1, Integer value2) {
            addCriterion("auto_sign_in_flag between", value1, value2, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignInFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_sign_in_flag not between", value1, value2, "autoSignInFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagIsNull() {
            addCriterion("auto_sign_off_flag is null");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagIsNotNull() {
            addCriterion("auto_sign_off_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagEqualTo(Integer value) {
            addCriterion("auto_sign_off_flag =", value, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagNotEqualTo(Integer value) {
            addCriterion("auto_sign_off_flag <>", value, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagGreaterThan(Integer value) {
            addCriterion("auto_sign_off_flag >", value, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_sign_off_flag >=", value, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagLessThan(Integer value) {
            addCriterion("auto_sign_off_flag <", value, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagLessThanOrEqualTo(Integer value) {
            addCriterion("auto_sign_off_flag <=", value, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_sign_off_flag in", values, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("auto_sign_off_flag not in", values, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagBetween(Integer value1, Integer value2) {
            addCriterion("auto_sign_off_flag between", value1, value2, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andAutoSignOffFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_sign_off_flag not between", value1, value2, "autoSignOffFlag");
            return (Criteria) this;
        }

        public Criteria andSignInLngIsNull() {
            addCriterion("sign_in_lng is null");
            return (Criteria) this;
        }

        public Criteria andSignInLngIsNotNull() {
            addCriterion("sign_in_lng is not null");
            return (Criteria) this;
        }

        public Criteria andSignInLngEqualTo(String value) {
            addCriterion("sign_in_lng =", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngNotEqualTo(String value) {
            addCriterion("sign_in_lng <>", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngGreaterThan(String value) {
            addCriterion("sign_in_lng >", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngGreaterThanOrEqualTo(String value) {
            addCriterion("sign_in_lng >=", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngLessThan(String value) {
            addCriterion("sign_in_lng <", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngLessThanOrEqualTo(String value) {
            addCriterion("sign_in_lng <=", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngLike(String value) {
            addCriterion("sign_in_lng like", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngNotLike(String value) {
            addCriterion("sign_in_lng not like", value, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_in_lng in", values, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_in_lng not in", values, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngBetween(String value1, String value2) {
            addCriterion("sign_in_lng between", value1, value2, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLngNotBetween(String value1, String value2) {
            addCriterion("sign_in_lng not between", value1, value2, "signInLng");
            return (Criteria) this;
        }

        public Criteria andSignInLatIsNull() {
            addCriterion("sign_in_lat is null");
            return (Criteria) this;
        }

        public Criteria andSignInLatIsNotNull() {
            addCriterion("sign_in_lat is not null");
            return (Criteria) this;
        }

        public Criteria andSignInLatEqualTo(String value) {
            addCriterion("sign_in_lat =", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatNotEqualTo(String value) {
            addCriterion("sign_in_lat <>", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatGreaterThan(String value) {
            addCriterion("sign_in_lat >", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatGreaterThanOrEqualTo(String value) {
            addCriterion("sign_in_lat >=", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatLessThan(String value) {
            addCriterion("sign_in_lat <", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatLessThanOrEqualTo(String value) {
            addCriterion("sign_in_lat <=", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatLike(String value) {
            addCriterion("sign_in_lat like", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatNotLike(String value) {
            addCriterion("sign_in_lat not like", value, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_in_lat in", values, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_in_lat not in", values, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatBetween(String value1, String value2) {
            addCriterion("sign_in_lat between", value1, value2, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignInLatNotBetween(String value1, String value2) {
            addCriterion("sign_in_lat not between", value1, value2, "signInLat");
            return (Criteria) this;
        }

        public Criteria andSignLocationIsNull() {
            addCriterion("sign_location is null");
            return (Criteria) this;
        }

        public Criteria andSignLocationIsNotNull() {
            addCriterion("sign_location is not null");
            return (Criteria) this;
        }

        public Criteria andSignLocationEqualTo(String value) {
            addCriterion("sign_location =", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationNotEqualTo(String value) {
            addCriterion("sign_location <>", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationGreaterThan(String value) {
            addCriterion("sign_location >", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationGreaterThanOrEqualTo(String value) {
            addCriterion("sign_location >=", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationLessThan(String value) {
            addCriterion("sign_location <", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationLessThanOrEqualTo(String value) {
            addCriterion("sign_location <=", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationLike(String value) {
            addCriterion("sign_location like", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationNotLike(String value) {
            addCriterion("sign_location not like", value, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_location in", values, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_location not in", values, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationBetween(String value1, String value2) {
            addCriterion("sign_location between", value1, value2, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignLocationNotBetween(String value1, String value2) {
            addCriterion("sign_location not between", value1, value2, "signLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLngIsNull() {
            addCriterion("sign_off_lng is null");
            return (Criteria) this;
        }

        public Criteria andSignOffLngIsNotNull() {
            addCriterion("sign_off_lng is not null");
            return (Criteria) this;
        }

        public Criteria andSignOffLngEqualTo(String value) {
            addCriterion("sign_off_lng =", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngNotEqualTo(String value) {
            addCriterion("sign_off_lng <>", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngGreaterThan(String value) {
            addCriterion("sign_off_lng >", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngGreaterThanOrEqualTo(String value) {
            addCriterion("sign_off_lng >=", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngLessThan(String value) {
            addCriterion("sign_off_lng <", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngLessThanOrEqualTo(String value) {
            addCriterion("sign_off_lng <=", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngLike(String value) {
            addCriterion("sign_off_lng like", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngNotLike(String value) {
            addCriterion("sign_off_lng not like", value, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_off_lng in", values, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_off_lng not in", values, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngBetween(String value1, String value2) {
            addCriterion("sign_off_lng between", value1, value2, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLngNotBetween(String value1, String value2) {
            addCriterion("sign_off_lng not between", value1, value2, "signOffLng");
            return (Criteria) this;
        }

        public Criteria andSignOffLatIsNull() {
            addCriterion("sign_off_lat is null");
            return (Criteria) this;
        }

        public Criteria andSignOffLatIsNotNull() {
            addCriterion("sign_off_lat is not null");
            return (Criteria) this;
        }

        public Criteria andSignOffLatEqualTo(String value) {
            addCriterion("sign_off_lat =", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatNotEqualTo(String value) {
            addCriterion("sign_off_lat <>", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatGreaterThan(String value) {
            addCriterion("sign_off_lat >", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatGreaterThanOrEqualTo(String value) {
            addCriterion("sign_off_lat >=", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatLessThan(String value) {
            addCriterion("sign_off_lat <", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatLessThanOrEqualTo(String value) {
            addCriterion("sign_off_lat <=", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatLike(String value) {
            addCriterion("sign_off_lat like", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatNotLike(String value) {
            addCriterion("sign_off_lat not like", value, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_off_lat in", values, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_off_lat not in", values, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatBetween(String value1, String value2) {
            addCriterion("sign_off_lat between", value1, value2, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLatNotBetween(String value1, String value2) {
            addCriterion("sign_off_lat not between", value1, value2, "signOffLat");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationIsNull() {
            addCriterion("sign_off_location is null");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationIsNotNull() {
            addCriterion("sign_off_location is not null");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationEqualTo(String value) {
            addCriterion("sign_off_location =", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationNotEqualTo(String value) {
            addCriterion("sign_off_location <>", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationGreaterThan(String value) {
            addCriterion("sign_off_location >", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationGreaterThanOrEqualTo(String value) {
            addCriterion("sign_off_location >=", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationLessThan(String value) {
            addCriterion("sign_off_location <", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationLessThanOrEqualTo(String value) {
            addCriterion("sign_off_location <=", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationLike(String value) {
            addCriterion("sign_off_location like", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationNotLike(String value) {
            addCriterion("sign_off_location not like", value, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_off_location in", values, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sign_off_location not in", values, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationBetween(String value1, String value2) {
            addCriterion("sign_off_location between", value1, value2, "signOffLocation");
            return (Criteria) this;
        }

        public Criteria andSignOffLocationNotBetween(String value1, String value2) {
            addCriterion("sign_off_location not between", value1, value2, "signOffLocation");
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
    b_punch_clockaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}