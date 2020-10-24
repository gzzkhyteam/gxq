package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogOpenDeleteExample extends com.hengyunsoft.db.example.BaseExample<LogOpenDeleteExample.Criteria> implements Serializable {
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

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(java.util.List<java.lang.String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeIsNull() {
            addCriterion("call_serve_time is null");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeIsNotNull() {
            addCriterion("call_serve_time is not null");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeEqualTo(Date value) {
            addCriterion("call_serve_time =", value, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeNotEqualTo(Date value) {
            addCriterion("call_serve_time <>", value, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeGreaterThan(Date value) {
            addCriterion("call_serve_time >", value, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("call_serve_time >=", value, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeLessThan(Date value) {
            addCriterion("call_serve_time <", value, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeLessThanOrEqualTo(Date value) {
            addCriterion("call_serve_time <=", value, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("call_serve_time in", values, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("call_serve_time not in", values, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeBetween(Date value1, Date value2) {
            addCriterion("call_serve_time between", value1, value2, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andCallServeTimeNotBetween(Date value1, Date value2) {
            addCriterion("call_serve_time not between", value1, value2, "callServeTime");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionIsNull() {
            addCriterion("delete_condition is null");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionIsNotNull() {
            addCriterion("delete_condition is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionEqualTo(String value) {
            addCriterion("delete_condition =", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionNotEqualTo(String value) {
            addCriterion("delete_condition <>", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionGreaterThan(String value) {
            addCriterion("delete_condition >", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionGreaterThanOrEqualTo(String value) {
            addCriterion("delete_condition >=", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionLessThan(String value) {
            addCriterion("delete_condition <", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionLessThanOrEqualTo(String value) {
            addCriterion("delete_condition <=", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionLike(String value) {
            addCriterion("delete_condition like", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionNotLike(String value) {
            addCriterion("delete_condition not like", value, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionIn(java.util.List<java.lang.String> values) {
            addCriterion("delete_condition in", values, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("delete_condition not in", values, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionBetween(String value1, String value2) {
            addCriterion("delete_condition between", value1, value2, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteConditionNotBetween(String value1, String value2) {
            addCriterion("delete_condition not between", value1, value2, "deleteCondition");
            return (Criteria) this;
        }

        public Criteria andDeleteCountIsNull() {
            addCriterion("delete_count is null");
            return (Criteria) this;
        }

        public Criteria andDeleteCountIsNotNull() {
            addCriterion("delete_count is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteCountEqualTo(Long value) {
            addCriterion("delete_count =", value, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountNotEqualTo(Long value) {
            addCriterion("delete_count <>", value, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountGreaterThan(Long value) {
            addCriterion("delete_count >", value, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountGreaterThanOrEqualTo(Long value) {
            addCriterion("delete_count >=", value, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountLessThan(Long value) {
            addCriterion("delete_count <", value, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountLessThanOrEqualTo(Long value) {
            addCriterion("delete_count <=", value, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountIn(java.util.List<java.lang.Long> values) {
            addCriterion("delete_count in", values, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("delete_count not in", values, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountBetween(Long value1, Long value2) {
            addCriterion("delete_count between", value1, value2, "deleteCount");
            return (Criteria) this;
        }

        public Criteria andDeleteCountNotBetween(Long value1, Long value2) {
            addCriterion("delete_count not between", value1, value2, "deleteCount");
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
    }

    /**
    log_open_deleteaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}