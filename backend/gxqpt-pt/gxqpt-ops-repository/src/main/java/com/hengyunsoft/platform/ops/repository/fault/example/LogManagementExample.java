package com.hengyunsoft.platform.ops.repository.fault.example;

import java.io.Serializable;
import java.util.Date;

public class LogManagementExample extends com.hengyunsoft.db.example.BaseExample<LogManagementExample.Criteria> implements Serializable {
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

        public Criteria andLogRecordIsNull() {
            addCriterion("log_record is null");
            return (Criteria) this;
        }

        public Criteria andLogRecordIsNotNull() {
            addCriterion("log_record is not null");
            return (Criteria) this;
        }

        public Criteria andLogRecordEqualTo(String value) {
            addCriterion("log_record =", value, "logRecord");
            return (Criteria) this;
        }

        public Criteria andLogRecordLike(String value) {
            addCriterion("log_record like", value, "logRecord");
            return (Criteria) this;
        }

        public Criteria andLogRecordNotLike(String value) {
            addCriterion("log_record not like", value, "logRecord");
            return (Criteria) this;
        }

        public Criteria andLogRecordIn(java.util.List<java.lang.String> values) {
            addCriterion("log_record in", values, "logRecord");
            return (Criteria) this;
        }

        public Criteria andLogRecordNotIn(java.util.List<java.lang.String> values) {
            addCriterion("log_record not in", values, "logRecord");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIsNull() {
            addCriterion("fault_level is null");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIsNotNull() {
            addCriterion("fault_level is not null");
            return (Criteria) this;
        }

        public Criteria andFaultLevelEqualTo(String value) {
            addCriterion("fault_level =", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelLike(String value) {
            addCriterion("fault_level like", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotLike(String value) {
            addCriterion("fault_level not like", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_level in", values, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_level not in", values, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultClassificationIsNull() {
            addCriterion("fault_classification is null");
            return (Criteria) this;
        }

        public Criteria andFaultClassificationIsNotNull() {
            addCriterion("fault_classification is not null");
            return (Criteria) this;
        }

        public Criteria andFaultClassificationEqualTo(String value) {
            addCriterion("fault_classification =", value, "faultClassification");
            return (Criteria) this;
        }

        public Criteria andFaultClassificationLike(String value) {
            addCriterion("fault_classification like", value, "faultClassification");
            return (Criteria) this;
        }

        public Criteria andFaultClassificationNotLike(String value) {
            addCriterion("fault_classification not like", value, "faultClassification");
            return (Criteria) this;
        }

        public Criteria andFaultClassificationIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_classification in", values, "faultClassification");
            return (Criteria) this;
        }

        public Criteria andFaultClassificationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fault_classification not in", values, "faultClassification");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNull() {
            addCriterion("deal_user is null");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNotNull() {
            addCriterion("deal_user is not null");
            return (Criteria) this;
        }

        public Criteria andDealUserEqualTo(Long value) {
            addCriterion("deal_user =", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThan(Long value) {
            addCriterion("deal_user >", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThanOrEqualTo(Long value) {
            addCriterion("deal_user >=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThan(Long value) {
            addCriterion("deal_user <", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThanOrEqualTo(Long value) {
            addCriterion("deal_user <=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("deal_user in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("deal_user not in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserBetween(Long value1, Long value2) {
            addCriterion("deal_user between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualToFooter(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualToTop(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
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
    }

    /**
    b_yw_log_managementaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}