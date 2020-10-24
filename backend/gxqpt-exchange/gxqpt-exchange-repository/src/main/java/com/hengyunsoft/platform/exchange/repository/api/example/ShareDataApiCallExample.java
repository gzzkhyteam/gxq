package com.hengyunsoft.platform.exchange.repository.api.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareDataApiCallExample extends com.hengyunsoft.db.example.BaseExample<ShareDataApiCallExample.Criteria> implements Serializable {
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

        public Criteria andApiIdIsNull() {
            addCriterion("api_id is null");
            return (Criteria) this;
        }

        public Criteria andApiIdIsNotNull() {
            addCriterion("api_id is not null");
            return (Criteria) this;
        }

        public Criteria andApiIdEqualTo(Long value) {
            addCriterion("api_id =", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotEqualTo(Long value) {
            addCriterion("api_id <>", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThan(Long value) {
            addCriterion("api_id >", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThanOrEqualTo(Long value) {
            addCriterion("api_id >=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThan(Long value) {
            addCriterion("api_id <", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThanOrEqualTo(Long value) {
            addCriterion("api_id <=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("api_id in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("api_id not in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdBetween(Long value1, Long value2) {
            addCriterion("api_id between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotBetween(Long value1, Long value2) {
            addCriterion("api_id not between", value1, value2, "apiId");
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

        public Criteria andDataCountIsNull() {
            addCriterion("data_count is null");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNotNull() {
            addCriterion("data_count is not null");
            return (Criteria) this;
        }

        public Criteria andDataCountEqualTo(Integer value) {
            addCriterion("data_count =", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotEqualTo(Integer value) {
            addCriterion("data_count <>", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThan(Integer value) {
            addCriterion("data_count >", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_count >=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThan(Integer value) {
            addCriterion("data_count <", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThanOrEqualTo(Integer value) {
            addCriterion("data_count <=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_count in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_count not in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountBetween(Integer value1, Integer value2) {
            addCriterion("data_count between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotBetween(Integer value1, Integer value2) {
            addCriterion("data_count not between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNull() {
            addCriterion("ip_address is null");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNotNull() {
            addCriterion("ip_address is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddressEqualTo(String value) {
            addCriterion("ip_address =", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotEqualTo(String value) {
            addCriterion("ip_address <>", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThan(String value) {
            addCriterion("ip_address >", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ip_address >=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThan(String value) {
            addCriterion("ip_address <", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            addCriterion("ip_address <=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLike(String value) {
            addCriterion("ip_address like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotLike(String value) {
            addCriterion("ip_address not like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("ip_address in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ip_address not in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressBetween(String value1, String value2) {
            addCriterion("ip_address between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotBetween(String value1, String value2) {
            addCriterion("ip_address not between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIsSuccessIsNull() {
            addCriterion("is_success is null");
            return (Criteria) this;
        }

        public Criteria andIsSuccessIsNotNull() {
            addCriterion("is_success is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuccessEqualTo(Integer value) {
            addCriterion("is_success =", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessNotEqualTo(Integer value) {
            addCriterion("is_success <>", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessGreaterThan(Integer value) {
            addCriterion("is_success >", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_success >=", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessLessThan(Integer value) {
            addCriterion("is_success <", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("is_success <=", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_success in", values, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("is_success not in", values, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessBetween(Integer value1, Integer value2) {
            addCriterion("is_success between", value1, value2, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("is_success not between", value1, value2, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeIsNull() {
            addCriterion("rsponse_time is null");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeIsNotNull() {
            addCriterion("rsponse_time is not null");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeEqualTo(Float value) {
            addCriterion("rsponse_time =", value, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeNotEqualTo(Float value) {
            addCriterion("rsponse_time <>", value, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeGreaterThan(Float value) {
            addCriterion("rsponse_time >", value, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeGreaterThanOrEqualTo(Float value) {
            addCriterion("rsponse_time >=", value, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeLessThan(Float value) {
            addCriterion("rsponse_time <", value, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeLessThanOrEqualTo(Float value) {
            addCriterion("rsponse_time <=", value, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeIn(java.util.List<java.lang.Float> values) {
            addCriterion("rsponse_time in", values, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("rsponse_time not in", values, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeBetween(Float value1, Float value2) {
            addCriterion("rsponse_time between", value1, value2, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andRsponseTimeNotBetween(Float value1, Float value2) {
            addCriterion("rsponse_time not between", value1, value2, "rsponseTime");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(java.util.List<java.lang.String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(java.util.List<java.lang.String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNull() {
            addCriterion("visit_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNotNull() {
            addCriterion("visit_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEqualTo(Date value) {
            addCriterion("visit_time =", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotEqualTo(Date value) {
            addCriterion("visit_time <>", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThan(Date value) {
            addCriterion("visit_time >", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_time >=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThan(Date value) {
            addCriterion("visit_time <", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThanOrEqualTo(Date value) {
            addCriterion("visit_time <=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("visit_time in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("visit_time not in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeBetween(Date value1, Date value2) {
            addCriterion("visit_time between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotBetween(Date value1, Date value2) {
            addCriterion("visit_time not between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andFailTypeIsNull() {
            addCriterion("fail_type is null");
            return (Criteria) this;
        }

        public Criteria andFailTypeIsNotNull() {
            addCriterion("fail_type is not null");
            return (Criteria) this;
        }

        public Criteria andFailTypeEqualTo(Integer value) {
            addCriterion("fail_type =", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeNotEqualTo(Integer value) {
            addCriterion("fail_type <>", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeGreaterThan(Integer value) {
            addCriterion("fail_type >", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fail_type >=", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeLessThan(Integer value) {
            addCriterion("fail_type <", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fail_type <=", value, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("fail_type in", values, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("fail_type not in", values, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeBetween(Integer value1, Integer value2) {
            addCriterion("fail_type between", value1, value2, "failType");
            return (Criteria) this;
        }

        public Criteria andFailTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fail_type not between", value1, value2, "failType");
            return (Criteria) this;
        }

        public Criteria andFailLogIsNull() {
            addCriterion("fail_log is null");
            return (Criteria) this;
        }

        public Criteria andFailLogIsNotNull() {
            addCriterion("fail_log is not null");
            return (Criteria) this;
        }

        public Criteria andFailLogEqualTo(String value) {
            addCriterion("fail_log =", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogNotEqualTo(String value) {
            addCriterion("fail_log <>", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogGreaterThan(String value) {
            addCriterion("fail_log >", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogGreaterThanOrEqualTo(String value) {
            addCriterion("fail_log >=", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogLessThan(String value) {
            addCriterion("fail_log <", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogLessThanOrEqualTo(String value) {
            addCriterion("fail_log <=", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogLike(String value) {
            addCriterion("fail_log like", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogNotLike(String value) {
            addCriterion("fail_log not like", value, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogIn(java.util.List<java.lang.String> values) {
            addCriterion("fail_log in", values, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogNotIn(java.util.List<java.lang.String> values) {
            addCriterion("fail_log not in", values, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogBetween(String value1, String value2) {
            addCriterion("fail_log between", value1, value2, "failLog");
            return (Criteria) this;
        }

        public Criteria andFailLogNotBetween(String value1, String value2) {
            addCriterion("fail_log not between", value1, value2, "failLog");
            return (Criteria) this;
        }

        public Criteria andHdleStateIsNull() {
            addCriterion("hdle_state is null");
            return (Criteria) this;
        }

        public Criteria andHdleStateIsNotNull() {
            addCriterion("hdle_state is not null");
            return (Criteria) this;
        }

        public Criteria andHdleStateEqualTo(Integer value) {
            addCriterion("hdle_state =", value, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateNotEqualTo(Integer value) {
            addCriterion("hdle_state <>", value, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateGreaterThan(Integer value) {
            addCriterion("hdle_state >", value, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("hdle_state >=", value, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateLessThan(Integer value) {
            addCriterion("hdle_state <", value, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateLessThanOrEqualTo(Integer value) {
            addCriterion("hdle_state <=", value, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateIn(java.util.List<java.lang.Integer> values) {
            addCriterion("hdle_state in", values, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("hdle_state not in", values, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateBetween(Integer value1, Integer value2) {
            addCriterion("hdle_state between", value1, value2, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleStateNotBetween(Integer value1, Integer value2) {
            addCriterion("hdle_state not between", value1, value2, "hdleState");
            return (Criteria) this;
        }

        public Criteria andHdleUserIsNull() {
            addCriterion("hdle_user is null");
            return (Criteria) this;
        }

        public Criteria andHdleUserIsNotNull() {
            addCriterion("hdle_user is not null");
            return (Criteria) this;
        }

        public Criteria andHdleUserEqualTo(Long value) {
            addCriterion("hdle_user =", value, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserNotEqualTo(Long value) {
            addCriterion("hdle_user <>", value, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserGreaterThan(Long value) {
            addCriterion("hdle_user >", value, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserGreaterThanOrEqualTo(Long value) {
            addCriterion("hdle_user >=", value, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserLessThan(Long value) {
            addCriterion("hdle_user <", value, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserLessThanOrEqualTo(Long value) {
            addCriterion("hdle_user <=", value, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("hdle_user in", values, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("hdle_user not in", values, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserBetween(Long value1, Long value2) {
            addCriterion("hdle_user between", value1, value2, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleUserNotBetween(Long value1, Long value2) {
            addCriterion("hdle_user not between", value1, value2, "hdleUser");
            return (Criteria) this;
        }

        public Criteria andHdleTimeIsNull() {
            addCriterion("hdle_time is null");
            return (Criteria) this;
        }

        public Criteria andHdleTimeIsNotNull() {
            addCriterion("hdle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHdleTimeEqualTo(Date value) {
            addCriterion("hdle_time =", value, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeNotEqualTo(Date value) {
            addCriterion("hdle_time <>", value, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeGreaterThan(Date value) {
            addCriterion("hdle_time >", value, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hdle_time >=", value, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeLessThan(Date value) {
            addCriterion("hdle_time <", value, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeLessThanOrEqualTo(Date value) {
            addCriterion("hdle_time <=", value, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("hdle_time in", values, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("hdle_time not in", values, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeBetween(Date value1, Date value2) {
            addCriterion("hdle_time between", value1, value2, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleTimeNotBetween(Date value1, Date value2) {
            addCriterion("hdle_time not between", value1, value2, "hdleTime");
            return (Criteria) this;
        }

        public Criteria andHdleContentIsNull() {
            addCriterion("hdle_content is null");
            return (Criteria) this;
        }

        public Criteria andHdleContentIsNotNull() {
            addCriterion("hdle_content is not null");
            return (Criteria) this;
        }

        public Criteria andHdleContentEqualTo(String value) {
            addCriterion("hdle_content =", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentNotEqualTo(String value) {
            addCriterion("hdle_content <>", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentGreaterThan(String value) {
            addCriterion("hdle_content >", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentGreaterThanOrEqualTo(String value) {
            addCriterion("hdle_content >=", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentLessThan(String value) {
            addCriterion("hdle_content <", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentLessThanOrEqualTo(String value) {
            addCriterion("hdle_content <=", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentLike(String value) {
            addCriterion("hdle_content like", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentNotLike(String value) {
            addCriterion("hdle_content not like", value, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentIn(java.util.List<java.lang.String> values) {
            addCriterion("hdle_content in", values, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("hdle_content not in", values, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentBetween(String value1, String value2) {
            addCriterion("hdle_content between", value1, value2, "hdleContent");
            return (Criteria) this;
        }

        public Criteria andHdleContentNotBetween(String value1, String value2) {
            addCriterion("hdle_content not between", value1, value2, "hdleContent");
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
    }

    /**
    b_share_data_api_calladdClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}