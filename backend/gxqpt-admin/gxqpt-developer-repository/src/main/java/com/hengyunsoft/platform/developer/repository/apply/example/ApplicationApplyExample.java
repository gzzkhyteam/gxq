package com.hengyunsoft.platform.developer.repository.apply.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample.Criteria;

public class ApplicationApplyExample extends com.hengyunsoft.db.example.BaseExample<ApplicationApplyExample.Criteria> implements Serializable {
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

        public Criteria andAppSecretIsNull() {
            addCriterion("app_secret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("app_secret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("app_secret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("app_secret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_secret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("app_secret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("app_secret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("app_secret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("app_secret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(java.util.List<java.lang.String> values) {
            addCriterion("app_secret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(java.util.List<java.lang.String> values) {
            addCriterion("app_secret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("app_secret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("app_secret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andIndexUrlIsNull() {
            addCriterion("index_url is null");
            return (Criteria) this;
        }

        public Criteria andIndexUrlIsNotNull() {
            addCriterion("index_url is not null");
            return (Criteria) this;
        }

        public Criteria andIndexUrlEqualTo(String value) {
            addCriterion("index_url =", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotEqualTo(String value) {
            addCriterion("index_url <>", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlGreaterThan(String value) {
            addCriterion("index_url >", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlGreaterThanOrEqualTo(String value) {
            addCriterion("index_url >=", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlLessThan(String value) {
            addCriterion("index_url <", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlLessThanOrEqualTo(String value) {
            addCriterion("index_url <=", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlLike(String value) {
            addCriterion("index_url like", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotLike(String value) {
            addCriterion("index_url not like", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("index_url in", values, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("index_url not in", values, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlBetween(String value1, String value2) {
            addCriterion("index_url between", value1, value2, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotBetween(String value1, String value2) {
            addCriterion("index_url not between", value1, value2, "indexUrl");
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

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(java.util.List<java.lang.Integer> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Short value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Short value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Short value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Short value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Short value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(java.util.List<java.lang.Short> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Short value1, Short value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Short value1, Short value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type_ is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type_ is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type_ =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type_ <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type_ >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type_ >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type_ <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type_ <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type_ like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type_ not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("type_ in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("type_ not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type_ between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type_ not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("provider_ is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("provider_ is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(String value) {
            addCriterion("provider_ =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("provider_ <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("provider_ >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("provider_ >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("provider_ <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("provider_ <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("provider_ like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("provider_ not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(java.util.List<java.lang.String> values) {
            addCriterion("provider_ in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(java.util.List<java.lang.String> values) {
            addCriterion("provider_ not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("provider_ between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("provider_ not between", value1, value2, "provider");
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

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRandomStrIsNull() {
            addCriterion("random_str is null");
            return (Criteria) this;
        }

        public Criteria andRandomStrIsNotNull() {
            addCriterion("random_str is not null");
            return (Criteria) this;
        }

        public Criteria andRandomStrEqualTo(String value) {
            addCriterion("random_str =", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotEqualTo(String value) {
            addCriterion("random_str <>", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrGreaterThan(String value) {
            addCriterion("random_str >", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrGreaterThanOrEqualTo(String value) {
            addCriterion("random_str >=", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrLessThan(String value) {
            addCriterion("random_str <", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrLessThanOrEqualTo(String value) {
            addCriterion("random_str <=", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrLike(String value) {
            addCriterion("random_str like", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotLike(String value) {
            addCriterion("random_str not like", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrIn(java.util.List<java.lang.String> values) {
            addCriterion("random_str in", values, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotIn(java.util.List<java.lang.String> values) {
            addCriterion("random_str not in", values, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrBetween(String value1, String value2) {
            addCriterion("random_str between", value1, value2, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotBetween(String value1, String value2) {
            addCriterion("random_str not between", value1, value2, "randomStr");
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

        public Criteria andApplyStatusIsNull() {
            addCriterion("apply_status is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(Short value) {
            addCriterion("apply_status =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(Short value) {
            addCriterion("apply_status <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(Short value) {
            addCriterion("apply_status >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("apply_status >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(Short value) {
            addCriterion("apply_status <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(Short value) {
            addCriterion("apply_status <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(java.util.List<java.lang.Short> values) {
            addCriterion("apply_status in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("apply_status not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(Short value1, Short value2) {
            addCriterion("apply_status between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(Short value1, Short value2) {
            addCriterion("apply_status not between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNull() {
            addCriterion("apply_user is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNotNull() {
            addCriterion("apply_user is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserEqualTo(Long value) {
            addCriterion("apply_user =", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotEqualTo(Long value) {
            addCriterion("apply_user <>", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThan(Long value) {
            addCriterion("apply_user >", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_user >=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThan(Long value) {
            addCriterion("apply_user <", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThanOrEqualTo(Long value) {
            addCriterion("apply_user <=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_user in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_user not in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserBetween(Long value1, Long value2) {
            addCriterion("apply_user between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotBetween(Long value1, Long value2) {
            addCriterion("apply_user not between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNull() {
            addCriterion("apply_user_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIsNotNull() {
            addCriterion("apply_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameEqualTo(String value) {
            addCriterion("apply_user_name =", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotEqualTo(String value) {
            addCriterion("apply_user_name <>", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThan(String value) {
            addCriterion("apply_user_name >", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user_name >=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThan(String value) {
            addCriterion("apply_user_name <", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLessThanOrEqualTo(String value) {
            addCriterion("apply_user_name <=", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameLike(String value) {
            addCriterion("apply_user_name like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotLike(String value) {
            addCriterion("apply_user_name not like", value, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_user_name in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_user_name not in", values, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameBetween(String value1, String value2) {
            addCriterion("apply_user_name between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andApplyUserNameNotBetween(String value1, String value2) {
            addCriterion("apply_user_name not between", value1, value2, "applyUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNull() {
            addCriterion("audit_user is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNotNull() {
            addCriterion("audit_user is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserEqualTo(Long value) {
            addCriterion("audit_user =", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotEqualTo(Long value) {
            addCriterion("audit_user <>", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThan(Long value) {
            addCriterion("audit_user >", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_user >=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThan(Long value) {
            addCriterion("audit_user <", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThanOrEqualTo(Long value) {
            addCriterion("audit_user <=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("audit_user in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("audit_user not in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserBetween(Long value1, Long value2) {
            addCriterion("audit_user between", value1, value2, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotBetween(Long value1, Long value2) {
            addCriterion("audit_user not between", value1, value2, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameIsNull() {
            addCriterion("audit_user_name is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameIsNotNull() {
            addCriterion("audit_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameEqualTo(String value) {
            addCriterion("audit_user_name =", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameNotEqualTo(String value) {
            addCriterion("audit_user_name <>", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameGreaterThan(String value) {
            addCriterion("audit_user_name >", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("audit_user_name >=", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameLessThan(String value) {
            addCriterion("audit_user_name <", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameLessThanOrEqualTo(String value) {
            addCriterion("audit_user_name <=", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameLike(String value) {
            addCriterion("audit_user_name like", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameNotLike(String value) {
            addCriterion("audit_user_name not like", value, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_user_name in", values, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_user_name not in", values, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameBetween(String value1, String value2) {
            addCriterion("audit_user_name between", value1, value2, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andAuditUserNameNotBetween(String value1, String value2) {
            addCriterion("audit_user_name not between", value1, value2, "auditUserName");
            return (Criteria) this;
        }

        public Criteria andApplyDescIsNull() {
            addCriterion("apply_desc is null");
            return (Criteria) this;
        }

        public Criteria andApplyDescIsNotNull() {
            addCriterion("apply_desc is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDescEqualTo(String value) {
            addCriterion("apply_desc =", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotEqualTo(String value) {
            addCriterion("apply_desc <>", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescGreaterThan(String value) {
            addCriterion("apply_desc >", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescGreaterThanOrEqualTo(String value) {
            addCriterion("apply_desc >=", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescLessThan(String value) {
            addCriterion("apply_desc <", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescLessThanOrEqualTo(String value) {
            addCriterion("apply_desc <=", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescLike(String value) {
            addCriterion("apply_desc like", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotLike(String value) {
            addCriterion("apply_desc not like", value, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_desc in", values, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("apply_desc not in", values, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescBetween(String value1, String value2) {
            addCriterion("apply_desc between", value1, value2, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andApplyDescNotBetween(String value1, String value2) {
            addCriterion("apply_desc not between", value1, value2, "applyDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescIsNull() {
            addCriterion("audit_desc is null");
            return (Criteria) this;
        }

        public Criteria andAuditDescIsNotNull() {
            addCriterion("audit_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDescEqualTo(String value) {
            addCriterion("audit_desc =", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotEqualTo(String value) {
            addCriterion("audit_desc <>", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescGreaterThan(String value) {
            addCriterion("audit_desc >", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescGreaterThanOrEqualTo(String value) {
            addCriterion("audit_desc >=", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescLessThan(String value) {
            addCriterion("audit_desc <", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescLessThanOrEqualTo(String value) {
            addCriterion("audit_desc <=", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescLike(String value) {
            addCriterion("audit_desc like", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotLike(String value) {
            addCriterion("audit_desc not like", value, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_desc in", values, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("audit_desc not in", values, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescBetween(String value1, String value2) {
            addCriterion("audit_desc between", value1, value2, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andAuditDescNotBetween(String value1, String value2) {
            addCriterion("audit_desc not between", value1, value2, "auditDesc");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdIsNull() {
            addCriterion("success_pass_app_id is null");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdIsNotNull() {
            addCriterion("success_pass_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdEqualTo(Long value) {
            addCriterion("success_pass_app_id =", value, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdNotEqualTo(Long value) {
            addCriterion("success_pass_app_id <>", value, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdGreaterThan(Long value) {
            addCriterion("success_pass_app_id >", value, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdGreaterThanOrEqualTo(Long value) {
            addCriterion("success_pass_app_id >=", value, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdLessThan(Long value) {
            addCriterion("success_pass_app_id <", value, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdLessThanOrEqualTo(Long value) {
            addCriterion("success_pass_app_id <=", value, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("success_pass_app_id in", values, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("success_pass_app_id not in", values, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdBetween(Long value1, Long value2) {
            addCriterion("success_pass_app_id between", value1, value2, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andSuccessPassAppIdNotBetween(Long value1, Long value2) {
            addCriterion("success_pass_app_id not between", value1, value2, "successPassAppId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(java.util.List<java.lang.String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeIsNull() {
            addCriterion("org_system_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeIsNotNull() {
            addCriterion("org_system_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeEqualTo(String value) {
            addCriterion("org_system_code =", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotEqualTo(String value) {
            addCriterion("org_system_code <>", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeGreaterThan(String value) {
            addCriterion("org_system_code >", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_system_code >=", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeLessThan(String value) {
            addCriterion("org_system_code <", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeLessThanOrEqualTo(String value) {
            addCriterion("org_system_code <=", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeLike(String value) {
            addCriterion("org_system_code like", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotLike(String value) {
            addCriterion("org_system_code not like", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("org_system_code in", values, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("org_system_code not in", values, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeBetween(String value1, String value2) {
            addCriterion("org_system_code between", value1, value2, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotBetween(String value1, String value2) {
            addCriterion("org_system_code not between", value1, value2, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(java.util.List<java.lang.String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
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

        public Criteria andOriginalTimeIsNull() {
            addCriterion("original_time is null");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeIsNotNull() {
            addCriterion("original_time is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeEqualTo(Double value) {
            addCriterion("original_time =", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeNotEqualTo(Double value) {
            addCriterion("original_time <>", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeGreaterThan(Double value) {
            addCriterion("original_time >", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("original_time >=", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeLessThan(Double value) {
            addCriterion("original_time <", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeLessThanOrEqualTo(Double value) {
            addCriterion("original_time <=", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeIn(java.util.List<java.lang.Double> values) {
            addCriterion("original_time in", values, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("original_time not in", values, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeBetween(Double value1, Double value2) {
            addCriterion("original_time between", value1, value2, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeNotBetween(Double value1, Double value2) {
            addCriterion("original_time not between", value1, value2, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalCostIsNull() {
            addCriterion("original_cost is null");
            return (Criteria) this;
        }

        public Criteria andOriginalCostIsNotNull() {
            addCriterion("original_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalCostEqualTo(Integer value) {
            addCriterion("original_cost =", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostNotEqualTo(Integer value) {
            addCriterion("original_cost <>", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostGreaterThan(Integer value) {
            addCriterion("original_cost >", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("original_cost >=", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostLessThan(Integer value) {
            addCriterion("original_cost <", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostLessThanOrEqualTo(Integer value) {
            addCriterion("original_cost <=", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostIn(java.util.List<java.lang.Integer> values) {
            addCriterion("original_cost in", values, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("original_cost not in", values, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostBetween(Integer value1, Integer value2) {
            addCriterion("original_cost between", value1, value2, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostNotBetween(Integer value1, Integer value2) {
            addCriterion("original_cost not between", value1, value2, "originalCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostIsNull() {
            addCriterion("reduce_build_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostIsNotNull() {
            addCriterion("reduce_build_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostEqualTo(Integer value) {
            addCriterion("reduce_build_cost =", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostNotEqualTo(Integer value) {
            addCriterion("reduce_build_cost <>", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostGreaterThan(Integer value) {
            addCriterion("reduce_build_cost >", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_build_cost >=", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostLessThan(Integer value) {
            addCriterion("reduce_build_cost <", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_build_cost <=", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_build_cost in", values, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_build_cost not in", values, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_build_cost between", value1, value2, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_build_cost not between", value1, value2, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostIsNull() {
            addCriterion("reduce_use_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostIsNotNull() {
            addCriterion("reduce_use_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostEqualTo(Integer value) {
            addCriterion("reduce_use_cost =", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostNotEqualTo(Integer value) {
            addCriterion("reduce_use_cost <>", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostGreaterThan(Integer value) {
            addCriterion("reduce_use_cost >", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_use_cost >=", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostLessThan(Integer value) {
            addCriterion("reduce_use_cost <", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_use_cost <=", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_use_cost in", values, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_use_cost not in", values, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_use_cost between", value1, value2, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_use_cost not between", value1, value2, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostIsNull() {
            addCriterion("reduce_protect_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostIsNotNull() {
            addCriterion("reduce_protect_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostEqualTo(Integer value) {
            addCriterion("reduce_protect_cost =", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostNotEqualTo(Integer value) {
            addCriterion("reduce_protect_cost <>", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostGreaterThan(Integer value) {
            addCriterion("reduce_protect_cost >", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_protect_cost >=", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostLessThan(Integer value) {
            addCriterion("reduce_protect_cost <", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_protect_cost <=", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_protect_cost in", values, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("reduce_protect_cost not in", values, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_protect_cost between", value1, value2, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_protect_cost not between", value1, value2, "reduceProtectCost");
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
        
        public Criteria andServiceIdIsNull() {
        	addCriterion("service_id is null");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdIsNotNull() {
        	addCriterion("service_id is not null");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdEqualTo(String value) {
        	addCriterion("service_id =", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdNotEqualTo(String value) {
        	addCriterion("service_id <>", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdGreaterThan(String value) {
        	addCriterion("service_id >", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
        	addCriterion("service_id >=", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdLessThan(String value) {
        	addCriterion("service_id <", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdLessThanOrEqualTo(String value) {
        	addCriterion("service_id <=", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdLike(String value) {
        	addCriterion("service_id like", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdNotLike(String value) {
        	addCriterion("service_id not like", value, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdIn(java.util.List<java.lang.String> values) {
        	addCriterion("service_id in", values, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdNotIn(java.util.List<java.lang.String> values) {
        	addCriterion("service_id not in", values, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdBetween(String value1, String value2) {
        	addCriterion("service_id between", value1, value2, "serviceId");
        	return (Criteria) this;
        }
        
        public Criteria andServiceIdNotBetween(String value1, String value2) {
        	addCriterion("service_id not between", value1, value2, "serviceId");
        	return (Criteria) this;
        }
    }

    /**
    c_application_applyaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}