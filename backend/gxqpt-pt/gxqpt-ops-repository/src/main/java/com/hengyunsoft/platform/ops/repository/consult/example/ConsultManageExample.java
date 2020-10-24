package com.hengyunsoft.platform.ops.repository.consult.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultManageExample extends com.hengyunsoft.db.example.BaseExample<ConsultManageExample.Criteria> implements Serializable {
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

        public Criteria andConsultNameIsNull() {
            addCriterion("consult_name is null");
            return (Criteria) this;
        }

        public Criteria andConsultNameIsNotNull() {
            addCriterion("consult_name is not null");
            return (Criteria) this;
        }

        public Criteria andConsultNameEqualTo(String value) {
            addCriterion("consult_name =", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameNotEqualTo(String value) {
            addCriterion("consult_name <>", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameGreaterThan(String value) {
            addCriterion("consult_name >", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameGreaterThanOrEqualTo(String value) {
            addCriterion("consult_name >=", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameLessThan(String value) {
            addCriterion("consult_name <", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameLessThanOrEqualTo(String value) {
            addCriterion("consult_name <=", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameLike(String value) {
            addCriterion("consult_name like", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameNotLike(String value) {
            addCriterion("consult_name not like", value, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameIn(java.util.List<java.lang.String> values) {
            addCriterion("consult_name in", values, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("consult_name not in", values, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameBetween(String value1, String value2) {
            addCriterion("consult_name between", value1, value2, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultNameNotBetween(String value1, String value2) {
            addCriterion("consult_name not between", value1, value2, "consultName");
            return (Criteria) this;
        }

        public Criteria andConsultTimeIsNull() {
            addCriterion("consult_time is null");
            return (Criteria) this;
        }

        public Criteria andConsultTimeIsNotNull() {
            addCriterion("consult_time is not null");
            return (Criteria) this;
        }

        public Criteria andConsultTimeEqualTo(Date value) {
            addCriterion("consult_time =", value, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeNotEqualTo(Date value) {
            addCriterion("consult_time <>", value, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeGreaterThan(Date value) {
            addCriterion("consult_time >", value, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("consult_time >=", value, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeLessThan(Date value) {
            addCriterion("consult_time <", value, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeLessThanOrEqualTo(Date value) {
            addCriterion("consult_time <=", value, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("consult_time in", values, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("consult_time not in", values, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeBetween(Date value1, Date value2) {
            addCriterion("consult_time between", value1, value2, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultTimeNotBetween(Date value1, Date value2) {
            addCriterion("consult_time not between", value1, value2, "consultTime");
            return (Criteria) this;
        }

        public Criteria andConsultInfoIsNull() {
            addCriterion("consult_info is null");
            return (Criteria) this;
        }

        public Criteria andConsultInfoIsNotNull() {
            addCriterion("consult_info is not null");
            return (Criteria) this;
        }

        public Criteria andConsultInfoEqualTo(String value) {
            addCriterion("consult_info =", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoNotEqualTo(String value) {
            addCriterion("consult_info <>", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoGreaterThan(String value) {
            addCriterion("consult_info >", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoGreaterThanOrEqualTo(String value) {
            addCriterion("consult_info >=", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoLessThan(String value) {
            addCriterion("consult_info <", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoLessThanOrEqualTo(String value) {
            addCriterion("consult_info <=", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoLike(String value) {
            addCriterion("consult_info like", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoNotLike(String value) {
            addCriterion("consult_info not like", value, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoIn(java.util.List<java.lang.String> values) {
            addCriterion("consult_info in", values, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("consult_info not in", values, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoBetween(String value1, String value2) {
            addCriterion("consult_info between", value1, value2, "consultInfo");
            return (Criteria) this;
        }

        public Criteria andConsultInfoNotBetween(String value1, String value2) {
            addCriterion("consult_info not between", value1, value2, "consultInfo");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Long value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Long value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Long value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Long value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Long value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(java.util.List<java.lang.Long> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Long value1, Long value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Long value1, Long value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andConsultAdviceIsNull() {
            addCriterion("consult_advice is null");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceIsNotNull() {
            addCriterion("consult_advice is not null");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceEqualTo(String value) {
            addCriterion("consult_advice =", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceNotEqualTo(String value) {
            addCriterion("consult_advice <>", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceGreaterThan(String value) {
            addCriterion("consult_advice >", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("consult_advice >=", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceLessThan(String value) {
            addCriterion("consult_advice <", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceLessThanOrEqualTo(String value) {
            addCriterion("consult_advice <=", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceLike(String value) {
            addCriterion("consult_advice like", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceNotLike(String value) {
            addCriterion("consult_advice not like", value, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceIn(java.util.List<java.lang.String> values) {
            addCriterion("consult_advice in", values, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceNotIn(java.util.List<java.lang.String> values) {
            addCriterion("consult_advice not in", values, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceBetween(String value1, String value2) {
            addCriterion("consult_advice between", value1, value2, "consultAdvice");
            return (Criteria) this;
        }

        public Criteria andConsultAdviceNotBetween(String value1, String value2) {
            addCriterion("consult_advice not between", value1, value2, "consultAdvice");
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

        public Criteria andServiceAttitudeIsNull() {
            addCriterion("service_attitude is null");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeIsNotNull() {
            addCriterion("service_attitude is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeEqualTo(Long value) {
            addCriterion("service_attitude =", value, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeNotEqualTo(Long value) {
            addCriterion("service_attitude <>", value, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeGreaterThan(Long value) {
            addCriterion("service_attitude >", value, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeGreaterThanOrEqualTo(Long value) {
            addCriterion("service_attitude >=", value, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeLessThan(Long value) {
            addCriterion("service_attitude <", value, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeLessThanOrEqualTo(Long value) {
            addCriterion("service_attitude <=", value, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_attitude in", values, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_attitude not in", values, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeBetween(Long value1, Long value2) {
            addCriterion("service_attitude between", value1, value2, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceAttitudeNotBetween(Long value1, Long value2) {
            addCriterion("service_attitude not between", value1, value2, "serviceAttitude");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyIsNull() {
            addCriterion("service_efficiency is null");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyIsNotNull() {
            addCriterion("service_efficiency is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyEqualTo(Long value) {
            addCriterion("service_efficiency =", value, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyNotEqualTo(Long value) {
            addCriterion("service_efficiency <>", value, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyGreaterThan(Long value) {
            addCriterion("service_efficiency >", value, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyGreaterThanOrEqualTo(Long value) {
            addCriterion("service_efficiency >=", value, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyLessThan(Long value) {
            addCriterion("service_efficiency <", value, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyLessThanOrEqualTo(Long value) {
            addCriterion("service_efficiency <=", value, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_efficiency in", values, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_efficiency not in", values, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyBetween(Long value1, Long value2) {
            addCriterion("service_efficiency between", value1, value2, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andServiceEfficiencyNotBetween(Long value1, Long value2) {
            addCriterion("service_efficiency not between", value1, value2, "serviceEfficiency");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("deal_result is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("deal_result is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(String value) {
            addCriterion("deal_result =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(String value) {
            addCriterion("deal_result <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(String value) {
            addCriterion("deal_result >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(String value) {
            addCriterion("deal_result >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(String value) {
            addCriterion("deal_result <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(String value) {
            addCriterion("deal_result <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLike(String value) {
            addCriterion("deal_result like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotLike(String value) {
            addCriterion("deal_result not like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_result in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(java.util.List<java.lang.String> values) {
            addCriterion("deal_result not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(String value1, String value2) {
            addCriterion("deal_result between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(String value1, String value2) {
            addCriterion("deal_result not between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andServiceQualityIsNull() {
            addCriterion("service_quality is null");
            return (Criteria) this;
        }

        public Criteria andServiceQualityIsNotNull() {
            addCriterion("service_quality is not null");
            return (Criteria) this;
        }

        public Criteria andServiceQualityEqualTo(Long value) {
            addCriterion("service_quality =", value, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityNotEqualTo(Long value) {
            addCriterion("service_quality <>", value, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityGreaterThan(Long value) {
            addCriterion("service_quality >", value, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityGreaterThanOrEqualTo(Long value) {
            addCriterion("service_quality >=", value, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityLessThan(Long value) {
            addCriterion("service_quality <", value, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityLessThanOrEqualTo(Long value) {
            addCriterion("service_quality <=", value, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_quality in", values, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_quality not in", values, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityBetween(Long value1, Long value2) {
            addCriterion("service_quality between", value1, value2, "serviceQuality");
            return (Criteria) this;
        }

        public Criteria andServiceQualityNotBetween(Long value1, Long value2) {
            addCriterion("service_quality not between", value1, value2, "serviceQuality");
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
    b_yw_consult_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}