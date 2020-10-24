package com.hengyunsoft.platform.developer.repository.fast.attence.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkApproveBusinessExample extends com.hengyunsoft.db.example.BaseExample<WorkApproveBusinessExample.Criteria> implements Serializable {
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

        public Criteria andAproveIdIsNull() {
            addCriterion("aprove_id is null");
            return (Criteria) this;
        }

        public Criteria andAproveIdIsNotNull() {
            addCriterion("aprove_id is not null");
            return (Criteria) this;
        }

        public Criteria andAproveIdEqualTo(Long value) {
            addCriterion("aprove_id =", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdNotEqualTo(Long value) {
            addCriterion("aprove_id <>", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdGreaterThan(Long value) {
            addCriterion("aprove_id >", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdGreaterThanOrEqualTo(Long value) {
            addCriterion("aprove_id >=", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdLessThan(Long value) {
            addCriterion("aprove_id <", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdLessThanOrEqualTo(Long value) {
            addCriterion("aprove_id <=", value, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("aprove_id in", values, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("aprove_id not in", values, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdBetween(Long value1, Long value2) {
            addCriterion("aprove_id between", value1, value2, "aproveId");
            return (Criteria) this;
        }

        public Criteria andAproveIdNotBetween(Long value1, Long value2) {
            addCriterion("aprove_id not between", value1, value2, "aproveId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("business_type like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("business_type not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andWorkAgentIsNull() {
            addCriterion("work_agent is null");
            return (Criteria) this;
        }

        public Criteria andWorkAgentIsNotNull() {
            addCriterion("work_agent is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAgentEqualTo(Long value) {
            addCriterion("work_agent =", value, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentNotEqualTo(Long value) {
            addCriterion("work_agent <>", value, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentGreaterThan(Long value) {
            addCriterion("work_agent >", value, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentGreaterThanOrEqualTo(Long value) {
            addCriterion("work_agent >=", value, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentLessThan(Long value) {
            addCriterion("work_agent <", value, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentLessThanOrEqualTo(Long value) {
            addCriterion("work_agent <=", value, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentIn(java.util.List<java.lang.Long> values) {
            addCriterion("work_agent in", values, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("work_agent not in", values, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentBetween(Long value1, Long value2) {
            addCriterion("work_agent between", value1, value2, "workAgent");
            return (Criteria) this;
        }

        public Criteria andWorkAgentNotBetween(Long value1, Long value2) {
            addCriterion("work_agent not between", value1, value2, "workAgent");
            return (Criteria) this;
        }

        public Criteria andAddrTypeIsNull() {
            addCriterion("addr_type is null");
            return (Criteria) this;
        }

        public Criteria andAddrTypeIsNotNull() {
            addCriterion("addr_type is not null");
            return (Criteria) this;
        }

        public Criteria andAddrTypeEqualTo(Integer value) {
            addCriterion("addr_type =", value, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeNotEqualTo(Integer value) {
            addCriterion("addr_type <>", value, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeGreaterThan(Integer value) {
            addCriterion("addr_type >", value, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_type >=", value, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeLessThan(Integer value) {
            addCriterion("addr_type <", value, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeLessThanOrEqualTo(Integer value) {
            addCriterion("addr_type <=", value, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("addr_type in", values, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("addr_type not in", values, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeBetween(Integer value1, Integer value2) {
            addCriterion("addr_type between", value1, value2, "addrType");
            return (Criteria) this;
        }

        public Criteria andAddrTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_type not between", value1, value2, "addrType");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrIsNull() {
            addCriterion("business_addr is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrIsNotNull() {
            addCriterion("business_addr is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrEqualTo(String value) {
            addCriterion("business_addr =", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrNotEqualTo(String value) {
            addCriterion("business_addr <>", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrGreaterThan(String value) {
            addCriterion("business_addr >", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrGreaterThanOrEqualTo(String value) {
            addCriterion("business_addr >=", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrLessThan(String value) {
            addCriterion("business_addr <", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrLessThanOrEqualTo(String value) {
            addCriterion("business_addr <=", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrLike(String value) {
            addCriterion("business_addr like", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrNotLike(String value) {
            addCriterion("business_addr not like", value, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrIn(java.util.List<java.lang.String> values) {
            addCriterion("business_addr in", values, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrNotIn(java.util.List<java.lang.String> values) {
            addCriterion("business_addr not in", values, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrBetween(String value1, String value2) {
            addCriterion("business_addr between", value1, value2, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessAddrNotBetween(String value1, String value2) {
            addCriterion("business_addr not between", value1, value2, "businessAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleIsNull() {
            addCriterion("business_vehicle is null");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleIsNotNull() {
            addCriterion("business_vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleEqualTo(String value) {
            addCriterion("business_vehicle =", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleNotEqualTo(String value) {
            addCriterion("business_vehicle <>", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleGreaterThan(String value) {
            addCriterion("business_vehicle >", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("business_vehicle >=", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleLessThan(String value) {
            addCriterion("business_vehicle <", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleLessThanOrEqualTo(String value) {
            addCriterion("business_vehicle <=", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleLike(String value) {
            addCriterion("business_vehicle like", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleNotLike(String value) {
            addCriterion("business_vehicle not like", value, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleIn(java.util.List<java.lang.String> values) {
            addCriterion("business_vehicle in", values, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("business_vehicle not in", values, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleBetween(String value1, String value2) {
            addCriterion("business_vehicle between", value1, value2, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andBusinessVehicleNotBetween(String value1, String value2) {
            addCriterion("business_vehicle not between", value1, value2, "businessVehicle");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserIsNull() {
            addCriterion("accompany_user is null");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserIsNotNull() {
            addCriterion("accompany_user is not null");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserEqualTo(String value) {
            addCriterion("accompany_user =", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserNotEqualTo(String value) {
            addCriterion("accompany_user <>", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserGreaterThan(String value) {
            addCriterion("accompany_user >", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserGreaterThanOrEqualTo(String value) {
            addCriterion("accompany_user >=", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserLessThan(String value) {
            addCriterion("accompany_user <", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserLessThanOrEqualTo(String value) {
            addCriterion("accompany_user <=", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserLike(String value) {
            addCriterion("accompany_user like", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserNotLike(String value) {
            addCriterion("accompany_user not like", value, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserIn(java.util.List<java.lang.String> values) {
            addCriterion("accompany_user in", values, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("accompany_user not in", values, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserBetween(String value1, String value2) {
            addCriterion("accompany_user between", value1, value2, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserNotBetween(String value1, String value2) {
            addCriterion("accompany_user not between", value1, value2, "accompanyUser");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneIsNull() {
            addCriterion("accompany_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneIsNotNull() {
            addCriterion("accompany_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneEqualTo(String value) {
            addCriterion("accompany_user_phone =", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneNotEqualTo(String value) {
            addCriterion("accompany_user_phone <>", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneGreaterThan(String value) {
            addCriterion("accompany_user_phone >", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("accompany_user_phone >=", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneLessThan(String value) {
            addCriterion("accompany_user_phone <", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("accompany_user_phone <=", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneLike(String value) {
            addCriterion("accompany_user_phone like", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneNotLike(String value) {
            addCriterion("accompany_user_phone not like", value, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneIn(java.util.List<java.lang.String> values) {
            addCriterion("accompany_user_phone in", values, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneNotIn(java.util.List<java.lang.String> values) {
            addCriterion("accompany_user_phone not in", values, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneBetween(String value1, String value2) {
            addCriterion("accompany_user_phone between", value1, value2, "accompanyUserPhone");
            return (Criteria) this;
        }

        public Criteria andAccompanyUserPhoneNotBetween(String value1, String value2) {
            addCriterion("accompany_user_phone not between", value1, value2, "accompanyUserPhone");
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

        public Criteria andBusHourIsNull() {
            addCriterion("bus_hour is null");
            return (Criteria) this;
        }

        public Criteria andBusHourIsNotNull() {
            addCriterion("bus_hour is not null");
            return (Criteria) this;
        }

        public Criteria andBusHourEqualTo(Float value) {
            addCriterion("bus_hour =", value, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourNotEqualTo(Float value) {
            addCriterion("bus_hour <>", value, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourGreaterThan(Float value) {
            addCriterion("bus_hour >", value, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourGreaterThanOrEqualTo(Float value) {
            addCriterion("bus_hour >=", value, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourLessThan(Float value) {
            addCriterion("bus_hour <", value, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourLessThanOrEqualTo(Float value) {
            addCriterion("bus_hour <=", value, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourIn(java.util.List<java.lang.Float> values) {
            addCriterion("bus_hour in", values, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourNotIn(java.util.List<java.lang.Float> values) {
            addCriterion("bus_hour not in", values, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourBetween(Float value1, Float value2) {
            addCriterion("bus_hour between", value1, value2, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusHourNotBetween(Float value1, Float value2) {
            addCriterion("bus_hour not between", value1, value2, "busHour");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonIsNull() {
            addCriterion("business_renson is null");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonIsNotNull() {
            addCriterion("business_renson is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonEqualTo(String value) {
            addCriterion("business_renson =", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonNotEqualTo(String value) {
            addCriterion("business_renson <>", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonGreaterThan(String value) {
            addCriterion("business_renson >", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonGreaterThanOrEqualTo(String value) {
            addCriterion("business_renson >=", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonLessThan(String value) {
            addCriterion("business_renson <", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonLessThanOrEqualTo(String value) {
            addCriterion("business_renson <=", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonLike(String value) {
            addCriterion("business_renson like", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonNotLike(String value) {
            addCriterion("business_renson not like", value, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonIn(java.util.List<java.lang.String> values) {
            addCriterion("business_renson in", values, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonNotIn(java.util.List<java.lang.String> values) {
            addCriterion("business_renson not in", values, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonBetween(String value1, String value2) {
            addCriterion("business_renson between", value1, value2, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andBusinessRensonNotBetween(String value1, String value2) {
            addCriterion("business_renson not between", value1, value2, "businessRenson");
            return (Criteria) this;
        }

        public Criteria andTravelApplyIsNull() {
            addCriterion("travel_apply is null");
            return (Criteria) this;
        }

        public Criteria andTravelApplyIsNotNull() {
            addCriterion("travel_apply is not null");
            return (Criteria) this;
        }

        public Criteria andTravelApplyEqualTo(Integer value) {
            addCriterion("travel_apply =", value, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyNotEqualTo(Integer value) {
            addCriterion("travel_apply <>", value, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyGreaterThan(Integer value) {
            addCriterion("travel_apply >", value, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_apply >=", value, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyLessThan(Integer value) {
            addCriterion("travel_apply <", value, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyLessThanOrEqualTo(Integer value) {
            addCriterion("travel_apply <=", value, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyIn(java.util.List<java.lang.Integer> values) {
            addCriterion("travel_apply in", values, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("travel_apply not in", values, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyBetween(Integer value1, Integer value2) {
            addCriterion("travel_apply between", value1, value2, "travelApply");
            return (Criteria) this;
        }

        public Criteria andTravelApplyNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_apply not between", value1, value2, "travelApply");
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
    b_work_appr_businessaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}