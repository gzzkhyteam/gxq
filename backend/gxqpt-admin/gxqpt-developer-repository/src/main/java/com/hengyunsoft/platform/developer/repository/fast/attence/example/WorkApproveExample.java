package com.hengyunsoft.platform.developer.repository.fast.attence.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkApproveExample extends com.hengyunsoft.db.example.BaseExample<WorkApproveExample.Criteria> implements Serializable {
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

        public Criteria andAproveCodeIsNull() {
            addCriterion("aprove_code is null");
            return (Criteria) this;
        }

        public Criteria andAproveCodeIsNotNull() {
            addCriterion("aprove_code is not null");
            return (Criteria) this;
        }

        public Criteria andAproveCodeEqualTo(String value) {
            addCriterion("aprove_code =", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeNotEqualTo(String value) {
            addCriterion("aprove_code <>", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeGreaterThan(String value) {
            addCriterion("aprove_code >", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeGreaterThanOrEqualTo(String value) {
            addCriterion("aprove_code >=", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeLessThan(String value) {
            addCriterion("aprove_code <", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeLessThanOrEqualTo(String value) {
            addCriterion("aprove_code <=", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeLike(String value) {
            addCriterion("aprove_code like", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeNotLike(String value) {
            addCriterion("aprove_code not like", value, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("aprove_code in", values, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("aprove_code not in", values, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeBetween(String value1, String value2) {
            addCriterion("aprove_code between", value1, value2, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveCodeNotBetween(String value1, String value2) {
            addCriterion("aprove_code not between", value1, value2, "aproveCode");
            return (Criteria) this;
        }

        public Criteria andAproveTypeIsNull() {
            addCriterion("aprove_type is null");
            return (Criteria) this;
        }

        public Criteria andAproveTypeIsNotNull() {
            addCriterion("aprove_type is not null");
            return (Criteria) this;
        }

        public Criteria andAproveTypeEqualTo(String value) {
            addCriterion("aprove_type =", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeNotEqualTo(String value) {
            addCriterion("aprove_type <>", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeGreaterThan(String value) {
            addCriterion("aprove_type >", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("aprove_type >=", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeLessThan(String value) {
            addCriterion("aprove_type <", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeLessThanOrEqualTo(String value) {
            addCriterion("aprove_type <=", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeLike(String value) {
            addCriterion("aprove_type like", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeNotLike(String value) {
            addCriterion("aprove_type not like", value, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("aprove_type in", values, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("aprove_type not in", values, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeBetween(String value1, String value2) {
            addCriterion("aprove_type between", value1, value2, "aproveType");
            return (Criteria) this;
        }

        public Criteria andAproveTypeNotBetween(String value1, String value2) {
            addCriterion("aprove_type not between", value1, value2, "aproveType");
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
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIsNull() {
            addCriterion("apply_user_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIsNotNull() {
            addCriterion("apply_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdEqualTo(Long value) {
            addCriterion("apply_user_id =", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotEqualTo(Long value) {
            addCriterion("apply_user_id <>", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdGreaterThan(Long value) {
            addCriterion("apply_user_id >", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_user_id >=", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdLessThan(Long value) {
            addCriterion("apply_user_id <", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_user_id <=", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_user_id in", values, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_user_id not in", values, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdBetween(Long value1, Long value2) {
            addCriterion("apply_user_id between", value1, value2, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_user_id not between", value1, value2, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNull() {
            addCriterion("apply_user_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNotNull() {
            addCriterion("apply_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameEqualTo(String value) {
            addCriterion("apply_user_name =", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotEqualTo(String value) {
            addCriterion("apply_user_name <>", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThan(String value) {
            addCriterion("apply_user_name >", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user_name >=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThan(String value) {
            addCriterion("apply_user_name <", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThanOrEqualTo(String value) {
            addCriterion("apply_user_name <=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLike(String value) {
            addCriterion("apply_user_name like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotLike(String value) {
            addCriterion("apply_user_name not like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_user_name in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_user_name not in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameBetween(String value1, String value2) {
            addCriterion("apply_user_name between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotBetween(String value1, String value2) {
            addCriterion("apply_user_name not between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIsNull() {
            addCriterion("current_state is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIsNotNull() {
            addCriterion("current_state is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStateEqualTo(String value) {
            addCriterion("current_state =", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotEqualTo(String value) {
            addCriterion("current_state <>", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateGreaterThan(String value) {
            addCriterion("current_state >", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateGreaterThanOrEqualTo(String value) {
            addCriterion("current_state >=", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLessThan(String value) {
            addCriterion("current_state <", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLessThanOrEqualTo(String value) {
            addCriterion("current_state <=", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLike(String value) {
            addCriterion("current_state like", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotLike(String value) {
            addCriterion("current_state not like", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIn(java.util.List<java.lang.String> values) {
            addCriterion("current_state in", values, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotIn(java.util.List<java.lang.String> values) {
            addCriterion("current_state not in", values, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateBetween(String value1, String value2) {
            addCriterion("current_state between", value1, value2, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotBetween(String value1, String value2) {
            addCriterion("current_state not between", value1, value2, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdIsNull() {
            addCriterion("current_aprove_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdIsNotNull() {
            addCriterion("current_aprove_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdEqualTo(Long value) {
            addCriterion("current_aprove_user_id =", value, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdNotEqualTo(Long value) {
            addCriterion("current_aprove_user_id <>", value, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdGreaterThan(Long value) {
            addCriterion("current_aprove_user_id >", value, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("current_aprove_user_id >=", value, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdLessThan(Long value) {
            addCriterion("current_aprove_user_id <", value, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdLessThanOrEqualTo(Long value) {
            addCriterion("current_aprove_user_id <=", value, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("current_aprove_user_id in", values, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("current_aprove_user_id not in", values, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdBetween(Long value1, Long value2) {
            addCriterion("current_aprove_user_id between", value1, value2, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserIdNotBetween(Long value1, Long value2) {
            addCriterion("current_aprove_user_id not between", value1, value2, "currentAproveUserId");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationIsNull() {
            addCriterion("current_aprove_user_operation is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationIsNotNull() {
            addCriterion("current_aprove_user_operation is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationEqualTo(String value) {
            addCriterion("current_aprove_user_operation =", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationNotEqualTo(String value) {
            addCriterion("current_aprove_user_operation <>", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationGreaterThan(String value) {
            addCriterion("current_aprove_user_operation >", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationGreaterThanOrEqualTo(String value) {
            addCriterion("current_aprove_user_operation >=", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationLessThan(String value) {
            addCriterion("current_aprove_user_operation <", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationLessThanOrEqualTo(String value) {
            addCriterion("current_aprove_user_operation <=", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationLike(String value) {
            addCriterion("current_aprove_user_operation like", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationNotLike(String value) {
            addCriterion("current_aprove_user_operation not like", value, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationIn(java.util.List<java.lang.String> values) {
            addCriterion("current_aprove_user_operation in", values, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("current_aprove_user_operation not in", values, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationBetween(String value1, String value2) {
            addCriterion("current_aprove_user_operation between", value1, value2, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andCurrentAproveUserOperationNotBetween(String value1, String value2) {
            addCriterion("current_aprove_user_operation not between", value1, value2, "currentAproveUserOperation");
            return (Criteria) this;
        }

        public Criteria andAproveStateIsNull() {
            addCriterion("aprove_state is null");
            return (Criteria) this;
        }

        public Criteria andAproveStateIsNotNull() {
            addCriterion("aprove_state is not null");
            return (Criteria) this;
        }

        public Criteria andAproveStateEqualTo(String value) {
            addCriterion("aprove_state =", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateNotEqualTo(String value) {
            addCriterion("aprove_state <>", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateGreaterThan(String value) {
            addCriterion("aprove_state >", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("aprove_state >=", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateLessThan(String value) {
            addCriterion("aprove_state <", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateLessThanOrEqualTo(String value) {
            addCriterion("aprove_state <=", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateLike(String value) {
            addCriterion("aprove_state like", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateNotLike(String value) {
            addCriterion("aprove_state not like", value, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateIn(java.util.List<java.lang.String> values) {
            addCriterion("aprove_state in", values, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateNotIn(java.util.List<java.lang.String> values) {
            addCriterion("aprove_state not in", values, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateBetween(String value1, String value2) {
            addCriterion("aprove_state between", value1, value2, "aproveState");
            return (Criteria) this;
        }

        public Criteria andAproveStateNotBetween(String value1, String value2) {
            addCriterion("aprove_state not between", value1, value2, "aproveState");
            return (Criteria) this;
        }

        public Criteria andInAproveIsNull() {
            addCriterion("in_aprove is null");
            return (Criteria) this;
        }

        public Criteria andInAproveIsNotNull() {
            addCriterion("in_aprove is not null");
            return (Criteria) this;
        }

        public Criteria andInAproveEqualTo(String value) {
            addCriterion("in_aprove =", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveNotEqualTo(String value) {
            addCriterion("in_aprove <>", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveGreaterThan(String value) {
            addCriterion("in_aprove >", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveGreaterThanOrEqualTo(String value) {
            addCriterion("in_aprove >=", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveLessThan(String value) {
            addCriterion("in_aprove <", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveLessThanOrEqualTo(String value) {
            addCriterion("in_aprove <=", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveLike(String value) {
            addCriterion("in_aprove like", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveNotLike(String value) {
            addCriterion("in_aprove not like", value, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveIn(java.util.List<java.lang.String> values) {
            addCriterion("in_aprove in", values, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveNotIn(java.util.List<java.lang.String> values) {
            addCriterion("in_aprove not in", values, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveBetween(String value1, String value2) {
            addCriterion("in_aprove between", value1, value2, "inAprove");
            return (Criteria) this;
        }

        public Criteria andInAproveNotBetween(String value1, String value2) {
            addCriterion("in_aprove not between", value1, value2, "inAprove");
            return (Criteria) this;
        }

        public Criteria andIsChangeIsNull() {
            addCriterion("is_change is null");
            return (Criteria) this;
        }

        public Criteria andIsChangeIsNotNull() {
            addCriterion("is_change is not null");
            return (Criteria) this;
        }

        public Criteria andIsChangeEqualTo(String value) {
            addCriterion("is_change =", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeNotEqualTo(String value) {
            addCriterion("is_change <>", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeGreaterThan(String value) {
            addCriterion("is_change >", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeGreaterThanOrEqualTo(String value) {
            addCriterion("is_change >=", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeLessThan(String value) {
            addCriterion("is_change <", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeLessThanOrEqualTo(String value) {
            addCriterion("is_change <=", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeLike(String value) {
            addCriterion("is_change like", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeNotLike(String value) {
            addCriterion("is_change not like", value, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeIn(java.util.List<java.lang.String> values) {
            addCriterion("is_change in", values, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_change not in", values, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeBetween(String value1, String value2) {
            addCriterion("is_change between", value1, value2, "isChange");
            return (Criteria) this;
        }

        public Criteria andIsChangeNotBetween(String value1, String value2) {
            addCriterion("is_change not between", value1, value2, "isChange");
            return (Criteria) this;
        }

        public Criteria andChangeReasonIsNull() {
            addCriterion("change_reason is null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonIsNotNull() {
            addCriterion("change_reason is not null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonEqualTo(String value) {
            addCriterion("change_reason =", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonNotEqualTo(String value) {
            addCriterion("change_reason <>", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonGreaterThan(String value) {
            addCriterion("change_reason >", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonGreaterThanOrEqualTo(String value) {
            addCriterion("change_reason >=", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonLessThan(String value) {
            addCriterion("change_reason <", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonLessThanOrEqualTo(String value) {
            addCriterion("change_reason <=", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonLike(String value) {
            addCriterion("change_reason like", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonNotLike(String value) {
            addCriterion("change_reason not like", value, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonIn(java.util.List<java.lang.String> values) {
            addCriterion("change_reason in", values, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("change_reason not in", values, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonBetween(String value1, String value2) {
            addCriterion("change_reason between", value1, value2, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeReasonNotBetween(String value1, String value2) {
            addCriterion("change_reason not between", value1, value2, "changeReason");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNull() {
            addCriterion("change_time is null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNotNull() {
            addCriterion("change_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeEqualTo(Date value) {
            addCriterion("change_time =", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotEqualTo(Date value) {
            addCriterion("change_time <>", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThan(Date value) {
            addCriterion("change_time >", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("change_time >=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThan(Date value) {
            addCriterion("change_time <", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("change_time <=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("change_time in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("change_time not in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeBetween(Date value1, Date value2) {
            addCriterion("change_time between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("change_time not between", value1, value2, "changeTime");
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

        public Criteria andBacklogIdIsNull() {
            addCriterion("backlog_id is null");
            return (Criteria) this;
        }

        public Criteria andBacklogIdIsNotNull() {
            addCriterion("backlog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBacklogIdEqualTo(Long value) {
            addCriterion("backlog_id =", value, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdNotEqualTo(Long value) {
            addCriterion("backlog_id <>", value, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdGreaterThan(Long value) {
            addCriterion("backlog_id >", value, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("backlog_id >=", value, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdLessThan(Long value) {
            addCriterion("backlog_id <", value, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdLessThanOrEqualTo(Long value) {
            addCriterion("backlog_id <=", value, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("backlog_id in", values, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("backlog_id not in", values, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdBetween(Long value1, Long value2) {
            addCriterion("backlog_id between", value1, value2, "backlogId");
            return (Criteria) this;
        }

        public Criteria andBacklogIdNotBetween(Long value1, Long value2) {
            addCriterion("backlog_id not between", value1, value2, "backlogId");
            return (Criteria) this;
        }
    }

    /**
    b_work_approveaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}