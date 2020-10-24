package com.hengyunsoft.platform.developer.repository.core.example;

import java.io.Serializable;
import java.util.Date;

public class ModuleUseInfoExample extends com.hengyunsoft.db.example.BaseExample<ModuleUseInfoExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

        public GeneratedCriteria() {
            super();
        }

        public Criteria andCombineIdIsNull() {
            addCriterion("combine_id is null");
            return (Criteria) this;
        }

        public Criteria andCombineIdIsNotNull() {
            addCriterion("combine_id is not null");
            return (Criteria) this;
        }

        public Criteria andCombineIdEqualTo(String value) {
            addCriterion("combine_id =", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotEqualTo(String value) {
            addCriterion("combine_id <>", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdGreaterThan(String value) {
            addCriterion("combine_id >", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdGreaterThanOrEqualTo(String value) {
            addCriterion("combine_id >=", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdLessThan(String value) {
            addCriterion("combine_id <", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdLessThanOrEqualTo(String value) {
            addCriterion("combine_id <=", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdLike(String value) {
            addCriterion("combine_id like", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotLike(String value) {
            addCriterion("combine_id not like", value, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdIn(java.util.List<java.lang.String> values) {
            addCriterion("combine_id in", values, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("combine_id not in", values, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdBetween(String value1, String value2) {
            addCriterion("combine_id between", value1, value2, "combineId");
            return (Criteria) this;
        }

        public Criteria andCombineIdNotBetween(String value1, String value2) {
            addCriterion("combine_id not between", value1, value2, "combineId");
            return (Criteria) this;
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

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(String value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(String value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(String value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(String value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(String value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLike(String value) {
            addCriterion("module_id like", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotLike(String value) {
            addCriterion("module_id not like", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(java.util.List<java.lang.String> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(String value1, String value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(String value1, String value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
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

        public Criteria andUseYearIsNull() {
            addCriterion("use_year is null");
            return (Criteria) this;
        }

        public Criteria andUseYearIsNotNull() {
            addCriterion("use_year is not null");
            return (Criteria) this;
        }

        public Criteria andUseYearEqualTo(String value) {
            addCriterion("use_year =", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotEqualTo(String value) {
            addCriterion("use_year <>", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearGreaterThan(String value) {
            addCriterion("use_year >", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearGreaterThanOrEqualTo(String value) {
            addCriterion("use_year >=", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLessThan(String value) {
            addCriterion("use_year <", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLessThanOrEqualTo(String value) {
            addCriterion("use_year <=", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLike(String value) {
            addCriterion("use_year like", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotLike(String value) {
            addCriterion("use_year not like", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearIn(java.util.List<java.lang.String> values) {
            addCriterion("use_year in", values, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotIn(java.util.List<java.lang.String> values) {
            addCriterion("use_year not in", values, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearBetween(String value1, String value2) {
            addCriterion("use_year between", value1, value2, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotBetween(String value1, String value2) {
            addCriterion("use_year not between", value1, value2, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseMonthIsNull() {
            addCriterion("use_month is null");
            return (Criteria) this;
        }

        public Criteria andUseMonthIsNotNull() {
            addCriterion("use_month is not null");
            return (Criteria) this;
        }

        public Criteria andUseMonthEqualTo(String value) {
            addCriterion("use_month =", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthNotEqualTo(String value) {
            addCriterion("use_month <>", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthGreaterThan(String value) {
            addCriterion("use_month >", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthGreaterThanOrEqualTo(String value) {
            addCriterion("use_month >=", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthLessThan(String value) {
            addCriterion("use_month <", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthLessThanOrEqualTo(String value) {
            addCriterion("use_month <=", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthLike(String value) {
            addCriterion("use_month like", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthNotLike(String value) {
            addCriterion("use_month not like", value, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthIn(java.util.List<java.lang.String> values) {
            addCriterion("use_month in", values, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthNotIn(java.util.List<java.lang.String> values) {
            addCriterion("use_month not in", values, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthBetween(String value1, String value2) {
            addCriterion("use_month between", value1, value2, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseMonthNotBetween(String value1, String value2) {
            addCriterion("use_month not between", value1, value2, "useMonth");
            return (Criteria) this;
        }

        public Criteria andUseDayIsNull() {
            addCriterion("use_day is null");
            return (Criteria) this;
        }

        public Criteria andUseDayIsNotNull() {
            addCriterion("use_day is not null");
            return (Criteria) this;
        }

        public Criteria andUseDayEqualTo(String value) {
            addCriterion("use_day =", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayNotEqualTo(String value) {
            addCriterion("use_day <>", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayGreaterThan(String value) {
            addCriterion("use_day >", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayGreaterThanOrEqualTo(String value) {
            addCriterion("use_day >=", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayLessThan(String value) {
            addCriterion("use_day <", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayLessThanOrEqualTo(String value) {
            addCriterion("use_day <=", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayLike(String value) {
            addCriterion("use_day like", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayNotLike(String value) {
            addCriterion("use_day not like", value, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayIn(java.util.List<java.lang.String> values) {
            addCriterion("use_day in", values, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayNotIn(java.util.List<java.lang.String> values) {
            addCriterion("use_day not in", values, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayBetween(String value1, String value2) {
            addCriterion("use_day between", value1, value2, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseDayNotBetween(String value1, String value2) {
            addCriterion("use_day not between", value1, value2, "useDay");
            return (Criteria) this;
        }

        public Criteria andUseHourIsNull() {
            addCriterion("use_hour is null");
            return (Criteria) this;
        }

        public Criteria andUseHourIsNotNull() {
            addCriterion("use_hour is not null");
            return (Criteria) this;
        }

        public Criteria andUseHourEqualTo(String value) {
            addCriterion("use_hour =", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourNotEqualTo(String value) {
            addCriterion("use_hour <>", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourGreaterThan(String value) {
            addCriterion("use_hour >", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourGreaterThanOrEqualTo(String value) {
            addCriterion("use_hour >=", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourLessThan(String value) {
            addCriterion("use_hour <", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourLessThanOrEqualTo(String value) {
            addCriterion("use_hour <=", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourLike(String value) {
            addCriterion("use_hour like", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourNotLike(String value) {
            addCriterion("use_hour not like", value, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourIn(java.util.List<java.lang.String> values) {
            addCriterion("use_hour in", values, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourNotIn(java.util.List<java.lang.String> values) {
            addCriterion("use_hour not in", values, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourBetween(String value1, String value2) {
            addCriterion("use_hour between", value1, value2, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseHourNotBetween(String value1, String value2) {
            addCriterion("use_hour not between", value1, value2, "useHour");
            return (Criteria) this;
        }

        public Criteria andUseWeekendIsNull() {
            addCriterion("use_weekend is null");
            return (Criteria) this;
        }

        public Criteria andUseWeekendIsNotNull() {
            addCriterion("use_weekend is not null");
            return (Criteria) this;
        }

        public Criteria andUseWeekendEqualTo(String value) {
            addCriterion("use_weekend =", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendNotEqualTo(String value) {
            addCriterion("use_weekend <>", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendGreaterThan(String value) {
            addCriterion("use_weekend >", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendGreaterThanOrEqualTo(String value) {
            addCriterion("use_weekend >=", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendLessThan(String value) {
            addCriterion("use_weekend <", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendLessThanOrEqualTo(String value) {
            addCriterion("use_weekend <=", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendLike(String value) {
            addCriterion("use_weekend like", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendNotLike(String value) {
            addCriterion("use_weekend not like", value, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendIn(java.util.List<java.lang.String> values) {
            addCriterion("use_weekend in", values, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendNotIn(java.util.List<java.lang.String> values) {
            addCriterion("use_weekend not in", values, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendBetween(String value1, String value2) {
            addCriterion("use_weekend between", value1, value2, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseWeekendNotBetween(String value1, String value2) {
            addCriterion("use_weekend not between", value1, value2, "useWeekend");
            return (Criteria) this;
        }

        public Criteria andUseQuarterIsNull() {
            addCriterion("use_quarter is null");
            return (Criteria) this;
        }

        public Criteria andUseQuarterIsNotNull() {
            addCriterion("use_quarter is not null");
            return (Criteria) this;
        }

        public Criteria andUseQuarterEqualTo(String value) {
            addCriterion("use_quarter =", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterNotEqualTo(String value) {
            addCriterion("use_quarter <>", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterGreaterThan(String value) {
            addCriterion("use_quarter >", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterGreaterThanOrEqualTo(String value) {
            addCriterion("use_quarter >=", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterLessThan(String value) {
            addCriterion("use_quarter <", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterLessThanOrEqualTo(String value) {
            addCriterion("use_quarter <=", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterLike(String value) {
            addCriterion("use_quarter like", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterNotLike(String value) {
            addCriterion("use_quarter not like", value, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterIn(java.util.List<java.lang.String> values) {
            addCriterion("use_quarter in", values, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterNotIn(java.util.List<java.lang.String> values) {
            addCriterion("use_quarter not in", values, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterBetween(String value1, String value2) {
            addCriterion("use_quarter between", value1, value2, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andUseQuarterNotBetween(String value1, String value2) {
            addCriterion("use_quarter not between", value1, value2, "useQuarter");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("total_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("total_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(Integer value) {
            addCriterion("total_num =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(Integer value) {
            addCriterion("total_num <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(Integer value) {
            addCriterion("total_num >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_num >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(Integer value) {
            addCriterion("total_num <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_num <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("total_num in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("total_num not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("total_num between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_num not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumIsNull() {
            addCriterion("error_num is null");
            return (Criteria) this;
        }

        public Criteria andErrorNumIsNotNull() {
            addCriterion("error_num is not null");
            return (Criteria) this;
        }

        public Criteria andErrorNumEqualTo(Integer value) {
            addCriterion("error_num =", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumNotEqualTo(Integer value) {
            addCriterion("error_num <>", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumGreaterThan(Integer value) {
            addCriterion("error_num >", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_num >=", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumLessThan(Integer value) {
            addCriterion("error_num <", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumLessThanOrEqualTo(Integer value) {
            addCriterion("error_num <=", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("error_num in", values, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("error_num not in", values, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumBetween(Integer value1, Integer value2) {
            addCriterion("error_num between", value1, value2, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumNotBetween(Integer value1, Integer value2) {
            addCriterion("error_num not between", value1, value2, "errorNum");
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
    c_module_use_infoaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}