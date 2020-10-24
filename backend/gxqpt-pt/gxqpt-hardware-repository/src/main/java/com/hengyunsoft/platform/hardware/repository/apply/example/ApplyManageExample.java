package com.hengyunsoft.platform.hardware.repository.apply.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ApplyManageExample extends com.hengyunsoft.db.example.BaseExample<ApplyManageExample.Criteria> implements Serializable {
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

        public Criteria andApplyNoIsNull() {
            addCriterion("apply_no is null");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNotNull() {
            addCriterion("apply_no is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNoEqualTo(String value) {
            addCriterion("apply_no =", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotEqualTo(String value) {
            addCriterion("apply_no <>", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThan(String value) {
            addCriterion("apply_no >", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThanOrEqualTo(String value) {
            addCriterion("apply_no >=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThan(String value) {
            addCriterion("apply_no <", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThanOrEqualTo(String value) {
            addCriterion("apply_no <=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLike(String value) {
            addCriterion("apply_no like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotLike(String value) {
            addCriterion("apply_no not like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_no in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_no not in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoBetween(String value1, String value2) {
            addCriterion("apply_no between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotBetween(String value1, String value2) {
            addCriterion("apply_no not between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidIsNull() {
            addCriterion("apply_orgid is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidIsNotNull() {
            addCriterion("apply_orgid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidEqualTo(String value) {
            addCriterion("apply_orgid =", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidNotEqualTo(String value) {
            addCriterion("apply_orgid <>", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidGreaterThan(String value) {
            addCriterion("apply_orgid >", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidGreaterThanOrEqualTo(String value) {
            addCriterion("apply_orgid >=", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidLessThan(String value) {
            addCriterion("apply_orgid <", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidLessThanOrEqualTo(String value) {
            addCriterion("apply_orgid <=", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidLike(String value) {
            addCriterion("apply_orgid like", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidNotLike(String value) {
            addCriterion("apply_orgid not like", value, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_orgid in", values, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_orgid not in", values, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidBetween(String value1, String value2) {
            addCriterion("apply_orgid between", value1, value2, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgidNotBetween(String value1, String value2) {
            addCriterion("apply_orgid not between", value1, value2, "applyOrgid");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameIsNull() {
            addCriterion("apply_orgname is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameIsNotNull() {
            addCriterion("apply_orgname is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameEqualTo(String value) {
            addCriterion("apply_orgname =", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameNotEqualTo(String value) {
            addCriterion("apply_orgname <>", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameGreaterThan(String value) {
            addCriterion("apply_orgname >", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_orgname >=", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameLessThan(String value) {
            addCriterion("apply_orgname <", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameLessThanOrEqualTo(String value) {
            addCriterion("apply_orgname <=", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameLike(String value) {
            addCriterion("apply_orgname like", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameNotLike(String value) {
            addCriterion("apply_orgname not like", value, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_orgname in", values, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_orgname not in", values, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameBetween(String value1, String value2) {
            addCriterion("apply_orgname between", value1, value2, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyOrgnameNotBetween(String value1, String value2) {
            addCriterion("apply_orgname not between", value1, value2, "applyOrgname");
            return (Criteria) this;
        }

        public Criteria andApplyUidIsNull() {
            addCriterion("apply_uid is null");
            return (Criteria) this;
        }

        public Criteria andApplyUidIsNotNull() {
            addCriterion("apply_uid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUidEqualTo(String value) {
            addCriterion("apply_uid =", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotEqualTo(String value) {
            addCriterion("apply_uid <>", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidGreaterThan(String value) {
            addCriterion("apply_uid >", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidGreaterThanOrEqualTo(String value) {
            addCriterion("apply_uid >=", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidLessThan(String value) {
            addCriterion("apply_uid <", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidLessThanOrEqualTo(String value) {
            addCriterion("apply_uid <=", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidLike(String value) {
            addCriterion("apply_uid like", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotLike(String value) {
            addCriterion("apply_uid not like", value, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uid in", values, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uid not in", values, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidBetween(String value1, String value2) {
            addCriterion("apply_uid between", value1, value2, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUidNotBetween(String value1, String value2) {
            addCriterion("apply_uid not between", value1, value2, "applyUid");
            return (Criteria) this;
        }

        public Criteria andApplyUnameIsNull() {
            addCriterion("apply_uname is null");
            return (Criteria) this;
        }

        public Criteria andApplyUnameIsNotNull() {
            addCriterion("apply_uname is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUnameEqualTo(String value) {
            addCriterion("apply_uname =", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotEqualTo(String value) {
            addCriterion("apply_uname <>", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameGreaterThan(String value) {
            addCriterion("apply_uname >", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_uname >=", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameLessThan(String value) {
            addCriterion("apply_uname <", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameLessThanOrEqualTo(String value) {
            addCriterion("apply_uname <=", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameLike(String value) {
            addCriterion("apply_uname like", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotLike(String value) {
            addCriterion("apply_uname not like", value, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uname in", values, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_uname not in", values, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameBetween(String value1, String value2) {
            addCriterion("apply_uname between", value1, value2, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyUnameNotBetween(String value1, String value2) {
            addCriterion("apply_uname not between", value1, value2, "applyUname");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNull() {
            addCriterion("apply_type is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(String value) {
            addCriterion("apply_type =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(String value) {
            addCriterion("apply_type <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(String value) {
            addCriterion("apply_type >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_type >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(String value) {
            addCriterion("apply_type <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(String value) {
            addCriterion("apply_type <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLike(String value) {
            addCriterion("apply_type like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotLike(String value) {
            addCriterion("apply_type not like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_type in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_type not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(String value1, String value2) {
            addCriterion("apply_type between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(String value1, String value2) {
            addCriterion("apply_type not between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterionForJDBCDate("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(java.util.List<java.util.Date> values) {
            addCriterionForJDBCDate("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterionForJDBCDate("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNull() {
            addCriterion("step_code is null");
            return (Criteria) this;
        }

        public Criteria andStepCodeIsNotNull() {
            addCriterion("step_code is not null");
            return (Criteria) this;
        }

        public Criteria andStepCodeEqualTo(String value) {
            addCriterion("step_code =", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotEqualTo(String value) {
            addCriterion("step_code <>", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThan(String value) {
            addCriterion("step_code >", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("step_code >=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThan(String value) {
            addCriterion("step_code <", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLessThanOrEqualTo(String value) {
            addCriterion("step_code <=", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeLike(String value) {
            addCriterion("step_code like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotLike(String value) {
            addCriterion("step_code not like", value, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("step_code in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("step_code not in", values, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeBetween(String value1, String value2) {
            addCriterion("step_code between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepCodeNotBetween(String value1, String value2) {
            addCriterion("step_code not between", value1, value2, "stepCode");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("step_name is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("step_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("step_name =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("step_name <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("step_name >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_name >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("step_name <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("step_name <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("step_name like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("step_name not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(java.util.List<java.lang.String> values) {
            addCriterion("step_name in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("step_name not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("step_name between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("step_name not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andScodeIsNull() {
            addCriterion("scode is null");
            return (Criteria) this;
        }

        public Criteria andScodeIsNotNull() {
            addCriterion("scode is not null");
            return (Criteria) this;
        }

        public Criteria andScodeEqualTo(String value) {
            addCriterion("scode =", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotEqualTo(String value) {
            addCriterion("scode <>", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeGreaterThan(String value) {
            addCriterion("scode >", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeGreaterThanOrEqualTo(String value) {
            addCriterion("scode >=", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeLessThan(String value) {
            addCriterion("scode <", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeLessThanOrEqualTo(String value) {
            addCriterion("scode <=", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeLike(String value) {
            addCriterion("scode like", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotLike(String value) {
            addCriterion("scode not like", value, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeIn(java.util.List<java.lang.String> values) {
            addCriterion("scode in", values, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("scode not in", values, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeBetween(String value1, String value2) {
            addCriterion("scode between", value1, value2, "scode");
            return (Criteria) this;
        }

        public Criteria andScodeNotBetween(String value1, String value2) {
            addCriterion("scode not between", value1, value2, "scode");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(java.util.List<java.lang.String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andApplyEmailIsNull() {
            addCriterion("apply_email is null");
            return (Criteria) this;
        }

        public Criteria andApplyEmailIsNotNull() {
            addCriterion("apply_email is not null");
            return (Criteria) this;
        }

        public Criteria andApplyEmailEqualTo(String value) {
            addCriterion("apply_email =", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotEqualTo(String value) {
            addCriterion("apply_email <>", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailGreaterThan(String value) {
            addCriterion("apply_email >", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("apply_email >=", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailLessThan(String value) {
            addCriterion("apply_email <", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailLessThanOrEqualTo(String value) {
            addCriterion("apply_email <=", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailLike(String value) {
            addCriterion("apply_email like", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotLike(String value) {
            addCriterion("apply_email not like", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_email in", values, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_email not in", values, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailBetween(String value1, String value2) {
            addCriterion("apply_email between", value1, value2, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotBetween(String value1, String value2) {
            addCriterion("apply_email not between", value1, value2, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyReasonIsNull() {
            addCriterion("apply_reason is null");
            return (Criteria) this;
        }

        public Criteria andApplyReasonIsNotNull() {
            addCriterion("apply_reason is not null");
            return (Criteria) this;
        }

        public Criteria andApplyReasonEqualTo(String value) {
            addCriterion("apply_reason =", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotEqualTo(String value) {
            addCriterion("apply_reason <>", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonGreaterThan(String value) {
            addCriterion("apply_reason >", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonGreaterThanOrEqualTo(String value) {
            addCriterion("apply_reason >=", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonLessThan(String value) {
            addCriterion("apply_reason <", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonLessThanOrEqualTo(String value) {
            addCriterion("apply_reason <=", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonLike(String value) {
            addCriterion("apply_reason like", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotLike(String value) {
            addCriterion("apply_reason not like", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_reason in", values, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_reason not in", values, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonBetween(String value1, String value2) {
            addCriterion("apply_reason between", value1, value2, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotBetween(String value1, String value2) {
            addCriterion("apply_reason not between", value1, value2, "applyReason");
            return (Criteria) this;
        }

        public Criteria andServerKeyidIsNull() {
            addCriterion("server_keyid is null");
            return (Criteria) this;
        }

        public Criteria andServerKeyidIsNotNull() {
            addCriterion("server_keyid is not null");
            return (Criteria) this;
        }

        public Criteria andServerKeyidEqualTo(Long value) {
            addCriterion("server_keyid =", value, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidNotEqualTo(Long value) {
            addCriterion("server_keyid <>", value, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidGreaterThan(Long value) {
            addCriterion("server_keyid >", value, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidGreaterThanOrEqualTo(Long value) {
            addCriterion("server_keyid >=", value, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidLessThan(Long value) {
            addCriterion("server_keyid <", value, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidLessThanOrEqualTo(Long value) {
            addCriterion("server_keyid <=", value, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidIn(java.util.List<java.lang.Long> values) {
            addCriterion("server_keyid in", values, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("server_keyid not in", values, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidBetween(Long value1, Long value2) {
            addCriterion("server_keyid between", value1, value2, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andServerKeyidNotBetween(Long value1, Long value2) {
            addCriterion("server_keyid not between", value1, value2, "serverKeyid");
            return (Criteria) this;
        }

        public Criteria andResflagIsNull() {
            addCriterion("resflag is null");
            return (Criteria) this;
        }

        public Criteria andResflagIsNotNull() {
            addCriterion("resflag is not null");
            return (Criteria) this;
        }

        public Criteria andResflagEqualTo(Boolean value) {
            addCriterion("resflag =", value, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagNotEqualTo(Boolean value) {
            addCriterion("resflag <>", value, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagGreaterThan(Boolean value) {
            addCriterion("resflag >", value, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("resflag >=", value, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagLessThan(Boolean value) {
            addCriterion("resflag <", value, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagLessThanOrEqualTo(Boolean value) {
            addCriterion("resflag <=", value, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("resflag in", values, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("resflag not in", values, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagBetween(Boolean value1, Boolean value2) {
            addCriterion("resflag between", value1, value2, "resflag");
            return (Criteria) this;
        }

        public Criteria andResflagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("resflag not between", value1, value2, "resflag");
            return (Criteria) this;
        }

        public Criteria andEndflagIsNull() {
            addCriterion("endflag is null");
            return (Criteria) this;
        }

        public Criteria andEndflagIsNotNull() {
            addCriterion("endflag is not null");
            return (Criteria) this;
        }

        public Criteria andEndflagEqualTo(String value) {
            addCriterion("endflag =", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagNotEqualTo(String value) {
            addCriterion("endflag <>", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagGreaterThan(String value) {
            addCriterion("endflag >", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagGreaterThanOrEqualTo(String value) {
            addCriterion("endflag >=", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagLessThan(String value) {
            addCriterion("endflag <", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagLessThanOrEqualTo(String value) {
            addCriterion("endflag <=", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagLike(String value) {
            addCriterion("endflag like", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagNotLike(String value) {
            addCriterion("endflag not like", value, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagIn(java.util.List<java.lang.String> values) {
            addCriterion("endflag in", values, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagNotIn(java.util.List<java.lang.String> values) {
            addCriterion("endflag not in", values, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagBetween(String value1, String value2) {
            addCriterion("endflag between", value1, value2, "endflag");
            return (Criteria) this;
        }

        public Criteria andEndflagNotBetween(String value1, String value2) {
            addCriterion("endflag not between", value1, value2, "endflag");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
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
    b_hd_apply_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}