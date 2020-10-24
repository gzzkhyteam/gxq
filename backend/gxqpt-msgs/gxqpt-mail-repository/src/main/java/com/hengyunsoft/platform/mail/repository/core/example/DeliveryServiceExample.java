package com.hengyunsoft.platform.mail.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryServiceExample extends com.hengyunsoft.db.example.BaseExample<DeliveryServiceExample.Criteria> implements Serializable {
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

        public Criteria andMaxThreadSumIsNull() {
            addCriterion("max_thread_sum is null");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumIsNotNull() {
            addCriterion("max_thread_sum is not null");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumEqualTo(String value) {
            addCriterion("max_thread_sum =", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumNotEqualTo(String value) {
            addCriterion("max_thread_sum <>", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumGreaterThan(String value) {
            addCriterion("max_thread_sum >", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumGreaterThanOrEqualTo(String value) {
            addCriterion("max_thread_sum >=", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumLessThan(String value) {
            addCriterion("max_thread_sum <", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumLessThanOrEqualTo(String value) {
            addCriterion("max_thread_sum <=", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumLike(String value) {
            addCriterion("max_thread_sum like", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumNotLike(String value) {
            addCriterion("max_thread_sum not like", value, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumIn(java.util.List<java.lang.String> values) {
            addCriterion("max_thread_sum in", values, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumNotIn(java.util.List<java.lang.String> values) {
            addCriterion("max_thread_sum not in", values, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumBetween(String value1, String value2) {
            addCriterion("max_thread_sum between", value1, value2, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSumNotBetween(String value1, String value2) {
            addCriterion("max_thread_sum not between", value1, value2, "maxThreadSum");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalIsNull() {
            addCriterion("time_interval is null");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalIsNotNull() {
            addCriterion("time_interval is not null");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalEqualTo(String value) {
            addCriterion("time_interval =", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalNotEqualTo(String value) {
            addCriterion("time_interval <>", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalGreaterThan(String value) {
            addCriterion("time_interval >", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalGreaterThanOrEqualTo(String value) {
            addCriterion("time_interval >=", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalLessThan(String value) {
            addCriterion("time_interval <", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalLessThanOrEqualTo(String value) {
            addCriterion("time_interval <=", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalLike(String value) {
            addCriterion("time_interval like", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalNotLike(String value) {
            addCriterion("time_interval not like", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalIn(java.util.List<java.lang.String> values) {
            addCriterion("time_interval in", values, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalNotIn(java.util.List<java.lang.String> values) {
            addCriterion("time_interval not in", values, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalBetween(String value1, String value2) {
            addCriterion("time_interval between", value1, value2, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalNotBetween(String value1, String value2) {
            addCriterion("time_interval not between", value1, value2, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondIsNull() {
            addCriterion("max_thread_second is null");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondIsNotNull() {
            addCriterion("max_thread_second is not null");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondEqualTo(String value) {
            addCriterion("max_thread_second =", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondNotEqualTo(String value) {
            addCriterion("max_thread_second <>", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondGreaterThan(String value) {
            addCriterion("max_thread_second >", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondGreaterThanOrEqualTo(String value) {
            addCriterion("max_thread_second >=", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondLessThan(String value) {
            addCriterion("max_thread_second <", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondLessThanOrEqualTo(String value) {
            addCriterion("max_thread_second <=", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondLike(String value) {
            addCriterion("max_thread_second like", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondNotLike(String value) {
            addCriterion("max_thread_second not like", value, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondIn(java.util.List<java.lang.String> values) {
            addCriterion("max_thread_second in", values, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondNotIn(java.util.List<java.lang.String> values) {
            addCriterion("max_thread_second not in", values, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondBetween(String value1, String value2) {
            addCriterion("max_thread_second between", value1, value2, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andMaxThreadSecondNotBetween(String value1, String value2) {
            addCriterion("max_thread_second not between", value1, value2, "maxThreadSecond");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateIsNull() {
            addCriterion("interval_increase_rate is null");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateIsNotNull() {
            addCriterion("interval_increase_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateEqualTo(String value) {
            addCriterion("interval_increase_rate =", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateNotEqualTo(String value) {
            addCriterion("interval_increase_rate <>", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateGreaterThan(String value) {
            addCriterion("interval_increase_rate >", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateGreaterThanOrEqualTo(String value) {
            addCriterion("interval_increase_rate >=", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateLessThan(String value) {
            addCriterion("interval_increase_rate <", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateLessThanOrEqualTo(String value) {
            addCriterion("interval_increase_rate <=", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateLike(String value) {
            addCriterion("interval_increase_rate like", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateNotLike(String value) {
            addCriterion("interval_increase_rate not like", value, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateIn(java.util.List<java.lang.String> values) {
            addCriterion("interval_increase_rate in", values, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateNotIn(java.util.List<java.lang.String> values) {
            addCriterion("interval_increase_rate not in", values, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateBetween(String value1, String value2) {
            addCriterion("interval_increase_rate between", value1, value2, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andIntervalIncreaseRateNotBetween(String value1, String value2) {
            addCriterion("interval_increase_rate not between", value1, value2, "intervalIncreaseRate");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpIsNull() {
            addCriterion("out_binding_ip is null");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpIsNotNull() {
            addCriterion("out_binding_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpEqualTo(String value) {
            addCriterion("out_binding_ip =", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpNotEqualTo(String value) {
            addCriterion("out_binding_ip <>", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpGreaterThan(String value) {
            addCriterion("out_binding_ip >", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpGreaterThanOrEqualTo(String value) {
            addCriterion("out_binding_ip >=", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpLessThan(String value) {
            addCriterion("out_binding_ip <", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpLessThanOrEqualTo(String value) {
            addCriterion("out_binding_ip <=", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpLike(String value) {
            addCriterion("out_binding_ip like", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpNotLike(String value) {
            addCriterion("out_binding_ip not like", value, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpIn(java.util.List<java.lang.String> values) {
            addCriterion("out_binding_ip in", values, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("out_binding_ip not in", values, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpBetween(String value1, String value2) {
            addCriterion("out_binding_ip between", value1, value2, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andOutBindingIpNotBetween(String value1, String value2) {
            addCriterion("out_binding_ip not between", value1, value2, "outBindingIp");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutIsNull() {
            addCriterion("connection_timeout is null");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutIsNotNull() {
            addCriterion("connection_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutEqualTo(String value) {
            addCriterion("connection_timeout =", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutNotEqualTo(String value) {
            addCriterion("connection_timeout <>", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutGreaterThan(String value) {
            addCriterion("connection_timeout >", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutGreaterThanOrEqualTo(String value) {
            addCriterion("connection_timeout >=", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutLessThan(String value) {
            addCriterion("connection_timeout <", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutLessThanOrEqualTo(String value) {
            addCriterion("connection_timeout <=", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutLike(String value) {
            addCriterion("connection_timeout like", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutNotLike(String value) {
            addCriterion("connection_timeout not like", value, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutIn(java.util.List<java.lang.String> values) {
            addCriterion("connection_timeout in", values, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutNotIn(java.util.List<java.lang.String> values) {
            addCriterion("connection_timeout not in", values, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutBetween(String value1, String value2) {
            addCriterion("connection_timeout between", value1, value2, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andConnectionTimeoutNotBetween(String value1, String value2) {
            addCriterion("connection_timeout not between", value1, value2, "connectionTimeout");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileIsNull() {
            addCriterion("is_exception_file is null");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileIsNotNull() {
            addCriterion("is_exception_file is not null");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileEqualTo(String value) {
            addCriterion("is_exception_file =", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileNotEqualTo(String value) {
            addCriterion("is_exception_file <>", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileGreaterThan(String value) {
            addCriterion("is_exception_file >", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileGreaterThanOrEqualTo(String value) {
            addCriterion("is_exception_file >=", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileLessThan(String value) {
            addCriterion("is_exception_file <", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileLessThanOrEqualTo(String value) {
            addCriterion("is_exception_file <=", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileLike(String value) {
            addCriterion("is_exception_file like", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileNotLike(String value) {
            addCriterion("is_exception_file not like", value, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileIn(java.util.List<java.lang.String> values) {
            addCriterion("is_exception_file in", values, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_exception_file not in", values, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileBetween(String value1, String value2) {
            addCriterion("is_exception_file between", value1, value2, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsExceptionFileNotBetween(String value1, String value2) {
            addCriterion("is_exception_file not between", value1, value2, "isExceptionFile");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesIsNull() {
            addCriterion("is_filtering_rules is null");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesIsNotNull() {
            addCriterion("is_filtering_rules is not null");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesEqualTo(String value) {
            addCriterion("is_filtering_rules =", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesNotEqualTo(String value) {
            addCriterion("is_filtering_rules <>", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesGreaterThan(String value) {
            addCriterion("is_filtering_rules >", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesGreaterThanOrEqualTo(String value) {
            addCriterion("is_filtering_rules >=", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesLessThan(String value) {
            addCriterion("is_filtering_rules <", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesLessThanOrEqualTo(String value) {
            addCriterion("is_filtering_rules <=", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesLike(String value) {
            addCriterion("is_filtering_rules like", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesNotLike(String value) {
            addCriterion("is_filtering_rules not like", value, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesIn(java.util.List<java.lang.String> values) {
            addCriterion("is_filtering_rules in", values, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_filtering_rules not in", values, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesBetween(String value1, String value2) {
            addCriterion("is_filtering_rules between", value1, value2, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsFilteringRulesNotBetween(String value1, String value2) {
            addCriterion("is_filtering_rules not between", value1, value2, "isFilteringRules");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailIsNull() {
            addCriterion("is_conver_detail is null");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailIsNotNull() {
            addCriterion("is_conver_detail is not null");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailEqualTo(String value) {
            addCriterion("is_conver_detail =", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailNotEqualTo(String value) {
            addCriterion("is_conver_detail <>", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailGreaterThan(String value) {
            addCriterion("is_conver_detail >", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailGreaterThanOrEqualTo(String value) {
            addCriterion("is_conver_detail >=", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailLessThan(String value) {
            addCriterion("is_conver_detail <", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailLessThanOrEqualTo(String value) {
            addCriterion("is_conver_detail <=", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailLike(String value) {
            addCriterion("is_conver_detail like", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailNotLike(String value) {
            addCriterion("is_conver_detail not like", value, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailIn(java.util.List<java.lang.String> values) {
            addCriterion("is_conver_detail in", values, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_conver_detail not in", values, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailBetween(String value1, String value2) {
            addCriterion("is_conver_detail between", value1, value2, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andIsConverDetailNotBetween(String value1, String value2) {
            addCriterion("is_conver_detail not between", value1, value2, "isConverDetail");
            return (Criteria) this;
        }

        public Criteria andErrorTermListIsNull() {
            addCriterion("error_term_list is null");
            return (Criteria) this;
        }

        public Criteria andErrorTermListIsNotNull() {
            addCriterion("error_term_list is not null");
            return (Criteria) this;
        }

        public Criteria andErrorTermListEqualTo(String value) {
            addCriterion("error_term_list =", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListNotEqualTo(String value) {
            addCriterion("error_term_list <>", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListGreaterThan(String value) {
            addCriterion("error_term_list >", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListGreaterThanOrEqualTo(String value) {
            addCriterion("error_term_list >=", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListLessThan(String value) {
            addCriterion("error_term_list <", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListLessThanOrEqualTo(String value) {
            addCriterion("error_term_list <=", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListLike(String value) {
            addCriterion("error_term_list like", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListNotLike(String value) {
            addCriterion("error_term_list not like", value, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListIn(java.util.List<java.lang.String> values) {
            addCriterion("error_term_list in", values, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListNotIn(java.util.List<java.lang.String> values) {
            addCriterion("error_term_list not in", values, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListBetween(String value1, String value2) {
            addCriterion("error_term_list between", value1, value2, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andErrorTermListNotBetween(String value1, String value2) {
            addCriterion("error_term_list not between", value1, value2, "errorTermList");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumIsNull() {
            addCriterion("max_attempts_sum is null");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumIsNotNull() {
            addCriterion("max_attempts_sum is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumEqualTo(String value) {
            addCriterion("max_attempts_sum =", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumNotEqualTo(String value) {
            addCriterion("max_attempts_sum <>", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumGreaterThan(String value) {
            addCriterion("max_attempts_sum >", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumGreaterThanOrEqualTo(String value) {
            addCriterion("max_attempts_sum >=", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumLessThan(String value) {
            addCriterion("max_attempts_sum <", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumLessThanOrEqualTo(String value) {
            addCriterion("max_attempts_sum <=", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumLike(String value) {
            addCriterion("max_attempts_sum like", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumNotLike(String value) {
            addCriterion("max_attempts_sum not like", value, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumIn(java.util.List<java.lang.String> values) {
            addCriterion("max_attempts_sum in", values, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumNotIn(java.util.List<java.lang.String> values) {
            addCriterion("max_attempts_sum not in", values, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumBetween(String value1, String value2) {
            addCriterion("max_attempts_sum between", value1, value2, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxAttemptsSumNotBetween(String value1, String value2) {
            addCriterion("max_attempts_sum not between", value1, value2, "maxAttemptsSum");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodIsNull() {
            addCriterion("max_moreover_sencod is null");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodIsNotNull() {
            addCriterion("max_moreover_sencod is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodEqualTo(String value) {
            addCriterion("max_moreover_sencod =", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodNotEqualTo(String value) {
            addCriterion("max_moreover_sencod <>", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodGreaterThan(String value) {
            addCriterion("max_moreover_sencod >", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodGreaterThanOrEqualTo(String value) {
            addCriterion("max_moreover_sencod >=", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodLessThan(String value) {
            addCriterion("max_moreover_sencod <", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodLessThanOrEqualTo(String value) {
            addCriterion("max_moreover_sencod <=", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodLike(String value) {
            addCriterion("max_moreover_sencod like", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodNotLike(String value) {
            addCriterion("max_moreover_sencod not like", value, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodIn(java.util.List<java.lang.String> values) {
            addCriterion("max_moreover_sencod in", values, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodNotIn(java.util.List<java.lang.String> values) {
            addCriterion("max_moreover_sencod not in", values, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodBetween(String value1, String value2) {
            addCriterion("max_moreover_sencod between", value1, value2, "maxMoreoverSencod");
            return (Criteria) this;
        }

        public Criteria andMaxMoreoverSencodNotBetween(String value1, String value2) {
            addCriterion("max_moreover_sencod not between", value1, value2, "maxMoreoverSencod");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
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
    mail_delivery_serviceaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}