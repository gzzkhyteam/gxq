package com.hengyunsoft.platform.ops.repository.service.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceManageExample extends com.hengyunsoft.db.example.BaseExample<ServiceManageExample.Criteria> implements Serializable {
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

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceObjIsNull() {
            addCriterion("service_obj is null");
            return (Criteria) this;
        }

        public Criteria andServiceObjIsNotNull() {
            addCriterion("service_obj is not null");
            return (Criteria) this;
        }

        public Criteria andServiceObjEqualTo(String value) {
            addCriterion("service_obj =", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjNotEqualTo(String value) {
            addCriterion("service_obj <>", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjGreaterThan(String value) {
            addCriterion("service_obj >", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjGreaterThanOrEqualTo(String value) {
            addCriterion("service_obj >=", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjLessThan(String value) {
            addCriterion("service_obj <", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjLessThanOrEqualTo(String value) {
            addCriterion("service_obj <=", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjLike(String value) {
            addCriterion("service_obj like", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjNotLike(String value) {
            addCriterion("service_obj not like", value, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjIn(java.util.List<java.lang.String> values) {
            addCriterion("service_obj in", values, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_obj not in", values, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjBetween(String value1, String value2) {
            addCriterion("service_obj between", value1, value2, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceObjNotBetween(String value1, String value2) {
            addCriterion("service_obj not between", value1, value2, "serviceObj");
            return (Criteria) this;
        }

        public Criteria andServiceClassIsNull() {
            addCriterion("service_class is null");
            return (Criteria) this;
        }

        public Criteria andServiceClassIsNotNull() {
            addCriterion("service_class is not null");
            return (Criteria) this;
        }

        public Criteria andServiceClassEqualTo(String value) {
            addCriterion("service_class =", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassNotEqualTo(String value) {
            addCriterion("service_class <>", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassGreaterThan(String value) {
            addCriterion("service_class >", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassGreaterThanOrEqualTo(String value) {
            addCriterion("service_class >=", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassLessThan(String value) {
            addCriterion("service_class <", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassLessThanOrEqualTo(String value) {
            addCriterion("service_class <=", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassLike(String value) {
            addCriterion("service_class like", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassNotLike(String value) {
            addCriterion("service_class not like", value, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassIn(java.util.List<java.lang.String> values) {
            addCriterion("service_class in", values, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_class not in", values, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassBetween(String value1, String value2) {
            addCriterion("service_class between", value1, value2, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceClassNotBetween(String value1, String value2) {
            addCriterion("service_class not between", value1, value2, "serviceClass");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(java.util.List<java.lang.String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(Date value) {
            addCriterion("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(Date value) {
            addCriterion("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(Date value) {
            addCriterion("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(Date value) {
            addCriterion("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(Date value) {
            addCriterion("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(Date value1, Date value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(Date value1, Date value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andServiceProcessIsNull() {
            addCriterion("service_process is null");
            return (Criteria) this;
        }

        public Criteria andServiceProcessIsNotNull() {
            addCriterion("service_process is not null");
            return (Criteria) this;
        }

        public Criteria andServiceProcessEqualTo(String value) {
            addCriterion("service_process =", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessNotEqualTo(String value) {
            addCriterion("service_process <>", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessGreaterThan(String value) {
            addCriterion("service_process >", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessGreaterThanOrEqualTo(String value) {
            addCriterion("service_process >=", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessLessThan(String value) {
            addCriterion("service_process <", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessLessThanOrEqualTo(String value) {
            addCriterion("service_process <=", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessLike(String value) {
            addCriterion("service_process like", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessNotLike(String value) {
            addCriterion("service_process not like", value, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessIn(java.util.List<java.lang.String> values) {
            addCriterion("service_process in", values, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_process not in", values, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessBetween(String value1, String value2) {
            addCriterion("service_process between", value1, value2, "serviceProcess");
            return (Criteria) this;
        }

        public Criteria andServiceProcessNotBetween(String value1, String value2) {
            addCriterion("service_process not between", value1, value2, "serviceProcess");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(java.util.List<java.lang.String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNull() {
            addCriterion("apply_user is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNotNull() {
            addCriterion("apply_user is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserEqualTo(String value) {
            addCriterion("apply_user =", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotEqualTo(String value) {
            addCriterion("apply_user <>", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThan(String value) {
            addCriterion("apply_user >", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user >=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThan(String value) {
            addCriterion("apply_user <", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThanOrEqualTo(String value) {
            addCriterion("apply_user <=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLike(String value) {
            addCriterion("apply_user like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotLike(String value) {
            addCriterion("apply_user not like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_user in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_user not in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserBetween(String value1, String value2) {
            addCriterion("apply_user between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotBetween(String value1, String value2) {
            addCriterion("apply_user not between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyOrgIsNull() {
            addCriterion("apply_org is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrgIsNotNull() {
            addCriterion("apply_org is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrgEqualTo(String value) {
            addCriterion("apply_org =", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgNotEqualTo(String value) {
            addCriterion("apply_org <>", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgGreaterThan(String value) {
            addCriterion("apply_org >", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgGreaterThanOrEqualTo(String value) {
            addCriterion("apply_org >=", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgLessThan(String value) {
            addCriterion("apply_org <", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgLessThanOrEqualTo(String value) {
            addCriterion("apply_org <=", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgLike(String value) {
            addCriterion("apply_org like", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgNotLike(String value) {
            addCriterion("apply_org not like", value, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_org in", values, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_org not in", values, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgBetween(String value1, String value2) {
            addCriterion("apply_org between", value1, value2, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andApplyOrgNotBetween(String value1, String value2) {
            addCriterion("apply_org not between", value1, value2, "applyOrg");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIsNull() {
            addCriterion("audit_opinion is null");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIsNotNull() {
            addCriterion("audit_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionEqualTo(String value) {
            addCriterion("audit_opinion =", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotEqualTo(String value) {
            addCriterion("audit_opinion <>", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionGreaterThan(String value) {
            addCriterion("audit_opinion >", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("audit_opinion >=", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLessThan(String value) {
            addCriterion("audit_opinion <", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLessThanOrEqualTo(String value) {
            addCriterion("audit_opinion <=", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLike(String value) {
            addCriterion("audit_opinion like", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotLike(String value) {
            addCriterion("audit_opinion not like", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_opinion in", values, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_opinion not in", values, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionBetween(String value1, String value2) {
            addCriterion("audit_opinion between", value1, value2, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotBetween(String value1, String value2) {
            addCriterion("audit_opinion not between", value1, value2, "auditOpinion");
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

        public Criteria andServiceEvaluationIsNull() {
            addCriterion("service_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationIsNotNull() {
            addCriterion("service_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationEqualTo(Long value) {
            addCriterion("service_evaluation =", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationNotEqualTo(Long value) {
            addCriterion("service_evaluation <>", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationGreaterThan(Long value) {
            addCriterion("service_evaluation >", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationGreaterThanOrEqualTo(Long value) {
            addCriterion("service_evaluation >=", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationLessThan(Long value) {
            addCriterion("service_evaluation <", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationLessThanOrEqualTo(Long value) {
            addCriterion("service_evaluation <=", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_evaluation in", values, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("service_evaluation not in", values, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationBetween(Long value1, Long value2) {
            addCriterion("service_evaluation between", value1, value2, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationNotBetween(Long value1, Long value2) {
            addCriterion("service_evaluation not between", value1, value2, "serviceEvaluation");
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

        public Criteria andServiceAdviceIsNull() {
            addCriterion("service_advice is null");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceIsNotNull() {
            addCriterion("service_advice is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceEqualTo(String value) {
            addCriterion("service_advice =", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceNotEqualTo(String value) {
            addCriterion("service_advice <>", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceGreaterThan(String value) {
            addCriterion("service_advice >", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("service_advice >=", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceLessThan(String value) {
            addCriterion("service_advice <", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceLessThanOrEqualTo(String value) {
            addCriterion("service_advice <=", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceLike(String value) {
            addCriterion("service_advice like", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceNotLike(String value) {
            addCriterion("service_advice not like", value, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceIn(java.util.List<java.lang.String> values) {
            addCriterion("service_advice in", values, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceNotIn(java.util.List<java.lang.String> values) {
            addCriterion("service_advice not in", values, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceBetween(String value1, String value2) {
            addCriterion("service_advice between", value1, value2, "serviceAdvice");
            return (Criteria) this;
        }

        public Criteria andServiceAdviceNotBetween(String value1, String value2) {
            addCriterion("service_advice not between", value1, value2, "serviceAdvice");
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
    b_yw_service_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}