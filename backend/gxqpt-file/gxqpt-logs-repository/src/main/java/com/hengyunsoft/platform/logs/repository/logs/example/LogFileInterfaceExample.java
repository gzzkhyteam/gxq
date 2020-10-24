package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogFileInterfaceExample extends com.hengyunsoft.db.example.BaseExample<LogFileInterfaceExample.Criteria> implements Serializable {
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

        public Criteria andLogFileIdIsNull() {
            addCriterion("log_file_id is null");
            return (Criteria) this;
        }

        public Criteria andLogFileIdIsNotNull() {
            addCriterion("log_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogFileIdEqualTo(Long value) {
            addCriterion("log_file_id =", value, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdNotEqualTo(Long value) {
            addCriterion("log_file_id <>", value, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdGreaterThan(Long value) {
            addCriterion("log_file_id >", value, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_file_id >=", value, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdLessThan(Long value) {
            addCriterion("log_file_id <", value, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdLessThanOrEqualTo(Long value) {
            addCriterion("log_file_id <=", value, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_file_id in", values, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_file_id not in", values, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdBetween(Long value1, Long value2) {
            addCriterion("log_file_id between", value1, value2, "logFileId");
            return (Criteria) this;
        }

        public Criteria andLogFileIdNotBetween(Long value1, Long value2) {
            addCriterion("log_file_id not between", value1, value2, "logFileId");
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

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
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

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeIsNull() {
            addCriterion("log_export_type is null");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeIsNotNull() {
            addCriterion("log_export_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeEqualTo(String value) {
            addCriterion("log_export_type =", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeNotEqualTo(String value) {
            addCriterion("log_export_type <>", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeGreaterThan(String value) {
            addCriterion("log_export_type >", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_export_type >=", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeLessThan(String value) {
            addCriterion("log_export_type <", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeLessThanOrEqualTo(String value) {
            addCriterion("log_export_type <=", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeLike(String value) {
            addCriterion("log_export_type like", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeNotLike(String value) {
            addCriterion("log_export_type not like", value, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("log_export_type in", values, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("log_export_type not in", values, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeBetween(String value1, String value2) {
            addCriterion("log_export_type between", value1, value2, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogExportTypeNotBetween(String value1, String value2) {
            addCriterion("log_export_type not between", value1, value2, "logExportType");
            return (Criteria) this;
        }

        public Criteria andLogPatternIsNull() {
            addCriterion("log_pattern is null");
            return (Criteria) this;
        }

        public Criteria andLogPatternIsNotNull() {
            addCriterion("log_pattern is not null");
            return (Criteria) this;
        }

        public Criteria andLogPatternEqualTo(String value) {
            addCriterion("log_pattern =", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternNotEqualTo(String value) {
            addCriterion("log_pattern <>", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternGreaterThan(String value) {
            addCriterion("log_pattern >", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternGreaterThanOrEqualTo(String value) {
            addCriterion("log_pattern >=", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternLessThan(String value) {
            addCriterion("log_pattern <", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternLessThanOrEqualTo(String value) {
            addCriterion("log_pattern <=", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternLike(String value) {
            addCriterion("log_pattern like", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternNotLike(String value) {
            addCriterion("log_pattern not like", value, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternIn(java.util.List<java.lang.String> values) {
            addCriterion("log_pattern in", values, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternNotIn(java.util.List<java.lang.String> values) {
            addCriterion("log_pattern not in", values, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternBetween(String value1, String value2) {
            addCriterion("log_pattern between", value1, value2, "logPattern");
            return (Criteria) this;
        }

        public Criteria andLogPatternNotBetween(String value1, String value2) {
            addCriterion("log_pattern not between", value1, value2, "logPattern");
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

        public Criteria andIsParsedIsNull() {
            addCriterion("is_parsed is null");
            return (Criteria) this;
        }

        public Criteria andIsParsedIsNotNull() {
            addCriterion("is_parsed is not null");
            return (Criteria) this;
        }

        public Criteria andIsParsedEqualTo(String value) {
            addCriterion("is_parsed =", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedNotEqualTo(String value) {
            addCriterion("is_parsed <>", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedGreaterThan(String value) {
            addCriterion("is_parsed >", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedGreaterThanOrEqualTo(String value) {
            addCriterion("is_parsed >=", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedLessThan(String value) {
            addCriterion("is_parsed <", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedLessThanOrEqualTo(String value) {
            addCriterion("is_parsed <=", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedLike(String value) {
            addCriterion("is_parsed like", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedNotLike(String value) {
            addCriterion("is_parsed not like", value, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedIn(java.util.List<java.lang.String> values) {
            addCriterion("is_parsed in", values, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_parsed not in", values, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedBetween(String value1, String value2) {
            addCriterion("is_parsed between", value1, value2, "isParsed");
            return (Criteria) this;
        }

        public Criteria andIsParsedNotBetween(String value1, String value2) {
            addCriterion("is_parsed not between", value1, value2, "isParsed");
            return (Criteria) this;
        }

        public Criteria andParseTimeIsNull() {
            addCriterion("parse_time is null");
            return (Criteria) this;
        }

        public Criteria andParseTimeIsNotNull() {
            addCriterion("parse_time is not null");
            return (Criteria) this;
        }

        public Criteria andParseTimeEqualTo(Date value) {
            addCriterion("parse_time =", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotEqualTo(Date value) {
            addCriterion("parse_time <>", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeGreaterThan(Date value) {
            addCriterion("parse_time >", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("parse_time >=", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeLessThan(Date value) {
            addCriterion("parse_time <", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeLessThanOrEqualTo(Date value) {
            addCriterion("parse_time <=", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("parse_time in", values, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("parse_time not in", values, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeBetween(Date value1, Date value2) {
            addCriterion("parse_time between", value1, value2, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotBetween(Date value1, Date value2) {
            addCriterion("parse_time not between", value1, value2, "parseTime");
            return (Criteria) this;
        }

        public Criteria andIsPullIsNull() {
            addCriterion("is_pull is null");
            return (Criteria) this;
        }

        public Criteria andIsPullIsNotNull() {
            addCriterion("is_pull is not null");
            return (Criteria) this;
        }

        public Criteria andIsPullEqualTo(String value) {
            addCriterion("is_pull =", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullNotEqualTo(String value) {
            addCriterion("is_pull <>", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullGreaterThan(String value) {
            addCriterion("is_pull >", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullGreaterThanOrEqualTo(String value) {
            addCriterion("is_pull >=", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullLessThan(String value) {
            addCriterion("is_pull <", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullLessThanOrEqualTo(String value) {
            addCriterion("is_pull <=", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullLike(String value) {
            addCriterion("is_pull like", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullNotLike(String value) {
            addCriterion("is_pull not like", value, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullIn(java.util.List<java.lang.String> values) {
            addCriterion("is_pull in", values, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_pull not in", values, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullBetween(String value1, String value2) {
            addCriterion("is_pull between", value1, value2, "isPull");
            return (Criteria) this;
        }

        public Criteria andIsPullNotBetween(String value1, String value2) {
            addCriterion("is_pull not between", value1, value2, "isPull");
            return (Criteria) this;
        }

        public Criteria andPullTimeIsNull() {
            addCriterion("pull_time is null");
            return (Criteria) this;
        }

        public Criteria andPullTimeIsNotNull() {
            addCriterion("pull_time is not null");
            return (Criteria) this;
        }

        public Criteria andPullTimeEqualTo(Date value) {
            addCriterion("pull_time =", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeNotEqualTo(Date value) {
            addCriterion("pull_time <>", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeGreaterThan(Date value) {
            addCriterion("pull_time >", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pull_time >=", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeLessThan(Date value) {
            addCriterion("pull_time <", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeLessThanOrEqualTo(Date value) {
            addCriterion("pull_time <=", value, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("pull_time in", values, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("pull_time not in", values, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeBetween(Date value1, Date value2) {
            addCriterion("pull_time between", value1, value2, "pullTime");
            return (Criteria) this;
        }

        public Criteria andPullTimeNotBetween(Date value1, Date value2) {
            addCriterion("pull_time not between", value1, value2, "pullTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructIsNull() {
            addCriterion("is_delete_struct is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructIsNotNull() {
            addCriterion("is_delete_struct is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructEqualTo(String value) {
            addCriterion("is_delete_struct =", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructNotEqualTo(String value) {
            addCriterion("is_delete_struct <>", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructGreaterThan(String value) {
            addCriterion("is_delete_struct >", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete_struct >=", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructLessThan(String value) {
            addCriterion("is_delete_struct <", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructLessThanOrEqualTo(String value) {
            addCriterion("is_delete_struct <=", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructLike(String value) {
            addCriterion("is_delete_struct like", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructNotLike(String value) {
            addCriterion("is_delete_struct not like", value, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructIn(java.util.List<java.lang.String> values) {
            addCriterion("is_delete_struct in", values, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructNotIn(java.util.List<java.lang.String> values) {
            addCriterion("is_delete_struct not in", values, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructBetween(String value1, String value2) {
            addCriterion("is_delete_struct between", value1, value2, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andIsDeleteStructNotBetween(String value1, String value2) {
            addCriterion("is_delete_struct not between", value1, value2, "isDeleteStruct");
            return (Criteria) this;
        }

        public Criteria andLogCountIsNull() {
            addCriterion("log_count is null");
            return (Criteria) this;
        }

        public Criteria andLogCountIsNotNull() {
            addCriterion("log_count is not null");
            return (Criteria) this;
        }

        public Criteria andLogCountEqualTo(Long value) {
            addCriterion("log_count =", value, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountNotEqualTo(Long value) {
            addCriterion("log_count <>", value, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountGreaterThan(Long value) {
            addCriterion("log_count >", value, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountGreaterThanOrEqualTo(Long value) {
            addCriterion("log_count >=", value, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountLessThan(Long value) {
            addCriterion("log_count <", value, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountLessThanOrEqualTo(Long value) {
            addCriterion("log_count <=", value, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_count in", values, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("log_count not in", values, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountBetween(Long value1, Long value2) {
            addCriterion("log_count between", value1, value2, "logCount");
            return (Criteria) this;
        }

        public Criteria andLogCountNotBetween(Long value1, Long value2) {
            addCriterion("log_count not between", value1, value2, "logCount");
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
    log_file_interfaceaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}