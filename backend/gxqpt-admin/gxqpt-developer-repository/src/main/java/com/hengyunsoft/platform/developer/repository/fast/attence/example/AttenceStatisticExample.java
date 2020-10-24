package com.hengyunsoft.platform.developer.repository.fast.attence.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AttenceStatisticExample extends com.hengyunsoft.db.example.BaseExample<AttenceStatisticExample.Criteria> implements Serializable {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
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

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andWorkDateIsNull() {
            addCriterion("work_date is null");
            return (Criteria) this;
        }

        public Criteria andWorkDateIsNotNull() {
            addCriterion("work_date is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDateEqualTo(Date value) {
            addCriterionForJDBCDate("work_date =", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("work_date <>", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThan(Date value) {
            addCriterionForJDBCDate("work_date >", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_date >=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThan(Date value) {
            addCriterionForJDBCDate("work_date <", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_date <=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateIn(java.util.List<java.util.Date> values) {
            addCriterionForJDBCDate("work_date in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotIn(java.util.List<java.util.Date> values) {
            addCriterionForJDBCDate("work_date not in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_date between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_date not between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andExtraWorkIsNull() {
            addCriterion("extra_work is null");
            return (Criteria) this;
        }

        public Criteria andExtraWorkIsNotNull() {
            addCriterion("extra_work is not null");
            return (Criteria) this;
        }

        public Criteria andExtraWorkEqualTo(Float value) {
            addCriterion("extra_work =", value, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkNotEqualTo(Float value) {
            addCriterion("extra_work <>", value, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkGreaterThan(Float value) {
            addCriterion("extra_work >", value, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkGreaterThanOrEqualTo(Float value) {
            addCriterion("extra_work >=", value, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkLessThan(Float value) {
            addCriterion("extra_work <", value, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkLessThanOrEqualTo(Float value) {
            addCriterion("extra_work <=", value, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkIn(java.util.List<java.lang.Float> values) {
            addCriterion("extra_work in", values, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("extra_work not in", values, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkBetween(Float value1, Float value2) {
            addCriterion("extra_work between", value1, value2, "extraWork");
            return (Criteria) this;
        }

        public Criteria andExtraWorkNotBetween(Float value1, Float value2) {
            addCriterion("extra_work not between", value1, value2, "extraWork");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIsNull() {
            addCriterion("sick_leave is null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIsNotNull() {
            addCriterion("sick_leave is not null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveEqualTo(Float value) {
            addCriterion("sick_leave =", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotEqualTo(Float value) {
            addCriterion("sick_leave <>", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveGreaterThan(Float value) {
            addCriterion("sick_leave >", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("sick_leave >=", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveLessThan(Float value) {
            addCriterion("sick_leave <", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveLessThanOrEqualTo(Float value) {
            addCriterion("sick_leave <=", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("sick_leave in", values, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("sick_leave not in", values, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveBetween(Float value1, Float value2) {
            addCriterion("sick_leave between", value1, value2, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotBetween(Float value1, Float value2) {
            addCriterion("sick_leave not between", value1, value2, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveIsNull() {
            addCriterion("affair_leave is null");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveIsNotNull() {
            addCriterion("affair_leave is not null");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveEqualTo(Float value) {
            addCriterion("affair_leave =", value, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveNotEqualTo(Float value) {
            addCriterion("affair_leave <>", value, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveGreaterThan(Float value) {
            addCriterion("affair_leave >", value, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("affair_leave >=", value, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveLessThan(Float value) {
            addCriterion("affair_leave <", value, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveLessThanOrEqualTo(Float value) {
            addCriterion("affair_leave <=", value, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("affair_leave in", values, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("affair_leave not in", values, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveBetween(Float value1, Float value2) {
            addCriterion("affair_leave between", value1, value2, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAffairLeaveNotBetween(Float value1, Float value2) {
            addCriterion("affair_leave not between", value1, value2, "affairLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIsNull() {
            addCriterion("annual_leave is null");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIsNotNull() {
            addCriterion("annual_leave is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveEqualTo(Float value) {
            addCriterion("annual_leave =", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotEqualTo(Float value) {
            addCriterion("annual_leave <>", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveGreaterThan(Float value) {
            addCriterion("annual_leave >", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("annual_leave >=", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveLessThan(Float value) {
            addCriterion("annual_leave <", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveLessThanOrEqualTo(Float value) {
            addCriterion("annual_leave <=", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("annual_leave in", values, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("annual_leave not in", values, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveBetween(Float value1, Float value2) {
            addCriterion("annual_leave between", value1, value2, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotBetween(Float value1, Float value2) {
            addCriterion("annual_leave not between", value1, value2, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveIsNull() {
            addCriterion("home_leave is null");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveIsNotNull() {
            addCriterion("home_leave is not null");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveEqualTo(Float value) {
            addCriterion("home_leave =", value, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveNotEqualTo(Float value) {
            addCriterion("home_leave <>", value, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveGreaterThan(Float value) {
            addCriterion("home_leave >", value, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("home_leave >=", value, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveLessThan(Float value) {
            addCriterion("home_leave <", value, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveLessThanOrEqualTo(Float value) {
            addCriterion("home_leave <=", value, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("home_leave in", values, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("home_leave not in", values, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveBetween(Float value1, Float value2) {
            addCriterion("home_leave between", value1, value2, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andHomeLeaveNotBetween(Float value1, Float value2) {
            addCriterion("home_leave not between", value1, value2, "homeLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveIsNull() {
            addCriterion("marital_leave is null");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveIsNotNull() {
            addCriterion("marital_leave is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveEqualTo(Float value) {
            addCriterion("marital_leave =", value, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveNotEqualTo(Float value) {
            addCriterion("marital_leave <>", value, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveGreaterThan(Float value) {
            addCriterion("marital_leave >", value, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("marital_leave >=", value, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveLessThan(Float value) {
            addCriterion("marital_leave <", value, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveLessThanOrEqualTo(Float value) {
            addCriterion("marital_leave <=", value, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("marital_leave in", values, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("marital_leave not in", values, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveBetween(Float value1, Float value2) {
            addCriterion("marital_leave between", value1, value2, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andMaritalLeaveNotBetween(Float value1, Float value2) {
            addCriterion("marital_leave not between", value1, value2, "maritalLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIsNull() {
            addCriterion("funeral_leave is null");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIsNotNull() {
            addCriterion("funeral_leave is not null");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveEqualTo(Float value) {
            addCriterion("funeral_leave =", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotEqualTo(Float value) {
            addCriterion("funeral_leave <>", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveGreaterThan(Float value) {
            addCriterion("funeral_leave >", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("funeral_leave >=", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveLessThan(Float value) {
            addCriterion("funeral_leave <", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveLessThanOrEqualTo(Float value) {
            addCriterion("funeral_leave <=", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("funeral_leave in", values, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("funeral_leave not in", values, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveBetween(Float value1, Float value2) {
            addCriterion("funeral_leave between", value1, value2, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotBetween(Float value1, Float value2) {
            addCriterion("funeral_leave not between", value1, value2, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIsNull() {
            addCriterion("maternity_leave is null");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIsNotNull() {
            addCriterion("maternity_leave is not null");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveEqualTo(Float value) {
            addCriterion("maternity_leave =", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotEqualTo(Float value) {
            addCriterion("maternity_leave <>", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveGreaterThan(Float value) {
            addCriterion("maternity_leave >", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("maternity_leave >=", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveLessThan(Float value) {
            addCriterion("maternity_leave <", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveLessThanOrEqualTo(Float value) {
            addCriterion("maternity_leave <=", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("maternity_leave in", values, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("maternity_leave not in", values, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveBetween(Float value1, Float value2) {
            addCriterion("maternity_leave between", value1, value2, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotBetween(Float value1, Float value2) {
            addCriterion("maternity_leave not between", value1, value2, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveIsNull() {
            addCriterion("expatriate_leave is null");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveIsNotNull() {
            addCriterion("expatriate_leave is not null");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveEqualTo(Float value) {
            addCriterion("expatriate_leave =", value, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveNotEqualTo(Float value) {
            addCriterion("expatriate_leave <>", value, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveGreaterThan(Float value) {
            addCriterion("expatriate_leave >", value, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveGreaterThanOrEqualTo(Float value) {
            addCriterion("expatriate_leave >=", value, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveLessThan(Float value) {
            addCriterion("expatriate_leave <", value, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveLessThanOrEqualTo(Float value) {
            addCriterion("expatriate_leave <=", value, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveIn(java.util.List<java.lang.Float> values) {
            addCriterion("expatriate_leave in", values, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("expatriate_leave not in", values, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveBetween(Float value1, Float value2) {
            addCriterion("expatriate_leave between", value1, value2, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andExpatriateLeaveNotBetween(Float value1, Float value2) {
            addCriterion("expatriate_leave not between", value1, value2, "expatriateLeave");
            return (Criteria) this;
        }

        public Criteria andOutsideHourIsNull() {
            addCriterion("outside_hour is null");
            return (Criteria) this;
        }

        public Criteria andOutsideHourIsNotNull() {
            addCriterion("outside_hour is not null");
            return (Criteria) this;
        }

        public Criteria andOutsideHourEqualTo(Float value) {
            addCriterion("outside_hour =", value, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourNotEqualTo(Float value) {
            addCriterion("outside_hour <>", value, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourGreaterThan(Float value) {
            addCriterion("outside_hour >", value, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourGreaterThanOrEqualTo(Float value) {
            addCriterion("outside_hour >=", value, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourLessThan(Float value) {
            addCriterion("outside_hour <", value, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourLessThanOrEqualTo(Float value) {
            addCriterion("outside_hour <=", value, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("outside_hour in", values, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("outside_hour not in", values, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourBetween(Float value1, Float value2) {
            addCriterion("outside_hour between", value1, value2, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andOutsideHourNotBetween(Float value1, Float value2) {
            addCriterion("outside_hour not between", value1, value2, "outsideHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourIsNull() {
            addCriterion("neglect_hour is null");
            return (Criteria) this;
        }

        public Criteria andNeglectHourIsNotNull() {
            addCriterion("neglect_hour is not null");
            return (Criteria) this;
        }

        public Criteria andNeglectHourEqualTo(Float value) {
            addCriterion("neglect_hour =", value, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourNotEqualTo(Float value) {
            addCriterion("neglect_hour <>", value, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourGreaterThan(Float value) {
            addCriterion("neglect_hour >", value, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourGreaterThanOrEqualTo(Float value) {
            addCriterion("neglect_hour >=", value, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourLessThan(Float value) {
            addCriterion("neglect_hour <", value, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourLessThanOrEqualTo(Float value) {
            addCriterion("neglect_hour <=", value, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("neglect_hour in", values, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("neglect_hour not in", values, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourBetween(Float value1, Float value2) {
            addCriterion("neglect_hour between", value1, value2, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectHourNotBetween(Float value1, Float value2) {
            addCriterion("neglect_hour not between", value1, value2, "neglectHour");
            return (Criteria) this;
        }

        public Criteria andNeglectNumIsNull() {
            addCriterion("neglect_num is null");
            return (Criteria) this;
        }

        public Criteria andNeglectNumIsNotNull() {
            addCriterion("neglect_num is not null");
            return (Criteria) this;
        }

        public Criteria andNeglectNumEqualTo(Integer value) {
            addCriterion("neglect_num =", value, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumNotEqualTo(Integer value) {
            addCriterion("neglect_num <>", value, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumGreaterThan(Integer value) {
            addCriterion("neglect_num >", value, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("neglect_num >=", value, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumLessThan(Integer value) {
            addCriterion("neglect_num <", value, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumLessThanOrEqualTo(Integer value) {
            addCriterion("neglect_num <=", value, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("neglect_num in", values, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("neglect_num not in", values, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumBetween(Integer value1, Integer value2) {
            addCriterion("neglect_num between", value1, value2, "neglectNum");
            return (Criteria) this;
        }

        public Criteria andNeglectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("neglect_num not between", value1, value2, "neglectNum");
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

        public Criteria andLateHourEqualTo(Float value) {
            addCriterion("late_hour =", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourNotEqualTo(Float value) {
            addCriterion("late_hour <>", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourGreaterThan(Float value) {
            addCriterion("late_hour >", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourGreaterThanOrEqualTo(Float value) {
            addCriterion("late_hour >=", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourLessThan(Float value) {
            addCriterion("late_hour <", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourLessThanOrEqualTo(Float value) {
            addCriterion("late_hour <=", value, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("late_hour in", values, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("late_hour not in", values, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourBetween(Float value1, Float value2) {
            addCriterion("late_hour between", value1, value2, "lateHour");
            return (Criteria) this;
        }

        public Criteria andLateHourNotBetween(Float value1, Float value2) {
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

        public Criteria andEarlyHourEqualTo(Float value) {
            addCriterion("early_hour =", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourNotEqualTo(Float value) {
            addCriterion("early_hour <>", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourGreaterThan(Float value) {
            addCriterion("early_hour >", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourGreaterThanOrEqualTo(Float value) {
            addCriterion("early_hour >=", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourLessThan(Float value) {
            addCriterion("early_hour <", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourLessThanOrEqualTo(Float value) {
            addCriterion("early_hour <=", value, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("early_hour in", values, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("early_hour not in", values, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourBetween(Float value1, Float value2) {
            addCriterion("early_hour between", value1, value2, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andEarlyHourNotBetween(Float value1, Float value2) {
            addCriterion("early_hour not between", value1, value2, "earlyHour");
            return (Criteria) this;
        }

        public Criteria andActualHourIsNull() {
            addCriterion("actual_hour is null");
            return (Criteria) this;
        }

        public Criteria andActualHourIsNotNull() {
            addCriterion("actual_hour is not null");
            return (Criteria) this;
        }

        public Criteria andActualHourEqualTo(Float value) {
            addCriterion("actual_hour =", value, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourNotEqualTo(Float value) {
            addCriterion("actual_hour <>", value, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourGreaterThan(Float value) {
            addCriterion("actual_hour >", value, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourGreaterThanOrEqualTo(Float value) {
            addCriterion("actual_hour >=", value, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourLessThan(Float value) {
            addCriterion("actual_hour <", value, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourLessThanOrEqualTo(Float value) {
            addCriterion("actual_hour <=", value, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("actual_hour in", values, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("actual_hour not in", values, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourBetween(Float value1, Float value2) {
            addCriterion("actual_hour between", value1, value2, "actualHour");
            return (Criteria) this;
        }

        public Criteria andActualHourNotBetween(Float value1, Float value2) {
            addCriterion("actual_hour not between", value1, value2, "actualHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourIsNull() {
            addCriterion("business_hour is null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourIsNotNull() {
            addCriterion("business_hour is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourEqualTo(Float value) {
            addCriterion("business_hour =", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourNotEqualTo(Float value) {
            addCriterion("business_hour <>", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourGreaterThan(Float value) {
            addCriterion("business_hour >", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourGreaterThanOrEqualTo(Float value) {
            addCriterion("business_hour >=", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourLessThan(Float value) {
            addCriterion("business_hour <", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourLessThanOrEqualTo(Float value) {
            addCriterion("business_hour <=", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("business_hour in", values, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("business_hour not in", values, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourBetween(Float value1, Float value2) {
            addCriterion("business_hour between", value1, value2, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourNotBetween(Float value1, Float value2) {
            addCriterion("business_hour not between", value1, value2, "businessHour");
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
    }

    /**
    b_attence_statisticaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}