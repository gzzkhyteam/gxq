package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogWarnSetExample extends com.hengyunsoft.db.example.BaseExample<LogWarnSetExample.Criteria> implements Serializable {
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

        public Criteria andStructSaveDaysIsNull() {
            addCriterion("struct_save_days is null");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysIsNotNull() {
            addCriterion("struct_save_days is not null");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysEqualTo(Long value) {
            addCriterion("struct_save_days =", value, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysNotEqualTo(Long value) {
            addCriterion("struct_save_days <>", value, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysGreaterThan(Long value) {
            addCriterion("struct_save_days >", value, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysGreaterThanOrEqualTo(Long value) {
            addCriterion("struct_save_days >=", value, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysLessThan(Long value) {
            addCriterion("struct_save_days <", value, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysLessThanOrEqualTo(Long value) {
            addCriterion("struct_save_days <=", value, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysIn(java.util.List<java.lang.Long> values) {
            addCriterion("struct_save_days in", values, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("struct_save_days not in", values, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysBetween(Long value1, Long value2) {
            addCriterion("struct_save_days between", value1, value2, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andStructSaveDaysNotBetween(Long value1, Long value2) {
            addCriterion("struct_save_days not between", value1, value2, "structSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysIsNull() {
            addCriterion("file_save_days is null");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysIsNotNull() {
            addCriterion("file_save_days is not null");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysEqualTo(Long value) {
            addCriterion("file_save_days =", value, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysNotEqualTo(Long value) {
            addCriterion("file_save_days <>", value, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysGreaterThan(Long value) {
            addCriterion("file_save_days >", value, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysGreaterThanOrEqualTo(Long value) {
            addCriterion("file_save_days >=", value, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysLessThan(Long value) {
            addCriterion("file_save_days <", value, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysLessThanOrEqualTo(Long value) {
            addCriterion("file_save_days <=", value, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysIn(java.util.List<java.lang.Long> values) {
            addCriterion("file_save_days in", values, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("file_save_days not in", values, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysBetween(Long value1, Long value2) {
            addCriterion("file_save_days between", value1, value2, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andFileSaveDaysNotBetween(Long value1, Long value2) {
            addCriterion("file_save_days not between", value1, value2, "fileSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysIsNull() {
            addCriterion("warn_save_days is null");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysIsNotNull() {
            addCriterion("warn_save_days is not null");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysEqualTo(Long value) {
            addCriterion("warn_save_days =", value, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysNotEqualTo(Long value) {
            addCriterion("warn_save_days <>", value, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysGreaterThan(Long value) {
            addCriterion("warn_save_days >", value, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysGreaterThanOrEqualTo(Long value) {
            addCriterion("warn_save_days >=", value, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysLessThan(Long value) {
            addCriterion("warn_save_days <", value, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysLessThanOrEqualTo(Long value) {
            addCriterion("warn_save_days <=", value, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysIn(java.util.List<java.lang.Long> values) {
            addCriterion("warn_save_days in", values, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("warn_save_days not in", values, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysBetween(Long value1, Long value2) {
            addCriterion("warn_save_days between", value1, value2, "warnSaveDays");
            return (Criteria) this;
        }

        public Criteria andWarnSaveDaysNotBetween(Long value1, Long value2) {
            addCriterion("warn_save_days not between", value1, value2, "warnSaveDays");
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

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }
    }

    /**
    log_warn_setaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}