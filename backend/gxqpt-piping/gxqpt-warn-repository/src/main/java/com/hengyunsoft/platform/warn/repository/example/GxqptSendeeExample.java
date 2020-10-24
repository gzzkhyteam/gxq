package com.hengyunsoft.platform.warn.repository.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GxqptSendeeExample extends com.hengyunsoft.db.example.BaseExample<GxqptSendeeExample.Criteria> implements Serializable {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWarnIdIsNull() {
            addCriterion("warn_id is null");
            return (Criteria) this;
        }

        public Criteria andWarnIdIsNotNull() {
            addCriterion("warn_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarnIdEqualTo(Long value) {
            addCriterion("warn_id =", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotEqualTo(Long value) {
            addCriterion("warn_id <>", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThan(Long value) {
            addCriterion("warn_id >", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("warn_id >=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThan(Long value) {
            addCriterion("warn_id <", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThanOrEqualTo(Long value) {
            addCriterion("warn_id <=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("warn_id in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("warn_id not in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdBetween(Long value1, Long value2) {
            addCriterion("warn_id between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotBetween(Long value1, Long value2) {
            addCriterion("warn_id not between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andRecNameIsNull() {
            addCriterion("rec_name is null");
            return (Criteria) this;
        }

        public Criteria andRecNameIsNotNull() {
            addCriterion("rec_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecNameEqualTo(String value) {
            addCriterion("rec_name =", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameNotEqualTo(String value) {
            addCriterion("rec_name <>", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameGreaterThan(String value) {
            addCriterion("rec_name >", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameGreaterThanOrEqualTo(String value) {
            addCriterion("rec_name >=", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameLessThan(String value) {
            addCriterion("rec_name <", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameLessThanOrEqualTo(String value) {
            addCriterion("rec_name <=", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameLike(String value) {
            addCriterion("rec_name like", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameNotLike(String value) {
            addCriterion("rec_name not like", value, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameIn(java.util.List<java.lang.String> values) {
            addCriterion("rec_name in", values, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("rec_name not in", values, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameBetween(String value1, String value2) {
            addCriterion("rec_name between", value1, value2, "recName");
            return (Criteria) this;
        }

        public Criteria andRecNameNotBetween(String value1, String value2) {
            addCriterion("rec_name not between", value1, value2, "recName");
            return (Criteria) this;
        }

        public Criteria andRecTypeIsNull() {
            addCriterion("rec_type is null");
            return (Criteria) this;
        }

        public Criteria andRecTypeIsNotNull() {
            addCriterion("rec_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecTypeEqualTo(String value) {
            addCriterion("rec_type =", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeNotEqualTo(String value) {
            addCriterion("rec_type <>", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeGreaterThan(String value) {
            addCriterion("rec_type >", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rec_type >=", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeLessThan(String value) {
            addCriterion("rec_type <", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeLessThanOrEqualTo(String value) {
            addCriterion("rec_type <=", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeLike(String value) {
            addCriterion("rec_type like", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeNotLike(String value) {
            addCriterion("rec_type not like", value, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("rec_type in", values, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("rec_type not in", values, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeBetween(String value1, String value2) {
            addCriterion("rec_type between", value1, value2, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTypeNotBetween(String value1, String value2) {
            addCriterion("rec_type not between", value1, value2, "recType");
            return (Criteria) this;
        }

        public Criteria andRecTimeIsNull() {
            addCriterion("rec_time is null");
            return (Criteria) this;
        }

        public Criteria andRecTimeIsNotNull() {
            addCriterion("rec_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecTimeEqualTo(Date value) {
            addCriterion("rec_time =", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotEqualTo(Date value) {
            addCriterion("rec_time <>", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeGreaterThan(Date value) {
            addCriterion("rec_time >", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rec_time >=", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeLessThan(Date value) {
            addCriterion("rec_time <", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeLessThanOrEqualTo(Date value) {
            addCriterion("rec_time <=", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("rec_time in", values, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("rec_time not in", values, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeBetween(Date value1, Date value2) {
            addCriterion("rec_time between", value1, value2, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotBetween(Date value1, Date value2) {
            addCriterion("rec_time not between", value1, value2, "recTime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andHandlerLeveIsNull() {
            addCriterion("handler_leve is null");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveIsNotNull() {
            addCriterion("handler_leve is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveEqualTo(Integer value) {
            addCriterion("handler_leve =", value, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveNotEqualTo(Integer value) {
            addCriterion("handler_leve <>", value, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveGreaterThan(Integer value) {
            addCriterion("handler_leve >", value, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveGreaterThanOrEqualTo(Integer value) {
            addCriterion("handler_leve >=", value, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveLessThan(Integer value) {
            addCriterion("handler_leve <", value, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveLessThanOrEqualTo(Integer value) {
            addCriterion("handler_leve <=", value, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveIn(java.util.List<java.lang.Integer> values) {
            addCriterion("handler_leve in", values, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("handler_leve not in", values, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveBetween(Integer value1, Integer value2) {
            addCriterion("handler_leve between", value1, value2, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andHandlerLeveNotBetween(Integer value1, Integer value2) {
            addCriterion("handler_leve not between", value1, value2, "handlerLeve");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result_ is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result_ is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Boolean value) {
            addCriterion("result_ =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Boolean value) {
            addCriterion("result_ <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Boolean value) {
            addCriterion("result_ >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("result_ >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Boolean value) {
            addCriterion("result_ <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Boolean value) {
            addCriterion("result_ <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("result_ in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("result_ not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Boolean value1, Boolean value2) {
            addCriterion("result_ between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("result_ not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andWhoHandleIsNull() {
            addCriterion("who_handle is null");
            return (Criteria) this;
        }

        public Criteria andWhoHandleIsNotNull() {
            addCriterion("who_handle is not null");
            return (Criteria) this;
        }

        public Criteria andWhoHandleEqualTo(Boolean value) {
            addCriterion("who_handle =", value, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleNotEqualTo(Boolean value) {
            addCriterion("who_handle <>", value, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleGreaterThan(Boolean value) {
            addCriterion("who_handle >", value, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("who_handle >=", value, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleLessThan(Boolean value) {
            addCriterion("who_handle <", value, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleLessThanOrEqualTo(Boolean value) {
            addCriterion("who_handle <=", value, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("who_handle in", values, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("who_handle not in", values, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleBetween(Boolean value1, Boolean value2) {
            addCriterion("who_handle between", value1, value2, "whoHandle");
            return (Criteria) this;
        }

        public Criteria andWhoHandleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("who_handle not between", value1, value2, "whoHandle");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
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
    b_sendeeaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}