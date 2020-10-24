package com.hengyunsoft.platform.mt.repository.appr.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApprApplyExample extends com.hengyunsoft.db.example.BaseExample<ApprApplyExample.Criteria> implements Serializable {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Long value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Long value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Long value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Long value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Long value1, Long value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlIsNull() {
            addCriterion("cance_reasonl is null");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlIsNotNull() {
            addCriterion("cance_reasonl is not null");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlEqualTo(String value) {
            addCriterion("cance_reasonl =", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlNotEqualTo(String value) {
            addCriterion("cance_reasonl <>", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlGreaterThan(String value) {
            addCriterion("cance_reasonl >", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlGreaterThanOrEqualTo(String value) {
            addCriterion("cance_reasonl >=", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlLessThan(String value) {
            addCriterion("cance_reasonl <", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlLessThanOrEqualTo(String value) {
            addCriterion("cance_reasonl <=", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlLike(String value) {
            addCriterion("cance_reasonl like", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlNotLike(String value) {
            addCriterion("cance_reasonl not like", value, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlIn(java.util.List<java.lang.String> values) {
            addCriterion("cance_reasonl in", values, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cance_reasonl not in", values, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlBetween(String value1, String value2) {
            addCriterion("cance_reasonl between", value1, value2, "canceReasonl");
            return (Criteria) this;
        }

        public Criteria andCanceReasonlNotBetween(String value1, String value2) {
            addCriterion("cance_reasonl not between", value1, value2, "canceReasonl");
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

        public Criteria andAprCodeIsNull() {
            addCriterion("apr_code is null");
            return (Criteria) this;
        }

        public Criteria andAprCodeIsNotNull() {
            addCriterion("apr_code is not null");
            return (Criteria) this;
        }

        public Criteria andAprCodeEqualTo(String value) {
            addCriterion("apr_code =", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeNotEqualTo(String value) {
            addCriterion("apr_code <>", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeGreaterThan(String value) {
            addCriterion("apr_code >", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeGreaterThanOrEqualTo(String value) {
            addCriterion("apr_code >=", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeLessThan(String value) {
            addCriterion("apr_code <", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeLessThanOrEqualTo(String value) {
            addCriterion("apr_code <=", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeLike(String value) {
            addCriterion("apr_code like", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeNotLike(String value) {
            addCriterion("apr_code not like", value, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("apr_code in", values, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apr_code not in", values, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeBetween(String value1, String value2) {
            addCriterion("apr_code between", value1, value2, "aprCode");
            return (Criteria) this;
        }

        public Criteria andAprCodeNotBetween(String value1, String value2) {
            addCriterion("apr_code not between", value1, value2, "aprCode");
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

        public Criteria andCurStateIsNull() {
            addCriterion("cur_state is null");
            return (Criteria) this;
        }

        public Criteria andCurStateIsNotNull() {
            addCriterion("cur_state is not null");
            return (Criteria) this;
        }

        public Criteria andCurStateEqualTo(Integer value) {
            addCriterion("cur_state =", value, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateNotEqualTo(Integer value) {
            addCriterion("cur_state <>", value, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateGreaterThan(Integer value) {
            addCriterion("cur_state >", value, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("cur_state >=", value, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateLessThan(Integer value) {
            addCriterion("cur_state <", value, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateLessThanOrEqualTo(Integer value) {
            addCriterion("cur_state <=", value, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cur_state in", values, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cur_state not in", values, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateBetween(Integer value1, Integer value2) {
            addCriterion("cur_state between", value1, value2, "curState");
            return (Criteria) this;
        }

        public Criteria andCurStateNotBetween(Integer value1, Integer value2) {
            addCriterion("cur_state not between", value1, value2, "curState");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexIsNull() {
            addCriterion("cur_user_index is null");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexIsNotNull() {
            addCriterion("cur_user_index is not null");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexEqualTo(Integer value) {
            addCriterion("cur_user_index =", value, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexNotEqualTo(Integer value) {
            addCriterion("cur_user_index <>", value, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexGreaterThan(Integer value) {
            addCriterion("cur_user_index >", value, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("cur_user_index >=", value, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexLessThan(Integer value) {
            addCriterion("cur_user_index <", value, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexLessThanOrEqualTo(Integer value) {
            addCriterion("cur_user_index <=", value, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cur_user_index in", values, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cur_user_index not in", values, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexBetween(Integer value1, Integer value2) {
            addCriterion("cur_user_index between", value1, value2, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurUserIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("cur_user_index not between", value1, value2, "curUserIndex");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdIsNull() {
            addCriterion("cur_apr_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdIsNotNull() {
            addCriterion("cur_apr_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdEqualTo(Long value) {
            addCriterion("cur_apr_user_id =", value, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdNotEqualTo(Long value) {
            addCriterion("cur_apr_user_id <>", value, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdGreaterThan(Long value) {
            addCriterion("cur_apr_user_id >", value, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cur_apr_user_id >=", value, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdLessThan(Long value) {
            addCriterion("cur_apr_user_id <", value, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdLessThanOrEqualTo(Long value) {
            addCriterion("cur_apr_user_id <=", value, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("cur_apr_user_id in", values, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("cur_apr_user_id not in", values, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdBetween(Long value1, Long value2) {
            addCriterion("cur_apr_user_id between", value1, value2, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserIdNotBetween(Long value1, Long value2) {
            addCriterion("cur_apr_user_id not between", value1, value2, "curAprUserId");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameIsNull() {
            addCriterion("cur_apr_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameIsNotNull() {
            addCriterion("cur_apr_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameEqualTo(String value) {
            addCriterion("cur_apr_user_name =", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameNotEqualTo(String value) {
            addCriterion("cur_apr_user_name <>", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameGreaterThan(String value) {
            addCriterion("cur_apr_user_name >", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("cur_apr_user_name >=", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameLessThan(String value) {
            addCriterion("cur_apr_user_name <", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameLessThanOrEqualTo(String value) {
            addCriterion("cur_apr_user_name <=", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameLike(String value) {
            addCriterion("cur_apr_user_name like", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameNotLike(String value) {
            addCriterion("cur_apr_user_name not like", value, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("cur_apr_user_name in", values, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cur_apr_user_name not in", values, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameBetween(String value1, String value2) {
            addCriterion("cur_apr_user_name between", value1, value2, "curAprUserName");
            return (Criteria) this;
        }

        public Criteria andCurAprUserNameNotBetween(String value1, String value2) {
            addCriterion("cur_apr_user_name not between", value1, value2, "curAprUserName");
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
    b_appr_applyaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}