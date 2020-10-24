package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogDeleteAppExample extends com.hengyunsoft.db.example.BaseExample<LogDeleteAppExample.Criteria> implements Serializable {
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

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(java.util.List<java.lang.String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNull() {
            addCriterion("document_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNotNull() {
            addCriterion("document_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("document_id =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotEqualTo(String value) {
            addCriterion("document_id <>", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThan(String value) {
            addCriterion("document_id >", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThanOrEqualTo(String value) {
            addCriterion("document_id >=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThan(String value) {
            addCriterion("document_id <", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThanOrEqualTo(String value) {
            addCriterion("document_id <=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLike(String value) {
            addCriterion("document_id like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotLike(String value) {
            addCriterion("document_id not like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIn(java.util.List<java.lang.String> values) {
            addCriterion("document_id in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("document_id not in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdBetween(String value1, String value2) {
            addCriterion("document_id between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotBetween(String value1, String value2) {
            addCriterion("document_id not between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentPathIsNull() {
            addCriterion("document_path is null");
            return (Criteria) this;
        }

        public Criteria andDocumentPathIsNotNull() {
            addCriterion("document_path is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentPathEqualTo(String value) {
            addCriterion("document_path =", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotEqualTo(String value) {
            addCriterion("document_path <>", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathGreaterThan(String value) {
            addCriterion("document_path >", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathGreaterThanOrEqualTo(String value) {
            addCriterion("document_path >=", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathLessThan(String value) {
            addCriterion("document_path <", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathLessThanOrEqualTo(String value) {
            addCriterion("document_path <=", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathLike(String value) {
            addCriterion("document_path like", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotLike(String value) {
            addCriterion("document_path not like", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathIn(java.util.List<java.lang.String> values) {
            addCriterion("document_path in", values, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotIn(java.util.List<java.lang.String> values) {
            addCriterion("document_path not in", values, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathBetween(String value1, String value2) {
            addCriterion("document_path between", value1, value2, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotBetween(String value1, String value2) {
            addCriterion("document_path not between", value1, value2, "documentPath");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeIsNull() {
            addCriterion("log_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeIsNotNull() {
            addCriterion("log_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeEqualTo(Date value) {
            addCriterion("log_start_time =", value, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeNotEqualTo(Date value) {
            addCriterion("log_start_time <>", value, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeGreaterThan(Date value) {
            addCriterion("log_start_time >", value, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_start_time >=", value, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeLessThan(Date value) {
            addCriterion("log_start_time <", value, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_start_time <=", value, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("log_start_time in", values, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("log_start_time not in", values, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeBetween(Date value1, Date value2) {
            addCriterion("log_start_time between", value1, value2, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_start_time not between", value1, value2, "logStartTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeIsNull() {
            addCriterion("log_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeIsNotNull() {
            addCriterion("log_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeEqualTo(Date value) {
            addCriterion("log_end_time =", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeNotEqualTo(Date value) {
            addCriterion("log_end_time <>", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeGreaterThan(Date value) {
            addCriterion("log_end_time >", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_end_time >=", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeLessThan(Date value) {
            addCriterion("log_end_time <", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_end_time <=", value, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("log_end_time in", values, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("log_end_time not in", values, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeBetween(Date value1, Date value2) {
            addCriterion("log_end_time between", value1, value2, "logEndTime");
            return (Criteria) this;
        }

        public Criteria andLogEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_end_time not between", value1, value2, "logEndTime");
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
    log_delete_appaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}