package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogStructApacheExample extends com.hengyunsoft.db.example.BaseExample<LogStructApacheExample.Criteria> implements Serializable {
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

        public Criteria andSendByteIsNull() {
            addCriterion("send_byte is null");
            return (Criteria) this;
        }

        public Criteria andSendByteIsNotNull() {
            addCriterion("send_byte is not null");
            return (Criteria) this;
        }

        public Criteria andSendByteEqualTo(String value) {
            addCriterion("send_byte =", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteNotEqualTo(String value) {
            addCriterion("send_byte <>", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteGreaterThan(String value) {
            addCriterion("send_byte >", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteGreaterThanOrEqualTo(String value) {
            addCriterion("send_byte >=", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteLessThan(String value) {
            addCriterion("send_byte <", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteLessThanOrEqualTo(String value) {
            addCriterion("send_byte <=", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteLike(String value) {
            addCriterion("send_byte like", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteNotLike(String value) {
            addCriterion("send_byte not like", value, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteIn(java.util.List<java.lang.String> values) {
            addCriterion("send_byte in", values, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteNotIn(java.util.List<java.lang.String> values) {
            addCriterion("send_byte not in", values, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteBetween(String value1, String value2) {
            addCriterion("send_byte between", value1, value2, "sendByte");
            return (Criteria) this;
        }

        public Criteria andSendByteNotBetween(String value1, String value2) {
            addCriterion("send_byte not between", value1, value2, "sendByte");
            return (Criteria) this;
        }

        public Criteria andFoobarEIsNull() {
            addCriterion("foobar_e is null");
            return (Criteria) this;
        }

        public Criteria andFoobarEIsNotNull() {
            addCriterion("foobar_e is not null");
            return (Criteria) this;
        }

        public Criteria andFoobarEEqualTo(String value) {
            addCriterion("foobar_e =", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarENotEqualTo(String value) {
            addCriterion("foobar_e <>", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarEGreaterThan(String value) {
            addCriterion("foobar_e >", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarEGreaterThanOrEqualTo(String value) {
            addCriterion("foobar_e >=", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarELessThan(String value) {
            addCriterion("foobar_e <", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarELessThanOrEqualTo(String value) {
            addCriterion("foobar_e <=", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarELike(String value) {
            addCriterion("foobar_e like", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarENotLike(String value) {
            addCriterion("foobar_e not like", value, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarEIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_e in", values, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarENotIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_e not in", values, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarEBetween(String value1, String value2) {
            addCriterion("foobar_e between", value1, value2, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarENotBetween(String value1, String value2) {
            addCriterion("foobar_e not between", value1, value2, "foobarE");
            return (Criteria) this;
        }

        public Criteria andFoobarIIsNull() {
            addCriterion("foobar_i is null");
            return (Criteria) this;
        }

        public Criteria andFoobarIIsNotNull() {
            addCriterion("foobar_i is not null");
            return (Criteria) this;
        }

        public Criteria andFoobarIEqualTo(String value) {
            addCriterion("foobar_i =", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarINotEqualTo(String value) {
            addCriterion("foobar_i <>", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarIGreaterThan(String value) {
            addCriterion("foobar_i >", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarIGreaterThanOrEqualTo(String value) {
            addCriterion("foobar_i >=", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarILessThan(String value) {
            addCriterion("foobar_i <", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarILessThanOrEqualTo(String value) {
            addCriterion("foobar_i <=", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarILike(String value) {
            addCriterion("foobar_i like", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarINotLike(String value) {
            addCriterion("foobar_i not like", value, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarIIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_i in", values, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarINotIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_i not in", values, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarIBetween(String value1, String value2) {
            addCriterion("foobar_i between", value1, value2, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarINotBetween(String value1, String value2) {
            addCriterion("foobar_i not between", value1, value2, "foobarI");
            return (Criteria) this;
        }

        public Criteria andFoobarNIsNull() {
            addCriterion("foobar_n is null");
            return (Criteria) this;
        }

        public Criteria andFoobarNIsNotNull() {
            addCriterion("foobar_n is not null");
            return (Criteria) this;
        }

        public Criteria andFoobarNEqualTo(String value) {
            addCriterion("foobar_n =", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNNotEqualTo(String value) {
            addCriterion("foobar_n <>", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNGreaterThan(String value) {
            addCriterion("foobar_n >", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNGreaterThanOrEqualTo(String value) {
            addCriterion("foobar_n >=", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNLessThan(String value) {
            addCriterion("foobar_n <", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNLessThanOrEqualTo(String value) {
            addCriterion("foobar_n <=", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNLike(String value) {
            addCriterion("foobar_n like", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNNotLike(String value) {
            addCriterion("foobar_n not like", value, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_n in", values, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNNotIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_n not in", values, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNBetween(String value1, String value2) {
            addCriterion("foobar_n between", value1, value2, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarNNotBetween(String value1, String value2) {
            addCriterion("foobar_n not between", value1, value2, "foobarN");
            return (Criteria) this;
        }

        public Criteria andFoobarOIsNull() {
            addCriterion("foobar_o is null");
            return (Criteria) this;
        }

        public Criteria andFoobarOIsNotNull() {
            addCriterion("foobar_o is not null");
            return (Criteria) this;
        }

        public Criteria andFoobarOEqualTo(String value) {
            addCriterion("foobar_o =", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarONotEqualTo(String value) {
            addCriterion("foobar_o <>", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarOGreaterThan(String value) {
            addCriterion("foobar_o >", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarOGreaterThanOrEqualTo(String value) {
            addCriterion("foobar_o >=", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarOLessThan(String value) {
            addCriterion("foobar_o <", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarOLessThanOrEqualTo(String value) {
            addCriterion("foobar_o <=", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarOLike(String value) {
            addCriterion("foobar_o like", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarONotLike(String value) {
            addCriterion("foobar_o not like", value, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarOIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_o in", values, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarONotIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_o not in", values, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarOBetween(String value1, String value2) {
            addCriterion("foobar_o between", value1, value2, "foobarO");
            return (Criteria) this;
        }

        public Criteria andFoobarONotBetween(String value1, String value2) {
            addCriterion("foobar_o not between", value1, value2, "foobarO");
            return (Criteria) this;
        }

        public Criteria andClfByteCountIsNull() {
            addCriterion("clf_byte_count is null");
            return (Criteria) this;
        }

        public Criteria andClfByteCountIsNotNull() {
            addCriterion("clf_byte_count is not null");
            return (Criteria) this;
        }

        public Criteria andClfByteCountEqualTo(String value) {
            addCriterion("clf_byte_count =", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountNotEqualTo(String value) {
            addCriterion("clf_byte_count <>", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountGreaterThan(String value) {
            addCriterion("clf_byte_count >", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountGreaterThanOrEqualTo(String value) {
            addCriterion("clf_byte_count >=", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountLessThan(String value) {
            addCriterion("clf_byte_count <", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountLessThanOrEqualTo(String value) {
            addCriterion("clf_byte_count <=", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountLike(String value) {
            addCriterion("clf_byte_count like", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountNotLike(String value) {
            addCriterion("clf_byte_count not like", value, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountIn(java.util.List<java.lang.String> values) {
            addCriterion("clf_byte_count in", values, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountNotIn(java.util.List<java.lang.String> values) {
            addCriterion("clf_byte_count not in", values, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountBetween(String value1, String value2) {
            addCriterion("clf_byte_count between", value1, value2, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andClfByteCountNotBetween(String value1, String value2) {
            addCriterion("clf_byte_count not between", value1, value2, "clfByteCount");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(java.util.List<java.lang.String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
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

        public Criteria andRemoteLoginNameIsNull() {
            addCriterion("remote_login_name is null");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameIsNotNull() {
            addCriterion("remote_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameEqualTo(String value) {
            addCriterion("remote_login_name =", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameNotEqualTo(String value) {
            addCriterion("remote_login_name <>", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameGreaterThan(String value) {
            addCriterion("remote_login_name >", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("remote_login_name >=", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameLessThan(String value) {
            addCriterion("remote_login_name <", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameLessThanOrEqualTo(String value) {
            addCriterion("remote_login_name <=", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameLike(String value) {
            addCriterion("remote_login_name like", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameNotLike(String value) {
            addCriterion("remote_login_name not like", value, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_login_name in", values, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_login_name not in", values, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameBetween(String value1, String value2) {
            addCriterion("remote_login_name between", value1, value2, "remoteLoginName");
            return (Criteria) this;
        }

        public Criteria andRemoteLoginNameNotBetween(String value1, String value2) {
            addCriterion("remote_login_name not between", value1, value2, "remoteLoginName");
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

        public Criteria andThreadIdIsNull() {
            addCriterion("thread_id is null");
            return (Criteria) this;
        }

        public Criteria andThreadIdIsNotNull() {
            addCriterion("thread_id is not null");
            return (Criteria) this;
        }

        public Criteria andThreadIdEqualTo(String value) {
            addCriterion("thread_id =", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotEqualTo(String value) {
            addCriterion("thread_id <>", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdGreaterThan(String value) {
            addCriterion("thread_id >", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdGreaterThanOrEqualTo(String value) {
            addCriterion("thread_id >=", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdLessThan(String value) {
            addCriterion("thread_id <", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdLessThanOrEqualTo(String value) {
            addCriterion("thread_id <=", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdLike(String value) {
            addCriterion("thread_id like", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotLike(String value) {
            addCriterion("thread_id not like", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdIn(java.util.List<java.lang.String> values) {
            addCriterion("thread_id in", values, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("thread_id not in", values, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdBetween(String value1, String value2) {
            addCriterion("thread_id between", value1, value2, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotBetween(String value1, String value2) {
            addCriterion("thread_id not between", value1, value2, "threadId");
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

        public Criteria andReqFirstLineIsNull() {
            addCriterion("req_first_line is null");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineIsNotNull() {
            addCriterion("req_first_line is not null");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineEqualTo(String value) {
            addCriterion("req_first_line =", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineNotEqualTo(String value) {
            addCriterion("req_first_line <>", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineGreaterThan(String value) {
            addCriterion("req_first_line >", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineGreaterThanOrEqualTo(String value) {
            addCriterion("req_first_line >=", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineLessThan(String value) {
            addCriterion("req_first_line <", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineLessThanOrEqualTo(String value) {
            addCriterion("req_first_line <=", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineLike(String value) {
            addCriterion("req_first_line like", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineNotLike(String value) {
            addCriterion("req_first_line not like", value, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineIn(java.util.List<java.lang.String> values) {
            addCriterion("req_first_line in", values, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineNotIn(java.util.List<java.lang.String> values) {
            addCriterion("req_first_line not in", values, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineBetween(String value1, String value2) {
            addCriterion("req_first_line between", value1, value2, "reqFirstLine");
            return (Criteria) this;
        }

        public Criteria andReqFirstLineNotBetween(String value1, String value2) {
            addCriterion("req_first_line not between", value1, value2, "reqFirstLine");
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

        public Criteria andRemoteUserIsNull() {
            addCriterion("remote_user is null");
            return (Criteria) this;
        }

        public Criteria andRemoteUserIsNotNull() {
            addCriterion("remote_user is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteUserEqualTo(String value) {
            addCriterion("remote_user =", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotEqualTo(String value) {
            addCriterion("remote_user <>", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserGreaterThan(String value) {
            addCriterion("remote_user >", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserGreaterThanOrEqualTo(String value) {
            addCriterion("remote_user >=", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserLessThan(String value) {
            addCriterion("remote_user <", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserLessThanOrEqualTo(String value) {
            addCriterion("remote_user <=", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserLike(String value) {
            addCriterion("remote_user like", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotLike(String value) {
            addCriterion("remote_user not like", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_user in", values, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_user not in", values, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserBetween(String value1, String value2) {
            addCriterion("remote_user between", value1, value2, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotBetween(String value1, String value2) {
            addCriterion("remote_user not between", value1, value2, "remoteUser");
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

        public Criteria andRspServerNameIsNull() {
            addCriterion("rsp_server_name is null");
            return (Criteria) this;
        }

        public Criteria andRspServerNameIsNotNull() {
            addCriterion("rsp_server_name is not null");
            return (Criteria) this;
        }

        public Criteria andRspServerNameEqualTo(String value) {
            addCriterion("rsp_server_name =", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameNotEqualTo(String value) {
            addCriterion("rsp_server_name <>", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameGreaterThan(String value) {
            addCriterion("rsp_server_name >", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("rsp_server_name >=", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameLessThan(String value) {
            addCriterion("rsp_server_name <", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameLessThanOrEqualTo(String value) {
            addCriterion("rsp_server_name <=", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameLike(String value) {
            addCriterion("rsp_server_name like", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameNotLike(String value) {
            addCriterion("rsp_server_name not like", value, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameIn(java.util.List<java.lang.String> values) {
            addCriterion("rsp_server_name in", values, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("rsp_server_name not in", values, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameBetween(String value1, String value2) {
            addCriterion("rsp_server_name between", value1, value2, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andRspServerNameNotBetween(String value1, String value2) {
            addCriterion("rsp_server_name not between", value1, value2, "rspServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameIsNull() {
            addCriterion("ucn_server_name is null");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameIsNotNull() {
            addCriterion("ucn_server_name is not null");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameEqualTo(String value) {
            addCriterion("ucn_server_name =", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameNotEqualTo(String value) {
            addCriterion("ucn_server_name <>", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameGreaterThan(String value) {
            addCriterion("ucn_server_name >", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("ucn_server_name >=", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameLessThan(String value) {
            addCriterion("ucn_server_name <", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameLessThanOrEqualTo(String value) {
            addCriterion("ucn_server_name <=", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameLike(String value) {
            addCriterion("ucn_server_name like", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameNotLike(String value) {
            addCriterion("ucn_server_name not like", value, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameIn(java.util.List<java.lang.String> values) {
            addCriterion("ucn_server_name in", values, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ucn_server_name not in", values, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameBetween(String value1, String value2) {
            addCriterion("ucn_server_name between", value1, value2, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andUcnServerNameNotBetween(String value1, String value2) {
            addCriterion("ucn_server_name not between", value1, value2, "ucnServerName");
            return (Criteria) this;
        }

        public Criteria andPercentSignIsNull() {
            addCriterion("percent_sign is null");
            return (Criteria) this;
        }

        public Criteria andPercentSignIsNotNull() {
            addCriterion("percent_sign is not null");
            return (Criteria) this;
        }

        public Criteria andPercentSignEqualTo(String value) {
            addCriterion("percent_sign =", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignNotEqualTo(String value) {
            addCriterion("percent_sign <>", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignGreaterThan(String value) {
            addCriterion("percent_sign >", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignGreaterThanOrEqualTo(String value) {
            addCriterion("percent_sign >=", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignLessThan(String value) {
            addCriterion("percent_sign <", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignLessThanOrEqualTo(String value) {
            addCriterion("percent_sign <=", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignLike(String value) {
            addCriterion("percent_sign like", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignNotLike(String value) {
            addCriterion("percent_sign not like", value, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignIn(java.util.List<java.lang.String> values) {
            addCriterion("percent_sign in", values, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignNotIn(java.util.List<java.lang.String> values) {
            addCriterion("percent_sign not in", values, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignBetween(String value1, String value2) {
            addCriterion("percent_sign between", value1, value2, "percentSign");
            return (Criteria) this;
        }

        public Criteria andPercentSignNotBetween(String value1, String value2) {
            addCriterion("percent_sign not between", value1, value2, "percentSign");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsIsNull() {
            addCriterion("microseconds is null");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsIsNotNull() {
            addCriterion("microseconds is not null");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsEqualTo(Long value) {
            addCriterion("microseconds =", value, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsNotEqualTo(Long value) {
            addCriterion("microseconds <>", value, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsGreaterThan(Long value) {
            addCriterion("microseconds >", value, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsGreaterThanOrEqualTo(Long value) {
            addCriterion("microseconds >=", value, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsLessThan(Long value) {
            addCriterion("microseconds <", value, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsLessThanOrEqualTo(Long value) {
            addCriterion("microseconds <=", value, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsIn(java.util.List<java.lang.Long> values) {
            addCriterion("microseconds in", values, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("microseconds not in", values, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsBetween(Long value1, Long value2) {
            addCriterion("microseconds between", value1, value2, "microseconds");
            return (Criteria) this;
        }

        public Criteria andMicrosecondsNotBetween(Long value1, Long value2) {
            addCriterion("microseconds not between", value1, value2, "microseconds");
            return (Criteria) this;
        }

        public Criteria andKeepAliveIsNull() {
            addCriterion("keep_alive is null");
            return (Criteria) this;
        }

        public Criteria andKeepAliveIsNotNull() {
            addCriterion("keep_alive is not null");
            return (Criteria) this;
        }

        public Criteria andKeepAliveEqualTo(String value) {
            addCriterion("keep_alive =", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveNotEqualTo(String value) {
            addCriterion("keep_alive <>", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveGreaterThan(String value) {
            addCriterion("keep_alive >", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveGreaterThanOrEqualTo(String value) {
            addCriterion("keep_alive >=", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveLessThan(String value) {
            addCriterion("keep_alive <", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveLessThanOrEqualTo(String value) {
            addCriterion("keep_alive <=", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveLike(String value) {
            addCriterion("keep_alive like", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveNotLike(String value) {
            addCriterion("keep_alive not like", value, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveIn(java.util.List<java.lang.String> values) {
            addCriterion("keep_alive in", values, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveNotIn(java.util.List<java.lang.String> values) {
            addCriterion("keep_alive not in", values, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveBetween(String value1, String value2) {
            addCriterion("keep_alive between", value1, value2, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andKeepAliveNotBetween(String value1, String value2) {
            addCriterion("keep_alive not between", value1, value2, "keepAlive");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateIsNull() {
            addCriterion("response_generate is null");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateIsNotNull() {
            addCriterion("response_generate is not null");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateEqualTo(String value) {
            addCriterion("response_generate =", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateNotEqualTo(String value) {
            addCriterion("response_generate <>", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateGreaterThan(String value) {
            addCriterion("response_generate >", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateGreaterThanOrEqualTo(String value) {
            addCriterion("response_generate >=", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateLessThan(String value) {
            addCriterion("response_generate <", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateLessThanOrEqualTo(String value) {
            addCriterion("response_generate <=", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateLike(String value) {
            addCriterion("response_generate like", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateNotLike(String value) {
            addCriterion("response_generate not like", value, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateIn(java.util.List<java.lang.String> values) {
            addCriterion("response_generate in", values, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateNotIn(java.util.List<java.lang.String> values) {
            addCriterion("response_generate not in", values, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateBetween(String value1, String value2) {
            addCriterion("response_generate between", value1, value2, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andResponseGenerateNotBetween(String value1, String value2) {
            addCriterion("response_generate not between", value1, value2, "responseGenerate");
            return (Criteria) this;
        }

        public Criteria andServingIsNull() {
            addCriterion("serving is null");
            return (Criteria) this;
        }

        public Criteria andServingIsNotNull() {
            addCriterion("serving is not null");
            return (Criteria) this;
        }

        public Criteria andServingEqualTo(String value) {
            addCriterion("serving =", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingNotEqualTo(String value) {
            addCriterion("serving <>", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingGreaterThan(String value) {
            addCriterion("serving >", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingGreaterThanOrEqualTo(String value) {
            addCriterion("serving >=", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingLessThan(String value) {
            addCriterion("serving <", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingLessThanOrEqualTo(String value) {
            addCriterion("serving <=", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingLike(String value) {
            addCriterion("serving like", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingNotLike(String value) {
            addCriterion("serving not like", value, "serving");
            return (Criteria) this;
        }

        public Criteria andServingIn(java.util.List<java.lang.String> values) {
            addCriterion("serving in", values, "serving");
            return (Criteria) this;
        }

        public Criteria andServingNotIn(java.util.List<java.lang.String> values) {
            addCriterion("serving not in", values, "serving");
            return (Criteria) this;
        }

        public Criteria andServingBetween(String value1, String value2) {
            addCriterion("serving between", value1, value2, "serving");
            return (Criteria) this;
        }

        public Criteria andServingNotBetween(String value1, String value2) {
            addCriterion("serving not between", value1, value2, "serving");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedIsNull() {
            addCriterion("response_completed is null");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedIsNotNull() {
            addCriterion("response_completed is not null");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedEqualTo(String value) {
            addCriterion("response_completed =", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedNotEqualTo(String value) {
            addCriterion("response_completed <>", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedGreaterThan(String value) {
            addCriterion("response_completed >", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedGreaterThanOrEqualTo(String value) {
            addCriterion("response_completed >=", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedLessThan(String value) {
            addCriterion("response_completed <", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedLessThanOrEqualTo(String value) {
            addCriterion("response_completed <=", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedLike(String value) {
            addCriterion("response_completed like", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedNotLike(String value) {
            addCriterion("response_completed not like", value, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedIn(java.util.List<java.lang.String> values) {
            addCriterion("response_completed in", values, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedNotIn(java.util.List<java.lang.String> values) {
            addCriterion("response_completed not in", values, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedBetween(String value1, String value2) {
            addCriterion("response_completed between", value1, value2, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andResponseCompletedNotBetween(String value1, String value2) {
            addCriterion("response_completed not between", value1, value2, "responseCompleted");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedIsNull() {
            addCriterion("bytes_received is null");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedIsNotNull() {
            addCriterion("bytes_received is not null");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedEqualTo(String value) {
            addCriterion("bytes_received =", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedNotEqualTo(String value) {
            addCriterion("bytes_received <>", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedGreaterThan(String value) {
            addCriterion("bytes_received >", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedGreaterThanOrEqualTo(String value) {
            addCriterion("bytes_received >=", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedLessThan(String value) {
            addCriterion("bytes_received <", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedLessThanOrEqualTo(String value) {
            addCriterion("bytes_received <=", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedLike(String value) {
            addCriterion("bytes_received like", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedNotLike(String value) {
            addCriterion("bytes_received not like", value, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedIn(java.util.List<java.lang.String> values) {
            addCriterion("bytes_received in", values, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedNotIn(java.util.List<java.lang.String> values) {
            addCriterion("bytes_received not in", values, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedBetween(String value1, String value2) {
            addCriterion("bytes_received between", value1, value2, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesReceivedNotBetween(String value1, String value2) {
            addCriterion("bytes_received not between", value1, value2, "bytesReceived");
            return (Criteria) this;
        }

        public Criteria andBytesSentIsNull() {
            addCriterion("bytes_sent is null");
            return (Criteria) this;
        }

        public Criteria andBytesSentIsNotNull() {
            addCriterion("bytes_sent is not null");
            return (Criteria) this;
        }

        public Criteria andBytesSentEqualTo(String value) {
            addCriterion("bytes_sent =", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotEqualTo(String value) {
            addCriterion("bytes_sent <>", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentGreaterThan(String value) {
            addCriterion("bytes_sent >", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentGreaterThanOrEqualTo(String value) {
            addCriterion("bytes_sent >=", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentLessThan(String value) {
            addCriterion("bytes_sent <", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentLessThanOrEqualTo(String value) {
            addCriterion("bytes_sent <=", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentLike(String value) {
            addCriterion("bytes_sent like", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotLike(String value) {
            addCriterion("bytes_sent not like", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentIn(java.util.List<java.lang.String> values) {
            addCriterion("bytes_sent in", values, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("bytes_sent not in", values, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentBetween(String value1, String value2) {
            addCriterion("bytes_sent between", value1, value2, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotBetween(String value1, String value2) {
            addCriterion("bytes_sent not between", value1, value2, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andVarnameTiIsNull() {
            addCriterion("varname_ti is null");
            return (Criteria) this;
        }

        public Criteria andVarnameTiIsNotNull() {
            addCriterion("varname_ti is not null");
            return (Criteria) this;
        }

        public Criteria andVarnameTiEqualTo(String value) {
            addCriterion("varname_ti =", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiNotEqualTo(String value) {
            addCriterion("varname_ti <>", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiGreaterThan(String value) {
            addCriterion("varname_ti >", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiGreaterThanOrEqualTo(String value) {
            addCriterion("varname_ti >=", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiLessThan(String value) {
            addCriterion("varname_ti <", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiLessThanOrEqualTo(String value) {
            addCriterion("varname_ti <=", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiLike(String value) {
            addCriterion("varname_ti like", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiNotLike(String value) {
            addCriterion("varname_ti not like", value, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiIn(java.util.List<java.lang.String> values) {
            addCriterion("varname_ti in", values, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiNotIn(java.util.List<java.lang.String> values) {
            addCriterion("varname_ti not in", values, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiBetween(String value1, String value2) {
            addCriterion("varname_ti between", value1, value2, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameTiNotBetween(String value1, String value2) {
            addCriterion("varname_ti not between", value1, value2, "varnameTi");
            return (Criteria) this;
        }

        public Criteria andVarnameToIsNull() {
            addCriterion("varname_to is null");
            return (Criteria) this;
        }

        public Criteria andVarnameToIsNotNull() {
            addCriterion("varname_to is not null");
            return (Criteria) this;
        }

        public Criteria andVarnameToEqualTo(String value) {
            addCriterion("varname_to =", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToNotEqualTo(String value) {
            addCriterion("varname_to <>", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToGreaterThan(String value) {
            addCriterion("varname_to >", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToGreaterThanOrEqualTo(String value) {
            addCriterion("varname_to >=", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToLessThan(String value) {
            addCriterion("varname_to <", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToLessThanOrEqualTo(String value) {
            addCriterion("varname_to <=", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToLike(String value) {
            addCriterion("varname_to like", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToNotLike(String value) {
            addCriterion("varname_to not like", value, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToIn(java.util.List<java.lang.String> values) {
            addCriterion("varname_to in", values, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("varname_to not in", values, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToBetween(String value1, String value2) {
            addCriterion("varname_to between", value1, value2, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andVarnameToNotBetween(String value1, String value2) {
            addCriterion("varname_to not between", value1, value2, "varnameTo");
            return (Criteria) this;
        }

        public Criteria andUnitTIsNull() {
            addCriterion("unit_t is null");
            return (Criteria) this;
        }

        public Criteria andUnitTIsNotNull() {
            addCriterion("unit_t is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTEqualTo(String value) {
            addCriterion("unit_t =", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTNotEqualTo(String value) {
            addCriterion("unit_t <>", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTGreaterThan(String value) {
            addCriterion("unit_t >", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTGreaterThanOrEqualTo(String value) {
            addCriterion("unit_t >=", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTLessThan(String value) {
            addCriterion("unit_t <", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTLessThanOrEqualTo(String value) {
            addCriterion("unit_t <=", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTLike(String value) {
            addCriterion("unit_t like", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTNotLike(String value) {
            addCriterion("unit_t not like", value, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_t in", values, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTNotIn(java.util.List<java.lang.String> values) {
            addCriterion("unit_t not in", values, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTBetween(String value1, String value2) {
            addCriterion("unit_t between", value1, value2, "unitT");
            return (Criteria) this;
        }

        public Criteria andUnitTNotBetween(String value1, String value2) {
            addCriterion("unit_t not between", value1, value2, "unitT");
            return (Criteria) this;
        }

        public Criteria andFormatPIsNull() {
            addCriterion("format_p is null");
            return (Criteria) this;
        }

        public Criteria andFormatPIsNotNull() {
            addCriterion("format_p is not null");
            return (Criteria) this;
        }

        public Criteria andFormatPEqualTo(String value) {
            addCriterion("format_p =", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPNotEqualTo(String value) {
            addCriterion("format_p <>", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPGreaterThan(String value) {
            addCriterion("format_p >", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPGreaterThanOrEqualTo(String value) {
            addCriterion("format_p >=", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPLessThan(String value) {
            addCriterion("format_p <", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPLessThanOrEqualTo(String value) {
            addCriterion("format_p <=", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPLike(String value) {
            addCriterion("format_p like", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPNotLike(String value) {
            addCriterion("format_p not like", value, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPIn(java.util.List<java.lang.String> values) {
            addCriterion("format_p in", values, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPNotIn(java.util.List<java.lang.String> values) {
            addCriterion("format_p not in", values, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPBetween(String value1, String value2) {
            addCriterion("format_p between", value1, value2, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatPNotBetween(String value1, String value2) {
            addCriterion("format_p not between", value1, value2, "formatP");
            return (Criteria) this;
        }

        public Criteria andFormatBigpIsNull() {
            addCriterion("format_bigp is null");
            return (Criteria) this;
        }

        public Criteria andFormatBigpIsNotNull() {
            addCriterion("format_bigp is not null");
            return (Criteria) this;
        }

        public Criteria andFormatBigpEqualTo(String value) {
            addCriterion("format_bigp =", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpNotEqualTo(String value) {
            addCriterion("format_bigp <>", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpGreaterThan(String value) {
            addCriterion("format_bigp >", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpGreaterThanOrEqualTo(String value) {
            addCriterion("format_bigp >=", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpLessThan(String value) {
            addCriterion("format_bigp <", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpLessThanOrEqualTo(String value) {
            addCriterion("format_bigp <=", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpLike(String value) {
            addCriterion("format_bigp like", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpNotLike(String value) {
            addCriterion("format_bigp not like", value, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpIn(java.util.List<java.lang.String> values) {
            addCriterion("format_bigp in", values, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpNotIn(java.util.List<java.lang.String> values) {
            addCriterion("format_bigp not in", values, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpBetween(String value1, String value2) {
            addCriterion("format_bigp between", value1, value2, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFormatBigpNotBetween(String value1, String value2) {
            addCriterion("format_bigp not between", value1, value2, "formatBigp");
            return (Criteria) this;
        }

        public Criteria andFoobarCIsNull() {
            addCriterion("foobar_c is null");
            return (Criteria) this;
        }

        public Criteria andFoobarCIsNotNull() {
            addCriterion("foobar_c is not null");
            return (Criteria) this;
        }

        public Criteria andFoobarCEqualTo(String value) {
            addCriterion("foobar_c =", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCNotEqualTo(String value) {
            addCriterion("foobar_c <>", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCGreaterThan(String value) {
            addCriterion("foobar_c >", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCGreaterThanOrEqualTo(String value) {
            addCriterion("foobar_c >=", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCLessThan(String value) {
            addCriterion("foobar_c <", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCLessThanOrEqualTo(String value) {
            addCriterion("foobar_c <=", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCLike(String value) {
            addCriterion("foobar_c like", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCNotLike(String value) {
            addCriterion("foobar_c not like", value, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_c in", values, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCNotIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_c not in", values, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCBetween(String value1, String value2) {
            addCriterion("foobar_c between", value1, value2, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarCNotBetween(String value1, String value2) {
            addCriterion("foobar_c not between", value1, value2, "foobarC");
            return (Criteria) this;
        }

        public Criteria andFoobarTIsNull() {
            addCriterion("foobar_t is null");
            return (Criteria) this;
        }

        public Criteria andFoobarTIsNotNull() {
            addCriterion("foobar_t is not null");
            return (Criteria) this;
        }

        public Criteria andFoobarTEqualTo(String value) {
            addCriterion("foobar_t =", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTNotEqualTo(String value) {
            addCriterion("foobar_t <>", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTGreaterThan(String value) {
            addCriterion("foobar_t >", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTGreaterThanOrEqualTo(String value) {
            addCriterion("foobar_t >=", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTLessThan(String value) {
            addCriterion("foobar_t <", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTLessThanOrEqualTo(String value) {
            addCriterion("foobar_t <=", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTLike(String value) {
            addCriterion("foobar_t like", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTNotLike(String value) {
            addCriterion("foobar_t not like", value, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_t in", values, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTNotIn(java.util.List<java.lang.String> values) {
            addCriterion("foobar_t not in", values, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTBetween(String value1, String value2) {
            addCriterion("foobar_t between", value1, value2, "foobarT");
            return (Criteria) this;
        }

        public Criteria andFoobarTNotBetween(String value1, String value2) {
            addCriterion("foobar_t not between", value1, value2, "foobarT");
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

        public Criteria andHostNameIsNull() {
            addCriterion("host_name is null");
            return (Criteria) this;
        }

        public Criteria andHostNameIsNotNull() {
            addCriterion("host_name is not null");
            return (Criteria) this;
        }

        public Criteria andHostNameEqualTo(String value) {
            addCriterion("host_name =", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotEqualTo(String value) {
            addCriterion("host_name <>", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameGreaterThan(String value) {
            addCriterion("host_name >", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameGreaterThanOrEqualTo(String value) {
            addCriterion("host_name >=", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLessThan(String value) {
            addCriterion("host_name <", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLessThanOrEqualTo(String value) {
            addCriterion("host_name <=", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameLike(String value) {
            addCriterion("host_name like", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotLike(String value) {
            addCriterion("host_name not like", value, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameIn(java.util.List<java.lang.String> values) {
            addCriterion("host_name in", values, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("host_name not in", values, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameBetween(String value1, String value2) {
            addCriterion("host_name between", value1, value2, "hostName");
            return (Criteria) this;
        }

        public Criteria andHostNameNotBetween(String value1, String value2) {
            addCriterion("host_name not between", value1, value2, "hostName");
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

        public Criteria andAllowCredentialsIsNull() {
            addCriterion("allow_credentials is null");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsIsNotNull() {
            addCriterion("allow_credentials is not null");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsEqualTo(String value) {
            addCriterion("allow_credentials =", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsNotEqualTo(String value) {
            addCriterion("allow_credentials <>", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsGreaterThan(String value) {
            addCriterion("allow_credentials >", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsGreaterThanOrEqualTo(String value) {
            addCriterion("allow_credentials >=", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsLessThan(String value) {
            addCriterion("allow_credentials <", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsLessThanOrEqualTo(String value) {
            addCriterion("allow_credentials <=", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsLike(String value) {
            addCriterion("allow_credentials like", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsNotLike(String value) {
            addCriterion("allow_credentials not like", value, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsIn(java.util.List<java.lang.String> values) {
            addCriterion("allow_credentials in", values, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsNotIn(java.util.List<java.lang.String> values) {
            addCriterion("allow_credentials not in", values, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsBetween(String value1, String value2) {
            addCriterion("allow_credentials between", value1, value2, "allowCredentials");
            return (Criteria) this;
        }

        public Criteria andAllowCredentialsNotBetween(String value1, String value2) {
            addCriterion("allow_credentials not between", value1, value2, "allowCredentials");
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
    log_struct_apacheaddClassComment 472
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