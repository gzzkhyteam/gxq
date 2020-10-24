package com.hengyunsoft.platform.admin.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleExample extends com.hengyunsoft.db.example.BaseExample<RoleExample.Criteria> implements Serializable {
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

        public Criteria andNameIsNull() {
            addCriterion("name_ is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name_ is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name_ =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name_ <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name_ >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name_ >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name_ <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name_ <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name_ like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name_ not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(java.util.List<java.lang.String> values) {
            addCriterion("name_ in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("name_ not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name_ between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name_ not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code_ is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code_ is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code_ =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code_ <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code_ >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code_ >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code_ <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code_ <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code_ like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code_ not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("code_ in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("code_ not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code_ between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code_ not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc_ is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc_ is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc_ =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc_ <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc_ >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc_ >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc_ <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc_ <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc_ like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc_ not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(java.util.List<java.lang.String> values) {
            addCriterion("desc_ in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("desc_ not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc_ between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc_ not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Short> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPtRoleIsNull() {
            addCriterion("pt_role is null");
            return (Criteria) this;
        }

        public Criteria andPtRoleIsNotNull() {
            addCriterion("pt_role is not null");
            return (Criteria) this;
        }

        public Criteria andPtRoleEqualTo(Boolean value) {
            addCriterion("pt_role =", value, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleNotEqualTo(Boolean value) {
            addCriterion("pt_role <>", value, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleGreaterThan(Boolean value) {
            addCriterion("pt_role >", value, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pt_role >=", value, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleLessThan(Boolean value) {
            addCriterion("pt_role <", value, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleLessThanOrEqualTo(Boolean value) {
            addCriterion("pt_role <=", value, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("pt_role in", values, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("pt_role not in", values, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleBetween(Boolean value1, Boolean value2) {
            addCriterion("pt_role between", value1, value2, "ptRole");
            return (Criteria) this;
        }

        public Criteria andPtRoleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pt_role not between", value1, value2, "ptRole");
            return (Criteria) this;
        }

        public Criteria andReadonlyIsNull() {
            addCriterion("readonly_ is null");
            return (Criteria) this;
        }

        public Criteria andReadonlyIsNotNull() {
            addCriterion("readonly_ is not null");
            return (Criteria) this;
        }

        public Criteria andReadonlyEqualTo(Boolean value) {
            addCriterion("readonly_ =", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotEqualTo(Boolean value) {
            addCriterion("readonly_ <>", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyGreaterThan(Boolean value) {
            addCriterion("readonly_ >", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("readonly_ >=", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyLessThan(Boolean value) {
            addCriterion("readonly_ <", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyLessThanOrEqualTo(Boolean value) {
            addCriterion("readonly_ <=", value, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("readonly_ in", values, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("readonly_ not in", values, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyBetween(Boolean value1, Boolean value2) {
            addCriterion("readonly_ between", value1, value2, "readonly");
            return (Criteria) this;
        }

        public Criteria andReadonlyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("readonly_ not between", value1, value2, "readonly");
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

        public Criteria andBizFlagIsNull() {
            addCriterion("biz_flag is null");
            return (Criteria) this;
        }

        public Criteria andBizFlagIsNotNull() {
            addCriterion("biz_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBizFlagEqualTo(String value) {
            addCriterion("biz_flag =", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagNotEqualTo(String value) {
            addCriterion("biz_flag <>", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagGreaterThan(String value) {
            addCriterion("biz_flag >", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagGreaterThanOrEqualTo(String value) {
            addCriterion("biz_flag >=", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagLessThan(String value) {
            addCriterion("biz_flag <", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagLessThanOrEqualTo(String value) {
            addCriterion("biz_flag <=", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagLike(String value) {
            addCriterion("biz_flag like", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagNotLike(String value) {
            addCriterion("biz_flag not like", value, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagIn(java.util.List<java.lang.String> values) {
            addCriterion("biz_flag in", values, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagNotIn(java.util.List<java.lang.String> values) {
            addCriterion("biz_flag not in", values, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagBetween(String value1, String value2) {
            addCriterion("biz_flag between", value1, value2, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andBizFlagNotBetween(String value1, String value2) {
            addCriterion("biz_flag not between", value1, value2, "bizFlag");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsIsNull() {
            addCriterion("auth_manage_is is null");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsIsNotNull() {
            addCriterion("auth_manage_is is not null");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsEqualTo(Boolean value) {
            addCriterion("auth_manage_is =", value, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsNotEqualTo(Boolean value) {
            addCriterion("auth_manage_is <>", value, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsGreaterThan(Boolean value) {
            addCriterion("auth_manage_is >", value, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("auth_manage_is >=", value, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsLessThan(Boolean value) {
            addCriterion("auth_manage_is <", value, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsLessThanOrEqualTo(Boolean value) {
            addCriterion("auth_manage_is <=", value, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("auth_manage_is in", values, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("auth_manage_is not in", values, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsBetween(Boolean value1, Boolean value2) {
            addCriterion("auth_manage_is between", value1, value2, "authManageIs");
            return (Criteria) this;
        }

        public Criteria andAuthManageIsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("auth_manage_is not between", value1, value2, "authManageIs");
            return (Criteria) this;
        }
    }

    /**
    c_roleaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}