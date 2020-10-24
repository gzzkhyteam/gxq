package com.hengyunsoft.platform.warn.repository.example;

import java.io.Serializable;
import java.util.Date;

public class WarnTimeSlotExample extends com.hengyunsoft.db.example.BaseExample<WarnTimeSlotExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

		private static final long serialVersionUID = 1L;

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

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(java.util.List<java.lang.String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andPendingIsNull() {
            addCriterion("pending is null");
            return (Criteria) this;
        }

        public Criteria andPendingIsNotNull() {
            addCriterion("pending is not null");
            return (Criteria) this;
        }

        public Criteria andPendingEqualTo(Integer value) {
            addCriterion("pending =", value, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingNotEqualTo(Integer value) {
            addCriterion("pending <>", value, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingGreaterThan(Integer value) {
            addCriterion("pending >", value, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingGreaterThanOrEqualTo(Integer value) {
            addCriterion("pending >=", value, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingLessThan(Integer value) {
            addCriterion("pending <", value, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingLessThanOrEqualTo(Integer value) {
            addCriterion("pending <=", value, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingIn(java.util.List<java.lang.Integer> values) {
            addCriterion("pending in", values, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("pending not in", values, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingBetween(Integer value1, Integer value2) {
            addCriterion("pending between", value1, value2, "pending");
            return (Criteria) this;
        }

        public Criteria andPendingNotBetween(Integer value1, Integer value2) {
            addCriterion("pending not between", value1, value2, "pending");
            return (Criteria) this;
        }

        public Criteria andNewComeIsNull() {
            addCriterion("new_come is null");
            return (Criteria) this;
        }

        public Criteria andNewComeIsNotNull() {
            addCriterion("new_come is not null");
            return (Criteria) this;
        }

        public Criteria andNewComeEqualTo(Integer value) {
            addCriterion("new_come =", value, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeNotEqualTo(Integer value) {
            addCriterion("new_come <>", value, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeGreaterThan(Integer value) {
            addCriterion("new_come >", value, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_come >=", value, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeLessThan(Integer value) {
            addCriterion("new_come <", value, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeLessThanOrEqualTo(Integer value) {
            addCriterion("new_come <=", value, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("new_come in", values, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("new_come not in", values, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeBetween(Integer value1, Integer value2) {
            addCriterion("new_come between", value1, value2, "newCome");
            return (Criteria) this;
        }

        public Criteria andNewComeNotBetween(Integer value1, Integer value2) {
            addCriterion("new_come not between", value1, value2, "newCome");
            return (Criteria) this;
        }

        public Criteria andHandledIsNull() {
            addCriterion("handled is null");
            return (Criteria) this;
        }

        public Criteria andHandledIsNotNull() {
            addCriterion("handled is not null");
            return (Criteria) this;
        }

        public Criteria andHandledEqualTo(Integer value) {
            addCriterion("handled =", value, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledNotEqualTo(Integer value) {
            addCriterion("handled <>", value, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledGreaterThan(Integer value) {
            addCriterion("handled >", value, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledGreaterThanOrEqualTo(Integer value) {
            addCriterion("handled >=", value, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledLessThan(Integer value) {
            addCriterion("handled <", value, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledLessThanOrEqualTo(Integer value) {
            addCriterion("handled <=", value, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledIn(java.util.List<java.lang.Integer> values) {
            addCriterion("handled in", values, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("handled not in", values, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledBetween(Integer value1, Integer value2) {
            addCriterion("handled between", value1, value2, "handled");
            return (Criteria) this;
        }

        public Criteria andHandledNotBetween(Integer value1, Integer value2) {
            addCriterion("handled not between", value1, value2, "handled");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeIsNull() {
            addCriterion("statistical_time is null");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeIsNotNull() {
            addCriterion("statistical_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeEqualTo(String value) {
            addCriterion("statistical_time =", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeNotEqualTo(String value) {
            addCriterion("statistical_time <>", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeGreaterThan(String value) {
            addCriterion("statistical_time >", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeGreaterThanOrEqualTo(String value) {
            addCriterion("statistical_time >=", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeLessThan(String value) {
            addCriterion("statistical_time <", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeLessThanOrEqualTo(String value) {
            addCriterion("statistical_time <=", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeLike(String value) {
            addCriterion("statistical_time like", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeNotLike(String value) {
            addCriterion("statistical_time not like", value, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("statistical_time in", values, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("statistical_time not in", values, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeBetween(String value1, String value2) {
            addCriterion("statistical_time between", value1, value2, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andStatisticalTimeNotBetween(String value1, String value2) {
            addCriterion("statistical_time not between", value1, value2, "statisticalTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeIsNull() {
            addCriterion("avg_handle_time is null");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeIsNotNull() {
            addCriterion("avg_handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeEqualTo(String value) {
            addCriterion("avg_handle_time =", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeNotEqualTo(String value) {
            addCriterion("avg_handle_time <>", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeGreaterThan(String value) {
            addCriterion("avg_handle_time >", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeGreaterThanOrEqualTo(String value) {
            addCriterion("avg_handle_time >=", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeLessThan(String value) {
            addCriterion("avg_handle_time <", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeLessThanOrEqualTo(String value) {
            addCriterion("avg_handle_time <=", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeLike(String value) {
            addCriterion("avg_handle_time like", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeNotLike(String value) {
            addCriterion("avg_handle_time not like", value, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("avg_handle_time in", values, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("avg_handle_time not in", values, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeBetween(String value1, String value2) {
            addCriterion("avg_handle_time between", value1, value2, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgHandleTimeNotBetween(String value1, String value2) {
            addCriterion("avg_handle_time not between", value1, value2, "avgHandleTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeIsNull() {
            addCriterion("avg_confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeIsNotNull() {
            addCriterion("avg_confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeEqualTo(String value) {
            addCriterion("avg_confirm_time =", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeNotEqualTo(String value) {
            addCriterion("avg_confirm_time <>", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeGreaterThan(String value) {
            addCriterion("avg_confirm_time >", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeGreaterThanOrEqualTo(String value) {
            addCriterion("avg_confirm_time >=", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeLessThan(String value) {
            addCriterion("avg_confirm_time <", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeLessThanOrEqualTo(String value) {
            addCriterion("avg_confirm_time <=", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeLike(String value) {
            addCriterion("avg_confirm_time like", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeNotLike(String value) {
            addCriterion("avg_confirm_time not like", value, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("avg_confirm_time in", values, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("avg_confirm_time not in", values, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeBetween(String value1, String value2) {
            addCriterion("avg_confirm_time between", value1, value2, "avgConfirmTime");
            return (Criteria) this;
        }

        public Criteria andAvgConfirmTimeNotBetween(String value1, String value2) {
            addCriterion("avg_confirm_time not between", value1, value2, "avgConfirmTime");
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
    }

    /**
    b_warn_timeslotaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

		private static final long serialVersionUID = 1L;

		public Criteria() {
            super();
        }
    }
}