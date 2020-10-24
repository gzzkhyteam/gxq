package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogStructNginxExample extends com.hengyunsoft.db.example.BaseExample<LogStructNginxExample.Criteria> implements Serializable {
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

        public Criteria andRemoteAddrIsNull() {
            addCriterion("remote_addr is null");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrIsNotNull() {
            addCriterion("remote_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrEqualTo(String value) {
            addCriterion("remote_addr =", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotEqualTo(String value) {
            addCriterion("remote_addr <>", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrGreaterThan(String value) {
            addCriterion("remote_addr >", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrGreaterThanOrEqualTo(String value) {
            addCriterion("remote_addr >=", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLessThan(String value) {
            addCriterion("remote_addr <", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLessThanOrEqualTo(String value) {
            addCriterion("remote_addr <=", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLike(String value) {
            addCriterion("remote_addr like", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotLike(String value) {
            addCriterion("remote_addr not like", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_addr in", values, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotIn(java.util.List<java.lang.String> values) {
            addCriterion("remote_addr not in", values, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrBetween(String value1, String value2) {
            addCriterion("remote_addr between", value1, value2, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotBetween(String value1, String value2) {
            addCriterion("remote_addr not between", value1, value2, "remoteAddr");
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

        public Criteria andLocalTimeIsNull() {
            addCriterion("local_time is null");
            return (Criteria) this;
        }

        public Criteria andLocalTimeIsNotNull() {
            addCriterion("local_time is not null");
            return (Criteria) this;
        }

        public Criteria andLocalTimeEqualTo(Date value) {
            addCriterion("local_time =", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeNotEqualTo(Date value) {
            addCriterion("local_time <>", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeGreaterThan(Date value) {
            addCriterion("local_time >", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("local_time >=", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeLessThan(Date value) {
            addCriterion("local_time <", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeLessThanOrEqualTo(Date value) {
            addCriterion("local_time <=", value, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("local_time in", values, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("local_time not in", values, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeBetween(Date value1, Date value2) {
            addCriterion("local_time between", value1, value2, "localTime");
            return (Criteria) this;
        }

        public Criteria andLocalTimeNotBetween(Date value1, Date value2) {
            addCriterion("local_time not between", value1, value2, "localTime");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenIsNull() {
            addCriterion("request_agreen is null");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenIsNotNull() {
            addCriterion("request_agreen is not null");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenEqualTo(String value) {
            addCriterion("request_agreen =", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenNotEqualTo(String value) {
            addCriterion("request_agreen <>", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenGreaterThan(String value) {
            addCriterion("request_agreen >", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenGreaterThanOrEqualTo(String value) {
            addCriterion("request_agreen >=", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenLessThan(String value) {
            addCriterion("request_agreen <", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenLessThanOrEqualTo(String value) {
            addCriterion("request_agreen <=", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenLike(String value) {
            addCriterion("request_agreen like", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenNotLike(String value) {
            addCriterion("request_agreen not like", value, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenIn(java.util.List<java.lang.String> values) {
            addCriterion("request_agreen in", values, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenNotIn(java.util.List<java.lang.String> values) {
            addCriterion("request_agreen not in", values, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenBetween(String value1, String value2) {
            addCriterion("request_agreen between", value1, value2, "requestAgreen");
            return (Criteria) this;
        }

        public Criteria andRequestAgreenNotBetween(String value1, String value2) {
            addCriterion("request_agreen not between", value1, value2, "requestAgreen");
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

        public Criteria andUpstreamStatusIsNull() {
            addCriterion("upstream_status is null");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusIsNotNull() {
            addCriterion("upstream_status is not null");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusEqualTo(String value) {
            addCriterion("upstream_status =", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusNotEqualTo(String value) {
            addCriterion("upstream_status <>", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusGreaterThan(String value) {
            addCriterion("upstream_status >", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusGreaterThanOrEqualTo(String value) {
            addCriterion("upstream_status >=", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusLessThan(String value) {
            addCriterion("upstream_status <", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusLessThanOrEqualTo(String value) {
            addCriterion("upstream_status <=", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusLike(String value) {
            addCriterion("upstream_status like", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusNotLike(String value) {
            addCriterion("upstream_status not like", value, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusIn(java.util.List<java.lang.String> values) {
            addCriterion("upstream_status in", values, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusNotIn(java.util.List<java.lang.String> values) {
            addCriterion("upstream_status not in", values, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusBetween(String value1, String value2) {
            addCriterion("upstream_status between", value1, value2, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andUpstreamStatusNotBetween(String value1, String value2) {
            addCriterion("upstream_status not between", value1, value2, "upstreamStatus");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentIsNull() {
            addCriterion("body_bytes_sent is null");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentIsNotNull() {
            addCriterion("body_bytes_sent is not null");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentEqualTo(String value) {
            addCriterion("body_bytes_sent =", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentNotEqualTo(String value) {
            addCriterion("body_bytes_sent <>", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentGreaterThan(String value) {
            addCriterion("body_bytes_sent >", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentGreaterThanOrEqualTo(String value) {
            addCriterion("body_bytes_sent >=", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentLessThan(String value) {
            addCriterion("body_bytes_sent <", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentLessThanOrEqualTo(String value) {
            addCriterion("body_bytes_sent <=", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentLike(String value) {
            addCriterion("body_bytes_sent like", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentNotLike(String value) {
            addCriterion("body_bytes_sent not like", value, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentIn(java.util.List<java.lang.String> values) {
            addCriterion("body_bytes_sent in", values, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("body_bytes_sent not in", values, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentBetween(String value1, String value2) {
            addCriterion("body_bytes_sent between", value1, value2, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andBodyBytesSentNotBetween(String value1, String value2) {
            addCriterion("body_bytes_sent not between", value1, value2, "bodyBytesSent");
            return (Criteria) this;
        }

        public Criteria andHttpRefererIsNull() {
            addCriterion("http_referer is null");
            return (Criteria) this;
        }

        public Criteria andHttpRefererIsNotNull() {
            addCriterion("http_referer is not null");
            return (Criteria) this;
        }

        public Criteria andHttpRefererEqualTo(String value) {
            addCriterion("http_referer =", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererNotEqualTo(String value) {
            addCriterion("http_referer <>", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererGreaterThan(String value) {
            addCriterion("http_referer >", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererGreaterThanOrEqualTo(String value) {
            addCriterion("http_referer >=", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererLessThan(String value) {
            addCriterion("http_referer <", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererLessThanOrEqualTo(String value) {
            addCriterion("http_referer <=", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererLike(String value) {
            addCriterion("http_referer like", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererNotLike(String value) {
            addCriterion("http_referer not like", value, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererIn(java.util.List<java.lang.String> values) {
            addCriterion("http_referer in", values, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererNotIn(java.util.List<java.lang.String> values) {
            addCriterion("http_referer not in", values, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererBetween(String value1, String value2) {
            addCriterion("http_referer between", value1, value2, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpRefererNotBetween(String value1, String value2) {
            addCriterion("http_referer not between", value1, value2, "httpReferer");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentIsNull() {
            addCriterion("http_user_agent is null");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentIsNotNull() {
            addCriterion("http_user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentEqualTo(String value) {
            addCriterion("http_user_agent =", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentNotEqualTo(String value) {
            addCriterion("http_user_agent <>", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentGreaterThan(String value) {
            addCriterion("http_user_agent >", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("http_user_agent >=", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentLessThan(String value) {
            addCriterion("http_user_agent <", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentLessThanOrEqualTo(String value) {
            addCriterion("http_user_agent <=", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentLike(String value) {
            addCriterion("http_user_agent like", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentNotLike(String value) {
            addCriterion("http_user_agent not like", value, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentIn(java.util.List<java.lang.String> values) {
            addCriterion("http_user_agent in", values, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentNotIn(java.util.List<java.lang.String> values) {
            addCriterion("http_user_agent not in", values, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentBetween(String value1, String value2) {
            addCriterion("http_user_agent between", value1, value2, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andHttpUserAgentNotBetween(String value1, String value2) {
            addCriterion("http_user_agent not between", value1, value2, "httpUserAgent");
            return (Criteria) this;
        }

        public Criteria andSslProtocolIsNull() {
            addCriterion("ssl_protocol is null");
            return (Criteria) this;
        }

        public Criteria andSslProtocolIsNotNull() {
            addCriterion("ssl_protocol is not null");
            return (Criteria) this;
        }

        public Criteria andSslProtocolEqualTo(String value) {
            addCriterion("ssl_protocol =", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolNotEqualTo(String value) {
            addCriterion("ssl_protocol <>", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolGreaterThan(String value) {
            addCriterion("ssl_protocol >", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("ssl_protocol >=", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolLessThan(String value) {
            addCriterion("ssl_protocol <", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolLessThanOrEqualTo(String value) {
            addCriterion("ssl_protocol <=", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolLike(String value) {
            addCriterion("ssl_protocol like", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolNotLike(String value) {
            addCriterion("ssl_protocol not like", value, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolIn(java.util.List<java.lang.String> values) {
            addCriterion("ssl_protocol in", values, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ssl_protocol not in", values, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolBetween(String value1, String value2) {
            addCriterion("ssl_protocol between", value1, value2, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslProtocolNotBetween(String value1, String value2) {
            addCriterion("ssl_protocol not between", value1, value2, "sslProtocol");
            return (Criteria) this;
        }

        public Criteria andSslCipherIsNull() {
            addCriterion("ssl_cipher is null");
            return (Criteria) this;
        }

        public Criteria andSslCipherIsNotNull() {
            addCriterion("ssl_cipher is not null");
            return (Criteria) this;
        }

        public Criteria andSslCipherEqualTo(String value) {
            addCriterion("ssl_cipher =", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherNotEqualTo(String value) {
            addCriterion("ssl_cipher <>", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherGreaterThan(String value) {
            addCriterion("ssl_cipher >", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherGreaterThanOrEqualTo(String value) {
            addCriterion("ssl_cipher >=", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherLessThan(String value) {
            addCriterion("ssl_cipher <", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherLessThanOrEqualTo(String value) {
            addCriterion("ssl_cipher <=", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherLike(String value) {
            addCriterion("ssl_cipher like", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherNotLike(String value) {
            addCriterion("ssl_cipher not like", value, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherIn(java.util.List<java.lang.String> values) {
            addCriterion("ssl_cipher in", values, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ssl_cipher not in", values, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherBetween(String value1, String value2) {
            addCriterion("ssl_cipher between", value1, value2, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andSslCipherNotBetween(String value1, String value2) {
            addCriterion("ssl_cipher not between", value1, value2, "sslCipher");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrIsNull() {
            addCriterion("upstream_addr is null");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrIsNotNull() {
            addCriterion("upstream_addr is not null");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrEqualTo(String value) {
            addCriterion("upstream_addr =", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrNotEqualTo(String value) {
            addCriterion("upstream_addr <>", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrGreaterThan(String value) {
            addCriterion("upstream_addr >", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrGreaterThanOrEqualTo(String value) {
            addCriterion("upstream_addr >=", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrLessThan(String value) {
            addCriterion("upstream_addr <", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrLessThanOrEqualTo(String value) {
            addCriterion("upstream_addr <=", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrLike(String value) {
            addCriterion("upstream_addr like", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrNotLike(String value) {
            addCriterion("upstream_addr not like", value, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrIn(java.util.List<java.lang.String> values) {
            addCriterion("upstream_addr in", values, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrNotIn(java.util.List<java.lang.String> values) {
            addCriterion("upstream_addr not in", values, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrBetween(String value1, String value2) {
            addCriterion("upstream_addr between", value1, value2, "upstreamAddr");
            return (Criteria) this;
        }

        public Criteria andUpstreamAddrNotBetween(String value1, String value2) {
            addCriterion("upstream_addr not between", value1, value2, "upstreamAddr");
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

        public Criteria andUpstreamResponseTimeIsNull() {
            addCriterion("upstream_response_time is null");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeIsNotNull() {
            addCriterion("upstream_response_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeEqualTo(Date value) {
            addCriterion("upstream_response_time =", value, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeNotEqualTo(Date value) {
            addCriterion("upstream_response_time <>", value, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeGreaterThan(Date value) {
            addCriterion("upstream_response_time >", value, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upstream_response_time >=", value, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeLessThan(Date value) {
            addCriterion("upstream_response_time <", value, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("upstream_response_time <=", value, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("upstream_response_time in", values, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("upstream_response_time not in", values, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeBetween(Date value1, Date value2) {
            addCriterion("upstream_response_time between", value1, value2, "upstreamResponseTime");
            return (Criteria) this;
        }

        public Criteria andUpstreamResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("upstream_response_time not between", value1, value2, "upstreamResponseTime");
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

        public Criteria andBytesSentEqualTo(Long value) {
            addCriterion("bytes_sent =", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotEqualTo(Long value) {
            addCriterion("bytes_sent <>", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentGreaterThan(Long value) {
            addCriterion("bytes_sent >", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentGreaterThanOrEqualTo(Long value) {
            addCriterion("bytes_sent >=", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentLessThan(Long value) {
            addCriterion("bytes_sent <", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentLessThanOrEqualTo(Long value) {
            addCriterion("bytes_sent <=", value, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentIn(java.util.List<java.lang.Long> values) {
            addCriterion("bytes_sent in", values, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("bytes_sent not in", values, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentBetween(Long value1, Long value2) {
            addCriterion("bytes_sent between", value1, value2, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andBytesSentNotBetween(Long value1, Long value2) {
            addCriterion("bytes_sent not between", value1, value2, "bytesSent");
            return (Criteria) this;
        }

        public Criteria andConnectionIsNull() {
            addCriterion("connection is null");
            return (Criteria) this;
        }

        public Criteria andConnectionIsNotNull() {
            addCriterion("connection is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionEqualTo(Long value) {
            addCriterion("connection =", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotEqualTo(Long value) {
            addCriterion("connection <>", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionGreaterThan(Long value) {
            addCriterion("connection >", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionGreaterThanOrEqualTo(Long value) {
            addCriterion("connection >=", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLessThan(Long value) {
            addCriterion("connection <", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLessThanOrEqualTo(Long value) {
            addCriterion("connection <=", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionIn(java.util.List<java.lang.Long> values) {
            addCriterion("connection in", values, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("connection not in", values, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionBetween(Long value1, Long value2) {
            addCriterion("connection between", value1, value2, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotBetween(Long value1, Long value2) {
            addCriterion("connection not between", value1, value2, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsIsNull() {
            addCriterion("connection_requests is null");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsIsNotNull() {
            addCriterion("connection_requests is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsEqualTo(Long value) {
            addCriterion("connection_requests =", value, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsNotEqualTo(Long value) {
            addCriterion("connection_requests <>", value, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsGreaterThan(Long value) {
            addCriterion("connection_requests >", value, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsGreaterThanOrEqualTo(Long value) {
            addCriterion("connection_requests >=", value, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsLessThan(Long value) {
            addCriterion("connection_requests <", value, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsLessThanOrEqualTo(Long value) {
            addCriterion("connection_requests <=", value, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsIn(java.util.List<java.lang.Long> values) {
            addCriterion("connection_requests in", values, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("connection_requests not in", values, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsBetween(Long value1, Long value2) {
            addCriterion("connection_requests between", value1, value2, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andConnectionRequestsNotBetween(Long value1, Long value2) {
            addCriterion("connection_requests not between", value1, value2, "connectionRequests");
            return (Criteria) this;
        }

        public Criteria andMsecIsNull() {
            addCriterion("msec is null");
            return (Criteria) this;
        }

        public Criteria andMsecIsNotNull() {
            addCriterion("msec is not null");
            return (Criteria) this;
        }

        public Criteria andMsecEqualTo(String value) {
            addCriterion("msec =", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecNotEqualTo(String value) {
            addCriterion("msec <>", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecGreaterThan(String value) {
            addCriterion("msec >", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecGreaterThanOrEqualTo(String value) {
            addCriterion("msec >=", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecLessThan(String value) {
            addCriterion("msec <", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecLessThanOrEqualTo(String value) {
            addCriterion("msec <=", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecLike(String value) {
            addCriterion("msec like", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecNotLike(String value) {
            addCriterion("msec not like", value, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecIn(java.util.List<java.lang.String> values) {
            addCriterion("msec in", values, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecNotIn(java.util.List<java.lang.String> values) {
            addCriterion("msec not in", values, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecBetween(String value1, String value2) {
            addCriterion("msec between", value1, value2, "msec");
            return (Criteria) this;
        }

        public Criteria andMsecNotBetween(String value1, String value2) {
            addCriterion("msec not between", value1, value2, "msec");
            return (Criteria) this;
        }

        public Criteria andPipeIsNull() {
            addCriterion("pipe is null");
            return (Criteria) this;
        }

        public Criteria andPipeIsNotNull() {
            addCriterion("pipe is not null");
            return (Criteria) this;
        }

        public Criteria andPipeEqualTo(String value) {
            addCriterion("pipe =", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeNotEqualTo(String value) {
            addCriterion("pipe <>", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeGreaterThan(String value) {
            addCriterion("pipe >", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeGreaterThanOrEqualTo(String value) {
            addCriterion("pipe >=", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeLessThan(String value) {
            addCriterion("pipe <", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeLessThanOrEqualTo(String value) {
            addCriterion("pipe <=", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeLike(String value) {
            addCriterion("pipe like", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeNotLike(String value) {
            addCriterion("pipe not like", value, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeIn(java.util.List<java.lang.String> values) {
            addCriterion("pipe in", values, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("pipe not in", values, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeBetween(String value1, String value2) {
            addCriterion("pipe between", value1, value2, "pipe");
            return (Criteria) this;
        }

        public Criteria andPipeNotBetween(String value1, String value2) {
            addCriterion("pipe not between", value1, value2, "pipe");
            return (Criteria) this;
        }

        public Criteria andRequestLengthIsNull() {
            addCriterion("request_length is null");
            return (Criteria) this;
        }

        public Criteria andRequestLengthIsNotNull() {
            addCriterion("request_length is not null");
            return (Criteria) this;
        }

        public Criteria andRequestLengthEqualTo(Long value) {
            addCriterion("request_length =", value, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthNotEqualTo(Long value) {
            addCriterion("request_length <>", value, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthGreaterThan(Long value) {
            addCriterion("request_length >", value, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthGreaterThanOrEqualTo(Long value) {
            addCriterion("request_length >=", value, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthLessThan(Long value) {
            addCriterion("request_length <", value, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthLessThanOrEqualTo(Long value) {
            addCriterion("request_length <=", value, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthIn(java.util.List<java.lang.Long> values) {
            addCriterion("request_length in", values, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("request_length not in", values, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthBetween(Long value1, Long value2) {
            addCriterion("request_length between", value1, value2, "requestLength");
            return (Criteria) this;
        }

        public Criteria andRequestLengthNotBetween(Long value1, Long value2) {
            addCriterion("request_length not between", value1, value2, "requestLength");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601IsNull() {
            addCriterion("time_iso8601 is null");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601IsNotNull() {
            addCriterion("time_iso8601 is not null");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601EqualTo(Date value) {
            addCriterion("time_iso8601 =", value, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601NotEqualTo(Date value) {
            addCriterion("time_iso8601 <>", value, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601GreaterThan(Date value) {
            addCriterion("time_iso8601 >", value, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601GreaterThanOrEqualTo(Date value) {
            addCriterion("time_iso8601 >=", value, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601LessThan(Date value) {
            addCriterion("time_iso8601 <", value, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601LessThanOrEqualTo(Date value) {
            addCriterion("time_iso8601 <=", value, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601In(java.util.List<java.util.Date> values) {
            addCriterion("time_iso8601 in", values, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601NotIn(java.util.List<java.util.Date> values) {
            addCriterion("time_iso8601 not in", values, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601Between(Date value1, Date value2) {
            addCriterion("time_iso8601 between", value1, value2, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeIso8601NotBetween(Date value1, Date value2) {
            addCriterion("time_iso8601 not between", value1, value2, "timeIso8601");
            return (Criteria) this;
        }

        public Criteria andTimeLocalIsNull() {
            addCriterion("time_local is null");
            return (Criteria) this;
        }

        public Criteria andTimeLocalIsNotNull() {
            addCriterion("time_local is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLocalEqualTo(Date value) {
            addCriterion("time_local =", value, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalNotEqualTo(Date value) {
            addCriterion("time_local <>", value, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalGreaterThan(Date value) {
            addCriterion("time_local >", value, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalGreaterThanOrEqualTo(Date value) {
            addCriterion("time_local >=", value, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalLessThan(Date value) {
            addCriterion("time_local <", value, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalLessThanOrEqualTo(Date value) {
            addCriterion("time_local <=", value, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalIn(java.util.List<java.util.Date> values) {
            addCriterion("time_local in", values, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalNotIn(java.util.List<java.util.Date> values) {
            addCriterion("time_local not in", values, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalBetween(Date value1, Date value2) {
            addCriterion("time_local between", value1, value2, "timeLocal");
            return (Criteria) this;
        }

        public Criteria andTimeLocalNotBetween(Date value1, Date value2) {
            addCriterion("time_local not between", value1, value2, "timeLocal");
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
    log_struct_nginxaddClassComment 472
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