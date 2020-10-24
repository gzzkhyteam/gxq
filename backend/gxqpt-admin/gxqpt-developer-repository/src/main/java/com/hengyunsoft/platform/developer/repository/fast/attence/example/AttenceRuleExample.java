package com.hengyunsoft.platform.developer.repository.fast.attence.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttenceRuleExample extends com.hengyunsoft.db.example.BaseExample<AttenceRuleExample.Criteria> implements Serializable {
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

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(String value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(String value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(String value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(String value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(String value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(String value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLike(String value) {
            addCriterion("in_time like", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotLike(String value) {
            addCriterion("in_time not like", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(String value1, String value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(String value1, String value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(String value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(String value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(String value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(String value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(String value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLike(String value) {
            addCriterion("out_time like", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotLike(String value) {
            addCriterion("out_time not like", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(String value1, String value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(String value1, String value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeIsNull() {
            addCriterion("later_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeIsNotNull() {
            addCriterion("later_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeEqualTo(String value) {
            addCriterion("later_start_time =", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeNotEqualTo(String value) {
            addCriterion("later_start_time <>", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeGreaterThan(String value) {
            addCriterion("later_start_time >", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("later_start_time >=", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeLessThan(String value) {
            addCriterion("later_start_time <", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeLessThanOrEqualTo(String value) {
            addCriterion("later_start_time <=", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeLike(String value) {
            addCriterion("later_start_time like", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeNotLike(String value) {
            addCriterion("later_start_time not like", value, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("later_start_time in", values, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("later_start_time not in", values, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeBetween(String value1, String value2) {
            addCriterion("later_start_time between", value1, value2, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterStartTimeNotBetween(String value1, String value2) {
            addCriterion("later_start_time not between", value1, value2, "laterStartTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeIsNull() {
            addCriterion("later_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeIsNotNull() {
            addCriterion("later_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeEqualTo(String value) {
            addCriterion("later_end_time =", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeNotEqualTo(String value) {
            addCriterion("later_end_time <>", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeGreaterThan(String value) {
            addCriterion("later_end_time >", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("later_end_time >=", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeLessThan(String value) {
            addCriterion("later_end_time <", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeLessThanOrEqualTo(String value) {
            addCriterion("later_end_time <=", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeLike(String value) {
            addCriterion("later_end_time like", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeNotLike(String value) {
            addCriterion("later_end_time not like", value, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("later_end_time in", values, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("later_end_time not in", values, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeBetween(String value1, String value2) {
            addCriterion("later_end_time between", value1, value2, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLaterEndTimeNotBetween(String value1, String value2) {
            addCriterion("later_end_time not between", value1, value2, "laterEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeIsNull() {
            addCriterion("lunch_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeIsNotNull() {
            addCriterion("lunch_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeEqualTo(String value) {
            addCriterion("lunch_start_time =", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeNotEqualTo(String value) {
            addCriterion("lunch_start_time <>", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeGreaterThan(String value) {
            addCriterion("lunch_start_time >", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_start_time >=", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeLessThan(String value) {
            addCriterion("lunch_start_time <", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeLessThanOrEqualTo(String value) {
            addCriterion("lunch_start_time <=", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeLike(String value) {
            addCriterion("lunch_start_time like", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeNotLike(String value) {
            addCriterion("lunch_start_time not like", value, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("lunch_start_time in", values, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("lunch_start_time not in", values, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeBetween(String value1, String value2) {
            addCriterion("lunch_start_time between", value1, value2, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchStartTimeNotBetween(String value1, String value2) {
            addCriterion("lunch_start_time not between", value1, value2, "lunchStartTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeIsNull() {
            addCriterion("lunch_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeIsNotNull() {
            addCriterion("lunch_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeEqualTo(String value) {
            addCriterion("lunch_end_time =", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeNotEqualTo(String value) {
            addCriterion("lunch_end_time <>", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeGreaterThan(String value) {
            addCriterion("lunch_end_time >", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_end_time >=", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeLessThan(String value) {
            addCriterion("lunch_end_time <", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeLessThanOrEqualTo(String value) {
            addCriterion("lunch_end_time <=", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeLike(String value) {
            addCriterion("lunch_end_time like", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeNotLike(String value) {
            addCriterion("lunch_end_time not like", value, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("lunch_end_time in", values, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("lunch_end_time not in", values, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeBetween(String value1, String value2) {
            addCriterion("lunch_end_time between", value1, value2, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andLunchEndTimeNotBetween(String value1, String value2) {
            addCriterion("lunch_end_time not between", value1, value2, "lunchEndTime");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeIsNull() {
            addCriterion("absent_time_range is null");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeIsNotNull() {
            addCriterion("absent_time_range is not null");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeEqualTo(String value) {
            addCriterion("absent_time_range =", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeNotEqualTo(String value) {
            addCriterion("absent_time_range <>", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeGreaterThan(String value) {
            addCriterion("absent_time_range >", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeGreaterThanOrEqualTo(String value) {
            addCriterion("absent_time_range >=", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeLessThan(String value) {
            addCriterion("absent_time_range <", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeLessThanOrEqualTo(String value) {
            addCriterion("absent_time_range <=", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeLike(String value) {
            addCriterion("absent_time_range like", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeNotLike(String value) {
            addCriterion("absent_time_range not like", value, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeIn(java.util.List<java.lang.String> values) {
            addCriterion("absent_time_range in", values, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("absent_time_range not in", values, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeBetween(String value1, String value2) {
            addCriterion("absent_time_range between", value1, value2, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andAbsentTimeRangeNotBetween(String value1, String value2) {
            addCriterion("absent_time_range not between", value1, value2, "absentTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeIsNull() {
            addCriterion("leave_time_range is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeIsNotNull() {
            addCriterion("leave_time_range is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeEqualTo(String value) {
            addCriterion("leave_time_range =", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeNotEqualTo(String value) {
            addCriterion("leave_time_range <>", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeGreaterThan(String value) {
            addCriterion("leave_time_range >", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeGreaterThanOrEqualTo(String value) {
            addCriterion("leave_time_range >=", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeLessThan(String value) {
            addCriterion("leave_time_range <", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeLessThanOrEqualTo(String value) {
            addCriterion("leave_time_range <=", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeLike(String value) {
            addCriterion("leave_time_range like", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeNotLike(String value) {
            addCriterion("leave_time_range not like", value, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeIn(java.util.List<java.lang.String> values) {
            addCriterion("leave_time_range in", values, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("leave_time_range not in", values, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeBetween(String value1, String value2) {
            addCriterion("leave_time_range between", value1, value2, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeRangeNotBetween(String value1, String value2) {
            addCriterion("leave_time_range not between", value1, value2, "leaveTimeRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeIsNull() {
            addCriterion("distance_range is null");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeIsNotNull() {
            addCriterion("distance_range is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeEqualTo(String value) {
            addCriterion("distance_range =", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeNotEqualTo(String value) {
            addCriterion("distance_range <>", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeGreaterThan(String value) {
            addCriterion("distance_range >", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeGreaterThanOrEqualTo(String value) {
            addCriterion("distance_range >=", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeLessThan(String value) {
            addCriterion("distance_range <", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeLessThanOrEqualTo(String value) {
            addCriterion("distance_range <=", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeLike(String value) {
            addCriterion("distance_range like", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeNotLike(String value) {
            addCriterion("distance_range not like", value, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeIn(java.util.List<java.lang.String> values) {
            addCriterion("distance_range in", values, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("distance_range not in", values, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeBetween(String value1, String value2) {
            addCriterion("distance_range between", value1, value2, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andDistanceRangeNotBetween(String value1, String value2) {
            addCriterion("distance_range not between", value1, value2, "distanceRange");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(java.util.List<java.lang.Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andUploadUrlIsNull() {
            addCriterion("upload_url is null");
            return (Criteria) this;
        }

        public Criteria andUploadUrlIsNotNull() {
            addCriterion("upload_url is not null");
            return (Criteria) this;
        }

        public Criteria andUploadUrlEqualTo(String value) {
            addCriterion("upload_url =", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlNotEqualTo(String value) {
            addCriterion("upload_url <>", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlGreaterThan(String value) {
            addCriterion("upload_url >", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("upload_url >=", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlLessThan(String value) {
            addCriterion("upload_url <", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlLessThanOrEqualTo(String value) {
            addCriterion("upload_url <=", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlLike(String value) {
            addCriterion("upload_url like", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlNotLike(String value) {
            addCriterion("upload_url not like", value, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("upload_url in", values, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("upload_url not in", values, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlBetween(String value1, String value2) {
            addCriterion("upload_url between", value1, value2, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andUploadUrlNotBetween(String value1, String value2) {
            addCriterion("upload_url not between", value1, value2, "uploadUrl");
            return (Criteria) this;
        }

        public Criteria andLongtudeIsNull() {
            addCriterion("longtude is null");
            return (Criteria) this;
        }

        public Criteria andLongtudeIsNotNull() {
            addCriterion("longtude is not null");
            return (Criteria) this;
        }

        public Criteria andLongtudeEqualTo(Double value) {
            addCriterion("longtude =", value, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeNotEqualTo(Double value) {
            addCriterion("longtude <>", value, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeGreaterThan(Double value) {
            addCriterion("longtude >", value, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longtude >=", value, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeLessThan(Double value) {
            addCriterion("longtude <", value, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeLessThanOrEqualTo(Double value) {
            addCriterion("longtude <=", value, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeIn(java.util.List<java.lang.Double> values) {
            addCriterion("longtude in", values, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("longtude not in", values, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeBetween(Double value1, Double value2) {
            addCriterion("longtude between", value1, value2, "longtude");
            return (Criteria) this;
        }

        public Criteria andLongtudeNotBetween(Double value1, Double value2) {
            addCriterion("longtude not between", value1, value2, "longtude");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(java.util.List<java.lang.String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
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

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCoefficientIsNull() {
            addCriterion("coefficient is null");
            return (Criteria) this;
        }

        public Criteria andCoefficientIsNotNull() {
            addCriterion("coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andCoefficientEqualTo(Float value) {
            addCriterion("coefficient =", value, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientNotEqualTo(Float value) {
            addCriterion("coefficient <>", value, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientGreaterThan(Float value) {
            addCriterion("coefficient >", value, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientGreaterThanOrEqualTo(Float value) {
            addCriterion("coefficient >=", value, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientLessThan(Float value) {
            addCriterion("coefficient <", value, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientLessThanOrEqualTo(Float value) {
            addCriterion("coefficient <=", value, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientIn(java.util.List<java.lang.Float> values) {
            addCriterion("coefficient in", values, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("coefficient not in", values, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientBetween(Float value1, Float value2) {
            addCriterion("coefficient between", value1, value2, "coefficient");
            return (Criteria) this;
        }

        public Criteria andCoefficientNotBetween(Float value1, Float value2) {
            addCriterion("coefficient not between", value1, value2, "coefficient");
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
    b_attence_ruleaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}