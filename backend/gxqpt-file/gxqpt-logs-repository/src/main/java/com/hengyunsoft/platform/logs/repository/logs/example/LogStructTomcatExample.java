package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogStructTomcatExample extends com.hengyunsoft.db.example.BaseExample<LogStructTomcatExample.Criteria> implements Serializable {
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

        public Criteria andDocumentIdIsNull() {
            addCriterion("document_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNotNull() {
            addCriterion("document_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("document_id =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotEqualTo(String value) {
            addCriterion("document_id <>", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThan(String value) {
            addCriterion("document_id >", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThanOrEqualTo(String value) {
            addCriterion("document_id >=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThan(String value) {
            addCriterion("document_id <", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThanOrEqualTo(String value) {
            addCriterion("document_id <=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLike(String value) {
            addCriterion("document_id like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotLike(String value) {
            addCriterion("document_id not like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIn(java.util.List<java.lang.String> values) {
            addCriterion("document_id in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("document_id not in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdBetween(String value1, String value2) {
            addCriterion("document_id between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotBetween(String value1, String value2) {
            addCriterion("document_id not between", value1, value2, "documentId");
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

        public Criteria andRemoteIpIsNull() {
            addCriterion("remote_ip is null");
            return (Criteria) this;
        }

        public Criteria andRemoteIpIsNotNull() {
            addCriterion("remote_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteIpEqualTo(String value) {
            addCriterion("remote_ip =", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotEqualTo(String value) {
            addCriterion("remote_ip <>", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpGreaterThan(String value) {
            addCriterion("remote_ip >", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpGreaterThanOrEqualTo(String value) {
            addCriterion("remote_ip >=", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLessThan(String value) {
            addCriterion("remote_ip <", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLessThanOrEqualTo(String value) {
            addCriterion("remote_ip <=", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLike(String value) {
            addCriterion("remote_ip like", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotLike(String value) {
            addCriterion("remote_ip not like", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_ip in", values, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_ip not in", values, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpBetween(String value1, String value2) {
            addCriterion("remote_ip between", value1, value2, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotBetween(String value1, String value2) {
            addCriterion("remote_ip not between", value1, value2, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpIsNull() {
            addCriterion("local_ip is null");
            return (Criteria) this;
        }

        public Criteria andLocalIpIsNotNull() {
            addCriterion("local_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLocalIpEqualTo(String value) {
            addCriterion("local_ip =", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpNotEqualTo(String value) {
            addCriterion("local_ip <>", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpGreaterThan(String value) {
            addCriterion("local_ip >", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpGreaterThanOrEqualTo(String value) {
            addCriterion("local_ip >=", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpLessThan(String value) {
            addCriterion("local_ip <", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpLessThanOrEqualTo(String value) {
            addCriterion("local_ip <=", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpLike(String value) {
            addCriterion("local_ip like", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpNotLike(String value) {
            addCriterion("local_ip not like", value, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpIn(java.util.List<java.lang.String> values) {
            addCriterion("local_ip in", values, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("local_ip not in", values, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpBetween(String value1, String value2) {
            addCriterion("local_ip between", value1, value2, "localIp");
            return (Criteria) this;
        }

        public Criteria andLocalIpNotBetween(String value1, String value2) {
            addCriterion("local_ip not between", value1, value2, "localIp");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebIsNull() {
            addCriterion("send_byte_littleb is null");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebIsNotNull() {
            addCriterion("send_byte_littleb is not null");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebEqualTo(String value) {
            addCriterion("send_byte_littleb =", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebNotEqualTo(String value) {
            addCriterion("send_byte_littleb <>", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebGreaterThan(String value) {
            addCriterion("send_byte_littleb >", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebGreaterThanOrEqualTo(String value) {
            addCriterion("send_byte_littleb >=", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebLessThan(String value) {
            addCriterion("send_byte_littleb <", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebLessThanOrEqualTo(String value) {
            addCriterion("send_byte_littleb <=", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebLike(String value) {
            addCriterion("send_byte_littleb like", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebNotLike(String value) {
            addCriterion("send_byte_littleb not like", value, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebIn(java.util.List<java.lang.String> values) {
            addCriterion("send_byte_littleb in", values, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebNotIn(java.util.List<java.lang.String> values) {
            addCriterion("send_byte_littleb not in", values, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebBetween(String value1, String value2) {
            addCriterion("send_byte_littleb between", value1, value2, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteLittlebNotBetween(String value1, String value2) {
            addCriterion("send_byte_littleb not between", value1, value2, "sendByteLittleb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbIsNull() {
            addCriterion("send_byte_bigb is null");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbIsNotNull() {
            addCriterion("send_byte_bigb is not null");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbEqualTo(String value) {
            addCriterion("send_byte_bigb =", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbNotEqualTo(String value) {
            addCriterion("send_byte_bigb <>", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbGreaterThan(String value) {
            addCriterion("send_byte_bigb >", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbGreaterThanOrEqualTo(String value) {
            addCriterion("send_byte_bigb >=", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbLessThan(String value) {
            addCriterion("send_byte_bigb <", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbLessThanOrEqualTo(String value) {
            addCriterion("send_byte_bigb <=", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbLike(String value) {
            addCriterion("send_byte_bigb like", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbNotLike(String value) {
            addCriterion("send_byte_bigb not like", value, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbIn(java.util.List<java.lang.String> values) {
            addCriterion("send_byte_bigb in", values, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbNotIn(java.util.List<java.lang.String> values) {
            addCriterion("send_byte_bigb not in", values, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbBetween(String value1, String value2) {
            addCriterion("send_byte_bigb between", value1, value2, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andSendByteBigbNotBetween(String value1, String value2) {
            addCriterion("send_byte_bigb not between", value1, value2, "sendByteBigb");
            return (Criteria) this;
        }

        public Criteria andRemoteHostIsNull() {
            addCriterion("remote_host is null");
            return (Criteria) this;
        }

        public Criteria andRemoteHostIsNotNull() {
            addCriterion("remote_host is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteHostEqualTo(String value) {
            addCriterion("remote_host =", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotEqualTo(String value) {
            addCriterion("remote_host <>", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostGreaterThan(String value) {
            addCriterion("remote_host >", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostGreaterThanOrEqualTo(String value) {
            addCriterion("remote_host >=", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostLessThan(String value) {
            addCriterion("remote_host <", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostLessThanOrEqualTo(String value) {
            addCriterion("remote_host <=", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostLike(String value) {
            addCriterion("remote_host like", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotLike(String value) {
            addCriterion("remote_host not like", value, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_host in", values, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_host not in", values, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostBetween(String value1, String value2) {
            addCriterion("remote_host between", value1, value2, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRemoteHostNotBetween(String value1, String value2) {
            addCriterion("remote_host not between", value1, value2, "remoteHost");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementIsNull() {
            addCriterion("request_agreement is null");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementIsNotNull() {
            addCriterion("request_agreement is not null");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementEqualTo(String value) {
            addCriterion("request_agreement =", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementNotEqualTo(String value) {
            addCriterion("request_agreement <>", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementGreaterThan(String value) {
            addCriterion("request_agreement >", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementGreaterThanOrEqualTo(String value) {
            addCriterion("request_agreement >=", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementLessThan(String value) {
            addCriterion("request_agreement <", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementLessThanOrEqualTo(String value) {
            addCriterion("request_agreement <=", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementLike(String value) {
            addCriterion("request_agreement like", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementNotLike(String value) {
            addCriterion("request_agreement not like", value, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementIn(java.util.List<java.lang.String> values) {
            addCriterion("request_agreement in", values, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementNotIn(java.util.List<java.lang.String> values) {
            addCriterion("request_agreement not in", values, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementBetween(String value1, String value2) {
            addCriterion("request_agreement between", value1, value2, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andRequestAgreementNotBetween(String value1, String value2) {
            addCriterion("request_agreement not between", value1, value2, "requestAgreement");
            return (Criteria) this;
        }

        public Criteria andIdentdUserIsNull() {
            addCriterion("identd_user is null");
            return (Criteria) this;
        }

        public Criteria andIdentdUserIsNotNull() {
            addCriterion("identd_user is not null");
            return (Criteria) this;
        }

        public Criteria andIdentdUserEqualTo(String value) {
            addCriterion("identd_user =", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserNotEqualTo(String value) {
            addCriterion("identd_user <>", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserGreaterThan(String value) {
            addCriterion("identd_user >", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserGreaterThanOrEqualTo(String value) {
            addCriterion("identd_user >=", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserLessThan(String value) {
            addCriterion("identd_user <", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserLessThanOrEqualTo(String value) {
            addCriterion("identd_user <=", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserLike(String value) {
            addCriterion("identd_user like", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserNotLike(String value) {
            addCriterion("identd_user not like", value, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserIn(java.util.List<java.lang.String> values) {
            addCriterion("identd_user in", values, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("identd_user not in", values, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserBetween(String value1, String value2) {
            addCriterion("identd_user between", value1, value2, "identdUser");
            return (Criteria) this;
        }

        public Criteria andIdentdUserNotBetween(String value1, String value2) {
            addCriterion("identd_user not between", value1, value2, "identdUser");
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

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(java.util.List<java.lang.String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(java.util.List<java.lang.String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andQueryStrIsNull() {
            addCriterion("query_str is null");
            return (Criteria) this;
        }

        public Criteria andQueryStrIsNotNull() {
            addCriterion("query_str is not null");
            return (Criteria) this;
        }

        public Criteria andQueryStrEqualTo(String value) {
            addCriterion("query_str =", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrNotEqualTo(String value) {
            addCriterion("query_str <>", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrGreaterThan(String value) {
            addCriterion("query_str >", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrGreaterThanOrEqualTo(String value) {
            addCriterion("query_str >=", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrLessThan(String value) {
            addCriterion("query_str <", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrLessThanOrEqualTo(String value) {
            addCriterion("query_str <=", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrLike(String value) {
            addCriterion("query_str like", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrNotLike(String value) {
            addCriterion("query_str not like", value, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrIn(java.util.List<java.lang.String> values) {
            addCriterion("query_str in", values, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrNotIn(java.util.List<java.lang.String> values) {
            addCriterion("query_str not in", values, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrBetween(String value1, String value2) {
            addCriterion("query_str between", value1, value2, "queryStr");
            return (Criteria) this;
        }

        public Criteria andQueryStrNotBetween(String value1, String value2) {
            addCriterion("query_str not between", value1, value2, "queryStr");
            return (Criteria) this;
        }

        public Criteria andFirstLineIsNull() {
            addCriterion("first_line is null");
            return (Criteria) this;
        }

        public Criteria andFirstLineIsNotNull() {
            addCriterion("first_line is not null");
            return (Criteria) this;
        }

        public Criteria andFirstLineEqualTo(String value) {
            addCriterion("first_line =", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineNotEqualTo(String value) {
            addCriterion("first_line <>", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineGreaterThan(String value) {
            addCriterion("first_line >", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineGreaterThanOrEqualTo(String value) {
            addCriterion("first_line >=", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineLessThan(String value) {
            addCriterion("first_line <", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineLessThanOrEqualTo(String value) {
            addCriterion("first_line <=", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineLike(String value) {
            addCriterion("first_line like", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineNotLike(String value) {
            addCriterion("first_line not like", value, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineIn(java.util.List<java.lang.String> values) {
            addCriterion("first_line in", values, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineNotIn(java.util.List<java.lang.String> values) {
            addCriterion("first_line not in", values, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineBetween(String value1, String value2) {
            addCriterion("first_line between", value1, value2, "firstLine");
            return (Criteria) this;
        }

        public Criteria andFirstLineNotBetween(String value1, String value2) {
            addCriterion("first_line not between", value1, value2, "firstLine");
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

        public Criteria andSessionIdIsNull() {
            addCriterion("session_id is null");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNotNull() {
            addCriterion("session_id is not null");
            return (Criteria) this;
        }

        public Criteria andSessionIdEqualTo(String value) {
            addCriterion("session_id =", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotEqualTo(String value) {
            addCriterion("session_id <>", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThan(String value) {
            addCriterion("session_id >", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("session_id >=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThan(String value) {
            addCriterion("session_id <", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThanOrEqualTo(String value) {
            addCriterion("session_id <=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLike(String value) {
            addCriterion("session_id like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotLike(String value) {
            addCriterion("session_id not like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIn(java.util.List<java.lang.String> values) {
            addCriterion("session_id in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("session_id not in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdBetween(String value1, String value2) {
            addCriterion("session_id between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotBetween(String value1, String value2) {
            addCriterion("session_id not between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserIsNull() {
            addCriterion("remote_check_user is null");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserIsNotNull() {
            addCriterion("remote_check_user is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserEqualTo(String value) {
            addCriterion("remote_check_user =", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserNotEqualTo(String value) {
            addCriterion("remote_check_user <>", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserGreaterThan(String value) {
            addCriterion("remote_check_user >", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserGreaterThanOrEqualTo(String value) {
            addCriterion("remote_check_user >=", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserLessThan(String value) {
            addCriterion("remote_check_user <", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserLessThanOrEqualTo(String value) {
            addCriterion("remote_check_user <=", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserLike(String value) {
            addCriterion("remote_check_user like", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserNotLike(String value) {
            addCriterion("remote_check_user not like", value, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_check_user in", values, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_check_user not in", values, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserBetween(String value1, String value2) {
            addCriterion("remote_check_user between", value1, value2, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRemoteCheckUserNotBetween(String value1, String value2) {
            addCriterion("remote_check_user not between", value1, value2, "remoteCheckUser");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIsNull() {
            addCriterion("request_url is null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIsNotNull() {
            addCriterion("request_url is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlEqualTo(String value) {
            addCriterion("request_url =", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotEqualTo(String value) {
            addCriterion("request_url <>", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThan(String value) {
            addCriterion("request_url >", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("request_url >=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThan(String value) {
            addCriterion("request_url <", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThanOrEqualTo(String value) {
            addCriterion("request_url <=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLike(String value) {
            addCriterion("request_url like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotLike(String value) {
            addCriterion("request_url not like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("request_url in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("request_url not in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlBetween(String value1, String value2) {
            addCriterion("request_url between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotBetween(String value1, String value2) {
            addCriterion("request_url not between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andLocalHostIsNull() {
            addCriterion("local_host is null");
            return (Criteria) this;
        }

        public Criteria andLocalHostIsNotNull() {
            addCriterion("local_host is not null");
            return (Criteria) this;
        }

        public Criteria andLocalHostEqualTo(String value) {
            addCriterion("local_host =", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostNotEqualTo(String value) {
            addCriterion("local_host <>", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostGreaterThan(String value) {
            addCriterion("local_host >", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostGreaterThanOrEqualTo(String value) {
            addCriterion("local_host >=", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostLessThan(String value) {
            addCriterion("local_host <", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostLessThanOrEqualTo(String value) {
            addCriterion("local_host <=", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostLike(String value) {
            addCriterion("local_host like", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostNotLike(String value) {
            addCriterion("local_host not like", value, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostIn(java.util.List<java.lang.String> values) {
            addCriterion("local_host in", values, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostNotIn(java.util.List<java.lang.String> values) {
            addCriterion("local_host not in", values, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostBetween(String value1, String value2) {
            addCriterion("local_host between", value1, value2, "localHost");
            return (Criteria) this;
        }

        public Criteria andLocalHostNotBetween(String value1, String value2) {
            addCriterion("local_host not between", value1, value2, "localHost");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondIsNull() {
            addCriterion("deal_request_millisecond is null");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondIsNotNull() {
            addCriterion("deal_request_millisecond is not null");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondEqualTo(Long value) {
            addCriterion("deal_request_millisecond =", value, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondNotEqualTo(Long value) {
            addCriterion("deal_request_millisecond <>", value, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondGreaterThan(Long value) {
            addCriterion("deal_request_millisecond >", value, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondGreaterThanOrEqualTo(Long value) {
            addCriterion("deal_request_millisecond >=", value, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondLessThan(Long value) {
            addCriterion("deal_request_millisecond <", value, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondLessThanOrEqualTo(Long value) {
            addCriterion("deal_request_millisecond <=", value, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondIn(java.util.List<java.lang.Long> values) {
            addCriterion("deal_request_millisecond in", values, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("deal_request_millisecond not in", values, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondBetween(Long value1, Long value2) {
            addCriterion("deal_request_millisecond between", value1, value2, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andDealRequestMillisecondNotBetween(Long value1, Long value2) {
            addCriterion("deal_request_millisecond not between", value1, value2, "dealRequestMillisecond");
            return (Criteria) this;
        }

        public Criteria andTimeConsumIsNull() {
            addCriterion("time_consum is null");
            return (Criteria) this;
        }

        public Criteria andTimeConsumIsNotNull() {
            addCriterion("time_consum is not null");
            return (Criteria) this;
        }

        public Criteria andTimeConsumEqualTo(Long value) {
            addCriterion("time_consum =", value, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumNotEqualTo(Long value) {
            addCriterion("time_consum <>", value, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumGreaterThan(Long value) {
            addCriterion("time_consum >", value, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumGreaterThanOrEqualTo(Long value) {
            addCriterion("time_consum >=", value, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumLessThan(Long value) {
            addCriterion("time_consum <", value, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumLessThanOrEqualTo(Long value) {
            addCriterion("time_consum <=", value, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumIn(java.util.List<java.lang.Long> values) {
            addCriterion("time_consum in", values, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("time_consum not in", values, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumBetween(Long value1, Long value2) {
            addCriterion("time_consum between", value1, value2, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andTimeConsumNotBetween(Long value1, Long value2) {
            addCriterion("time_consum not between", value1, value2, "timeConsum");
            return (Criteria) this;
        }

        public Criteria andCurrentLineIsNull() {
            addCriterion("current_line is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLineIsNotNull() {
            addCriterion("current_line is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLineEqualTo(String value) {
            addCriterion("current_line =", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineNotEqualTo(String value) {
            addCriterion("current_line <>", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineGreaterThan(String value) {
            addCriterion("current_line >", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineGreaterThanOrEqualTo(String value) {
            addCriterion("current_line >=", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineLessThan(String value) {
            addCriterion("current_line <", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineLessThanOrEqualTo(String value) {
            addCriterion("current_line <=", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineLike(String value) {
            addCriterion("current_line like", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineNotLike(String value) {
            addCriterion("current_line not like", value, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineIn(java.util.List<java.lang.String> values) {
            addCriterion("current_line in", values, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineNotIn(java.util.List<java.lang.String> values) {
            addCriterion("current_line not in", values, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineBetween(String value1, String value2) {
            addCriterion("current_line between", value1, value2, "currentLine");
            return (Criteria) this;
        }

        public Criteria andCurrentLineNotBetween(String value1, String value2) {
            addCriterion("current_line not between", value1, value2, "currentLine");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNull() {
            addCriterion("accept is null");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNotNull() {
            addCriterion("accept is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptEqualTo(String value) {
            addCriterion("accept =", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotEqualTo(String value) {
            addCriterion("accept <>", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThan(String value) {
            addCriterion("accept >", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThanOrEqualTo(String value) {
            addCriterion("accept >=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThan(String value) {
            addCriterion("accept <", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThanOrEqualTo(String value) {
            addCriterion("accept <=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLike(String value) {
            addCriterion("accept like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotLike(String value) {
            addCriterion("accept not like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptIn(java.util.List<java.lang.String> values) {
            addCriterion("accept in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotIn(java.util.List<java.lang.String> values) {
            addCriterion("accept not in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptBetween(String value1, String value2) {
            addCriterion("accept between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotBetween(String value1, String value2) {
            addCriterion("accept not between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingIsNull() {
            addCriterion("accept_encoding is null");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingIsNotNull() {
            addCriterion("accept_encoding is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingEqualTo(String value) {
            addCriterion("accept_encoding =", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingNotEqualTo(String value) {
            addCriterion("accept_encoding <>", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingGreaterThan(String value) {
            addCriterion("accept_encoding >", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingGreaterThanOrEqualTo(String value) {
            addCriterion("accept_encoding >=", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingLessThan(String value) {
            addCriterion("accept_encoding <", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingLessThanOrEqualTo(String value) {
            addCriterion("accept_encoding <=", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingLike(String value) {
            addCriterion("accept_encoding like", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingNotLike(String value) {
            addCriterion("accept_encoding not like", value, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingIn(java.util.List<java.lang.String> values) {
            addCriterion("accept_encoding in", values, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingNotIn(java.util.List<java.lang.String> values) {
            addCriterion("accept_encoding not in", values, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingBetween(String value1, String value2) {
            addCriterion("accept_encoding between", value1, value2, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptEncodingNotBetween(String value1, String value2) {
            addCriterion("accept_encoding not between", value1, value2, "acceptEncoding");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageIsNull() {
            addCriterion("accept_language is null");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageIsNotNull() {
            addCriterion("accept_language is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageEqualTo(String value) {
            addCriterion("accept_language =", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageNotEqualTo(String value) {
            addCriterion("accept_language <>", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageGreaterThan(String value) {
            addCriterion("accept_language >", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("accept_language >=", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageLessThan(String value) {
            addCriterion("accept_language <", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageLessThanOrEqualTo(String value) {
            addCriterion("accept_language <=", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageLike(String value) {
            addCriterion("accept_language like", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageNotLike(String value) {
            addCriterion("accept_language not like", value, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageIn(java.util.List<java.lang.String> values) {
            addCriterion("accept_language in", values, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageNotIn(java.util.List<java.lang.String> values) {
            addCriterion("accept_language not in", values, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageBetween(String value1, String value2) {
            addCriterion("accept_language between", value1, value2, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptLanguageNotBetween(String value1, String value2) {
            addCriterion("accept_language not between", value1, value2, "acceptLanguage");
            return (Criteria) this;
        }

        public Criteria andConnectionIIsNull() {
            addCriterion("connection_i is null");
            return (Criteria) this;
        }

        public Criteria andConnectionIIsNotNull() {
            addCriterion("connection_i is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionIEqualTo(String value) {
            addCriterion("connection_i =", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionINotEqualTo(String value) {
            addCriterion("connection_i <>", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionIGreaterThan(String value) {
            addCriterion("connection_i >", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionIGreaterThanOrEqualTo(String value) {
            addCriterion("connection_i >=", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionILessThan(String value) {
            addCriterion("connection_i <", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionILessThanOrEqualTo(String value) {
            addCriterion("connection_i <=", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionILike(String value) {
            addCriterion("connection_i like", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionINotLike(String value) {
            addCriterion("connection_i not like", value, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionIIn(java.util.List<java.lang.String> values) {
            addCriterion("connection_i in", values, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionINotIn(java.util.List<java.lang.String> values) {
            addCriterion("connection_i not in", values, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionIBetween(String value1, String value2) {
            addCriterion("connection_i between", value1, value2, "connectionI");
            return (Criteria) this;
        }

        public Criteria andConnectionINotBetween(String value1, String value2) {
            addCriterion("connection_i not between", value1, value2, "connectionI");
            return (Criteria) this;
        }

        public Criteria andCookieIsNull() {
            addCriterion("cookie is null");
            return (Criteria) this;
        }

        public Criteria andCookieIsNotNull() {
            addCriterion("cookie is not null");
            return (Criteria) this;
        }

        public Criteria andCookieEqualTo(String value) {
            addCriterion("cookie =", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotEqualTo(String value) {
            addCriterion("cookie <>", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThan(String value) {
            addCriterion("cookie >", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThanOrEqualTo(String value) {
            addCriterion("cookie >=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThan(String value) {
            addCriterion("cookie <", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThanOrEqualTo(String value) {
            addCriterion("cookie <=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLike(String value) {
            addCriterion("cookie like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotLike(String value) {
            addCriterion("cookie not like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieIn(java.util.List<java.lang.String> values) {
            addCriterion("cookie in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cookie not in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieBetween(String value1, String value2) {
            addCriterion("cookie between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotBetween(String value1, String value2) {
            addCriterion("cookie not between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            addCriterion("host is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("host is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("host =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("host <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("host >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("host >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("host <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("host <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("host like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("host not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(java.util.List<java.lang.String> values) {
            addCriterion("host in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(java.util.List<java.lang.String> values) {
            addCriterion("host not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("host between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("host not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andRefererIsNull() {
            addCriterion("referer is null");
            return (Criteria) this;
        }

        public Criteria andRefererIsNotNull() {
            addCriterion("referer is not null");
            return (Criteria) this;
        }

        public Criteria andRefererEqualTo(String value) {
            addCriterion("referer =", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotEqualTo(String value) {
            addCriterion("referer <>", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThan(String value) {
            addCriterion("referer >", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThanOrEqualTo(String value) {
            addCriterion("referer >=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThan(String value) {
            addCriterion("referer <", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThanOrEqualTo(String value) {
            addCriterion("referer <=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLike(String value) {
            addCriterion("referer like", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotLike(String value) {
            addCriterion("referer not like", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererIn(java.util.List<java.lang.String> values) {
            addCriterion("referer in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotIn(java.util.List<java.lang.String> values) {
            addCriterion("referer not in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererBetween(String value1, String value2) {
            addCriterion("referer between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotBetween(String value1, String value2) {
            addCriterion("referer not between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNull() {
            addCriterion("user_agent is null");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNotNull() {
            addCriterion("user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgentEqualTo(String value) {
            addCriterion("user_agent =", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotEqualTo(String value) {
            addCriterion("user_agent <>", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThan(String value) {
            addCriterion("user_agent >", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("user_agent >=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThan(String value) {
            addCriterion("user_agent <", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThanOrEqualTo(String value) {
            addCriterion("user_agent <=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLike(String value) {
            addCriterion("user_agent like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotLike(String value) {
            addCriterion("user_agent not like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentIn(java.util.List<java.lang.String> values) {
            addCriterion("user_agent in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("user_agent not in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentBetween(String value1, String value2) {
            addCriterion("user_agent between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotBetween(String value1, String value2) {
            addCriterion("user_agent not between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialIsNull() {
            addCriterion("allow_credential is null");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialIsNotNull() {
            addCriterion("allow_credential is not null");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialEqualTo(String value) {
            addCriterion("allow_credential =", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialNotEqualTo(String value) {
            addCriterion("allow_credential <>", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialGreaterThan(String value) {
            addCriterion("allow_credential >", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialGreaterThanOrEqualTo(String value) {
            addCriterion("allow_credential >=", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialLessThan(String value) {
            addCriterion("allow_credential <", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialLessThanOrEqualTo(String value) {
            addCriterion("allow_credential <=", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialLike(String value) {
            addCriterion("allow_credential like", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialNotLike(String value) {
            addCriterion("allow_credential not like", value, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialIn(java.util.List<java.lang.String> values) {
            addCriterion("allow_credential in", values, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialNotIn(java.util.List<java.lang.String> values) {
            addCriterion("allow_credential not in", values, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialBetween(String value1, String value2) {
            addCriterion("allow_credential between", value1, value2, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialNotBetween(String value1, String value2) {
            addCriterion("allow_credential not between", value1, value2, "allowCredential");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginIsNull() {
            addCriterion("access_control_allow_origin is null");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginIsNotNull() {
            addCriterion("access_control_allow_origin is not null");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginEqualTo(String value) {
            addCriterion("access_control_allow_origin =", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginNotEqualTo(String value) {
            addCriterion("access_control_allow_origin <>", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginGreaterThan(String value) {
            addCriterion("access_control_allow_origin >", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginGreaterThanOrEqualTo(String value) {
            addCriterion("access_control_allow_origin >=", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginLessThan(String value) {
            addCriterion("access_control_allow_origin <", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginLessThanOrEqualTo(String value) {
            addCriterion("access_control_allow_origin <=", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginLike(String value) {
            addCriterion("access_control_allow_origin like", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginNotLike(String value) {
            addCriterion("access_control_allow_origin not like", value, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginIn(java.util.List<java.lang.String> values) {
            addCriterion("access_control_allow_origin in", values, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginNotIn(java.util.List<java.lang.String> values) {
            addCriterion("access_control_allow_origin not in", values, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginBetween(String value1, String value2) {
            addCriterion("access_control_allow_origin between", value1, value2, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andAccessControlAllowOriginNotBetween(String value1, String value2) {
            addCriterion("access_control_allow_origin not between", value1, value2, "accessControlAllowOrigin");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingIsNull() {
            addCriterion("transfer_encoding is null");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingIsNotNull() {
            addCriterion("transfer_encoding is not null");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingEqualTo(String value) {
            addCriterion("transfer_encoding =", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingNotEqualTo(String value) {
            addCriterion("transfer_encoding <>", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingGreaterThan(String value) {
            addCriterion("transfer_encoding >", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_encoding >=", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingLessThan(String value) {
            addCriterion("transfer_encoding <", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingLessThanOrEqualTo(String value) {
            addCriterion("transfer_encoding <=", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingLike(String value) {
            addCriterion("transfer_encoding like", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingNotLike(String value) {
            addCriterion("transfer_encoding not like", value, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingIn(java.util.List<java.lang.String> values) {
            addCriterion("transfer_encoding in", values, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingNotIn(java.util.List<java.lang.String> values) {
            addCriterion("transfer_encoding not in", values, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingBetween(String value1, String value2) {
            addCriterion("transfer_encoding between", value1, value2, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andTransferEncodingNotBetween(String value1, String value2) {
            addCriterion("transfer_encoding not between", value1, value2, "transferEncoding");
            return (Criteria) this;
        }

        public Criteria andVaryIsNull() {
            addCriterion("vary is null");
            return (Criteria) this;
        }

        public Criteria andVaryIsNotNull() {
            addCriterion("vary is not null");
            return (Criteria) this;
        }

        public Criteria andVaryEqualTo(String value) {
            addCriterion("vary =", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryNotEqualTo(String value) {
            addCriterion("vary <>", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryGreaterThan(String value) {
            addCriterion("vary >", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryGreaterThanOrEqualTo(String value) {
            addCriterion("vary >=", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryLessThan(String value) {
            addCriterion("vary <", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryLessThanOrEqualTo(String value) {
            addCriterion("vary <=", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryLike(String value) {
            addCriterion("vary like", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryNotLike(String value) {
            addCriterion("vary not like", value, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryIn(java.util.List<java.lang.String> values) {
            addCriterion("vary in", values, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryNotIn(java.util.List<java.lang.String> values) {
            addCriterion("vary not in", values, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryBetween(String value1, String value2) {
            addCriterion("vary between", value1, value2, "vary");
            return (Criteria) this;
        }

        public Criteria andVaryNotBetween(String value1, String value2) {
            addCriterion("vary not between", value1, value2, "vary");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextIsNull() {
            addCriterion("x_application_context is null");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextIsNotNull() {
            addCriterion("x_application_context is not null");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextEqualTo(String value) {
            addCriterion("x_application_context =", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextNotEqualTo(String value) {
            addCriterion("x_application_context <>", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextGreaterThan(String value) {
            addCriterion("x_application_context >", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextGreaterThanOrEqualTo(String value) {
            addCriterion("x_application_context >=", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextLessThan(String value) {
            addCriterion("x_application_context <", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextLessThanOrEqualTo(String value) {
            addCriterion("x_application_context <=", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextLike(String value) {
            addCriterion("x_application_context like", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextNotLike(String value) {
            addCriterion("x_application_context not like", value, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextIn(java.util.List<java.lang.String> values) {
            addCriterion("x_application_context in", values, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextNotIn(java.util.List<java.lang.String> values) {
            addCriterion("x_application_context not in", values, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextBetween(String value1, String value2) {
            addCriterion("x_application_context between", value1, value2, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andXApplicationContextNotBetween(String value1, String value2) {
            addCriterion("x_application_context not between", value1, value2, "xApplicationContext");
            return (Criteria) this;
        }

        public Criteria andDateOIsNull() {
            addCriterion("date_o is null");
            return (Criteria) this;
        }

        public Criteria andDateOIsNotNull() {
            addCriterion("date_o is not null");
            return (Criteria) this;
        }

        public Criteria andDateOEqualTo(Date value) {
            addCriterion("date_o =", value, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateONotEqualTo(Date value) {
            addCriterion("date_o <>", value, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateOGreaterThan(Date value) {
            addCriterion("date_o >", value, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateOGreaterThanOrEqualTo(Date value) {
            addCriterion("date_o >=", value, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateOLessThan(Date value) {
            addCriterion("date_o <", value, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateOLessThanOrEqualTo(Date value) {
            addCriterion("date_o <=", value, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateOIn(java.util.List<java.util.Date> values) {
            addCriterion("date_o in", values, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateONotIn(java.util.List<java.util.Date> values) {
            addCriterion("date_o not in", values, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateOBetween(Date value1, Date value2) {
            addCriterion("date_o between", value1, value2, "dateO");
            return (Criteria) this;
        }

        public Criteria andDateONotBetween(Date value1, Date value2) {
            addCriterion("date_o not between", value1, value2, "dateO");
            return (Criteria) this;
        }

        public Criteria andServerIsNull() {
            addCriterion("server is null");
            return (Criteria) this;
        }

        public Criteria andServerIsNotNull() {
            addCriterion("server is not null");
            return (Criteria) this;
        }

        public Criteria andServerEqualTo(String value) {
            addCriterion("server =", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotEqualTo(String value) {
            addCriterion("server <>", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerGreaterThan(String value) {
            addCriterion("server >", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerGreaterThanOrEqualTo(String value) {
            addCriterion("server >=", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLessThan(String value) {
            addCriterion("server <", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLessThanOrEqualTo(String value) {
            addCriterion("server <=", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLike(String value) {
            addCriterion("server like", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotLike(String value) {
            addCriterion("server not like", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerIn(java.util.List<java.lang.String> values) {
            addCriterion("server in", values, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotIn(java.util.List<java.lang.String> values) {
            addCriterion("server not in", values, "server");
            return (Criteria) this;
        }

        public Criteria andServerBetween(String value1, String value2) {
            addCriterion("server between", value1, value2, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotBetween(String value1, String value2) {
            addCriterion("server not between", value1, value2, "server");
            return (Criteria) this;
        }

        public Criteria andConnectionOIsNull() {
            addCriterion("connection_o is null");
            return (Criteria) this;
        }

        public Criteria andConnectionOIsNotNull() {
            addCriterion("connection_o is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionOEqualTo(String value) {
            addCriterion("connection_o =", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionONotEqualTo(String value) {
            addCriterion("connection_o <>", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionOGreaterThan(String value) {
            addCriterion("connection_o >", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionOGreaterThanOrEqualTo(String value) {
            addCriterion("connection_o >=", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionOLessThan(String value) {
            addCriterion("connection_o <", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionOLessThanOrEqualTo(String value) {
            addCriterion("connection_o <=", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionOLike(String value) {
            addCriterion("connection_o like", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionONotLike(String value) {
            addCriterion("connection_o not like", value, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionOIn(java.util.List<java.lang.String> values) {
            addCriterion("connection_o in", values, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionONotIn(java.util.List<java.lang.String> values) {
            addCriterion("connection_o not in", values, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionOBetween(String value1, String value2) {
            addCriterion("connection_o between", value1, value2, "connectionO");
            return (Criteria) this;
        }

        public Criteria andConnectionONotBetween(String value1, String value2) {
            addCriterion("connection_o not between", value1, value2, "connectionO");
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

        public Criteria andCacheControlIsNull() {
            addCriterion("cache_control is null");
            return (Criteria) this;
        }

        public Criteria andCacheControlIsNotNull() {
            addCriterion("cache_control is not null");
            return (Criteria) this;
        }

        public Criteria andCacheControlEqualTo(String value) {
            addCriterion("cache_control =", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlNotEqualTo(String value) {
            addCriterion("cache_control <>", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlGreaterThan(String value) {
            addCriterion("cache_control >", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlGreaterThanOrEqualTo(String value) {
            addCriterion("cache_control >=", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlLessThan(String value) {
            addCriterion("cache_control <", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlLessThanOrEqualTo(String value) {
            addCriterion("cache_control <=", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlLike(String value) {
            addCriterion("cache_control like", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlNotLike(String value) {
            addCriterion("cache_control not like", value, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlIn(java.util.List<java.lang.String> values) {
            addCriterion("cache_control in", values, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("cache_control not in", values, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlBetween(String value1, String value2) {
            addCriterion("cache_control between", value1, value2, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andCacheControlNotBetween(String value1, String value2) {
            addCriterion("cache_control not between", value1, value2, "cacheControl");
            return (Criteria) this;
        }

        public Criteria andXxxCIsNull() {
            addCriterion("xxx_c is null");
            return (Criteria) this;
        }

        public Criteria andXxxCIsNotNull() {
            addCriterion("xxx_c is not null");
            return (Criteria) this;
        }

        public Criteria andXxxCEqualTo(String value) {
            addCriterion("xxx_c =", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCNotEqualTo(String value) {
            addCriterion("xxx_c <>", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCGreaterThan(String value) {
            addCriterion("xxx_c >", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCGreaterThanOrEqualTo(String value) {
            addCriterion("xxx_c >=", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCLessThan(String value) {
            addCriterion("xxx_c <", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCLessThanOrEqualTo(String value) {
            addCriterion("xxx_c <=", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCLike(String value) {
            addCriterion("xxx_c like", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCNotLike(String value) {
            addCriterion("xxx_c not like", value, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCIn(java.util.List<java.lang.String> values) {
            addCriterion("xxx_c in", values, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCNotIn(java.util.List<java.lang.String> values) {
            addCriterion("xxx_c not in", values, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCBetween(String value1, String value2) {
            addCriterion("xxx_c between", value1, value2, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxCNotBetween(String value1, String value2) {
            addCriterion("xxx_c not between", value1, value2, "xxxC");
            return (Criteria) this;
        }

        public Criteria andXxxRIsNull() {
            addCriterion("xxx_r is null");
            return (Criteria) this;
        }

        public Criteria andXxxRIsNotNull() {
            addCriterion("xxx_r is not null");
            return (Criteria) this;
        }

        public Criteria andXxxREqualTo(String value) {
            addCriterion("xxx_r =", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRNotEqualTo(String value) {
            addCriterion("xxx_r <>", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRGreaterThan(String value) {
            addCriterion("xxx_r >", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRGreaterThanOrEqualTo(String value) {
            addCriterion("xxx_r >=", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRLessThan(String value) {
            addCriterion("xxx_r <", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRLessThanOrEqualTo(String value) {
            addCriterion("xxx_r <=", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRLike(String value) {
            addCriterion("xxx_r like", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRNotLike(String value) {
            addCriterion("xxx_r not like", value, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRIn(java.util.List<java.lang.String> values) {
            addCriterion("xxx_r in", values, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRNotIn(java.util.List<java.lang.String> values) {
            addCriterion("xxx_r not in", values, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRBetween(String value1, String value2) {
            addCriterion("xxx_r between", value1, value2, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxRNotBetween(String value1, String value2) {
            addCriterion("xxx_r not between", value1, value2, "xxxR");
            return (Criteria) this;
        }

        public Criteria andXxxSIsNull() {
            addCriterion("xxx_s is null");
            return (Criteria) this;
        }

        public Criteria andXxxSIsNotNull() {
            addCriterion("xxx_s is not null");
            return (Criteria) this;
        }

        public Criteria andXxxSEqualTo(String value) {
            addCriterion("xxx_s =", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSNotEqualTo(String value) {
            addCriterion("xxx_s <>", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSGreaterThan(String value) {
            addCriterion("xxx_s >", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSGreaterThanOrEqualTo(String value) {
            addCriterion("xxx_s >=", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSLessThan(String value) {
            addCriterion("xxx_s <", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSLessThanOrEqualTo(String value) {
            addCriterion("xxx_s <=", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSLike(String value) {
            addCriterion("xxx_s like", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSNotLike(String value) {
            addCriterion("xxx_s not like", value, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSIn(java.util.List<java.lang.String> values) {
            addCriterion("xxx_s in", values, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSNotIn(java.util.List<java.lang.String> values) {
            addCriterion("xxx_s not in", values, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSBetween(String value1, String value2) {
            addCriterion("xxx_s between", value1, value2, "xxxS");
            return (Criteria) this;
        }

        public Criteria andXxxSNotBetween(String value1, String value2) {
            addCriterion("xxx_s not between", value1, value2, "xxxS");
            return (Criteria) this;
        }

        public Criteria andDataChannelIsNull() {
            addCriterion("data_channel is null");
            return (Criteria) this;
        }

        public Criteria andDataChannelIsNotNull() {
            addCriterion("data_channel is not null");
            return (Criteria) this;
        }

        public Criteria andDataChannelEqualTo(String value) {
            addCriterion("data_channel =", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelNotEqualTo(String value) {
            addCriterion("data_channel <>", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelGreaterThan(String value) {
            addCriterion("data_channel >", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelGreaterThanOrEqualTo(String value) {
            addCriterion("data_channel >=", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelLessThan(String value) {
            addCriterion("data_channel <", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelLessThanOrEqualTo(String value) {
            addCriterion("data_channel <=", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelLike(String value) {
            addCriterion("data_channel like", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelNotLike(String value) {
            addCriterion("data_channel not like", value, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelIn(java.util.List<java.lang.String> values) {
            addCriterion("data_channel in", values, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelNotIn(java.util.List<java.lang.String> values) {
            addCriterion("data_channel not in", values, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelBetween(String value1, String value2) {
            addCriterion("data_channel between", value1, value2, "dataChannel");
            return (Criteria) this;
        }

        public Criteria andDataChannelNotBetween(String value1, String value2) {
            addCriterion("data_channel not between", value1, value2, "dataChannel");
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

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }
    }

    /**
    log_struct_tomcataddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
        public Criteria andFStatusIn(java.util.List<java.lang.String> values) {
            if(values.size()==1 && (null==values.get(0)|| values.get(0).equals(""))){
                return (Criteria) this;
            }
            addCriterion(" status in ", values, "status");
            return (Criteria) this;
        }
        public Criteria andFAppIdIn(java.util.List<java.lang.String> values) {
            if(values.size()==1 && (null==values.get(0)|| values.get(0).equals(""))){
                return (Criteria) this;
            }
            addCriterion("app_id in ", values, "appId");
            return (Criteria) this;
        }
        public Criteria andFTimeConsumGreaterThanOrEqualTo(Long value) {
            if(null==value || value==0){
                return (Criteria) this;
            }
            addCriterion("time_consum >=", value, "timeConsum");
            return (Criteria) this;
        }
        public Criteria andFTimeConsumLessThanOrEqualTo(Long value) {
            if(null==value || value==0){
                return (Criteria) this;
            }
            addCriterion("time_consum <=", value, "timeConsum");
            return (Criteria) this;
        }
    }
}