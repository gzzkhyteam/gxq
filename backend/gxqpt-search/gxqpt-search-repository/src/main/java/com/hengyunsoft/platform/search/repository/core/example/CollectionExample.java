package com.hengyunsoft.platform.search.repository.core.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionExample extends com.hengyunsoft.db.example.BaseExample<CollectionExample.Criteria> implements Serializable {
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

        public Criteria andCollectionNameIsNull() {
            addCriterion("collection_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIsNotNull() {
            addCriterion("collection_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionNameEqualTo(String value) {
            addCriterion("collection_name =", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotEqualTo(String value) {
            addCriterion("collection_name <>", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameGreaterThan(String value) {
            addCriterion("collection_name >", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("collection_name >=", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLessThan(String value) {
            addCriterion("collection_name <", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLessThanOrEqualTo(String value) {
            addCriterion("collection_name <=", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameLike(String value) {
            addCriterion("collection_name like", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotLike(String value) {
            addCriterion("collection_name not like", value, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameIn(java.util.List<java.lang.String> values) {
            addCriterion("collection_name in", values, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("collection_name not in", values, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameBetween(String value1, String value2) {
            addCriterion("collection_name between", value1, value2, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionNameNotBetween(String value1, String value2) {
            addCriterion("collection_name not between", value1, value2, "collectionName");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeIsNull() {
            addCriterion("collection_code is null");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeIsNotNull() {
            addCriterion("collection_code is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeEqualTo(String value) {
            addCriterion("collection_code =", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotEqualTo(String value) {
            addCriterion("collection_code <>", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeGreaterThan(String value) {
            addCriterion("collection_code >", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("collection_code >=", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeLessThan(String value) {
            addCriterion("collection_code <", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeLessThanOrEqualTo(String value) {
            addCriterion("collection_code <=", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeLike(String value) {
            addCriterion("collection_code like", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotLike(String value) {
            addCriterion("collection_code not like", value, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("collection_code in", values, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("collection_code not in", values, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeBetween(String value1, String value2) {
            addCriterion("collection_code between", value1, value2, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCollectionCodeNotBetween(String value1, String value2) {
            addCriterion("collection_code not between", value1, value2, "collectionCode");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdIsNull() {
            addCriterion("create_app_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdIsNotNull() {
            addCriterion("create_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdEqualTo(String value) {
            addCriterion("create_app_id =", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdNotEqualTo(String value) {
            addCriterion("create_app_id <>", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdGreaterThan(String value) {
            addCriterion("create_app_id >", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_app_id >=", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdLessThan(String value) {
            addCriterion("create_app_id <", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdLessThanOrEqualTo(String value) {
            addCriterion("create_app_id <=", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdLike(String value) {
            addCriterion("create_app_id like", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdNotLike(String value) {
            addCriterion("create_app_id not like", value, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdIn(java.util.List<java.lang.String> values) {
            addCriterion("create_app_id in", values, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_app_id not in", values, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdBetween(String value1, String value2) {
            addCriterion("create_app_id between", value1, value2, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateAppIdNotBetween(String value1, String value2) {
            addCriterion("create_app_id not between", value1, value2, "createAppId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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
    c_collectionaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}