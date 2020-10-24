package com.hengyunsoft.platform.ops.repository.train.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainManageExample extends com.hengyunsoft.db.example.BaseExample<TrainManageExample.Criteria> implements Serializable {
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

        public Criteria andTrainTypeIsNull() {
            addCriterion("train_type is null");
            return (Criteria) this;
        }

        public Criteria andTrainTypeIsNotNull() {
            addCriterion("train_type is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTypeEqualTo(String value) {
            addCriterion("train_type =", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeNotEqualTo(String value) {
            addCriterion("train_type <>", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeGreaterThan(String value) {
            addCriterion("train_type >", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeGreaterThanOrEqualTo(String value) {
            addCriterion("train_type >=", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeLessThan(String value) {
            addCriterion("train_type <", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeLessThanOrEqualTo(String value) {
            addCriterion("train_type <=", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeLike(String value) {
            addCriterion("train_type like", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeNotLike(String value) {
            addCriterion("train_type not like", value, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("train_type in", values, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("train_type not in", values, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeBetween(String value1, String value2) {
            addCriterion("train_type between", value1, value2, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainTypeNotBetween(String value1, String value2) {
            addCriterion("train_type not between", value1, value2, "trainType");
            return (Criteria) this;
        }

        public Criteria andTrainNameIsNull() {
            addCriterion("train_name is null");
            return (Criteria) this;
        }

        public Criteria andTrainNameIsNotNull() {
            addCriterion("train_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrainNameEqualTo(String value) {
            addCriterion("train_name =", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameNotEqualTo(String value) {
            addCriterion("train_name <>", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameGreaterThan(String value) {
            addCriterion("train_name >", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameGreaterThanOrEqualTo(String value) {
            addCriterion("train_name >=", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameLessThan(String value) {
            addCriterion("train_name <", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameLessThanOrEqualTo(String value) {
            addCriterion("train_name <=", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameLike(String value) {
            addCriterion("train_name like", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameNotLike(String value) {
            addCriterion("train_name not like", value, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameIn(java.util.List<java.lang.String> values) {
            addCriterion("train_name in", values, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("train_name not in", values, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameBetween(String value1, String value2) {
            addCriterion("train_name between", value1, value2, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainNameNotBetween(String value1, String value2) {
            addCriterion("train_name not between", value1, value2, "trainName");
            return (Criteria) this;
        }

        public Criteria andTrainAddressIsNull() {
            addCriterion("train_address is null");
            return (Criteria) this;
        }

        public Criteria andTrainAddressIsNotNull() {
            addCriterion("train_address is not null");
            return (Criteria) this;
        }

        public Criteria andTrainAddressEqualTo(String value) {
            addCriterion("train_address =", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotEqualTo(String value) {
            addCriterion("train_address <>", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressGreaterThan(String value) {
            addCriterion("train_address >", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressGreaterThanOrEqualTo(String value) {
            addCriterion("train_address >=", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressLessThan(String value) {
            addCriterion("train_address <", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressLessThanOrEqualTo(String value) {
            addCriterion("train_address <=", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressLike(String value) {
            addCriterion("train_address like", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotLike(String value) {
            addCriterion("train_address not like", value, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("train_address in", values, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("train_address not in", values, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressBetween(String value1, String value2) {
            addCriterion("train_address between", value1, value2, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainAddressNotBetween(String value1, String value2) {
            addCriterion("train_address not between", value1, value2, "trainAddress");
            return (Criteria) this;
        }

        public Criteria andTrainTimeIsNull() {
            addCriterion("train_time is null");
            return (Criteria) this;
        }

        public Criteria andTrainTimeIsNotNull() {
            addCriterion("train_time is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTimeEqualTo(Date value) {
            addCriterion("train_time =", value, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeNotEqualTo(Date value) {
            addCriterion("train_time <>", value, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeGreaterThan(Date value) {
            addCriterion("train_time >", value, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("train_time >=", value, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeLessThan(Date value) {
            addCriterion("train_time <", value, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeLessThanOrEqualTo(Date value) {
            addCriterion("train_time <=", value, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("train_time in", values, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("train_time not in", values, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeBetween(Date value1, Date value2) {
            addCriterion("train_time between", value1, value2, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainTimeNotBetween(Date value1, Date value2) {
            addCriterion("train_time not between", value1, value2, "trainTime");
            return (Criteria) this;
        }

        public Criteria andTrainInfoIsNull() {
            addCriterion("train_info is null");
            return (Criteria) this;
        }

        public Criteria andTrainInfoIsNotNull() {
            addCriterion("train_info is not null");
            return (Criteria) this;
        }

        public Criteria andTrainInfoEqualTo(String value) {
            addCriterion("train_info =", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoNotEqualTo(String value) {
            addCriterion("train_info <>", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoGreaterThan(String value) {
            addCriterion("train_info >", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoGreaterThanOrEqualTo(String value) {
            addCriterion("train_info >=", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoLessThan(String value) {
            addCriterion("train_info <", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoLessThanOrEqualTo(String value) {
            addCriterion("train_info <=", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoLike(String value) {
            addCriterion("train_info like", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoNotLike(String value) {
            addCriterion("train_info not like", value, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoIn(java.util.List<java.lang.String> values) {
            addCriterion("train_info in", values, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("train_info not in", values, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoBetween(String value1, String value2) {
            addCriterion("train_info between", value1, value2, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andTrainInfoNotBetween(String value1, String value2) {
            addCriterion("train_info not between", value1, value2, "trainInfo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTrainSorceIsNull() {
            addCriterion("train_sorce is null");
            return (Criteria) this;
        }

        public Criteria andTrainSorceIsNotNull() {
            addCriterion("train_sorce is not null");
            return (Criteria) this;
        }

        public Criteria andTrainSorceEqualTo(Long value) {
            addCriterion("train_sorce =", value, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceNotEqualTo(Long value) {
            addCriterion("train_sorce <>", value, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceGreaterThan(Long value) {
            addCriterion("train_sorce >", value, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceGreaterThanOrEqualTo(Long value) {
            addCriterion("train_sorce >=", value, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceLessThan(Long value) {
            addCriterion("train_sorce <", value, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceLessThanOrEqualTo(Long value) {
            addCriterion("train_sorce <=", value, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceIn(java.util.List<java.lang.Long> values) {
            addCriterion("train_sorce in", values, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("train_sorce not in", values, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceBetween(Long value1, Long value2) {
            addCriterion("train_sorce between", value1, value2, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andTrainSorceNotBetween(Long value1, Long value2) {
            addCriterion("train_sorce not between", value1, value2, "trainSorce");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNull() {
            addCriterion("score_time is null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNotNull() {
            addCriterion("score_time is not null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeEqualTo(Date value) {
            addCriterion("score_time =", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotEqualTo(Date value) {
            addCriterion("score_time <>", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThan(Date value) {
            addCriterion("score_time >", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("score_time >=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThan(Date value) {
            addCriterion("score_time <", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThanOrEqualTo(Date value) {
            addCriterion("score_time <=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("score_time in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("score_time not in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeBetween(Date value1, Date value2) {
            addCriterion("score_time between", value1, value2, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotBetween(Date value1, Date value2) {
            addCriterion("score_time not between", value1, value2, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceIsNull() {
            addCriterion("train_advice is null");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceIsNotNull() {
            addCriterion("train_advice is not null");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceEqualTo(String value) {
            addCriterion("train_advice =", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceNotEqualTo(String value) {
            addCriterion("train_advice <>", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceGreaterThan(String value) {
            addCriterion("train_advice >", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("train_advice >=", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceLessThan(String value) {
            addCriterion("train_advice <", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceLessThanOrEqualTo(String value) {
            addCriterion("train_advice <=", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceLike(String value) {
            addCriterion("train_advice like", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceNotLike(String value) {
            addCriterion("train_advice not like", value, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceIn(java.util.List<java.lang.String> values) {
            addCriterion("train_advice in", values, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceNotIn(java.util.List<java.lang.String> values) {
            addCriterion("train_advice not in", values, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceBetween(String value1, String value2) {
            addCriterion("train_advice between", value1, value2, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andTrainAdviceNotBetween(String value1, String value2) {
            addCriterion("train_advice not between", value1, value2, "trainAdvice");
            return (Criteria) this;
        }

        public Criteria andSubDeptIsNull() {
            addCriterion("sub_dept is null");
            return (Criteria) this;
        }

        public Criteria andSubDeptIsNotNull() {
            addCriterion("sub_dept is not null");
            return (Criteria) this;
        }

        public Criteria andSubDeptEqualTo(String value) {
            addCriterion("sub_dept =", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptNotEqualTo(String value) {
            addCriterion("sub_dept <>", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptGreaterThan(String value) {
            addCriterion("sub_dept >", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptGreaterThanOrEqualTo(String value) {
            addCriterion("sub_dept >=", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptLessThan(String value) {
            addCriterion("sub_dept <", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptLessThanOrEqualTo(String value) {
            addCriterion("sub_dept <=", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptLike(String value) {
            addCriterion("sub_dept like", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptNotLike(String value) {
            addCriterion("sub_dept not like", value, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptIn(java.util.List<java.lang.String> values) {
            addCriterion("sub_dept in", values, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sub_dept not in", values, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptBetween(String value1, String value2) {
            addCriterion("sub_dept between", value1, value2, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubDeptNotBetween(String value1, String value2) {
            addCriterion("sub_dept not between", value1, value2, "subDept");
            return (Criteria) this;
        }

        public Criteria andSubPersonIsNull() {
            addCriterion("sub_person is null");
            return (Criteria) this;
        }

        public Criteria andSubPersonIsNotNull() {
            addCriterion("sub_person is not null");
            return (Criteria) this;
        }

        public Criteria andSubPersonEqualTo(String value) {
            addCriterion("sub_person =", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonNotEqualTo(String value) {
            addCriterion("sub_person <>", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonGreaterThan(String value) {
            addCriterion("sub_person >", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonGreaterThanOrEqualTo(String value) {
            addCriterion("sub_person >=", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonLessThan(String value) {
            addCriterion("sub_person <", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonLessThanOrEqualTo(String value) {
            addCriterion("sub_person <=", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonLike(String value) {
            addCriterion("sub_person like", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonNotLike(String value) {
            addCriterion("sub_person not like", value, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonIn(java.util.List<java.lang.String> values) {
            addCriterion("sub_person in", values, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sub_person not in", values, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonBetween(String value1, String value2) {
            addCriterion("sub_person between", value1, value2, "subPerson");
            return (Criteria) this;
        }

        public Criteria andSubPersonNotBetween(String value1, String value2) {
            addCriterion("sub_person not between", value1, value2, "subPerson");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNull() {
            addCriterion("deal_opinion is null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNotNull() {
            addCriterion("deal_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionEqualTo(String value) {
            addCriterion("deal_opinion =", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotEqualTo(String value) {
            addCriterion("deal_opinion <>", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThan(String value) {
            addCriterion("deal_opinion >", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("deal_opinion >=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThan(String value) {
            addCriterion("deal_opinion <", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThanOrEqualTo(String value) {
            addCriterion("deal_opinion <=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLike(String value) {
            addCriterion("deal_opinion like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotLike(String value) {
            addCriterion("deal_opinion not like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_opinion in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_opinion not in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionBetween(String value1, String value2) {
            addCriterion("deal_opinion between", value1, value2, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotBetween(String value1, String value2) {
            addCriterion("deal_opinion not between", value1, value2, "dealOpinion");
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
    b_yw_train_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}