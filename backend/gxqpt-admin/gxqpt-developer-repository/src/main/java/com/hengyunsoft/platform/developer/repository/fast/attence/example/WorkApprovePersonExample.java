package com.hengyunsoft.platform.developer.repository.fast.attence.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkApprovePersonExample extends com.hengyunsoft.db.example.BaseExample<WorkApprovePersonExample.Criteria> implements Serializable {
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

        public Criteria andApproveSortIdIsNull() {
            addCriterion("approve_sort_id is null");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdIsNotNull() {
            addCriterion("approve_sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdEqualTo(Integer value) {
            addCriterion("approve_sort_id =", value, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdNotEqualTo(Integer value) {
            addCriterion("approve_sort_id <>", value, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdGreaterThan(Integer value) {
            addCriterion("approve_sort_id >", value, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_sort_id >=", value, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdLessThan(Integer value) {
            addCriterion("approve_sort_id <", value, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("approve_sort_id <=", value, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdIn(java.util.List<java.lang.Integer> values) {
            addCriterion("approve_sort_id in", values, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("approve_sort_id not in", values, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdBetween(Integer value1, Integer value2) {
            addCriterion("approve_sort_id between", value1, value2, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andApproveSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_sort_id not between", value1, value2, "approveSortId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Long value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Long value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Long value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Long value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Long value1, Long value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(java.util.List<java.lang.String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andAproveIdIsNull() {
            addCriterion("aprove_id is null");
            return (Criteria) this;
        }

        public Criteria andAproveIdIsNotNull() {
            addCriterion("aprove_id is not null");
            return (Criteria) this;
        }

        public Criteria andAproveIdEqualTo(Long value) {
            addCriterion("aprove_id =", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdNotEqualTo(Long value) {
            addCriterion("aprove_id <>", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdGreaterThan(Long value) {
            addCriterion("aprove_id >", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdGreaterThanOrEqualTo(Long value) {
            addCriterion("aprove_id >=", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdLessThan(Long value) {
            addCriterion("aprove_id <", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdLessThanOrEqualTo(Long value) {
            addCriterion("aprove_id <=", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("aprove_id in", values, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("aprove_id not in", values, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdBetween(Long value1, Long value2) {
            addCriterion("aprove_id between", value1, value2, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdNotBetween(Long value1, Long value2) {
            addCriterion("aprove_id not between", value1, value2, "aproveId");
            return (Criteria) this;
        }

        public Criteria andPersonTypeIsNull() {
            addCriterion("person_type is null");
            return (Criteria) this;
        }

        public Criteria andPersonTypeIsNotNull() {
            addCriterion("person_type is not null");
            return (Criteria) this;
        }

        public Criteria andPersonTypeEqualTo(String value) {
            addCriterion("person_type =", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeNotEqualTo(String value) {
            addCriterion("person_type <>", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeGreaterThan(String value) {
            addCriterion("person_type >", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("person_type >=", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeLessThan(String value) {
            addCriterion("person_type <", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeLessThanOrEqualTo(String value) {
            addCriterion("person_type <=", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeLike(String value) {
            addCriterion("person_type like", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeNotLike(String value) {
            addCriterion("person_type not like", value, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("person_type in", values, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("person_type not in", values, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeBetween(String value1, String value2) {
            addCriterion("person_type between", value1, value2, "personType");
            return (Criteria) this;
        }

        public Criteria andPersonTypeNotBetween(String value1, String value2) {
            addCriterion("person_type not between", value1, value2, "personType");
            return (Criteria) this;
        }

        public Criteria andApproveStateIsNull() {
            addCriterion("approve_state is null");
            return (Criteria) this;
        }

        public Criteria andApproveStateIsNotNull() {
            addCriterion("approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStateEqualTo(String value) {
            addCriterion("approve_state =", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotEqualTo(String value) {
            addCriterion("approve_state <>", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateGreaterThan(String value) {
            addCriterion("approve_state >", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("approve_state >=", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLessThan(String value) {
            addCriterion("approve_state <", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLessThanOrEqualTo(String value) {
            addCriterion("approve_state <=", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLike(String value) {
            addCriterion("approve_state like", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotLike(String value) {
            addCriterion("approve_state not like", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateIn(java.util.List<java.lang.String> values) {
            addCriterion("approve_state in", values, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotIn(java.util.List<java.lang.String> values) {
            addCriterion("approve_state not in", values, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateBetween(String value1, String value2) {
            addCriterion("approve_state between", value1, value2, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotBetween(String value1, String value2) {
            addCriterion("approve_state not between", value1, value2, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveOponionIsNull() {
            addCriterion("approve_oponion is null");
            return (Criteria) this;
        }

        public Criteria andApproveOponionIsNotNull() {
            addCriterion("approve_oponion is not null");
            return (Criteria) this;
        }

        public Criteria andApproveOponionEqualTo(String value) {
            addCriterion("approve_oponion =", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionNotEqualTo(String value) {
            addCriterion("approve_oponion <>", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionGreaterThan(String value) {
            addCriterion("approve_oponion >", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionGreaterThanOrEqualTo(String value) {
            addCriterion("approve_oponion >=", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionLessThan(String value) {
            addCriterion("approve_oponion <", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionLessThanOrEqualTo(String value) {
            addCriterion("approve_oponion <=", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionLike(String value) {
            addCriterion("approve_oponion like", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionNotLike(String value) {
            addCriterion("approve_oponion not like", value, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionIn(java.util.List<java.lang.String> values) {
            addCriterion("approve_oponion in", values, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("approve_oponion not in", values, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionBetween(String value1, String value2) {
            addCriterion("approve_oponion between", value1, value2, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andApproveOponionNotBetween(String value1, String value2) {
            addCriterion("approve_oponion not between", value1, value2, "approveOponion");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNull() {
            addCriterion("operation_date is null");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNotNull() {
            addCriterion("operation_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDateEqualTo(Date value) {
            addCriterion("operation_date =", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotEqualTo(Date value) {
            addCriterion("operation_date <>", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThan(Date value) {
            addCriterion("operation_date >", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_date >=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThan(Date value) {
            addCriterion("operation_date <", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThanOrEqualTo(Date value) {
            addCriterion("operation_date <=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateIn(java.util.List<java.util.Date> values) {
            addCriterion("operation_date in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotIn(java.util.List<java.util.Date> values) {
            addCriterion("operation_date not in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateBetween(Date value1, Date value2) {
            addCriterion("operation_date between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotBetween(Date value1, Date value2) {
            addCriterion("operation_date not between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andRemindIsNull() {
            addCriterion("remind is null");
            return (Criteria) this;
        }

        public Criteria andRemindIsNotNull() {
            addCriterion("remind is not null");
            return (Criteria) this;
        }

        public Criteria andRemindEqualTo(Short value) {
            addCriterion("remind =", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotEqualTo(Short value) {
            addCriterion("remind <>", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindGreaterThan(Short value) {
            addCriterion("remind >", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindGreaterThanOrEqualTo(Short value) {
            addCriterion("remind >=", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindLessThan(Short value) {
            addCriterion("remind <", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindLessThanOrEqualTo(Short value) {
            addCriterion("remind <=", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindIn(java.util.List<java.lang.Short> values) {
            addCriterion("remind in", values, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("remind not in", values, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindBetween(Short value1, Short value2) {
            addCriterion("remind between", value1, value2, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotBetween(Short value1, Short value2) {
            addCriterion("remind not between", value1, value2, "remind");
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
    b_work_appr_personaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}