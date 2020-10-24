package com.hengyunsoft.platform.security.repository.assess.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SafetyAssessmentReportExample extends com.hengyunsoft.db.example.BaseExample<SafetyAssessmentReportExample.Criteria> implements Serializable {
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

        public Criteria andAssessmentIdIsNull() {
            addCriterion("assessment_id is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdIsNotNull() {
            addCriterion("assessment_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdEqualTo(Long value) {
            addCriterion("assessment_id =", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdNotEqualTo(Long value) {
            addCriterion("assessment_id <>", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdGreaterThan(Long value) {
            addCriterion("assessment_id >", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("assessment_id >=", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdLessThan(Long value) {
            addCriterion("assessment_id <", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdLessThanOrEqualTo(Long value) {
            addCriterion("assessment_id <=", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("assessment_id in", values, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("assessment_id not in", values, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdBetween(Long value1, Long value2) {
            addCriterion("assessment_id between", value1, value2, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdNotBetween(Long value1, Long value2) {
            addCriterion("assessment_id not between", value1, value2, "assessmentId");
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

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(java.util.List<java.lang.String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeIsNull() {
            addCriterion("assessment_time is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeIsNotNull() {
            addCriterion("assessment_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeEqualTo(Date value) {
            addCriterion("assessment_time =", value, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeNotEqualTo(Date value) {
            addCriterion("assessment_time <>", value, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeGreaterThan(Date value) {
            addCriterion("assessment_time >", value, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("assessment_time >=", value, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeLessThan(Date value) {
            addCriterion("assessment_time <", value, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("assessment_time <=", value, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("assessment_time in", values, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("assessment_time not in", values, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeBetween(Date value1, Date value2) {
            addCriterion("assessment_time between", value1, value2, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("assessment_time not between", value1, value2, "assessmentTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdIsNull() {
            addCriterion("assessment_file_id is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdIsNotNull() {
            addCriterion("assessment_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdEqualTo(Long value) {
            addCriterion("assessment_file_id =", value, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdNotEqualTo(Long value) {
            addCriterion("assessment_file_id <>", value, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdGreaterThan(Long value) {
            addCriterion("assessment_file_id >", value, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("assessment_file_id >=", value, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdLessThan(Long value) {
            addCriterion("assessment_file_id <", value, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdLessThanOrEqualTo(Long value) {
            addCriterion("assessment_file_id <=", value, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("assessment_file_id in", values, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("assessment_file_id not in", values, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdBetween(Long value1, Long value2) {
            addCriterion("assessment_file_id between", value1, value2, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileIdNotBetween(Long value1, Long value2) {
            addCriterion("assessment_file_id not between", value1, value2, "assessmentFileId");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameIsNull() {
            addCriterion("assessment_file_name is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameIsNotNull() {
            addCriterion("assessment_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameEqualTo(String value) {
            addCriterion("assessment_file_name =", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameNotEqualTo(String value) {
            addCriterion("assessment_file_name <>", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameGreaterThan(String value) {
            addCriterion("assessment_file_name >", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_file_name >=", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameLessThan(String value) {
            addCriterion("assessment_file_name <", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameLessThanOrEqualTo(String value) {
            addCriterion("assessment_file_name <=", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameLike(String value) {
            addCriterion("assessment_file_name like", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameNotLike(String value) {
            addCriterion("assessment_file_name not like", value, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameIn(java.util.List<java.lang.String> values) {
            addCriterion("assessment_file_name in", values, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("assessment_file_name not in", values, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameBetween(String value1, String value2) {
            addCriterion("assessment_file_name between", value1, value2, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileNameNotBetween(String value1, String value2) {
            addCriterion("assessment_file_name not between", value1, value2, "assessmentFileName");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlIsNull() {
            addCriterion("assessment_file_url is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlIsNotNull() {
            addCriterion("assessment_file_url is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlEqualTo(String value) {
            addCriterion("assessment_file_url =", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlNotEqualTo(String value) {
            addCriterion("assessment_file_url <>", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlGreaterThan(String value) {
            addCriterion("assessment_file_url >", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_file_url >=", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlLessThan(String value) {
            addCriterion("assessment_file_url <", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlLessThanOrEqualTo(String value) {
            addCriterion("assessment_file_url <=", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlLike(String value) {
            addCriterion("assessment_file_url like", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlNotLike(String value) {
            addCriterion("assessment_file_url not like", value, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("assessment_file_url in", values, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("assessment_file_url not in", values, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlBetween(String value1, String value2) {
            addCriterion("assessment_file_url between", value1, value2, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andAssessmentFileUrlNotBetween(String value1, String value2) {
            addCriterion("assessment_file_url not between", value1, value2, "assessmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdIsNull() {
            addCriterion("rectification_file_id is null");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdIsNotNull() {
            addCriterion("rectification_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdEqualTo(Long value) {
            addCriterion("rectification_file_id =", value, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdNotEqualTo(Long value) {
            addCriterion("rectification_file_id <>", value, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdGreaterThan(Long value) {
            addCriterion("rectification_file_id >", value, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rectification_file_id >=", value, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdLessThan(Long value) {
            addCriterion("rectification_file_id <", value, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdLessThanOrEqualTo(Long value) {
            addCriterion("rectification_file_id <=", value, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("rectification_file_id in", values, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("rectification_file_id not in", values, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdBetween(Long value1, Long value2) {
            addCriterion("rectification_file_id between", value1, value2, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileIdNotBetween(Long value1, Long value2) {
            addCriterion("rectification_file_id not between", value1, value2, "rectificationFileId");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameIsNull() {
            addCriterion("rectification_file_name is null");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameIsNotNull() {
            addCriterion("rectification_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameEqualTo(String value) {
            addCriterion("rectification_file_name =", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameNotEqualTo(String value) {
            addCriterion("rectification_file_name <>", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameGreaterThan(String value) {
            addCriterion("rectification_file_name >", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("rectification_file_name >=", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameLessThan(String value) {
            addCriterion("rectification_file_name <", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameLessThanOrEqualTo(String value) {
            addCriterion("rectification_file_name <=", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameLike(String value) {
            addCriterion("rectification_file_name like", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameNotLike(String value) {
            addCriterion("rectification_file_name not like", value, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameIn(java.util.List<java.lang.String> values) {
            addCriterion("rectification_file_name in", values, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("rectification_file_name not in", values, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameBetween(String value1, String value2) {
            addCriterion("rectification_file_name between", value1, value2, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileNameNotBetween(String value1, String value2) {
            addCriterion("rectification_file_name not between", value1, value2, "rectificationFileName");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlIsNull() {
            addCriterion("rectification_file_url is null");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlIsNotNull() {
            addCriterion("rectification_file_url is not null");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlEqualTo(String value) {
            addCriterion("rectification_file_url =", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlNotEqualTo(String value) {
            addCriterion("rectification_file_url <>", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlGreaterThan(String value) {
            addCriterion("rectification_file_url >", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("rectification_file_url >=", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlLessThan(String value) {
            addCriterion("rectification_file_url <", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlLessThanOrEqualTo(String value) {
            addCriterion("rectification_file_url <=", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlLike(String value) {
            addCriterion("rectification_file_url like", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlNotLike(String value) {
            addCriterion("rectification_file_url not like", value, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("rectification_file_url in", values, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("rectification_file_url not in", values, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlBetween(String value1, String value2) {
            addCriterion("rectification_file_url between", value1, value2, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRectificationFileUrlNotBetween(String value1, String value2) {
            addCriterion("rectification_file_url not between", value1, value2, "rectificationFileUrl");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(java.util.List<java.lang.String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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
    se_safety_assessment_reportaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}