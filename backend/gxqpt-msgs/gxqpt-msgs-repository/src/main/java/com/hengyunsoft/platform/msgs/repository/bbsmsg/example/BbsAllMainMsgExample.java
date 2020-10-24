package com.hengyunsoft.platform.msgs.repository.bbsmsg.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BbsAllMainMsgExample extends com.hengyunsoft.db.example.BaseExample<BbsAllMainMsgExample.Criteria> implements Serializable {
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

        public Criteria andBizIdIsNull() {
            addCriterion("biz_id is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("biz_id is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(String value) {
            addCriterion("biz_id =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(String value) {
            addCriterion("biz_id <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(String value) {
            addCriterion("biz_id >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(String value) {
            addCriterion("biz_id >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(String value) {
            addCriterion("biz_id <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(String value) {
            addCriterion("biz_id <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLike(String value) {
            addCriterion("biz_id like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotLike(String value) {
            addCriterion("biz_id not like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(java.util.List<java.lang.String> values) {
            addCriterion("biz_id in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("biz_id not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(String value1, String value2) {
            addCriterion("biz_id between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(String value1, String value2) {
            addCriterion("biz_id not between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("biz_type is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(String value) {
            addCriterion("biz_type =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(String value) {
            addCriterion("biz_type <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(String value) {
            addCriterion("biz_type >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("biz_type >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(String value) {
            addCriterion("biz_type <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(String value) {
            addCriterion("biz_type <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLike(String value) {
            addCriterion("biz_type like", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotLike(String value) {
            addCriterion("biz_type not like", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("biz_type in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("biz_type not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(String value1, String value2) {
            addCriterion("biz_type between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(String value1, String value2) {
            addCriterion("biz_type not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andClientFlagIsNull() {
            addCriterion("client_flag is null");
            return (Criteria) this;
        }

        public Criteria andClientFlagIsNotNull() {
            addCriterion("client_flag is not null");
            return (Criteria) this;
        }

        public Criteria andClientFlagEqualTo(String value) {
            addCriterion("client_flag =", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotEqualTo(String value) {
            addCriterion("client_flag <>", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagGreaterThan(String value) {
            addCriterion("client_flag >", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagGreaterThanOrEqualTo(String value) {
            addCriterion("client_flag >=", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLessThan(String value) {
            addCriterion("client_flag <", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLessThanOrEqualTo(String value) {
            addCriterion("client_flag <=", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLike(String value) {
            addCriterion("client_flag like", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotLike(String value) {
            addCriterion("client_flag not like", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagIn(java.util.List<java.lang.String> values) {
            addCriterion("client_flag in", values, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotIn(java.util.List<java.lang.String> values) {
            addCriterion("client_flag not in", values, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagBetween(String value1, String value2) {
            addCriterion("client_flag between", value1, value2, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotBetween(String value1, String value2) {
            addCriterion("client_flag not between", value1, value2, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeIsNull() {
            addCriterion("brief_tpye is null");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeIsNotNull() {
            addCriterion("brief_tpye is not null");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeEqualTo(String value) {
            addCriterion("brief_tpye =", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeNotEqualTo(String value) {
            addCriterion("brief_tpye <>", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeGreaterThan(String value) {
            addCriterion("brief_tpye >", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeGreaterThanOrEqualTo(String value) {
            addCriterion("brief_tpye >=", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeLessThan(String value) {
            addCriterion("brief_tpye <", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeLessThanOrEqualTo(String value) {
            addCriterion("brief_tpye <=", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeLike(String value) {
            addCriterion("brief_tpye like", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeNotLike(String value) {
            addCriterion("brief_tpye not like", value, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeIn(java.util.List<java.lang.String> values) {
            addCriterion("brief_tpye in", values, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("brief_tpye not in", values, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeBetween(String value1, String value2) {
            addCriterion("brief_tpye between", value1, value2, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andBriefTpyeNotBetween(String value1, String value2) {
            addCriterion("brief_tpye not between", value1, value2, "briefTpye");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeIsNull() {
            addCriterion("detailed_type is null");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeIsNotNull() {
            addCriterion("detailed_type is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeEqualTo(String value) {
            addCriterion("detailed_type =", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeNotEqualTo(String value) {
            addCriterion("detailed_type <>", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeGreaterThan(String value) {
            addCriterion("detailed_type >", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_type >=", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeLessThan(String value) {
            addCriterion("detailed_type <", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeLessThanOrEqualTo(String value) {
            addCriterion("detailed_type <=", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeLike(String value) {
            addCriterion("detailed_type like", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeNotLike(String value) {
            addCriterion("detailed_type not like", value, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("detailed_type in", values, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("detailed_type not in", values, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeBetween(String value1, String value2) {
            addCriterion("detailed_type between", value1, value2, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeNotBetween(String value1, String value2) {
            addCriterion("detailed_type not between", value1, value2, "detailedType");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescIsNull() {
            addCriterion("detailed_type_desc is null");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescIsNotNull() {
            addCriterion("detailed_type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescEqualTo(String value) {
            addCriterion("detailed_type_desc =", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescNotEqualTo(String value) {
            addCriterion("detailed_type_desc <>", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescGreaterThan(String value) {
            addCriterion("detailed_type_desc >", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_type_desc >=", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescLessThan(String value) {
            addCriterion("detailed_type_desc <", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescLessThanOrEqualTo(String value) {
            addCriterion("detailed_type_desc <=", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescLike(String value) {
            addCriterion("detailed_type_desc like", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescNotLike(String value) {
            addCriterion("detailed_type_desc not like", value, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescIn(java.util.List<java.lang.String> values) {
            addCriterion("detailed_type_desc in", values, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("detailed_type_desc not in", values, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescBetween(String value1, String value2) {
            addCriterion("detailed_type_desc between", value1, value2, "detailedTypeDesc");
            return (Criteria) this;
        }

        public Criteria andDetailedTypeDescNotBetween(String value1, String value2) {
            addCriterion("detailed_type_desc not between", value1, value2, "detailedTypeDesc");
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

        public Criteria andSenderNameIsNull() {
            addCriterion("sender_name is null");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNotNull() {
            addCriterion("sender_name is not null");
            return (Criteria) this;
        }

        public Criteria andSenderNameEqualTo(String value) {
            addCriterion("sender_name =", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotEqualTo(String value) {
            addCriterion("sender_name <>", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThan(String value) {
            addCriterion("sender_name >", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("sender_name >=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThan(String value) {
            addCriterion("sender_name <", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThanOrEqualTo(String value) {
            addCriterion("sender_name <=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLike(String value) {
            addCriterion("sender_name like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotLike(String value) {
            addCriterion("sender_name not like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameIn(java.util.List<java.lang.String> values) {
            addCriterion("sender_name in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("sender_name not in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameBetween(String value1, String value2) {
            addCriterion("sender_name between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotBetween(String value1, String value2) {
            addCriterion("sender_name not between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlIsNull() {
            addCriterion("handler_url is null");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlIsNotNull() {
            addCriterion("handler_url is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlEqualTo(String value) {
            addCriterion("handler_url =", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlNotEqualTo(String value) {
            addCriterion("handler_url <>", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlGreaterThan(String value) {
            addCriterion("handler_url >", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("handler_url >=", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlLessThan(String value) {
            addCriterion("handler_url <", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlLessThanOrEqualTo(String value) {
            addCriterion("handler_url <=", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlLike(String value) {
            addCriterion("handler_url like", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlNotLike(String value) {
            addCriterion("handler_url not like", value, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("handler_url in", values, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("handler_url not in", values, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlBetween(String value1, String value2) {
            addCriterion("handler_url between", value1, value2, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerUrlNotBetween(String value1, String value2) {
            addCriterion("handler_url not between", value1, value2, "handlerUrl");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsIsNull() {
            addCriterion("handler_params is null");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsIsNotNull() {
            addCriterion("handler_params is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsEqualTo(String value) {
            addCriterion("handler_params =", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsNotEqualTo(String value) {
            addCriterion("handler_params <>", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsGreaterThan(String value) {
            addCriterion("handler_params >", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsGreaterThanOrEqualTo(String value) {
            addCriterion("handler_params >=", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsLessThan(String value) {
            addCriterion("handler_params <", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsLessThanOrEqualTo(String value) {
            addCriterion("handler_params <=", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsLike(String value) {
            addCriterion("handler_params like", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsNotLike(String value) {
            addCriterion("handler_params not like", value, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsIn(java.util.List<java.lang.String> values) {
            addCriterion("handler_params in", values, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsNotIn(java.util.List<java.lang.String> values) {
            addCriterion("handler_params not in", values, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsBetween(String value1, String value2) {
            addCriterion("handler_params between", value1, value2, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andHandlerParamsNotBetween(String value1, String value2) {
            addCriterion("handler_params not between", value1, value2, "handlerParams");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsIsNull() {
            addCriterion("single_handle_is is null");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsIsNotNull() {
            addCriterion("single_handle_is is not null");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsEqualTo(Boolean value) {
            addCriterion("single_handle_is =", value, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsNotEqualTo(Boolean value) {
            addCriterion("single_handle_is <>", value, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsGreaterThan(Boolean value) {
            addCriterion("single_handle_is >", value, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("single_handle_is >=", value, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsLessThan(Boolean value) {
            addCriterion("single_handle_is <", value, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsLessThanOrEqualTo(Boolean value) {
            addCriterion("single_handle_is <=", value, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("single_handle_is in", values, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("single_handle_is not in", values, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsBetween(Boolean value1, Boolean value2) {
            addCriterion("single_handle_is between", value1, value2, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andSingleHandleIsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("single_handle_is not between", value1, value2, "singleHandleIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsIsNull() {
            addCriterion("handler_need_is is null");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsIsNotNull() {
            addCriterion("handler_need_is is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsEqualTo(Boolean value) {
            addCriterion("handler_need_is =", value, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsNotEqualTo(Boolean value) {
            addCriterion("handler_need_is <>", value, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsGreaterThan(Boolean value) {
            addCriterion("handler_need_is >", value, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("handler_need_is >=", value, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsLessThan(Boolean value) {
            addCriterion("handler_need_is <", value, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsLessThanOrEqualTo(Boolean value) {
            addCriterion("handler_need_is <=", value, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("handler_need_is in", values, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("handler_need_is not in", values, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsBetween(Boolean value1, Boolean value2) {
            addCriterion("handler_need_is between", value1, value2, "handlerNeedIs");
            return (Criteria) this;
        }

        public Criteria andHandlerNeedIsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("handler_need_is not between", value1, value2, "handlerNeedIs");
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

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(java.util.List<java.lang.String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
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
    }

    /**
    b_bbs_all_main_msgaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}