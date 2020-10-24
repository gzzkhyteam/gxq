package com.hengyunsoft.platform.mail.repository.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BWListExample extends com.hengyunsoft.db.example.BaseExample<BWListExample.Criteria> implements Serializable {
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

        public Criteria andBwTypeIsNull() {
            addCriterion("bw_type is null");
            return (Criteria) this;
        }

        public Criteria andBwTypeIsNotNull() {
            addCriterion("bw_type is not null");
            return (Criteria) this;
        }

        public Criteria andBwTypeEqualTo(String value) {
            addCriterion("bw_type =", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeNotEqualTo(String value) {
            addCriterion("bw_type <>", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeGreaterThan(String value) {
            addCriterion("bw_type >", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bw_type >=", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeLessThan(String value) {
            addCriterion("bw_type <", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeLessThanOrEqualTo(String value) {
            addCriterion("bw_type <=", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeLike(String value) {
            addCriterion("bw_type like", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeNotLike(String value) {
            addCriterion("bw_type not like", value, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("bw_type in", values, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("bw_type not in", values, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeBetween(String value1, String value2) {
            addCriterion("bw_type between", value1, value2, "bwType");
            return (Criteria) this;
        }

        public Criteria andBwTypeNotBetween(String value1, String value2) {
            addCriterion("bw_type not between", value1, value2, "bwType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeIsNull() {
            addCriterion("locate_type is null");
            return (Criteria) this;
        }

        public Criteria andLocateTypeIsNotNull() {
            addCriterion("locate_type is not null");
            return (Criteria) this;
        }

        public Criteria andLocateTypeEqualTo(String value) {
            addCriterion("locate_type =", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeNotEqualTo(String value) {
            addCriterion("locate_type <>", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeGreaterThan(String value) {
            addCriterion("locate_type >", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("locate_type >=", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeLessThan(String value) {
            addCriterion("locate_type <", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeLessThanOrEqualTo(String value) {
            addCriterion("locate_type <=", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeLike(String value) {
            addCriterion("locate_type like", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeNotLike(String value) {
            addCriterion("locate_type not like", value, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("locate_type in", values, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("locate_type not in", values, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeBetween(String value1, String value2) {
            addCriterion("locate_type between", value1, value2, "locateType");
            return (Criteria) this;
        }

        public Criteria andLocateTypeNotBetween(String value1, String value2) {
            addCriterion("locate_type not between", value1, value2, "locateType");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(java.util.List<java.lang.String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(java.util.List<java.lang.String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailIsNull() {
            addCriterion("current_email is null");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailIsNotNull() {
            addCriterion("current_email is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailEqualTo(String value) {
            addCriterion("current_email =", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailNotEqualTo(String value) {
            addCriterion("current_email <>", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailGreaterThan(String value) {
            addCriterion("current_email >", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailGreaterThanOrEqualTo(String value) {
            addCriterion("current_email >=", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailLessThan(String value) {
            addCriterion("current_email <", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailLessThanOrEqualTo(String value) {
            addCriterion("current_email <=", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailLike(String value) {
            addCriterion("current_email like", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailNotLike(String value) {
            addCriterion("current_email not like", value, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailIn(java.util.List<java.lang.String> values) {
            addCriterion("current_email in", values, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailNotIn(java.util.List<java.lang.String> values) {
            addCriterion("current_email not in", values, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailBetween(String value1, String value2) {
            addCriterion("current_email between", value1, value2, "currentEmail");
            return (Criteria) this;
        }

        public Criteria andCurrentEmailNotBetween(String value1, String value2) {
            addCriterion("current_email not between", value1, value2, "currentEmail");
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
    mail_bwllistaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}