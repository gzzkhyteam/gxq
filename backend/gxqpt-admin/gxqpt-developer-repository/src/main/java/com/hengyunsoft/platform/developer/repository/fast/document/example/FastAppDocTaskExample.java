package com.hengyunsoft.platform.developer.repository.fast.document.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastAppDocTaskExample extends com.hengyunsoft.db.example.BaseExample<FastAppDocTaskExample.Criteria> implements Serializable {
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

        public Criteria andCurrentUserTypeIsNull() {
            addCriterion("current_user_type is null");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeIsNotNull() {
            addCriterion("current_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeEqualTo(String value) {
            addCriterion("current_user_type =", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeNotEqualTo(String value) {
            addCriterion("current_user_type <>", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeGreaterThan(String value) {
            addCriterion("current_user_type >", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("current_user_type >=", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeLessThan(String value) {
            addCriterion("current_user_type <", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeLessThanOrEqualTo(String value) {
            addCriterion("current_user_type <=", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeLike(String value) {
            addCriterion("current_user_type like", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeNotLike(String value) {
            addCriterion("current_user_type not like", value, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("current_user_type in", values, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("current_user_type not in", values, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeBetween(String value1, String value2) {
            addCriterion("current_user_type between", value1, value2, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andCurrentUserTypeNotBetween(String value1, String value2) {
            addCriterion("current_user_type not between", value1, value2, "currentUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeIsNull() {
            addCriterion("next_user_type is null");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeIsNotNull() {
            addCriterion("next_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeEqualTo(String value) {
            addCriterion("next_user_type =", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeNotEqualTo(String value) {
            addCriterion("next_user_type <>", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeGreaterThan(String value) {
            addCriterion("next_user_type >", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("next_user_type >=", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeLessThan(String value) {
            addCriterion("next_user_type <", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeLessThanOrEqualTo(String value) {
            addCriterion("next_user_type <=", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeLike(String value) {
            addCriterion("next_user_type like", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeNotLike(String value) {
            addCriterion("next_user_type not like", value, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("next_user_type in", values, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("next_user_type not in", values, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeBetween(String value1, String value2) {
            addCriterion("next_user_type between", value1, value2, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserTypeNotBetween(String value1, String value2) {
            addCriterion("next_user_type not between", value1, value2, "nextUserType");
            return (Criteria) this;
        }

        public Criteria andNextUserIdIsNull() {
            addCriterion("next_user_id is null");
            return (Criteria) this;
        }

        public Criteria andNextUserIdIsNotNull() {
            addCriterion("next_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextUserIdEqualTo(Long value) {
            addCriterion("next_user_id =", value, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdNotEqualTo(Long value) {
            addCriterion("next_user_id <>", value, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdGreaterThan(Long value) {
            addCriterion("next_user_id >", value, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("next_user_id >=", value, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdLessThan(Long value) {
            addCriterion("next_user_id <", value, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdLessThanOrEqualTo(Long value) {
            addCriterion("next_user_id <=", value, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("next_user_id in", values, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("next_user_id not in", values, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdBetween(Long value1, Long value2) {
            addCriterion("next_user_id between", value1, value2, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andNextUserIdNotBetween(Long value1, Long value2) {
            addCriterion("next_user_id not between", value1, value2, "nextUserId");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNull() {
            addCriterion("handle_status is null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNotNull() {
            addCriterion("handle_status is not null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusEqualTo(String value) {
            addCriterion("handle_status =", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotEqualTo(String value) {
            addCriterion("handle_status <>", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThan(String value) {
            addCriterion("handle_status >", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("handle_status >=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThan(String value) {
            addCriterion("handle_status <", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThanOrEqualTo(String value) {
            addCriterion("handle_status <=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLike(String value) {
            addCriterion("handle_status like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotLike(String value) {
            addCriterion("handle_status not like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIn(java.util.List<java.lang.String> values) {
            addCriterion("handle_status in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotIn(java.util.List<java.lang.String> values) {
            addCriterion("handle_status not in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusBetween(String value1, String value2) {
            addCriterion("handle_status between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotBetween(String value1, String value2) {
            addCriterion("handle_status not between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNull() {
            addCriterion("link_status is null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNotNull() {
            addCriterion("link_status is not null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusEqualTo(String value) {
            addCriterion("link_status =", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotEqualTo(String value) {
            addCriterion("link_status <>", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThan(String value) {
            addCriterion("link_status >", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("link_status >=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThan(String value) {
            addCriterion("link_status <", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThanOrEqualTo(String value) {
            addCriterion("link_status <=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLike(String value) {
            addCriterion("link_status like", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotLike(String value) {
            addCriterion("link_status not like", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIn(java.util.List<java.lang.String> values) {
            addCriterion("link_status in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotIn(java.util.List<java.lang.String> values) {
            addCriterion("link_status not in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusBetween(String value1, String value2) {
            addCriterion("link_status between", value1, value2, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotBetween(String value1, String value2) {
            addCriterion("link_status not between", value1, value2, "linkStatus");
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

        public Criteria andTargetIsNull() {
            addCriterion("target_ is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("target_ is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(String value) {
            addCriterion("target_ =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(String value) {
            addCriterion("target_ <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(String value) {
            addCriterion("target_ >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(String value) {
            addCriterion("target_ >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(String value) {
            addCriterion("target_ <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(String value) {
            addCriterion("target_ <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLike(String value) {
            addCriterion("target_ like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotLike(String value) {
            addCriterion("target_ not like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(java.util.List<java.lang.String> values) {
            addCriterion("target_ in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(java.util.List<java.lang.String> values) {
            addCriterion("target_ not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(String value1, String value2) {
            addCriterion("target_ between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(String value1, String value2) {
            addCriterion("target_ not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank_ is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank_ is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("rank_ =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("rank_ <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("rank_ >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("rank_ >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("rank_ <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("rank_ <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("rank_ like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("rank_ not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(java.util.List<java.lang.String> values) {
            addCriterion("rank_ in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(java.util.List<java.lang.String> values) {
            addCriterion("rank_ not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("rank_ between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("rank_ not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title_ is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title_ is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title_ =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title_ <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title_ >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title_ >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title_ <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title_ <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title_ like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title_ not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(java.util.List<java.lang.String> values) {
            addCriterion("title_ in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("title_ not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title_ between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title_ not between", value1, value2, "title");
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

        public Criteria andContentIsNull() {
            addCriterion("content_ is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content_ is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content_ =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content_ <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content_ >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content_ >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content_ <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content_ <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content_ like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content_ not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(java.util.List<java.lang.String> values) {
            addCriterion("content_ in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("content_ not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content_ between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content_ not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andDocUnitIsNull() {
            addCriterion("doc_unit is null");
            return (Criteria) this;
        }

        public Criteria andDocUnitIsNotNull() {
            addCriterion("doc_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDocUnitEqualTo(String value) {
            addCriterion("doc_unit =", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitNotEqualTo(String value) {
            addCriterion("doc_unit <>", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitGreaterThan(String value) {
            addCriterion("doc_unit >", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitGreaterThanOrEqualTo(String value) {
            addCriterion("doc_unit >=", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitLessThan(String value) {
            addCriterion("doc_unit <", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitLessThanOrEqualTo(String value) {
            addCriterion("doc_unit <=", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitLike(String value) {
            addCriterion("doc_unit like", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitNotLike(String value) {
            addCriterion("doc_unit not like", value, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_unit in", values, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitNotIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_unit not in", values, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitBetween(String value1, String value2) {
            addCriterion("doc_unit between", value1, value2, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocUnitNotBetween(String value1, String value2) {
            addCriterion("doc_unit not between", value1, value2, "docUnit");
            return (Criteria) this;
        }

        public Criteria andDocNumIsNull() {
            addCriterion("doc_num is null");
            return (Criteria) this;
        }

        public Criteria andDocNumIsNotNull() {
            addCriterion("doc_num is not null");
            return (Criteria) this;
        }

        public Criteria andDocNumEqualTo(String value) {
            addCriterion("doc_num =", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotEqualTo(String value) {
            addCriterion("doc_num <>", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumGreaterThan(String value) {
            addCriterion("doc_num >", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumGreaterThanOrEqualTo(String value) {
            addCriterion("doc_num >=", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumLessThan(String value) {
            addCriterion("doc_num <", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumLessThanOrEqualTo(String value) {
            addCriterion("doc_num <=", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumLike(String value) {
            addCriterion("doc_num like", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotLike(String value) {
            addCriterion("doc_num not like", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_num in", values, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_num not in", values, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumBetween(String value1, String value2) {
            addCriterion("doc_num between", value1, value2, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotBetween(String value1, String value2) {
            addCriterion("doc_num not between", value1, value2, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocTimeIsNull() {
            addCriterion("doc_time is null");
            return (Criteria) this;
        }

        public Criteria andDocTimeIsNotNull() {
            addCriterion("doc_time is not null");
            return (Criteria) this;
        }

        public Criteria andDocTimeEqualTo(Date value) {
            addCriterion("doc_time =", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeNotEqualTo(Date value) {
            addCriterion("doc_time <>", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeGreaterThan(Date value) {
            addCriterion("doc_time >", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doc_time >=", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeLessThan(Date value) {
            addCriterion("doc_time <", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeLessThanOrEqualTo(Date value) {
            addCriterion("doc_time <=", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("doc_time in", values, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("doc_time not in", values, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeBetween(Date value1, Date value2) {
            addCriterion("doc_time between", value1, value2, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeNotBetween(Date value1, Date value2) {
            addCriterion("doc_time not between", value1, value2, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocCodeIsNull() {
            addCriterion("doc_code is null");
            return (Criteria) this;
        }

        public Criteria andDocCodeIsNotNull() {
            addCriterion("doc_code is not null");
            return (Criteria) this;
        }

        public Criteria andDocCodeEqualTo(String value) {
            addCriterion("doc_code =", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeNotEqualTo(String value) {
            addCriterion("doc_code <>", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeGreaterThan(String value) {
            addCriterion("doc_code >", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeGreaterThanOrEqualTo(String value) {
            addCriterion("doc_code >=", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeLessThan(String value) {
            addCriterion("doc_code <", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeLessThanOrEqualTo(String value) {
            addCriterion("doc_code <=", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeLike(String value) {
            addCriterion("doc_code like", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeNotLike(String value) {
            addCriterion("doc_code not like", value, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_code in", values, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_code not in", values, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeBetween(String value1, String value2) {
            addCriterion("doc_code between", value1, value2, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocCodeNotBetween(String value1, String value2) {
            addCriterion("doc_code not between", value1, value2, "docCode");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNull() {
            addCriterion("doc_type is null");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNotNull() {
            addCriterion("doc_type is not null");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("doc_type =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotEqualTo(String value) {
            addCriterion("doc_type <>", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThan(String value) {
            addCriterion("doc_type >", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThanOrEqualTo(String value) {
            addCriterion("doc_type >=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThan(String value) {
            addCriterion("doc_type <", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThanOrEqualTo(String value) {
            addCriterion("doc_type <=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLike(String value) {
            addCriterion("doc_type like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotLike(String value) {
            addCriterion("doc_type not like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_type in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("doc_type not in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeBetween(String value1, String value2) {
            addCriterion("doc_type between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotBetween(String value1, String value2) {
            addCriterion("doc_type not between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIsNull() {
            addCriterion("urgency_degree is null");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIsNotNull() {
            addCriterion("urgency_degree is not null");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeEqualTo(String value) {
            addCriterion("urgency_degree =", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotEqualTo(String value) {
            addCriterion("urgency_degree <>", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeGreaterThan(String value) {
            addCriterion("urgency_degree >", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("urgency_degree >=", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLessThan(String value) {
            addCriterion("urgency_degree <", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLessThanOrEqualTo(String value) {
            addCriterion("urgency_degree <=", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeLike(String value) {
            addCriterion("urgency_degree like", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotLike(String value) {
            addCriterion("urgency_degree not like", value, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeIn(java.util.List<java.lang.String> values) {
            addCriterion("urgency_degree in", values, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("urgency_degree not in", values, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeBetween(String value1, String value2) {
            addCriterion("urgency_degree between", value1, value2, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andUrgencyDegreeNotBetween(String value1, String value2) {
            addCriterion("urgency_degree not between", value1, value2, "urgencyDegree");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlIsNull() {
            addCriterion("attachment_url is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlIsNotNull() {
            addCriterion("attachment_url is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlEqualTo(String value) {
            addCriterion("attachment_url =", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotEqualTo(String value) {
            addCriterion("attachment_url <>", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlGreaterThan(String value) {
            addCriterion("attachment_url >", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_url >=", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlLessThan(String value) {
            addCriterion("attachment_url <", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlLessThanOrEqualTo(String value) {
            addCriterion("attachment_url <=", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlLike(String value) {
            addCriterion("attachment_url like", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotLike(String value) {
            addCriterion("attachment_url not like", value, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_url in", values, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_url not in", values, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlBetween(String value1, String value2) {
            addCriterion("attachment_url between", value1, value2, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentUrlNotBetween(String value1, String value2) {
            addCriterion("attachment_url not between", value1, value2, "attachmentUrl");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNull() {
            addCriterion("attachment_name is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNotNull() {
            addCriterion("attachment_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameEqualTo(String value) {
            addCriterion("attachment_name =", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotEqualTo(String value) {
            addCriterion("attachment_name <>", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThan(String value) {
            addCriterion("attachment_name >", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_name >=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThan(String value) {
            addCriterion("attachment_name <", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThanOrEqualTo(String value) {
            addCriterion("attachment_name <=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLike(String value) {
            addCriterion("attachment_name like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotLike(String value) {
            addCriterion("attachment_name not like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_name in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("attachment_name not in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameBetween(String value1, String value2) {
            addCriterion("attachment_name between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotBetween(String value1, String value2) {
            addCriterion("attachment_name not between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
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
    b_fast_app_doc_taskaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}