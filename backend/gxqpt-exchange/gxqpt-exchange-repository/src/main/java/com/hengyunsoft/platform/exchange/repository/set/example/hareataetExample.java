package com.hengyunsoft.platform.exchange.repository.set.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class hareataetExample extends com.hengyunsoft.db.example.BaseExample<hareataetExample.Criteria> implements Serializable {
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

        public Criteria andApplyCodeIsNull() {
            addCriterion("apply_code is null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIsNotNull() {
            addCriterion("apply_code is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCodeEqualTo(String value) {
            addCriterion("apply_code =", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotEqualTo(String value) {
            addCriterion("apply_code <>", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThan(String value) {
            addCriterion("apply_code >", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_code >=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThan(String value) {
            addCriterion("apply_code <", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLessThanOrEqualTo(String value) {
            addCriterion("apply_code <=", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeLike(String value) {
            addCriterion("apply_code like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotLike(String value) {
            addCriterion("apply_code not like", value, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_code in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_code not in", values, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeBetween(String value1, String value2) {
            addCriterion("apply_code between", value1, value2, "applyCode");
            return (Criteria) this;
        }

        public Criteria andApplyCodeNotBetween(String value1, String value2) {
            addCriterion("apply_code not between", value1, value2, "applyCode");
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

        public Criteria andUnitIdEqualTo(Long value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(Long value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(Long value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(Long value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(Long value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(Long value1, Long value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(Long value1, Long value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andSetNameIsNull() {
            addCriterion("set_name is null");
            return (Criteria) this;
        }

        public Criteria andSetNameIsNotNull() {
            addCriterion("set_name is not null");
            return (Criteria) this;
        }

        public Criteria andSetNameEqualTo(String value) {
            addCriterion("set_name =", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameNotEqualTo(String value) {
            addCriterion("set_name <>", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameGreaterThan(String value) {
            addCriterion("set_name >", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameGreaterThanOrEqualTo(String value) {
            addCriterion("set_name >=", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameLessThan(String value) {
            addCriterion("set_name <", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameLessThanOrEqualTo(String value) {
            addCriterion("set_name <=", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameLike(String value) {
            addCriterion("set_name like", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameNotLike(String value) {
            addCriterion("set_name not like", value, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameIn(java.util.List<java.lang.String> values) {
            addCriterion("set_name in", values, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("set_name not in", values, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameBetween(String value1, String value2) {
            addCriterion("set_name between", value1, value2, "setName");
            return (Criteria) this;
        }

        public Criteria andSetNameNotBetween(String value1, String value2) {
            addCriterion("set_name not between", value1, value2, "setName");
            return (Criteria) this;
        }

        public Criteria andSetCodeIsNull() {
            addCriterion("set_code is null");
            return (Criteria) this;
        }

        public Criteria andSetCodeIsNotNull() {
            addCriterion("set_code is not null");
            return (Criteria) this;
        }

        public Criteria andSetCodeEqualTo(String value) {
            addCriterion("set_code =", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeNotEqualTo(String value) {
            addCriterion("set_code <>", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeGreaterThan(String value) {
            addCriterion("set_code >", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("set_code >=", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeLessThan(String value) {
            addCriterion("set_code <", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeLessThanOrEqualTo(String value) {
            addCriterion("set_code <=", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeLike(String value) {
            addCriterion("set_code like", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeNotLike(String value) {
            addCriterion("set_code not like", value, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("set_code in", values, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("set_code not in", values, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeBetween(String value1, String value2) {
            addCriterion("set_code between", value1, value2, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetCodeNotBetween(String value1, String value2) {
            addCriterion("set_code not between", value1, value2, "setCode");
            return (Criteria) this;
        }

        public Criteria andSetTypeIsNull() {
            addCriterion("set_type is null");
            return (Criteria) this;
        }

        public Criteria andSetTypeIsNotNull() {
            addCriterion("set_type is not null");
            return (Criteria) this;
        }

        public Criteria andSetTypeEqualTo(Integer value) {
            addCriterion("set_type =", value, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeNotEqualTo(Integer value) {
            addCriterion("set_type <>", value, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeGreaterThan(Integer value) {
            addCriterion("set_type >", value, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("set_type >=", value, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeLessThan(Integer value) {
            addCriterion("set_type <", value, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("set_type <=", value, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("set_type in", values, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("set_type not in", values, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeBetween(Integer value1, Integer value2) {
            addCriterion("set_type between", value1, value2, "setType");
            return (Criteria) this;
        }

        public Criteria andSetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("set_type not between", value1, value2, "setType");
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

        public Criteria andDataCountEqualTo(Float value) {
            addCriterion("data_count =", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotEqualTo(Float value) {
            addCriterion("data_count <>", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThan(Float value) {
            addCriterion("data_count >", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThanOrEqualTo(Float value) {
            addCriterion("data_count >=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThan(Float value) {
            addCriterion("data_count <", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThanOrEqualTo(Float value) {
            addCriterion("data_count <=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountIn(java.util.List<java.lang.Float> values) {
            addCriterion("data_count in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("data_count not in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountBetween(Float value1, Float value2) {
            addCriterion("data_count between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotBetween(Float value1, Float value2) {
            addCriterion("data_count not between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andUpdateRateIsNull() {
            addCriterion("update_rate is null");
            return (Criteria) this;
        }

        public Criteria andUpdateRateIsNotNull() {
            addCriterion("update_rate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateRateEqualTo(Integer value) {
            addCriterion("update_rate =", value, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateNotEqualTo(Integer value) {
            addCriterion("update_rate <>", value, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateGreaterThan(Integer value) {
            addCriterion("update_rate >", value, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_rate >=", value, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateLessThan(Integer value) {
            addCriterion("update_rate <", value, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateLessThanOrEqualTo(Integer value) {
            addCriterion("update_rate <=", value, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateIn(java.util.List<java.lang.Integer> values) {
            addCriterion("update_rate in", values, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("update_rate not in", values, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateBetween(Integer value1, Integer value2) {
            addCriterion("update_rate between", value1, value2, "updateRate");
            return (Criteria) this;
        }

        public Criteria andUpdateRateNotBetween(Integer value1, Integer value2) {
            addCriterion("update_rate not between", value1, value2, "updateRate");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNull() {
            addCriterion("api_name is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("api_name is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("api_name =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("api_name <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("api_name >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("api_name >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("api_name <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("api_name <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("api_name like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("api_name not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(java.util.List<java.lang.String> values) {
            addCriterion("api_name in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("api_name not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("api_name between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("api_name not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNull() {
            addCriterion("api_url is null");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNotNull() {
            addCriterion("api_url is not null");
            return (Criteria) this;
        }

        public Criteria andApiUrlEqualTo(String value) {
            addCriterion("api_url =", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotEqualTo(String value) {
            addCriterion("api_url <>", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThan(String value) {
            addCriterion("api_url >", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThanOrEqualTo(String value) {
            addCriterion("api_url >=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThan(String value) {
            addCriterion("api_url <", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThanOrEqualTo(String value) {
            addCriterion("api_url <=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLike(String value) {
            addCriterion("api_url like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotLike(String value) {
            addCriterion("api_url not like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("api_url in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("api_url not in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlBetween(String value1, String value2) {
            addCriterion("api_url between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotBetween(String value1, String value2) {
            addCriterion("api_url not between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeIsNull() {
            addCriterion("api_data_type is null");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeIsNotNull() {
            addCriterion("api_data_type is not null");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeEqualTo(Integer value) {
            addCriterion("api_data_type =", value, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeNotEqualTo(Integer value) {
            addCriterion("api_data_type <>", value, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeGreaterThan(Integer value) {
            addCriterion("api_data_type >", value, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_data_type >=", value, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeLessThan(Integer value) {
            addCriterion("api_data_type <", value, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeLessThanOrEqualTo(Integer value) {
            addCriterion("api_data_type <=", value, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("api_data_type in", values, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("api_data_type not in", values, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeBetween(Integer value1, Integer value2) {
            addCriterion("api_data_type between", value1, value2, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andApiDataTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("api_data_type not between", value1, value2, "apiDataType");
            return (Criteria) this;
        }

        public Criteria andAcqTimeIsNull() {
            addCriterion("acq_time is null");
            return (Criteria) this;
        }

        public Criteria andAcqTimeIsNotNull() {
            addCriterion("acq_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcqTimeEqualTo(Date value) {
            addCriterion("acq_time =", value, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeNotEqualTo(Date value) {
            addCriterion("acq_time <>", value, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeGreaterThan(Date value) {
            addCriterion("acq_time >", value, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acq_time >=", value, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeLessThan(Date value) {
            addCriterion("acq_time <", value, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeLessThanOrEqualTo(Date value) {
            addCriterion("acq_time <=", value, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("acq_time in", values, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("acq_time not in", values, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeBetween(Date value1, Date value2) {
            addCriterion("acq_time between", value1, value2, "acqTime");
            return (Criteria) this;
        }

        public Criteria andAcqTimeNotBetween(Date value1, Date value2) {
            addCriterion("acq_time not between", value1, value2, "acqTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeIsNull() {
            addCriterion("update_type is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeIsNotNull() {
            addCriterion("update_type is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeEqualTo(Integer value) {
            addCriterion("update_type =", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeNotEqualTo(Integer value) {
            addCriterion("update_type <>", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeGreaterThan(Integer value) {
            addCriterion("update_type >", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_type >=", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeLessThan(Integer value) {
            addCriterion("update_type <", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("update_type <=", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("update_type in", values, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("update_type not in", values, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeBetween(Integer value1, Integer value2) {
            addCriterion("update_type between", value1, value2, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_type not between", value1, value2, "updateType");
            return (Criteria) this;
        }

        public Criteria andSetModeIsNull() {
            addCriterion("set_mode is null");
            return (Criteria) this;
        }

        public Criteria andSetModeIsNotNull() {
            addCriterion("set_mode is not null");
            return (Criteria) this;
        }

        public Criteria andSetModeEqualTo(Integer value) {
            addCriterion("set_mode =", value, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeNotEqualTo(Integer value) {
            addCriterion("set_mode <>", value, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeGreaterThan(Integer value) {
            addCriterion("set_mode >", value, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("set_mode >=", value, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeLessThan(Integer value) {
            addCriterion("set_mode <", value, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeLessThanOrEqualTo(Integer value) {
            addCriterion("set_mode <=", value, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("set_mode in", values, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("set_mode not in", values, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeBetween(Integer value1, Integer value2) {
            addCriterion("set_mode between", value1, value2, "setMode");
            return (Criteria) this;
        }

        public Criteria andSetModeNotBetween(Integer value1, Integer value2) {
            addCriterion("set_mode not between", value1, value2, "setMode");
            return (Criteria) this;
        }

        public Criteria andTableCodeIsNull() {
            addCriterion("table_code is null");
            return (Criteria) this;
        }

        public Criteria andTableCodeIsNotNull() {
            addCriterion("table_code is not null");
            return (Criteria) this;
        }

        public Criteria andTableCodeEqualTo(String value) {
            addCriterion("table_code =", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeNotEqualTo(String value) {
            addCriterion("table_code <>", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeGreaterThan(String value) {
            addCriterion("table_code >", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeGreaterThanOrEqualTo(String value) {
            addCriterion("table_code >=", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeLessThan(String value) {
            addCriterion("table_code <", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeLessThanOrEqualTo(String value) {
            addCriterion("table_code <=", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeLike(String value) {
            addCriterion("table_code like", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeNotLike(String value) {
            addCriterion("table_code not like", value, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("table_code in", values, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("table_code not in", values, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeBetween(String value1, String value2) {
            addCriterion("table_code between", value1, value2, "tableCode");
            return (Criteria) this;
        }

        public Criteria andTableCodeNotBetween(String value1, String value2) {
            addCriterion("table_code not between", value1, value2, "tableCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeIsNull() {
            addCriterion("sql_code is null");
            return (Criteria) this;
        }

        public Criteria andSqlCodeIsNotNull() {
            addCriterion("sql_code is not null");
            return (Criteria) this;
        }

        public Criteria andSqlCodeEqualTo(String value) {
            addCriterion("sql_code =", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeNotEqualTo(String value) {
            addCriterion("sql_code <>", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeGreaterThan(String value) {
            addCriterion("sql_code >", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sql_code >=", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeLessThan(String value) {
            addCriterion("sql_code <", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeLessThanOrEqualTo(String value) {
            addCriterion("sql_code <=", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeLike(String value) {
            addCriterion("sql_code like", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeNotLike(String value) {
            addCriterion("sql_code not like", value, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("sql_code in", values, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sql_code not in", values, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeBetween(String value1, String value2) {
            addCriterion("sql_code between", value1, value2, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andSqlCodeNotBetween(String value1, String value2) {
            addCriterion("sql_code not between", value1, value2, "sqlCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(Integer value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(Integer value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(Integer value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(Integer value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(Integer value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(Integer value1, Integer value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(java.util.List<java.lang.String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andDbIdIsNull() {
            addCriterion("db_id is null");
            return (Criteria) this;
        }

        public Criteria andDbIdIsNotNull() {
            addCriterion("db_id is not null");
            return (Criteria) this;
        }

        public Criteria andDbIdEqualTo(Long value) {
            addCriterion("db_id =", value, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdNotEqualTo(Long value) {
            addCriterion("db_id <>", value, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdGreaterThan(Long value) {
            addCriterion("db_id >", value, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdGreaterThanOrEqualTo(Long value) {
            addCriterion("db_id >=", value, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdLessThan(Long value) {
            addCriterion("db_id <", value, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdLessThanOrEqualTo(Long value) {
            addCriterion("db_id <=", value, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("db_id in", values, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("db_id not in", values, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdBetween(Long value1, Long value2) {
            addCriterion("db_id between", value1, value2, "dbId");
            return (Criteria) this;
        }

        public Criteria andDbIdNotBetween(Long value1, Long value2) {
            addCriterion("db_id not between", value1, value2, "dbId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status_ not between", value1, value2, "status");
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
    b_share_data_setaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}