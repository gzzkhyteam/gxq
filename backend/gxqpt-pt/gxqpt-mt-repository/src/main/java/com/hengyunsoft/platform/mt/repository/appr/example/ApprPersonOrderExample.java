package com.hengyunsoft.platform.mt.repository.appr.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApprPersonOrderExample extends com.hengyunsoft.db.example.BaseExample<ApprPersonOrderExample.Criteria> implements Serializable {
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

        public Criteria andAprTypeIsNull() {
            addCriterion("apr_type is null");
            return (Criteria) this;
        }

        public Criteria andAprTypeIsNotNull() {
            addCriterion("apr_type is not null");
            return (Criteria) this;
        }

        public Criteria andAprTypeEqualTo(String value) {
            addCriterion("apr_type =", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeNotEqualTo(String value) {
            addCriterion("apr_type <>", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeGreaterThan(String value) {
            addCriterion("apr_type >", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeGreaterThanOrEqualTo(String value) {
            addCriterion("apr_type >=", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeLessThan(String value) {
            addCriterion("apr_type <", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeLessThanOrEqualTo(String value) {
            addCriterion("apr_type <=", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeLike(String value) {
            addCriterion("apr_type like", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeNotLike(String value) {
            addCriterion("apr_type not like", value, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("apr_type in", values, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apr_type not in", values, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeBetween(String value1, String value2) {
            addCriterion("apr_type between", value1, value2, "aprType");
            return (Criteria) this;
        }

        public Criteria andAprTypeNotBetween(String value1, String value2) {
            addCriterion("apr_type not between", value1, value2, "aprType");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdIsNull() {
            addCriterion("appr_person_id is null");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdIsNotNull() {
            addCriterion("appr_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdEqualTo(Long value) {
            addCriterion("appr_person_id =", value, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdNotEqualTo(Long value) {
            addCriterion("appr_person_id <>", value, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdGreaterThan(Long value) {
            addCriterion("appr_person_id >", value, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("appr_person_id >=", value, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdLessThan(Long value) {
            addCriterion("appr_person_id <", value, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("appr_person_id <=", value, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("appr_person_id in", values, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("appr_person_id not in", values, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdBetween(Long value1, Long value2) {
            addCriterion("appr_person_id between", value1, value2, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("appr_person_id not between", value1, value2, "apprPersonId");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameIsNull() {
            addCriterion("appr_person_name is null");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameIsNotNull() {
            addCriterion("appr_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameEqualTo(String value) {
            addCriterion("appr_person_name =", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameNotEqualTo(String value) {
            addCriterion("appr_person_name <>", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameGreaterThan(String value) {
            addCriterion("appr_person_name >", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("appr_person_name >=", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameLessThan(String value) {
            addCriterion("appr_person_name <", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameLessThanOrEqualTo(String value) {
            addCriterion("appr_person_name <=", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameLike(String value) {
            addCriterion("appr_person_name like", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameNotLike(String value) {
            addCriterion("appr_person_name not like", value, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameIn(java.util.List<java.lang.String> values) {
            addCriterion("appr_person_name in", values, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("appr_person_name not in", values, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameBetween(String value1, String value2) {
            addCriterion("appr_person_name between", value1, value2, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprPersonNameNotBetween(String value1, String value2) {
            addCriterion("appr_person_name not between", value1, value2, "apprPersonName");
            return (Criteria) this;
        }

        public Criteria andApprOrderIsNull() {
            addCriterion("appr_order is null");
            return (Criteria) this;
        }

        public Criteria andApprOrderIsNotNull() {
            addCriterion("appr_order is not null");
            return (Criteria) this;
        }

        public Criteria andApprOrderEqualTo(Integer value) {
            addCriterion("appr_order =", value, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderNotEqualTo(Integer value) {
            addCriterion("appr_order <>", value, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderGreaterThan(Integer value) {
            addCriterion("appr_order >", value, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("appr_order >=", value, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderLessThan(Integer value) {
            addCriterion("appr_order <", value, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderLessThanOrEqualTo(Integer value) {
            addCriterion("appr_order <=", value, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderIn(java.util.List<java.lang.Integer> values) {
            addCriterion("appr_order in", values, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("appr_order not in", values, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderBetween(Integer value1, Integer value2) {
            addCriterion("appr_order between", value1, value2, "apprOrder");
            return (Criteria) this;
        }

        public Criteria andApprOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("appr_order not between", value1, value2, "apprOrder");
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
    b_appr_person_orderaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}