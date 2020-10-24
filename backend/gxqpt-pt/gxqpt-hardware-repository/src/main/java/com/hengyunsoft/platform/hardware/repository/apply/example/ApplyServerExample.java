package com.hengyunsoft.platform.hardware.repository.apply.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyServerExample extends com.hengyunsoft.db.example.BaseExample<ApplyServerExample.Criteria> implements Serializable {
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

        public Criteria andMemorySizeEqualTo(Long value) {
            addCriterion("memory_size =", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotEqualTo(Long value) {
            addCriterion("memory_size <>", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThan(Long value) {
            addCriterion("memory_size >", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeGreaterThanOrEqualTo(Long value) {
            addCriterion("memory_size >=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThan(Long value) {
            addCriterion("memory_size <", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeLessThanOrEqualTo(Long value) {
            addCriterion("memory_size <=", value, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeIn(java.util.List<java.lang.Long> values) {
            addCriterion("memory_size in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("memory_size not in", values, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeBetween(Long value1, Long value2) {
            addCriterion("memory_size between", value1, value2, "memorySize");
            return (Criteria) this;
        }

        public Criteria andMemorySizeNotBetween(Long value1, Long value2) {
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

        public Criteria andSysDisksizeIsNull() {
            addCriterion("sys_disksize is null");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeIsNotNull() {
            addCriterion("sys_disksize is not null");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeEqualTo(Integer value) {
            addCriterion("sys_disksize =", value, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeNotEqualTo(Integer value) {
            addCriterion("sys_disksize <>", value, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeGreaterThan(Integer value) {
            addCriterion("sys_disksize >", value, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_disksize >=", value, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeLessThan(Integer value) {
            addCriterion("sys_disksize <", value, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeLessThanOrEqualTo(Integer value) {
            addCriterion("sys_disksize <=", value, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sys_disksize in", values, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("sys_disksize not in", values, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeBetween(Integer value1, Integer value2) {
            addCriterion("sys_disksize between", value1, value2, "sysDisksize");
            return (Criteria) this;
        }

        public Criteria andSysDisksizeNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_disksize not between", value1, value2, "sysDisksize");
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

        public Criteria andGatewayDescIsNull() {
            addCriterion("gateway_desc is null");
            return (Criteria) this;
        }

        public Criteria andGatewayDescIsNotNull() {
            addCriterion("gateway_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayDescEqualTo(String value) {
            addCriterion("gateway_desc =", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescNotEqualTo(String value) {
            addCriterion("gateway_desc <>", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescGreaterThan(String value) {
            addCriterion("gateway_desc >", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescGreaterThanOrEqualTo(String value) {
            addCriterion("gateway_desc >=", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescLessThan(String value) {
            addCriterion("gateway_desc <", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescLessThanOrEqualTo(String value) {
            addCriterion("gateway_desc <=", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescLike(String value) {
            addCriterion("gateway_desc like", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescNotLike(String value) {
            addCriterion("gateway_desc not like", value, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescIn(java.util.List<java.lang.String> values) {
            addCriterion("gateway_desc in", values, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescNotIn(java.util.List<java.lang.String> values) {
            addCriterion("gateway_desc not in", values, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescBetween(String value1, String value2) {
            addCriterion("gateway_desc between", value1, value2, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andGatewayDescNotBetween(String value1, String value2) {
            addCriterion("gateway_desc not between", value1, value2, "gatewayDesc");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNull() {
            addCriterion("apply_count is null");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNotNull() {
            addCriterion("apply_count is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCountEqualTo(Integer value) {
            addCriterion("apply_count =", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotEqualTo(Integer value) {
            addCriterion("apply_count <>", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThan(Integer value) {
            addCriterion("apply_count >", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_count >=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThan(Integer value) {
            addCriterion("apply_count <", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("apply_count <=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountIn(java.util.List<java.lang.Integer> values) {
            addCriterion("apply_count in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("apply_count not in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountBetween(Integer value1, Integer value2) {
            addCriterion("apply_count between", value1, value2, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_count not between", value1, value2, "applyCount");
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
    }

    /**
    b_hd_apply_serveraddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}