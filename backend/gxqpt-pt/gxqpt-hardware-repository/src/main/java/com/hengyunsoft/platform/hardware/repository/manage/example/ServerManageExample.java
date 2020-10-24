package com.hengyunsoft.platform.hardware.repository.manage.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerManageExample extends com.hengyunsoft.db.example.BaseExample<ServerManageExample.Criteria> implements Serializable {
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

        public Criteria andApplyKeyidIsNull() {
            addCriterion("apply_keyid is null");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidIsNotNull() {
            addCriterion("apply_keyid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidEqualTo(Long value) {
            addCriterion("apply_keyid =", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidNotEqualTo(Long value) {
            addCriterion("apply_keyid <>", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidGreaterThan(Long value) {
            addCriterion("apply_keyid >", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_keyid >=", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidLessThan(Long value) {
            addCriterion("apply_keyid <", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidLessThanOrEqualTo(Long value) {
            addCriterion("apply_keyid <=", value, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_keyid in", values, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("apply_keyid not in", values, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidBetween(Long value1, Long value2) {
            addCriterion("apply_keyid between", value1, value2, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andApplyKeyidNotBetween(Long value1, Long value2) {
            addCriterion("apply_keyid not between", value1, value2, "applyKeyid");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(String value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(String value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(String value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(String value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(String value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLike(String value) {
            addCriterion("server_id like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotLike(String value) {
            addCriterion("server_id not like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(java.util.List<java.lang.String> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(java.util.List<java.lang.String> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(String value1, String value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(String value1, String value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
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

        public Criteria andOrgidIsNull() {
            addCriterion("orgid is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgid is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(String value) {
            addCriterion("orgid =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(String value) {
            addCriterion("orgid <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(String value) {
            addCriterion("orgid >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(String value) {
            addCriterion("orgid >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(String value) {
            addCriterion("orgid <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(String value) {
            addCriterion("orgid <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLike(String value) {
            addCriterion("orgid like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotLike(String value) {
            addCriterion("orgid not like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(java.util.List<java.lang.String> values) {
            addCriterion("orgid in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("orgid not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(String value1, String value2) {
            addCriterion("orgid between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(String value1, String value2) {
            addCriterion("orgid not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("orgname is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgname is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgname =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgname <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgname >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgname >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgname <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgname <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgname like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgname not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(java.util.List<java.lang.String> values) {
            addCriterion("orgname in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("orgname not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgname between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgname not between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andManageUidIsNull() {
            addCriterion("manage_uid is null");
            return (Criteria) this;
        }

        public Criteria andManageUidIsNotNull() {
            addCriterion("manage_uid is not null");
            return (Criteria) this;
        }

        public Criteria andManageUidEqualTo(String value) {
            addCriterion("manage_uid =", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidNotEqualTo(String value) {
            addCriterion("manage_uid <>", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidGreaterThan(String value) {
            addCriterion("manage_uid >", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidGreaterThanOrEqualTo(String value) {
            addCriterion("manage_uid >=", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidLessThan(String value) {
            addCriterion("manage_uid <", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidLessThanOrEqualTo(String value) {
            addCriterion("manage_uid <=", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidLike(String value) {
            addCriterion("manage_uid like", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidNotLike(String value) {
            addCriterion("manage_uid not like", value, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidIn(java.util.List<java.lang.String> values) {
            addCriterion("manage_uid in", values, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidNotIn(java.util.List<java.lang.String> values) {
            addCriterion("manage_uid not in", values, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidBetween(String value1, String value2) {
            addCriterion("manage_uid between", value1, value2, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUidNotBetween(String value1, String value2) {
            addCriterion("manage_uid not between", value1, value2, "manageUid");
            return (Criteria) this;
        }

        public Criteria andManageUnameIsNull() {
            addCriterion("manage_uname is null");
            return (Criteria) this;
        }

        public Criteria andManageUnameIsNotNull() {
            addCriterion("manage_uname is not null");
            return (Criteria) this;
        }

        public Criteria andManageUnameEqualTo(String value) {
            addCriterion("manage_uname =", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameNotEqualTo(String value) {
            addCriterion("manage_uname <>", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameGreaterThan(String value) {
            addCriterion("manage_uname >", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameGreaterThanOrEqualTo(String value) {
            addCriterion("manage_uname >=", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameLessThan(String value) {
            addCriterion("manage_uname <", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameLessThanOrEqualTo(String value) {
            addCriterion("manage_uname <=", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameLike(String value) {
            addCriterion("manage_uname like", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameNotLike(String value) {
            addCriterion("manage_uname not like", value, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameIn(java.util.List<java.lang.String> values) {
            addCriterion("manage_uname in", values, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("manage_uname not in", values, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameBetween(String value1, String value2) {
            addCriterion("manage_uname between", value1, value2, "manageUname");
            return (Criteria) this;
        }

        public Criteria andManageUnameNotBetween(String value1, String value2) {
            addCriterion("manage_uname not between", value1, value2, "manageUname");
            return (Criteria) this;
        }

        public Criteria andCpuCountIsNull() {
            addCriterion("cpu_count is null");
            return (Criteria) this;
        }

        public Criteria andCpuCountIsNotNull() {
            addCriterion("cpu_count is not null");
            return (Criteria) this;
        }

        public Criteria andCpuCountEqualTo(Integer value) {
            addCriterion("cpu_count =", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotEqualTo(Integer value) {
            addCriterion("cpu_count <>", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountGreaterThan(Integer value) {
            addCriterion("cpu_count >", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpu_count >=", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountLessThan(Integer value) {
            addCriterion("cpu_count <", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountLessThanOrEqualTo(Integer value) {
            addCriterion("cpu_count <=", value, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cpu_count in", values, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("cpu_count not in", values, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountBetween(Integer value1, Integer value2) {
            addCriterion("cpu_count between", value1, value2, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andCpuCountNotBetween(Integer value1, Integer value2) {
            addCriterion("cpu_count not between", value1, value2, "cpuCount");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIsNull() {
            addCriterion("memory_size is null");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIsNotNull() {
            addCriterion("memory_size is not null");
            return (Criteria) this;
        }

        public Criteria andMemorySizeEqualTo(Integer value) {
            addCriterion("memory_size =", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotEqualTo(Integer value) {
            addCriterion("memory_size <>", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThan(Integer value) {
            addCriterion("memory_size >", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("memory_size >=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThan(Integer value) {
            addCriterion("memory_size <", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThanOrEqualTo(Integer value) {
            addCriterion("memory_size <=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("memory_size in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("memory_size not in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeBetween(Integer value1, Integer value2) {
            addCriterion("memory_size between", value1, value2, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotBetween(Integer value1, Integer value2) {
            addCriterion("memory_size not between", value1, value2, "memorySize");
            return (Criteria) this;
        }

        public Criteria andSystemIsNull() {
            addCriterion("system is null");
            return (Criteria) this;
        }

        public Criteria andSystemIsNotNull() {
            addCriterion("system is not null");
            return (Criteria) this;
        }

        public Criteria andSystemEqualTo(String value) {
            addCriterion("system =", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotEqualTo(String value) {
            addCriterion("system <>", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThan(String value) {
            addCriterion("system >", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThanOrEqualTo(String value) {
            addCriterion("system >=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThan(String value) {
            addCriterion("system <", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThanOrEqualTo(String value) {
            addCriterion("system <=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLike(String value) {
            addCriterion("system like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotLike(String value) {
            addCriterion("system not like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemIn(java.util.List<java.lang.String> values) {
            addCriterion("system in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotIn(java.util.List<java.lang.String> values) {
            addCriterion("system not in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemBetween(String value1, String value2) {
            addCriterion("system between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotBetween(String value1, String value2) {
            addCriterion("system not between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andNetScopeIsNull() {
            addCriterion("net_scope is null");
            return (Criteria) this;
        }

        public Criteria andNetScopeIsNotNull() {
            addCriterion("net_scope is not null");
            return (Criteria) this;
        }

        public Criteria andNetScopeEqualTo(String value) {
            addCriterion("net_scope =", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeNotEqualTo(String value) {
            addCriterion("net_scope <>", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeGreaterThan(String value) {
            addCriterion("net_scope >", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeGreaterThanOrEqualTo(String value) {
            addCriterion("net_scope >=", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeLessThan(String value) {
            addCriterion("net_scope <", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeLessThanOrEqualTo(String value) {
            addCriterion("net_scope <=", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeLike(String value) {
            addCriterion("net_scope like", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeNotLike(String value) {
            addCriterion("net_scope not like", value, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeIn(java.util.List<java.lang.String> values) {
            addCriterion("net_scope in", values, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("net_scope not in", values, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeBetween(String value1, String value2) {
            addCriterion("net_scope between", value1, value2, "netScope");
            return (Criteria) this;
        }

        public Criteria andNetScopeNotBetween(String value1, String value2) {
            addCriterion("net_scope not between", value1, value2, "netScope");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andNetWideIsNull() {
            addCriterion("net_wide is null");
            return (Criteria) this;
        }

        public Criteria andNetWideIsNotNull() {
            addCriterion("net_wide is not null");
            return (Criteria) this;
        }

        public Criteria andNetWideEqualTo(Integer value) {
            addCriterion("net_wide =", value, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideNotEqualTo(Integer value) {
            addCriterion("net_wide <>", value, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideGreaterThan(Integer value) {
            addCriterion("net_wide >", value, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_wide >=", value, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideLessThan(Integer value) {
            addCriterion("net_wide <", value, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideLessThanOrEqualTo(Integer value) {
            addCriterion("net_wide <=", value, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideIn(java.util.List<java.lang.Integer> values) {
            addCriterion("net_wide in", values, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("net_wide not in", values, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideBetween(Integer value1, Integer value2) {
            addCriterion("net_wide between", value1, value2, "netWide");
            return (Criteria) this;
        }

        public Criteria andNetWideNotBetween(Integer value1, Integer value2) {
            addCriterion("net_wide not between", value1, value2, "netWide");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(java.util.List<java.lang.Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andOriginIdIsNull() {
            addCriterion("origin_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginIdIsNotNull() {
            addCriterion("origin_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginIdEqualTo(Long value) {
            addCriterion("origin_id =", value, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdNotEqualTo(Long value) {
            addCriterion("origin_id <>", value, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdGreaterThan(Long value) {
            addCriterion("origin_id >", value, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdGreaterThanOrEqualTo(Long value) {
            addCriterion("origin_id >=", value, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdLessThan(Long value) {
            addCriterion("origin_id <", value, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdLessThanOrEqualTo(Long value) {
            addCriterion("origin_id <=", value, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("origin_id in", values, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("origin_id not in", values, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdBetween(Long value1, Long value2) {
            addCriterion("origin_id between", value1, value2, "originId");
            return (Criteria) this;
        }

        public Criteria andOriginIdNotBetween(Long value1, Long value2) {
            addCriterion("origin_id not between", value1, value2, "originId");
            return (Criteria) this;
        }

        public Criteria andChangeCountIsNull() {
            addCriterion("change_count is null");
            return (Criteria) this;
        }

        public Criteria andChangeCountIsNotNull() {
            addCriterion("change_count is not null");
            return (Criteria) this;
        }

        public Criteria andChangeCountEqualTo(Integer value) {
            addCriterion("change_count =", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountNotEqualTo(Integer value) {
            addCriterion("change_count <>", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountGreaterThan(Integer value) {
            addCriterion("change_count >", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_count >=", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountLessThan(Integer value) {
            addCriterion("change_count <", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountLessThanOrEqualTo(Integer value) {
            addCriterion("change_count <=", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("change_count in", values, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("change_count not in", values, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountBetween(Integer value1, Integer value2) {
            addCriterion("change_count between", value1, value2, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("change_count not between", value1, value2, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeFlagIsNull() {
            addCriterion("change_flag is null");
            return (Criteria) this;
        }

        public Criteria andChangeFlagIsNotNull() {
            addCriterion("change_flag is not null");
            return (Criteria) this;
        }

        public Criteria andChangeFlagEqualTo(Boolean value) {
            addCriterion("change_flag =", value, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagNotEqualTo(Boolean value) {
            addCriterion("change_flag <>", value, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagGreaterThan(Boolean value) {
            addCriterion("change_flag >", value, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("change_flag >=", value, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagLessThan(Boolean value) {
            addCriterion("change_flag <", value, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("change_flag <=", value, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("change_flag in", values, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("change_flag not in", values, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("change_flag between", value1, value2, "changeFlag");
            return (Criteria) this;
        }

        public Criteria andChangeFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("change_flag not between", value1, value2, "changeFlag");
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

        public Criteria andUseStatusIsNull() {
            addCriterion("use_status is null");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNotNull() {
            addCriterion("use_status is not null");
            return (Criteria) this;
        }

        public Criteria andUseStatusEqualTo(Integer value) {
            addCriterion("use_status =", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotEqualTo(Integer value) {
            addCriterion("use_status <>", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThan(Integer value) {
            addCriterion("use_status >", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_status >=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThan(Integer value) {
            addCriterion("use_status <", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("use_status <=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusIn(java.util.List<java.lang.Integer> values) {
            addCriterion("use_status in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("use_status not in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusBetween(Integer value1, Integer value2) {
            addCriterion("use_status between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("use_status not between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andCpuPercentIsNull() {
            addCriterion("cpu_percent is null");
            return (Criteria) this;
        }

        public Criteria andCpuPercentIsNotNull() {
            addCriterion("cpu_percent is not null");
            return (Criteria) this;
        }

        public Criteria andCpuPercentEqualTo(Byte value) {
            addCriterion("cpu_percent =", value, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentNotEqualTo(Byte value) {
            addCriterion("cpu_percent <>", value, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentGreaterThan(Byte value) {
            addCriterion("cpu_percent >", value, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("cpu_percent >=", value, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentLessThan(Byte value) {
            addCriterion("cpu_percent <", value, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentLessThanOrEqualTo(Byte value) {
            addCriterion("cpu_percent <=", value, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentIn(java.util.List<java.lang.Byte> values) {
            addCriterion("cpu_percent in", values, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentNotIn(java.util.List<java.lang.Byte> values) {
            addCriterion("cpu_percent not in", values, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentBetween(Byte value1, Byte value2) {
            addCriterion("cpu_percent between", value1, value2, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andCpuPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("cpu_percent not between", value1, value2, "cpuPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentIsNull() {
            addCriterion("memory_percent is null");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentIsNotNull() {
            addCriterion("memory_percent is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentEqualTo(Byte value) {
            addCriterion("memory_percent =", value, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentNotEqualTo(Byte value) {
            addCriterion("memory_percent <>", value, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentGreaterThan(Byte value) {
            addCriterion("memory_percent >", value, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("memory_percent >=", value, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentLessThan(Byte value) {
            addCriterion("memory_percent <", value, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentLessThanOrEqualTo(Byte value) {
            addCriterion("memory_percent <=", value, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentIn(java.util.List<java.lang.Byte> values) {
            addCriterion("memory_percent in", values, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentNotIn(java.util.List<java.lang.Byte> values) {
            addCriterion("memory_percent not in", values, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentBetween(Byte value1, Byte value2) {
            addCriterion("memory_percent between", value1, value2, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andMemoryPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("memory_percent not between", value1, value2, "memoryPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentIsNull() {
            addCriterion("disk_percent is null");
            return (Criteria) this;
        }

        public Criteria andDiskPercentIsNotNull() {
            addCriterion("disk_percent is not null");
            return (Criteria) this;
        }

        public Criteria andDiskPercentEqualTo(Byte value) {
            addCriterion("disk_percent =", value, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentNotEqualTo(Byte value) {
            addCriterion("disk_percent <>", value, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentGreaterThan(Byte value) {
            addCriterion("disk_percent >", value, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("disk_percent >=", value, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentLessThan(Byte value) {
            addCriterion("disk_percent <", value, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentLessThanOrEqualTo(Byte value) {
            addCriterion("disk_percent <=", value, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentIn(java.util.List<java.lang.Byte> values) {
            addCriterion("disk_percent in", values, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentNotIn(java.util.List<java.lang.Byte> values) {
            addCriterion("disk_percent not in", values, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentBetween(Byte value1, Byte value2) {
            addCriterion("disk_percent between", value1, value2, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andDiskPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("disk_percent not between", value1, value2, "diskPercent");
            return (Criteria) this;
        }

        public Criteria andWideUpIsNull() {
            addCriterion("wide_up is null");
            return (Criteria) this;
        }

        public Criteria andWideUpIsNotNull() {
            addCriterion("wide_up is not null");
            return (Criteria) this;
        }

        public Criteria andWideUpEqualTo(Double value) {
            addCriterion("wide_up =", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpNotEqualTo(Double value) {
            addCriterion("wide_up <>", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpGreaterThan(Double value) {
            addCriterion("wide_up >", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpGreaterThanOrEqualTo(Double value) {
            addCriterion("wide_up >=", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpLessThan(Double value) {
            addCriterion("wide_up <", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpLessThanOrEqualTo(Double value) {
            addCriterion("wide_up <=", value, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_up in", values, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_up not in", values, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpBetween(Double value1, Double value2) {
            addCriterion("wide_up between", value1, value2, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideUpNotBetween(Double value1, Double value2) {
            addCriterion("wide_up not between", value1, value2, "wideUp");
            return (Criteria) this;
        }

        public Criteria andWideDownIsNull() {
            addCriterion("wide_down is null");
            return (Criteria) this;
        }

        public Criteria andWideDownIsNotNull() {
            addCriterion("wide_down is not null");
            return (Criteria) this;
        }

        public Criteria andWideDownEqualTo(Double value) {
            addCriterion("wide_down =", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownNotEqualTo(Double value) {
            addCriterion("wide_down <>", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownGreaterThan(Double value) {
            addCriterion("wide_down >", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownGreaterThanOrEqualTo(Double value) {
            addCriterion("wide_down >=", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownLessThan(Double value) {
            addCriterion("wide_down <", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownLessThanOrEqualTo(Double value) {
            addCriterion("wide_down <=", value, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_down in", values, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownNotIn(java.util.List<java.lang.Double> values) {
            addCriterion("wide_down not in", values, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownBetween(Double value1, Double value2) {
            addCriterion("wide_down between", value1, value2, "wideDown");
            return (Criteria) this;
        }

        public Criteria andWideDownNotBetween(Double value1, Double value2) {
            addCriterion("wide_down not between", value1, value2, "wideDown");
            return (Criteria) this;
        }

        public Criteria andRevertTimeIsNull() {
            addCriterion("revert_time is null");
            return (Criteria) this;
        }

        public Criteria andRevertTimeIsNotNull() {
            addCriterion("revert_time is not null");
            return (Criteria) this;
        }

        public Criteria andRevertTimeEqualTo(Date value) {
            addCriterion("revert_time =", value, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeNotEqualTo(Date value) {
            addCriterion("revert_time <>", value, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeGreaterThan(Date value) {
            addCriterion("revert_time >", value, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("revert_time >=", value, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeLessThan(Date value) {
            addCriterion("revert_time <", value, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeLessThanOrEqualTo(Date value) {
            addCriterion("revert_time <=", value, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("revert_time in", values, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("revert_time not in", values, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeBetween(Date value1, Date value2) {
            addCriterion("revert_time between", value1, value2, "revertTime");
            return (Criteria) this;
        }

        public Criteria andRevertTimeNotBetween(Date value1, Date value2) {
            addCriterion("revert_time not between", value1, value2, "revertTime");
            return (Criteria) this;
        }
    }

    /**
    b_hd_server_manageaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}