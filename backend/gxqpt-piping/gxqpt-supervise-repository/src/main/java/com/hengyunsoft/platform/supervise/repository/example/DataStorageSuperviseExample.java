package com.hengyunsoft.platform.supervise.repository.example;

import java.io.Serializable;
import java.util.Date;

public class DataStorageSuperviseExample extends com.hengyunsoft.db.example.BaseExample<DataStorageSuperviseExample.Criteria> implements Serializable {
    //------------- 手动新增字段，请写在此后面 -------------
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

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeIsNull() {
            addCriterion("supervise_type is null");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeIsNotNull() {
            addCriterion("supervise_type is not null");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeEqualTo(Short value) {
            addCriterion("supervise_type =", value, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeNotEqualTo(Short value) {
            addCriterion("supervise_type <>", value, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeGreaterThan(Short value) {
            addCriterion("supervise_type >", value, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("supervise_type >=", value, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeLessThan(Short value) {
            addCriterion("supervise_type <", value, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeLessThanOrEqualTo(Short value) {
            addCriterion("supervise_type <=", value, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeIn(java.util.List<java.lang.Short> values) {
            addCriterion("supervise_type in", values, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("supervise_type not in", values, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeBetween(Short value1, Short value2) {
            addCriterion("supervise_type between", value1, value2, "superviseType");
            return (Criteria) this;
        }

        public Criteria andSuperviseTypeNotBetween(Short value1, Short value2) {
            addCriterion("supervise_type not between", value1, value2, "superviseType");
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

        public Criteria andDbSpaceNumIsNull() {
            addCriterion("db_space_num is null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumIsNotNull() {
            addCriterion("db_space_num is not null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumEqualTo(Double value) {
            addCriterion("db_space_num =", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumGreaterThan(Double value) {
            addCriterion("db_space_num >", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumGreaterThanOrEqualTo(Double value) {
            addCriterion("db_space_num >=", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumLessThan(Double value) {
            addCriterion("db_space_num <", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumLessThanOrEqualTo(Double value) {
            addCriterion("db_space_num <=", value, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumIn(java.util.List<java.lang.Double> values) {
            addCriterion("db_space_num in", values, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("db_space_num not in", values, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceNumBetween(Double value1, Double value2) {
            addCriterion("db_space_num between", value1, value2, "dbSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumIsNull() {
            addCriterion("log_space_num is null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumIsNotNull() {
            addCriterion("log_space_num is not null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumEqualTo(Double value) {
            addCriterion("log_space_num =", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumGreaterThan(Double value) {
            addCriterion("log_space_num >", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumGreaterThanOrEqualTo(Double value) {
            addCriterion("log_space_num >=", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumLessThan(Double value) {
            addCriterion("log_space_num <", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumLessThanOrEqualTo(Double value) {
            addCriterion("log_space_num <=", value, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumIn(java.util.List<java.lang.Double> values) {
            addCriterion("log_space_num in", values, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("log_space_num not in", values, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andLogSpaceNumBetween(Double value1, Double value2) {
            addCriterion("log_space_num between", value1, value2, "logSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumIsNull() {
            addCriterion("file_space_num is null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumIsNotNull() {
            addCriterion("file_space_num is not null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumEqualTo(Double value) {
            addCriterion("file_space_num =", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumGreaterThan(Double value) {
            addCriterion("file_space_num >", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumGreaterThanOrEqualTo(Double value) {
            addCriterion("file_space_num >=", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumLessThan(Double value) {
            addCriterion("file_space_num <", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumLessThanOrEqualTo(Double value) {
            addCriterion("file_space_num <=", value, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumIn(java.util.List<java.lang.Double> values) {
            addCriterion("file_space_num in", values, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("file_space_num not in", values, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andFileSpaceNumBetween(Double value1, Double value2) {
            addCriterion("file_space_num between", value1, value2, "fileSpaceNum");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitIsNull() {
            addCriterion("db_space_limit is null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitIsNotNull() {
            addCriterion("db_space_limit is not null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitEqualTo(Double value) {
            addCriterion("db_space_limit =", value, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitGreaterThan(Double value) {
            addCriterion("db_space_limit >", value, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitGreaterThanOrEqualTo(Double value) {
            addCriterion("db_space_limit >=", value, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitLessThan(Double value) {
            addCriterion("db_space_limit <", value, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitLessThanOrEqualTo(Double value) {
            addCriterion("db_space_limit <=", value, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitIn(java.util.List<java.lang.Double> values) {
            addCriterion("db_space_limit in", values, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("db_space_limit not in", values, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andDbSpaceLimitBetween(Double value1, Double value2) {
            addCriterion("db_space_limit between", value1, value2, "dbSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitIsNull() {
            addCriterion("log_space_limit is null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitIsNotNull() {
            addCriterion("log_space_limit is not null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitEqualTo(Double value) {
            addCriterion("log_space_limit =", value, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitGreaterThan(Double value) {
            addCriterion("log_space_limit >", value, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitGreaterThanOrEqualTo(Double value) {
            addCriterion("log_space_limit >=", value, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitLessThan(Double value) {
            addCriterion("log_space_limit <", value, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitLessThanOrEqualTo(Double value) {
            addCriterion("log_space_limit <=", value, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitIn(java.util.List<java.lang.Double> values) {
            addCriterion("log_space_limit in", values, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("log_space_limit not in", values, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andLogSpaceLimitBetween(Double value1, Double value2) {
            addCriterion("log_space_limit between", value1, value2, "logSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitIsNull() {
            addCriterion("file_space_limit is null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitIsNotNull() {
            addCriterion("file_space_limit is not null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitEqualTo(Double value) {
            addCriterion("file_space_limit =", value, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitGreaterThan(Double value) {
            addCriterion("file_space_limit >", value, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitGreaterThanOrEqualTo(Double value) {
            addCriterion("file_space_limit >=", value, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitLessThan(Double value) {
            addCriterion("file_space_limit <", value, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitLessThanOrEqualTo(Double value) {
            addCriterion("file_space_limit <=", value, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitIn(java.util.List<java.lang.Double> values) {
            addCriterion("file_space_limit in", values, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("file_space_limit not in", values, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceLimitBetween(Double value1, Double value2) {
            addCriterion("file_space_limit between", value1, value2, "fileSpaceLimit");
            return (Criteria) this;
        }

        public Criteria andFileSpaceUrlIsNull() {
            addCriterion("file_space_url is null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceUrlIsNotNull() {
            addCriterion("file_space_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileSpaceUrlEqualTo(String value) {
            addCriterion("file_space_url =", value, "fileSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andFileSpaceUrlLike(String value) {
            addCriterion("file_space_url like", value, "fileSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andFileSpaceUrlNotLike(String value) {
            addCriterion("file_space_url not like", value, "fileSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andFileSpaceUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("file_space_url in", values, "fileSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andFileSpaceUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("file_space_url not in", values, "fileSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andLogSpaceUrlIsNull() {
            addCriterion("log_space_url is null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceUrlIsNotNull() {
            addCriterion("log_space_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogSpaceUrlEqualTo(String value) {
            addCriterion("log_space_url =", value, "logSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andLogSpaceUrlLike(String value) {
            addCriterion("log_space_url like", value, "logSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andLogSpaceUrlNotLike(String value) {
            addCriterion("log_space_url not like", value, "logSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andLogSpaceUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("log_space_url in", values, "logSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andLogSpaceUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("log_space_url not in", values, "logSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andDbSpaceUrlIsNull() {
            addCriterion("db_space_url is null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceUrlIsNotNull() {
            addCriterion("db_space_url is not null");
            return (Criteria) this;
        }

        public Criteria andDbSpaceUrlEqualTo(String value) {
            addCriterion("db_space_url =", value, "dbSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andDbSpaceUrlLike(String value) {
            addCriterion("db_space_url like", value, "dbSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andDbSpaceUrlNotLike(String value) {
            addCriterion("db_space_url not like", value, "dbSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andDbSpaceUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("db_space_url in", values, "dbSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andDbSpaceUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("db_space_url not in", values, "dbSpaceUrl");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNull() {
            addCriterion("duty_user is null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNotNull() {
            addCriterion("duty_user is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUserEqualTo(String value) {
            addCriterion("duty_user =", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLike(String value) {
            addCriterion("duty_user like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotLike(String value) {
            addCriterion("duty_user not like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserIn(java.util.List<java.lang.String> values) {
            addCriterion("duty_user in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("duty_user not in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andConfirmUserIsNull() {
            addCriterion("confirm_user is null");
            return (Criteria) this;
        }

        public Criteria andConfirmUserIsNotNull() {
            addCriterion("confirm_user is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmUserEqualTo(String value) {
            addCriterion("confirm_user =", value, "confirmUser");
            return (Criteria) this;
        }

        public Criteria andConfirmUserLike(String value) {
            addCriterion("confirm_user like", value, "confirmUser");
            return (Criteria) this;
        }

        public Criteria andConfirmUserNotLike(String value) {
            addCriterion("confirm_user not like", value, "confirmUser");
            return (Criteria) this;
        }

        public Criteria andConfirmUserIn(java.util.List<java.lang.String> values) {
            addCriterion("confirm_user in", values, "confirmUser");
            return (Criteria) this;
        }

        public Criteria andConfirmUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("confirm_user not in", values, "confirmUser");
            return (Criteria) this;
        }

        public Criteria andCopyUserIsNull() {
            addCriterion("copy_user is null");
            return (Criteria) this;
        }

        public Criteria andCopyUserIsNotNull() {
            addCriterion("copy_user is not null");
            return (Criteria) this;
        }

        public Criteria andCopyUserEqualTo(String value) {
            addCriterion("copy_user =", value, "copyUser");
            return (Criteria) this;
        }

        public Criteria andCopyUserLike(String value) {
            addCriterion("copy_user like", value, "copyUser");
            return (Criteria) this;
        }

        public Criteria andCopyUserNotLike(String value) {
            addCriterion("copy_user not like", value, "copyUser");
            return (Criteria) this;
        }

        public Criteria andCopyUserIn(java.util.List<java.lang.String> values) {
            addCriterion("copy_user in", values, "copyUser");
            return (Criteria) this;
        }

        public Criteria andCopyUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("copy_user not in", values, "copyUser");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeIsNull() {
            addCriterion("scheduled_time is null");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeIsNotNull() {
            addCriterion("scheduled_time is not null");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeGreaterThan(Date value) {
            addCriterion("scheduled_time >", value, "scheduledTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scheduled_time >=", value, "scheduledTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeLessThan(Date value) {
            addCriterion("scheduled_time <", value, "scheduledTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeLessThanOrEqualTo(Date value) {
            addCriterion("scheduled_time <=", value, "scheduledTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeBetween(Date value1, Date value2) {
            addCriterion("scheduled_time between", value1, value2, "scheduledTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeLessThanOrEqualToFooter(Date value) {
            addCriterion("scheduled_time <=", value, "scheduledTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTimeGreaterThanOrEqualToTop(Date value) {
            addCriterion("scheduled_time >=", value, "scheduledTime");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNull() {
            addCriterion("run_status is null");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNotNull() {
            addCriterion("run_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunStatusEqualTo(Boolean value) {
            addCriterion("run_status =", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc_ is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc_ is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc_ =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc_ like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc_ not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(java.util.List<java.lang.String> values) {
            addCriterion("desc_ in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("desc_ not in", values, "desc");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
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

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualToFooter(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualToTop(Date value) {
            addCriterion("create_time >=", value, "createTime");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
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

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualToFooter(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualToTop(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(java.util.List<java.lang.Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }
    }

    /**
    b_data_storage_superviseaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}