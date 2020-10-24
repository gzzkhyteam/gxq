package com.hengyunsoft.platform.mt.repository.work.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkLogExample extends com.hengyunsoft.db.example.BaseExample<WorkLogExample.Criteria> implements Serializable {
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

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(java.util.List<java.lang.String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdIsNull() {
            addCriterion("main_org_id is null");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdIsNotNull() {
            addCriterion("main_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdEqualTo(String value) {
            addCriterion("main_org_id =", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdNotEqualTo(String value) {
            addCriterion("main_org_id <>", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdGreaterThan(String value) {
            addCriterion("main_org_id >", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("main_org_id >=", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdLessThan(String value) {
            addCriterion("main_org_id <", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdLessThanOrEqualTo(String value) {
            addCriterion("main_org_id <=", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdLike(String value) {
            addCriterion("main_org_id like", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdNotLike(String value) {
            addCriterion("main_org_id not like", value, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdIn(java.util.List<java.lang.String> values) {
            addCriterion("main_org_id in", values, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("main_org_id not in", values, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdBetween(String value1, String value2) {
            addCriterion("main_org_id between", value1, value2, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainOrgIdNotBetween(String value1, String value2) {
            addCriterion("main_org_id not between", value1, value2, "mainOrgId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdIsNull() {
            addCriterion("main_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdIsNotNull() {
            addCriterion("main_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdEqualTo(String value) {
            addCriterion("main_dept_id =", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdNotEqualTo(String value) {
            addCriterion("main_dept_id <>", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdGreaterThan(String value) {
            addCriterion("main_dept_id >", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("main_dept_id >=", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdLessThan(String value) {
            addCriterion("main_dept_id <", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdLessThanOrEqualTo(String value) {
            addCriterion("main_dept_id <=", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdLike(String value) {
            addCriterion("main_dept_id like", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdNotLike(String value) {
            addCriterion("main_dept_id not like", value, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdIn(java.util.List<java.lang.String> values) {
            addCriterion("main_dept_id in", values, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("main_dept_id not in", values, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdBetween(String value1, String value2) {
            addCriterion("main_dept_id between", value1, value2, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptIdNotBetween(String value1, String value2) {
            addCriterion("main_dept_id not between", value1, value2, "mainDeptId");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameIsNull() {
            addCriterion("main_dept_name is null");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameIsNotNull() {
            addCriterion("main_dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameEqualTo(String value) {
            addCriterion("main_dept_name =", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameNotEqualTo(String value) {
            addCriterion("main_dept_name <>", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameGreaterThan(String value) {
            addCriterion("main_dept_name >", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("main_dept_name >=", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameLessThan(String value) {
            addCriterion("main_dept_name <", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameLessThanOrEqualTo(String value) {
            addCriterion("main_dept_name <=", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameLike(String value) {
            addCriterion("main_dept_name like", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameNotLike(String value) {
            addCriterion("main_dept_name not like", value, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameIn(java.util.List<java.lang.String> values) {
            addCriterion("main_dept_name in", values, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("main_dept_name not in", values, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameBetween(String value1, String value2) {
            addCriterion("main_dept_name between", value1, value2, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDeptNameNotBetween(String value1, String value2) {
            addCriterion("main_dept_name not between", value1, value2, "mainDeptName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameIsNull() {
            addCriterion("main_duty_name is null");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameIsNotNull() {
            addCriterion("main_duty_name is not null");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameEqualTo(String value) {
            addCriterion("main_duty_name =", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameNotEqualTo(String value) {
            addCriterion("main_duty_name <>", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameGreaterThan(String value) {
            addCriterion("main_duty_name >", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameGreaterThanOrEqualTo(String value) {
            addCriterion("main_duty_name >=", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameLessThan(String value) {
            addCriterion("main_duty_name <", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameLessThanOrEqualTo(String value) {
            addCriterion("main_duty_name <=", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameLike(String value) {
            addCriterion("main_duty_name like", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameNotLike(String value) {
            addCriterion("main_duty_name not like", value, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameIn(java.util.List<java.lang.String> values) {
            addCriterion("main_duty_name in", values, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("main_duty_name not in", values, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameBetween(String value1, String value2) {
            addCriterion("main_duty_name between", value1, value2, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andMainDutyNameNotBetween(String value1, String value2) {
            addCriterion("main_duty_name not between", value1, value2, "mainDutyName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(java.util.List<java.util.Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(java.util.List<java.util.Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andNowNumIsNull() {
            addCriterion("now_num is null");
            return (Criteria) this;
        }

        public Criteria andNowNumIsNotNull() {
            addCriterion("now_num is not null");
            return (Criteria) this;
        }

        public Criteria andNowNumEqualTo(Integer value) {
            addCriterion("now_num =", value, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumNotEqualTo(Integer value) {
            addCriterion("now_num <>", value, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumGreaterThan(Integer value) {
            addCriterion("now_num >", value, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_num >=", value, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumLessThan(Integer value) {
            addCriterion("now_num <", value, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumLessThanOrEqualTo(Integer value) {
            addCriterion("now_num <=", value, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("now_num in", values, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("now_num not in", values, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumBetween(Integer value1, Integer value2) {
            addCriterion("now_num between", value1, value2, "nowNum");
            return (Criteria) this;
        }

        public Criteria andNowNumNotBetween(Integer value1, Integer value2) {
            addCriterion("now_num not between", value1, value2, "nowNum");
            return (Criteria) this;
        }
    }

    /**
    b_work_logaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}