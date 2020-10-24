package com.hengyunsoft.platform.developer.repository.service.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ServiceModuleExample extends com.hengyunsoft.db.example.BaseExample<ServiceModuleExample.Criteria> implements Serializable {
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

        public Criteria andLogoIsNull() {
            addCriterion("logo_ is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo_ is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo_ =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo_ <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo_ >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo_ >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo_ <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo_ <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo_ like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo_ not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(java.util.List<java.lang.String> values) {
            addCriterion("logo_ in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(java.util.List<java.lang.String> values) {
            addCriterion("logo_ not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo_ between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo_ not between", value1, value2, "logo");
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

        public Criteria andEmailIsNull() {
            addCriterion("email_ is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email_ is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email_ =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email_ <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email_ >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email_ >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email_ <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email_ <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email_ like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email_ not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(java.util.List<java.lang.String> values) {
            addCriterion("email_ in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(java.util.List<java.lang.String> values) {
            addCriterion("email_ not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email_ between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email_ not between", value1, value2, "email");
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

        public Criteria andModuleTypeIsNull() {
            addCriterion("module_type is null");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIsNotNull() {
            addCriterion("module_type is not null");
            return (Criteria) this;
        }

        public Criteria andModuleTypeEqualTo(String value) {
            addCriterion("module_type =", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotEqualTo(String value) {
            addCriterion("module_type <>", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeGreaterThan(String value) {
            addCriterion("module_type >", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("module_type >=", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeLessThan(String value) {
            addCriterion("module_type <", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeLessThanOrEqualTo(String value) {
            addCriterion("module_type <=", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeLike(String value) {
            addCriterion("module_type like", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotLike(String value) {
            addCriterion("module_type not like", value, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("module_type in", values, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("module_type not in", values, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeBetween(String value1, String value2) {
            addCriterion("module_type between", value1, value2, "moduleType");
            return (Criteria) this;
        }

        public Criteria andModuleTypeNotBetween(String value1, String value2) {
            addCriterion("module_type not between", value1, value2, "moduleType");
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

        public Criteria andPublicIsIsNull() {
            addCriterion("public_is is null");
            return (Criteria) this;
        }

        public Criteria andPublicIsIsNotNull() {
            addCriterion("public_is is not null");
            return (Criteria) this;
        }

        public Criteria andPublicIsEqualTo(Boolean value) {
            addCriterion("public_is =", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsNotEqualTo(Boolean value) {
            addCriterion("public_is <>", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsGreaterThan(Boolean value) {
            addCriterion("public_is >", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("public_is >=", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsLessThan(Boolean value) {
            addCriterion("public_is <", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsLessThanOrEqualTo(Boolean value) {
            addCriterion("public_is <=", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("public_is in", values, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("public_is not in", values, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsBetween(Boolean value1, Boolean value2) {
            addCriterion("public_is between", value1, value2, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("public_is not between", value1, value2, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicLookIsNull() {
            addCriterion("public_look is null");
            return (Criteria) this;
        }

        public Criteria andPublicLookIsNotNull() {
            addCriterion("public_look is not null");
            return (Criteria) this;
        }

        public Criteria andPublicLookEqualTo(Boolean value) {
            addCriterion("public_look =", value, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookNotEqualTo(Boolean value) {
            addCriterion("public_look <>", value, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookGreaterThan(Boolean value) {
            addCriterion("public_look >", value, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookGreaterThanOrEqualTo(Boolean value) {
            addCriterion("public_look >=", value, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookLessThan(Boolean value) {
            addCriterion("public_look <", value, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookLessThanOrEqualTo(Boolean value) {
            addCriterion("public_look <=", value, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("public_look in", values, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("public_look not in", values, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookBetween(Boolean value1, Boolean value2) {
            addCriterion("public_look between", value1, value2, "publicLook");
            return (Criteria) this;
        }

        public Criteria andPublicLookNotBetween(Boolean value1, Boolean value2) {
            addCriterion("public_look not between", value1, value2, "publicLook");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlIsNull() {
            addCriterion("api_sync_url is null");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlIsNotNull() {
            addCriterion("api_sync_url is not null");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlEqualTo(String value) {
            addCriterion("api_sync_url =", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlNotEqualTo(String value) {
            addCriterion("api_sync_url <>", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlGreaterThan(String value) {
            addCriterion("api_sync_url >", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("api_sync_url >=", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlLessThan(String value) {
            addCriterion("api_sync_url <", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlLessThanOrEqualTo(String value) {
            addCriterion("api_sync_url <=", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlLike(String value) {
            addCriterion("api_sync_url like", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlNotLike(String value) {
            addCriterion("api_sync_url not like", value, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("api_sync_url in", values, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("api_sync_url not in", values, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlBetween(String value1, String value2) {
            addCriterion("api_sync_url between", value1, value2, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andApiSyncUrlNotBetween(String value1, String value2) {
            addCriterion("api_sync_url not between", value1, value2, "apiSyncUrl");
            return (Criteria) this;
        }

        public Criteria andResourceNumIsNull() {
            addCriterion("resource_num is null");
            return (Criteria) this;
        }

        public Criteria andResourceNumIsNotNull() {
            addCriterion("resource_num is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNumEqualTo(Integer value) {
            addCriterion("resource_num =", value, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumNotEqualTo(Integer value) {
            addCriterion("resource_num <>", value, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumGreaterThan(Integer value) {
            addCriterion("resource_num >", value, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_num >=", value, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumLessThan(Integer value) {
            addCriterion("resource_num <", value, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumLessThanOrEqualTo(Integer value) {
            addCriterion("resource_num <=", value, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("resource_num in", values, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("resource_num not in", values, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumBetween(Integer value1, Integer value2) {
            addCriterion("resource_num between", value1, value2, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andResourceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_num not between", value1, value2, "resourceNum");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(Date value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(Date value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(Date value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(Date value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(Date value1, Date value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleIsNull() {
            addCriterion("advice_module is null");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleIsNotNull() {
            addCriterion("advice_module is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleEqualTo(Long value) {
            addCriterion("advice_module =", value, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleNotEqualTo(Long value) {
            addCriterion("advice_module <>", value, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleGreaterThan(Long value) {
            addCriterion("advice_module >", value, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleGreaterThanOrEqualTo(Long value) {
            addCriterion("advice_module >=", value, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleLessThan(Long value) {
            addCriterion("advice_module <", value, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleLessThanOrEqualTo(Long value) {
            addCriterion("advice_module <=", value, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleIn(java.util.List<java.lang.Long> values) {
            addCriterion("advice_module in", values, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("advice_module not in", values, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleBetween(Long value1, Long value2) {
            addCriterion("advice_module between", value1, value2, "adviceModule");
            return (Criteria) this;
        }

        public Criteria andAdviceModuleNotBetween(Long value1, Long value2) {
            addCriterion("advice_module not between", value1, value2, "adviceModule");
            return (Criteria) this;
        }
        
        public Criteria andReduceTimeIsNull() {
            addCriterion("reduce_time is null");
            return (Criteria) this;
        }

        public Criteria andReduceTimeIsNotNull() {
            addCriterion("reduce_time is not null");
            return (Criteria) this;
        }

        public Criteria andReduceTimeEqualTo(Double value) {
            addCriterion("reduce_time =", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotEqualTo(Double value) {
            addCriterion("reduce_time <>", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeGreaterThan(Double value) {
            addCriterion("reduce_time >", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("reduce_time >=", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeLessThan(Double value) {
            addCriterion("reduce_time <", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeLessThanOrEqualTo(Double value) {
            addCriterion("reduce_time <=", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeIn(java.util.List<java.lang.Double> values) {
            addCriterion("reduce_time in", values, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("reduce_time not in", values, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeBetween(Double value1, Double value2) {
            addCriterion("reduce_time between", value1, value2, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotBetween(Double value1, Double value2) {
            addCriterion("reduce_time not between", value1, value2, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceCostIsNull() {
            addCriterion("reduce_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceCostIsNotNull() {
            addCriterion("reduce_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceCostEqualTo(Integer value) {
            addCriterion("reduce_cost =", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotEqualTo(Integer value) {
            addCriterion("reduce_cost <>", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostGreaterThan(Integer value) {
            addCriterion("reduce_cost >", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_cost >=", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostLessThan(Integer value) {
            addCriterion("reduce_cost <", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_cost <=", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_cost in", values, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_cost not in", values, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_cost between", value1, value2, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_cost not between", value1, value2, "reduceCost");
            return (Criteria) this;
        }
    }

    /**
    c_service_moduleaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}