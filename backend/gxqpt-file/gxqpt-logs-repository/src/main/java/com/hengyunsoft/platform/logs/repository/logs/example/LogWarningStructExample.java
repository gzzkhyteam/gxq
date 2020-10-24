package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LogWarningStructExample extends com.hengyunsoft.db.example.BaseExample<LogWarningStructExample.Criteria> implements Serializable {
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

        public Criteria andLogWarningIdIsNull() {
            addCriterion("log_warning_id is null");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdIsNotNull() {
            addCriterion("log_warning_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdEqualTo(Long value) {
            addCriterion("log_warning_id =", value, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdNotEqualTo(Long value) {
            addCriterion("log_warning_id <>", value, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdGreaterThan(Long value) {
            addCriterion("log_warning_id >", value, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_warning_id >=", value, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdLessThan(Long value) {
            addCriterion("log_warning_id <", value, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdLessThanOrEqualTo(Long value) {
            addCriterion("log_warning_id <=", value, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_warning_id in", values, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_warning_id not in", values, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdBetween(Long value1, Long value2) {
            addCriterion("log_warning_id between", value1, value2, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogWarningIdNotBetween(Long value1, Long value2) {
            addCriterion("log_warning_id not between", value1, value2, "logWarningId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogStructIdIsNull() {
            addCriterion("log_struct_id is null");
            return (Criteria) this;
        }

        public Criteria andLogStructIdIsNotNull() {
            addCriterion("log_struct_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogStructIdEqualTo(Long value) {
            addCriterion("log_struct_id =", value, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdNotEqualTo(Long value) {
            addCriterion("log_struct_id <>", value, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdGreaterThan(Long value) {
            addCriterion("log_struct_id >", value, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_struct_id >=", value, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdLessThan(Long value) {
            addCriterion("log_struct_id <", value, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdLessThanOrEqualTo(Long value) {
            addCriterion("log_struct_id <=", value, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_struct_id in", values, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_struct_id not in", values, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdBetween(Long value1, Long value2) {
            addCriterion("log_struct_id between", value1, value2, "logStructId");
            return (Criteria) this;
        }

        public Criteria andLogStructIdNotBetween(Long value1, Long value2) {
            addCriterion("log_struct_id not between", value1, value2, "logStructId");
            return (Criteria) this;
        }
    }

    /**
    log_warning_structaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}