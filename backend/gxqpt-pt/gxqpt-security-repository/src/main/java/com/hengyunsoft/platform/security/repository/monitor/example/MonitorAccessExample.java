package com.hengyunsoft.platform.security.repository.monitor.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorAccessExample extends com.hengyunsoft.db.example.BaseExample<MonitorAccessExample.Criteria> implements Serializable {
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

        public Criteria andFromServerIpIsNull() {
            addCriterion("from_server_ip is null");
            return (Criteria) this;
        }

        public Criteria andFromServerIpIsNotNull() {
            addCriterion("from_server_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFromServerIpEqualTo(String value) {
            addCriterion("from_server_ip =", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpNotEqualTo(String value) {
            addCriterion("from_server_ip <>", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpGreaterThan(String value) {
            addCriterion("from_server_ip >", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpGreaterThanOrEqualTo(String value) {
            addCriterion("from_server_ip >=", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpLessThan(String value) {
            addCriterion("from_server_ip <", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpLessThanOrEqualTo(String value) {
            addCriterion("from_server_ip <=", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpLike(String value) {
            addCriterion("from_server_ip like", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpNotLike(String value) {
            addCriterion("from_server_ip not like", value, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpIn(java.util.List<java.lang.String> values) {
            addCriterion("from_server_ip in", values, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("from_server_ip not in", values, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpBetween(String value1, String value2) {
            addCriterion("from_server_ip between", value1, value2, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andFromServerIpNotBetween(String value1, String value2) {
            addCriterion("from_server_ip not between", value1, value2, "fromServerIp");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(java.util.List<java.lang.String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(java.util.List<java.lang.String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeIsNull() {
            addCriterion("logout_time is null");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeIsNotNull() {
            addCriterion("logout_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeEqualTo(Date value) {
            addCriterion("logout_time =", value, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeNotEqualTo(Date value) {
            addCriterion("logout_time <>", value, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeGreaterThan(Date value) {
            addCriterion("logout_time >", value, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("logout_time >=", value, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeLessThan(Date value) {
            addCriterion("logout_time <", value, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeLessThanOrEqualTo(Date value) {
            addCriterion("logout_time <=", value, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("logout_time in", values, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("logout_time not in", values, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeBetween(Date value1, Date value2) {
            addCriterion("logout_time between", value1, value2, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLogoutTimeNotBetween(Date value1, Date value2) {
            addCriterion("logout_time not between", value1, value2, "logoutTime");
            return (Criteria) this;
        }

        public Criteria andLoginDurationIsNull() {
            addCriterion("login_duration is null");
            return (Criteria) this;
        }

        public Criteria andLoginDurationIsNotNull() {
            addCriterion("login_duration is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDurationEqualTo(String value) {
            addCriterion("login_duration =", value, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationNotEqualTo(String value) {
            addCriterion("login_duration <>", value, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationGreaterThan(Integer value) {
            addCriterion("login_duration >", value, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_duration >=", value, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationLessThan(Integer value) {
            addCriterion("login_duration <", value, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationLessThanOrEqualTo(Integer value) {
            addCriterion("login_duration <=", value, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationIn(java.util.List<java.lang.Integer> values) {
            addCriterion("login_duration in", values, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("login_duration not in", values, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationBetween(Integer value1, Integer value2) {
            addCriterion("login_duration between", value1, value2, "loginDuration");
            return (Criteria) this;
        }

        public Criteria andLoginDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("login_duration not between", value1, value2, "loginDuration");
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

        public Criteria andToServerIpIsNull() {
            addCriterion("to_server_ip is null");
            return (Criteria) this;
        }

        public Criteria andToServerIpIsNotNull() {
            addCriterion("to_server_ip is not null");
            return (Criteria) this;
        }

        public Criteria andToServerIpEqualTo(String value) {
            addCriterion("to_server_ip =", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpNotEqualTo(String value) {
            addCriterion("to_server_ip <>", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpGreaterThan(String value) {
            addCriterion("to_server_ip >", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpGreaterThanOrEqualTo(String value) {
            addCriterion("to_server_ip >=", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpLessThan(String value) {
            addCriterion("to_server_ip <", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpLessThanOrEqualTo(String value) {
            addCriterion("to_server_ip <=", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpLike(String value) {
            addCriterion("to_server_ip like", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpNotLike(String value) {
            addCriterion("to_server_ip not like", value, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpIn(java.util.List<java.lang.String> values) {
            addCriterion("to_server_ip in", values, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("to_server_ip not in", values, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpBetween(String value1, String value2) {
            addCriterion("to_server_ip between", value1, value2, "toServerIp");
            return (Criteria) this;
        }

        public Criteria andToServerIpNotBetween(String value1, String value2) {
            addCriterion("to_server_ip not between", value1, value2, "toServerIp");
            return (Criteria) this;
        }
    }

    /**
    se_monitor_accessaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}