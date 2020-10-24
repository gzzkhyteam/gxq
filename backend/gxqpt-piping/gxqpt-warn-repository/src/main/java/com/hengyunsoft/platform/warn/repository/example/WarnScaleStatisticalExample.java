package com.hengyunsoft.platform.warn.repository.example;

import java.io.Serializable;
import java.util.Date;

public class WarnScaleStatisticalExample extends com.hengyunsoft.db.example.BaseExample<WarnScaleStatisticalExample.Criteria> implements Serializable {
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

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(String value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(String value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(String value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(String value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(String value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLike(String value) {
            addCriterion("object_id like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotLike(String value) {
            addCriterion("object_id not like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(java.util.List<java.lang.String> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(String value1, String value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(String value1, String value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectNameIsNull() {
            addCriterion("object_name is null");
            return (Criteria) this;
        }

        public Criteria andObjectNameIsNotNull() {
            addCriterion("object_name is not null");
            return (Criteria) this;
        }

        public Criteria andObjectNameEqualTo(String value) {
            addCriterion("object_name =", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotEqualTo(String value) {
            addCriterion("object_name <>", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameGreaterThan(String value) {
            addCriterion("object_name >", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("object_name >=", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameLessThan(String value) {
            addCriterion("object_name <", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameLessThanOrEqualTo(String value) {
            addCriterion("object_name <=", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameLike(String value) {
            addCriterion("object_name like", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotLike(String value) {
            addCriterion("object_name not like", value, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameIn(java.util.List<java.lang.String> values) {
            addCriterion("object_name in", values, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("object_name not in", values, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameBetween(String value1, String value2) {
            addCriterion("object_name between", value1, value2, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectNameNotBetween(String value1, String value2) {
            addCriterion("object_name not between", value1, value2, "objectName");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(Integer value) {
            addCriterion("object_type =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(Integer value) {
            addCriterion("object_type <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(Integer value) {
            addCriterion("object_type >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("object_type >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(Integer value) {
            addCriterion("object_type <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("object_type <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("object_type in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("object_type not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("object_type between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("object_type not between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andPendingNumIsNull() {
            addCriterion("pending_num is null");
            return (Criteria) this;
        }

        public Criteria andPendingNumIsNotNull() {
            addCriterion("pending_num is not null");
            return (Criteria) this;
        }

        public Criteria andPendingNumEqualTo(Integer value) {
            addCriterion("pending_num =", value, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumNotEqualTo(Integer value) {
            addCriterion("pending_num <>", value, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumGreaterThan(Integer value) {
            addCriterion("pending_num >", value, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pending_num >=", value, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumLessThan(Integer value) {
            addCriterion("pending_num <", value, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumLessThanOrEqualTo(Integer value) {
            addCriterion("pending_num <=", value, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("pending_num in", values, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("pending_num not in", values, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumBetween(Integer value1, Integer value2) {
            addCriterion("pending_num between", value1, value2, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andPendingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pending_num not between", value1, value2, "pendingNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumIsNull() {
            addCriterion("new_come_num is null");
            return (Criteria) this;
        }

        public Criteria andNewComeNumIsNotNull() {
            addCriterion("new_come_num is not null");
            return (Criteria) this;
        }

        public Criteria andNewComeNumEqualTo(Integer value) {
            addCriterion("new_come_num =", value, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumNotEqualTo(Integer value) {
            addCriterion("new_come_num <>", value, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumGreaterThan(Integer value) {
            addCriterion("new_come_num >", value, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_come_num >=", value, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumLessThan(Integer value) {
            addCriterion("new_come_num <", value, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumLessThanOrEqualTo(Integer value) {
            addCriterion("new_come_num <=", value, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("new_come_num in", values, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("new_come_num not in", values, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumBetween(Integer value1, Integer value2) {
            addCriterion("new_come_num between", value1, value2, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andNewComeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("new_come_num not between", value1, value2, "newComeNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumIsNull() {
            addCriterion("handled_num is null");
            return (Criteria) this;
        }

        public Criteria andHandledNumIsNotNull() {
            addCriterion("handled_num is not null");
            return (Criteria) this;
        }

        public Criteria andHandledNumEqualTo(Integer value) {
            addCriterion("handled_num =", value, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumNotEqualTo(Integer value) {
            addCriterion("handled_num <>", value, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumGreaterThan(Integer value) {
            addCriterion("handled_num >", value, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("handled_num >=", value, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumLessThan(Integer value) {
            addCriterion("handled_num <", value, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumLessThanOrEqualTo(Integer value) {
            addCriterion("handled_num <=", value, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("handled_num in", values, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("handled_num not in", values, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumBetween(Integer value1, Integer value2) {
            addCriterion("handled_num between", value1, value2, "handledNum");
            return (Criteria) this;
        }

        public Criteria andHandledNumNotBetween(Integer value1, Integer value2) {
            addCriterion("handled_num not between", value1, value2, "handledNum");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleIsNull() {
            addCriterion("statistical_scale is null");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleIsNotNull() {
            addCriterion("statistical_scale is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleEqualTo(String value) {
            addCriterion("statistical_scale =", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleNotEqualTo(String value) {
            addCriterion("statistical_scale <>", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleGreaterThan(String value) {
            addCriterion("statistical_scale >", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleGreaterThanOrEqualTo(String value) {
            addCriterion("statistical_scale >=", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleLessThan(String value) {
            addCriterion("statistical_scale <", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleLessThanOrEqualTo(String value) {
            addCriterion("statistical_scale <=", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleLike(String value) {
            addCriterion("statistical_scale like", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleNotLike(String value) {
            addCriterion("statistical_scale not like", value, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleIn(java.util.List<java.lang.String> values) {
            addCriterion("statistical_scale in", values, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("statistical_scale not in", values, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleBetween(String value1, String value2) {
            addCriterion("statistical_scale between", value1, value2, "statisticalScale");
            return (Criteria) this;
        }

        public Criteria andStatisticalScaleNotBetween(String value1, String value2) {
            addCriterion("statistical_scale not between", value1, value2, "statisticalScale");
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
    b_warn_scale_statisticaladdClassComment 472
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