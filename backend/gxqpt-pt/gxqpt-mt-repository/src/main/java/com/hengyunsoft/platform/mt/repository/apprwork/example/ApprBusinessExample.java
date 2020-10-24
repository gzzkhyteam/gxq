package com.hengyunsoft.platform.mt.repository.apprwork.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApprBusinessExample extends com.hengyunsoft.db.example.BaseExample<ApprBusinessExample.Criteria> implements Serializable {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Long value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Long value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Long value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Long value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Long value1, Long value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIsNull() {
            addCriterion("leave_type is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIsNotNull() {
            addCriterion("leave_type is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeEqualTo(String value) {
            addCriterion("leave_type =", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotEqualTo(String value) {
            addCriterion("leave_type <>", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeGreaterThan(String value) {
            addCriterion("leave_type >", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("leave_type >=", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLessThan(String value) {
            addCriterion("leave_type <", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLessThanOrEqualTo(String value) {
            addCriterion("leave_type <=", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLike(String value) {
            addCriterion("leave_type like", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotLike(String value) {
            addCriterion("leave_type not like", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("leave_type in", values, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("leave_type not in", values, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeBetween(String value1, String value2) {
            addCriterion("leave_type between", value1, value2, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotBetween(String value1, String value2) {
            addCriterion("leave_type not between", value1, value2, "leaveType");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(java.util.List<java.lang.String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(java.util.List<java.lang.String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(java.util.List<java.lang.String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(java.util.List<java.lang.String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(java.util.List<java.lang.String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(java.util.List<java.lang.String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNull() {
            addCriterion("vehicle is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNotNull() {
            addCriterion("vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleEqualTo(String value) {
            addCriterion("vehicle =", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotEqualTo(String value) {
            addCriterion("vehicle <>", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThan(String value) {
            addCriterion("vehicle >", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle >=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThan(String value) {
            addCriterion("vehicle <", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThanOrEqualTo(String value) {
            addCriterion("vehicle <=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLike(String value) {
            addCriterion("vehicle like", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotLike(String value) {
            addCriterion("vehicle not like", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleIn(java.util.List<java.lang.String> values) {
            addCriterion("vehicle in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("vehicle not in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleBetween(String value1, String value2) {
            addCriterion("vehicle between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotBetween(String value1, String value2) {
            addCriterion("vehicle not between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andEntourageIsNull() {
            addCriterion("entourage is null");
            return (Criteria) this;
        }

        public Criteria andEntourageIsNotNull() {
            addCriterion("entourage is not null");
            return (Criteria) this;
        }

        public Criteria andEntourageEqualTo(String value) {
            addCriterion("entourage =", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageNotEqualTo(String value) {
            addCriterion("entourage <>", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageGreaterThan(String value) {
            addCriterion("entourage >", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageGreaterThanOrEqualTo(String value) {
            addCriterion("entourage >=", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageLessThan(String value) {
            addCriterion("entourage <", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageLessThanOrEqualTo(String value) {
            addCriterion("entourage <=", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageLike(String value) {
            addCriterion("entourage like", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageNotLike(String value) {
            addCriterion("entourage not like", value, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageIn(java.util.List<java.lang.String> values) {
            addCriterion("entourage in", values, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageNotIn(java.util.List<java.lang.String> values) {
            addCriterion("entourage not in", values, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageBetween(String value1, String value2) {
            addCriterion("entourage between", value1, value2, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntourageNotBetween(String value1, String value2) {
            addCriterion("entourage not between", value1, value2, "entourage");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneIsNull() {
            addCriterion("entourage_phone is null");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneIsNotNull() {
            addCriterion("entourage_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneEqualTo(String value) {
            addCriterion("entourage_phone =", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneNotEqualTo(String value) {
            addCriterion("entourage_phone <>", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneGreaterThan(String value) {
            addCriterion("entourage_phone >", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("entourage_phone >=", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneLessThan(String value) {
            addCriterion("entourage_phone <", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneLessThanOrEqualTo(String value) {
            addCriterion("entourage_phone <=", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneLike(String value) {
            addCriterion("entourage_phone like", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneNotLike(String value) {
            addCriterion("entourage_phone not like", value, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneIn(java.util.List<java.lang.String> values) {
            addCriterion("entourage_phone in", values, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneNotIn(java.util.List<java.lang.String> values) {
            addCriterion("entourage_phone not in", values, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneBetween(String value1, String value2) {
            addCriterion("entourage_phone between", value1, value2, "entouragePhone");
            return (Criteria) this;
        }

        public Criteria andEntouragePhoneNotBetween(String value1, String value2) {
            addCriterion("entourage_phone not between", value1, value2, "entouragePhone");
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

        public Criteria andBusinessHourIsNull() {
            addCriterion("business_hour is null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourIsNotNull() {
            addCriterion("business_hour is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourEqualTo(Float value) {
            addCriterion("business_hour =", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourNotEqualTo(Float value) {
            addCriterion("business_hour <>", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourGreaterThan(Float value) {
            addCriterion("business_hour >", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourGreaterThanOrEqualTo(Float value) {
            addCriterion("business_hour >=", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourLessThan(Float value) {
            addCriterion("business_hour <", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourLessThanOrEqualTo(Float value) {
            addCriterion("business_hour <=", value, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("business_hour in", values, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("business_hour not in", values, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourBetween(Float value1, Float value2) {
            addCriterion("business_hour between", value1, value2, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessHourNotBetween(Float value1, Float value2) {
            addCriterion("business_hour not between", value1, value2, "businessHour");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonIsNull() {
            addCriterion("business_reason is null");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonIsNotNull() {
            addCriterion("business_reason is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonEqualTo(String value) {
            addCriterion("business_reason =", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonNotEqualTo(String value) {
            addCriterion("business_reason <>", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonGreaterThan(String value) {
            addCriterion("business_reason >", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonGreaterThanOrEqualTo(String value) {
            addCriterion("business_reason >=", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonLessThan(String value) {
            addCriterion("business_reason <", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonLessThanOrEqualTo(String value) {
            addCriterion("business_reason <=", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonLike(String value) {
            addCriterion("business_reason like", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonNotLike(String value) {
            addCriterion("business_reason not like", value, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonIn(java.util.List<java.lang.String> values) {
            addCriterion("business_reason in", values, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("business_reason not in", values, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonBetween(String value1, String value2) {
            addCriterion("business_reason between", value1, value2, "businessReason");
            return (Criteria) this;
        }

        public Criteria andBusinessReasonNotBetween(String value1, String value2) {
            addCriterion("business_reason not between", value1, value2, "businessReason");
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
    b_appr_businessaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}