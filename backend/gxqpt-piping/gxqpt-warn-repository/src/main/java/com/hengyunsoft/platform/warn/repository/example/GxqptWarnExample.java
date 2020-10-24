package com.hengyunsoft.platform.warn.repository.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GxqptWarnExample extends com.hengyunsoft.db.example.BaseExample<GxqptWarnExample.Criteria> implements Serializable {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(java.util.List<java.lang.String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Long value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Long value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Long value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Long value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Long value1, Long value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(java.util.List<java.lang.String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(java.util.List<java.lang.Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andWarntimeIsNull() {
            addCriterion("warntime is null");
            return (Criteria) this;
        }

        public Criteria andWarntimeIsNotNull() {
            addCriterion("warntime is not null");
            return (Criteria) this;
        }

        public Criteria andWarntimeEqualTo(Date value) {
            addCriterion("warntime =", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeNotEqualTo(Date value) {
            addCriterion("warntime <>", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeGreaterThan(Date value) {
            addCriterion("warntime >", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warntime >=", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeLessThan(Date value) {
            addCriterion("warntime <", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeLessThanOrEqualTo(Date value) {
            addCriterion("warntime <=", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeIn(java.util.List<java.util.Date> values) {
            addCriterion("warntime in", values, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("warntime not in", values, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeBetween(Date value1, Date value2) {
            addCriterion("warntime between", value1, value2, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeNotBetween(Date value1, Date value2) {
            addCriterion("warntime not between", value1, value2, "warntime");
            return (Criteria) this;
        }

        public Criteria andHanTimeIsNull() {
            addCriterion("han_time is null");
            return (Criteria) this;
        }

        public Criteria andHanTimeIsNotNull() {
            addCriterion("han_time is not null");
            return (Criteria) this;
        }

        public Criteria andHanTimeEqualTo(Date value) {
            addCriterion("han_time =", value, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeNotEqualTo(Date value) {
            addCriterion("han_time <>", value, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeGreaterThan(Date value) {
            addCriterion("han_time >", value, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("han_time >=", value, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeLessThan(Date value) {
            addCriterion("han_time <", value, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeLessThanOrEqualTo(Date value) {
            addCriterion("han_time <=", value, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("han_time in", values, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("han_time not in", values, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeBetween(Date value1, Date value2) {
            addCriterion("han_time between", value1, value2, "hanTime");
            return (Criteria) this;
        }

        public Criteria andHanTimeNotBetween(Date value1, Date value2) {
            addCriterion("han_time not between", value1, value2, "hanTime");
            return (Criteria) this;
        }

        public Criteria andIsHandleIsNull() {
            addCriterion("is_handle is null");
            return (Criteria) this;
        }

        public Criteria andIsHandleIsNotNull() {
            addCriterion("is_handle is not null");
            return (Criteria) this;
        }

        public Criteria andIsHandleEqualTo(Boolean value) {
            addCriterion("is_handle =", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleNotEqualTo(Boolean value) {
            addCriterion("is_handle <>", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleGreaterThan(Boolean value) {
            addCriterion("is_handle >", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_handle >=", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleLessThan(Boolean value) {
            addCriterion("is_handle <", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleLessThanOrEqualTo(Boolean value) {
            addCriterion("is_handle <=", value, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("is_handle in", values, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("is_handle not in", values, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleBetween(Boolean value1, Boolean value2) {
            addCriterion("is_handle between", value1, value2, "isHandle");
            return (Criteria) this;
        }

        public Criteria andIsHandleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_handle not between", value1, value2, "isHandle");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNull() {
            addCriterion("callback_url is null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNotNull() {
            addCriterion("callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlEqualTo(String value) {
            addCriterion("callback_url =", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotEqualTo(String value) {
            addCriterion("callback_url <>", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThan(String value) {
            addCriterion("callback_url >", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("callback_url >=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThan(String value) {
            addCriterion("callback_url <", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("callback_url <=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLike(String value) {
            addCriterion("callback_url like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotLike(String value) {
            addCriterion("callback_url not like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("callback_url in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("callback_url not in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlBetween(String value1, String value2) {
            addCriterion("callback_url between", value1, value2, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("callback_url not between", value1, value2, "callbackUrl");
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

        public Criteria andConfirmCostTimeIsNull() {
            addCriterion("confirm_cost_time is null");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeIsNotNull() {
            addCriterion("confirm_cost_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeEqualTo(String value) {
            addCriterion("confirm_cost_time =", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeNotEqualTo(String value) {
            addCriterion("confirm_cost_time <>", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeGreaterThan(String value) {
            addCriterion("confirm_cost_time >", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_cost_time >=", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeLessThan(String value) {
            addCriterion("confirm_cost_time <", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeLessThanOrEqualTo(String value) {
            addCriterion("confirm_cost_time <=", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeLike(String value) {
            addCriterion("confirm_cost_time like", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeNotLike(String value) {
            addCriterion("confirm_cost_time not like", value, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("confirm_cost_time in", values, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("confirm_cost_time not in", values, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeBetween(String value1, String value2) {
            addCriterion("confirm_cost_time between", value1, value2, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andConfirmCostTimeNotBetween(String value1, String value2) {
            addCriterion("confirm_cost_time not between", value1, value2, "confirmCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeIsNull() {
            addCriterion("handle_cost_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeIsNotNull() {
            addCriterion("handle_cost_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeEqualTo(String value) {
            addCriterion("handle_cost_time =", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeNotEqualTo(String value) {
            addCriterion("handle_cost_time <>", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeGreaterThan(String value) {
            addCriterion("handle_cost_time >", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeGreaterThanOrEqualTo(String value) {
            addCriterion("handle_cost_time >=", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeLessThan(String value) {
            addCriterion("handle_cost_time <", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeLessThanOrEqualTo(String value) {
            addCriterion("handle_cost_time <=", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeLike(String value) {
            addCriterion("handle_cost_time like", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeNotLike(String value) {
            addCriterion("handle_cost_time not like", value, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("handle_cost_time in", values, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("handle_cost_time not in", values, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeBetween(String value1, String value2) {
            addCriterion("handle_cost_time between", value1, value2, "handleCostTime");
            return (Criteria) this;
        }

        public Criteria andHandleCostTimeNotBetween(String value1, String value2) {
            addCriterion("handle_cost_time not between", value1, value2, "handleCostTime");
            return (Criteria) this;
        }
    }

    /**
    b_warnaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}