package com.hengyunsoft.platform.exchange.repository.set.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareDataSetDirElementExample extends com.hengyunsoft.db.example.BaseExample<ShareDataSetDirElementExample.Criteria> implements Serializable {
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

        public Criteria andSdIdIsNull() {
            addCriterion("sd_id is null");
            return (Criteria) this;
        }

        public Criteria andSdIdIsNotNull() {
            addCriterion("sd_id is not null");
            return (Criteria) this;
        }

        public Criteria andSdIdEqualTo(Long value) {
            addCriterion("sd_id =", value, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdNotEqualTo(Long value) {
            addCriterion("sd_id <>", value, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdGreaterThan(Long value) {
            addCriterion("sd_id >", value, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sd_id >=", value, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdLessThan(Long value) {
            addCriterion("sd_id <", value, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdLessThanOrEqualTo(Long value) {
            addCriterion("sd_id <=", value, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("sd_id in", values, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("sd_id not in", values, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdBetween(Long value1, Long value2) {
            addCriterion("sd_id between", value1, value2, "sdId");
            return (Criteria) this;
        }

        public Criteria andSdIdNotBetween(Long value1, Long value2) {
            addCriterion("sd_id not between", value1, value2, "sdId");
            return (Criteria) this;
        }

        public Criteria andSetIdIsNull() {
            addCriterion("set_id is null");
            return (Criteria) this;
        }

        public Criteria andSetIdIsNotNull() {
            addCriterion("set_id is not null");
            return (Criteria) this;
        }

        public Criteria andSetIdEqualTo(Long value) {
            addCriterion("set_id =", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotEqualTo(Long value) {
            addCriterion("set_id <>", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdGreaterThan(Long value) {
            addCriterion("set_id >", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("set_id >=", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdLessThan(Long value) {
            addCriterion("set_id <", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdLessThanOrEqualTo(Long value) {
            addCriterion("set_id <=", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("set_id in", values, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("set_id not in", values, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdBetween(Long value1, Long value2) {
            addCriterion("set_id between", value1, value2, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotBetween(Long value1, Long value2) {
            addCriterion("set_id not between", value1, value2, "setId");
            return (Criteria) this;
        }

        public Criteria andDirIdIsNull() {
            addCriterion("dir_id is null");
            return (Criteria) this;
        }

        public Criteria andDirIdIsNotNull() {
            addCriterion("dir_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirIdEqualTo(Long value) {
            addCriterion("dir_id =", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdNotEqualTo(Long value) {
            addCriterion("dir_id <>", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdGreaterThan(Long value) {
            addCriterion("dir_id >", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dir_id >=", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdLessThan(Long value) {
            addCriterion("dir_id <", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdLessThanOrEqualTo(Long value) {
            addCriterion("dir_id <=", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("dir_id in", values, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("dir_id not in", values, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdBetween(Long value1, Long value2) {
            addCriterion("dir_id between", value1, value2, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdNotBetween(Long value1, Long value2) {
            addCriterion("dir_id not between", value1, value2, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdIsNull() {
            addCriterion("dir_field_id is null");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdIsNotNull() {
            addCriterion("dir_field_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdEqualTo(Long value) {
            addCriterion("dir_field_id =", value, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdNotEqualTo(Long value) {
            addCriterion("dir_field_id <>", value, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdGreaterThan(Long value) {
            addCriterion("dir_field_id >", value, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dir_field_id >=", value, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdLessThan(Long value) {
            addCriterion("dir_field_id <", value, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdLessThanOrEqualTo(Long value) {
            addCriterion("dir_field_id <=", value, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("dir_field_id in", values, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("dir_field_id not in", values, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdBetween(Long value1, Long value2) {
            addCriterion("dir_field_id between", value1, value2, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldIdNotBetween(Long value1, Long value2) {
            addCriterion("dir_field_id not between", value1, value2, "dirFieldId");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeIsNull() {
            addCriterion("dir_field_code is null");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeIsNotNull() {
            addCriterion("dir_field_code is not null");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeEqualTo(String value) {
            addCriterion("dir_field_code =", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeNotEqualTo(String value) {
            addCriterion("dir_field_code <>", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeGreaterThan(String value) {
            addCriterion("dir_field_code >", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dir_field_code >=", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeLessThan(String value) {
            addCriterion("dir_field_code <", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeLessThanOrEqualTo(String value) {
            addCriterion("dir_field_code <=", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeLike(String value) {
            addCriterion("dir_field_code like", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeNotLike(String value) {
            addCriterion("dir_field_code not like", value, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_field_code in", values, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_field_code not in", values, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeBetween(String value1, String value2) {
            addCriterion("dir_field_code between", value1, value2, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldCodeNotBetween(String value1, String value2) {
            addCriterion("dir_field_code not between", value1, value2, "dirFieldCode");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameIsNull() {
            addCriterion("dir_field_name is null");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameIsNotNull() {
            addCriterion("dir_field_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameEqualTo(String value) {
            addCriterion("dir_field_name =", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameNotEqualTo(String value) {
            addCriterion("dir_field_name <>", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameGreaterThan(String value) {
            addCriterion("dir_field_name >", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("dir_field_name >=", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameLessThan(String value) {
            addCriterion("dir_field_name <", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameLessThanOrEqualTo(String value) {
            addCriterion("dir_field_name <=", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameLike(String value) {
            addCriterion("dir_field_name like", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameNotLike(String value) {
            addCriterion("dir_field_name not like", value, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_field_name in", values, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("dir_field_name not in", values, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameBetween(String value1, String value2) {
            addCriterion("dir_field_name between", value1, value2, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andDirFieldNameNotBetween(String value1, String value2) {
            addCriterion("dir_field_name not between", value1, value2, "dirFieldName");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeIsNull() {
            addCriterion("set_field_code is null");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeIsNotNull() {
            addCriterion("set_field_code is not null");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeEqualTo(String value) {
            addCriterion("set_field_code =", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeNotEqualTo(String value) {
            addCriterion("set_field_code <>", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeGreaterThan(String value) {
            addCriterion("set_field_code >", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeGreaterThanOrEqualTo(String value) {
            addCriterion("set_field_code >=", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeLessThan(String value) {
            addCriterion("set_field_code <", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeLessThanOrEqualTo(String value) {
            addCriterion("set_field_code <=", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeLike(String value) {
            addCriterion("set_field_code like", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeNotLike(String value) {
            addCriterion("set_field_code not like", value, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("set_field_code in", values, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("set_field_code not in", values, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeBetween(String value1, String value2) {
            addCriterion("set_field_code between", value1, value2, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andSetFieldCodeNotBetween(String value1, String value2) {
            addCriterion("set_field_code not between", value1, value2, "setFieldCode");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNull() {
            addCriterion("opt_type is null");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNotNull() {
            addCriterion("opt_type is not null");
            return (Criteria) this;
        }

        public Criteria andOptTypeEqualTo(Integer value) {
            addCriterion("opt_type =", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotEqualTo(Integer value) {
            addCriterion("opt_type <>", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThan(Integer value) {
            addCriterion("opt_type >", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("opt_type >=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThan(Integer value) {
            addCriterion("opt_type <", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThanOrEqualTo(Integer value) {
            addCriterion("opt_type <=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("opt_type in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("opt_type not in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeBetween(Integer value1, Integer value2) {
            addCriterion("opt_type between", value1, value2, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("opt_type not between", value1, value2, "optType");
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
    b_share_data_set_dir_elementaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}