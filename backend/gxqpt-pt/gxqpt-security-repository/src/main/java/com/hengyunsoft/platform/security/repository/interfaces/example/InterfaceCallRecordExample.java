package com.hengyunsoft.platform.security.repository.interfaces.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InterfaceCallRecordExample extends com.hengyunsoft.db.example.BaseExample<InterfaceCallRecordExample.Criteria> implements Serializable {
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

        public Criteria andInterfaceConfigIdIsNull() {
            addCriterion("interface_config_id is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdIsNotNull() {
            addCriterion("interface_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdEqualTo(Long value) {
            addCriterion("interface_config_id =", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotEqualTo(Long value) {
            addCriterion("interface_config_id <>", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdGreaterThan(Long value) {
            addCriterion("interface_config_id >", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("interface_config_id >=", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdLessThan(Long value) {
            addCriterion("interface_config_id <", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("interface_config_id <=", value, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("interface_config_id in", values, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("interface_config_id not in", values, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdBetween(Long value1, Long value2) {
            addCriterion("interface_config_id between", value1, value2, "interfaceConfigId");
            return (Criteria) this;
        }

        public Criteria andInterfaceConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("interface_config_id not between", value1, value2, "interfaceConfigId");
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

        public Criteria andModularNameIsNull() {
            addCriterion("modular_name is null");
            return (Criteria) this;
        }

        public Criteria andModularNameIsNotNull() {
            addCriterion("modular_name is not null");
            return (Criteria) this;
        }

        public Criteria andModularNameEqualTo(String value) {
            addCriterion("modular_name =", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotEqualTo(String value) {
            addCriterion("modular_name <>", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameGreaterThan(String value) {
            addCriterion("modular_name >", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameGreaterThanOrEqualTo(String value) {
            addCriterion("modular_name >=", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLessThan(String value) {
            addCriterion("modular_name <", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLessThanOrEqualTo(String value) {
            addCriterion("modular_name <=", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLike(String value) {
            addCriterion("modular_name like", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotLike(String value) {
            addCriterion("modular_name not like", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameIn(java.util.List<java.lang.String> values) {
            addCriterion("modular_name in", values, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("modular_name not in", values, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameBetween(String value1, String value2) {
            addCriterion("modular_name between", value1, value2, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotBetween(String value1, String value2) {
            addCriterion("modular_name not between", value1, value2, "modularName");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdIsNull() {
            addCriterion("caller_app_id is null");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdIsNotNull() {
            addCriterion("caller_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdEqualTo(String value) {
            addCriterion("caller_app_id =", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdNotEqualTo(String value) {
            addCriterion("caller_app_id <>", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdGreaterThan(String value) {
            addCriterion("caller_app_id >", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("caller_app_id >=", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdLessThan(String value) {
            addCriterion("caller_app_id <", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdLessThanOrEqualTo(String value) {
            addCriterion("caller_app_id <=", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdLike(String value) {
            addCriterion("caller_app_id like", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdNotLike(String value) {
            addCriterion("caller_app_id not like", value, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdIn(java.util.List<java.lang.String> values) {
            addCriterion("caller_app_id in", values, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("caller_app_id not in", values, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdBetween(String value1, String value2) {
            addCriterion("caller_app_id between", value1, value2, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andCallerAppIdNotBetween(String value1, String value2) {
            addCriterion("caller_app_id not between", value1, value2, "callerAppId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(java.util.List<java.lang.String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(java.util.List<java.lang.String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(java.util.List<java.lang.String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andZuulUriIsNull() {
            addCriterion("zuul_uri is null");
            return (Criteria) this;
        }

        public Criteria andZuulUriIsNotNull() {
            addCriterion("zuul_uri is not null");
            return (Criteria) this;
        }

        public Criteria andZuulUriEqualTo(String value) {
            addCriterion("zuul_uri =", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriNotEqualTo(String value) {
            addCriterion("zuul_uri <>", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriGreaterThan(String value) {
            addCriterion("zuul_uri >", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriGreaterThanOrEqualTo(String value) {
            addCriterion("zuul_uri >=", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriLessThan(String value) {
            addCriterion("zuul_uri <", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriLessThanOrEqualTo(String value) {
            addCriterion("zuul_uri <=", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriLike(String value) {
            addCriterion("zuul_uri like", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriNotLike(String value) {
            addCriterion("zuul_uri not like", value, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriIn(java.util.List<java.lang.String> values) {
            addCriterion("zuul_uri in", values, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriNotIn(java.util.List<java.lang.String> values) {
            addCriterion("zuul_uri not in", values, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriBetween(String value1, String value2) {
            addCriterion("zuul_uri between", value1, value2, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andZuulUriNotBetween(String value1, String value2) {
            addCriterion("zuul_uri not between", value1, value2, "zuulUri");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(java.util.List<java.lang.String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andCookiesIsNull() {
            addCriterion("cookies is null");
            return (Criteria) this;
        }

        public Criteria andCookiesIsNotNull() {
            addCriterion("cookies is not null");
            return (Criteria) this;
        }

        public Criteria andCookiesEqualTo(String value) {
            addCriterion("cookies =", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesNotEqualTo(String value) {
            addCriterion("cookies <>", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesGreaterThan(String value) {
            addCriterion("cookies >", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesGreaterThanOrEqualTo(String value) {
            addCriterion("cookies >=", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesLessThan(String value) {
            addCriterion("cookies <", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesLessThanOrEqualTo(String value) {
            addCriterion("cookies <=", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesLike(String value) {
            addCriterion("cookies like", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesNotLike(String value) {
            addCriterion("cookies not like", value, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesIn(java.util.List<java.lang.String> values) {
            addCriterion("cookies in", values, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cookies not in", values, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesBetween(String value1, String value2) {
            addCriterion("cookies between", value1, value2, "cookies");
            return (Criteria) this;
        }

        public Criteria andCookiesNotBetween(String value1, String value2) {
            addCriterion("cookies not between", value1, value2, "cookies");
            return (Criteria) this;
        }

        public Criteria andHeadersIsNull() {
            addCriterion("headers is null");
            return (Criteria) this;
        }

        public Criteria andHeadersIsNotNull() {
            addCriterion("headers is not null");
            return (Criteria) this;
        }

        public Criteria andHeadersEqualTo(String value) {
            addCriterion("headers =", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersNotEqualTo(String value) {
            addCriterion("headers <>", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersGreaterThan(String value) {
            addCriterion("headers >", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersGreaterThanOrEqualTo(String value) {
            addCriterion("headers >=", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersLessThan(String value) {
            addCriterion("headers <", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersLessThanOrEqualTo(String value) {
            addCriterion("headers <=", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersLike(String value) {
            addCriterion("headers like", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersNotLike(String value) {
            addCriterion("headers not like", value, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersIn(java.util.List<java.lang.String> values) {
            addCriterion("headers in", values, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersNotIn(java.util.List<java.lang.String> values) {
            addCriterion("headers not in", values, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersBetween(String value1, String value2) {
            addCriterion("headers between", value1, value2, "headers");
            return (Criteria) this;
        }

        public Criteria andHeadersNotBetween(String value1, String value2) {
            addCriterion("headers not between", value1, value2, "headers");
            return (Criteria) this;
        }

        public Criteria andQueryStringIsNull() {
            addCriterion("query_string is null");
            return (Criteria) this;
        }

        public Criteria andQueryStringIsNotNull() {
            addCriterion("query_string is not null");
            return (Criteria) this;
        }

        public Criteria andQueryStringEqualTo(String value) {
            addCriterion("query_string =", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringNotEqualTo(String value) {
            addCriterion("query_string <>", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringGreaterThan(String value) {
            addCriterion("query_string >", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringGreaterThanOrEqualTo(String value) {
            addCriterion("query_string >=", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringLessThan(String value) {
            addCriterion("query_string <", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringLessThanOrEqualTo(String value) {
            addCriterion("query_string <=", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringLike(String value) {
            addCriterion("query_string like", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringNotLike(String value) {
            addCriterion("query_string not like", value, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringIn(java.util.List<java.lang.String> values) {
            addCriterion("query_string in", values, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringNotIn(java.util.List<java.lang.String> values) {
            addCriterion("query_string not in", values, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringBetween(String value1, String value2) {
            addCriterion("query_string between", value1, value2, "queryString");
            return (Criteria) this;
        }

        public Criteria andQueryStringNotBetween(String value1, String value2) {
            addCriterion("query_string not between", value1, value2, "queryString");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsIsNull() {
            addCriterion("request_query_params is null");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsIsNotNull() {
            addCriterion("request_query_params is not null");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsEqualTo(String value) {
            addCriterion("request_query_params =", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsNotEqualTo(String value) {
            addCriterion("request_query_params <>", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsGreaterThan(String value) {
            addCriterion("request_query_params >", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsGreaterThanOrEqualTo(String value) {
            addCriterion("request_query_params >=", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsLessThan(String value) {
            addCriterion("request_query_params <", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsLessThanOrEqualTo(String value) {
            addCriterion("request_query_params <=", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsLike(String value) {
            addCriterion("request_query_params like", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsNotLike(String value) {
            addCriterion("request_query_params not like", value, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsIn(java.util.List<java.lang.String> values) {
            addCriterion("request_query_params in", values, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsNotIn(java.util.List<java.lang.String> values) {
            addCriterion("request_query_params not in", values, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsBetween(String value1, String value2) {
            addCriterion("request_query_params between", value1, value2, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andRequestQueryParamsNotBetween(String value1, String value2) {
            addCriterion("request_query_params not between", value1, value2, "requestQueryParams");
            return (Criteria) this;
        }

        public Criteria andContentLengthIsNull() {
            addCriterion("content_length is null");
            return (Criteria) this;
        }

        public Criteria andContentLengthIsNotNull() {
            addCriterion("content_length is not null");
            return (Criteria) this;
        }

        public Criteria andContentLengthEqualTo(String value) {
            addCriterion("content_length =", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthNotEqualTo(String value) {
            addCriterion("content_length <>", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthGreaterThan(String value) {
            addCriterion("content_length >", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthGreaterThanOrEqualTo(String value) {
            addCriterion("content_length >=", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthLessThan(String value) {
            addCriterion("content_length <", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthLessThanOrEqualTo(String value) {
            addCriterion("content_length <=", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthLike(String value) {
            addCriterion("content_length like", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthNotLike(String value) {
            addCriterion("content_length not like", value, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthIn(java.util.List<java.lang.String> values) {
            addCriterion("content_length in", values, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthNotIn(java.util.List<java.lang.String> values) {
            addCriterion("content_length not in", values, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthBetween(String value1, String value2) {
            addCriterion("content_length between", value1, value2, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentLengthNotBetween(String value1, String value2) {
            addCriterion("content_length not between", value1, value2, "contentLength");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(String value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(String value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(String value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(String value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(String value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLike(String value) {
            addCriterion("content_type like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotLike(String value) {
            addCriterion("content_type not like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(String value1, String value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(String value1, String value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(java.util.List<java.lang.String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(java.util.List<java.lang.String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andRequestBodyIsNull() {
            addCriterion("request_body is null");
            return (Criteria) this;
        }

        public Criteria andRequestBodyIsNotNull() {
            addCriterion("request_body is not null");
            return (Criteria) this;
        }

        public Criteria andRequestBodyEqualTo(String value) {
            addCriterion("request_body =", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyNotEqualTo(String value) {
            addCriterion("request_body <>", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyGreaterThan(String value) {
            addCriterion("request_body >", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyGreaterThanOrEqualTo(String value) {
            addCriterion("request_body >=", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyLessThan(String value) {
            addCriterion("request_body <", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyLessThanOrEqualTo(String value) {
            addCriterion("request_body <=", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyLike(String value) {
            addCriterion("request_body like", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyNotLike(String value) {
            addCriterion("request_body not like", value, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyIn(java.util.List<java.lang.String> values) {
            addCriterion("request_body in", values, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("request_body not in", values, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyBetween(String value1, String value2) {
            addCriterion("request_body between", value1, value2, "requestBody");
            return (Criteria) this;
        }

        public Criteria andRequestBodyNotBetween(String value1, String value2) {
            addCriterion("request_body not between", value1, value2, "requestBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyIsNull() {
            addCriterion("response_body is null");
            return (Criteria) this;
        }

        public Criteria andResponseBodyIsNotNull() {
            addCriterion("response_body is not null");
            return (Criteria) this;
        }

        public Criteria andResponseBodyEqualTo(String value) {
            addCriterion("response_body =", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyNotEqualTo(String value) {
            addCriterion("response_body <>", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyGreaterThan(String value) {
            addCriterion("response_body >", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyGreaterThanOrEqualTo(String value) {
            addCriterion("response_body >=", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyLessThan(String value) {
            addCriterion("response_body <", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyLessThanOrEqualTo(String value) {
            addCriterion("response_body <=", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyLike(String value) {
            addCriterion("response_body like", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyNotLike(String value) {
            addCriterion("response_body not like", value, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyIn(java.util.List<java.lang.String> values) {
            addCriterion("response_body in", values, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("response_body not in", values, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyBetween(String value1, String value2) {
            addCriterion("response_body between", value1, value2, "responseBody");
            return (Criteria) this;
        }

        public Criteria andResponseBodyNotBetween(String value1, String value2) {
            addCriterion("response_body not between", value1, value2, "responseBody");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(java.util.List<java.lang.String> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateMonthIsNull() {
            addCriterion("create_month is null");
            return (Criteria) this;
        }

        public Criteria andCreateMonthIsNotNull() {
            addCriterion("create_month is not null");
            return (Criteria) this;
        }

        public Criteria andCreateMonthEqualTo(String value) {
            addCriterion("create_month =", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthNotEqualTo(String value) {
            addCriterion("create_month <>", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthGreaterThan(String value) {
            addCriterion("create_month >", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthGreaterThanOrEqualTo(String value) {
            addCriterion("create_month >=", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthLessThan(String value) {
            addCriterion("create_month <", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthLessThanOrEqualTo(String value) {
            addCriterion("create_month <=", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthLike(String value) {
            addCriterion("create_month like", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthNotLike(String value) {
            addCriterion("create_month not like", value, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthIn(java.util.List<java.lang.String> values) {
            addCriterion("create_month in", values, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_month not in", values, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthBetween(String value1, String value2) {
            addCriterion("create_month between", value1, value2, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateMonthNotBetween(String value1, String value2) {
            addCriterion("create_month not between", value1, value2, "createMonth");
            return (Criteria) this;
        }

        public Criteria andCreateHourIsNull() {
            addCriterion("create_hour is null");
            return (Criteria) this;
        }

        public Criteria andCreateHourIsNotNull() {
            addCriterion("create_hour is not null");
            return (Criteria) this;
        }

        public Criteria andCreateHourEqualTo(String value) {
            addCriterion("create_hour =", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourNotEqualTo(String value) {
            addCriterion("create_hour <>", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourGreaterThan(String value) {
            addCriterion("create_hour >", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourGreaterThanOrEqualTo(String value) {
            addCriterion("create_hour >=", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourLessThan(String value) {
            addCriterion("create_hour <", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourLessThanOrEqualTo(String value) {
            addCriterion("create_hour <=", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourLike(String value) {
            addCriterion("create_hour like", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourNotLike(String value) {
            addCriterion("create_hour not like", value, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourIn(java.util.List<java.lang.String> values) {
            addCriterion("create_hour in", values, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourNotIn(java.util.List<java.lang.String> values) {
            addCriterion("create_hour not in", values, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourBetween(String value1, String value2) {
            addCriterion("create_hour between", value1, value2, "createHour");
            return (Criteria) this;
        }

        public Criteria andCreateHourNotBetween(String value1, String value2) {
            addCriterion("create_hour not between", value1, value2, "createHour");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andErrMsgIsNull() {
            addCriterion("err_msg is null");
            return (Criteria) this;
        }

        public Criteria andErrMsgIsNotNull() {
            addCriterion("err_msg is not null");
            return (Criteria) this;
        }

        public Criteria andErrMsgEqualTo(String value) {
            addCriterion("err_msg =", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotEqualTo(String value) {
            addCriterion("err_msg <>", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThan(String value) {
            addCriterion("err_msg >", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThanOrEqualTo(String value) {
            addCriterion("err_msg >=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThan(String value) {
            addCriterion("err_msg <", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThanOrEqualTo(String value) {
            addCriterion("err_msg <=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLike(String value) {
            addCriterion("err_msg like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotLike(String value) {
            addCriterion("err_msg not like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgIn(java.util.List<java.lang.String> values) {
            addCriterion("err_msg in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotIn(java.util.List<java.lang.String> values) {
            addCriterion("err_msg not in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgBetween(String value1, String value2) {
            addCriterion("err_msg between", value1, value2, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotBetween(String value1, String value2) {
            addCriterion("err_msg not between", value1, value2, "errMsg");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(java.util.List<java.lang.String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(java.util.List<java.lang.String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }
    }

    /**
    se_interface_call_recordaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}