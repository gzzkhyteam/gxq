package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogWarnRuleExample extends com.hengyunsoft.db.example.BaseExample<LogWarnRuleExample.Criteria> implements Serializable {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(java.util.List<java.lang.String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNull() {
            addCriterion("warn_type is null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNotNull() {
            addCriterion("warn_type is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeEqualTo(String value) {
            addCriterion("warn_type =", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotEqualTo(String value) {
            addCriterion("warn_type <>", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThan(String value) {
            addCriterion("warn_type >", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("warn_type >=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThan(String value) {
            addCriterion("warn_type <", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThanOrEqualTo(String value) {
            addCriterion("warn_type <=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLike(String value) {
            addCriterion("warn_type like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotLike(String value) {
            addCriterion("warn_type not like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("warn_type in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("warn_type not in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeBetween(String value1, String value2) {
            addCriterion("warn_type between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotBetween(String value1, String value2) {
            addCriterion("warn_type not between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNull() {
            addCriterion("warn_level is null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNotNull() {
            addCriterion("warn_level is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelEqualTo(String value) {
            addCriterion("warn_level =", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotEqualTo(String value) {
            addCriterion("warn_level <>", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThan(String value) {
            addCriterion("warn_level >", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThanOrEqualTo(String value) {
            addCriterion("warn_level >=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThan(String value) {
            addCriterion("warn_level <", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThanOrEqualTo(String value) {
            addCriterion("warn_level <=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLike(String value) {
            addCriterion("warn_level like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotLike(String value) {
            addCriterion("warn_level not like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIn(java.util.List<java.lang.String> values) {
            addCriterion("warn_level in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("warn_level not in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelBetween(String value1, String value2) {
            addCriterion("warn_level between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotBetween(String value1, String value2) {
            addCriterion("warn_level not between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionIsNull() {
            addCriterion("warn_description is null");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionIsNotNull() {
            addCriterion("warn_description is not null");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionEqualTo(String value) {
            addCriterion("warn_description =", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionNotEqualTo(String value) {
            addCriterion("warn_description <>", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionGreaterThan(String value) {
            addCriterion("warn_description >", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("warn_description >=", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionLessThan(String value) {
            addCriterion("warn_description <", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionLessThanOrEqualTo(String value) {
            addCriterion("warn_description <=", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionLike(String value) {
            addCriterion("warn_description like", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionNotLike(String value) {
            addCriterion("warn_description not like", value, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionIn(java.util.List<java.lang.String> values) {
            addCriterion("warn_description in", values, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("warn_description not in", values, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionBetween(String value1, String value2) {
            addCriterion("warn_description between", value1, value2, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptionNotBetween(String value1, String value2) {
            addCriterion("warn_description not between", value1, value2, "warnDescription");
            return (Criteria) this;
        }

        public Criteria andKeyContentIsNull() {
            addCriterion("key_content is null");
            return (Criteria) this;
        }

        public Criteria andKeyContentIsNotNull() {
            addCriterion("key_content is not null");
            return (Criteria) this;
        }

        public Criteria andKeyContentEqualTo(String value) {
            addCriterion("key_content =", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotEqualTo(String value) {
            addCriterion("key_content <>", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentGreaterThan(String value) {
            addCriterion("key_content >", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentGreaterThanOrEqualTo(String value) {
            addCriterion("key_content >=", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentLessThan(String value) {
            addCriterion("key_content <", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentLessThanOrEqualTo(String value) {
            addCriterion("key_content <=", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentLike(String value) {
            addCriterion("key_content like", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotLike(String value) {
            addCriterion("key_content not like", value, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentIn(java.util.List<java.lang.String> values) {
            addCriterion("key_content in", values, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("key_content not in", values, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentBetween(String value1, String value2) {
            addCriterion("key_content between", value1, value2, "keyContent");
            return (Criteria) this;
        }

        public Criteria andKeyContentNotBetween(String value1, String value2) {
            addCriterion("key_content not between", value1, value2, "keyContent");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalIsNull() {
            addCriterion("quantity_time_interval is null");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalIsNotNull() {
            addCriterion("quantity_time_interval is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalEqualTo(Long value) {
            addCriterion("quantity_time_interval =", value, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalNotEqualTo(Long value) {
            addCriterion("quantity_time_interval <>", value, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalGreaterThan(Long value) {
            addCriterion("quantity_time_interval >", value, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalGreaterThanOrEqualTo(Long value) {
            addCriterion("quantity_time_interval >=", value, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalLessThan(Long value) {
            addCriterion("quantity_time_interval <", value, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalLessThanOrEqualTo(Long value) {
            addCriterion("quantity_time_interval <=", value, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalIn(java.util.List<java.lang.Long> values) {
            addCriterion("quantity_time_interval in", values, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("quantity_time_interval not in", values, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalBetween(Long value1, Long value2) {
            addCriterion("quantity_time_interval between", value1, value2, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityTimeIntervalNotBetween(Long value1, Long value2) {
            addCriterion("quantity_time_interval not between", value1, value2, "quantityTimeInterval");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelIsNull() {
            addCriterion("quantity_log_level is null");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelIsNotNull() {
            addCriterion("quantity_log_level is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelEqualTo(String value) {
            addCriterion("quantity_log_level =", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelNotEqualTo(String value) {
            addCriterion("quantity_log_level <>", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelGreaterThan(String value) {
            addCriterion("quantity_log_level >", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelGreaterThanOrEqualTo(String value) {
            addCriterion("quantity_log_level >=", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelLessThan(String value) {
            addCriterion("quantity_log_level <", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelLessThanOrEqualTo(String value) {
            addCriterion("quantity_log_level <=", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelLike(String value) {
            addCriterion("quantity_log_level like", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelNotLike(String value) {
            addCriterion("quantity_log_level not like", value, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelIn(java.util.List<java.lang.String> values) {
            addCriterion("quantity_log_level in", values, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("quantity_log_level not in", values, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelBetween(String value1, String value2) {
            addCriterion("quantity_log_level between", value1, value2, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityLogLevelNotBetween(String value1, String value2) {
            addCriterion("quantity_log_level not between", value1, value2, "quantityLogLevel");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitIsNull() {
            addCriterion("quantity_upper_limit is null");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitIsNotNull() {
            addCriterion("quantity_upper_limit is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitEqualTo(Long value) {
            addCriterion("quantity_upper_limit =", value, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitNotEqualTo(Long value) {
            addCriterion("quantity_upper_limit <>", value, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitGreaterThan(Long value) {
            addCriterion("quantity_upper_limit >", value, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitGreaterThanOrEqualTo(Long value) {
            addCriterion("quantity_upper_limit >=", value, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitLessThan(Long value) {
            addCriterion("quantity_upper_limit <", value, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitLessThanOrEqualTo(Long value) {
            addCriterion("quantity_upper_limit <=", value, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitIn(java.util.List<java.lang.Long> values) {
            addCriterion("quantity_upper_limit in", values, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("quantity_upper_limit not in", values, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitBetween(Long value1, Long value2) {
            addCriterion("quantity_upper_limit between", value1, value2, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andQuantityUpperLimitNotBetween(Long value1, Long value2) {
            addCriterion("quantity_upper_limit not between", value1, value2, "quantityUpperLimit");
            return (Criteria) this;
        }

        public Criteria andResponseDurationIsNull() {
            addCriterion("response_duration is null");
            return (Criteria) this;
        }

        public Criteria andResponseDurationIsNotNull() {
            addCriterion("response_duration is not null");
            return (Criteria) this;
        }

        public Criteria andResponseDurationEqualTo(Long value) {
            addCriterion("response_duration =", value, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationNotEqualTo(Long value) {
            addCriterion("response_duration <>", value, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationGreaterThan(Long value) {
            addCriterion("response_duration >", value, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("response_duration >=", value, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationLessThan(Long value) {
            addCriterion("response_duration <", value, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationLessThanOrEqualTo(Long value) {
            addCriterion("response_duration <=", value, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationIn(java.util.List<java.lang.Long> values) {
            addCriterion("response_duration in", values, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("response_duration not in", values, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationBetween(Long value1, Long value2) {
            addCriterion("response_duration between", value1, value2, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andResponseDurationNotBetween(Long value1, Long value2) {
            addCriterion("response_duration not between", value1, value2, "responseDuration");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(String value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(String value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(String value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(String value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(String value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(String value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLike(String value) {
            addCriterion("is_enable like", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotLike(String value) {
            addCriterion("is_enable not like", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(java.util.List<java.lang.String> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(String value1, String value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(String value1, String value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(java.util.List<java.lang.String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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
    log_warn_ruleaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
        public Criteria andFNameLike(String value) {
            addCriterion(" name like", value, "name");
            return (Criteria) this;
        }
        public Criteria andFWarnDescriptionLike(String value) {
            addCriterion(" warn_description like", value, "warnDescription");
            return (Criteria) this;
        }
        public Criteria andFAppIdIn(java.util.List<java.lang.String> values) {
            if(values.size()==1 && (null==values.get(0)|| values.get(0).equals(""))){
                return (Criteria) this;
            }
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }
        public Criteria andFWarnTypeIn(java.util.List<java.lang.String> values) {
            if(values.size()==1 && (null==values.get(0)|| values.get(0).equals(""))){
                return (Criteria) this;
            }
            addCriterion("warn_type in", values, "warnType");
            return (Criteria) this;
        }
        public Criteria andFWarnLevelIn(java.util.List<java.lang.String> values) {
            if(values.size()==1 && (null==values.get(0)|| values.get(0).equals(""))){
                return (Criteria) this;
            }
            addCriterion("warn_level in", values, "warnLevel");
            return (Criteria) this;
        }
    }
}